package com.blz.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HotelReservation {
	Map<Integer, String> hotelList = new HashMap<Integer, String>();
	Map<Integer, Integer> hoteltotalRates = new HashMap<Integer, Integer>();
	List<String> cheapRateHotel = new ArrayList<>();
	Map<Integer, Integer> hotelCheapestRating = new HashMap<Integer, Integer>();
	HotelDetails hotelDetails = new HotelDetails();

	public int getSize() {
		hotelList = hotelDetails.getHotels();
		return hotelList.size();
	}

	public int getCheapestRate(List<String> dayList) {
		for (int i = 1; i <= hotelList.size(); i++) {
			int totalRates = 0;
			for(String day : dayList) {
				if(day != "Sat" && day != "Sun")
					totalRates = totalRates + hotelDetails.getHotelWeekdayRates(i);
				else
					totalRates = totalRates + hotelDetails.getHotelWeekendRates(i);
			}
			hoteltotalRates.put(i, totalRates);
		}
		int cheapestRate = Collections.min(hoteltotalRates.values());
		return cheapestRate;
	}

	public List<String> getCheapestHotel(int rate) {
		int hotelId = 0;
		for (Entry<Integer, Integer> entry : hoteltotalRates.entrySet()) {
			if (entry.getValue().equals(rate)) {
				hotelId = entry.getKey();
				cheapRateHotel.add(hotelDetails.getHotelName(hotelId));
			}
		}
		return cheapRateHotel;
	}
	
	public String getCheapestBestRatedHotel(List<String> cheapestHotel) {
		for(int i = 0; i <= cheapestHotel.size(); i++) {
			for(String cheapHotel : cheapestHotel)
				hotelCheapestRating.put(i, getHotelRatingBasedOnHotel(cheapHotel));
		}
		int bestRating = Collections.max(hotelCheapestRating.values());
		int hotelNo = 0;
		for(Entry<Integer, Integer> entry : hotelCheapestRating.entrySet()) {
			if(entry.getValue().equals(bestRating)) {
				hotelNo = entry.getKey();
			}
		}
		return hotelDetails.getHotelName(hotelNo);
	}

	public int getHotelRatingBasedOnHotel(String inputHotel) {
		int hotelNum = 0;
		for(Entry<Integer, String> entry : hotelList.entrySet()) {
			if(entry.getValue().equals(inputHotel)) {
				hotelNum = entry.getKey();
			}
		}
		return hotelDetails.getHotelRatings(hotelNum);
	}
}
