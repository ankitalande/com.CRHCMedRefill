package utility;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Basecls {
		
	public static WebDriver driver; 	
	public static ExtentTest test;
	public static ExtentReports extent;
	

	@SuppressWarnings("deprecation")
	@BeforeClass
//	public void setUp() throws  Exception {
	
	public void setUp(String browserName) throws  Exception {

		// start reporters 
		String path = System.getProperty("user.dir") + "\\Report_Web\\extent.html"; 
		ExtentSparkReporter spark = new ExtentSparkReporter(path);
		spark.config().setReportName("WebMEDRefill Automation");
		extent = new ExtentReports();
		extent.setSystemInfo("QA", "Ankita");
		extent.setSystemInfo("Module", "com.Medevantage");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("Opertaing System", "Windows 10");
		extent.attachReporter(spark);

		freemarker.log.Logger.selectLoggerLibrary(freemarker.log.Logger.LIBRARY_NONE);
		
		
		System.out.println(".....");
		if(browserName.equalsIgnoreCase("Chrome")) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\lenovo\\eclipse-workspace\\com.CRHCMedRefill\\src\\main\\resources\\Drivers\\chromedriver.exe");		
		driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("Firefox"))
		{
		System.setProperty("webdriver.gecko.driver","C:\\Users\\lenovo\\eclipse-workspace\\com.CRHCMedRefill\\src\\main\\resources\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
	}else if(browserName.equalsIgnoreCase("Edge"))
		{
			System.setProperty("webdriver.edge.driver","C:\\Users\\lenovo\\eclipse-workspace\\com.CRHCMedRefill\\src\\main\\resources\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}  
		
		
		driver.get("https://crhctestmedrefill.medevantage.com/");    //("https://crhctestmedrefill.medevantage.com/");
		driver.manage().window().maximize();		
		driver.findElement(By.xpath("//*[@class='btn btn-primary px-5']")).click();
	}

	public String captureScreenShot(WebDriver driver) throws Exception
	{
		File source = ((TakesScreenshot) Basecls.driver).getScreenshotAs(OutputType.FILE);
		File destination = new File("screenShot.png");
		String filepath = destination.getAbsolutePath();
		FileUtils.copyFile(source, destination);
		System.out.println("----destination path----" + filepath);
		return filepath;
	}      

	@AfterClass

	public void teardown() {
		driver.quit();
		System.out.println("App Closed");
		extent.flush();
	}
}
 