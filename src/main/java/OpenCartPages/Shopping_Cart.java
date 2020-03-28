package OpenCartPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.DriverWait;

public class Shopping_Cart 
{
WebDriver dr;
DriverWait wait;
String productName=null;
String productPrice=null;
	
    //To assign the local dr with the browser launched dr
	public Shopping_Cart(WebDriver dr)
	{
		this.dr=dr;
		wait=new DriverWait(dr);
	}
	
	
	       //Locators used in this Shopping Cart page
			By clickOnShoppingCart=By.xpath("//*[@id='top-links']/ul/li[4]/a");
			By addedProduct=By.xpath("//*[@id='content']//following::a[2]");
			By removeProduct=By.xpath("//*[@id='content']/form/div/table/tbody/tr[2]/td[4]/div/span/button[2]");
			By addedProductPrice=By.xpath("//*[@id='content']/form/div/table/tbody/tr/td[6]");

				
	//Searches for the added product and returns its name
	public String view_Shopping_Cart()
	{
		WebElement element=wait.elementToBeClickable(clickOnShoppingCart, 40);
	    element.click();//Clicks on shopping cart icon
	    
	    try 
	    {
			Thread.sleep(5000);//waits for the shopping cart to be loaded
		} 
	    catch (InterruptedException e) 
	    {
			e.printStackTrace();
		}
	    
	    
	    WebElement element1=wait.elementToBdVisible(addedProduct, 40);
		productName=element1.getText();//Gets the name of the added product
		
		return productName;//returns added prodcut name
	}
	
	//To remove the added product from the shopping cart
	public String remove_product()
	{
		
		WebElement element=wait.elementToBeClickable(removeProduct, 40);
	    element.click();//clicks on the remove product
	    
	    try 
	    {
			Thread.sleep(5000);//waits for the product to be removed
		} 
	    catch (InterruptedException e) 
	    {
			e.printStackTrace();
		}
	    
	    
	    WebElement element1=wait.elementToBdVisible(addedProductPrice, 40);
		productPrice=element1.getText();//Gets the price of the product still present in the cart
		
		return productPrice;//returns the readed product price
	}
}
