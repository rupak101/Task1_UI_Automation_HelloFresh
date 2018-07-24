package com.hellofresh.cucumber.steps.gherkin;

import com.hellofresh.cucumber.steps.serenity.HelloFreshSteps;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class LoginScenarioSteps {
	@Steps
	HelloFreshSteps helloFreshSteps;

	@When("^enter the Email address and password for already registered customer$")
	public void enter_the_Email_address_and_password_for_already_registered_customer() {
		helloFreshSteps.enter_email_and_password();
	}
	@When("^click sign in button for registered customer$")
	public void click_sign_in_button_for_registered_customer() {
		helloFreshSteps.click_signin_button();
	}
}