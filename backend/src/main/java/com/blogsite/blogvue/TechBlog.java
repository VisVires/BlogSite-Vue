package com.blogsite.blogvue;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tech_blog")
public class TechBlog extends BlogPost {
	
	public TechBlog(String postTitle, ArrayList<String> text, ArrayList<String> images, Date postDate) {
		super(postTitle, text, images, postDate);
		// TODO Auto-generated constructor stub
	}

}
