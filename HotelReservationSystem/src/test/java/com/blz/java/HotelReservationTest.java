package com.blz.java;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class HotelReservationTest {

	static HotelReservation reservation;

	@BeforeClass
	public static void createHotelReservationObj() {
		reservation = new HotelReservation();
	}

	@Test
	public void givenHotels_whenAdded_ShoulsReturnSize() {
		int noOfHotels = reservation.getSize();
		Assert.assertEquals(3, noOfHotels);
	}
}
