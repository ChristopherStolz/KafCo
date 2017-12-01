package edu.nyit.CSCI455.MeterProject.Client;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

import Display.Main;
import edu.nyit.CSCI455.MeterProject.Data.DataRepository;
import edu.nyit.CSCI455.MeterProject.Data.UserRepository;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
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
public class MeterProjectApplication extends Application {
	
	@Autowired
	DataRepository dataService;
	@Autowired
	UserRepository userService;
	
	private static Stage primaryStage;
	private static BorderPane mainLayout;
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Kafco");//name of doc.
		
		showMainView();//calls showMainView (so that it will display)
		showMainLogin();//Calls ShowMainLogin (so that it will display)
		
		
	}
		
		//loads the main FXML doc and gives it a size
		private void showMainView() throws IOException {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("NewView/MainView.fxml"));
			mainLayout = loader.load();
			Scene scene = new Scene(mainLayout,800,600);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		
		//loads the login FXML doc inside the Main FXML doc
		public static void showMainLogin() throws IOException {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("NewView/MainLogin.fxml"));
			BorderPane mainLogin = loader.load();
			mainLayout.setCenter(mainLogin);
		}
		
		//loads the Readers FXML doc inside the Main FXML doc is called in MainLoginController
		public static void showReaders() throws IOException{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("Readers/Readers.fxml"));
			BorderPane readers = loader.load();
			mainLayout.setCenter(readers);
			
		}
		
		//loads the Forgot Password screen 
		public static void showForgotPass() throws IOException{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("ForgotPass/ForgotPass.fxml"));
			BorderPane forgotPass = loader.load();
			mainLayout.setCenter(forgotPass);
		}
	
	public static void main(String[] args){
		SpringApplication.run(MeterProjectApplication.class, args);
		launch(args);
	}
	
	/*@Override
	public void run(String...args) throws Exception{
		Meter meter = new Meter("meter", 100);
		String result;
		for (int i = 0; i < 10; i++){
			result = meter.KafCoRead();
			System.out.println(result);
		}
		dataService.save(meter.getData());
	}*/
}
