package aspireTest;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import aspire.pages.MobileOtpPages;
import aspire.pages.RegistrationPages;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterTest {
	

	public static WebDriver driver;
	
	@Before
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}
	
	/*
	 * Test case check register information valid
	 * Expected: the text in the next stage is valid as expected
	 * */
	@Test
	public void testVerifyRegister() throws Exception {
		RegistrationPages register = new RegistrationPages(driver);
		register.navigateToWebSite();
		register.navigateToRegisterPage();
		register.verifyTitleRegisterPage();
		register.inputFullName(register.getDataTest("full_name"));
		register.inputEmail(register.generateNumbersString() + register.getDataTest("email"));
		register.inputPhone(register.generateNumbersString());
		register.openOptions();
		register.selecFirstHearAboutUs();
		register.checkTernAndCondition();
		MobileOtpPages mobileOtp = register.clickContinueButton();
		Thread.sleep(15000);
		mobileOtp.checkTextPhoneOtp();
	}

	/*
	 * Test case check message invalid email
	 * Expected: the message error and icon message is correctly with format
	 * */
	@Test
	public void testVerifyInvalidEmail() {
		RegistrationPages register = new RegistrationPages(driver);
		register.navigateToWebSite();
		register.navigateToRegisterPage();
		register.verifyTitleRegisterPage();
		register.inputFullName(register.getDataTest("full_name"));
		register.inputEmail(register.getDataTest("email_invalid"));
		register.inputPhone(register.generateNumbersString());
		register.verifyEmailMessageError();
		register.verifyIconEmailMessageError();
	}
	
	/*
	 * Test case check message invalid number phone more than 14 digits
	 * Expected: the message error and icon number phone is correctly with format
	 * */
	@Test
	public void testVerifyInvalidNumberPhone() {
		RegistrationPages register = new RegistrationPages(driver);
		invalidNumberPhone(register);
	}
	
	/*
	 * Test case check disable of Continue button
	 * */
	@Test
	public void testVerifyDisableContinueButton() {
		RegistrationPages register = new RegistrationPages(driver);
		invalidNumberPhone(register);
		register.checkDisableContinueButton();
	}
	
	private void invalidNumberPhone(RegistrationPages register) {
		register.navigateToWebSite();
		register.navigateToRegisterPage();
		register.verifyTitleRegisterPage();
		register.inputFullName(register.getDataTest("full_name"));
		register.inputPhone(register.getDataTest("phone_invalid"));
		register.inputEmail(register.getDataTest("email_invalid"));
		register.verifyPhoneMessageError();
		register.verifyIconPhoneMessageError();
	}
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
	}
 
}
