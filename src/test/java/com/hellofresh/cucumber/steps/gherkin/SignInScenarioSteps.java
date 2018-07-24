package com.hellofresh.cucumber.steps.gherkin;

import com.hellofresh.cucumber.steps.serenity.HelloFreshSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class SignInScenarioSteps {
	@Steps
	HelloFreshSteps helloFreshSteps;
	
	@Given("^open homepage url$")
	public void open_homepage_url() {		
	helloFreshSteps.open_hellofresh_home_page();
	}
	
	@When("^click Sign in button$")
	public void click_Sign_in_button() {
		helloFreshSteps.click_signin_link();
		
	}

	@When("^fill Email address to create an account$")
	public void fill_Email_address_to_create_an_account(){
		helloFreshSteps.fill_email_address();
	}

	@When("^click Create an account$")
	public void click_Create_an_account() throws Throwable {
		helloFreshSteps.click_Create_Account_button();
	}

	@When("^Fill all fields with correct data \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void fill_all_fields_with_correct_data(String firstName, String lastName, String address, String city, String postalCode, String mobile,String info){
		helloFreshSteps.fill_customer_data(firstName,lastName,address,city,postalCode,mobile,info);
	
	}

	@When("^Click Register button$")
	public void click_Register_button() throws InterruptedException {
		helloFreshSteps.click_submit_account_button();
	}

	@Then("^verify the my account page is opened$")
	public void verify_the_my_account_page_is_opened() throws Throwable {
		helloFreshSteps.validate_my_account_page();
	}

	@Then("^Proper username \"([^\"]*)\",\"([^\"]*)\" is shown in the header$")
	public void proper_username_is_shown_in_the_header(String firstNameValue,String lastNameValue) throws Throwable {
		helloFreshSteps.validate_user_name(firstNameValue,lastNameValue);
	}

	@Then("^Log out action is available$")
	public void log_out_action_is_available() throws Throwable {
		helloFreshSteps.validate_logout_action_available();
	
	}
}