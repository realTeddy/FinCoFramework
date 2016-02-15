package edu.mum.finco;

import java.util.ArrayList;
import java.util.List;

public class Account implements IAccount {

	public Account(Long accNumber, List<IEntry> entries, boolean isActive, ICustomer customer) {
		this.accNumber = accNumber;
		this.entries = entries != null ? entries : new ArrayList<>();
		this.isActive = isActive;
		this.customer = customer;
	}

	private Long accNumber;
	private List<IEntry> entries;
	private boolean isActive;
	private ICustomer customer;

	@Override
	public Long getAccNumber() {
		return accNumber;
	}

	@Override
	public void setCustomer(ICustomer customer) {
		this.customer = customer;
	}

	@Override
	public ICustomer getCustomer() {
		return customer;
	}

	@Override
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public boolean getIsActive() {
		return isActive;
	}

	@Override
	public void setAccNumber(long accNumber) {
		this.accNumber = accNumber;
	}

	@Override
	public void addInterest() {
		double interest = getBalance() * getInterestRate();
		addEntry(interest);
	}

	@Override
	public double getInterestRate() {
		return 0.025;
	}

	@Override
	public IEntry addEntry(double amount) {
		IEntry entry = Injector.createObject("entry", amount);
		entry.setAmount(amount);
		entry.setAccount(this);
		entries.add(entry);
		DbHelper.addEntry(entry);
		return entry;
	}
	
	@Override
	public List<IEntry> getEntries() {
		return entries;
	}

	@Override
	public void deposit(double amount) {
		IEntry entry = addEntry(amount);
		customer.sendEmail(entry);
	}

	@Override
	public void withdraw(double amount) {
		IEntry entry = addEntry(amount * -1);
		customer.sendEmail(entry);
	}

	@Override
	public double getBalance() {
		return entries.stream().mapToDouble(e -> e.getAmount()).sum();
	}

	@Override
	public void generateReport() {
		// TODO implement here
	}

	@Override
	public String toString() {
		return accNumber.toString();
	}

	@Override
	public String getType() {
		return null;
	}
}