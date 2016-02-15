package edu.mum.finco;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class FinCo implements ISubject<FinCo>, IFinCo {
	
	protected static String amountColumnHeaderText = "Amount";

	public FinCo() {
	}

	protected DefaultTableModel mainFormTableModel;
	List<IObserver<FinCo>> observers = new ArrayList<IObserver<FinCo>>();

	public DefaultTableModel getMainFormTableModel() {
		return mainFormTableModel;
	}

	public void setMainFormTableModel(DefaultTableModel mainFormTableModel) {
		this.mainFormTableModel = mainFormTableModel;
	}

	public static void main(String[] args) throws Exception {		
		FinCo finco = new FinCo();
		String[] columns = new String[] { "Account No", "Name", "City", "P/C", amountColumnHeaderText };
		
		finco.initialize(columns, "mainFrame");
		
	}

	@SuppressWarnings("unchecked")
	public void initialize(String[] columns, String mainFrameTypeBeanId) throws Exception {
		boolean amountColFound = false;
		mainFormTableModel = new DefaultTableModel();
		for (String column : columns) {
			mainFormTableModel.addColumn(column);
			if(column.equals(amountColumnHeaderText))
				amountColFound = true;
		}
		
		if(!amountColFound)
			throw new Exception("There has to be an amount column!");
		
		this.setMainFormTableModel(mainFormTableModel);

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		}

		JFrame mainFrame = Injector.createObject(mainFrameTypeBeanId, this);
		attach((IObserver<FinCo>) mainFrame);

		mainFrame.setVisible(true);
	}

	public void addRow(IAccount account) {
		ICustomer customer = account.getCustomer();
		IAddress address = customer.getAddress();
		Object rowdata[] = new Object[mainFormTableModel.getColumnCount()];
		rowdata[0] = account;
		rowdata[1] = customer.getName();
		rowdata[2] = address.getCity();
		rowdata[3] = customer.getType();
		// rowdata[4] = accountType;
		rowdata[4] = account.getBalance();
		mainFormTableModel.addRow(rowdata);
	}

	private void updateRowAmount(IAccount account, double amount, int rowIndex) {
		int ammountColIndex = mainFormTableModel.findColumn(amountColumnHeaderText);
		double newamount = (double) mainFormTableModel.getValueAt(rowIndex, ammountColIndex) + amount;
		mainFormTableModel.setValueAt(newamount, rowIndex, ammountColIndex);
		if (amount < 0 && newamount < 0) {
			JOptionPane
					.showMessageDialog(null,
							" Account " + account.getAccNumber() + " : balance is negative: $"
									+ String.valueOf(newamount) + " !",
							"Warning: negative balance", JOptionPane.WARNING_MESSAGE);
		}
	}

	private void refreshRows() {
		if (mainFormTableModel.getRowCount() > 0) {
			for (int i = mainFormTableModel.getRowCount() - 1; i > -1; i--) {
				mainFormTableModel.removeRow(i);
			}
		}

		List<IAccount> accounts = DbHelper.getAllAccounts();

		for (IAccount account : accounts)
			addRow(account);
	}

	public Long generateAccountNumber() {
		return DbHelper.getMaxAccountNumber() + 1;
	}

	@Override
	public void addCustomer(ICustomer customer) {
		DbHelper.addCustomer(customer);
		IAccount account = customer.getAccountList().get(0);
		DbHelper.addAccount(account);
		addRow(account);
		notifyObservers();
	}

	@Override
	public void deposit(IAccount account, double amount, int rowIndex) {
		account.deposit(amount);
		updateRowAmount(account, amount, rowIndex);
		notifyObservers();
	}

	@Override
	public void withdraw(IAccount account, double amount, int rowIndex) {
		account.withdraw(amount);
		updateRowAmount(account, amount * -1, rowIndex);
		notifyObservers();
	}

	@Override
	public void addInterest() {
		DbHelper.addInterest();
		refreshRows();
		notifyObservers();
	}

	@Override
	public void attach(IObserver<FinCo> observer) {
		observers.add(observer);
	}

	@Override
	public void notifyObservers() {
		for (IObserver<FinCo> observer : observers)
			observer.update(this);
	}
	
	@Override
	public String generateReport() {
		return null;
	}
}