package edu.nyit.CSCI455.MeterProject.Client;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import Display.Main;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import edu.nyit.CSCI455.MeterProject.Data.DataRepository;
import edu.nyit.CSCI455.MeterProject.Data.DataService;
import edu.nyit.CSCI455.MeterProject.Data.UserRepository;
import edu.nyit.CSCI455.MeterProject.Data.UserService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.IOException;

@SpringBootApplication
public class MeterProjectApplication implements CommandLineRunner
{
	
    private ConfigurableApplicationContext context;
    private Parent rootNode;
    
	@Autowired
	DataRepository dataService;
	@Autowired
	UserRepository userService;
	@Bean
	public UserService userService(){
		return new UserService();
	}
	@Bean
	public DataService dataService(){
		return new DataService();
	}
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}
	private static Stage primaryStage;
	private static BorderPane mainLayout;
	
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