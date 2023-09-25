package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utils.BaseTest;

public class ScrollExample extends BaseTest{
	
	//@Test
	public void scrollByPixels() throws InterruptedException {
		
		//js executor scroll
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0, 1500)");
		
		Thread.sleep(3000);
		//action class scroll
		Actions action =  new Actions(driver);
		action.scrollByAmount(0, 1500).perform();
		
		Thread.sleep(3000);
		
		app.scrollVerically(3500);
	}
	
	//@Test
	public void scrollToElement() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Actions action =  new Actions(driver);

		
		//scroll to element with JS Executor
		jse.executeScript("arguments[0].scrollIntoView();", app.returnElement(app.home.signUpButton));
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0, -100)");

		//scroll to element with Action class
		action.scrollToElement(app.returnElement(app.home.pickedText)).perform();
		Thread.sleep(3000);

	}
	@Test
	public void scrollTopAndDown() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Actions action =  new Actions(driver);
		
		
		//js executor scroll 
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);
		jse.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
		Thread.sleep(3000);

		
		//action class scroll
		action.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(3000);
		action.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();

		
	}
	
	
	

}
