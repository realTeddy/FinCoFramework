package edu.mum.finco;

import java.util.ArrayList;
import java.util.List;

public abstract class Customer implements ICustomer {
	
	public Customer(String name, String email, IAddress address, List<IAccount> accounts, boolean isActive) {
		this.name = name;
		this.email = email;
		this.address = address;
		this.accounts = accounts != null ? accounts : new ArrayList<>();
		this.isActive = isActive;
	}
	
	private int custNumber;
    private String name;
    private String email;
    private IAddress address;
    private List<IAccount> accounts;
    private boolean isActive;
    
    @Override
    public void setCustNumber(int custNumber) {
    	this.custNumber = custNumber;
    }
    
    @Override
    public int getCustNumber() {
    	return custNumber;
    }

    @Override
	public void addAccount(IAccount account) {
    	accounts.add(account);
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
	public List<IAccount> getAccountList() {
        return accounts;
    }

    @Override
	public String getName() {
        return name;
    }

    @Override
	public void setName(String name) {
        this.name = name;
    }

    @Override
	public String getEmail() {
        return email;
    }

    @Override
	public void setEmail(String email) {
        this.email = email;
    }

    @Override
	public IAddress getAddress() {
        return address;
    }

    @Override
	public void setAddress(IAddress address) {
        this.address = address;
    }
}