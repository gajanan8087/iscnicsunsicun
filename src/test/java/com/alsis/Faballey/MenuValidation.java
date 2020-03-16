package com.alsis.Faballey;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.alsis.util.ExcelRead1;
import com.alsis.util.MenuUtil;

public class MenuValidation {
	WebDriver driver = null;
	WebElement we = null;
	List<String> listMenuWeb;
	List<String> listMenuExcel = null;
	  
	@BeforeSuite
	public void openBrowser() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Projects\\Faballey\\src\\resource\\java\\com\\jbk\\Eproc\\Driver\\chromedriver78.exe");
		driver = new ChromeDriver();
		
	}
	
	@AfterSuite
	public void closeBrowser() {
		
		driver.quit();
	}

	@BeforeClass
	public void loadMenuForTesting() throws Exception {
		driver.get("https://www.faballey.com");
		Thread.sleep(10000);

		driver.findElement(By.xpath("//a[text()='No Thanks']")).click();
		By listXpath=By.xpath("//ul/li[@class]");
		listMenuWeb=MenuUtil.getWebList(driver,listXpath);
		listMenuExcel = ExcelRead1.getExcellist("E:\\Projects\\Faballey\\MenuList.xlsx", "MenuSheet");
	}

	@Test(dataProvider ="Menu")
	public void testLinkSpellings(String linkNameExcel) {
		Assert.assertTrue(listMenuWeb.contains(linkNameExcel));
	}

	@Test
	public void testLinksCount() {
		
		Assert.assertTrue(listMenuWeb.size()==listMenuExcel.size());
	}

	@Test
	public void testLinksSeq() {
		//Assert.assertEquals(listMenuWeb,listMenuExcel);
		if(listMenuWeb.size()==listMenuExcel.size()) {
			for(int i=0;i<listMenuWeb.size();i++) {
				boolean flag=true;
				if(!(listMenuWeb.get(i).equals(listMenuExcel.get(i)))) {
					flag=false;
					break;
				}
				Assert.assertTrue(flag);
			}
		}else {
			Assert.assertTrue(false);
		}
	}

	@DataProvider(name = "Menu")
	public Object[][] loginData() throws IOException {
		Object[][] arrayObject =ExcelRead1.getExcelData("E:\\Projects\\Faballey\\MenuList.xlsx", "MenuSheet");
		return arrayObject;
	}


}
