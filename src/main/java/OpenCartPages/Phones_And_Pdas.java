package OpenCartPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.DriverWait;

public class Phones_And_Pdas 
{
	
	WebDriver dr;
	DriverWait wait;
	String productName=null;
	
	//To assign the local dr with the browser launched dr
	public Phones_And_Pdas(WebDriver dr)
	{
		this.dr=dr;
		wait=new DriverWait(dr);
	}
	
	
	//Locators used in this Phones & PDA's page
	By selectPhones=By.xpath("//*[@id='menu']/div[2]/ul/li[6]/a");
	By firstProduct=By.xpath("//*[@id='content']//following::a[3]");
	By addFirstProduct=By.xpath("//*[@class='button-group']//following::button[1]");

	
	
	//To select a prodcut from phones category and add it cart
	public String add_Phone_To_Cart()
	{
		
		WebElement element=wait.elementToBeClickable(selectPhones, 40);
		element.click();//Clicks on the Phones & PDAS
		
		WebElement element1=wait.elementToBdVisible(firstProduct, 40);
		productName=element1.getText();//Gets the First product name
		
		WebElement element2=wait.elementToBeClickable(addFirstProduct, 40);
		element2.click();//Adds the first product displayed to the shopping cart
		
		try 
		{
			Thread.sleep(5000);//used to wait the script until the prodcut added successfully
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		return productName;//returns the added product name
	}


}
