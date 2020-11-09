package com.blz.java;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HotelReservation {
	Map<Integer, String> hotelList = new HashMap<Integer, String>();
	Map<Integer, Integer> hoteltotalRates = new HashMap<Integer, Integer>();
	HotelDetails hotelDetails = new HotelDetails();

	public int getSize() {
		hotelList = hotelDetails.getHotels();
		return hotelList.size();
	}

	public int getCheapestRate(int noOfDays) {
		for (int i = 1; i <= hotelList.size(); i++) {
			hoteltotalRates.put(i, noOfDays * hotelDetails.getHotelRates(i));
		}
		int cheapestRate = Collections.min(hoteltotalRates.values());
		return cheapestRate;
	}

	public String getCheapestHotel(int rate) {
		int hotelId = 0;
		for (Entry<Integer, Integer> entry : hoteltotalRates.entrySet()) {
			if (entry.getValue().equals(rate)) {
				hotelId = entry.getKey();
			}
		}
		return hotelDetails.getHotelName(hotelId);
	}
}
