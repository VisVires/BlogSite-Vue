package com.blogsite.blogvue.controller;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.blogsite.blogvue.models.Degree;
import com.blogsite.blogvue.models.Job;
import com.blogsite.blogvue.models.MessageResponse;
import com.blogsite.blogvue.models.Project;
import com.blogsite.blogvue.models.Quote;
import com.blogsite.blogvue.models.TechBlog;
import com.blogsite.blogvue.repository.DegreeRepository;
import com.blogsite.blogvue.repository.JobRepository;
import com.blogsite.blogvue.repository.ProjectRepository;
import com.blogsite.blogvue.repository.QuoteRepository;
import com.blogsite.blogvue.repository.TechBlogRepository;


@RestController
public class BlogController {
	Logger LOG = LoggerFactory.getLogger(BlogController.class);
	
	@Autowired
	private JobRepository jobRepository;
	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private DegreeRepository degreeRepository;
	@Autowired
	private TechBlogRepository techBlogRepository;
	@Autowired
	private QuoteRepository quoteRepository;
	
	@CrossOrigin
	@PostMapping("/addJob")
	@PreAuthorize("hasRole('ADMIN')")
	public Job addJob(@RequestBody Job job) {
		jobRepository.save(job);
		return job;
	}
	
	@CrossOrigin
	@GetMapping("/jobs")
	public List<Job> getJobs() {
		LOG.info(String.format("Getting Employment History"));
		return jobRepository.findAll(Sort.by(Sort.Direction.DESC, "startDate"));
	}
	
	@CrossOrigin
	@PostMapping("/addJobs")
	public List<Job> addJobs(@RequestBody List<Job> jobs) {
		jobRepository.saveAll(jobs);
		return jobs;
	}
	
	@CrossOrigin
	@PostMapping("/addProject")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<MessageResponse> addProject(@RequestBody Project project) {
		if (projectRepository.existsByProjectName(project.getProjectName())) {
			return ResponseEntity
				.badRequest()
				.body(new MessageResponse("Error: Project Name is already taken!"));
		}
		LOG.info(String.format("Saving Project %s", project.getProjectName()));
		projectRepository.save(project);
		return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(
				String.format("Project Added %s", project.getProjectName())));
	}
	
	@CrossOrigin
	@GetMapping("/projects")
	public List<Project> getProjects() {
		LOG.info(String.format("Getting Projects"));
		return projectRepository.findAll();
	}
	
	@CrossOrigin
	@PostMapping("/addProjects")
	@PreAuthorize("hasRole('ADMIN')")
	public List<Project> addProjects(@RequestBody List<Project> projects) {
		projectRepository.saveAll(projects);
		return projects;
	}
	
	@CrossOrigin
	@GetMapping("/education")
	public List<Degree> getEducation() {
		LOG.info(String.format("Getting Education"));
		return degreeRepository.findAll(Sort.by(Sort.Direction.DESC, "startDate"));
	}
	
	@CrossOrigin
	@PostMapping("/addDegrees")
	@PreAuthorize("hasRole('ADMIN')")
	public List<Degree> addDegrees(@RequestBody List<Degree> degrees) {
		degreeRepository.saveAll(degrees);
		return degrees;
	}
	
	@CrossOrigin
	@GetMapping("/quote")
	public ResponseEntity<?> getRandomQuote() {
		List<Quote> quotes = quoteRepository.findAll();
		if(quotes.size() > 0) { 
			Calendar cal = Calendar.getInstance();
			int weekNum  = cal.get(Calendar.WEEK_OF_YEAR);
			Random rand = new Random(weekNum);
			int r = rand.ints(0, quotes.size()).findFirst().getAsInt();
			LOG.info(String.format("The quote for the week is: %s", quotes.get(r).getQuote()));
			return new ResponseEntity<>(quotes.get(r), HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		}
	}
	
	@CrossOrigin
	@PostMapping("/addQuote")
	@PreAuthorize("hasRole('ADMIN')")
	public String addQuote(@RequestBody Quote quote) {
		LOG.info(String.format("Adding: %s", quote.getQuote())); 
		quoteRepository.save(quote);
		return quote.getQuote();
	}
	
	@CrossOrigin
	@GetMapping("/quotes")
	public List<Quote> getQuotes() {
		return quoteRepository.findAll();
	}
	
	@CrossOrigin
	@PostMapping("/addQuotes")
	@PreAuthorize("hasRole('ADMIN')")
	public String addQuotes(@RequestBody List<Quote> quotes) {
		LOG.info(String.format("Adding: %d Quotes", quotes.size())); 
		quoteRepository.saveAll(quotes);
		return String.format("Added: %d Quotes", quotes.size()); 
	}
	
	
	@CrossOrigin
	@GetMapping("/techBlog")
	public List<TechBlog> getTechBlog() {
		LOG.info(String.format("Getting Tech Blog Posts"));
		return techBlogRepository.findAll(Sort.by(Sort.Direction.DESC, "postDate"));
	}
	
	@CrossOrigin
	@PostMapping("/addTechBlog")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<MessageResponse> writeTechPost(@RequestBody TechBlog techBlog) {
		if (techBlogRepository.existsByPostTitle(techBlog.getPostTitle())) {
			return ResponseEntity
				.badRequest()
				.body(new MessageResponse("Error: Post Title has been taken!"));
		}	
		LOG.info(String.format("Writing %s to Database", techBlog.getPostTitle()));
		techBlogRepository.save(techBlog);
		return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(
				String.format("Post Added %s", techBlog.getPostTitle())));
	}
	
	@CrossOrigin
	@GetMapping("/travelBlog")
	public String getTravelBlog() {
		return "Travel Blog";
	}
}
