package PageObjects;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductDescriptionPage extends BasePage {

    public ProductDescriptionPage(WebDriver driver, int waitDuration){
        super(driver, waitDuration);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@class='add-to-cart']")
    protected WebElement addToCartButton;



    public boolean isPageLoaded(){
        return wait.until(ExpectedConditions.visibilityOf(addToCartButton)).isDisplayed();
    }

    public boolean validateElementsDisplayed(){
        return addToCartButton.isDisplayed();
    }

    public void addtoCart(){
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();
    }

}
