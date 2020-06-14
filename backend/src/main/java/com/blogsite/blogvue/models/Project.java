package com.blogsite.blogvue.models;

import java.net.URL;
import java.util.ArrayList;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "projects")
public class Project {

	
	@Id
	private String projectId;
	@NotNull(message = "Project Name is mandatory")
	private String projectName;
	@NotNull(message = "Project Purpose is mandatory")
	private String purpose;
	@NotNull(message = "Project repo address is mandatory")
	private URL repoAddress;
	private ArrayList<String> attributes;
	
	public Project(String projectName, String purpose, URL repoAddress, ArrayList<String> attributes) {
		super();
		this.projectName = projectName;
		this.purpose = purpose;
		this.repoAddress = repoAddress;
		this.attributes = attributes;
	}
	
	@Override
	public String toString() {
		return String.format(
		        "Project[projectId=%s, projectName='%s', purpose='%s', repoAddress='%s']",
		        projectId, projectName, purpose, repoAddress.toString());
	}

	public String getProjectId() {
		return projectId;
	}
	
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public URL getRepoAddress() {
		return repoAddress;
	}

	public void setRepoAddress(URL repoAddress) {
		this.repoAddress = repoAddress;
	}

	public ArrayList<String> getAttributes() {
		return attributes;
	}

	public void setAttributes(ArrayList<String> attributes) {
		this.attributes = attributes;
	}
}
