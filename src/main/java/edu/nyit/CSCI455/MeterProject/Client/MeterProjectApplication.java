package edu.nyit.CSCI455.MeterProject.Client;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

import edu.nyit.CSCI455.MeterProject.Data.DataRepository;
import edu.nyit.CSCI455.MeterProject.Data.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.IOException;

@SpringBootApplication
public class MeterProjectApplication implements CommandLineRunner{
	
	@Autowired
	DataRepository dataService;
	@Autowired
	UserRepository userService;
	
	public static void main(String[] args){
		SpringApplication.run(MeterProjectApplication.class, args);
	}
	
	@Override
	public void run(String...args) throws Exception{
		Meter meter = new Meter("meter", 100);
		String result;
		for (int i = 0; i < 10; i++){
			result = meter.KafCoRead();
			System.out.println(result);
		}
		dataService.save(meter.getData());
	}
}
