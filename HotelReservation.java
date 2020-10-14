package com.capgemini.hotelreservation;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Comparator;
import java.util.Calendar;
import java.util.stream.Collectors;

public class HotelReservation {
	private static List<Hotel> hotels = new ArrayList<Hotel>();
	private static Scanner input = new Scanner(System.in);

	public static boolean addHotel(String name, long weekRatesFor_RegularCustomer, long weekendRatesFor_RegularCustomer,
			int rating) {
		Hotel hotel_list = new Hotel(name, weekRatesFor_RegularCustomer, weekendRatesFor_RegularCustomer, rating);
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

//		Hotel cheapHotel_Weekend= hotels.stream().sorted(Comparator.comparing(Hotel::getWeekend_rates)).findFirst().orElse(null);
//		Hotel cheapHotel_Week=hotels.stream().sorted(Comparator.comparing(Hotel::getRates)).findFirst().orElse(null);
		long dateRange = 1 + ((end_date.getTime() - start_date.getTime()) / (1000 * 60 * 60 * 24));
		Calendar startCal = Calendar.getInstance();
		startCal.setTime(start_date);
		Calendar endCal = Calendar.getInstance();
		endCal.setTime(end_date);
		long workDays = 0;
		if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
			startCal.setTime(end_date);
			endCal.setTime(start_date);
		}
		do {
			startCal.add(Calendar.DAY_OF_MONTH, 1);
			if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
					&& startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
				++workDays;
			}
		} while (startCal.getTimeInMillis() < endCal.getTimeInMillis());
		long weekend = dateRange - workDays;
		for (Hotel hotel_list : hotels) {
			long price = weekend * hotel_list.weekendRatesFor_RegularCustomer
					+ workDays * hotel_list.weekRatesFor_RegularCustomer;
			hotel_list.setPrice(price);
		}
		List<Hotel>ratingList=hotels.stream().sorted(Comparator.comparing(Hotel::getPrice)).collect(Collectors.toList());
		Hotel cheapHotel=ratingList.get(0);
		long cheapPrice=ratingList.get(0).getPrice();
		for(Hotel h:ratingList) {
			if(h.getPrice()<cheapPrice)
				cheapPrice=h.getPrice();
			if (h.getRating() > cheapHotel.getRating())
				cheapHotel = h;		
			else 
				break;
		}
		return cheapHotel;
	}

	public static void main(String[] args) {
		System.out.println("Welcome to the Hotel Reservation Program");
		HotelReservation hotel_price = new HotelReservation();
		HotelReservation.addHotel("LakeWood", 110, 90, 3);
		HotelReservation.addHotel("BridgeWood", 160, 50, 4);
		HotelReservation.addHotel("RidgeWood", 220, 150, 5);
		System.out.println("enter name of hotel");
		String hotel1 = input.next();
		System.out.println("enter Price for weekday");
		int week_price1 = input.nextInt();
		System.out.println("enter Price for weekdend");
		int weekend_price1 = input.nextInt();
		System.out.println("Enter Rating of Hotel");
		int rating1 = input.nextInt();
		System.out.println(addHotel(hotel1, week_price1, weekend_price1, rating1));
		System.out.println("enter start date:");
		String startD = input.next();
		System.out.println("enter end date:");
		String endD = input.next();
		Hotel cheap = hotel_price.findCheapHotelForGivenDateRange(startD, endD);
		System.out.println("Hotel name is " + cheap.getHotelName() +"\nHotel week price is "
				+ cheap.getWeekendRatesFor_RegularCustomer() + "\nweekend price is " +cheap.getWeekRatesFor_RegularCustomer()
				+ "\ntotal price is " + cheap.getPrice()+"rating is "+cheap.getRating());
	}
}
