import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class locatorsPractice {
	public static void main(String[] args) {
		
		TimeUnit time = TimeUnit.SECONDS; 
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "D:\\Dilip_java\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://the-internet.herokuapp.com/");
		System.out.println("Loading website http://the-internet.herokuapp.com/");
		
		WebElement element = driver.findElement(By.cssSelector("#content ul"));
		System.out.println(element.getTagName());

		List<WebElement> lis = driver.findElements(By.cssSelector("#content ul li"));
		System.out.println("the li elements size is "+ lis.size());
		
//		for(int i=0;i<lis.size();i++)
//		{
//			System.out.println(i + " - li text is: " + lis.get(i));
//			System.out.println(i + " - li text is: " + lis.get(i).findElement(By.tagName("a")).getText());
//		}
		
		for(int i=0;i<lis.size();i++)
		{
//			System.out.println(i + " - li text is: " + lis.get(i).findElement(By.tagName("a")).getText());
			WebElement openlink = lis.get(i).findElement(By.tagName("a"));
			String xx = openlink.getText();
			if (xx.equals("Challenging DOM"))
			{
				System.out.println("TRUE");
				openlink.click();
				break;
			}
			
		}
		
		String current_url = driver.getCurrentUrl();
		System.out.println("current url is : "+current_url);
		
		
		List<WebElement> tble_lis = driver.findElements(By.cssSelector("table>tbody>tr>td"));
		System.out.println(tble_lis.size());	
		List<String> row_2 = new ArrayList<String>();
		for(int j=0;j<tble_lis.size();j++)
		{
//			System.out.println(j+" - "+tble_lis.get(j).getText());
			if (j%7 == 2)
			{
//				System.out.println(j+" - "+tble_lis.get(j).getText());
				row_2.add(tble_lis.get(j).getText());	 
				
			}			
		}
		System.out.println("Desired result is : "+ row_2.get(3));
	}

}
