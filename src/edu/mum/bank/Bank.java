package edu.mum.bank;

import java.util.List;

import edu.mum.finco.DbHelper;
import edu.mum.finco.FinCo;
import edu.mum.finco.IAccount;
import edu.mum.finco.IAddress;
import edu.mum.finco.ICustomer;

public class Bank extends FinCo {
	
	public static void main(String[] args) throws Exception {
		String[] columns = new String[] { "Account No", "Street", "City", "State", "Zip", "P/C", "Ch/S", amountColumnHeaderText };
		new Bank().initialize(columns, "bankFrame");
	}
	
	@Override
	public void addRow(IAccount account) {
		ICustomer customer = account.getCustomer();
		IAddress address = customer.getAddress();
		Object rowdata[] = new Object[mainFormTableModel.getColumnCount()];
		rowdata[0] = account;
		rowdata[1] = address.getStreet();
		rowdata[2] = address.getCity();
		rowdata[3] = address.getState();
		rowdata[4] = address.getZip();
		rowdata[5] = customer.getType();
		rowdata[6] = account.getType();
		rowdata[7] = account.getBalance();
		mainFormTableModel.addRow(rowdata);
	}
	
	@Override
	public String generateReport() {
		List<IAccount> accounts = DbHelper.getAllAccounts();
		StringBuilder report = new StringBuilder();
		for(IAccount account : accounts) {
			report.append("Account No. " + account.getAccNumber() + "\r\n");
			report.append("Balance. " + account.getBalance() + "\r\n");
			report.append("-----------------------------------------------\r\n");
		}
		
		return report.toString();
	}
}
