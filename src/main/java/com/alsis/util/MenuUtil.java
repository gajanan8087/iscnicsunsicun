package com.alsis.util;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MenuUtil {
	 
	
	 
	public static List<String> getWebList(WebDriver driver,By locator){
		List<String>menulist = new ArrayList<String>();
		List<WebElement> listElements = driver.findElements(locator);
		for(WebElement menu:listElements) {
			String text=menu.getText();
			System.out.println(text);
			menulist.add(text);
		}
		
		return menulist;
		
	}
	
	
	public static Integer getWebListSize(WebDriver driver,By locator){
		List<WebElement> menulist = driver.findElements(locator);
		int count = menulist.size();
		return count;
		
	}

}
