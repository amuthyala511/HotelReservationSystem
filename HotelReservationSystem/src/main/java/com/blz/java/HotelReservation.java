package com.blz.java;

import java.util.ArrayList;
import java.util.Comparator;
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
	
	public int getRate(List<String> dayList, int hotelId, String customerType) {
		int totalRates = 0;
		if(customerType.equalsIgnoreCase("Regular")) {
			for(String day : dayList) {
				if(day != "Sat" && day != "Sun")
					totalRates = totalRates + hotelDetails.getHotelWeekdayRatesForRegularCustomer(hotelId);
				else
					totalRates = totalRates + hotelDetails.getHotelWeekendRatesForRegularCustomer(hotelId);
			}
		}
		else if(customerType.equalsIgnoreCase("Reward")) {
			for(String day : dayList) {
				if(day != "Sat" && day != "Sun")
					totalRates = totalRates + hotelDetails.getHotelWeekdayRatesForRewardCustomer(hotelId);
				else
					totalRates = totalRates + hotelDetails.getHotelWeekendRatesForRewardCustomer(hotelId);
			}
		}
		return totalRates;
	}

	public int getCheapestRate(List<String> dayList, String customerType) {
		for (int i = 1; i <= hotelList.size(); i++) {
			hoteltotalRates.put(i, getRate(dayList, i, customerType));
		}
		int cheapestRate = hoteltotalRates.entrySet().stream().min(Comparator.comparing(Map.Entry::getValue)).get().getValue();
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
		int bestRating = hotelCheapestRating.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getValue();
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
		int bestRating = ratings.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getValue();
		return getHotelBasedOnRating(bestRating);
	}
}
