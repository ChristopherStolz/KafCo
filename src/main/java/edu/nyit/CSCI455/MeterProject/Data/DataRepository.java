package edu.nyit.CSCI455.MeterProject.Data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends MongoRepository<DataRun, String>{

}
