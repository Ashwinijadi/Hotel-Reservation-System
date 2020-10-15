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
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMMyyyy");

	public static boolean addHotel(String name, long weekRatesFor_RegularCustomer, long weekendRatesFor_RegularCustomer,
			long weekRatesFor_RewardCustomer, long weekendRatesFor_RewardCustomer, int rating) {
		Hotel hotel_list = new Hotel(name, weekRatesFor_RegularCustomer, weekendRatesFor_RegularCustomer,
				weekRatesFor_RewardCustomer, weekendRatesFor_RewardCustomer, rating);
		return true;
	}

	public Hotel findCheapBestRatedHotelForGivenDateRange(String startDate, String endDate, CustomerType customer) {
		Date start_date = null;
		Date end_date = null;
		try {
			start_date = new SimpleDateFormat("ddMMMyyyy").parse(startDate);
			end_date = new SimpleDateFormat("ddMMMyyyy").parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
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
		try {
			if (customer.getCustomerType().equals("reward")) {
				for (Hotel hotel_List : hotels) {
					long total = workDays * hotel_List.getWeekRatesFor_RewardCustomer()
							+ weekend * hotel_List.getWeekendRatesFor_RewardCustomer();
					hotel_List.setTotal(total);
				}
			}
			if (customer.getCustomerType().equals("regular")) {
				for (Hotel hotel_List : hotels) {
					long price = workDays * hotel_List.getWeekRatesFor_RegularCustomer()
							+ weekend * hotel_List.getWeekendRatesFor_RegularCustomer();
					hotel_List.setPrice(price);
				}
			}
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}

		List<Hotel> ratingList = hotels.stream().sorted(Comparator.comparing(Hotel::getPrice))
				.collect(Collectors.toList());
		Hotel cheapHotel = ratingList.get(0);
		long cheapPrice = ratingList.get(0).getPrice();
		for (Hotel h : ratingList) {
			if (h.getPrice() < cheapPrice)
				cheapPrice = h.getPrice();
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
		HotelReservation.addHotel("LakeWood", 110, 90, 80, 80, 3);
		HotelReservation.addHotel("BridgeWood", 160, 50, 110, 50, 4);
		HotelReservation.addHotel("RidgeWood", 220, 150, 100, 40, 5);
		System.out.println("enter name of hotel");
		String hotel1 = input.next();
		System.out.println("enter Price on weekday for regular customer");
		int week_price1 = input.nextInt();
		System.out.println("enter Price on weekdend for regular customer");
		int weekend_price1 = input.nextInt();

		System.out.println("enter Price on weekday for reward customer");
		int week_price2 = input.nextInt();
		System.out.println("enter Price on weekend for reward customer");
		int weekend_price2 = input.nextInt();
		System.out.println("Enter Rating of Hotel");
		int rating1 = input.nextInt();

		System.out.println(addHotel(hotel1, week_price1, weekend_price1, week_price2, weekend_price2, rating1));
		CustomerType customer = new CustomerType();
		System.out.println("Enter type of customer \n 1.regular ln 2.reward");
		System.out.println("Enter choice");
		int choice = input.nextInt();
		if (choice == 1) {
			customer.setCustomerType("regular");
			System.out.println("enter start date:");
			String startD = input.next();
			System.out.println("enter end date:");
			String endD = input.next();
			Hotel cheap = hotel_price.findCheapBestRatedHotelForGivenDateRange(startD, endD, customer);
			System.out.println(cheap.getHotelName() + " week rate :" + cheap.getWeekRatesFor_RegularCustomer()
					+ "weekend" + cheap.getWeekendRatesFor_RegularCustomer() + " total :" + cheap.getTotal() + "ratings"
					+ cheap.getRating());
		}
		if (choice == 2) {
			customer.setCustomerType("reward");
			System.out.println("enter start date:");
			String startD = input.next();
			System.out.println("enter end date:");
			String endD = input.next();
			Hotel cheap = hotel_price.findCheapBestRatedHotelForGivenDateRange(startD, endD, customer);
			System.out.println(cheap.getHotelName() + " \nweek rate :" + cheap.getWeekRatesFor_RewardCustomer()
					+ "\nweekend" + cheap.getWeekendRatesFor_RewardCustomer() + "\ntotal :" + cheap.getPrice()
					+ "\nratings" + cheap.getRating());
		}

	}
}
