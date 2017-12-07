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
	public TextField txtPassword;

	// calls ShowREaders from Main and loads the Readers when login btn is hit
	@FXML
	private void goReader(ActionEvent event) throws IOException{
		String email = txtUserName.getText();
		String password = txtPassword.getText();
		if (userService.checkUser(email, password)){
			main.showReaders();
		}
		else
		{
			lblStatus.setText("! User Name or Password is Invalid");
		}

	}
	
	@FXML
	private void goForgotPass() throws IOException{
			main.showForgotPass();
	}


}

