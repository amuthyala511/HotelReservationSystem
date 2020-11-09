package com.blz.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class HotelReservationTest {
	static HotelReservation reservation;
	private static Locale Locale;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");

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
		String date1 = "10/9/2020";
		String date2 = "11/9/2020";
		List<String> dayList = new ArrayList<>();
		dayList.add(LocalDate.parse(date1, formatter).getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.US));
		dayList.add(LocalDate.parse(date2, formatter).getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.US));
		int cheapestRate = reservation.getCheapestRate(dayList);
		List<String> cheapestHotel = reservation.getCheapestHotel(cheapestRate);
		Assert.assertEquals(true, cheapestHotel.contains("Lakewood"));
		System.out.println("Cheapest Hotel : "+cheapestHotel+", Total charges : "+cheapestRate);
	}
	
	@Test
	public void givenDates_whenWeekdayAndWeekend_FindCheapestRate_ReturnHotelName() {
		String date1 = "11/9/2020";
		String date2 = "12/9/2020";
		List<String> dayList = new ArrayList<>();
		dayList.add(LocalDate.parse(date1, formatter).getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.US));
		dayList.add(LocalDate.parse(date2, formatter).getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.US));
		int cheapestRate = reservation.getCheapestRate(dayList);
		List<String> cheapestHotel = reservation.getCheapestHotel(cheapestRate);
		Assert.assertEquals(true, cheapestHotel.contains("Lakewood"));
		System.out.println("Cheapest Hotel : "+cheapestHotel+", Total charges : "+cheapestRate);
	}
	
	@Test
	public void givenDates_whenWeekdayAndWeekend_FindCheapestRate_ReturnHotelName_withBestRating() {
		String date1 = "11/9/2020";
		String date2 = "12/9/2020";
		List<String> dayList = new ArrayList<>();
		dayList.add(LocalDate.parse(date1, formatter).getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.US));
		dayList.add(LocalDate.parse(date2, formatter).getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.US));
		int cheapestRate = reservation.getCheapestRate(dayList);
		List<String> cheapestHotel = reservation.getCheapestHotel(cheapestRate);
		String bestRatedCheapestHotel = reservation.getCheapestBestRatedHotel(cheapestHotel);
		int rating = reservation.getHotelRatingBasedOnHotel(bestRatedCheapestHotel);
		Assert.assertEquals("Bridgewood", bestRatedCheapestHotel);
		System.out.println("Cheapest Hotel with Best Rating : "+bestRatedCheapestHotel+", Rating : "+rating+", Total charges : "+cheapestRate);
	}
}
