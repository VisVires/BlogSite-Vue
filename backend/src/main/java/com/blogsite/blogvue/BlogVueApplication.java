package com.blogsite.blogvue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.blogsite.blogvue.models.Job;
import com.blogsite.blogvue.models.Location;
import com.blogsite.blogvue.models.Project;
import com.blogsite.blogvue.models.Role;
import com.blogsite.blogvue.models.RoleEnum;
import com.blogsite.blogvue.repository.DegreeRepository;
import com.blogsite.blogvue.repository.JobRepository;
import com.blogsite.blogvue.repository.ProjectRepository;
import com.blogsite.blogvue.repository.QuoteRepository;
import com.blogsite.blogvue.repository.RoleRepository;
import com.blogsite.blogvue.repository.TechBlogRepository;
import com.blogsite.blogvue.repository.UserRepository;

import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class BlogVueApplication implements CommandLineRunner {
	Logger LOG = LoggerFactory.getLogger(BlogVueApplication.class);
	
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
	@Autowired
	private RoleRepository roleRepository;
	@Autowired 
	private UserRepository userRepository;


	
	public static void main(String[] args) {
		SpringApplication.run(BlogVueApplication.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception { 
		
		deleteRepos();
		
		loadJobInfo();
		loadProjectInfo();
		loadRoles();
	}

	public void deleteRepos() {
		jobRepository.deleteAll();
		projectRepository.deleteAll();
		degreeRepository.deleteAll();
		techBlogRepository.deleteAll();
		quoteRepository.deleteAll();
		roleRepository.deleteAll();
		userRepository.deleteAll();
	}
	
	public void loadRoles() {
		roleRepository.save(new Role(RoleEnum.ROLE_USER));
		roleRepository.save(new Role(RoleEnum.ROLE_ADMIN));
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
		
		ArrayList<String> baeAttributes = new ArrayList<String>(Arrays.asList(
				"Big Data Managment, Tooling, and Migration",
				"RESTful API development",
				"Operational Monitoring and Resource Management"));
		
		String baeTechnologies = "Ansible, AWS Development/Cloud Tools, NoSQL and Graph Based data management, "
				+ "Jenkins continuous integration, Docker based Deployment/Containerization, Vue.js, Spring Boot, Maven, Git";
		
		ArrayList<String> visViresAccomplishments = new ArrayList<String>(Arrays.asList(
				"Maintained a healthy client base through word of mouth and social media advertising",
				"Developed Web applications alongside company website to ease day to day operations"));
		
		ArrayList<String> simulabAccomplishments = new ArrayList<String>(Arrays.asList(
				"Increased territory sales over 100%, leading company in Domestic Sales in 2013 and 2014",
				"Managed thousands of user accounts in MI, OH, ON, PA, DE, MD, DC",
				"Identified several new potential customers to grow company reach"));
		
		ArrayList<String> twentyFourAccomplishments = new ArrayList<String>(Arrays.asList(
				"Consistently in the top three in revenue generated at the highest grossing training gym in the nation for 4 years",
				"Worked with over 125 unique clients for more than 7000 sessions"));
		
		
		jobRepository.save(new Job("BAE Systems", "Software Development Engineer II", baeStart, null, 
				sanDiego, "Backend software development engineer with focus on creating and managing tools for a variety of tasks including: ", 
				baeAttributes, null, baeTechnologies));
		
		jobRepository.save(new Job("Vis Vires LLC", "Owner / Founder", visViresStart, visViresEnd, 
				seattle, "Founder of successful startup focused on providing health and fitness solutions for busy professionals", 
				null, visViresAccomplishments, null));
		
		jobRepository.save(new Job("Simulab Corporation", "Account Specialist", simulabStart, simulabEnd, 
				seattle, "Introducing and managing immersive training programs for a variety of procedures in hospitals and universities nationwide", null, simulabAccomplishments, null));
		
		jobRepository.save(new Job("24 Hour Fitness", "Master Personal Trainer", twentyFourStart, twentyFourEnd, 
				seattle, "Planning and managing fitness, and nutritional programming for working professionals", null, twentyFourAccomplishments, null));
		
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
			
			ArrayList<String> pinchAttributes = new ArrayList<String>(Arrays.asList(
					"Google DataStore for NoSQL Database", 
					"RESTful API/Backend Server built in Python and hosted on Google App Engine",
					"Android Interface for client side currently with Web and iOS interfaces currently under construction", 
					"Application built using Android SDK that uses OKHttp and AppAuth to communicate with custom API",
					"Google+ OAuth2.0 Integration with Java", 
					"Web Interface will be built using Google+ OAuth2.0 and NodeJS Express with Handlebars templating along with Bootstrap CSS3"));
			
			ArrayList<String> ftpAttributes = new ArrayList<String>(Arrays.asList(
					"Simple FTP client constructed with Python that can request server directory as well as individual files"));
			
			ArrayList<String> unityAttributes = new ArrayList<String>(Arrays.asList(
					"Acted as team lead organizing meetings with several team members and delegating responsibility",
					"Created Procedural Path/Map Generation Algorithm based on Conways Game of Life",
					"Created board generation script to generate randomized game boards with specified entry/exit points for enemies",
					"Added enemy tracking script for user weapons to follow and shoot at enemies across the board when enemies come within range"
					));
			
			ArrayList<String> howToAttributes = new ArrayList<String>(Arrays.asList(
					"Templating: handlebars.js, CSS3: Bootstrap, Framework: Node.js Express, Task Management: Grunt"));
			
			ArrayList<String> blogAttributes = new ArrayList<String>(Arrays.asList(
					"Bootstrap CSS3, Express Handlebars Templating, Grunt Task Management",
					"Individual Blog inputs read from backend JSON array which will eventually be ported to a NoSQL database",
					"Photography pulled from S3",
					"FB social commenting integration",
					"Hosted using AWS EC2 t2.nano instance, Route53 DNS service, and Cloudflare for CDN"));
			
			ArrayList<String> blogIIAttributes = new ArrayList<String>(Arrays.asList());
			
			ArrayList<String> smallShellAttributes = new ArrayList<String>(Arrays.asList(
					"Programmed in C to change directories, send processes to the background, bring background processes forward as well and exit"));
			
			ArrayList<String> gainzAttributes = new ArrayList<String>(Arrays.asList(
					"Built on Linked-List with individual links facing North, East, South and West",
					"Individual room types defined by abstract Room class"));
			
			ArrayList<String> fitnessAttributes = new ArrayList<String>(Arrays.asList(
					" Previously Hosted on Github Pages and SSL done by Cloudflare"));
			
			projectRepository.save(new Project("Blog Site v1","NodeJS application with Express Framework for personal, tech and fitness blog.",
					blogUrl, blogAttributes));
			
			projectRepository.save(new Project("Blog Site v2","Refactored Blog Site project constructed with Vue.js using a Spring Boot / MongoDB backend",
					blogIIUrl, blogIIAttributes));
			
			projectRepository.save(new Project("PinchTest Application","Application for calculating user body fat percentage using skin-fold measurments via the Siri equation",
					pinchTestUrl, pinchAttributes));
			
			projectRepository.save(new Project("FTP Server and Client","FTP server built in C to send file and directory contents to client via web sockets",
					ftpUrl, ftpAttributes));
			
			projectRepository.save(new Project("Unity 2D Tower Defense","2D Tower Defense Game created using Unity Game Engine for class project",
					unityUrl, unityAttributes));
			
			projectRepository.save(new Project("How To Guide","NodeJS Application built to explain server side analytics using universal analytics and the Google Analytics API",
					howToUrl, howToAttributes));
			
			projectRepository.save(new Project("Small Shell","Operating Systems class project to build small shell with limited functionality and some built-in functions",
					smallShellUrl, smallShellAttributes));
			
			projectRepository.save(new Project("Gainz The Game","Maze based RPG to demonstrate OOP concepts of Abstraction, Inheritance and Polymorphism",
					gainzUrl, gainzAttributes));
			
			projectRepository.save(new Project("Vis Vires Fitness Website","First website built using basic HTML5 and CSS3",
					fitnessUrl, fitnessAttributes));
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
