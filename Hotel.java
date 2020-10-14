package com.capgemini.hotelreservation;

public class Hotel  
{
	public String hotelName;
	public long rates;

	public Hotel(String hotelName, long rates) {
		this.hotelName = hotelName;
		this.rates = rates;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public long getRates() {
		return rates;
	}

	public void setRates(long rates) {
		this.rates = rates;
	}

}
