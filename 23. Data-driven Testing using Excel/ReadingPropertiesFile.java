package day41;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

public class ReadingPropertiesFile {

	public static void main(String[] args) throws IOException {
		
		// Create an object of properties file
		Properties propertiesObj = new Properties();
		
		// Location of properties file
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\testData\\config.properties");
		
		// Loading properties file
		propertiesObj.load(file);
		
		// Reading data from properties file
		String url = propertiesObj.getProperty("appurl");
		String email = propertiesObj.getProperty("email");
		String pwd = propertiesObj.getProperty("password");
		String orderId = propertiesObj.getProperty("orderId");
		String customerId = propertiesObj.getProperty("customerId");
		
		System.out.println(url);
		System.out.println(email);
		System.out.println(pwd);
		System.out.println(orderId);
		System.out.println(customerId);
		
		
		// Reading all the keys from properties file
		
		// 1) Read keys as strings
		// Set<String> keys = propertiesObj.stringPropertyNames();
		// System.out.println(keys);
		
		// 2) Read keys as objects
		Set<Object> keys = propertiesObj.keySet();
		System.out.println(keys);
		
		// Reading all the values
		Collection<Object> values = propertiesObj.values();
		System.out.println(values);
		
		
		

	}

}
