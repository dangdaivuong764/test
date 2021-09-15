package aspire.pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import aspire.base.AspireAbstractPages;

public class PersonalDetailPages extends AspireAbstractPages {

	public PersonalDetailPages(WebDriver driver) {
		super(driver);
	}

	By additionalDetailEle = By.cssSelector(".text-h4");
	By arrowDownEle = By.xpath("//i[@role='presentation']");
	By selecoptionEle = By.xpath("//div[@class='q-item__label ellipsis']");

	By selectCheckBoxEle = By.cssSelector(".q-radio__label");

	By selectOptionsCompanyEle = By.xpath("//div[@url='countries/all']//i[@role='presentation']");
	By selectFirstCompanyEle = By.xpath("//div[@class='q-item__label']");
	By continueButtonEle = By.xpath("//button");
	By learnMoreEle = By.xpath("//span[@class='block']");

	public void checkTextnavigateToAdditionalDetail() {
		String textAboutYourself = waiAndCheckVisibility(additionalDetailEle).getText().trim().toString();
		assertTrue("The text addtional detail does not match",
				textAboutYourself.equalsIgnoreCase(TEXT_ADDITIONAL_DETAIL));
	}

	public void clickOnArrowDown() {
		WebElement arrowDown = waiAndCheckVisibility(arrowDownEle);
		moveAndClick(arrowDown);
	}

	public void selectFirstOptions() {
		WebElement optionEle = selectFirstOptions(selecoptionEle);
		moveAndClick(optionEle);
	}

	public void selectFirstCheckBox() {
		WebElement checkBoxEle = selectFirstOptions(selectCheckBoxEle);
		moveAndClick(checkBoxEle);
	}

	public void openListCompany() {
		WebElement optionsComapny = waiAndCheckVisibility(selectOptionsCompanyEle);
		moveAndClick(optionsComapny);
	}

	public void selectFirstCompany() {
		WebElement selectFirstCompany = selectFirstOptions(selectFirstCompanyEle);
		moveAndClick(selectFirstCompany);
	}

	public void checkDisableContinueButton() {
		WebElement continueButton = waiAndCheckVisibility(continueButtonEle);
		moveIntoView(continueButton);
		assertTrue("The Continue button is enabled", !continueButton.isEnabled());
	}
	
	public void clickOnContinuebutton() {
		WebElement continueButton = waiAndCheckVisibility(continueButtonEle);
		moveAndClick(continueButton);
	}
	
	public void clickOnLearMoreButton() {
		WebElement learnMoreButton = waiAndCheckVisibility(learnMoreEle);
		moveAndClick(learnMoreButton);
	}
	
	public void clickOnGetStartButton() {
		WebElement learnMoreButton = waiAndCheckVisibility(learnMoreEle);
		moveAndClick(learnMoreButton);
	}
	
	public IncorporateYourCompanyPages clickOnGetStarOverviewtButton() {
		WebElement learnMoreButton = waiAndCheckVisibility(learnMoreEle);
		moveAndClick(learnMoreButton);
		return new IncorporateYourCompanyPages(driver);
	}

}
