package tests;

import static org.testng.Assert.assertFalse;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utils.BaseTest;

public class JavascriptExecutorExample extends BaseTest{
	
	//@Test
	public void example1() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		//navigate to URL
		
		//driver.get("<URL>");
		//driver.navigate().to("<URL>");
		jse.executeScript("window.location='http://emag.ro'");
		
		//driver.navigate().back();
		jse.executeScript("window.history.go(-1)");
		
		//driver.navigate().forward();
		jse.executeScript("window.history.forward()");
				
		//1
		driver.navigate().refresh();
		//2
		jse.executeScript("window.history.go(0)");
		//3
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys(Keys.F5).perform();
		//4
		driver.get(driver.getCurrentUrl());
		
	}
	
	//@Test
	public void example2() {
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
	//	WebElement searchIcon = driver.findElement(app.menu.searchIcon);
		//alternativa pentru click()
	//	jse.executeScript("arguments[0].click()", searchIcon);
		//WebElement searchInput = driver.findElement(app.menu.searchInput);
		//alternativa pentru sendKeys()
//		jse.executeScript("arguments[0].value='cooking'", searchInput);
		
//		jse.executeScript("arguments[0].click()", searchIcon);

	/*	jse.executeScript("arguments[0].click()", app.returnElement(app.menu.searchIcon));
		jse.executeScript("arguments[0].value='cooking'", app.returnElement(app.menu.searchInput));
		jse.executeScript("arguments[0].click()", app.returnElement(app.menu.searchIcon));
		*/
		
		jse.executeScript("document.getElementsByClassName('icon-search')[0].click()");	
		jse.executeScript("document.getElementsByClassName('search_field')[0].value='cooking'");
		jse.executeScript("document.getElementsByClassName('icon-search')[0].click()");	
		
		
	/*	jse.executeScript("document.getElementsByClassName('icon-search')[0].click();"
				+ "document.getElementsByClassName('search_field')[0].value='cooking';"
				+ "document.getElementsByClassName('icon-search')[0].click()");  */
		
		
		//alternativa pentru isDisplayed()
		String exempluIsDisplayed = jse.executeScript("return document.getElementsByClassName('post_title')[0].checkVisibility()").toString();
		System.out.println("isDisplayed : " + exempluIsDisplayed);
		
		//alternativa pentru getText()
		String exempluGetText =  jse.executeScript("return document.getElementsByClassName('post_title')[0].childNodes[0].innerText").toString();
		System.out.println("getText : " + exempluGetText);
		
		//alternativa pentru getTitle()
		String exempluGetPageTitle = jse.executeScript("return document.title").toString();
		System.out.println("getTitle : " + exempluGetPageTitle);
		
		//alternativa pentru getCurrentUrl()
		String exempluGetCurrentUrl = jse.executeScript("return document.URL").toString();
		System.out.println("getURL : " + exempluGetCurrentUrl);
		
		
		jse.executeScript("document.getElementsByClassName('popup_login_link')[0].click()");
		
		//alternativa pentru isSelected()
		String exempluIsSelected = jse.executeScript("return document.getElementsByName('rememberme')[0].checked").toString();
		System.out.println("isSelected : " + exempluIsSelected);
		boolean value = Boolean.valueOf(exempluIsSelected);
		assertFalse(value);
		
		//alternativa pentru isEnabled()
		String exempluIsEnabled = jse.executeScript("return document.getElementsByName('pwd')[0].disabled").toString();
		System.out.println("isEnabled : " + exempluIsEnabled);
	}
	
	@Test
	public void example3() {
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;

		System.out.println(driver.getTitle());
		
		jse.executeScript("window.schimbTitlulPaginii = function() { document.title = 'Alt titlu!'};"
				+ "window.schimbTitlulPaginii.call();");
		
		System.out.println("Dupa functia JS : " + driver.getTitle());
		
		
		//alternativa pentru hover
		
		String javascriptHover = "var obiect = document.createEvent('MouseEvent');"
				+ "obiect.initMouseEvent('mouseover', true);"
				+ "arguments[0].dispatchEvent(obiect);";
		
		jse.executeScript(javascriptHover, app.returnElement(app.menu.blogLink));
		
		jse.executeScript(javascriptHover, app.returnElement(app.menu.aboutLink));

		
	}
	
	

}
