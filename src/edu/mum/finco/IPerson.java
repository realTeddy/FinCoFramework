package edu.mum.finco;

import java.time.LocalDate;

public interface IPerson extends ICustomer {

    public LocalDate getBirthDate();

	void setBirthDate(LocalDate birthDate);

}