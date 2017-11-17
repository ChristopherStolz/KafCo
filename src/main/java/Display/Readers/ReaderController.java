package Display.Readers;


import java.io.IOException;

import java.util.Random;


import Display.Main;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
public class ReaderController {

	private Main main;
	
	ObservableList<String> comPortList = FXCollections
			.observableArrayList("1","2","3","4");
	
	ObservableList<String> timeIntList = FXCollections
			.observableArrayList("100","200","300","400","500","600","700","800","900","1000");
	

	//brings you back to the login screen
	@FXML
	private void Logout(ActionEvent event) throws IOException{
		main.showMainLogin();
	}
	

	
	@FXML
	private ChoiceBox comPortBox;
	
	@FXML
	private ChoiceBox timeIntBox;
	
	//fills ChoiceBoxs and sets there initial value
	@FXML 
	public void initialize(){
		comPortBox.setValue("1");
		comPortBox.setItems(comPortList);
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
	
	
	
	
	
	static Random rand = new Random();

	String num;
	
	//graphs all data and displays it in text box and updates meter
	@FXML
	private void chartBtn (ActionEvent event) throws InterruptedException{
		XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
		int selectedChoice = Integer.parseInt((String)timeIntBox.getSelectionModel().getSelectedItem());
		
		float[] floatArray = new float[101];
		AreaChart.getData().add(series);//graphs point
		
		
		
		Task task = new Task<Void>() {
			  @Override
			  public Void call() throws Exception {
			    int i = 0;
			    while (true) {//loops until array is over
			      final int finalI = i;
			      Platform.runLater(new Runnable() {
			        @Override
			        public void run() {			        			    			
			    			floatArray[finalI] = Graph.Random();
			    			String newValueR = floatArray[finalI] + "";
			    			meterData.setText(newValueR);
			    			num = Integer.toString(finalI);
			    			series.getData().add(new XYChart.Data<String, Number>(num , floatArray[finalI]));
			    			//fill graph
			    			meterLine.setRotate((179.9/580)*floatArray[finalI]);//converts data into degrees

			        }
			      });
			      i++;
			      //sleeps after every point
			      Thread.sleep(selectedChoice);
			    }
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
	
	
	
	

