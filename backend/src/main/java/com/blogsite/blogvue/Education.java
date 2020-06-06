package com.blogsite.blogvue;

import java.util.ArrayList;
import java.util.Date;

public class Education {
	
	private String schoolName;
	private Location location;
	private Date startDate;
	private Date endDate;
	private ArrayList<String> degreeName;
	private String concentration;
	
	public Education(String schoolName, Location location, Date startDate, Date endDate, ArrayList<String> degreeName,
			String concentration) {
		super();
		this.schoolName = schoolName;
		this.location = location;
		this.startDate = startDate;
		this.endDate = endDate;
		this.degreeName = degreeName;
		this.concentration = concentration;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public ArrayList<String> getDegreeName() {
		return degreeName;
	}

	public void setDegreeName(ArrayList<String> degreeName) {
		this.degreeName = degreeName;
	}

	public String getConcentration() {
		return concentration;
	}

	public void setConcentration(String concentration) {
		this.concentration = concentration;
	}
	
	
}
