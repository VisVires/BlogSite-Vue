package com.blogsite.blogvue.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.blogsite.blogvue.models.Job;

public interface JobRepository extends MongoRepository<Job, String>{

	public List<Job> findAll(Sort sort);
}
