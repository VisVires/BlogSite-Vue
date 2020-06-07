package com.blogsite.blogvue;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.annotation.Id;

public class TravelBlog extends BlogPost {
	
	public TravelBlog(String postTitle, ArrayList<String> text, ArrayList<String> images, Date postDate) {
		super(postTitle, text, images, postDate);
		// TODO Auto-generated constructor stub
	}

}
