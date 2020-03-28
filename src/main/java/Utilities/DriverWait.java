package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverWait 
{

WebDriver dr;
WebElement element=null;
	
	//Assigns the local dr with the browser launched dr
	public DriverWait(WebDriver dr)
	{
		this.dr=dr;
	}

	//Waits untill element become clickable
	public WebElement elementToBeClickable(By locator,int time)
	{
		try
		{
		WebDriverWait wait=new WebDriverWait(dr,time);
		element=wait.until(ExpectedConditions.elementToBeClickable(locator));
		}
		catch(Exception e)
		{
			
		}
		
		return element;
	}
	
	
	//Waits untill element becomes visible
	public WebElement elementToBdVisible(By locator,int time)
	{
		try
		{
		WebDriverWait wait=new WebDriverWait(dr,time);
		element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}
		catch(Exception e)
		{
		}
		
		return element;
	}
}
