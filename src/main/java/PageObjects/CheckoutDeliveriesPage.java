package PageObjects;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CheckoutDeliveriesPage extends BasePage {

    public CheckoutDeliveriesPage(WebDriver driver, int waitDuration){
        super(driver, waitDuration);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//i[@class='caret pull-right']")
    protected WebElement dropdownArrowShippingOptionButton;

    @FindBy(xpath = "//div[@class='ui-select-choices-row']")
    protected List<WebElement> shippingMethodOptions;

    @FindBy(xpath = " //button[@ng-click='next()']")
    protected WebElement nextButton;


    public boolean isPageLoaded(){
        return wait.until(ExpectedConditions.visibilityOf(dropdownArrowShippingOptionButton)).isDisplayed();
    }

    public boolean validateElementsDisplayed(){
        return dropdownArrowShippingOptionButton.isDisplayed();
    }

    public void selectShippingMethodByIndex(int index){
        wait.until(ExpectedConditions.elementToBeClickable(dropdownArrowShippingOptionButton));
        dropdownArrowShippingOptionButton.click();
        shippingMethodOptions.get(index).click();
        wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        nextButton.click();
    }

}
