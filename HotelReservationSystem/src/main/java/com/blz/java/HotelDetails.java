package com.blz.java;

import java.util.HashMap;
import java.util.Map;

public class HotelDetails {
	Map<Integer, String> hotels;
	Map<Integer, String> hotelName = new HashMap<Integer, String>();
	Map<Integer, Integer> hotelWeekdayRates = new HashMap<Integer, Integer>();
	Map<Integer, Integer> hotelWeekendRates = new HashMap<Integer, Integer>();

	public Map<Integer, String> getHotels() {
		hotelName.put(1, "Lakewood");
		hotelName.put(2, "Bridgewood");
		hotelName.put(3, "Ridgewood");
		return hotelName;
	}

	public String getHotelName(int id) {
		hotels = getHotels();
		return hotelName.get(id);
	}
	
	public int getHotelWeekdayRates(int id) {
		hotelWeekdayRates.put(1, 110);
		hotelWeekdayRates.put(2, 160);
		hotelWeekdayRates.put(3, 220);
		return hotelWeekdayRates.get(id);
	}
	
	public int getHotelWeekendRates(int id) {
		hotelWeekendRates.put(1, 90);
		hotelWeekendRates.put(2, 60);
		hotelWeekendRates.put(3, 150);
		return hotelWeekendRates.get(id);
	}
}
