package com.hellofresh.cucumber.steps.serenity;

import com.hellofresh.cucumber.pages.LoginPage;
import com.hellofresh.cucumber.pages.OrderCheckoutPage;
import com.hellofresh.cucumber.pages.SignInPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class HelloFreshSteps extends ScenarioSteps{
	LoginPage loginPage;
	SignInPage signinPage;
	OrderCheckoutPage orderCheckoutPage;	
    
    @Step
    public void open_hellofresh_home_page(){
    	signinPage.open();
    }
    
    @Step
    public void click_signin_link(){
    	signinPage.clickSignInLink(); 
    }
    
    @Step
    public void fill_email_address(){
    	signinPage.fillEmail();
    }
    
    @Step
    public void click_Create_Account_button(){
    	signinPage.clickCreateAccountButton();

    }
    
    @Step
    public void fill_customer_data(String firstName,String lastName,String address,String city,String pincode ,String phoneNumber, String info) {
    	signinPage.fillCustomerData(firstName,lastName,address,city,pincode,phoneNumber,info);
    }
    
    @Step
    public void click_submit_account_button() throws InterruptedException {
    	signinPage.clickSubmitAccountButton();
    }
    
    @Step
    public void validate_my_account_page() throws InterruptedException {
    	signinPage.validateMyAccount();
    }
    @Step
    public void validate_user_name(String firstName,String lastName) throws InterruptedException {
    	signinPage.validateUserName(firstName,lastName);
    }
    
    @Step
    public void validate_logout_action_available() throws InterruptedException {
    	signinPage.validateLogout();
    }
    
    @Step
    public void enter_email_and_password() {
    	loginPage.enterEmailAndPassword();
    }
    @Step
    public void click_signin_button() {
    	loginPage.clickSignIn();
    }
    
    @Step
    public void choose_type_of_store() throws InterruptedException{  
    	orderCheckoutPage.clickTypeOfStore();
    	
    }
    @Step
    public void choose_type_of_dress(String productName) throws InterruptedException{  
    	orderCheckoutPage.chooseTypeOfDress(productName);
    }
    @Step
    public void proceed_to_checkout_on_cart_page() throws InterruptedException{  
    	orderCheckoutPage.clickProceedToCheckOutOnCartPage();
    }
    @Step
    public void proceed_to_checkout_on_summary_page() throws InterruptedException{  
    	orderCheckoutPage.clickProceedToCheckOutOnSummaryPage();
    }
    @Step
    public void proceed_to_checkout_on_address_page() throws InterruptedException{  
    	orderCheckoutPage.clickProceedToCheckOutOnAddressPage();
    }
    @Step
    public void click_terms_of_conditions() throws InterruptedException{  
    	orderCheckoutPage.clickTermsOfService();
    }
    @Step
    public void proceed_to_checkout_on_shipping_page() throws InterruptedException{  
    	orderCheckoutPage.clickProceedToCheckOutOnShippingPage();
    }
    @Step
    public void pay_by_bank() throws InterruptedException{  
    	orderCheckoutPage.clickPayByBank();
    }
    @Step
    public void confirm_my_order() throws InterruptedException{   		
    	orderCheckoutPage.clickIConfirmMyOrder();
    }
    @Step
    public void validate_order_confirmation_page() throws InterruptedException{   		
    	orderCheckoutPage.validateHeaderConfirmation();
    }
    @Step
    public void validate_order_complete() throws InterruptedException{   		
    	orderCheckoutPage.validateOrderComplete();
    }
    @Step
    public void last_stage_ordering() throws InterruptedException{   		
    	orderCheckoutPage.validateLastPageOrdering();
    }
}
