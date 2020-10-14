package com.capgemini.hotelreservation;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Comparator;

public class HotelReservation {
	// private static HashMap<String, Integer> hotelNames = new HashMap<String,
	private static List<Hotel> hotels = new ArrayList<Hotel>();
	private static Scanner input = new Scanner(System.in);

	public static boolean addHotel(String name, long weekRatesFor_RegularCustomer,
			long weekendRatesFor_RegularCustomer) {
		Hotel hotel_list = new Hotel(name, weekRatesFor_RegularCustomer, weekendRatesFor_RegularCustomer);
		hotels.add(hotel_list);
		return true;
	}

	public Hotel findCheapHotelForGivenDateRange(String startDate, String endDate) {
		Date start_date = null;
		Date end_date = null;
		try {
			start_date = new SimpleDateFormat("ddMMMyyyy").parse(startDate);
			end_date = new SimpleDateFormat("ddMMMyyyy").parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Hotel cheapHotel = hotels.stream().sorted(Comparator.comparing(Hotel::getWeekRatesFor_RegularCustomer))
				.findFirst().orElse(null);
		long dateRange = 1 + ((end_date.getTime() - start_date.getTime()) / (1000 * 60 * 60 * 24));
		long price = cheapHotel.getWeekRatesFor_RegularCustomer();
		cheapHotel.setPrice(price);
		return cheapHotel;
	}

	public static void main(String[] args) {
		System.out.println("Welcome to the Hotel Reservation Program");
		HotelReservation hotel_price = new HotelReservation();
		HotelReservation.addHotel("LakeWood", 110, 90);
		HotelReservation.addHotel("BridgeWood", 160, 50);
		HotelReservation.addHotel("RidgeWood", 220, 150);
		System.out.println("enter name of hotel");
		String hotel1 = input.next();
		System.out.println("enter Price for weekday");
		int week_price1 = input.nextInt();
		System.out.println("enter Price for weekdend");
		int weekend_price1 = input.nextInt();
		System.out.println(addHotel(hotel1, week_price1, weekend_price1));
		
	}
}
