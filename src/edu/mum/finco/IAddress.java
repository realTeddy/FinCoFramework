package edu.mum.finco;

public interface IAddress {
	
    public String getStreet();

    public String getCity();

    public String getState();

    public int getZip();

	void setStreet(String street);

	void setCity(String city);

	void setZip(int zip);

	void setState(String state);

}