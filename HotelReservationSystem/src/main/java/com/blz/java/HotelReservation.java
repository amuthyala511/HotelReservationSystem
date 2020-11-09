package com.blz.java;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HotelReservation {
	Map<Integer, String> hotelList = new HashMap<Integer, String>();
	Map<Integer, Integer> hoteltotalWeekdayRates = new HashMap<Integer, Integer>();
	Map<Integer, Integer> hoteltotalWeekendRates = new HashMap<Integer, Integer>();
	HotelDetails hotelDetails = new HotelDetails();

	public int getSize() {
		hotelList = hotelDetails.getHotels();
		return hotelList.size();
	}

	public int getCheapestWeekdayRate(int noOfDays) {
		for (int i = 1; i <= hotelList.size(); i++) {
			hoteltotalWeekdayRates.put(i, noOfDays * hotelDetails.getHotelWeekdayRates(i));
		}
		int cheapestWeekdayRate = Collections.min(hoteltotalWeekdayRates.values());
		return cheapestWeekdayRate;
	}

	public String getCheapestWeekdayHotel(int rate) {
		int hotelId = 0;
		for (Entry<Integer, Integer> entry : hoteltotalWeekdayRates.entrySet()) {
			if (entry.getValue().equals(rate)) {
				hotelId = entry.getKey();
			}
		}
		return hotelDetails.getHotelName(hotelId);
	}
	
	public int getCheapestWeekendRate(int noOfDays) {
		for (int i = 1; i <= hotelList.size(); i++) {
			hoteltotalWeekendRates.put(i, noOfDays * hotelDetails.getHotelWeekendRates(i));
		}
		int cheapestWeekendRate = Collections.min(hoteltotalWeekendRates.values());
		return cheapestWeekendRate;
	}

	public String getCheapestWeekendHotel(int rate) {
		int hotelId = 0;
		for (Entry<Integer, Integer> entry : hoteltotalWeekendRates.entrySet()) {
			if (entry.getValue().equals(rate)) {
				hotelId = entry.getKey();
			}
		}
		return hotelDetails.getHotelName(hotelId);
	}
}
