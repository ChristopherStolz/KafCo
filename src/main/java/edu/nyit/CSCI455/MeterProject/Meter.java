package edu.nyit.CSCI455.MeterProject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.Date;

import jssc.SerialPort;
import jssc.SerialPortException;

public class Meter {
	
	private InputStream iStream;
	private SerialPort serialPort;
	private Thread readThread;
	private byte[] readBuffer;
	private DataRun myData;
	private int timeOffset;
	private String myName;
	
	public Meter () {
		serialPort = null;
	}
	
	public Meter(String portName, Thread thread, String meterName, int timeOffset) {
		serialPort = new SerialPort(portName);
		readThread = thread;
		myName = meterName;
		myData = new DataRun(myName, new Date().toString());
		this.timeOffset = timeOffset;
	}
	
	public byte[] read() throws SerialPortException{
		/*
		 * TODO: Define readThread 
		 */
		serialPort.openPort();
		serialPort.setParams(57600, 8, 1, 0); //Baud Rate, dataBits, stopBits, parity
		readBuffer = serialPort.readBytes(10); //reads 10 bytes; default value; need to test
		serialPort.closePort();
		return readBuffer;
	}
	
	public boolean write() throws SerialPortException{
		serialPort.openPort();
		serialPort.setParams(57600, 8, 1, 0); //Baud Rate, dataBits, stopBits, parity
		serialPort.writeBytes("test string".getBytes());
		serialPort.closePort();
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
}
