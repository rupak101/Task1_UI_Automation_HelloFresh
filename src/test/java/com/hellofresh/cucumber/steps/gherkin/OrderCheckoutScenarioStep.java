package com.hellofresh.cucumber.steps.gherkin;

import com.hellofresh.cucumber.steps.serenity.HelloFreshSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class OrderCheckoutScenarioStep {

@Steps
HelloFreshSteps helloFreshSteps;

@When("^choose the store type in the header$")
public void choose_the_store_type_in_the_header() throws InterruptedException{
	helloFreshSteps.choose_type_of_store();
}


@When("^click the product with name \"([^\"]*)\"$")
public void click_the_product_with_name(String productName) throws InterruptedException{
	helloFreshSteps.choose_type_of_dress(productName);
}

@When("^click Add to card button$")
public void click_Add_to_card_button() throws InterruptedException{
	//helloFreshSteps.choose_type_of_dress();
}

@When("^click Proceed to checkout on cart page$")
public void click_Proceed_to_checkout_on_cart_page() throws InterruptedException{
	helloFreshSteps.proceed_to_checkout_on_cart_page();
}

@When("^click Proceed to checkout button on summary step$")
public void click_Proceed_to_checkout_button_on_summary_step() throws InterruptedException{
	helloFreshSteps.proceed_to_checkout_on_summary_page();
}

@When("^click Proceed to checkout button on address step$")
public void click_Proceed_to_checkout_button_on_address_step() throws InterruptedException{
	helloFreshSteps.proceed_to_checkout_on_address_page();
}

@When("^click by Terms of service to agree$")
public void click_by_Terms_of_service_to_agree() throws InterruptedException{
	helloFreshSteps.click_terms_of_conditions();
}

@When("^click Proceed to checkout button on shipping step$")
public void click_Proceed_to_checkout_button_on_shipping_step() throws InterruptedException{
	helloFreshSteps.proceed_to_checkout_on_shipping_page();
}

@When("^click by payment method \"([^\"]*)\"$")
public void click_by_payment_method(String arg1) throws InterruptedException{
	helloFreshSteps.pay_by_bank();
}

@When("^click on I confirm my order button$")
public void click_on_I_confirm_my_order_button() throws InterruptedException{
	helloFreshSteps.confirm_my_order();
}

@Then("^order confirmation page is opened$")
public void order_confirmation_page_is_opened() throws InterruptedException{
	helloFreshSteps.validate_order_confirmation_page();   
}

@Then("^the order is complete\\.$")
public void the_order_is_complete() throws InterruptedException{
	helloFreshSteps.validate_order_complete();
}

@Then("^current page is the last step of ordering$")
public void current_page_is_the_last_step_of_ordering() throws InterruptedException{
	helloFreshSteps.last_stage_ordering();
}

}