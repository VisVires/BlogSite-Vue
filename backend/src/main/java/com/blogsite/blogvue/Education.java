package com.blogsite.blogvue;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class Education {
	
	
	@Id
	private String schoolId;
	private String schoolName;
	private Location location;
	private Date startDate;
	private Date endDate;
	private String degreeName;
	private String concentration;
	
	public Education(String schoolName, Location location, Date startDate, Date endDate, String degreeName,
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

	public String getDegreeName() {
		return degreeName;
	}

	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
	}

	public String getConcentration() {
		return concentration;
	}

	public void setConcentration(String concentration) {
		this.concentration = concentration;
	}
	
	
}
