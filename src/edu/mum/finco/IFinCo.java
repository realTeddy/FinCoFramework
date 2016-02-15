package edu.mum.finco;

import javax.swing.table.TableModel;

public interface IFinCo {

	void deposit(IAccount account, double amount, int rowIndex);

	void addInterest();

	void withdraw(IAccount account, double amount, int rowIndex);

	TableModel getMainFormTableModel();

	Long generateAccountNumber();
	
	String generateReport();

	void addCustomer(ICustomer customer);

}