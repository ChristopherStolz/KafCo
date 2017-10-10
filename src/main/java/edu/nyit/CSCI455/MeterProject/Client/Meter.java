package edu.nyit.CSCI455.MeterProject.Client;

import edu.nyit.CSCI455.MeterProject.Data.*;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Date;

import com.fazecast.jSerialComm.SerialPort;
public class Meter {
	
	private InputStream iStream;
	private OutputStream oStream;
	private SerialPort serialPort;
	private byte[] readBuffer;
	private DataRun myData;
	private int timeOffset;
	private String myName;
	
	public Meter () {
		serialPort = null;
	}
	
	public Meter(String meterName, int timeOffset) {
		SerialPort[] temp = SerialPort.getCommPorts();
		for (int i = 0; i < temp.length; i ++){
			System.out.println(temp[i].getSystemPortName());
		}
		serialPort = SerialPort.getCommPorts()[0];
		serialPort.openPort();
		System.out.println(serialPort.isOpen() + "");
		serialPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING | 
				SerialPort.TIMEOUT_WRITE_SEMI_BLOCKING, 100, 100);
		serialPort.setBaudRate(9600);
		iStream = serialPort.getInputStream();
		oStream = serialPort.getOutputStream();
		myName = meterName;
		readBuffer = new byte[100];
		myData = new DataRun(myName, new Date().toString());
		this.timeOffset = timeOffset;
	}
	
	public byte[] read(){
		/*
		 * TODO: Define readThread 
		 */
		try{
			oStream.write((byte)0);
			int stream = iStream.read(readBuffer);
			System.out.println(readBuffer);
			
		} catch (Exception e){
			e.printStackTrace();
		}
		serialPort.closePort();
		String[] outData = {"0", "" + readBuffer};
		//myData.writeData(outData);
/*		serialPort.openPort();
		serialPort.setParams(57600, 8, 1, 0); //Baud Rate, dataBits, stopBits, parity
		readBuffer = serialPort.readBytes(10); //reads 10 bytes; default value; need to test
		serialPort.closePort();*/
		return readBuffer;
	}
	
	public boolean write(){
		/*serialPort.openPort();
		serialPort.setParams(57600, 8, 1, 0); //Baud Rate, dataBits, stopBits, parity
		serialPort.writeBytes("test string".getBytes());
		serialPort.closePort();*/
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
