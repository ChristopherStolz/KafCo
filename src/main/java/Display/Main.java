package Display;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import Display.Main;
import Display.NewView.MainView;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;

import edu.nyit.CSCI455.MeterProject.Data.DataRepository;
import edu.nyit.CSCI455.MeterProject.Data.DataService;
import edu.nyit.CSCI455.MeterProject.Data.UserRepository;
import edu.nyit.CSCI455.MeterProject.Data.UserService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main  extends Application{
	
	private static Stage primaryStage;
	private static BorderPane mainLayout;


	
	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Zoro Reader");//name of doc.
		
		showMainView();//calls showMainView (so that it will display)
		showMainLogin();//Calls ShowMainLogin (so that it will display)
		
		
	}
		//loads the main FXML doc and gives it a size
		private void showMainView() throws IOException {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("NewView/MainView.fxml"));
			mainLayout = loader.load();
			Scene scene = new Scene(mainLayout,5000,700);
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
		
		//launches the program
		public static void main(String[] args) {
			launch(Main.class, args);
		}
}