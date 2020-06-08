package com.blogsite.blogvue;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlogRepository extends MongoRepository <BlogPost, String> {

	
}
