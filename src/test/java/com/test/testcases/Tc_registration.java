package com.test.testcases;

import org.testng.annotations.Test;

import com.test.pageobject.Indexpage;
import com.test.pageobject.rgstpg;

import junit.framework.Assert;

public class Tc_registration extends Baseclass {


@Test
public void verifyregistrationpage()
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
}