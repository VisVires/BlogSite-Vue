package com.blogsite.blogvue;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
	@GetMapping("/jobs")
	public List<Job> getJobs() {
		return jobRepository.findAll();
	}
	
	@CrossOrigin
	@GetMapping("/projects")
	public List<Project> getProjects() {
		return projectRepository.findAll();
	}
	
	@CrossOrigin
	@GetMapping("/education")
	public List<Degree> getEducation() {
		return degreeRepository.findAll();
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
	@PostMapping("/quotes")
	public String addQuotes(@RequestBody List<Quote> quotes) {
		LOG.info(String.format("Adding: %d Quotes", quotes.size())); 
		quoteRepository.saveAll(quotes);
		return String.format("Added: %d Quotes", quotes.size()); 
	}
	
	
	@CrossOrigin
	@GetMapping("/techBlog")
	public String getTechBlog() {
		return "Tech Blog";
	}
	
	@CrossOrigin
	@GetMapping("/travelBlog")
	public String getTravelBlog() {
		return "Travel Blog";
	}
}
