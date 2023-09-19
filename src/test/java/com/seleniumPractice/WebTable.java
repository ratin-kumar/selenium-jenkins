package com.seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebTable {
	
	// Get all data from the Web Table
	
	WebDriver driver = new FirefoxDriver();
	
	@BeforeTest
	public void setUp() throws InterruptedException {	
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		Thread.sleep(3000);

	}
	
	@Test
	public void getWebTableData() {
		
		int rowCount = driver.findElements(By.xpath("//table[@class='ws-table-all']/tbody/tr")).size();
		int colCount = driver.findElements(By.xpath("//table[@class='ws-table-all']/tbody/tr[2]/td")).size();
		String xpath1 = "//table[@class='ws-table-all']/tbody/tr[";
		String xpath2 = "]/td[";
		String xpath3 = "]";
		
		System.out.println("Row: "+ rowCount);
		System.out.println("Col: "+ colCount);
		
		for(int i=2; i<=rowCount; i++) {
			for(int j=1; j<=colCount; j++) {
				String tableText = driver.findElement(By.xpath(xpath1+i+xpath2+j+xpath3)).getText();
				System.out.print(tableText+ ",  ");
			}
			System.out.println();
		}
		
	}
	
	@Test
	public void getWebTableData2() {
		
		int row = 2;
		int col = 3;
		int data = 2;
		
		String xpath1 = "//table[@class='ws-table-all']/tbody/tr[";
		String xpath2 = "]/td[";
		String xpath3 = "]";
		
		for(int i=row; i<=row+data; i++) {
			String text = driver.findElement(By.xpath(xpath1+i+xpath2+col+xpath3)).getText();
			System.out.println(text);
		}
	}

	@AfterTest
	void tearDown() {
		driver.quit();
	}
}
