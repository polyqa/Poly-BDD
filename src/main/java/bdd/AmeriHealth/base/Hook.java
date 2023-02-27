package bdd.AmeriHealth.base;

import static bdd.AmeriHealth.Utils.IConstant.*;

import bdd.AmeriHealth.Utils.ReadProperties;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook {
	BaseClass baseClass;
	ReadProperties envV= new ReadProperties();
	
	@Before
	public void initDriver() {
		baseClass = new BaseClass();
		baseClass.setUpDriver(envV.getProperty(BROWSER));
		
	}
	
	@After
	public void exitingDriver() {
	baseClass.tearup();
		
	}

}
