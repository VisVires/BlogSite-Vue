package com.blogsite.blogvue.models;

import java.util.Date;

import org.springframework.data.annotation.Id;

public abstract class BlogPost {
	
	@Id
	private String blogId;
	private String postTitle;
	private String text;
	private Date postDate;
	
	public BlogPost(String postTitle, String text, Date postDate) {
		super();
		this.postTitle = postTitle;
		this.text = text;
		this.postDate = postDate;
	}
	
	public String getBlogId() {
		return blogId;
	}

	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
}
