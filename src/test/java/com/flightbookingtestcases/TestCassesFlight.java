package com.flightbookingtestcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Flightbooking.homepage;

public class TestCassesFlight {
 WebDriver driver;
 
 @BeforeTest
 public void launchChrome()
 {
	 driver=new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 driver.get("https://www.makemytrip.com/flights/");
 }
 
 @Test 
 public void SearchFlightTicket() throws InterruptedException
 {
	 homepage hp=new homepage(driver);
	 hp.ClosePopUpMessage();
	 hp.ClickRoundTrip();
	 hp.ClickSourceCity("Pune");
	// hp.EnterSourceCity("Pune");
	 hp.ClickDestinationCity("Hyderabad");
	 //hp.EnterDestCity("Hyderabad");
	// hp.SelectDepartureDate();
	// hp.ClickArrival();
	 hp.ClickSearch();
	 
 }
 
 @AfterTest
 public void Closebrowser()
 {
	// driver.close();
 }
}
