package com.org.saib.genericjavautilites;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Properties;

public class JavaProperties {
	
	Properties properties;
	String FileName;
	
	public JavaProperties(String CompleteFilePath) throws FileNotFoundException, IOException
	{
		FileName = CompleteFilePath;
		properties = new Properties();
		properties.load(new FileReader(FileName));
	}
	
	public String getProperty(String Key) throws FileNotFoundException, IOException
	{
		return properties.getProperty(Key);
	}
	
	public void setProperty(String Key,String Value) throws IOException
	{
		properties.setProperty(Key, Value);
		properties.store(new FileWriter(Value),new Timestamp(System.currentTimeMillis()).toString());
	}

}
