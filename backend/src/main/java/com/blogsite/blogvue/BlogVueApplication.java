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


	
	public static void main(String[] args) {
		SpringApplication.run(BlogVueApplication.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception { 
		
		deleteRepos();
		
		loadJobInfo();
		loadProjectInfo();
		loadDegreeInfo();
		loadQuotes();
		loadBlogInfo();
	}

	public void deleteRepos() {
		jobRepository.deleteAll();
		projectRepository.deleteAll();
		degreeRepository.deleteAll();
		techBlogRepository.deleteAll();
		quoteRepository.deleteAll();
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
			
			projectRepository.save(new Project("PinchTest Application","Application for calculating user body fat percentage using skin-fold measurments via the Siri equation",
					pinchTestUrl, pinchAttributes));
			
			projectRepository.save(new Project("FTP Server and Client","FTP server built in C to send file and directory contents to client via web sockets",
					ftpUrl, ftpAttributes));
			
			projectRepository.save(new Project("Unity 2D Tower Defense","2D Tower Defense Game created using Unity Game Engine for class project",
					unityUrl, unityAttributes));
			
			projectRepository.save(new Project("How To Guide","NodeJS Application built to explain server side analytics using universal analytics and the Google Analytics API",
					howToUrl, howToAttributes));
			
			projectRepository.save(new Project("Blog Site v1","NodeJS application with Express Framework for personal, tech and fitness blog.",
					blogUrl, blogAttributes));
			
			projectRepository.save(new Project("Blog Site v2","Refactored Blog Site project constructed with Vue.js using a Spring Boot / MongoDB backend",
					blogIIUrl, blogIIAttributes));
			
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
		String samplePost = "* * *\n" + 
				"**A Summary of the AWS White Paper**\n" + 
				"\n" + 
				"* * *\n" + 
				"\n" + 
				"### The Five Pillars\n" + 
				"\n" + 
				"When working with a distributed computing architecture there are five-pillars you should focus on in order for it to operate at the optimal capacity. Each pillar has it's own design principles and best practices from which to operate and AWS offers tools and services to help with the implementation of each principle. The pillars are as follows:\n" + 
				"\n" + 
				"*   Operational Excellence\n" + 
				"*   Security\n" + 
				"*   Reliability\n" + 
				"*   Performance Efficiency\n" + 
				"*   Cost Optimization\n" + 
				"\n" + 
				"For each of these I will do a brief overview of the design principles and the best practices as outlined by the white paper itself.\n" + 
				"\n" + 
				"* * *\n" + 
				"\n" + 
				"### Operational Excellence\n" + 
				"\n" + 
				"#### Design Principles\n" + 
				"\n" + 
				"*   Perform operation as code – Define entire environment and workload as code to reduce human error and enable consistent responses\n" + 
				"*   Annotate Documentation – Automate the creation of documentation after every build\n" + 
				"*   Refine operation procedures frequently- Always look for opportunities for improvement and evolve procedures to facilitate improvement\n" + 
				"*   Make frequent, small reversible changes – Making small changes allows for components to be updated frequently\n" + 
				"*   Anticipate Failure – Always test failure response procedures and perform exercises to identify sources of failure.\n" + 
				"*   Learn from all operations failures- drive improvements through lessons learned\n" + 
				"\n" + 
				"#### Best Practices\n" + 
				"\n" + 
				"##### Prepare\n" + 
				"\n" + 
				"*   Have shared goals and understanding across every part of the business\n" + 
				"*   Design your system to monitor all aspects of the application, infrastructure and customer experience\n" + 
				"*   Design method by to validate application is ready for production and to be supported by operations\n" + 
				"*   Be sure to have sufficient trained personnel to support the workloads\n" + 
				"*   Test and practice response to operational events and failures\n" + 
				"\n" + 
				"##### Operate\n" + 
				"\n" + 
				"*   Measure operational health and success by the achievement of business and customer outcomes using custom dashboards to manage expectations and inform of normal operations\n" + 
				"*   Prioritize responses based on business and customer impact\n" + 
				"*   Determine cause of unplanned events and update procedures to facilitate for them\n" + 
				"*   Routine and responses to unplanned events should be automated\n" + 
				"\n" + 
				"##### Evolve\n" + 
				"\n" + 
				"*   Dedicate work cycles to continuous incremental improvements\n" + 
				"*   Evaluate and prioritize improvement opportunities in both workload and operations procedures\n" + 
				"*   Share lessons across to teams to share benefits\n" + 
				"*   Make frequent small improvements with a safe environment from which to experiment, develop and test improvements\n" + 
				"\n" + 
				"* * *\n" + 
				"\n" + 
				"### Security\n" + 
				"\n" + 
				"#### Design Principles\n" + 
				"\n" + 
				"*   Implement a strong identity foundation by separating duties, giving individuals the least privilege needed, centralizing privilege management and reducing long-term credentials.\n" + 
				"*   Enable traceability by monitoring, alerting and auditing all changes and integrating logs and metrics to respond.\n" + 
				"*   Apply security at each layer of the application from the network to the operating system of each specific instance\n" + 
				"*   Automate best practices\n" + 
				"*   Protect data at data and at rest by limiting human interaction and classifying data into sensitivity levels using encryption and tokenization.\n" + 
				"*   Prepare for security events and have an incident management process that aligns with organization requirements\n" + 
				"\n" + 
				"#### Best Practices\n" + 
				"\n" + 
				"*   Identity and Access Management – allow only authorized and authenticated users to access resources in only the manner intended (R/W/Execute)\n" + 
				"*   Detective Controls – use to identify potential security incidents with reactive tools to identify and understand anomalous activity\n" + 
				"*   Infrastructure Protection – Defend the infrastructure at all layers and enforce rules to increase security even further like Multi-Factor Authorization\n" + 
				"*   Data Protection – Before designing a system define rules for data classification and encryption\n" + 
				"*   Incident Response – Isolate and contain systems to restore operations to a good known state and routinely practice incident responses\n" + 
				"\n" + 
				"* * *\n" + 
				"\n" + 
				"### Reliability\n" + 
				"\n" + 
				"#### Design Principles\n" + 
				"\n" + 
				"*   Use automation in the cloud to simulate and recreate failures then test recovery procedures\n" + 
				"*   Automatically recover from failure by monitoring system for key performance indicators and triggering recovery mechanisms when certain thresholds are breached\n" + 
				"*   Scale horizontally to increase aggregate system availability by distributing requests across several smaller resources so one point of failure has a smaller impact on the overall system\n" + 
				"*   Stop guessing capacity and automate addition and removal of resources\n" + 
				"*   Manage changes to the system using automation\n" + 
				"\n" + 
				"#### Best Practices\n" + 
				"\n" + 
				"*   Foundations – set foundational requirements that influence reliability before architecting a system, understand that cloud is limitless and that limits for networking and computing capacity may change over time\n" + 
				"*   Change Management – Monitor trends that could lead to capacity issues and add or remove resources as needed using automated responses to key performance indicators to increase reliability and ensure that business success doesn’t become a burden\n" + 
				"*   Failure Management – Automate reactions to monitoring data, perform regular backups and test backups to cause failures and ensure you can recover from physical and logical errors\n" + 
				"\n" + 
				"* * *\n" + 
				"\n" + 
				"### Perfomance Efficiency\n" + 
				"\n" + 
				"#### Design Principles\n" + 
				"\n" + 
				"*   Democratize advance technologies by pushing them onto the cloud and using them as a service rather than trying to learn to host and run it\n" + 
				"\n" + 
				"*   Use serverless architectures to remove the need to run and maintain servers for traditional compute activities and lower transactional costs\n" + 
				"*   Experiment more often by carrying out comparative testing with different types of instances, storage types and different configurations\n" + 
				"*   Use the technologies that best align with what you’re trying to achieve like data access patterns with databases and other storage approaches.\n" + 
				"\n" + 
				"#### Best Practices\n" + 
				"\n" + 
				"**Select multiple solutions from the different resource types to improve performance. The four main resource types are:**\n" + 
				"\n" + 
				"**Compute** – varies based on application design, usage patterns and configuration settings and available in three different forms:\n" + 
				"*   Instances – virtualized servers\n" + 
				"*   Containers – resource isolated processes using operating system virtualization\n" + 
				"*   Functions – abstracted execution environment from the code\n" + 
				"\n" + 
				"**Storage** – varies based on access methods, patterns of access, throughput, frequency of access, update frequency, availability and durability constraints.\n" + 
				"\n" + 
				"**Database** – varies based on availability, consistency, partition tolerance, latency, durability, scalability and query capability. Available in 3 forms:\n" +  
				"*   Managed Relational Databases – Database with tables, rows and columns with relational backbone\n" + 
				"*   NoSQL Databases – key, value based pairs\n" + 
				"*   Data Warehouses – means of changing the types and number of nodes as performance and capacity needs change\n" + 
				"\n" + 
				"**Network** – Varies based on latency and throughput requirements where physical constraints such as resource placement and location play big factors.\n" + 
				"\n" + 
				"**Once you've selected the appropriate resource types you can increase efficiency further by:**\n" +
				"*   Reviewing architecture and performance and understand where bottlenecks are so you can look for tools to alleviate those constraints\n" + 
				"*   Setting monitors to raise alarms when thresholds are reached and set off automated triggers to work around poorly performing components\n" + 
				"*   Trading consistency, availability, durability, space, time, and/or latency to deliver higher performance that aligns with business goals and test the trade-offs to ensure a measurable benefit it obtained.\n" + 
				"\n" + 
				"* * *\n" + 
				"\n" + 
				"### Cost Optimization\n" + 
				"\n" + 
				"#### Design Principles\n" + 
				"\n" + 
				"*   Adopt a consumption model so that you only pay for the computing resources you consume.\n" + 
				"*   Measure overall efficiency by monitoring the business output of the system and the costs associated with it\n" + 
				"*   Stop spending money on data center operations and allow a cloud service to manage hardware for you\n" + 
				"*   Analyze and attribute expenditure to measure return on investment\n" + 
				"*   Use managed services to remove the operational burden of maintaining servers for menial tasks\n" + 
				"\n" + 
				"#### Best Practices\n" + 
				"\n" + 
				"*   Cost Effective Resources – Use the most cost effective resources\n" + 
				"*   Match Supply and Demand – Actively think about patterns of usage and time to provision new resources so you can add and remove resources as needed\n" + 
				"*   Expenditure Awareness - Because you no longer have to think about the cost of manual processes associated with on-campus infrastructure you can now use tags to categorize and track costs of cloud resources and determine what resources or products are no longer generating income\n" + 
				"*   Optimize over time – As requirements change be aggressive in decommissioning resources and services no longer needed and be aware of new services and how they could save you money\n" + 
				"\n" + 
				"* * *";
		Date blogDate = new GregorianCalendar(2020, Calendar.JUNE, 10).getTime();
		techBlogRepository.save(new TechBlog("A Well Architected Framework", samplePost, blogDate));
		LOG.info("Loaded Sample post");
	}
	
	public void loadQuotes() {
		quoteRepository.save(new Quote("Beta is latin for still doesn't work", "Unknown", null));
		quoteRepository.save(new Quote("Debugging is twice as hard as writing the code in the first place. "
				+ "Therefore, if you write the code as cleverly as possible, you are, by definition, not smart enough to debug it.", "Brian W. Kernighan", null));
		quoteRepository.save(new Quote("If computers get too powerful, we can organize them into committees. That'll do them in", "Unknown", null));
	}
}
