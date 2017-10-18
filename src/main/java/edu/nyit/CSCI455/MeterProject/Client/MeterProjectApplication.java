package edu.nyit.CSCI455.MeterProject.Client;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

import edu.nyit.CSCI455.MeterProject.Data.DataRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.IOException;

@SpringBootApplication
public class MeterProjectApplication{
	@Autowired
	private DataRepository dataRepository;
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(MeterProjectApplication.class)
			.headless(false)
			.web(true)
			.run(args);
		Meter meter = new Meter("meter", 100);
		String result;
		for (int i = 0; i < 9; i++){
			result = meter.KafCoRead();
			System.out.println(result);
			try{
				Thread.sleep(100);
			} catch(Exception e){
				
			}
		}
		//dataRepository.insert(meter.getData());
		//dataRepository.saveAll();
		
		/*
		 * Creating an outputstream for test data from the meter
		 */
		File file = new File ("Test.txt");
		PrintWriter out = null;
		try{
			out = new PrintWriter(new FileOutputStream(file));
		}catch (IOException e){
			System.out.println("foo");
		}

	}
	
	@Bean
	public static MeterFrame frame(){
		return new MeterFrame();
	}
}
