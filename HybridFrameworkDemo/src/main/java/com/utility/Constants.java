package com.utility;

public class Constants {

	public static final String PROJECTPATH=System.getProperty("user.dir");
	public static final String CHROMEDRIVERPATH =System.getProperty("user.dir")+"\\Driver\\chromedriver.exe";
	public static final String GECKODRIVERPATH = System.getProperty("user.dir")+"\\Driver\\geckodriver.exe";
	
	public static final String RESOURCESPATH = "C:\\Users\\Ajay\\Workspace\\AnupPractice\\src\\main\\resources\\com\\project\\resourses\\data.properties";
	public static final String TESTDATASHEETNAME= System.getProperty("user.dir")+"//BrixLite//src//com//brixlite//resources//TestData.xlsx";
	
	public static final long PAGE_LOAD_TIMEOUT = 20;
	public static final long IMPLICIT_WAIT = 20;
	public static final int EXPLICITWAIT=50;
	
	public static final int SHORT_WAIT = 1000;
	public static final int MEDIUM_WAIT = 3000;
	public static final int LONG_WAIT = 5000;
	
}
