package com.capgemini.hotelreservation;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class HotelReservation {
		// private static HashMap<String, Integer> hotelNames = new HashMap<String,
		private static List<Hotel> hotels = new ArrayList<Hotel>();
		private static Scanner input = new Scanner(System.in);

		public static boolean addHotel(String name, long weekRatesFor_RegularCustomer) {
			Hotel hotel_list = new Hotel(name,weekRatesFor_RegularCustomer );
			hotels.add(hotel_list);
			return true;
		}

	public static void main(String[] args) {
		System.out.println("Welcome to the Hotel Reservation Program");
		HotelReservation hotel_price = new HotelReservation();
		HotelReservation.addHotel("LakeWood", 110);
		HotelReservation.addHotel("BridgeWood", 160);
		HotelReservation.addHotel("RidgeWood", 220);
		System.out.println("enter name of hotel");
		String hotel1 = input.next();
		System.out.println("enter Price for weekday");
		int week_price1 = input.nextInt();
		System.out.println(addHotel(hotel1,week_price1));
	}
}
