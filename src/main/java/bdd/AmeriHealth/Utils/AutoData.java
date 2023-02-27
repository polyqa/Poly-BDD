package bdd.AmeriHealth.Utils;

public class AutoData {
	
	private String landingPageTitle;
	private String careerPageTitle;
	
	public AutoData(String landingPageTitle, String careerPageTitle1) {
		
		if (landingPageTitle == null || careerPageTitle1 == null ||
				landingPageTitle.length() == 0 || careerPageTitle1.length() == 0) {
			throw new NullPointerException();
		} else {
			this.landingPageTitle = landingPageTitle;
			careerPageTitle = careerPageTitle1;

		}
	}
	
	public String getLandingPageTitle() {
		return landingPageTitle;
	}
	public String getCareerPageTitle() {
		return careerPageTitle;
	}
	

}
