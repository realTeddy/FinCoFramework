package edu.mum.ccard;

import edu.mum.finco.IAccount;

public interface ICCardAccount extends IAccount {

	String getExpDate();
	void setExpDate(String expDate);
	
}
