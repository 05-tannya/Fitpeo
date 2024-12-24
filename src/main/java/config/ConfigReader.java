package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import Pages.BrowserFactory;

public class ConfigReader {
	
	public Properties p ;
	public FileInputStream s; 
	
	public ConfigReader() throws IOException {
     p = new Properties();
     s = new FileInputStream("C:\\Users\\mittal.tannya\\eclipse-workspace1\\FitpeoAssignment\\src\\main\\java\\config\\config.properties");
     p.load(s);
	}
	
	 // Method to get a property value by key
    public String RetriveProperty(String key) {
        return p.getProperty(key);
       }
	
}
