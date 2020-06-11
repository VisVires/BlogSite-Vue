package com.blogsite.blogvue;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tech_blog")
public class TechBlog extends BlogPost {
	
	public TechBlog(String postTitle, String text, Date postDate) {
		super(postTitle, text, postDate);
		// TODO Auto-generated constructor stub
	}

}
