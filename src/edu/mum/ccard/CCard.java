package edu.mum.ccard;

import java.time.LocalDate;
import java.util.List;

import edu.mum.finco.DbHelper;
import edu.mum.finco.FinCo;
import edu.mum.finco.IAccount;
import edu.mum.finco.ICustomer;

public class CCard extends FinCo {

	public static void main(String[] args) throws Exception {
		amountColumnHeaderText = "Balance";
		String[] columns = new String[] { "Name", "CC Number", "Exp date", "Type", amountColumnHeaderText };
		new CCard().initialize(columns, "cCardFrame");
	}
	
	@Override
	public void addRow(IAccount account) {
		ICustomer customer = account.getCustomer();
		Object rowdata[] = new Object[mainFormTableModel.getColumnCount()];
		rowdata[0] = customer.getName();
		rowdata[1] = account;
		rowdata[2] = ((ICCardAccount)account).getExpDate();
		rowdata[3] = account.getType();
		rowdata[4] = account.getBalance();
		mainFormTableModel.addRow(rowdata);
	}
	
	@Override
	public String generateReport() {
		List<IAccount> accounts = DbHelper.getAllAccounts();
		StringBuilder report = new StringBuilder();
		for(IAccount account : accounts) {
			double previousBalance = account.getEntries().stream().filter(e -> e.getDate().getMonthValue() == LocalDate.now().getMonthValue() - 1).mapToDouble(e -> e.getAmount()).sum();
			double totalCharges = account.getEntries().stream().filter(e -> e.getAmount() < 0 && e.getDate().getMonthValue() == LocalDate.now().getMonthValue()).mapToDouble(e -> e.getAmount()).sum();
			double totalCredits = account.getEntries().stream().filter(e -> e.getAmount() > 0 && e.getDate().getMonthValue() == LocalDate.now().getMonthValue()).mapToDouble(e -> e.getAmount()).sum();
			double newBalance = previousBalance - totalCredits + totalCharges + (account.getInterestRate() * (previousBalance - totalCredits));
			report.append("Previous balance. " + previousBalance + "\r\n");
			report.append("Total charges: " + totalCharges + "\r\n");
			report.append("Total credits: " + totalCredits + "\r\n");
			report.append("New balance: " + newBalance + "\r\n");
			report.append("-----------------------------------------------\r\n");
		}
		
		return report.toString();
	}
	
}
