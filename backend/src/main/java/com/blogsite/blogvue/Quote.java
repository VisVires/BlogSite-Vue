package com.blogsite.blogvue;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "quotes")
public class Quote {
	
	@Id
	private String quoteId;
	private String quote;
	private String author;
	private Integer year;
	private String reference;
	
	public Quote() {}
	
	public Quote(String quote, String author, String reference) {
		super();
		this.quote = quote;
		this.author = author;
		this.reference = reference;
	}
	
	public Quote(String quote, String author, String reference, Integer year) {
		super();
		this.quote = quote;
		this.author = author;
		this.reference = reference;
		this.year = year;
	}

	public String getQuoteId() {
		return quoteId;
	}

	public void setQuoteId(String quoteId) {
		this.quoteId = quoteId;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}
}
