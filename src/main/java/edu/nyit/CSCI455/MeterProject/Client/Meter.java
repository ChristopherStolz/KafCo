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
	
	private final char STX = (char)2;
	private final char ETX = (char)3;
	private final char ZERO = (char)48;
	
	private InputStream iStream;
	private OutputStream oStream;
	private PrintWriter oWriter;
	private BufferedReader iReader;
	private SerialPort serialPort;	
	private byte[] readBuffer;
	private DataRun myData;
	private int timeOffset;
	private String myName;
	
	public Meter () {
		serialPort = null;
	}
	
	public Meter(String meterName, int timeOffset) {
		String[] portNames = SerialPortList.getPortNames();
		
		if (portNames.length == 0){
			System.out.println("No serial device connected.");
		}
		
		serialPort = new SerialPort(portNames[0]);
		try{
			
		serialPort.openPort();
		
		serialPort.setParams(serialPort.BAUDRATE_9600,
							serialPort.DATABITS_8,
							serialPort.STOPBITS_1,
							serialPort.PARITY_NONE);
		
		serialPort.setFlowControlMode(serialPort.FLOWCONTROL_RTSCTS_IN |
									  serialPort.FLOWCONTROL_RTSCTS_OUT);
		
		serialPort.addEventListener(new PortReader(), SerialPort.MASK_RXCHAR);
		} catch (SerialPortException e) {
			System.out.println(e.getStackTrace().toString());
		}
		//iStream = serialPort.getInputStream();
		//oWriter = new PrintWriter(serialPort.getOutputStream());
		//iReader = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
		myName = meterName;
		readBuffer = new byte[8];
		myData = new DataRun(myName, new Date().toString());
		this.timeOffset = timeOffset;
	}
	
	public byte[] read(){
		/*
		 * TODO: Define readThread 
		 */
		try{
			//System.out.println(serialPort.isOpen() + "");
			//oWriter.write(STX + ZERO + ETX);
			//oWriter.flush();
			//int read = serialPort.readBytes(readBuffer, 8);
			//String read = iReader.readLine();
			//System.out.println(readBuffer + " test");
			System.out.print(STX + "," + ZERO + "," + ETX);
			serialPort.writeString(STX + "," + ZERO + "," + ETX);
		} catch (Exception e){
			e.printStackTrace();
		}
		try{
			serialPort.closePort();
		}catch (SerialPortException e){
			System.out.println(e.getStackTrace().toString());
		}
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
	
	private class PortReader implements SerialPortEventListener {
		@Override
		public void serialEvent(SerialPortEvent event){
			if (event.isRXCHAR() && event.getEventValue() > 0) {
				try{
					String receivedData = serialPort.readString(event.getEventValue());
					System.out.println("Received response: " + receivedData);
				}catch(SerialPortException e){
					System.out.println("Error in receiving string " + e);
				}
			}
		}
	}
}


