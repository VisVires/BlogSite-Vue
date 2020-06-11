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
	private String jobFunction;
	private ArrayList<String> attributes;
	private ArrayList<String> accomplishments;
	private String technologies;
	
	public Job(String companyName, String position, Date startDate, Date endDate, Location location, String jobFunction, ArrayList<String> attributes,
			ArrayList<String> accomplishments, String technologies) {
		super();
		this.companyName = companyName;
		this.position = position;
		this.startDate = startDate;
		this.endDate = endDate;
		this.location = location;
		this.jobFunction = jobFunction;
		this.attributes = attributes;
		this.accomplishments = accomplishments;
		this.technologies = technologies;
	}
	
	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
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
	
	public String getJobFunction() {
		return jobFunction;
	}

	public void setJobFunction(String jobFunction) {
		this.jobFunction = jobFunction;
	}

	public ArrayList<String> getAttributes() {
		return attributes;
	}
	
	public void setAttributes(ArrayList<String> attributes) {
		this.attributes = attributes;
	}
	
	public ArrayList<String> getAccomplishments() {
		return accomplishments;
	}
	
	public void setAccomplishments(ArrayList<String> accomplishments) {
		this.accomplishments = accomplishments;
	}
	
	public String getTechnologies() {
		return technologies;
	}
	
	public void setTechnologies(String technologies) {
		this.technologies = technologies;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
}
