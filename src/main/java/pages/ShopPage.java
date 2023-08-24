package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ShopPage {

	public WebDriver driver;
	
	public ShopPage(WebDriver driver) {
		this.driver = driver;	}
	
	
	//locatori
	public By orderDropdown = By.name("orderby");
	
	//metode
	public void selectByValue(String value) {
		WebElement dropdown =  driver.findElement(orderDropdown);
		Select select = new Select(dropdown);
		select.selectByValue(value);
		
	}
	
	public void selectByVisibleText(String text) {
		WebElement dropdown =  driver.findElement(orderDropdown);
		Select select = new Select(dropdown);
		select.selectByVisibleText(text);
		
	}
	
	public void selectByIndex(int index) {
		WebElement dropdown =  driver.findElement(orderDropdown);
		Select select = new Select(dropdown);
		select.selectByIndex(index);
		
	}
	
	
	/**
	 * Method that retruns the value as String from the current selection
	 * of a dropdown 
	 * @return uses getText() method from selenium to retrun the text inside the
	 * selected option
	 */
	public String getSelectedOption() {
		WebElement dropdown =  driver.findElement(orderDropdown);
		Select select = new Select(dropdown);
		return select.getFirstSelectedOption().getText();
	}
	
	
}
