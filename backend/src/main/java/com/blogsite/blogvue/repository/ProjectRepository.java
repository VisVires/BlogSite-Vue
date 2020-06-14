package com.blogsite.blogvue.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.blogsite.blogvue.models.Project;

public interface ProjectRepository extends MongoRepository<Project, String>{

	public List<Project> findAll();

	public boolean existsByProjectName(String projectName);
}
