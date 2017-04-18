package utility;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Helper {

	public static String captureScreenshot(WebDriver driver, String ScreenShotName) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir")+"/Screenshots/"+ScreenShotName+".png";
		File destination = new File(dest);
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			System.out.println("Failed to capter Screenshot "+e.getMessage());
		}
		
		return dest;
	}
	
	public static String captureFullPageScreenshot(WebDriver driver, String screenshotNameFullPage) {
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		String dest = System.getProperty("user.dir")+"/Screenshots/"+screenshotNameFullPage+".png";
		try {
			ImageIO.write(screenshot.getImage(), "PNG", new File(dest));
		} catch (IOException e) {
			System.out.println("Failed to capter Screenshot "+e.getMessage());
		}
		
		return dest;
	}
	
}
