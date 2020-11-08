package com.blz.java;

import java.util.ArrayList;
import java.util.List;

public class HotelReservation {
	public static List<HotelDetails> list = new ArrayList<HotelDetails>();
	
	public static void main(String[] args) {
		System.out.println("WELCOME TO HOTEL RESERVATION PROGRAM IN HOTEL-RESERVATION CLASS");
		HotelDetails h1 = new HotelDetails("Lakewood", 3, "Regular", 100, 90);
		HotelDetails h2 = new HotelDetails("Bridgewood", 4, "Regular", 160, 60);
		HotelDetails h3 = new HotelDetails("Ridgewood", 5, "Regular", 220, 150);
		list.add(h1);
		list.add(h2);
		list.add(h3);
		for(HotelDetails hotelList : list ) {
			System.out.println(hotelList);
		}
	}
}
