package OpenCartPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.DriverWait;

public class Tablets
{
	WebDriver dr;
	DriverWait wait;
	String productName=null;
	
	 //To assign the local dr with the browser launched dr
	public Tablets(WebDriver dr)
	{
		this.dr=dr;
		wait=new DriverWait(dr);
	}
	
	
	//Locators used in this Tablets page
		By selectTablets=By.xpath("//*[@id='menu']/div[2]/ul/li[4]/a");
		By firstProduct=By.xpath("//*[@id='content']//following::a[3]");
		By addFirstProduct=By.xpath("//*[@class='button-group']//following::button[1]");
		
			
	//Adds product from the Tablets category
	public String add_Tablets_To_Cart()
	{
		WebElement element=wait.elementToBeClickable(selectTablets, 40);
		element.click();//Clicks on Tablets icon
		
		
		WebElement element1=wait.elementToBdVisible(firstProduct, 40);
		productName=element1.getText();//Gets the name of the first product displayed
		
		
		WebElement element2=wait.elementToBeClickable(addFirstProduct, 40);
		element2.click();//Adds the displayed first product to the cart
		
		try 
		{
			Thread.sleep(5000);//Waits the script untill product is successfully added to the cart
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		return productName;//returns the added product name
	}
}
