package edu.nyit.CSCI455.MeterProject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import jssc.SerialPort;
import jssc.SerialPortException;

public class Meter {
	
	InputStream iStream;
	SerialPort serialPort;
	Thread readThread;
	byte[] readBuffer;
	
	public Meter () {
		serialPort = null;
	}
	
	public Meter (String portId){
		serialPort = new SerialPort(portId);
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
}
