package com.blz.java;

import java.util.HashMap;
import java.util.Map;

public class HotelDetails {
	Map<String, Integer> hotelRegularRates = new HashMap<String, Integer>();
	
	public Map<String, Integer> getHotels() {
		hotelRegularRates.put("Lakewood", 110);
		hotelRegularRates.put("Bridgewood", 160);
		hotelRegularRates.put("Ridgewood", 220);
		return hotelRegularRates;
	}
}
