package edu.mum.bank;

import java.util.List;

import edu.mum.finco.Account;
import edu.mum.finco.ICustomer;
import edu.mum.finco.IEntry;

public class Checking extends Account{
	
	public Checking(Long accNumber, List<IEntry> entries, boolean isActive, ICustomer customer) {
		super(accNumber, entries, isActive, customer);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getType() {
		return "C";
	}
	
	@Override
	public double getInterestRate() {
		return 0.05;
	}
}
