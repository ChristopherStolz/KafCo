package edu.nyit.CSCI455.MeterProject.Data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface DataRepository extends MongoRepository<DataRun, String>{

/**
 * TODO: Define database calls available
 * Update
 */
	public List<DataRun> findAll(); 
	public DataRun findByid(String id);
}
