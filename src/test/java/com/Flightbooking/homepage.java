package com.Flightbooking;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homepage {
	
	WebDriver driver;
	
	public homepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//Repository
	@FindBy (xpath="//span[@class='commonModal__close']") WebElement ClosePopUp;
	@FindBy (xpath="//li[@data-cy='roundTrip']") WebElement RoundTripbutton;
	@FindBy (xpath="//span[text()='From']") WebElement SourceCity;

	@FindBy (xpath="//input[@aria-controls='react-autowhatever-1']") WebElement SourceSearchBox; 
	@FindBy (xpath="//input[@id='toCity']") WebElement DestinationCity;
	@FindBy (xpath="//input[@aria-controls='react-autowhatever-1']") WebElement DestiSearchBox;
	//@FindBy (xpath="//a[text()='Search']") WebElement SearchButton;
	@FindBy (xpath="//span[@class='lbl_input appendBottom10'][text()='Departure']") WebElement dropbutton;
	@FindBy (xpath="//div[@aria-label='Wed Mar 19 2025']") WebElement DepartureDate;
	@FindBy (xpath="//div[@aria-label='Mon Apr 14 2025']") WebElement ArrivalDate;
	@FindBy (xpath="//a[text()='Search']") WebElement SearchButton;
	//https://www.makemytrip.com/flights/


//methods

public void ClosePopUpMessage() throws InterruptedException
{
	Thread.sleep(3000);
	ClosePopUp.click();
	Thread.sleep(2000);
}
public void ClickRoundTrip() throws InterruptedException
{
	
	RoundTripbutton.click();
}
public void ClickSourceCity(String city) throws InterruptedException
{
	Thread.sleep(3000);
	SourceCity.click();
	SourceSearchBox.sendKeys(city);
	Thread.sleep(4000);
	SourceSearchBox.click();

	

}
/*public void EnterSourceCity(String city) throws InterruptedException
{
	SourceSearchBox.sendKeys(city);
	Thread.sleep(4000);
}*/
public void ClickDestinationCity(String dest) throws InterruptedException
{
	Thread.sleep(4000);
	DestinationCity.click();
	Thread.sleep(3000);
	DestiSearchBox.sendKeys(dest);
	DestiSearchBox.click();
}

/*public void EnterDestCity(String dest) throws InterruptedException
{
	Thread.sleep(3000);
	DestiSearchBox.sendKeys(dest);
}*/
public void SelectDepartureDate() throws InterruptedException
{
	//Thread.sleep(3000);
	//JavascriptExecutor js=(JavascriptExecutor)driver;
	//js.executeScript("window.scrollBy(400,500)","");
	dropbutton.click();
	DepartureDate.click();
	
}
public void ClickArrival()
{
	ArrivalDate.click();
}
public void ClickSearch()
{
	SearchButton.click();
}
}
