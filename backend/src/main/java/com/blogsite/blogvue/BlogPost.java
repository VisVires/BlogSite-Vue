package com.blogsite.blogvue;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.annotation.Id;

public abstract class BlogPost {
	
	@Id
	private String blogId;
	private String postTitle;
	private ArrayList<String> text;
	private ArrayList<String> images;
	private Date postDate;
	
	public BlogPost(String postTitle, ArrayList<String> text, ArrayList<String> images, Date postDate) {
		super();
		this.postTitle = postTitle;
		this.text = text;
		this.images = images;
		this.postDate = postDate;
	}
	
	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public ArrayList<String> getText() {
		return text;
	}

	public void setText(ArrayList<String> text) {
		this.text = text;
	}

	public ArrayList<String> getImages() {
		return images;
	}

	public void setImages(ArrayList<String> images) {
		this.images = images;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
}
