package Display.ForgotPass;

import java.io.IOException;

import Display.Main;
import javafx.fxml.FXML;

public class ForgotHome {
	
	
	private Main main;
	
	//brings you back to the main login screen when you hit the cancel button
	@FXML
	private void goHome() throws IOException{
			main.showMainLogin();
	}


}
