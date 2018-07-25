package com.hellofresh.cucumber.pages;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://automationpractice.com/index.php")
public class SignInPage extends PageObject{
	public static String emailValue = "test_mail" + String.valueOf(new Date().getTime()) + "@test" + ".com";
	public static String passwordValue ="password123";
	@FindBy(css = "a.login")
	private WebElement signIn;
	
	@FindBy(id = "email_create")
	private WebElement eMail;
	
	@FindBy(id = "SubmitCreate")
	private WebElement createAccountButton;
	
	@FindBy(id = "id_gender2")
	private WebElement customerTitle;
	
	@FindBy(id = "customer_firstname")
	private WebElement customerFirstName;
	
	@FindBy(id = "customer_lastname")
	private WebElement customerLastName;
	
	@FindBy(id = "passwd")
	private WebElement password;
	
	@FindBy(id = "address1")
	private WebElement address1;
	
	@FindBy(id = "city")
	private WebElement cityName;
	
	@FindBy(id = "id_state")
	private WebElement state;
	
	@FindBy(id = "days")
	private WebElement bDays;
	
	@FindBy(id = "months")
	private WebElement bMonths;
	
	@FindBy(id = "years")
	private WebElement bYears;
	
	@FindBy(id = "postcode")
	private WebElement postalCode;
	
	@FindBy(id = "phone_mobile")
	private WebElement mobileNumber;
		
	@FindBy(id = "other")
	private WebElement otherInfo;
	
	@FindBy(xpath = "//button[@id='submitAccount']")
	private WebElement submitAccountButton;
	
	@FindBy(className = "info-account")
	private WebElement accountConfirmation;
	
	@FindBy(xpath = "//*[@class='page-heading']")
	private WebElement headerConfirmation;
	
	/**
	 * click on sign in link
	 * 
	 */
	public void clickSignInLink(){
		try{
		  element(signIn).click();
		  System.out.println("click on signin link");
		}catch(Exception e){
			e.printStackTrace();
		  }
		}
	/**
	 *enter email address
	 * 
	 */
	public void fillEmail() {
	try{
		eMail.sendKeys(emailValue);
		System.out.println("enter email address");
	}catch(Exception e){
		e.printStackTrace();
	  }
		}
	/**
	 * click on create account button
	 * 
	 */
	public void clickCreateAccountButton() {
		createAccountButton.click();
		System.out.println("click on create account button");
		}
	
	/**
	 * enter the required customer data 
	 * 
	 */
	
	public void fillCustomerData(String firstName,String lastName,String address,String city,String pincode ,String phoneNumber, String info){	
	
	customerTitle.click();
	//Enter first name and last name
	customerFirstName.sendKeys(firstName);
	customerLastName.sendKeys(lastName);
	password.sendKeys(passwordValue);
	//Select the birthday date
	Select select = new Select(bDays);
    select.selectByValue("1");
    select = new Select(bMonths);
    select.selectByValue("1");
    select = new Select(bYears);
    select.selectByValue("1990"); 
    //Enter the address
	address1.sendKeys(address);
	cityName.sendKeys(city);
	//select the state
	select = new Select(state);
	select.selectByVisibleText("Colorado");
	postalCode.sendKeys(pincode);
	mobileNumber.sendKeys(phoneNumber);
	otherInfo.sendKeys(info);      
     System.out.println("enter the required customer data");	
	}
	
	/**
	 * click on submit account button
	 * 
	 */
	public void clickSubmitAccountButton(){
		JavascriptExecutor js = (JavascriptExecutor) this.getDriver();				
		js.executeScript("arguments[0].click()", submitAccountButton);
		System.out.println("click on submit account button");
		
		}
	
	/**
	 * validate the my account page
	 */

	public void validateMyAccount() {
		assertEquals("MY ACCOUNT", headerConfirmation.getText());
		System.out.println("My account page is successfully validated");
	}
	/**
	 * User name validation on My account page
	 * 
	 * @param customerName
	 */

	public void validateUserName(String firstName,String lastName) {
		assertEquals(firstName +' '+ lastName, this.getDriver().findElement(By.className("account")).getText());	
		System.out.println("User name is successfully validated on My account page : " + firstName +' '+ lastName );
	}
	/**
	 * validate the logout action and welcome message
	 * 
	 * 
	 */

	public void validateLogout() {
		assertTrue(accountConfirmation.getText().contains("Welcome to your account.")); 
	    assertTrue(this.getDriver().findElement(By.className("logout")).isDisplayed());
	    assertTrue(this.getDriver().getCurrentUrl().contains("controller=my-account"));	
	    System.out.println("Logout action  and welcome message successfully validated");
	}
	
}

