package aspire.pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import aspire.base.AspireAbstractPages;

public class BussinessRolePages extends AspireAbstractPages{

	public BussinessRolePages(WebDriver driver) {
		super(driver);
	}
	
	By aboutYourselfEle = By.cssSelector(".text-h4");
	By imageDirectoryEle = By.xpath("//img[@src='img/auth/director.svg']");
	By descriptionDirectoryEle = By.xpath("//img[@src='img/auth/director.svg']/../div");

	By imageEmployeeEle = By.xpath("//img[@src='img/auth/employee.svg']");
	By descriptionEmployeeEle = By.xpath("//img[@src='img/auth/employee.svg']/../div");

	By imageFreelancerEle = By.xpath("//img[@src='img/auth/freelancer.svg']");
	By descriptionFreelancerEle = By.xpath("//img[@src='img/auth/freelancer.svg']/../div");
	
	By imageCompanyEle = By.xpath("//img[@src='img/auth/incorp.svg']");
	By descriptionCompanyEle = By.xpath("//img[@src='img/auth/incorp.svg']/../div");

	public void checkTextnavigateToBussnessRole() {
		String textAboutYourself = waiAndCheckVisibility(aboutYourselfEle).getText().trim().toString();
		assertTrue("The text about yourself does not match", textAboutYourself.equalsIgnoreCase(TEXT_TELL_ABOUT_YOURSELF));
	}

	public void checkDisplayOfimageDirectory() {
		waiAndCheckVisibility(imageDirectoryEle);
	}
	
	public void checkDisplayOfDescriptionDirectory() {
		checkTextElementNotEmpty(descriptionDirectoryEle);
	}

	public void checkDisplayOfimageEmployee() {
		waiAndCheckVisibility(imageEmployeeEle);
	}

	public void checkDisplayOfDescriptionEmployee() {
		checkTextElementNotEmpty(descriptionEmployeeEle);
	}

	public void checkDisplayOfimageFreelancer() {
		waiAndCheckVisibility(imageFreelancerEle);
	}
	
	public void checkDisplayOfDescriptionFreelancer() {
		checkTextElementNotEmpty(descriptionFreelancerEle);
	}
	
	public void checkDisplayOfimageCompany() {
		waiAndCheckVisibility(imageCompanyEle);
	}
	
	public void checkDisplayOfDescriptionCompany() {
		checkTextElementNotEmpty(descriptionCompanyEle);
	}
	
	public PersonalDetailPages clickOnFreelancer() {
		WebElement freelancer = waiAndCheckVisibility(imageFreelancerEle);
		moveAndClick(freelancer);
		return new PersonalDetailPages(driver);
	}

	public void waitAfterNavigateTo(final int value) {
		waitAfterNavigateTo(value);
	}
}
