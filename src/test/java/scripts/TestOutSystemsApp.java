package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestOutSystemsApp extends TestOutSystems {

	/**
	 * Navigates to the test site.
	 * 
	 * @see scripts.TestOutSystems.init()
	 */
	@Override
	@BeforeMethod
	public void init() {
		super.init();
		driver.get(URL_LOGIN);
	}

	@Test
	public void testLogin() {
		WebElement inputUsername = driver.findElement(By.id("Input_UsernameVal"));
		WebElement inputPassword = driver.findElement(By.id("Input_PasswordVal"));
		WebElement buttonLogin = driver.findElement(By.id("b6-Button"));
		inputUsername.sendKeys(USERNAME);
		inputPassword.sendKeys(PASSWORD);
		buttonLogin.click();
	}

	@Test
	public void testAddReminderCancel() {
		testLogin();

		WebElement buttonAdd = driver.findElement(By.xpath("//i[@class='icon fa fa-plus-circle fa-3x']"));
		buttonAdd.click();

		WebElement buttonCancel = driver.findElement(By.xpath("//*[@id=\"b1-Breadcrumbs\"]/a"));
		buttonCancel.click();
	}

	@Test
	public void testDeleteReminder() {
		testLogin();
		// TODO:
	}

	@Override
	@AfterMethod
	public void shutdown() {
		super.shutdown();
	}
}
