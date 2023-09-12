package PageObjects;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver, int waitDuration){
        super(driver, waitDuration);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "autocomplete-0-input")
    protected WebElement inputSearch;

    @FindBy(xpath = "//section[@data-autocomplete-source-id='products']")
    protected WebElement resultSearch;


    public boolean isPageLoaded(){
        return wait.until(ExpectedConditions.visibilityOf(inputSearch)).isDisplayed();
    }

    public boolean validateElementsDisplayed(){
        return inputSearch.isDisplayed();
    }

    public void searchForProductByIndex(int index){
        wait.until(ExpectedConditions.elementToBeClickable(inputSearch));
        inputSearch.sendKeys("Aceite");
        wait.until(ExpectedConditions.visibilityOf(resultSearch));
        driver.findElement(By.id("autocomplete-0-item-" + index)).click();
    }

}
