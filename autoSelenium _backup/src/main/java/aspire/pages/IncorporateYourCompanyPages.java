package aspire.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import aspire.base.AspireAbstractPages;

public class IncorporateYourCompanyPages extends AspireAbstractPages {

	public IncorporateYourCompanyPages(WebDriver driver) {
		super(driver);
	}
	
	By openListCompanyEle = By.xpath("//div[@url='countries/all']//i[@role='presentation']");
	By selectFirstCompanyEle = By.xpath("//div[@class='q-item__label']");
	By continueButtonEle = By.xpath("//button//span[@class='block']");
	By selectpackageEle = By.cssSelector(".q-card__section");

	public void openListCompany() {
		WebElement openListComapny = waiAndCheckVisibility(openListCompanyEle);
		moveAndClick(openListComapny);
	}

	public void selectFirstCompany() {
		WebElement selectFirstCompany = selectFirstOptions(selectFirstCompanyEle);
		moveAndClick(selectFirstCompany);
	}
	
	public void clickOnContinueButton() {
		WebElement continueButton = waiAndCheckVisibility(continueButtonEle);
		moveAndClick(continueButton);
	}

	public BussinessDetailPages clickOnFirstPackages() {
		WebElement continueButton = selectFirstOptions(selectpackageEle);
		moveAndClick(continueButton);
		return new BussinessDetailPages(driver);
	}
}
