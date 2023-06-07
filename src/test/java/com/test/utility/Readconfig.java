package com.test.utility;

import java.io.FileInputStream;
import java.util.Properties;

import org.bouncycastle.crypto.RuntimeCryptoException;

public class Readconfig {

	Properties properties;
 String path="C:\\Users\\bharat v devadiga\\OneDrive\\Desktop\\Sharath\\v1\\configurations\\configure.property";
	
 
 public Readconfig() {
    try {
    	 properties =new Properties();
         FileInputStream f1=new FileInputStream(path);
    	 properties.load(f1);
    	 
	} catch (Exception e) {
            e.printStackTrace();
	}       
	}
public String getbaseurl()
{
	String value=properties.getProperty("baseurl");
	
	if(value!=null)
	{
		return value;
	}
	else
	{
		throw new RuntimeException("url not found");
	}
}
 
 public String getbrowser()
 {
	 String value=properties.getProperty("browser");
	 if (value!=null)
	 {
		 return value;
	 }
	 else
		 throw new RuntimeException("browser not found");
 }
 
 
 
 
 
 
	
}
