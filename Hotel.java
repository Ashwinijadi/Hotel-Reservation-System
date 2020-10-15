package com.capgemini.hotelreservation;

public class Hotel {
	public String hotelName;
	public long weekRatesFor_RegularCustomer;
	public long weekendRatesFor_RegularCustomer;
	public long weekRatesFor_RewardCustomer;
	public long weekendRatesFor_RewardCustomer;
	public long price;
	public int rating;

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public Hotel(String hotelName, long weekRatesFor_RegularCustomer, long weekendRatesFor_RegularCustomer,
			long weekRatesFor_RewardCustomer, long weekendRatesFor_RewardCustomer, int rating) {
		this.hotelName = hotelName;
		this.weekRatesFor_RegularCustomer = weekRatesFor_RegularCustomer;
		this.weekendRatesFor_RegularCustomer = weekendRatesFor_RegularCustomer;
		this.weekRatesFor_RewardCustomer = weekRatesFor_RewardCustomer;
		this.weekendRatesFor_RewardCustomer = weekendRatesFor_RewardCustomer;
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Hotel [hotelName=" + hotelName + ", weekRatesFor_RegularCustomer=" + weekRatesFor_RegularCustomer
				+ ", weekendRatesFor_RegularCustomer=" + weekendRatesFor_RegularCustomer
				+ ", weekRatesFor_RewardCustomer=" + weekRatesFor_RewardCustomer + ", weekendRatesFor_RewardCustomer="
				+ weekendRatesFor_RewardCustomer + ", price=" + price + ", rating=" + rating + "]";
	}

	public long getWeekRatesFor_RewardCustomer() {
		return weekRatesFor_RewardCustomer;
	}

	public void setWeekRatesFor_RewardCustomer(long weekRatesFor_RewardCustomer) {
		this.weekRatesFor_RewardCustomer = weekRatesFor_RewardCustomer;
	}

	public long getWeekendRatesFor_RewardCustomer() {
		return weekendRatesFor_RewardCustomer;
	}

	public void setWeekendRatesFor_RewardCustomer(long weekendRatesFor_RewardCustomer) {
		this.weekendRatesFor_RewardCustomer = weekendRatesFor_RewardCustomer;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
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
