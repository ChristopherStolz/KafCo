package edu.nyit.CSCI455.MeterProject.Server;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.nyit.CSCI455.MeterProject.Data.UserRepository;
import edu.nyit.CSCI455.MeterProject.Data.User;

@RestController
@RequestMapping("/db/user")
public class UserRestAPI {
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/create")
	 public Map<String, Object> create(User data) {
		  //data.setDate(new Date().toString());
		  data = userRepository.save(data);
		  Map<String, Object> dataMap = new HashMap<String, Object>();
		  dataMap.put("message", "Data created successfully");
		  dataMap.put("status", "1");
		  dataMap.put("data", data);
		     return dataMap;
	}
	
	@RequestMapping("/read-all")
	public Map<String, Object> readAll(){
		List<User> data = userRepository.findAll();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("message", "Data found successfully");
		dataMap.put("totalData", data.size());
		dataMap.put("status", "1");
		dataMap.put("data", data);
		return dataMap;
	}
}