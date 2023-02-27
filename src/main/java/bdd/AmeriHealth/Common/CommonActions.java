package bdd.AmeriHealth.Common;

import static bdd.AmeriHealth.Utils.IConstant.*;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import bdd.AmeriHealth.Utils.ReadProperties;
import bdd.AmeriHealth.Reportings.Logs;

public class CommonActions {
	
	ReadProperties envProperties = new ReadProperties();
	public WebDriverWait wait;
	
	public CommonActions(WebDriver driver) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(envProperties.getNumProperty(EXPLICIT_WAIT)));
	}
	
	public  void clickElement(WebElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			
			Logs.log(element + "<---->has been clicked");
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Logs.log(element + "<---->has not been clicked");
			Assert.fail();
		}
	}

	public  void validate(WebElement element, String expected) {
		String actual = "";
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			actual = element.getText();
			Logs.log("Validating --->actual :" + actual + "***Expected : " + expected);
		} catch (NoSuchElementException | NullPointerException e) {
			Logs.log(element + "<---->has not been clicked");
			Assert.fail();
		}
		Assert.assertEquals(actual, expected);
	}

	public  void inputText(WebElement element, String input) {
		try {wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
			element.sendKeys(input);
			Logs.log(input + "<---->has been put into" + element);
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Logs.log(element + "<---->has not been clicked, so couldn't put input");
			Assert.fail();
		}
	}

}
