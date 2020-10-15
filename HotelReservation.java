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
			long weekRatesFor_RewardCustomer, long weekendRatesFor_RewardCustomer, int rating) {
		Hotel hotel_list = new Hotel(name, weekRatesFor_RegularCustomer, weekendRatesFor_RegularCustomer,
				weekRatesFor_RewardCustomer, weekendRatesFor_RewardCustomer, rating);
		return true;
	}

	public static void main(String[] args) {
		System.out.println("Welcome to the Hotel Reservation Program");
		HotelReservation hotel_price = new HotelReservation();
		System.out.println(hotel_price.addHotel("LakeWood", 110, 90, 80, 80, 3));
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
		System.out.print(addHotel(hotel1, week_price1, weekend_price1, week_price2, weekend_price2, rating1));
		;
	}

}
