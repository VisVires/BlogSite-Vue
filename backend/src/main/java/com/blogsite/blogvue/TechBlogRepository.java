package com.blogsite.blogvue;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface TechBlogRepository extends MongoRepository <TechBlog, String> {

	List<TechBlog> findAll(Sort sort);	
}
