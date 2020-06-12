package com.blogsite.blogvue.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.blogsite.blogvue.models.Quote;

public interface QuoteRepository extends MongoRepository <Quote, String> {

}

