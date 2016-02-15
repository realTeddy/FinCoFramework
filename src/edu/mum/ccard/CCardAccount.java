package edu.mum.ccard;

import java.util.List;

import edu.mum.finco.Account;
import edu.mum.finco.ICustomer;
import edu.mum.finco.IEntry;

public class CCardAccount extends Account implements ICCardAccount {
	
	public CCardAccount(String expDate, Long accNumber, List<IEntry> entries, boolean isActive, ICustomer customer) {
		super(accNumber, entries, isActive, customer);
		this.expDate = expDate;
	}

	private String expDate;
	
	public String getExpDate(){
		return expDate;
	}
	
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	
}
