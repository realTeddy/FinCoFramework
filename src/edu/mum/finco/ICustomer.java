package edu.mum.finco;

import java.util.List;

public interface ICustomer {

	void addAccount(IAccount account);

	List<IAccount> getAccountList();

	String getName();

	String getEmail();

	IAddress getAddress();

	void setCustNumber(int custNumber);
	
	void setIsActive(boolean isActive);

	boolean getIsActive();

	void setAddress(IAddress address);

	void setName(String name);

	void setEmail(String email);

	void sendEmail(IEntry entry);

	int getCustNumber();
	
	String getType();

}