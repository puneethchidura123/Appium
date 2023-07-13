package com.org.saib.genericjavautilites;

public class GenericJava {
	
	private PropertiesFileManager metaPropertiesManager = new PropertiesFileManager(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\TestProperties\\MetaProperties.properties");

	public PropertiesFileManager getMetaPropertiesManager() {
		return metaPropertiesManager;
	}

	public void setMetaPropertiesManager(PropertiesFileManager metaPropertiesManager) {
		this.metaPropertiesManager = metaPropertiesManager;
	}

}
