package com.blogsite.blogvue;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TechBlogRepository extends MongoRepository <TechBlog, String> {

	
}
