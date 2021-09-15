package aspire.pages;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import aspire.base.AspireAbstractPages;

public class RegistrationPages extends AspireAbstractPages {

	public RegistrationPages(WebDriver driver) {
		super(driver);
	}

	private static final String TITLE = "Let's get started | Aspire";

	By loginEle = By.linkText("Register");
	By fullNameEle = By.xpath("//input[@name='full_name']");
	By emailEle = By.xpath("//input[@name='email']");
	By emailMessageEle = By.xpath("//div[@name='email']/div/div");
	By iconEmailMessageEle = By.xpath("//div[@name='email']/div/img");
	By numberPhoneEle = By.xpath("//input[@name='phone']");
	By phoneMessageEle = By.xpath("//div[@name='phone']/div/div");
	By iconPhoneMessageEle = By.xpath("//div[@name='phone']/div/img");
	By optionRole = By.xpath("//div[@role='option']");
	By aboutHeard = By.xpath("//div[@data-cy='register-person-heard-about']//i[@role= 'presentation']");
	By checkTernAndCondition = By.cssSelector(".q-checkbox__svg.absolute-full");
	By continueButton = By.cssSelector(".block");
	By loginButton = By.xpath("//a[@role ='link']//span[@class ='block']");
	By disabledContinueButton = By.xpath("//button");


	public void navigateToRegisterPage() {
		WebElement input_element = driver.findElement(loginEle);
		input_element.click();
	}

	public void inputFullName(String fullNameValue) {
		WebElement input_element = waiAndCheckVisibility(fullNameEle);
		input_element.sendKeys(fullNameValue);
	}

	public void inputEmail(String emailValue) {
		WebElement input_element = waiAndCheckVisibility(emailEle);
		input_element.sendKeys(emailValue);
	}

	public String verifyEmailMessageError() {
		String getTextMessageError = waiAndCheckVisibility(emailMessageEle).getText().trim().toString();
		assertTrue("The message error does not match", getTextMessageError.equalsIgnoreCase(EMAIL_MESSAGE_ERROR));
		return getTextMessageError;
	}

	public void verifyIconEmailMessageError() {
		WebElement getIconImage = waiAndCheckVisibility(iconEmailMessageEle);
		assertTrue("The icon email does not exist " , getIconImage.isDisplayed());
	}

	public void inputPhone(String phoneValue) {
		WebElement input_element = waiAndCheckVisibility(numberPhoneEle);
		input_element.sendKeys(phoneValue);
	}
	
	public String verifyPhoneMessageError() {
		String getTextMessageError = waiAndCheckVisibility(phoneMessageEle).getText().trim().toString();
		assertTrue("The message error does not match" + getTextMessageError, getTextMessageError.equalsIgnoreCase(EMAIL_PHONE_ERROR));
		return getTextMessageError;
	}

	public void verifyIconPhoneMessageError() {
		WebElement getIconImage = waiAndCheckVisibility(iconPhoneMessageEle);
		assertTrue("The icon email does not exist " , getIconImage.isDisplayed());
	}

	public void verifyTitleRegisterPage() {
		String getTitle = driver.getTitle();
		assertEquals(TITLE, getTitle.trim(), "The actual result does not match with expected result");
	}

	public void openOptions() {
		WebElement optionEle = waiAndCheckVisibility(aboutHeard);
		moveAndClick(optionEle);
	}

	public void selecFirstHearAboutUs() {
		WebElement optionEle = selectFirstOptions(optionRole);
		moveAndClick(optionEle);
	}

	public void checkTernAndCondition() {
		WebElement optionEle = waiAndCheckVisibility(checkTernAndCondition);
		moveAndClick(optionEle);
	}

	public MobileOtpPages clickContinueButton() {
		WebElement optionEle = waiAndCheckVisibility(continueButton);
		moveAndClick(optionEle);
		return new MobileOtpPages(driver);
	}

	public void clickLoginButton() {
		WebElement optionEle = waiAndCheckVisibility(loginButton);
		moveAndClick(optionEle);
	}

	public void checkDisableContinueButton() {
		WebElement continueButtonEle = waiAndCheckVisibility(disabledContinueButton);
		moveIntoView(continueButtonEle);
		assertTrue("The Continue button is enabled" , !continueButtonEle.isEnabled());
	}

	public void waitAfterNavigateTo(final int value) {
		waitAfterNavigateTo(value);
	}

}
