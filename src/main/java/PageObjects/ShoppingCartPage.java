package PageObjects;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShoppingCartPage extends BasePage {

    public ShoppingCartPage(WebDriver driver, int waitDuration){
        super(driver, waitDuration);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@class='button-cta right']")
    protected WebElement proceedCheckoutButton;



    public boolean isPageLoaded(){
        return wait.until(ExpectedConditions.visibilityOf(proceedCheckoutButton)).isDisplayed();
    }

    public boolean validateElementsDisplayed(){
        return proceedCheckoutButton.isDisplayed();
    }

    public void proceedCheckout(){
        wait.until(ExpectedConditions.elementToBeClickable(proceedCheckoutButton));
        proceedCheckoutButton.click();
    }

}
