package com.blz.java;

import java.util.ArrayList;
import java.util.List;

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

	@Test
	public void givenDates_FindCheapestRate_ReturnHotelName() {
		List<String> dateList = new ArrayList<>();
		dateList.add("10sep2020");
		dateList.add("11sep2020");
		int totaldays = dateList.size();
		int cheapestWeekdayRate = reservation.getCheapestWeekdayRate(totaldays);
		String cheapestWeekdayHotel = reservation.getCheapestWeekdayHotel(cheapestWeekdayRate);
		Assert.assertEquals("Lakewood", cheapestWeekdayHotel);
		int cheapestWeekendRate = reservation.getCheapestWeekendRate(totaldays);
		String cheapestWeekendHotel = reservation.getCheapestWeekendHotel(cheapestWeekendRate);
		Assert.assertEquals("Bridgewood", cheapestWeekendHotel);
		System.out.println("Cheapest Weekday Hotel: "+cheapestWeekdayHotel+", Total Charges: "+cheapestWeekdayRate);
		System.out.println("Cheapest Weekend Hotel: "+cheapestWeekendHotel+", Total Charges: "+cheapestWeekendRate);
	}
}
