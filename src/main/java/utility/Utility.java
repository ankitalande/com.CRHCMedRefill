package utility;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility extends Listeners_refill {
	
	public String captureScreenShot(WebDriver driver) throws Exception
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destination = new File("screenShot.png");
		String filepath = destination.getAbsolutePath();
		FileUtils.copyFile(source, destination);
		System.out.println("----destination path----"+filepath);
		return filepath;
	}
}
 