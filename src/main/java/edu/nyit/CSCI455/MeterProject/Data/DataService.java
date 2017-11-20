package edu.nyit.CSCI455.MeterProject.Data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class DataService {
	
	@Autowired
	DataRepository dataRepository;
	
	public List<DataRun> findAll(){
		return dataRepository.findAll();
	}
}
