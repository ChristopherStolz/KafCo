package edu.nyit.CSCI455.MeterProject;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DataRepository extends MongoRepository<DataRun, String>{
/**
 * TODO: Define database algorithms (growing with additional entries)
 **/
}
