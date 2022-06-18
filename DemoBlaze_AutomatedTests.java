package myFirstpck;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DemoBlaze_AutomatedTests
{

	
	public void t_01_validateSignupUsernameAlreadyExists()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.demoblaze.com/index.html");
		driver.findElement(By.id("signup2")).click();
		driver.findElement(By.id("sign-username")).sendKeys("cameronsteensma");

		driver.findElement(By.id("sign-password")).sendKeys("abc*");
		driver.findElement(By.className("btn btn-primary")).click();
		Assert.assertEquals("display: block;", driver.findElement(By.id("signInModal")).getAttribute("style"));
	}

	public void t_02_validateSignupEmptyUsername()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.demoblaze.com/index.html");
		driver.findElement(By.id("signup2")).click();
		driver.findElement(By.id("sign-username")).sendKeys("");

		driver.findElement(By.id("sign-password")).sendKeys("abc*");
		driver.findElement(By.className("btn btn-primary")).click();
		Assert.assertEquals("display: block;", driver.findElement(By.id("signInModal")).getAttribute("style"));
	}

	public void t_03_validateSignupEmptyPassword()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.demoblaze.com/index.html");
		driver.findElement(By.id("signup2")).click();
		driver.findElement(By.id("sign-username")).sendKeys("cameronsteensma");

		driver.findElement(By.id("sign-password")).sendKeys("");
		driver.findElement(By.className("btn btn-primary")).click();
		Assert.assertEquals("display: block;", driver.findElement(By.id("signInModal")).getAttribute("style"));
	}

	public void t_04_validateSignupValidEntries()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.demoblaze.com/index.html");
		driver.findElement(By.id("signup2")).click();
		driver.findElement(By.id("sign-username")).sendKeys("cameronsteensma");

		driver.findElement(By.id("sign-password")).sendKeys("abc*");
		driver.findElement(By.className("btn btn-primary")).click();
		Assert.assertEquals("display: none;", driver.findElement(By.id("signInModal")).getAttribute("style"));
	}

	public void t_05_validateLogin_validEntries()
	{
		WebDriver driver = new ChromeDriver();
		// Retrieve URL
		driver.get("https://www.demoblaze.com/index.html");
		// Click login
		driver.findElement(By.id("login2")).click();
		// Set username
		WebElement txt_username = driver.findElement(By.id("loginusername"));
		txt_username.sendKeys("username");
		// Set password
		driver.findElement(By.id("loginpassword")).sendKeys("password");
		driver.findElement(By.className("btn btn-primary")).click();

		WebElement result = driver.findElement(By.id("logout2"));
		if (result != null)
		{
			System.out.println("Success!");

		} else
		{
			System.out.println("Failed to login");
		}
	}

	public void t_06_validateSignup_validUserNameInValidPassword()
	{
		WebDriver driver = new ChromeDriver();
		// Retrieve URL
		driver.get("https://www.demoblaze.com/index.html");
		// Click login
		driver.findElement(By.id("login2")).click();
		// Set username
		WebElement txt_username = driver.findElement(By.id("loginusername"));
		txt_username.sendKeys("username");
		// Set password
		driver.findElement(By.id("loginpassword")).sendKeys("");
		driver.findElement(By.className("btn btn-primary")).click();

		WebElement result = driver.findElement(By.id("logout2"));
		if (result == null)
		{
			System.out.println("Success!");

		} else
		{
			System.out.println("Failed to login");
		}
	}

	public void t_07_validateSignup_InvalidUsername()
	{
		WebDriver driver = new ChromeDriver();
		// Retrieve URL
		driver.get("https://www.demoblaze.com/index.html");
		// Click login
		driver.findElement(By.id("login2")).click();
		// Set username
		WebElement txt_username = driver.findElement(By.id("loginusername"));
		txt_username.sendKeys("");
		// Set password
		driver.findElement(By.id("loginpassword")).sendKeys("abc*");
		driver.findElement(By.className("btn btn-primary")).click();

		WebElement result = driver.findElement(By.id("logout2"));
		if (result == null)
		{
			System.out.println("Success!");

		} else
		{
			System.out.println("Failed to login");
		}
	}

	public void t_08_invalidEntries()
	{
		WebDriver driver = new ChromeDriver();
		// Retrieve URL
		driver.get("https://www.demoblaze.com/index.html");
		// Click login
		driver.findElement(By.id("login2")).click();
		// Set username
		WebElement txt_username = driver.findElement(By.id("loginusername"));
		txt_username.sendKeys("");
		// Set password
		driver.findElement(By.id("loginpassword")).sendKeys("");
		driver.findElement(By.className("btn btn-primary")).click();

		WebElement result = driver.findElement(By.id("logout2"));
		if (result == null)
		{
			System.out.println("Success!");

		} else
		{
			System.out.println("Failed to login");
		}
	}

}
