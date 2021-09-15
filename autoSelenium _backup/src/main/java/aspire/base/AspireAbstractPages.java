package aspire.base;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import aspire.pages.RegistrationPages;
import readProperites.ReadProperties;

public class AspireAbstractPages {
	
	private static final String URL = "https://feature-qa-automation.customer-frontend.staging.aspireapp.com/sg/login";

	public static final String EMAIL_MESSAGE_ERROR = "Email address must be a valid email address.";

	public static final String EMAIL_PHONE_ERROR = "Mobile number may not be greater than 14 digits.";

	public static final String OTP_MESSAGE_ERROR = "The OTP you entered is invalid or expired.";
	
	public static final String TEXT_PHONE_OTP = "Enter phone OTP";
	
	public static final String OTP_MESSAGE_SUCCESSFULL = "You have successfully verified your mobile number. You’re on to a great start!";
	
	public static final String TEXT_TELL_ABOUT_YOURSELF = "Tell us more about yourself";

	public static final String TEXT_ADDITIONAL_DETAIL = "Additional details";


	protected 	WebDriver driver;
	
	public AspireAbstractPages (WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public RegistrationPages navigateToWebSite() {
		driver.get(URL);
		return new RegistrationPages(driver);
	}

	/*
	 * @param: By element
	 * Check the element displayed
	 * */
	public WebElement waiAndCheckVisibility(By element) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
									.withTimeout(Duration.ofSeconds(50))		
									.pollingEvery(Duration.ofMillis(10))		
									.ignoring(NoSuchElementException.class);
		WebElement ele_wait = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					boolean checkEle = false;
					if (driver.findElement(element).isDisplayed()) {
						checkEle = true;
						return driver.findElement(element);
					}
					assertTrue("the element is not displayed ", checkEle);
					return null;
				}
		});
		return ele_wait;
	}
	
	/*
	 * @param: By element
	 * Get list the element displayed
	 * */
	public List<WebElement> waiAndCheckVisibilityListEle(By element) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
									.withTimeout(Duration.ofSeconds(50))		
									.pollingEvery(Duration.ofMillis(10))		
									.ignoring(NoSuchElementException.class);
		List<WebElement> ele_waits = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
		return ele_waits;
	}

	/*
	 * @param: By element
	 * Select the first options in the list element
	 * */
	public WebElement selectFirstOptions(By element) {
		List<WebElement> listEle = waiAndCheckVisibilityListEle(element);
		boolean check_flags = listEle.size() == 0;
		if (check_flags) {
			assertFalse("The list options is null" , check_flags);
		}
		return listEle.get(0);
	}
	
	/*
	 * @param: Weblement element
	 * Move to the specific element and click on it
	 * */
	public void moveAndClick(WebElement optionEle) {
		Actions builder = new Actions(driver);
        Action mouseToEle = builder
			                .moveToElement(optionEle)
			                .click()
			                .build();
		mouseToEle.perform();
	}
	
	/*
	 * @param: Weblement element
	 * Move to the specific element and click on it
	 * */
	public void moveAndDoubleClick(WebElement optionEle) {
		Actions builder = new Actions(driver);
        Action mouseToEle = builder
			                .moveToElement(optionEle)
			                .doubleClick()
			                .build();
		mouseToEle.perform();
	}
	
	/*
	 * @param: Weblement element
	 * Move to the specific element
	 * */
	public void moveIntoView(WebElement optionEle) {
		Actions builder = new Actions(driver);
        Action mouseToEle = builder
			                .moveToElement(optionEle)
			                .build();
		mouseToEle.perform();
	}
	
	/*
	 * @param: Webelement
	 * @value: value
	 * Move to the specific element and input the value
	 */
	public void moveAndSenKeys(WebElement optionEle, String keuValue) {
		Actions builder = new Actions(driver);
        Action mouseToEle = builder
			                .moveToElement(optionEle)
			                .sendKeys(keuValue)
			                .build();
		mouseToEle.perform();
	}
	
	/*
	 * @param: By element
	 * Check text element is not null
	 * */
	public void checkTextElementNotEmpty(By element) {
		String textEle = waiAndCheckVisibility(element).getText().trim().toString();
		assertNotNull("The text element is null ", textEle);
	}

	public String getDataTest(String key) {
		ReadProperties properties = new ReadProperties();
		return properties.getDataObject(key);
	}

	public String generateNumbersString() {
		 Random rnd = new Random();
		    int number = rnd.nextInt(99999999);
		    return String.format("%06d", number);
	}
	
	public void waitAfterNavigateTo(final int timeDeplay) throws Exception {
		Thread.sleep(timeDeplay);
	}

}
