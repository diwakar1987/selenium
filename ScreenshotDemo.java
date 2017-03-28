package abcpack;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.apache.commons.io.FileUtils;

public class ScreenshotDemo {
	WebDriver d;
		
	@Before
	public void init() throws  Exception
	{
		System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
		d = new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				
	}
    @Test
    public void testScreenshot() throws Exception {
        
                
        d.get("https://www.google.co.in/");
        //d.findElement(By.linkText("Gmail")).click();
        Thread.sleep(2000);
               
        //Current Date and Time
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		Date dt = new Date();
		//System.out.println(dateFormat.format(dt));

        // then Augmenter will add the TakesScreenshot methods to the instance
        File scrFile = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("F:\\Selenium_Scripts_Nov16\\Results\\"+dateFormat.format(dt)+".png"));
        //FileUtils.copyFile(scrFile, new File("F:\\Selenium_Scripts_Nov16\\Results\\Page1.png"));
               
        Thread.sleep(4000);
        
        
    }
    @After
    public void stop()
    {
    	d.quit();
    }
}


