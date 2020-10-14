package com.capgemini.hotelreservation;

import static org.junit.Assert.*;

import org.junit.Test;

public class HotelReservation_Test {

	@Test
	public void addHotelNameInReservationSystemTest() {
		HotelReservation hotel_Name = new HotelReservation();
		boolean nameCheck = HotelReservation.addHotel("LakeWood", 110,90,3);
		boolean nameCheck1 = HotelReservation.addHotel("BridgeWood", 160,50,4);
		boolean nameCheck2 = HotelReservation.addHotel("RidgeWood", 220,150,5);
		assertTrue(nameCheck);
		assertTrue(nameCheck1);
		assertTrue(nameCheck2);
	}

}
