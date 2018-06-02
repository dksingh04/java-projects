package com.test.cucumbertest.aut.stepdef;

import org.springframework.beans.factory.annotation.Autowired;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestSteps {
	// private Customer customer;
	// private Item item;
	@Autowired
	AppProperties prop;
	

	@Given("^that (.*) bought a faulty (.*) for \\$(\\d+)$")
	public void that_bought_a_faulty_kettle(String name, String itemType, int price) throws Throwable {
		System.out.println("In Given: " + prop.getKey1());
	}

	@When("^he return the kettle to the store$")
	public void return_the_an_item_to_the_store() throws Throwable {
		System.out.println("In When");
	}

	@Then("^he will get \\$(\\d+) refunded$")
	public void she_will_get_$_back(int expected) throws Throwable {
		System.out.println("In Then");
	}
}