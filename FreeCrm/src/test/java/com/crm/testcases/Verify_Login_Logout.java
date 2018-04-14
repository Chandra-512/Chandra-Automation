package com.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.BaseClass;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;

public class Verify_Login_Logout extends BaseClass
{
	LoginPage loginpage;
	HomePage homepage;
//Compulsory do call BaseClass Constructor by using super() keyword
	
	public Verify_Login_Logout()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginpage = new LoginPage();      //Creating LoginPage class constructor
	}
	
	@Test(priority=1)
	public void loginPageTitle()
	{
	String title = loginpage.validateLoginPageTitle();
	Assert.assertEquals(title, "Free CRM in the cloud software boosts sales");
	}
	@Test(priority=2)
	public void crmImageLogo()
	{
		loginpage.validateCRMImageLogo();
		boolean flag = loginpage.validateCRMImageLogo();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void login()
	{
		
	homepage =	loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@AfterMethod
	public void tearDown()
	{
	driver.quit();	
	}
}
