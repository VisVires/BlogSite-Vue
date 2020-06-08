package com.blogsite.blogvue;

import java.net.MalformedURLException;
import java.net.URL;
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
	private BlogRepository blogRepository;

	
	public static void main(String[] args) {
		SpringApplication.run(BlogVueApplication.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception { 
		
		deleteRepos();
		
		loadJobInfo();
		loadProjectInfo();
		loadDegreeInfo();
		loadBlogInfo();
	}

	public void deleteRepos() {
		jobRepository.deleteAll();
		projectRepository.deleteAll();
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
		
		Location sanDiego = new Location("San Diego", "CA");
		Location seattle = new Location("Seattle", "WA");
		
		jobRepository.save(new Job("BAE Systems", "Software Development Engineer II", baeStart, null, 
				sanDiego, null, null, null));
		
		jobRepository.save(new Job("Vis Vires LLC", "Owner / Founder", visViresStart, visViresEnd, 
				seattle, null, null, null));
		
		jobRepository.save(new Job("Simulab Corporation", "Account Specialist", simulabStart, simulabEnd, 
				seattle, null, null, null));
		
		jobRepository.save(new Job("24 Hour Fitness", "Master Personal Trainer", twentyFourStart, twentyFourEnd, 
				seattle, null, null, null));
		
	}
	
	public void loadProjectInfo() {
		
		try {
			URL pinchTestUrl = new URL("https://github.com/VisVires/PinchTest");
			URL ftpUrl = new URL("https://github.com/VisVires/FTP_Server-Client");
			URL unityUrl = new URL("https://github.com/VisVires/UnityTowerDefense");
			URL howToUrl = new URL("https://github.com/VisVires/HowToGuide");
			URL blogUrl = new URL("https://github.com/VisVires/blogSite");
			URL blogIIUrl = new URL("https://github.com/VisVires/BlogSite-Vue");
			URL smallShellUrl = new URL("https://github.com/VisVires/smallShell");
			URL gainzUrl = new URL("https://github.com/VisVires/GainzTheGame");
			URL fitnessUrl = new URL("https://github.com/VisVires/VisVires.github.io");
			
			projectRepository.save(new Project("PinchTest Application","Application for calculating user body fat percentage using skin-fold measurments via the Siri equation",
					pinchTestUrl, null));
			
			projectRepository.save(new Project("FTP Server and Client","FTP server built in C to send file and directory contents to client via web sockets",
					ftpUrl, null));
			
			projectRepository.save(new Project("Unity 2D Tower Defense","2D Tower Defense Game created using Unity Game Engine for class project",
					unityUrl, null));
			
			projectRepository.save(new Project("How To Guide","NodeJS Application built to explain server side analytics using universal analytics and the Google Analytics API",
					howToUrl, null));
			
			projectRepository.save(new Project("Blog Site v1","NodeJS application with Express Framework for personal, tech and fitness blog.",
					blogUrl, null));
			
			projectRepository.save(new Project("Blog Site v2","Refactored Blog Site project constructed with Vue.js using a Spring Boot / MongoDB backend",
					blogIIUrl, null));
			
			projectRepository.save(new Project("Small Shell","Operating Systems class project to build small shell with limited functionality and some built-in functions",
					smallShellUrl, null));
			
			projectRepository.save(new Project("Gainz The Game","Maze based RPG to demonstrate OOP concepts of Abstraction, Inheritance and Polymorphism",
					gainzUrl, null));
			
			projectRepository.save(new Project("Vis Vires Fitness Website","First website built using basic HTML5 and CSS3",
					fitnessUrl, null));
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	
	public void loadDegreeInfo() {
		
		Date osuStart = new GregorianCalendar(2014, Calendar.SEPTEMBER, 1).getTime();
		Date osuEnd = new GregorianCalendar(2017, Calendar.DECEMBER, 1).getTime();
		
		Date kellerStart = new GregorianCalendar(2010, Calendar.SEPTEMBER, 1).getTime();
		Date kellerEnd = new GregorianCalendar(2012, Calendar.DECEMBER, 1).getTime();
		
		Date uwStart = new GregorianCalendar(2003, Calendar.SEPTEMBER, 1).getTime();
		Date uwEnd = new GregorianCalendar(2008, Calendar.JUNE, 13).getTime();
	
		Location uwLocation = new Location("Seattle", "WA");
		Location osuLocation = new Location("Corvallis", "OR");
		Location kellerLocation = new Location("Federal Way", "WA");
		
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
