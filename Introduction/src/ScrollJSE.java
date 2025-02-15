import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ScrollJSE {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "C:\\\\drivers\\\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		List<WebElement> values=driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));		
		int sum=0;	
		for(int i=0;i<values.size();i++) {
			sum= sum+(Integer.parseInt(values.get(i).getText()));
		}
		System.out.println(sum);
		driver.findElement(By.className("totalAmount")).getText();
		int total= Integer.parseInt(driver.findElement(By.className("totalAmount")).getText().split(":")[1].trim());
		System.out.println(total);
		
		Assert.assertEquals(sum, total);
		
		
		List<WebElement> Values2=driver.findElements(By.cssSelector(".table-display td:nth-child(3)"));
		int sum2=0;
		for(int i=0;i<Values2.size();i++) {
			
			sum2= sum2+Integer.parseInt(Values2.get(i).getText());
		}
		System.out.println(sum2);
		
		
	}

}
