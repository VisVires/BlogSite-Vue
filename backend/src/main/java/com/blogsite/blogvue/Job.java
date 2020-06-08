package com.blogsite.blogvue;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "jobs")
public class Job {
	
	@Id
	private String jobId;
	private String companyName;
	private String position; 
	private Date startDate;
	private Date endDate;
	private Location location;
	private ArrayList<String> responsibilities;
	private ArrayList<String> accomplishments;
	private ArrayList<String> technologies;
	
	public Job(String companyName, String position, Date startDate, Date endDate, Location location, ArrayList<String> responsibilities,
			ArrayList<String> accomplishments, ArrayList<String> technologies) {
		super();
		this.companyName = companyName;
		this.position = position;
		this.startDate = startDate;
		this.endDate = endDate;
		this.location = location;
		this.responsibilities = responsibilities;
		this.accomplishments = accomplishments;
		this.technologies = technologies;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public String getPosition() {
		return position;
	}
	
	public void setPosition(String position) {
		this.position = position;
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
	
	public ArrayList<String> getResponsibilities() {
		return responsibilities;
	}
	
	public void setResponsibilities(ArrayList<String> responsibilities) {
		this.responsibilities = responsibilities;
	}
	
	public ArrayList<String> getAccomplishments() {
		return accomplishments;
	}
	
	public void setAccomplishments(ArrayList<String> accomplishments) {
		this.accomplishments = accomplishments;
	}
	
	public ArrayList<String> getTechnologies() {
		return technologies;
	}
	
	public void setTechnologies(ArrayList<String> technologies) {
		this.technologies = technologies;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
}
