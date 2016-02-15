package edu.mum.bank;

import java.util.List;

import edu.mum.finco.Account;
import edu.mum.finco.ICustomer;
import edu.mum.finco.IEntry;

public class Saving extends Account {
	public Saving(Long accNumber, List<IEntry> entries, boolean isActive, ICustomer customer) {
		super(accNumber, entries, isActive, customer);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getType() {
		return "S";
	}
	
	@Override
	public double getInterestRate() {
		return 0.07;
	}
}
