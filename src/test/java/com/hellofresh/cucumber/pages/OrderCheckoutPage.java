package com.hellofresh.cucumber.pages;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class OrderCheckoutPage extends PageObject {
	
	@FindBy(xpath ="//a[contains(text(),'Women')]")
	private WebElement typeOfStore;

	@FindBy(xpath="//a[@title='Faded Short Sleeve T-shirts']/ancestor::li")
	private WebElement dressType;
	
	@FindBy(xpath="//*[@class='product-name']")
	private WebElement productName;
	
	@FindBy(name="Submit")
	private WebElement addToCartButton;
	
	@FindBy(xpath = "//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']")
	private WebElement proceedToCheckOutOnCartPage;
	
	@FindBy(xpath = "//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']")
	private WebElement proceedToCheckOutOnSummary;
	
	@FindBy(name = "processAddress")
	private WebElement proceedToCheckOutOnAddress;
	
	@FindBy(xpath = "//*[@id='uniform-cgv']")
	private WebElement termOfService;
	
	@FindBy(name = "processCarrier")
	private WebElement proceedToCheckOutOnShipping;
	
	@FindBy(className = "bankwire")
	private WebElement payByBankWire;
	
	@FindBy(xpath = "//*[@id='cart_navigation']/button")
	private WebElement iConfirmMyOrder;
	
	@FindBy(xpath = "//*[@class='page-heading']")
	private WebElement headerConfirmation;
	
	@FindBy(xpath = "//*[@class='cheque-indent']/strong")
	private WebElement orderComplete;
	
	
	/**
	 * click on type of store
	 * @throws InterruptedException 
	 * 
	 */
	public void clickTypeOfStore() throws InterruptedException {
	typeOfStore.click();
	 System.out.println("click on type of store : " + typeOfStore.getText());
	}
	/**
	 * click on type of product name(address)
	 * @throws InterruptedException 
	 * 
	 */
	public void chooseTypeOfDress(String productNameValue) throws InterruptedException {
	 JavascriptExecutor js = (JavascriptExecutor) this.getDriver();	
	 List<WebElement> listProductName=this.getDriver().findElements(By.xpath("//*[@class='product-name']"));
	 for(int i=0;i<=listProductName.size();i++)
	 {	 
	 if(listProductName.get(i).getText().contains(productNameValue))
	 {	
	 System.out.println("product name is selected : " + listProductName.get(i).getText());
	 js.executeScript("arguments[0].click()", listProductName.get(i));
	 
	 break;
	 }
	 }
	 //Click on add to cart
	 js.executeScript("arguments[0].click()", addToCartButton);
	 System.out.println("click on type of Dress : " + dressType.getText());
	 
	}
	/**
	 * click on proceed to checkout on the cart page
	 * @throws InterruptedException 
	 * 
	 */
	public void clickProceedToCheckOutOnCartPage() throws InterruptedException {
	 proceedToCheckOutOnCartPage.click();
	 System.out.println("click on proceed to checkout on the cart page");
	}
	
	/**
	 * click on proceed to checkout on the summary page
	 * @throws InterruptedException 
	 * 
	 */
	public void clickProceedToCheckOutOnSummaryPage() throws InterruptedException {
	JavascriptExecutor js = (JavascriptExecutor) this.getDriver();
	js.executeScript("arguments[0].click()", proceedToCheckOutOnSummary);
	 System.out.println("click on proceed to checkout on the summary page");
	}
	
	/**
	 * click on proceed to checkout on the address page
	 * @throws InterruptedException 
	 * 
	 */
	public void clickProceedToCheckOutOnAddressPage() throws InterruptedException {
	 JavascriptExecutor js = (JavascriptExecutor) this.getDriver();
	 js.executeScript("arguments[0].click()", proceedToCheckOutOnAddress);
	 System.out.println("click on proceed to checkout on the address page");
	}
	/**
	 * click on terms of services
	 * @throws InterruptedException 
	 * 
	 */
	public void clickTermsOfService() throws InterruptedException {
	 JavascriptExecutor js = (JavascriptExecutor) this.getDriver();
	 js.executeScript("arguments[0].scrollIntoView(false);", termOfService);
	 termOfService.click();
	 System.out.println("click on terms of services");
	 }
	/**
	 * click on proceed to checkout on the shipping page
	 * @throws InterruptedException 
	 * 
	 */
	public void clickProceedToCheckOutOnShippingPage() throws InterruptedException {
	   JavascriptExecutor js = (JavascriptExecutor) this.getDriver();
	   js.executeScript("arguments[0].click()", proceedToCheckOutOnShipping);
		
	   System.out.println("click on proceed to checkout on the shipping page");
	}
	/**
	 * click on pay by bank
	 * @throws InterruptedException 
	 * 
	 */
	public void clickPayByBank() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) this.getDriver();
		js.executeScript("arguments[0].click()", payByBankWire);
	    System.out.println("click on pay by bank");
	}
	/**
	 * click on "I confirm my order" button
	 * @throws InterruptedException 
	 * 
	 */
	public void clickIConfirmMyOrder() throws InterruptedException {
	 JavascriptExecutor js = (JavascriptExecutor) this.getDriver();
	 js.executeScript("arguments[0].click()", iConfirmMyOrder);
	  System.out.println("click on 'I confirm my order' button");
	}
	/**
	 * validate order confirmation page
	 * 
	 */

	public void validateHeaderConfirmation() {
	  assertEquals("ORDER CONFIRMATION", headerConfirmation.getText());	 
	  System.out.println("Order confirmation page is successfully validated");
	}
	/**
	 * validate the order completion status
	 * 
	 */

	public void validateOrderComplete() {
	  assertTrue(orderComplete.getText().contains("Your order on My Store is complete."));	
	  System.out.println("Order completion is successfully validated");
	}
	/**
	 * validate the current page is the last step of ordering
	 * 
	 * 
	 */

	public void validateLastPageOrdering() {
	        assertTrue(this.getDriver().findElement(By.xpath("//li[@class='step_done step_done_last four']")).isDisplayed());
	        assertTrue(this.getDriver().findElement(By.xpath("//li[@id='step_end' and @class='step_current last']")).isDisplayed());
	        assertTrue(this.getDriver().getCurrentUrl().contains("controller=order-confirmation"));	
	        System.out.println("Current page is the last step of ordering step is successfully validated");
	}
	
}

