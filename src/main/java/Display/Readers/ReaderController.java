package Display.Readers;


import java.io.IOException;

import java.util.Random;


import Display.Main;
import edu.nyit.CSCI455.MeterProject.Client.Meter;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class ReaderController {

	private Main main;

	//the data that will fill the choice box
	ObservableList<String> timeIntList = FXCollections
			.observableArrayList("100","200","300","400","500","600","700","800","900","1000");
	


	//brings you back to the login screen
	@FXML
	private void Logout(ActionEvent event) throws IOException{
		main.showMainLogin();
	}



	@FXML
	private ChoiceBox<String> comPortBox;

	@FXML
	private ChoiceBox<String> timeIntBox;
	
	
	@FXML
	private TextField lowerG;
	
	@FXML
	private TextField maximumG;
	
	

	//fills ChoiceBoxs and sets there initial value
	@FXML 
	public void initialize(){
		timeIntBox.setStyle("-fx-background-color: #35373a ");
		timeIntBox.setStyle("-fx-prompt-text-fill: #eee7e7");
		
		timeIntBox.setValue("100");
		timeIntBox.setItems(timeIntList);
		

	}




	@FXML
	private CategoryAxis xAxis;

	@FXML
	private NumberAxis yAxis;

	@FXML
	private AreaChart<String, Number> AreaChart;

	@FXML
	private Line meterLine;

	@FXML
	private TextField meterData;

	@FXML
	private Circle colorDect;
	
	@FXML
	private ToggleButton StartBtn;
	
	
	@FXML
	private ToggleButton StopBtn;
	
	
	




	static Random rand = new Random();

	String num;


	//graphs all data and displays it in text box and updates meter
	@FXML
	public void chartBtn (ActionEvent event) throws InterruptedException{
		XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
		int selectedChoice = Integer.parseInt((String)timeIntBox.getSelectionModel().getSelectedItem());

		float[] floatArray = new float[101];
		AreaChart.getData().add(series);//graphs point

		Meter meter = new Meter("meter-", selectedChoice); //Instantiates a meter; 100 is where the time offset should go

		
		Task task = new Task<Boolean>() {
			@Override
			public Boolean call() throws Exception {
				int i = 0;
				
				
				boolean run = true;
				while (run) {//loops until array is over
					final int finalI = i;
					Platform.runLater(new Runnable() {
						@Override
						public void run() {			        			    			
							//floatArray[finalI] = Graph.Random();
							String result = meter.KafCoRead();
							Float floatResult = Float.valueOf(result);
							String newValueR = String.format("%.2f", floatResult);
							meterData.setText(newValueR);
							num = Integer.toString(finalI);
							series.getData().add(new XYChart.Data<String, Number>(num , floatResult));
							//fill graph
							meterLine.setRotate((179.9/580)*floatResult);//converts data into degrees
							if(!lowerG.equals("")){
								int newLower = Integer.parseInt(lowerG.getText());
								int newMax = Integer.parseInt(maximumG.getText());
								//colors circle in meter depending on the values you typed in 
								if (floatResult < newLower || floatResult > newMax){
									colorDect.setFill(Color.RED);
								}
								else{
									colorDect.setFill(Color.GREEN);
								}
							}
						}
					});
					i++;
					//sleeps after every point for the amount of time you selected in choice box
					Thread.sleep(selectedChoice);
					if(StopBtn.isSelected()){//when you press stop button the while loop stops
						lowerG.setText(""+ meter.RestWrite());
						meter.close();
						break;
					}
				}
				return run;
				
				
			}
		};
		Thread th = new Thread(task);
		th.setDaemon(true);
		th.start();
		
		




	}
	

	// new class for new thread that populates array 
	static class Graph extends Task{

		@Override
		protected Object call() throws Exception {

			return null;
		}
		@FXML
		public static float Random(){
			float valueR = 580*rand.nextFloat();
			return valueR;

		}


	}

}




