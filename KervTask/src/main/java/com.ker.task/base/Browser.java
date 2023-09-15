package com.ker.task.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Browser {
	public static Logger log = Logger.getLogger(Browser.class);

	public static WebDriver startBrowser() {
		String browser = Base.reader.getBrowser().toLowerCase();
		log.info("Selected Browser is: "+browser);
		switch (browser) {

		case "chrome":
			//WebDriverManager.chromedriver().setup();
			Base.driver = new ChromeDriver();
			log.info("Chrome Browser is Started" + Base.driver.hashCode());
			return Base.driver;

		case "edge":
			WebDriverManager.edgedriver().setup();
			Base.driver = new EdgeDriver();
			log.info("Internet Explorer Browser is Started" + Base.driver.hashCode());
			return Base.driver;

		case "opera":
			WebDriverManager.operadriver().setup();
			//Base.driver = new OperaDriver();
			log.info("Opera Browser is Started" + Base.driver.hashCode());
			return Base.driver;

		case "htmlunit":
			Base.driver = new HtmlUnitDriver();
			log.info("HtmlUnit Browser is Started" + Base.driver.hashCode());
			return Base.driver;

		default:
			WebDriverManager.firefoxdriver().setup();
			Base.driver = new FirefoxDriver();
			log.info("Firefox Browser is Started" + Base.driver.hashCode());
			return Base.driver;
		}

	}

	public static void maximize() {
		Base.driver.manage().window().maximize();
	}

	public static byte[] takeScreenshot() {
		try {
			return ((TakesScreenshot)Base.driver).getScreenshotAs(OutputType.BYTES);
		}
		catch(Exception e){
			log.info("Exception has Occured while taking screenshot");
			return null;
		}

		

	}
}
