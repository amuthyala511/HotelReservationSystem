package com.blz.java;

import java.util.ArrayList;
import java.util.Arrays;
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
		String customerType = "Regular";
		List<String> dateRange = Arrays.asList("10/9/2020", "11/9/2020");
		List<String> dayList = new ArrayList<>();
		for(String eachDate : dateRange)
			dayList.add(LocalDate.parse(eachDate, formatter).getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.US));
		int cheapestRate = reservation.getCheapestRate(dayList, customerType);
		List<String> cheapestHotel = reservation.getCheapestHotel(cheapestRate);
		Assert.assertEquals(true, cheapestHotel.contains("Lakewood"));
		System.out.println("Cheapest Hotel : "+cheapestHotel+", Total charges : "+cheapestRate);
		System.out.println("Customer-Type : "+customerType+", Given dates : "+dateRange);
	}
	
	@Test
	public void givenDates_whenWeekdayAndWeekend_FindCheapestRate_ReturnHotelName() {
		String customerType = "Regular";
		List<String> dateRange = Arrays.asList("11/9/2020", "12/9/2020");
		List<String> dayList = new ArrayList<>();
		for(String eachDate : dateRange)
			dayList.add(LocalDate.parse(eachDate, formatter).getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.US));
		int cheapestRate = reservation.getCheapestRate(dayList, customerType);
		List<String> cheapestHotel = reservation.getCheapestHotel(cheapestRate);
		Assert.assertEquals(true, cheapestHotel.contains("Lakewood"));
		System.out.println("Cheapest Hotel : "+cheapestHotel+", Total charges : "+cheapestRate);
	}
	
	@Test
	public void givenDates_whenWeekdayAndWeekend_FindCheapestRate_ReturnHotelName_withBestRating() {
		String customerType = "Regular";
		List<String> dateRange = Arrays.asList("11/9/2020", "12/9/2020");
		List<String> dayList = new ArrayList<>();
		for(String eachDate : dateRange)
			dayList.add(LocalDate.parse(eachDate, formatter).getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.US));
		int cheapestRate = reservation.getCheapestRate(dayList, customerType);
		List<String> cheapestHotel = reservation.getCheapestHotel(cheapestRate);
		String bestRatedCheapestHotel = reservation.getCheapestBestRatedHotel(cheapestHotel);
		int rating = reservation.getHotelRatingBasedOnHotel(bestRatedCheapestHotel);
		Assert.assertEquals("Bridgewood", bestRatedCheapestHotel);
		System.out.println("Cheapest Hotel with Best Rating : "+bestRatedCheapestHotel+", Rating : "+rating+", Total charges : "+cheapestRate);
	}
	
	@Test
	public void givenWeekdaysAndWeekendDays_withBestRating_ShouldReturnHotelName() {
		String customerType = "Regular";
		List<String> dateRange = Arrays.asList("11/9/2020", "12/9/2020");
		List<String> dayList = new ArrayList<>();
		for(String eachDate : dateRange)
			dayList.add(LocalDate.parse(eachDate, formatter).getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.US));
		String bestRatedHotel = reservation.getBestRatedHotel();
		Assert.assertEquals("Ridgewood", bestRatedHotel);
		int index = reservation.getHotelIndex(bestRatedHotel);
		System.out.println("Best Rated Hotel : "+bestRatedHotel+", Total charges :"+reservation.getRate(dayList, index, customerType));
	}
	
	@Test
	public void givenWeekdaysAndWeekEndDays_ForRewardCustomer_WhenCheapestRate_ShouldReturnHotelName() {
		String customerType = "Reward";
		List<String> dateRange = Arrays.asList("11/9/2020", "12/9/2020");
		List<String> dayList = new ArrayList<>();
		for(String eachDate : dateRange)
			dayList.add(LocalDate.parse(eachDate, formatter).getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.US));
		int cheapestRate = reservation.getCheapestRate(dayList, customerType);
		List<String> cheapestHotel = reservation.getCheapestHotel(cheapestRate);
		String bestRatedCheapestHotel = reservation.getCheapestBestRatedHotel(cheapestHotel);
		int rating = reservation.getHotelRatingBasedOnHotel(bestRatedCheapestHotel);
		Assert.assertEquals("Bridgewood", bestRatedCheapestHotel);
		System.out.println("Cheapest Hotel with Best Rating : "+bestRatedCheapestHotel+", Rating : "+rating+", Total charges : "+cheapestRate);
	}
}
