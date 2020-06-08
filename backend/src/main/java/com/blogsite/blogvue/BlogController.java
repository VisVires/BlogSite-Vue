package com.blogsite.blogvue;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogController {
	
	@Autowired
	private JobRepository jobRepository;
	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private DegreeRepository degreeRepository;
	//@Autowired
	//private BlogRepository blogRepository;
	
	@GetMapping("/jobs")
	public List<Job> getJobs() {
		return jobRepository.findAll();
	}
	
	@GetMapping("/projects")
	public List<Project> getProjects() {
		return projectRepository.findAll();
	}
	
	@GetMapping("/education")
	public List<Degree> getEducation() {
		return degreeRepository.findAll();
	}
	
	@GetMapping("/techBlog")
	public String getTechBlog() {
		return "Tech Blog";
	}
	
	@GetMapping("/travelBlog")
	public String getTravelBlog() {
		return "Travel Blog";
	}
}
