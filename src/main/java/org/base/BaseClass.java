package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	public static WebDriver launchBrowser(String browserName) {
		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				return driver;

			} else if (browserName.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				return driver;
			} else {
				System.out.println("Invalid Browser : Pls choose chrome or edge");

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			driver.manage().window().maximize();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;

	}

	public static void geturl(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void close() {
		try {
			driver.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void quit() {
		try {
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void navigateTo(String url) {
		driver.navigate().to(url);

	}

	public static void navigateBack() {
		driver.navigate().back();

	}

	public static void navigateForward() {
		driver.navigate().back();
	}

	public static void navigateRefresh() {
		driver.navigate().refresh();

	} // alert: simple and confirm

	public static void alertSwitch(String alertOption) {

		if (alertOption.equalsIgnoreCase("ok")) {
			driver.switchTo().alert().accept();

		} else if (alertOption.equalsIgnoreCase("cancel")) {
			driver.switchTo().alert().dismiss();

		} else {
			System.out.println("Invalid Options");

		}

	}// alert : prompt :

	public static void prompt(String alertKey) throws InterruptedException {
		Thread.sleep(2000);
		try {
			Alert move = driver.switchTo().alert();
			move.sendKeys(alertKey);
			move.accept();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// moveToElement
	public static void moveToElement(WebElement x) {
		try {
			Actions ac = new Actions(driver);
			ac.moveToElement(x).perform();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Actions: Right click
	public static void getActions(WebElement y) {
		try {
			Actions ac = new Actions(driver);
			ac.contextClick(y).perform();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// robot-new tab:
	public static void robotTab() throws AWTException {
		try {
			Robot rb = new Robot();
			rb.keyPress(KeyEvent.VK_DOWN);
			rb.keyRelease(KeyEvent.VK_DOWN);
			rb.keyPress(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			e.printStackTrace();
		}

	}

	// robot-open in new window :
	public static void robotWindow() throws AWTException {
		try {
			Robot rb = new Robot();
			rb.keyPress(KeyEvent.VK_DOWN);
			rb.keyRelease(KeyEvent.VK_DOWN);
			rb.keyPress(KeyEvent.VK_DOWN);
			rb.keyRelease(KeyEvent.VK_DOWN);
			rb.keyPress(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			e.printStackTrace();
		}

	}

	// robot - incognito window
	public static void robotIncognitoWindow() throws AWTException {
		try {
			Robot rb = new Robot();
			rb.keyPress(KeyEvent.VK_DOWN);
			rb.keyRelease(KeyEvent.VK_DOWN);
			rb.keyPress(KeyEvent.VK_DOWN);
			rb.keyRelease(KeyEvent.VK_DOWN);
			rb.keyPress(KeyEvent.VK_DOWN);
			rb.keyRelease(KeyEvent.VK_DOWN);
			rb.keyPress(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			e.printStackTrace();
		}

	}

	// frame - Single Frame
	public static void singelFrame(String f1) {
		try {
			driver.switchTo().frame(f1);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// frame - Nested Frame
	public static void nestedFrame(String f1, String f2) {
		try {
			driver.switchTo().frame(f1);
			driver.switchTo().frame(f2);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// default page:
	public static void defaultContent() {
		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// get title:
	public static void getTitle() {
		try {
			String title = driver.getTitle();
			System.out.println(title);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// get current url:
	public static void getcurrenturl() {
		try {
			String currentUrl = driver.getCurrentUrl();
			System.out.println(currentUrl);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	// window handle: to get title and id

	public static void windowHandle() {
		try {
			String id = driver.getWindowHandle();
			System.out.println(id);
			String title = driver.switchTo().window(id).getTitle();
			System.out.println(title);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// window handles - id
	public static void windowHandlesId() {
		try {
			Set<String> multiIds = driver.getWindowHandles();
			for (String id : multiIds) {
				System.out.println(id);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// window handles - title
	public static void windowHandlesTitle() {
		try {
			Set<String> multiTitle = driver.getWindowHandles();
			for (String title : multiTitle) {
				String title2 = driver.switchTo().window(title).getTitle();
				System.out.println(title2);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	// wait - implicit wait

	public static void implicitWait(long n) {
		try {
			driver.manage().timeouts().implicitlyWait(n, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}// Explicit wait :

	public static void explicitWait(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// close
	public static void closebrowser() {
		driver.close();

	}

	// quit
	public static void quitBrowser() {
		driver.quit();

	}
	// TakesScreenshot:

	public static void takesScreenshot(String imagename) throws IOException {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			File desFile = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\" + imagename + ".png");
			FileUtils.copyFile(srcFile, desFile);
		} catch (WebDriverException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// Scroll up
	public static void scrollUp(String up) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView()", up);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Scroll Down
	public static void scrollDown(String down) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView()", down);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}// Select : Index

	public static void selectByIndex(WebElement element, int a) {
		try {
			Select s = new Select(element);
			s.selectByIndex(a);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}// select : Value

	public static void selectByValue(WebElement element, String value) {
		try {
			Select s = new Select(element);
			s.selectByValue(value);
		} catch (Exception e) {
			e.printStackTrace();
		}

	} // Select : visible Text

	public static void selectByText(WebElement element, String text) {
		try {
			Select s = new Select(element);
			s.selectByVisibleText(text);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}// get Options ;

	public static void getOptions(WebElement element) {
		try {
			Select s = new Select(element);
			List<WebElement> options = s.getOptions();
			for (WebElement webElement : options) {
				System.out.println(webElement.getText());

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}// isSelected

	public static void isSelected(WebElement element) {
		try {
			element.isSelected();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}// isEnabled

	public static void isEnabled(WebElement element) {
		try {
			element.isEnabled();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}// isDisplayed

	public static void isdisplayed(WebElement element) {
		try {
			element.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void sendKeys(WebElement element, String value) {
		element.sendKeys(value);

	}

	public static void click(WebElement element) {
		element.click();

	}
}
