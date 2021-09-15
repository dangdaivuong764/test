package aspire.pages;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import aspire.base.AspireAbstractPages;

public class MobileOtpPages extends AspireAbstractPages {

	public MobileOtpPages(WebDriver driver) {
		super(driver);
	}

	By digitsEle = By.cssSelector(".digit-input__input.digit-input__input--highlight");
	By textPhoneOtpEle = By.cssSelector(".text-h4");
	By textInvalidMessageOtpEle = By.xpath("//div[@class='aspire-label__text text-negative']");
	By iconInvalidMessageOtpEle = By.xpath("//img[@src='img/common/error.svg']");
	By continueButtonEle = By.xpath("//button//span[@class='block']");
	By messageSuccessfullEle = By.cssSelector(".aspire-cta-screen__content-text");

	public void inputDigitsOTP(String keyValue) {
		WebElement optionEle = waiAndCheckVisibility(digitsEle);
		moveAndSenKeys(optionEle, keyValue);		
	}

	public void checkTextPhoneOtp() {
		String textPhontOtp = waiAndCheckVisibility(textPhoneOtpEle).getText().trim().toString();
		assertTrue("The text phone otp does not match", textPhontOtp.equalsIgnoreCase(TEXT_PHONE_OTP));
	}

	public void checkMessageInvalidOTP() {
		WebElement textInvalidEle = waiAndCheckVisibility(textInvalidMessageOtpEle);
		assertEquals(OTP_MESSAGE_ERROR, textInvalidEle.getText().trim().toString(), "The actual result does not match with expected result");
	}

	public BussinessRolePages clickOnContinueButton() {
		WebElement continueButton = waiAndCheckVisibility(continueButtonEle);
		moveAndClick(continueButton);
		return new BussinessRolePages(driver);
	}

	public void verifyMessageSuccessfull() {
		WebElement messageSuccessfull = waiAndCheckVisibility(messageSuccessfullEle);
		assertEquals(OTP_MESSAGE_SUCCESSFULL, messageSuccessfull.getText().trim().toString(), "The actual result does not match with expected result");
	}

}
