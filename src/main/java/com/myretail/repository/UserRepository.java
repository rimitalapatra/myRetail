package com.myretail.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.myretail.model.reatilProductName;

@Repository
public interface UserRepository extends MongoRepository<reatilProductName, Integer> {
	

}
