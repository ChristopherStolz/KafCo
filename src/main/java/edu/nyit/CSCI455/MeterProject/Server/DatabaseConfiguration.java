package edu.nyit.CSCI455.MeterProject.Server;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

import edu.nyit.CSCI455.MeterProject.Data.*;

@Configuration
@EnableMongoRepositories
class DatabaseConfiguration extends AbstractMongoConfiguration{
	@Override
	protected String getDatabaseName() {
		return "KafCo";
	}
	
	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient("127.0.0.1", 27017);
	}
	
	@Override
	protected String getMappingBasePackage() {
		return "edu.nyit.CSCI455.MeterProject.Data";
	}
}
