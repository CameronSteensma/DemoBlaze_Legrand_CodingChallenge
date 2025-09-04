package myFirstpck;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.*;
import java.time.Duration;
import java.util.List;

public class DemoBlaze_AutomatedTests
{
	private WebDriver driver;
	private WebDriverWait wait;

	@BeforeClass
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.demoblaze.com/index.html");
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	}

	@AfterClass
	public void teardown()
	{
		if (driver != null)
		{
			driver.quit();
		}
	}

	@BeforeMethod
	public void goHome(){
		driver.get("https://www.demoblaze.com/index.html");
	}

	private void waitForElement(By locator) 
	{
    	new WebDriverWait(driver, Duration.ofSeconds(5))
        	.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	private void openSignupModal()
	{
		driver.findElement(By.id("signup2")).click();
	}

	private void openLoginModal()
	{
		driver.findElement(By.id("login2")).click();
	}

	private void fillSignupForm(String username, String password)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sign-username"))).sendKeys(username);
		driver.findElement(By.id("sign-password")).sendKeys(password);
		driver.findElement(By.cssSelector("#signInModal .btn-primary")).click();
	}

	private void fillLoginForm(String username, String password)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys(username);
		driver.findElement(By.id("loginpassword")).sendKeys(password);
		driver.findElement(By.cssSelector("#loginModal .btn-primary")).click();
	}

	private boolean isSignupModalDisplayed() {
        return "display: block;".equals(driver.findElement(By.id("signInModal")).getAttribute("style"));
    }

    private boolean isLogoutVisible() {
         List<WebElement> logout = driver.findElements(By.id("logout2"));
        return !logout.isEmpty();
    }

	/* Tests HERE */
	@Test
	public void t_01_validateSignupUsernameAlreadyExists()
	{
		openSignupModal();
		fillSignupForm("cameronsteensma", "abc*");
		Assert.assertTrue(isSignupModalDisplayed(), "Signup modal should remain open if username already exists");
	}

	@Test
	public void t_02_validateSignupEmptyUsername()
	{
		openSignupModal();
		fillSignupForm("", "abc*");
		Assert.assertTrue(isSignupModalDisplayed(), "Signup modal should remain open if username is empty");
	}

	@Test
	public void t_03_validateSignupEmptyPassword()
	{
		openSignupModal();
		fillSignupForm("cameronsteensma", "");
		Assert.assertTrue(isSignupModalDisplayed(), "Signup modal should remain open if password is empty");
	}

	@Test
	public void t_04_validateSignupValidEntries()
	{
		openSignupModal();
		fillSignupForm("newuser123", "validPass1!");
		Assert.assertFalse(isSignupModalDisplayed(), "Signup modal should close on successful signup");
	}

	@Test
	public void t_05_validateLogin_validEntries()
	{
		openLoginModal();
		fillLoginForm("cameronsteensma", "abc*");
		Assert.assertTrue(isLogoutVisible(), "Logout button should be visible after successful login");
	}

	@Test
	public void t_07_validateSignup_InvalidUsername()
	{
		openLoginModal();
		fillLoginForm("invalidUser", "somePass!");
		Assert.assertFalse(isLogoutVisible(), "Logout button should not be visible with empty username");
	}

	@Test
	public void t_08_invalidEntries()
	{
		openLoginModal();
		fillLoginForm("invalidUser", "wrongPass!");
		Assert.assertFalse(isLogoutVisible(), "Logout button should not be visible with invalid credentials");
	}

}
