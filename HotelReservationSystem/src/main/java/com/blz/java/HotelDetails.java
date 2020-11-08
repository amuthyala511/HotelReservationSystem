package com.blz.java;

public class HotelDetails {
	private String hotelName;
	private int rating;
	private String customerType;
	private int weekdayRate;
	private int weekendRate;
	
	public HotelDetails(String hotelName, int rating, String customerType, int weekdayRate, int weekendRate) {
		this.hotelName = hotelName;
		this.rating = rating;
		this.customerType = customerType;
		this.weekdayRate = weekdayRate;
		this.weekendRate = weekendRate;
	}
	
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName( String hotelName) {
		this.hotelName = hotelName;
	}
	
	public int getRating() {
		return rating;
	}
	public void setRating( int rating) {
		this.rating = rating;
	}
	
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType( String customerType) {
		this.customerType = customerType;
	}
	
	public int getWeekDayRate() {
		return weekdayRate;
	}
	public void setWeekDayRate( int weekdayRate) {
		this.weekdayRate = weekdayRate;
	}
	
	public int getWeekendRate() {
		return weekendRate;
	}
	public void setWeekEndRate( int weekendRate) {
		this.weekendRate = weekendRate;
	}
	
	@Override
	public String toString() {
		return "HotelDetails [ HotelName : "+hotelName+", Rating : "+rating+", CustomerType : "+customerType+", Weekday-charges : "+weekdayRate+", Weekend-Charges : "+weekendRate+" ]";
	}
}
