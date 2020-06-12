package com.blogsite.blogvue.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "skills")
public class Skill {
	
	@Id
	private String skillId;
	private String skillName;
	private String skillType;
	
	public Skill(String skillId, String skillName, String skillType) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
		this.skillType = skillType;
	}
	
	public String getSkillId() {
		return skillId;
	}
	
	public void setSkillId(String skillId) {
		this.skillId = skillId;
	}
	
	public String getSkillName() {
		return skillName;
	}
	
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	
	public String getSkillType() {
		return skillType;
	}
	
	public void setSkillType(String skillType) {
		this.skillType = skillType;
	}
}
