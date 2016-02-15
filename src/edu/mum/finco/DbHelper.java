package edu.mum.finco;

import java.util.*;

public class DbHelper {
	
	private static List<IAccount> accounts = new ArrayList<IAccount>();
	private static List<ICustomer> customers = new ArrayList<ICustomer>();
	private static List<IEntry> entries = new ArrayList<IEntry>();
	
	public static IAccount getAccount(long accNumber) throws Exception {
		Optional<IAccount> account = accounts.stream().filter(a -> a.getAccNumber() == accNumber).findAny();
		if(account.isPresent())
			return account.get();
		else
			throw new Exception("Account not found!");
	}
	
	public static void addAccount(IAccount account) {
		accounts.add(account);
	}

	public static void addCustomer(ICustomer customer) {
		customers.add(customer);
	}

	public static void addEntry(IEntry entry) {
		entries.add(entry);
	}

	public static long getMaxAccountNumber() {
		OptionalLong maxAccNo = accounts.stream().mapToLong(a -> a.getAccNumber()).max();
		if(maxAccNo.isPresent())
			return maxAccNo.getAsLong();
		else
			return 0;
	}

	public static void addInterest() {
		for(IAccount account: accounts) {
			account.addInterest();
		}
	}

	public static List<IAccount> getAllAccounts() {
		return accounts;
	}
}
