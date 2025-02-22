package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import utils.ConfigReader;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;


public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "username")
    public WebElement userNameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"mat-select-value-1\"]/span")
    public WebElement role;

    @FindBy(id = "login")
    public WebElement login;

    @FindBy(xpath = "/html/body/app-root/app-login/div/div/img")
    public WebElement logoImage;

    @FindBy(xpath = "//*[text()='Please login to LMS application']")
    public WebElement titleElement;

    @FindBy(xpath = "//*[@id=\"mat-select-0\"]/div/div[2]")
    public WebElement dropdown;

    @FindBy(xpath = "//*[@id=\"mat-select-value-1\"]/span")
    public WebElement selectRole;

    @FindBy(xpath = "/html/body/app-root/app-login/div/mat-card/mat-card-content/form")
    public WebElement inputField;

    public void clickLogin() {
        login.click();
    }

    public String getUserNameInputText() {
        return userNameInput.getAttribute("data-placeholder");
    }

    public String getpasswordInputText() {
        return passwordInput.getAttribute("data-placeholder");
    }

    public String getlogin() {
        return login.getText();
    }

    public boolean imageComparison() {
        try {
            //generate url
            URL imageURL = new URL(ConfigReader.getBaseUrl() + "/" + logoImage.getDomAttribute("src"));
            int countF = 0;
            //read url and retrieve image
            BufferedImage saveImage = ImageIO.read(imageURL);
            BufferedImage actualImage = ImageIO.read(new File(System.getProperty("user.dir") + "\\" + "src\\test\\resources\\images\\LMS-logo.jpg"));

            ImageDiffer imgDiff = new ImageDiffer();
            ImageDiff diff = imgDiff.makeDiff(saveImage, actualImage);
            return !diff.hasDiff();

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getTitleText() {
        return titleElement.getText();
    }

    public int getCountTextFields() {
        List<WebElement> textFields = driver.findElements(By.xpath("//input[@type='password' or @id='username']"));
        return textFields.size();
    }

    public String FirstTextField() {
        List<WebElement> textFields = driver.findElements(By.id("username"));
        WebElement firstTextField = textFields.get(0);
        return firstTextField.getAttribute("data-placeholder");
    }

    public boolean isDropDownVisible() {
        return dropdown.isDisplayed();
    }

    public boolean isUserAsteriskDisplayed() {
        WebElement usernameAsterisk = driver.findElement(By.xpath("//*[@id='mat-form-field-label-1']/span[2]"));
        return usernameAsterisk.isDisplayed();
    }

    public String userTextColor() {
        return userNameInput.getCssValue("color");
    }

    public String SecondTextField() {
        List<WebElement> textFields = driver.findElements(By.id("password"));
        WebElement secondTextField = textFields.get(0);
        return secondTextField.getAttribute("data-placeholder");
    }

    public boolean isPwdAsteriskDisplayed() {
        WebElement passwordAsterisk = driver.findElement(By.xpath("//*[@id='mat-form-field-label-3']/span[2]"));
        return passwordAsterisk.isDisplayed();
    }

    public boolean loginBtnVisible() {
        return login.isDisplayed();
    }

    public boolean inputFieldVisibleCenterOfPage() {
        return inputField.isDisplayed();
    }

    public boolean selectRolePlaceHolder() {
        return selectRole.isDisplayed();
    }

    public void loginKeyboard() {
        login.sendKeys(Keys.ENTER);
    }

    public void loginMouse() {
        Actions actionToClick = new Actions(driver);
        actionToClick.moveToElement(login).click().perform();
    }

    public boolean validateTextInPage(String message) {
        return driver.getPageSource().contains(message);
    }

    public String passwordTextColor() {
        return passwordInput.getCssValue("color");
    }

    public Color getFieldColor(String fieldName) {
        if ("user".equalsIgnoreCase(fieldName)) {
            return Color.fromString(userTextColor());
        } else {
            return Color.fromString(passwordTextColor());
        }
    }

    public boolean isAdminInDropdown() {
        Actions action = new Actions(driver);
        action.moveToElement(role).click().build().perform();
        WebElement adminElement = driver.findElement(By.xpath("//*[@id=\"mat-option-0\"]/span"));
        return null!= adminElement;
    }

    public boolean isStaffInDropdown() {
        WebElement staffElement = driver.findElement(By.xpath("//*[@id=\"mat-option-1\"]/span"));
        return null!= staffElement;
    }

    public boolean isStudentInDropdown() {
        WebElement studentElement = driver.findElement(By.xpath("//*[@id=\"mat-option-2\"]/span"));
        return null!= studentElement;
    }

}

