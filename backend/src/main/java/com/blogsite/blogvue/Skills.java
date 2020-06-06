package com.blogsite.blogvue;

import java.util.ArrayList;

public class Skills {
	
	ArrayList<String> techSkills;
	ArrayList<String> softSkills;
	
	public Skills(ArrayList<String> techSkills, ArrayList<String> softSkills) {
		super();
		this.techSkills = techSkills;
		this.softSkills = softSkills;
	}
	public ArrayList<String> getTechSkills() {
		return techSkills;
	}
	public void setTechSkills(ArrayList<String> techSkills) {
		this.techSkills = techSkills;
	}
	public ArrayList<String> getSoftSkills() {
		return softSkills;
	}
	public void setSoftSkills(ArrayList<String> softSkills) {
		this.softSkills = softSkills;
	}
}
