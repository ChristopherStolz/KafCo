package edu.nyit.CSCI455.MeterProject.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.LinkedList;
import java.util.ListIterator;

@Document(collection = "MeterData")
public class DataRun{

	@Id
	public String id;

	private int index;
	private int iteratorIndex;
	private String date;
	private String meterName;
	private ListIterator iterator;
	private LinkedList<String[][]> data;

	public DataRun() {
		data = new LinkedList<String[][]>();
		data.add(new String[2][100]); //indices flipped for X,Y representation
		iterator = data.listIterator();
		iteratorIndex = 0;
	}

	public DataRun(String meterName, String dateTime) {
		id = meterName + "-" + dateTime;
		this.meterName = meterName;
		date = dateTime; // TODO: cut off the time before storing.
	}

	public boolean writeData(String[] dataObject){
		String[][] current = data.get(iteratorIndex); //loads the current array of the data list
		if(index == 100){
			/*
			 * If data array is full, initialize a new data array
			 */
			String[][] helper = new String[2][100];
			helper[0][0] = dataObject[0];
			helper[1][0] = dataObject[1];
			data.add(new String[2][100]);
			iteratorIndex = iterator.nextIndex();
			iterator.next();
			index = 0;
		} else {
			/*
			 * Write to the data array
			 */
			current[0][index] = dataObject[0];
			current[1][index] = dataObject[1];
			data.set(iteratorIndex, current); //write back the current array of the data list
			index++;
		}
		return true;
	}

	public LinkedList<String[][]> getData (){
		/*
		 * TODO: Define more robust behavior.
		 * Currently returns the list raw
		 */
		return data;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMeterName() {
		return meterName;
	}

	public void setMeterName(String meterName) {
		this.meterName = meterName;
	}

	public void setData(LinkedList<String[][]> data) {
		this.data = data;
	}

}