package com.blogsite.blogvue.models;

import org.springframework.data.annotation.Id;

public class Location {
	
	@Id
	private String locationId;
	private String city;
	private String state;
	
	public Location(String city, String state) {
		super();
		this.city = city;
		this.state = state;
	}
	
	@Override
	public String toString() {
		return String.format("%s, %s", city, state);
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}
