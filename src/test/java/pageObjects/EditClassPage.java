package pageObjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.WebDriverWaitUtility;


public class EditClassPage extends BasePage {
	private  WebDriverWait wait;
	public EditClassPage(WebDriver driver) {
		super(driver);		
	}
	

	@FindBy(xpath = "//tbody[@class = 'p-datatable-tbody']//button[@icon = 'pi pi-pencil']")
	private List<WebElement> editBtnList;
	
	public List<WebElement> getEditbuttonList() {
		List<WebElement> btns = WebDriverWaitUtility.waitForListOfElementsToBeVisible(editBtnList);
		return editBtnList;
	}
	public  List<WebElement> waitForListOfElementsToBeVisible(List<WebElement> webElelments) {
		
		
			return wait.until(ExpectedConditions.visibilityOfAllElements(webElelments));
		
	}
	public void getRandomEditButton() {
		int number = new Random().nextInt(5);
		// clicking one random edit button from editButton list
		WebElement editBtn = getEditbuttonList().get(number);
		System.out.println("clicking the edit btn..");
		try {
			editBtn.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", editBtn);
		}

	}


}