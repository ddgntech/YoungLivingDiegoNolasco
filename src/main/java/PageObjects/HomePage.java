package PageObjects;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver, int waitDuration){
        super(driver, waitDuration);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@data-testid='qa-myaccount']")
    protected WebElement signInButton;



    public boolean isPageLoaded(){
        return wait.until(ExpectedConditions.visibilityOf(signInButton)).isDisplayed();
    }

    public boolean validateElementsDisplayed(){
        return signInButton.isDisplayed();
    }

    public void clickSignIn(){
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
    }

}
