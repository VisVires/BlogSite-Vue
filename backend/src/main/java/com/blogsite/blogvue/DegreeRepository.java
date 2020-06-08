package com.blogsite.blogvue;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DegreeRepository extends MongoRepository<Degree, String>{

	public List<Degree> findAll();
}
