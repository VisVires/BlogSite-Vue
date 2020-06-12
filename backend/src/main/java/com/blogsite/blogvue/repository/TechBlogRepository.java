package com.blogsite.blogvue.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.blogsite.blogvue.models.TechBlog;


public interface TechBlogRepository extends MongoRepository <TechBlog, String> {

	List<TechBlog> findAll(Sort sort);	
}
