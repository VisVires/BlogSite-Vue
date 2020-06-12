package com.blogsite.blogvue.controller;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import com.blogsite.blogvue.models.Degree;
import com.blogsite.blogvue.models.Job;
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
	@PostMapping("/job")
	public Job addJob(@RequestBody Job job) {
		jobRepository.save(job);
		return job;
	}
	
	@CrossOrigin
	@GetMapping("/jobs")
	public List<Job> getJobs() {
		return jobRepository.findAll(Sort.by(Sort.Direction.DESC, "startDate"));
	}
	
	@CrossOrigin
	@PostMapping("/jobs")
	public List<Job> addJobs(@RequestBody List<Job> jobs) {
		jobRepository.saveAll(jobs);
		return jobs;
	}
	
	@CrossOrigin
	@PostMapping("/project")
	public Project addProject(@RequestBody Project project) {
		projectRepository.save(project);
		return project;
	}
	
	@CrossOrigin
	@GetMapping("/projects")
	public List<Project> getProjects() {
		return projectRepository.findAll();
	}
	
	@CrossOrigin
	@PostMapping("/projects")
	public List<Project> addProjects(@RequestBody List<Project> projects) {
		projectRepository.saveAll(projects);
		return projects;
	}
	
	@CrossOrigin
	@GetMapping("/education")
	public List<Degree> getEducation() {
		return degreeRepository.findAll(Sort.by(Sort.Direction.DESC, "startDate"));
	}
	
	@CrossOrigin
	@GetMapping("/quote")
	public Quote getRandomQuote() {
		List<Quote> quotes = quoteRepository.findAll();
		// get week number
		Calendar cal = Calendar.getInstance();
		int weekNum  = cal.get(Calendar.WEEK_OF_YEAR);
		Random rand = new Random(weekNum);
		int r = rand.ints(0, quotes.size()).findFirst().getAsInt();
		LOG.info(String.format("The quote for the week is: %s", quotes.get(r).getQuote()));
		return quotes.get(r);
	}
	
	@CrossOrigin
	@PostMapping("/quote")
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
	@PostMapping("/quotes")
	public String addQuotes(@RequestBody List<Quote> quotes) {
		LOG.info(String.format("Adding: %d Quotes", quotes.size())); 
		quoteRepository.saveAll(quotes);
		return String.format("Added: %d Quotes", quotes.size()); 
	}
	
	
	@CrossOrigin
	@GetMapping("/techBlog")
	public List<TechBlog> getTechBlog() {
		return techBlogRepository.findAll(Sort.by(Sort.Direction.DESC, "postDate"));
	}
	
	@CrossOrigin
	@PostMapping("/techBlog")
	public TechBlog writeTechPost(@RequestBody TechBlog techBlog) {
		LOG.info(String.format("Writing %s to Database", techBlog.getPostTitle()));
		return techBlogRepository.save(techBlog);
	}
	
	@CrossOrigin
	@PostMapping("/auth/signin")
	public TechBlog signin(@RequestBody TechBlog techBlog) {
		LOG.info(String.format("Signing in to Admin page"));
		return techBlogRepository.save(techBlog);
	}
	
	
	
	@CrossOrigin
	@GetMapping("/travelBlog")
	public String getTravelBlog() {
		return "Travel Blog";
	}
}
