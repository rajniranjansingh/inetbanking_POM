package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();

	public String baseURL = readconfig.getApplicationURL();
	public String Uname = readconfig.getUserName();
	public String password = readconfig.getPassword();
	public String HomePageTitle = "Guru99 Bank Manager HomePage";

	public static WebDriver driver;

	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setUp(String br)
	{
		logger = Logger.getLogger("InetBanking");
		PropertyConfigurator.configure("log4j.properties");

		if(br.equals("chrome"))
		{
			//System.getProperty("user.dir")+"//Drivers//chromedriver" - Used to get current project directory and corresponding folder, then file
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());  // we can use ./ instead of System.getProperty("user.dir")
			ChromeOptions options = new ChromeOptions();
			options.addArguments("window-size=1440,900");
			driver = new ChromeDriver(options);
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "/Users/rajniranjansingh/eclipse-workspace/inetbanking_POM/Drivers/geckodriver"); //readconfig.getGeckoPath()
			driver = new FirefoxDriver();
		}

		driver.get(baseURL);
		logger.info("URL is Opened");
	}

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

	public void capturescreen(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source,target);
	}

	public static String randomString()  // This user defined method generates a 4 letter random string
	{
		String randS = RandomStringUtils.randomAlphabetic(4); 
		return randS;
	}

	public static String randomNum()  // This user defined method generates a 4 digit random number
	{
		String randS = RandomStringUtils.randomNumeric(4); 
		return randS;
	}

}
