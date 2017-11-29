package edu.nyit.CSCI455.MeterProject.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;

@Document(collection = "MeterData")
public class DataRun{

	@Id
	private String id;

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
	
	public DataRun(DataRun old){
		this.date = old.getDate();
		this.meterName = old.getMeterName();
		this.timeOffset = old.getTimeOffset();
		this.id = old.getId();
		this.data = old.getData();
	}

	public boolean writeData(String dataObject){
		data.add(dataObject);
		return true;
	}

	public ArrayList<String> getData (){
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
	public void setTimeOffset(int offset){
		timeOffset = offset;
	}
	public int getTimeOffset(){
		return timeOffset;
	}
}
