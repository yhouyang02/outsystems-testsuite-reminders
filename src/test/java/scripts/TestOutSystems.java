package scripts;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class TestOutSystems {
	protected final String USERNAME = "publicdemo@yhouyang.me";
	protected final String PASSWORD = "On20June2023!";

	protected final String URL_LOGIN = "https://personal-vcgtfgt9.outsystemscloud.com/Reminders/Login";
	protected final String URL_REMINDERS = "https://personal-vcgtfgt9.outsystemscloud.com/Reminders/MyReminders";
	protected final String URL_DETAIL = "https://personal-vcgtfgt9.outsystemscloud.com/Reminders/ReminderDetail";

	protected WebDriver driver;

	/**
	 * Auto-selects the web driver and version. The same web driver must be
	 * initialized before test cases.
	 * 
	 * @see #init()
	 * @see {@link https://bonigarcia.dev/webdrivermanager/}
	 */
	@BeforeClass
	protected void setup() {
		/* Uncomment ONE correct browser driver for testing. */
		WebDriverManager.edgedriver().setup();
//		WebDriverManager.chromedriver().setup();
//		WebDriverManager.firefoxdriver().setup();
	}

	/**
	 * Initializes web driver and timeouts. The same web driver must be selected by
	 * WebDriverManager before initialization.
	 * 
	 * @see #setup()
	 */
	@BeforeMethod
	protected void init() {
		/* Uncomment ONE correct browser for testing. */
		driver = new EdgeDriver();
//		driver = new ChromeDriver();
//		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	/**
	 * Shuts down web driver.
	 */
	@AfterMethod
	protected void shutdown() {
		driver.quit();
	}
}
