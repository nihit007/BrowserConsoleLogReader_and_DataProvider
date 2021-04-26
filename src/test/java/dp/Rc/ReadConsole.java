package dp.Rc;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.Test;

public class ReadConsole {
  @Test
  public void ReadBrowserLogs() {
	  System.setProperty("webdriver.chrome.driver","C:\\Chrome_Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/");
		 LogEntries entry = driver.manage().logs().get(LogType.BROWSER);
	        // Retrieving all log 
	        List<LogEntry> logs= entry.getAll();
	        // Print one by one
	        for(LogEntry e: logs)
	        {
	        	System.out.println(e);
	        }
	        // Printing details separately 
	        for(LogEntry e: logs)
	        {
	        	System.out.println("Message is: " +e.getMessage());
	        	System.out.println("Level is: " +e.getLevel());
	        }
  }
}
