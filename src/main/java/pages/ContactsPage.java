package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContactsPage {

	public WebDriver driver;
	
	public ContactsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By nameField = By.cssSelector("input[name='your-name']");
	public By zoomInButton = By.cssSelector("button[title='Zoom in']");
	public By zoomOutButton = By.cssSelector("button[title='Zoom out']");
	public By iframe = By.tagName("iframe");

	
	public void zoomMap(By locator) {
		WebElement element =  driver.findElement(iframe);
		driver.switchTo().frame(element);
		driver.findElement(locator).click();
	}
	
	
	public void sendKeysWithCaps(By locator, String textToBeSent) {
		WebElement element =  driver.findElement(locator);
		Actions action =  new Actions(driver);
		action.
			moveToElement(element).
			click().
			keyDown(Keys.SHIFT).
			sendKeys(textToBeSent).
			perform();
	}
}
