package com.blogsite.blogvue;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class BlogVueApplication implements CommandLineRunner {
	
	@Autowired
	private JobRepository jobRepository;
	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private DegreeRepository degreeRepository;
	@Autowired
	private SkillRepository skillRepository;
	@Autowired
	private BlogRepository blogRepository;

	
	public static void main(String[] args) {
		SpringApplication.run(BlogVueApplication.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception { 
		
		deleteRepos();
		
		loadJobInfo();
		loadProjectInfo();
		loadSkillInfo();
		loadSchoolInfo();
		loadBlogInfo();
	}

	public void deleteRepos() {
		jobRepository.deleteAll();
		projectRepository.deleteAll();
		skillRepository.deleteAll();
		degreeRepository.deleteAll();
		blogRepository.deleteAll();
	}
	
	public void loadJobInfo() {
		
		Date baeStart = new GregorianCalendar(2018, Calendar.FEBRUARY, 1).getTime();
		
		Date visViresStart = new GregorianCalendar(2012, Calendar.MARCH, 1).getTime();
		Date visViresEnd = new GregorianCalendar(2018, Calendar.FEBRUARY, 1).getTime();
		
		Date simulabStart = new GregorianCalendar(2011, Calendar.DECEMBER, 1).getTime();
		Date simulabEnd = new GregorianCalendar(2014, Calendar.AUGUST, 1).getTime();
	
		Date twentyFourStart = new GregorianCalendar(2008, Calendar.APRIL, 1).getTime();
		Date twentyFourEnd = new GregorianCalendar(2012, Calendar.APRIL, 1).getTime();
		
		
		
	}
	
	public void loadProjectInfo() {
		
	}
	
	public void loadSkillInfo() {
		
	}
	
	public void loadSchoolInfo() {
		
		Date osuStart = new GregorianCalendar(2014, Calendar.SEPTEMBER, 1).getTime();
		Date osuEnd = new GregorianCalendar(2017, Calendar.DECEMBER, 1).getTime();
		
		Date kellerStart = new GregorianCalendar(2010, Calendar.SEPTEMBER, 1).getTime();
		Date kellerEnd = new GregorianCalendar(2012, Calendar.DECEMBER, 1).getTime();
		
		Date uwStart = new GregorianCalendar(2003, Calendar.SEPTEMBER, 1).getTime();
		Date uwEnd = new GregorianCalendar(2008, Calendar.JUNE, 13).getTime();
	
		Location uwLocation = new Location("Seattle", "Washington");
		Location osuLocation = new Location("Corvalis", "Oregon");
		Location kellerLocation = new Location("Federal Way", "Washington");
		
		degreeRepository.save(new Degree("Oregon State University", osuLocation, osuStart, 
				osuEnd, "Bachelor of Science: Computer Science", 3.98));
		
		degreeRepository.save(new Degree("Keller Institute of Management", kellerLocation, kellerStart, 
				kellerEnd, "Master of Business Administration",
				"Information Systems Management", 3.92));
		
		degreeRepository.save(new Degree("University of Washington",uwLocation, uwStart, 
				uwEnd, "Bachelor of Science : Molecular, Cellular and Developmental Biology", 3.46));
		
		degreeRepository.save(new Degree("University of Washington",uwLocation, uwStart, 
				uwEnd, "Bachelor of Arts : Psychology", 3.46));
	}
	
	public void loadBlogInfo() {
		
	}
}
