package pageObjects;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ProgramSortPage extends BasePage {

	private Actions actions;
	
	public ProgramSortPage(WebDriver driver) {
		super(driver);	
		this.actions = new Actions(driver);	
	}	
     //sort locators	
	@FindBy(xpath = "//thead/tr/th[2]/p-sorticon/i")private WebElement PNameSort;
	@FindBy(xpath = "//thead/tr/th[3]/p-sorticon/i")private WebElement PDescripSort;
	@FindBy(xpath = "//thead/tr/th[4]/p-sorticon/i")private WebElement PStatusSort;
	//list locators		
	@FindBy(xpath = "//tbody//td[2]")private List<WebElement> ProgramNameList;
	@FindBy(xpath = "//tbody//td[3]")private List<WebElement> ProgramDescrList;
	@FindBy(xpath = "//tbody//td[4]")private List<WebElement> ProgramStatusList;
	
	public void clickElementMultipleTimes(WebElement element, int times) {
	    for (int i = 0; i < times; i++) {
	        actions.click(element).perform();
	    }
	}
	public void clickProgramNameAsc() {
		clickElementMultipleTimes(PNameSort, 2); 
	}
	public void clickProgramNameDsc() {
		clickElementMultipleTimes(PNameSort, 3); 
	}
	public void clickProgramDescriptionAsc() {			
	    clickElementMultipleTimes(PDescripSort, 2); 
	}
	public void clickProgramDescriptionDsc() {			
	    clickElementMultipleTimes(PDescripSort, 3); 
	}
	public void clickProgramStatusAsc() {			
	    clickElementMultipleTimes(PStatusSort, 2); 
	}
	public void clickProgramStatusDsc() {			
	    clickElementMultipleTimes(PStatusSort, 3); 
	}
	
	
	public List<String> getOriginalList(String type) {
	    List<String> originalList = new ArrayList<>(); 

	    switch (type) {
	        case "ProgramName":
	            originalList = convertWebElementsToText(ProgramNameList);
	            break;
	        case "ProgramDescription":
	            originalList = convertWebElementsToText(ProgramDescrList);
	            break;
	        case "ProgramStatus":
	            originalList = convertWebElementsToText(ProgramStatusList);
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
	    System.out.println("ascending Original List Before sorting: " + originalList);
	    
	    List<String> sortedList = new ArrayList<>(originalList);
	    sortedList.sort(String.CASE_INSENSITIVE_ORDER); 

	    System.out.println("ascending Sorted List After sorting: " + sortedList);
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
}
