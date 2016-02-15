package edu.mum.finco;

import java.time.LocalDate;
import java.util.List;

public class Person extends Customer implements IPerson {
	
	public Person(LocalDate birthDate, String name, String email, IAddress address,
			List<IAccount> accounts, boolean isActive) {
		super(name, email, address, accounts, isActive);
		
	}

    private LocalDate birthDate;

    @Override
    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

	@Override
	public void sendEmail(IEntry entry) {
		double amount = entry.getAmount();
		if(Math.abs(amount) > 500 || (amount < 0 && entry.getAccount().getBalance() < (amount * -1)))
			System.out.println("Email Sent to " + this.getEmail());
	}

	@Override
	public String getType() {
		return "P";
	}

}