package aspire.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import aspire.base.AspireAbstractPages;

public class BussinessDetailPages extends AspireAbstractPages{

	public BussinessDetailPages(WebDriver driver) {
		super(driver);
	}
	
	By bussinesDescriptionEle = By.xpath("//input[@data-cy='incorporated-step-business-details-business-name']");

}
