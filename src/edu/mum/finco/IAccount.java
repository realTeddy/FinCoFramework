package edu.mum.finco;

import java.util.List;

public interface IAccount {

	Long getAccNumber();

	IEntry addEntry(double amount);
	
	List<IEntry> getEntries();

	void deposit(double amount);

	void withdraw(double amount);

	double getBalance();

	void generateReport();

	void setAccNumber(long accNumber);

	void setIsActive(boolean isActive);

	boolean getIsActive();

	void setCustomer(ICustomer customer);

	void addInterest();

	ICustomer getCustomer();
	
	String getType();

	double getInterestRate();

}