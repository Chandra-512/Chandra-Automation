package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.BaseClass;

public class LoginPage extends BaseClass
{
//page factory or object repository
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement login;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signup;
	
	@FindBy(xpath="//img[@class='img-responsive']")
	WebElement crmlogo;
	//Initializing the page objects
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
				
	}
	//Actions
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	public boolean validateCRMImageLogo()
	{
		return crmlogo.isDisplayed();
	}
	public HomePage login(String un,String pwd)
	{
		username.sendKeys(un);
		System.out.println("Entered UserName");
		password.sendKeys(pwd);
		System.out.println("Entered Password");
		login.click();
		System.out.println("Clicked on SignUp button");
		return new HomePage();
	}
	
}
