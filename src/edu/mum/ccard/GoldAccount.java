package edu.mum.ccard;

import java.util.List;

import edu.mum.finco.ICustomer;
import edu.mum.finco.IEntry;

public class GoldAccount extends CCardAccount {
	public GoldAccount(String expDate, Long accNumber, List<IEntry> entries, boolean isActive, ICustomer customer) {
		super(expDate, accNumber, entries, isActive, customer);
	}

	@Override
	public double getInterestRate() {
		return 0.06;
	}
	
	@Override
	public String getType() {
		return "Gold";
	}
}