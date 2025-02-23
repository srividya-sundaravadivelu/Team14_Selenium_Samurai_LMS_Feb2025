package stepDefinitions;

import driver.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import pageObjects.LoginPage;
import utils.ConfigReader;
import utils.DataReader;
import utils.LogHelper;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;

public class LoginSteps {

    TestContext testContext;
    LoginPage loginPage;
    List<HashMap<String, String>> datamap; // Data driven

    public LoginSteps(TestContext testContext) {
        this.testContext = testContext;
        this.loginPage = testContext.getLoginPage();
    }

    @Given("The browser is open")
    public void the_browser_is_open() {
        LogHelper.info("The browser is open");
        Assert.assertNotNull(testContext.getdriver());
    }

    @When("Admin gives the correct LMS portal URL")
    public void admin_gives_the_correct_lms_portal_url() {
        loginPage.navigateToPage(ConfigReader.getBaseUrl());
        LogHelper.info("Current page is " + loginPage.getCurrentUrl());
    }

    @Then("Admin should land on the login page")
    public void admin_should_land_on_the_login_page() {

        Assert.assertEquals(loginPage.getCurrentUrl(), ConfigReader.getLoginUrl());
    }

    @Then("HTTP response >= {int}. Then the link is broken")
    public void httpResponseThenTheLinkIsBroken(int arg0) throws IOException, InterruptedException {
        List<WebElement> links = testContext.getdriver().findElements(By.tagName("button"));
        System.out.println(links.size());

        for (WebElement link : links) {
            String linkURL = link.getAttribute("routerLink");
            if (linkURL == null) continue;
            URL url = new URL(ConfigReader.getBaseUrl() + linkURL);
            URLConnection urlConnection = url.openConnection();
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200)
                LogHelper.info(linkURL + " - " + httpURLConnection.getResponseMessage());
            else
                LogHelper.error(linkURL + " - " + httpURLConnection.getResponseCode() + " - " + httpURLConnection.getResponseMessage());
        }
    }

    @Given("Admin is on login Page")
    public void admin_is_on_login_page() {
        loginPage.navigateToPage(ConfigReader.getLoginUrl());
        LogHelper.info(loginPage.getCurrentUrl());
    }

	@When("Admin enter valid data from excel row {string}")
	public void admin_enter_valid_data_from_excel_row(String rows) throws InterruptedException {
		LogHelper.info("entering username and password");
		dataInitialization();
		LogHelper.info("user fills data from excel");
		int index = Integer.parseInt(rows) - 1;

		loginPage.enterUsername(datamap.get(index).get("Username"));
        loginPage.enterPassword(datamap.get(index).get("Password"));
        loginPage.selectRole("Admin");
        loginPage.clickLogin();
        Thread.sleep(1000);
	}
//    @When("Admin enter data from excel row {string}")
//    public void admin_enter_data_from_excel_row(String rows) throws InterruptedException {
//        LogHelper.info("entering username and password");
//        dataInitialization();
//        LogHelper.info("user fills data from excel");
//        int index = Integer.parseInt(rows) - 1;
//
//        // Get action for browser elements, to perform action on them
//        Actions action = new Actions(testContext.getdriver());
//
//        // Type username
//        action.moveToElement(loginPage.userNameInput).click().sendKeys(datamap.get(index).get("Username")).build().perform();
//        // Type password
//        action.moveToElement(loginPage.passwordInput).click().sendKeys(datamap.get(index).get("Password")).build().perform();
//        // Select role
//
//        action.moveToElement(loginPage.role).click().build().perform();
//
//        testContext.getdriver().findElement(By.xpath("//mat-option[span[text()[contains(.,'Admin')]]]")).click();
//
//        loginPage.clickLogin();
//    }

    @Then("Admin should receive application error") // invalid URL
    public void admin_should_receive_application_error() {
        Assert.assertTrue(loginPage.validateTextInPage("This site can’t be reached"));
    }

    @Then("Admin should see correct spellings in all fields")
    public void adminShouldSeeCorrectSpellingsInAllFields() {

        String userNameInputText = loginPage.getUserNameInputText();
        LogHelper.info("UserNameInput text is:" + userNameInputText);
        Assert.assertEquals(userNameInputText, "User");

        String passwordInputText = loginPage.getpasswordInputText();
        LogHelper.info("passwordInput text is:" + passwordInputText);
        Assert.assertEquals(passwordInputText, "Password");

        String loginInputText = loginPage.getlogin();
        LogHelper.info("login text is:" + loginInputText);
        Assert.assertEquals(loginInputText, "Login");
    }

    @Then("Admin should land on home page")
    public void admin_should_land_on_home_page() throws InterruptedException {
        Thread.sleep(500);
        LogHelper.info("Current URL:" + loginPage.getCurrentUrl());
        Assert.assertEquals(loginPage.getCurrentUrl(), ConfigReader.getBaseUrl());
        LogHelper.info("Admin is on Home page");
    }

    @When("Admin enter url from excel row {string}")
    public void adminEnterUrlFromExcelRow(String rowIndex) {
        LogHelper.info("entering url");
        dataInitialization();
        int index = Integer.parseInt(rowIndex) - 1;
        try {
            loginPage.navigateToPage(datamap.get(index).get("url"));
        } catch (WebDriverException exception) {
            LogHelper.error(exception.getMessage());
        }
    }

    public void dataInitialization() {
        if (datamap == null) {
            datamap = DataReader.data(System.getProperty("user.dir") + "\\testData\\ExcelData.xlsx", "LoginPage");
        }
    }

    @Then("Admin should see  LMS - Learning Management System")
    public void adminShouldSeeLMSLearningManagementSystem() {
        Assert.assertTrue(loginPage.imageComparison());
    }

    @Then("Admin should see company name below the app name")
    public void adminShouldSeeCompanyNameBelowTheAppName() {
        Assert.assertTrue(loginPage.imageComparison());
    }

    @Then("Admin should see {string}")
    public void adminShouldSee(String inputString) {
        Assert.assertEquals(loginPage.getTitleText(), inputString);
    }

    @Then("Admin should see two text field")
    public void adminShouldSeeTwoTextField() {
        int count = loginPage.getCountTextFields();
        Assert.assertEquals(2, count);
    }

    @Then("Admin should  see {string} in the first text field")
    public void adminShouldSeeInTheFirstTextField(String text) {
        String firstTextField = loginPage.FirstTextField();
        LogHelper.info("FIRST TEXT FIELD :" + firstTextField);
        Assert.assertEquals(firstTextField, text);
    }

    @Then("Admin should see one dropdown")
    public void adminShouldSeeOneDropdown() {
        LogHelper.info("dropdown displayed" + loginPage.isDropDownVisible());
        Assert.assertTrue(loginPage.isDropDownVisible());
    }

    @Then("Admin should see asterisk mark symbol next to text for mandatory fields")
    public void adminShouldSeeAsteriskMarkSymbolNextToTextForMandatoryFields() {
        Assert.assertTrue(loginPage.isUserAsteriskDisplayed());
        LogHelper.info("asterisk user displayed");
    }


    @Then("Admin should {string} in the second text field")
    public void adminShouldInTheSecondTextField(String text) {
        String secondTextField = loginPage.SecondTextField();
        LogHelper.info("Second Text Field :" + secondTextField);
        Assert.assertEquals(secondTextField, text);
    }

    @Then("Admin should see asterisk mark symbol next to password text")
    public void adminShouldSeeAsteriskMarkSymbolNextToPasswordText() {
        Assert.assertTrue(loginPage.isPwdAsteriskDisplayed());
        LogHelper.info("asterisk password displayed");
    }

    @Then("Error message {string}")// login with invalid data, null username, null password
    public void errorMessage(String arg0) {
    }

    @Then("Admin should see login button")
    public void adminShouldSeeLoginButton() {
        Assert.assertTrue(loginPage.loginBtnVisible());
        LogHelper.info("login button displayed");
    }

    @Then("Admin should see input field on the centre of the page")
    public void adminShouldSeeInputFieldOnTheCentreOfThePage() {
        Assert.assertTrue(loginPage.inputFieldVisibleCenterOfPage());
        LogHelper.info(("Input field visible on the center of the page"));
    }

    @Then("Admin should see {string} placeholder in dropdown")
    public void adminShouldSeePlaceholderInDropdown(String arg0) {
        Assert.assertTrue(loginPage.selectRolePlaceHolder());
        LogHelper.info("select the role is visible");
    }

    @When("Admin clicks login button through keyboard")
    public void adminEnterValidCredentialsAndClicksLoginButtonThroughKeyboard() {
        LogHelper.info("Admin pressing login button through keyboard...");
        loginPage.loginKeyboard();
        LogHelper.info("Admin pressed login button through keyboard.");
    }

    @When("Admin clicks login button through mouse")
    public void adminEnterValidCredentialsAndClicksLoginButtonThroughMouse() {
        LogHelper.info("Admin clicking login button through mouse...");
        loginPage.loginMouse();
        LogHelper.info("Admin clicked login button through mouse.");
    }

    @Then("Admin should see {string} in {string} color")
    public void adminShouldSeeUserInGrayColor(String fieldName, String color) {
        Color color1 = loginPage.getFieldColor(fieldName);
        Assert.assertEquals(Color.fromString("rgba(0, 0, 0, 0.87)"),color1);
    }

    @Then("Admin should see {string} options in dropdown")
    public void adminShouldSeeOptionsInDropdown(String options) {
        Assert.assertTrue(loginPage.isAdminInDropdown());
        Assert.assertTrue(loginPage.isStaffInDropdown());
        Assert.assertTrue(loginPage.isStudentInDropdown());

        LogHelper.info("Options are displayed in dropdown");
    }
}