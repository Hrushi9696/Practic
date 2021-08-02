package com.base;

import java.io.FileInputStream;
import java.util.Properties;

import com.utility.Constants;




public class ReadPropertyFile {

	public static String get(String propertyname) {
		
		String returnproperty=null;
		Properties prop = new Properties();
		try {
			FileInputStream file = new FileInputStream(Constants.RESOURCESPATH);
			prop.load(file);
			returnproperty = prop.getProperty(propertyname);
			if(returnproperty==null) {
				throw new Exception("Property named "+propertyname+ " not found");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return returnproperty;
	}
}
