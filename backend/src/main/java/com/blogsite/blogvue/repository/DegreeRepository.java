package com.blogsite.blogvue.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.blogsite.blogvue.models.Degree;

public interface DegreeRepository extends MongoRepository<Degree, String>{

	public List<Degree> findAll(Sort sort);
}
