package edu.mum.finco;

import java.time.LocalDate;

public class Entry implements IEntry {
	
	public Entry(double amount) {
		this.date = LocalDate.now();
		this.amount = amount;
	}

    private LocalDate date;
    private double amount;
    private IAccount account;

    @Override
	public LocalDate getDate() {
        return date;
    }

    @Override
	public double getAmount() {
        return amount;
    }
    
    @Override
    public void setAmount(double amount) {
    	this.amount = amount;
    }
    
    @Override
    public void setAccount(IAccount account) {
    	this.account = account;
    }

	@Override
	public IAccount getAccount() {
		return account;
	}

}