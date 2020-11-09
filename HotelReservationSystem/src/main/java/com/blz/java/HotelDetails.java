package com.blz.java;

import java.util.HashMap;
import java.util.Map;

public class HotelDetails {
	Map<Integer, Integer> hotelRatings = new HashMap<Integer, Integer>();
	Map<Integer, String> hotelName = new HashMap<Integer, String>();
	Map<Integer, Integer> hotelRates = new HashMap<Integer, Integer>();

	public Map<Integer, String> getHotels() {
		hotelName.put(1, "Lakewood");
		hotelName.put(2, "Bridgewood");
		hotelName.put(3, "Ridgewood");
		return hotelName;
	}
	
	public int getHotelWeekdayRates(int id) {
		hotelRates.put(1, 110);
		hotelRates.put(2, 160);
		hotelRates.put(3, 220);
		return hotelRates.get(id);
	}
	
	public int getHotelWeekendRates(int id) {
		hotelRates.put(1, 90);
		hotelRates.put(2, 60);
		hotelRates.put(3, 150);
		return hotelRates.get(id);
	}
	
	public Map<Integer, Integer> getHotelRatings() {
		hotelRatings.put(1, 3);
		hotelRatings.put(2, 4);
		hotelRatings.put(3, 5);
		return hotelRatings;
	}
}
