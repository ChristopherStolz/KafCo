package Display.NewView;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import Display.Main;
import de.felixroske.jfxsupport.FXMLController;
import edu.nyit.CSCI455.MeterProject.Data.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

@FXMLController
public class MainLoginController {


	private Main main;

	@Autowired
	private UserService userService;
	
	@FXML
	private Label lblWelcome;


	@FXML
	private Label lblStatus;

	@FXML
	public TextField txtUserName;

	
	@FXML
	public PasswordField PassPassword;
	
	
	//makes the password field so that text in it is hidden 
	@FXML 
	public void initialize(){
		PasswordField PassPassword = new PasswordField();
		PassPassword.setPromptText("Your password");
	}

	// calls ShowREaders from Main and loads the Readers when login btn is hit
	@FXML
	private void goReader(ActionEvent event) throws IOException{
		
		String email = txtUserName.getText();
		
		String passwordField = PassPassword.getText();
		//if (userService.checkUser(email, passwordField))
		//checks to make sure password and username atch
		if (email.equals("kparrish@nyit.edu") && passwordField.equals("password") || email.equals("akim07@nyit.edu") && passwordField.equals("password") || email.equals("cstolz@nyit.edu") && passwordField.equals("password"))
		{
			main.showReaders();
		}
		else
		{	//error message
			lblStatus.setText("! User Name or Password is Invalid");
		}

	}
	//brings you to forgot password screen when you hit the forgot password button
	@FXML
	private void goForgotPass() throws IOException{
			main.showForgotPass();
	}


}

