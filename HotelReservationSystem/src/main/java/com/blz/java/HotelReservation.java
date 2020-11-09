package com.blz.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HotelReservation {
	HotelDetails hotelDetails = new HotelDetails();
	Map<Integer, String> hotelList = hotelDetails.getHotels();
	Map<Integer, Integer> hoteltotalRates = new HashMap<Integer, Integer>();
	List<String> cheapRateHotel = new ArrayList<>();
	Map<Integer, Integer> hotelCheapestRating = new HashMap<Integer, Integer>();
	Map<Integer, Integer> ratings = hotelDetails.getHotelRatings();

	public int getSize() {
		return hotelList.size();
	}
	
	public String getHotelName(int id) {
		return hotelList.get(id);
	}
	
	public int getRate(List<String> dayList, int hotelId) {
		int totalRates = 0;
		for(String day : dayList) {
			if(day != "Sat" && day != "Sun")
				totalRates = totalRates + hotelDetails.getHotelWeekdayRates(hotelId);
			else
				totalRates = totalRates + hotelDetails.getHotelWeekendRates(hotelId);
		}
		return totalRates;
	}

	public int getCheapestRate(List<String> dayList) {
		for (int i = 1; i <= hotelList.size(); i++) {
			hoteltotalRates.put(i, getRate(dayList, i));
		}
		int cheapestRate = Collections.min(hoteltotalRates.values());
		return cheapestRate;
	}

	public List<String> getCheapestHotel(int rate) {
		int hotelId = 0;
		for (Entry<Integer, Integer> entry : hoteltotalRates.entrySet()) {
			if (entry.getValue().equals(rate)) {
				hotelId = entry.getKey();
				cheapRateHotel.add(getHotelName(hotelId));
			}
		}
		return cheapRateHotel;
	}
	
	public String getCheapestBestRatedHotel(List<String> cheapestHotel) {
		for(int i = 1; i <= cheapestHotel.size(); i++) {
			for(String cheapHotel : cheapestHotel)
				hotelCheapestRating.put(i, getHotelRatingBasedOnHotel(cheapHotel));
		}
		int bestRating = Collections.max(hotelCheapestRating.values());
		return getHotelBasedOnRating(bestRating);
	}

	public String getHotelBasedOnRating(int rating) {
		int hotelNum = 0;
		for(Entry<Integer, Integer> entry : ratings.entrySet()) {
			if(entry.getValue().equals(rating))
				hotelNum = entry.getKey();
		}
		return hotelList.get(hotelNum);
	}

	public int getHotelRatingBasedOnHotel(String inputHotel) {
		return ratings.get(getHotelIndex(inputHotel));
	}

	public int getHotelIndex(String inputHotel) {
		int hotelNo = 0;
		for(Entry<Integer, String> entry : hotelList.entrySet()) {
			if(entry.getValue().equals(inputHotel))
				hotelNo = entry.getKey();
		}
		return hotelNo;
	}
	
	public String getBestRatedHotel() {
		int bestRating = Collections.max(ratings.values());
		return getHotelBasedOnRating(bestRating);
	}
}
