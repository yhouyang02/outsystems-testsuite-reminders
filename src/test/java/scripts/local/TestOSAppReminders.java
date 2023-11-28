package scripts.local;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestOSAppReminders {
	private final String USERNAME = "publicdemo@yhouyang.me";
	private final String PASSWORD = "On20June2023!";

	private final String URL_LOGIN = "https://personal-vcgtfgt9.outsystemscloud.com/Reminders/Login";
	private final String URL_MYREMINDER = "https://personal-vcgtfgt9.outsystemscloud.com/Reminders/MyReminders";
	private final String URL_DETAIL = "https://personal-vcgtfgt9.outsystemscloud.com/Reminders/ReminderDetail";

	private WebDriver driver;

	/**
	 * Auto-selects the web driver and version. The same web driver must be
	 * initialized before test cases.
	 * 
	 * @see #init()
	 * @see {@link https://bonigarcia.dev/webdrivermanager/}
	 */
	@BeforeClass
	public void setup() {
		/* Uncomment ONE correct browser driver for testing. */
		WebDriverManager.edgedriver().setup();
//		WebDriverManager.chromedriver().setup();
//		WebDriverManager.firefoxdriver().setup();
	}

	/**
	 * Initializes web driver and timeouts. Navigates to the test site. The same web
	 * driver must be selected by WebDriverManager before initialization.
	 * 
	 * @see #setup()
	 */
	@BeforeMethod
	public void init() {
		/* Uncomment ONE correct browser for testing. */
		driver = new EdgeDriver();
//		driver = new ChromeDriver();
//		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
		// TODO:
	}

	/**
	 * Shuts down web driver.
	 */
	@AfterMethod
	public void shutdown() {
		driver.quit();
	}
}
