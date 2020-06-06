package com.blogsite.blogvue;

import java.util.ArrayList;
import java.util.Date;

public class BlogPost {
	
	private ArrayList<String> text;
	private ArrayList<String> images;
	private Date postDate;
	
	public BlogPost(ArrayList<String> text, ArrayList<String> images, Date postDate) {
		super();
		this.text = text;
		this.images = images;
		this.postDate = postDate;
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
