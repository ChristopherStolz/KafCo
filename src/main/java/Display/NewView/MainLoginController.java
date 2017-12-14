package Display.NewView;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

@FXMLController
public class MainLoginController {


	private Main main;

	@Autowired
	private UserService userService;


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
		//checks to make sure password and username match
		String message = "";
		try{
		HttpClient httpclient = new DefaultHttpClient();
		URI uri = new URI("http://localhost:8080/db/user/authorize");
		HttpPost httppost = new HttpPost(uri);
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("email", email));
		nameValuePairs.add(new BasicNameValuePair("password", passwordField));

		
		UrlEncodedFormEntity form;
		form = new UrlEncodedFormEntity(nameValuePairs, "UTF-8");
		form.setContentEncoding(HTTP.UTF_8);
		httppost.setEntity(form);
		
		HttpResponse response = httpclient.execute(httppost);
		BufferedReader br = new BufferedReader(
				new InputStreamReader(response.getEntity().getContent()));
		message = br.readLine();
		EntityUtils.consume((HttpEntity) httpclient);
		}catch (Exception e){
			e.printStackTrace(System.err);
		}
		if(message.contains("true"))
		{
			main.showReaders();
		}
		else
		{	//error message
			lblStatus.setText("! User Name or Password is Invalid");
			lblStatus.setStyle("-fx-background-color: #000000 ");
		}

	}
	//brings you to forgot password screen when you hit the forgot password button
	@FXML
	private void goForgotPass() throws IOException{
			main.showForgotPass();
	}


}

