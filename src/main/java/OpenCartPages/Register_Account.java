package OpenCartPages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.DriverWait;

public class Register_Account 
{
	WebDriver dr;
	DriverWait wait;
	String message=null;
	
	//To assign the local dr with the browser launched dr
	public Register_Account(WebDriver dr)
	{
		this.dr=dr;
		wait=new DriverWait(dr);
	}

	
	//Locators used in Register Account Page
	By account=By.xpath("//*[@id='top-links']//following::a[2]");
	By selectRegister=By.xpath("//*[@id='top-links']//following::a[3]");
	By enterFirstName=By.xpath("//*[@id='input-firstname']");
	By enterLastName=By.xpath("//*[@id='input-lastname']");
	By enterEmail=By.xpath("//*[@id='input-email']");
	By enterTelephone=By.xpath("//*[@id='input-telephone']");
	By enterPassword=By.xpath("//*[@id='input-password']");
	By enterConfirmPassword=By.xpath("//*[@id='input-confirm']");
	By clickOnAgree=By.xpath("//*[@name='agree']");
	By clickOnContinue=By.xpath("//*[@value='Continue']");
	By errorMessage=By.xpath("//*[@class='text-danger']");
	By againClickContinue=By.xpath("//*[@class='buttons']//a");
	By clickOnLogOut=By.xpath("//*[@id='top-links']//following::a[7]");
	By continueLogOut=By.xpath("//*[@class='buttons']//a");
	
	
	//To register to the open cart website
	public String register(String firstName,String lastName,String email,String telephone,String password,String confirmPassword)
	{
		WebElement element=wait.elementToBeClickable(account, 40);
		element.click();//To click on My Account
		
		
		WebElement element1=wait.elementToBeClickable(selectRegister, 40);
		element1.click();//To choose Register from My Account dropdown
		
		
		WebElement element2=wait.elementToBdVisible(enterFirstName, 40);
		element2.sendKeys(firstName);//Enters the Firstname
		
		
		WebElement element3=wait.elementToBdVisible(enterLastName, 40);
		element3.sendKeys(lastName);//Enter the Lastname
		
		
		WebElement element4=wait.elementToBdVisible(enterEmail, 40);
		element4.sendKeys(email);//Enter the Email	
		
		
		WebElement element5=wait.elementToBdVisible(enterTelephone, 40);
		element5.sendKeys(telephone);//Enters the Telephone number	
		
		
		WebElement element6=wait.elementToBdVisible(enterPassword, 40);
		element6.sendKeys(password);//Enters the Password
		
		
		WebElement element7=wait.elementToBdVisible(enterConfirmPassword, 40);
		element7.sendKeys(confirmPassword);//Enters the Confirm password
		
		WebElement element8=wait.elementToBeClickable(clickOnAgree, 40);
		element8.click();//Clicks on agree to privacy policy check box	
		
		
		WebElement element9=wait.elementToBeClickable(clickOnContinue, 40);
		element9.click();//Clicks on continue to register button
		
		try
		{
		    message=dr.findElement(errorMessage).getText();//Stores the displayed error message if the entered credentials are invalid
		}
		catch(NoSuchElementException e)
		{
			
		}
		
		
		WebElement element10=wait.elementToBeClickable(againClickContinue, 40);
		element10.click();//Once again clicks on continue to register button
		
		return message;//returns the displayed error message or else rerturn NULL
		}
		
	
	public void logout()
	{
		WebElement element=wait.elementToBeClickable(account, 40);
		element.click();//To click on My Account
		
		
		WebElement element1=wait.elementToBeClickable(clickOnLogOut, 40);
		element1.click();//To click on Log Out
		
		
		WebElement element2=wait.elementToBeClickable(continueLogOut, 40);
		element2.click();//Clicks on continue to Log Out
	}
}
