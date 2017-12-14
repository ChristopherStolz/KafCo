	package edu.nyit.CSCI455.MeterProject.Server;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.nyit.CSCI455.MeterProject.Data.DataRepository;
import edu.nyit.CSCI455.MeterProject.Data.DataRun;

@RestController
@RequestMapping("/db")
public class DataRestAPI {
	@Autowired
	private DataRepository dataRepository;
	
	@PostMapping("/create")
	 public Map<String, Object> create(@RequestParam String id,
			 						   @RequestParam String date,
			 						   @RequestParam String timeOffset,
			 						   @RequestParam String data,
			 						   @RequestParam String meterName) {
		  DataRun newData = new DataRun(meterName, date,
				  				Integer.parseInt(timeOffset));
		  newData.setId(id);
		  newData.setDataString(data);
		  
		  dataRepository.save(newData);
		  Map<String, Object> dataMap = new HashMap<String, Object>();
		  dataMap.put("message", "Data created successfully");
		  dataMap.put("status", "1");
		  dataMap.put("data", data);
		     return dataMap;
	}
	
	@RequestMapping("/read-all")
	public Map<String, Object> readAll(){
		List<DataRun> data = dataRepository.findAll();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("message", "Data found successfully");
		dataMap.put("totalData", data.size());
		dataMap.put("status", "1");
		dataMap.put("data", data);
		return dataMap;
	}
	
	
}
