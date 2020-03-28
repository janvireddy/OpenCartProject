package OpenCartPages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.DriverWait;

public class Account_Login 
{
	WebDriver dr;
	DriverWait wait;
	
	//To assign the local dr with the browser launched dr
	public Account_Login(WebDriver dr)
	{
		this.dr=dr;
		wait=new DriverWait(dr);
	}
	
	
	//Locators used in this Account Login page
	By account=By.xpath("//*[@id='top-links']//following::a[2]");
	By selectLogin=By.xpath("//*[@id='top-links']//following::a[4]");
	By eMail=By.xpath("//*[@id='input-email']");
	By passWord=By.xpath("//*[@id='input-password']");
	By clickLogin=By.xpath("//*[@value='Login']");
	
	
	//To Login to the Opencart website
	public void login(String email,String password)
	{
		
		WebElement element=wait.elementToBeClickable(account, 40);
		element.click();//To click on My Account
		
		
		WebElement element1=wait.elementToBeClickable(selectLogin, 40);
		element1.click();//To Select Login from My Account dropdown
		
		
		WebElement element2=wait.elementToBdVisible(eMail, 40);
		element2.sendKeys(email);//Enters Email in the login page
		
		
		WebElement element3=wait.elementToBdVisible(passWord, 40);
	    element3.sendKeys(password);//Enters password in the Login page
		
	    
	    WebElement element4=wait.elementToBeClickable(clickLogin, 40);
		element4.click();//To click on Login
    }
}