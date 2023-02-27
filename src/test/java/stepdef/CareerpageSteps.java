package stepdef;

import bdd.AmeriHealth.base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CareerpageSteps extends BaseClass {
	
	@Given("validating landing page title")
	public void validating_landing_page_title() {
		careerPage.validateLandingPageTitle("The only plan you need.");
	   
	}

	@Given("click career button")
	public void click_career_button() {
		careerPage.clickCareerBtn(driver);
	   
	}

	@When("validate career page title")
	public void validate_career_page_title() {
		careerPage.validateCareerPageTitle("Corporate culture");
	   
	}

	@When("click see current job")
	public void click_see_current_job() throws InterruptedException {
		careerPage.clickSeeCurrentJob(driver);
		Thread.sleep(5000);
	   
	}

	@Then("input job keyword")
	public void input_job_keyword() {
		careerPage.inputJobKeyword(driver);
	    
	}

	@Then("click search button")
	public void click_search_button() {
		careerPage.clickSearchBtn();
	    
	}

}
