package bdd.AmeriHealth.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {

	 Properties properties;
	 static ReadProperties envV= new ReadProperties();;
	public ReadProperties() {
		loadProperties();
	}

	private void loadProperties() {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("environment.properties");
		properties = new Properties();
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getProperty(String key) {
		if (key != null) {
			return properties.getProperty(key);
		} else {
		}
		return null;
	}

	public long getNumProperty(String key) {
		String value = getProperty(key);
		if (value != null) {
			String refinedValue = value.trim().replaceAll("^0-9", "");
			return Long.parseLong(refinedValue);

		} else {
			return 0;
		}
	
		
		
		
	}
	



}
