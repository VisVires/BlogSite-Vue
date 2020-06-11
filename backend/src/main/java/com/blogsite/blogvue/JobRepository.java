package com.blogsite.blogvue;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobRepository extends MongoRepository<Job, String>{

	public List<Job> findAll(Sort sort);
}
