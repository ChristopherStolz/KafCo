package Display;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import Display.Main;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import edu.nyit.CSCI455.MeterProject.Client.MeterProjectApplication;
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

@SpringBootApplication
public class Main extends Application{//extends AbstractJavaFxApplicationSupport{
	
    private ConfigurableApplicationContext context;
    private Parent rootNode;
    
	@Autowired
	DataRepository dataRepository;
	
	@Autowired
	UserService userService;
	
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

	@Override
	public void init() throws Exception{
        SpringApplicationBuilder builder = new SpringApplicationBuilder(MeterProjectApplication.class);
        context = builder.run(getParameters().getRaw().toArray(new String[0]));
        
//        primaryStage.setTitle("DIYW");
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("NewView/MainLogin.fxml"));
//        loader.setControllerFactory(context::getBean);
//        rootNode = loader.load();
//        mainLayout = loader.load();
        
	}
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("DIYW");//name of doc.
		
		showMainView();//calls showMainView (so that it will display)
		showMainLogin();//Calls ShowMainLogin (so that it will display)
		
		
	}
		//loads the main FXML doc and gives it a size
		private void showMainView() throws IOException {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("NewView/MainView.fxml"));
	        loader.setControllerFactory(context::getBean);
			mainLayout = loader.load();
			Scene scene = new Scene(mainLayout,800,600);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		
		//loads the login FXML doc inside the Main FXML doc
		public void showMainLogin() throws IOException {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("NewView/MainLogin.fxml"));
	        loader.setControllerFactory(context::getBean);
			BorderPane mainLogin = loader.load();
			mainLayout.setCenter(mainLogin);
		}
		
		//loads the Readers FXML doc inside the Main FXML doc is called in MainLoginController
		public void showReaders() throws IOException{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("Readers/Readers.fxml"));
	        loader.setControllerFactory(context::getBean);
			BorderPane readers = loader.load();
			mainLayout.setCenter(readers);
			
		}
		
		//loads the Forgot Password screen 
		public void showForgotPass() throws IOException{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("ForgotPass/ForgotPass.fxml"));
	        loader.setControllerFactory(context::getBean);
			BorderPane forgotPass = loader.load();
			mainLayout.setCenter(forgotPass);
		}
		

//		public static void main(String[] args) {
//			launchApp(Main.class, MainView.class, args);
//		}
}