package com.blogsite.blogvue;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "degrees")
public class Degree {
	
	
	@Id
	private String schoolId;
	private String schoolName;
	private Location location;
	private Date startDate;
	private Date endDate;
	private String degreeName;
	private String concentration;
	private Double average;
	
	public Degree(String schoolName, Location location, Date startDate, Date endDate, String degreeName,
			String concentration, Double average) {
		super();
		this.schoolName = schoolName;
		this.location = location;
		this.startDate = startDate;
		this.endDate = endDate;
		this.degreeName = degreeName;
		this.concentration = concentration;
		this.average = average;
	}
	
	public Degree(String schoolName, Location location, Date startDate, Date endDate, String degreeName,
			Double average) {
		super();
		this.schoolName = schoolName;
		this.location = location;
		this.startDate = startDate;
		this.endDate = endDate;
		this.degreeName = degreeName;
		this.average = average;
	}
	
	@Override
	public String toString() {
		return String.format(
		        "School[schoolId=%s, schoolName='%s', degreeName='%s', city='%s', state='%s']",
		        schoolId, schoolName, degreeName, location.toString());
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

	public String getSchoolId() {
		return schoolId;
	}

	public Double getAverage() {
		return average;
	}
	
	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

	public void setAverage(Double average) {
		this.average = average;
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
