package edu.nyit.CSCI455.MeterProject.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@EnableMongoRepositories(basePackages = "edu.nyit.CSCI455.MeterProject.Data")
@Service
@Component
public class DataService {
	@Autowired DataRepository dataRepository;
	
	public DataRun save (DataRun data){

		System.out.println("This is my repository" + dataRepository.toString());
		
		dataRepository.save(data);
		
		return data;
	}

}
