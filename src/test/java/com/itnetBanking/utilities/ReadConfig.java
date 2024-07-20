package com.itnetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	
	public ReadConfig(){
		File src = new File("./Configaration/Config.Properties");
	    try {
			FileInputStream fis=new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
	    
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
		
	}
	
	public String geturl() {
		String baseurl=pro.getProperty("baseUrL");
		return baseurl;
	}
	public String username() {
		String username=pro.getProperty("username");
	 return username;
	
	}
	public String password() {
		String password=pro.getProperty("password");
		return password;
	}
}
