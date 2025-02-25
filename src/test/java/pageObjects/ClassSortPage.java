package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import utils.WebDriverWaitUtility;

public class ClassSortPage extends BasePage {

	private Actions actions;

	public ClassSortPage(WebDriver driver) {
		super(driver);
		this.actions = new Actions(driver);
	}

	// sort locators
	@FindBy(xpath = "//thead/tr/th[2]/p-sorticon/i")
	private WebElement batchNameSort;
	@FindBy(xpath = "//thead/tr/th[3]/p-sorticon/i")
	private WebElement classTopicSort;
	@FindBy(xpath = "//thead/tr/th[4]/p-sorticon/i")
	private WebElement classDcpnSort;
	@FindBy(xpath = "//thead/tr/th[5]/p-sorticon/i")
	private WebElement statusSort;
	@FindBy(xpath = "//thead/tr/th[6]/p-sorticon/i")
	private WebElement classDateSort;
	@FindBy(xpath = "//thead/tr/th[7]/p-sorticon/i")
	private WebElement staffNameSort;
	// list locators
	@FindBy(xpath = "//tbody//td[2]")
	private List<WebElement> batchList;
	@FindBy(xpath = "//tbody//td[3]")
	private List<WebElement> classTopicList;
	@FindBy(xpath = "//tbody//td[4]")
	private List<WebElement> classDcpnList;
	@FindBy(xpath = "//tbody//td[5]")
	private List<WebElement> statusList;
	@FindBy(xpath = "//tbody//td[6]")
	private List<WebElement> classDateList;
	@FindBy(xpath = "//tbody//td[7]")
	private List<WebElement> staffNameList;
	
	@FindBy(xpath="//span[@class='p-paginator-icon pi pi-angle-right']")
	private WebElement nextPageIcon;

	public void clickElementMultipleTimes(WebElement element, int times) {
		for (int i = 0; i < times; i++) {
			actions.click(element).perform();
		}
	}

	public void clickBatchNameAsc() {
		clickElementMultipleTimes(batchNameSort, 2);
	}

	public void clickBatchNameDsc() {
		clickElementMultipleTimes(batchNameSort, 3);
	}

	public void clickClassTopicAsc() {
		clickElementMultipleTimes(classTopicSort, 2);
	}

	public void clickClassTopicDsc() {
		clickElementMultipleTimes(classTopicSort, 3);
	}

	public void clickClassDcpnAsc() {
		clickElementMultipleTimes(classDcpnSort, 2);
	}

	public void clickClassDcpnDsc() {
		clickElementMultipleTimes(classDcpnSort, 3);
	}

	public void clickStatusAsc() {
		clickElementMultipleTimes(statusSort, 2);
	}

	public void clickStatusDsc() {
		clickElementMultipleTimes(statusSort, 3);
	}

	public void clickClassDateAsc() {
		clickElementMultipleTimes(classDateSort, 2);
	}

	public void clickClassDateDsc() {
		clickElementMultipleTimes(classDateSort, 3);
	}

	public void clickStaffNameAsc() {
		clickElementMultipleTimes(staffNameSort, 2);
	}

	public void clickStaffNameDsc() {
		clickElementMultipleTimes(staffNameSort, 3);
	}

	public List<String> getOriginalList(String type) {
		List<String> originalList = new ArrayList<>();
		
		switch (type) {
		case "BatchName":
			originalList = convertWebElementsToText(batchList);
			break;
		case "ClassTopic":
			originalList = convertWebElementsToText(classTopicList);
			break;
		case "ClassDescription":
			originalList = convertWebElementsToText(classDcpnList);
			break;
		case "Status":
			originalList = convertWebElementsToText(statusList);
			break;
		case "ClassDate":
			originalList = convertWebElementsToText(classDateList);
			break;
		case "StaffName": 
			originalList = convertWebElementsToText(staffNameList);
			break;
		default:
			throw new IllegalArgumentException("Invalid type provided: " + type);
		}
		return originalList;
	}

	public List<String> convertWebElementsToText(List<WebElement> elements) {
		List<String> texts = new ArrayList<>();

		for (WebElement element : elements) {
			System.out.println("each elements " + element.getText().trim());
			texts.add(element.getText().trim());
		}

		System.out.println("Total items in the list: " + texts.size());
		return texts;
	}

	// Get sorted list in ascending order
	public List<String> getSortedListAscending(List<String> originalList) {
		// System.out.println("ascending Original List Before sorting: " +
		// originalList);

		List<String> sortedList = new ArrayList<>(originalList);
		sortedList.sort(String.CASE_INSENSITIVE_ORDER);

		// System.out.println("ascending Sorted List After sorting: " + sortedList);
		return sortedList;
	}

	// Get sorted list in descending order
	public List<String> getSortedListDescending(List<String> originalList) {
		System.out.println("descending Original List Before sorting: " + originalList);

		List<String> sortedList = new ArrayList<>(originalList);
		sortedList.sort(String.CASE_INSENSITIVE_ORDER.reversed()); // Reverse order sorting

		System.out.println("descending Sorted List After sorting: " + sortedList);
		return sortedList;
	}
	
	public boolean clickNextPageButton() throws InterruptedException {
		boolean status = false;
		WebElement nxt = WebDriverWaitUtility.waitForElementToBeClickable(nextPageIcon);
		Thread.sleep(2000);
			if(nxt.isEnabled()== true) {
				status = true;
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true);", nxt);
				//nxt.click();
				try {
					nxt.click();
				}catch (Exception e) {
					((JavascriptExecutor) driver).executeScript("arguments[0].click();",nxt);
				}
//				
//				}else {
//					status = false;
//				
			}
		
		
		return status;
	}
	
}