package com.hellofresh.cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import net.thucydides.core.pages.PageObject;


public class LoginPage extends PageObject {
	
	@FindBy(id = "email")
	private WebElement eMail;

	@FindBy(id="passwd")
	private WebElement password;
	
	@FindBy(id = "SubmitLogin")
	private WebElement submitButton;	
	
	/**
	 * method to enter UserName and password in text field
	 * 
	 * @param eMail and password
	 */
	
	public void enterEmailAndPassword() {
		eMail.sendKeys(SignInPage.emailValue);
		password.sendKeys(SignInPage.passwordValue);
		System.out.println("Email and password is entered");
		}
	
	/**
	 * click on sign in button for registered user
	 * 
	 */
	public void clickSignIn() {
	  submitButton.click();
	  System.out.println("customer is clicked on signin button");
	}
   }

