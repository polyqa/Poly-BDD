package bdd.AmeriHealth.base;

import static bdd.AmeriHealth.Utils.IConstant.*;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import bdd.AmeriHealth.Objects.CareerPage;
import bdd.AmeriHealth.Objects.GetStartedPage;
import bdd.AmeriHealth.Objects.LandingPage;
import bdd.AmeriHealth.Utils.Constant;
import bdd.AmeriHealth.Utils.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass  {
	
	public static WebDriver driver;
	public static LandingPage landingPage;
	public static GetStartedPage getStartedPage;
	public static CareerPage careerPage;
	ReadProperties envV= new ReadProperties();


	public void setUpDriver(String browser) {
		 //driver = new ChromeDriver();
	   // String browser = envV.getProperty(BROWSER);
		String url = envV.getProperty(URL);
		long pageLoadwait =envV.getNumProperty(PAGELOAD_WAIT);
		long implicitlyWait = envV.getNumProperty(IMPLICITLY_WAIT );
		initDriver(browser);
		initClasses(driver);
		//driver.get(browser);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadwait));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWait));

	}

	public void initClasses(WebDriver driver) {
		landingPage = new LandingPage(driver);
		getStartedPage = new GetStartedPage(driver);
		careerPage = new CareerPage(driver);
	}

	public void initDriver(String driverName) {
		switch (driverName) {
		case CHROME:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case SAFARI:
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			break;

		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		}
	}


	public void tearup() {
		driver.quit();

	}
	
	

	@SuppressWarnings("unused")
	private String getString(Constant constant) {
		return constant.name();
	}


}
