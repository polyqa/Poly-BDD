package bdd.AmeriHealth.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bdd.AmeriHealth.Common.CommonActions;

public class LandingPage {
	
	CommonActions actions;

	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		actions = new CommonActions(driver);
		
	}

	@FindBy(tagName = "h2")
	WebElement landingPageTitle;

	@FindBy(css = "a.btn.btnHeroCTA.shop")
	WebElement shopForPlan;

	@FindBy(xpath = "h1")
	WebElement memberPageTitle;

	@FindBy(xpath = "(//a[@class='more'])[2]")
	WebElement applyNow;

	public void validateLandingPageTitle(String expectedTitle) {
		actions .validate(landingPageTitle, expectedTitle);
	}

	public void clickShopForPlan() {
		actions .clickElement(shopForPlan);
	}

	public void validatememberPageTitle(String expectedTitle) {
		actions .validate(landingPageTitle, expectedTitle);
	}

	public void clickapplyNow() {
		actions .clickElement(applyNow);
	}

}
