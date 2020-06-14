package com.blogsite.blogvue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		loadRoles();
		loadRootUser();
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
	
	public void loadRootUser() {
		
	}
}
