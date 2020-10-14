package com.capgemini.hotelreservation;

public class Hotel {
	public String hotelName;
	public long weekRatesFor_RegularCustomer;
	public long weekendRatesFor_RegularCustomer;
	public long price;

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public Hotel(String hotelName, long  weekRatesFor_RegularCustomer, long weekendRatesFor_RegularCustomer) {
		this.hotelName = hotelName;
		this.weekRatesFor_RegularCustomer =weekRatesFor_RegularCustomer;
		this.weekendRatesFor_RegularCustomer= weekendRatesFor_RegularCustomer;;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public long getWeekRatesFor_RegularCustomer() {
		return weekRatesFor_RegularCustomer;
	}

	public void setWeekRatesFor_RegularCustomer(long weekRatesFor_RegularCustomer) {
		this.weekRatesFor_RegularCustomer = weekRatesFor_RegularCustomer;
	}

	public long getWeekendRatesFor_RegularCustomer() {
		return weekendRatesFor_RegularCustomer;
	}

	public void setWeekendRatesFor_RegularCustomer(long weekendRatesFor_RegularCustomer) {
		this.weekendRatesFor_RegularCustomer = weekendRatesFor_RegularCustomer;
	}

	
}
