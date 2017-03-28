package abcpack;

import static org.junit.Assert.*;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MultiWindowDemo {
	WebDriver d;
	@Test
	public void testMultiwindow() throws Exception
	{
		//Load web page
		d.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
		//Verify page title
		assertEquals("IRCTC Next Generation eTicketing System",d.getTitle());
		//Click on Food-on-Track link
		d.findElement(By.xpath("//div[@id='bluemenu']/ul/li/a")).click();
		Set<String> h=d.getWindowHandles();
		System.out.println("No of handles is:"+h.size());
		System.out.println("********* Handles are: ************");
		String handle[]=new String[h.size()];
		int i=0;
		for(String s:h)
		{
			System.out.println(s);
			handle[i]=s;
			i++;
		}
		//Switch driver focus to e-catering
		d.switchTo().window(handle[1]);
		assertTrue(d.findElement(By.id("stnCode")).isDisplayed());
		Thread.sleep(3000);
		//Switch driver focus to IRCTC
		d.switchTo().window(handle[0]);
		assertTrue(d.findElement(By.id("usernameId")).isDisplayed());
		Thread.sleep(4000);
	}
	@Before
	public void setUp()
	{
		//Launch browser
		System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
		d=new FirefoxDriver();
		//Maximize
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	}
	@After
	public void tearDown()
	{
		//Close browser
		d.quit();
	}

}
