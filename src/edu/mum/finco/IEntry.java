package edu.mum.finco;

import java.time.LocalDate;

public interface IEntry {

	LocalDate getDate();

	double getAmount();

	void setAmount(double amount);

	void setAccount(IAccount account);

	IAccount getAccount();

}