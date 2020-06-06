package com.blogsite.blogvue;

import org.springframework.web.bind.annotation.*;

@RestController
public class BlogController {
	
	@GetMapping("/jobs")
	public String getJobs() {
		return "Jobs";
	}
	
	@GetMapping("/projects")
	public String getProjects() {
		return "Projects";
	}
	
	@GetMapping("/education")
	public String getEducation() {
		return "Education";
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
