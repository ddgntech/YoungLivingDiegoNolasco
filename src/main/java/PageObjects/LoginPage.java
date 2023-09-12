package PageObjects;

import Base.BasePage;
import Utils.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver, int waitDuration){
        super(driver, waitDuration);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "loginUsername")
    protected WebElement usernameInput;

    @FindBy(id = "continue-btn")
    protected WebElement continueButton;

    @FindBy(id = "loginPassword")
    protected WebElement passwordInput;

    @FindBy(id = "login-btn")
    protected WebElement loginButton;

    public boolean isPageLoaded(){
        return wait.until(ExpectedConditions.visibilityOf(usernameInput)).isDisplayed();
    }

    public boolean validateElementsDisplayed(){
        return usernameInput.isDisplayed()
                && continueButton.isDisplayed();
    }

    public void loginWithDefaultUser (){
        wait.until(ExpectedConditions.elementToBeClickable(usernameInput));
        usernameInput.sendKeys(ReadProperties.readProperty("username"));
        continueButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(passwordInput));
        passwordInput.sendKeys(ReadProperties.readProperty("password"));
        loginButton.click();
    }

}

