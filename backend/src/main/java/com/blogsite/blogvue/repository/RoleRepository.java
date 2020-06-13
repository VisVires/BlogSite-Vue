package com.blogsite.blogvue.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.blogsite.blogvue.models.Role;
import com.blogsite.blogvue.models.RoleEnum;

public interface RoleRepository extends MongoRepository<Role, String>{

	Optional<Role> findByName(RoleEnum name);

}
