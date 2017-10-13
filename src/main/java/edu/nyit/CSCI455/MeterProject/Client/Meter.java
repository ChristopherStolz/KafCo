package edu.nyit.CSCI455.MeterProject.Client;

import edu.nyit.CSCI455.MeterProject.Data.*;

import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
import jssc.SerialPortList;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;


public class Meter {
	/*
	 * Define constants used in communication; STX = Start text, ETX = End Text (Control Flow)
	 * ZERO is ASCII Zero; The KafCo device takes a Zero before it will write back.
	 */
	private final char STX = (char)2;
	private final char ETX = (char)3;
	private final char ZERO = (char)48;
	
	private SerialPort serialPort;
	private DataRun myData;
	private int timeOffset;
	private String myName;
	
	public Meter () {
		serialPort = null;
	}
	
	public Meter(String meterName, int timeOffset) {
		/*
		 * Initialize instance variables
		 */
		this.timeOffset = timeOffset;
		this.myName = meterName;
		myData = new DataRun(myName, new Date().toString());
		
		
		/*
		 * Get the list of port names; All connected Serial Devices go into this list.
		 * To use multiple meters we will need to pass a param for what device should be connected
		 */
		String[] portNames = SerialPortList.getPortNames();
		
		if (portNames.length == 0){
			/*
			 * If there are no serial devices connected we error;
			 * TODO: Robust error behavior for GUI
			 */
			System.out.println("No serial device connected.");
		}
		
		/*
		 * Currently defaults to first connected device
		 * Should be parameterized so we can select and connect multiple devices
		 */
		serialPort = new SerialPort(portNames[0]);
		
		try{
		/*
		 * Initialize the serial connection
		 */
		serialPort.openPort();
		
		serialPort.setParams(serialPort.BAUDRATE_9600,
							serialPort.DATABITS_8,
							serialPort.STOPBITS_1,
							serialPort.PARITY_NONE);
		
		serialPort.setFlowControlMode(serialPort.FLOWCONTROL_NONE);

		} catch (SerialPortException e) {
			System.out.println("Serial device initialization failed: " + e);
		}
		
	}
	
	public String read(){
		/*
		 * TODO: Define readThread 
		 */
		String result = new String();
		try{
			serialPort.writeString(ZERO + ""); //KafCo device wants a ZERO before returning result (mode?)
			result = serialPort.readString(); //Read the meter
		} catch (Exception e){
			e.printStackTrace();
		}
		try{
			serialPort.closePort();
		}catch (SerialPortException e){
			System.out.println(e.getStackTrace().toString());
		}
		
		String[] results = result.split(",");
		result = results[2];
		String[] outData = {"0", "" + result};
		myData.writeData(outData);
		return result;
	}
	
	public boolean write(){
		/*
		 * May need this later;
		 */
		return false;
	}
	
	public DataRun getData (){
		return myData;
	}
	
	public boolean setTimeOffset (int timeOffset) {
		this.timeOffset = timeOffset;
		return true;
	}
	
	public int getTimeOffset (){
		return timeOffset;
	}
	public String getName(){
		return myName;
	}
}