package Display.ForgotPass;

import java.io.IOException;

import Display.Main;
import javafx.fxml.FXML;

public class ForgotHome {
	
	
	private Main main;
	
	
	@FXML
	private void goHome() throws IOException{
			main.showMainLogin();
	}


}
