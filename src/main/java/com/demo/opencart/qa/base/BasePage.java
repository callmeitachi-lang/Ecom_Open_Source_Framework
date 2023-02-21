	package com.demo.opencart.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;



import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public WebDriver driver;
	public Properties prop;
	public static String highlight;
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();

	/**
	 * Setting up the driver----browser inputs
	 * 
	 * @param browsername
	 * @return
	 */
	
	
	
	
	public WebDriver init_driver(Properties prop) {

		String browsername = prop.getProperty("browser");
		System.out.println("The browser value is " + browsername);

		highlight = prop.getProperty("highlight");
	
		if (browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();

			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				init_remotedriver("chrome");
			} else {
				tldriver.set(new ChromeDriver());
			}
		} else if (browsername.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				init_remotedriver("firefox");
			} else {

				tldriver.set(new FirefoxDriver());
			}
		} else if (browsername.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			tldriver.set(new InternetExplorerDriver());

		} else if (browsername.equalsIgnoreCase("safari")) {
			WebDriverManager.safaridriver().setup();
			tldriver.set(new SafariDriver());
		} else
			System.out.println("Please check the browser value" + browsername);
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		return getDriver();

	}

	private void init_remotedriver(String browsername) {
		System.out.println("Test start in at remote side");

		if (browsername.equals("chrome")) {
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			try {
				tldriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")), cap));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		if (browsername.equals("firefox")) {
			DesiredCapabilities cap = DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");

			try {
				tldriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")), cap));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * getDriver using ThreadLocal
	 */
	public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}

	/**
	 * intializing the properties file
	 * 
	 * @return
	 */

	public Properties init_prop() {

		FileInputStream ip = null;
		String envname = System.getProperty("env"); // running at runtime --dev/qa/stage

		prop = new Properties();
		try {
			if (envname == null) {
				System.out.println("Running on prod envirnment");
				ip = new FileInputStream("./src/main/java/com/demo/opencart/qa/properties/config.properties");
			} else {
				switch (envname.toLowerCase()) {
				case "qa":
					ip = new FileInputStream("./src/main/java/com/demo/opencart/qa/properties/qa.config.properties");
					break;
				case "stage":
					ip = new FileInputStream("./src/main/java/com/demo/opencart/qa/properties/stage.config.properties");
					break;

				default:
					System.out.println("Please check the environment......");
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;

	}

	/**
	 * This method is used to take the screenshot It will return the path of
	 * screenshot
	 */
	public String getScreenshot() {
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

}
