package Display.NewView;


import java.io.IOException;

import Display.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainLoginController {


	private Main main;
	
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
		String UserName = txtUserName.getText();
		String Pass = txtPassword.getText();
		if (UserName.equals("") && Pass.equals("")){
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

