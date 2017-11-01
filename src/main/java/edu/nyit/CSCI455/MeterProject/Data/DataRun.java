package edu.nyit.CSCI455.MeterProject.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.ListIterator;

@Document(collection = "MeterData")
public class DataRun{

	@Id
	public String id;

	private String date;
	private String meterName;
	private int timeOffset;
	private ArrayList<String> data;

	public DataRun() {
		data = new ArrayList<String>();
		date = new Date().toString();
	}

	public DataRun(String meterName, String dateTime, int timeOffset) {
		id = meterName + "-" + dateTime;
		this.meterName = meterName;
		this.timeOffset = timeOffset;
		date = dateTime; // TODO: cut off the time before storing.
		data = new ArrayList<String>();
	}

	public boolean writeData(String dataObject){
		data.add(dataObject);
		return true;
	}

	public ArrayList<String> getData (){
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

	public void setData(ArrayList<String> data) {
		this.data = data;
	}

}
