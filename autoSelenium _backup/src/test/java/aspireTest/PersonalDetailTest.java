package aspireTest;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import aspire.pages.BussinessRolePages;
import aspire.pages.MobileOtpPages;
import aspire.pages.PersonalDetailPages;
import aspire.pages.RegistrationPages;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PersonalDetailTest {

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
	 * Test case check input additional details
	 */
	@Test
	public void testVerifyPersonalDetail() throws Exception {
		RegistrationPages register = new RegistrationPages(driver);
		PersonalDetailPages personalDetail = validRegisterAndMobileOtpAndBussinessRoleStage(register);
		personalDetail.clickOnArrowDown();
		personalDetail.selectFirstOptions();
		personalDetail.clickOnArrowDown();
		waitAfterNavigateTo(500);
		personalDetail.selectFirstCheckBox();
		personalDetail.openListCompany();
		waitAfterNavigateTo(500);
		personalDetail.selectFirstCompany();
		personalDetail.clickOnContinuebutton();
		waitAfterNavigateTo(10000);
		personalDetail.clickOnLearMoreButton();
		waitAfterNavigateTo(1000);
		personalDetail.clickOnGetStartButton();
		waitAfterNavigateTo(1000);
		personalDetail.clickOnGetStarOverviewtButton();
	}

	/*
	 * Test case check disable button continue
	 */
	@Test
	public void testVerifyDisableContinuebutton() throws Exception {
		RegistrationPages register = new RegistrationPages(driver);
		PersonalDetailPages personalDetail = validRegisterAndMobileOtpAndBussinessRoleStage(register);
		personalDetail.clickOnArrowDown();
		personalDetail.selectFirstOptions();
		personalDetail.clickOnArrowDown();
		waitAfterNavigateTo(500);
		personalDetail.selectFirstCheckBox();
		personalDetail.checkDisableContinueButton();
	}

	private PersonalDetailPages validRegisterAndMobileOtpAndBussinessRoleStage(RegistrationPages register) throws Exception {
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
		waitAfterNavigateTo(15000);
		mobileOtp.checkTextPhoneOtp();
		mobileOtp.inputDigitsOTP(register.getDataTest("first_otp"));
		mobileOtp.inputDigitsOTP(register.getDataTest("second_otp"));
		mobileOtp.inputDigitsOTP(register.getDataTest("third_otp"));
		mobileOtp.inputDigitsOTP(register.getDataTest("four_otp"));
		waitAfterNavigateTo(3000);
		mobileOtp.verifyMessageSuccessfull();
		BussinessRolePages bussinessRole = mobileOtp.clickOnContinueButton();
		waitAfterNavigateTo(3000);
		bussinessRole.checkDisplayOfimageDirectory();
		bussinessRole.checkDisplayOfDescriptionDirectory();
		bussinessRole.checkDisplayOfimageEmployee();
		bussinessRole.checkDisplayOfDescriptionEmployee();
		bussinessRole.checkDisplayOfimageFreelancer();
		bussinessRole.checkDisplayOfDescriptionFreelancer();
		bussinessRole.checkDisplayOfimageCompany();
		bussinessRole.checkDisplayOfDescriptionCompany();
		PersonalDetailPages personalDetail = bussinessRole.clickOnFreelancer();
		waitAfterNavigateTo(3000);
		return personalDetail;
	}

	private void waitAfterNavigateTo(int timeDeplay) throws Exception {
		Thread.sleep(timeDeplay);
	}

	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
	}
}
