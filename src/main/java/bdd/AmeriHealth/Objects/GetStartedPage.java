package bdd.AmeriHealth.Objects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class GetStartedPage {
	
	public GetStartedPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath   = "//h1[text()='Where do you live?']")
	WebElement shoppingPageTitle;
	
	
	@FindBy(xpath = "//input[@id='zipCodeInput']")
	WebElement zipCode;
	
	@FindBy(xpath = "(//span[@class='mat-button-wrapper'])[5]")
	WebElement nextBtn;
	

		
	
	

}
