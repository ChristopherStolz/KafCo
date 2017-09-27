package edu.nyit.CSCI455.MeterProject;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DataRepository extends MongoRepository<DataRun, String>{
/**
 * TODO: Define database calls available
 * Update
 **/
	public DataRun findByDate (String date);
	public DataRun findByMeterName (String meterName);
}
