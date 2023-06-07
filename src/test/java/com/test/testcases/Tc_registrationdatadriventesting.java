package com.test.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.pageobject.Indexpage;
import com.test.pageobject.rgstpg;
import com.test.utility.ReadExcelshett;

import junit.framework.Assert;

public class Tc_registrationdatadriventesting extends Baseclass {


@Test(dataProvider = "logindataprovider")
public void verifyregistrationpage(String username ,String email,String actualname)
{
driver.get(url);
Indexpage I2=new Indexpage(driver);
   I2.clickregister();
 
   rgstpg r2=new rgstpg(driver);
   r2.enterfirstname("sharathdevadiga");
   r2.enterlastname("devadiga");
   r2.enteremail("sharathdevadiga04@gmail.com");
  String page =r2.logo();
   Assert.assertEquals(page,"Register");
  
   
}
@DataProvider(name="logindataprovider")
public String[][] logindataprovider()
{
	String filename =System.getProperty("path of the excel file");
    
	int TTlRows=ReadExcelshett.getrowvalue(filename, "Login page");
	
	int TTlcolumns=ReadExcelshett.getcellcount(filename, "Login page");

	String Data[][]=new String[TTlRows-1][TTlcolumns];
	
	for(int i=0;i<TTlRows;i++)
	{
		for(int j=0;j<TTlcolumns;j++)
		{
			Data[i-1][j]=ReadExcelshett.getcellvalue(filename, "Logintestdata", i, j);
		}
	}
	
return Data;
}





}