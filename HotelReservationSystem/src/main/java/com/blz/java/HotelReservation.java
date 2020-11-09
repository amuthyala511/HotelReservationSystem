package com.blz.java;

import java.util.HashMap;
import java.util.Map;

public class HotelReservation {
	Map<String, Integer> hotelList = new HashMap<String, Integer>();
	HotelDetails hotelDetails = new HotelDetails();
	
	public int getSize() {
		hotelList = hotelDetails.getHotels();
		return hotelList.size();
	}
}
