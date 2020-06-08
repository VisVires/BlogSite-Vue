package com.blogsite.blogvue;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SkillRepository extends MongoRepository<Skill, String>{
	
	public List<Skill> findSkillByType(String skillType);
}
