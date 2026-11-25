package Demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Browsertest {
	WebDriver driver=null;
@Test
public void launch() throws Exception {
	String BROWSER = System.getProperty("browser");
	
	if (BROWSER.equalsIgnoreCase("chrome")) {
		driver = new ChromeDriver();
		
	}
	else if(BROWSER.equalsIgnoreCase("firefox"))
		driver = new FirefoxDriver();
	
	else if(BROWSER.equalsIgnoreCase("edge")){
		driver = new EdgeDriver();
	}
	else
		driver= new ChromeDriver();
	
	driver.get(System.getProperty("url"));
	
	Thread.sleep(4000);
}
}
