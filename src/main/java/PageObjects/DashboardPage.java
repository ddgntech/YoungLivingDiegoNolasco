package PageObjects;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BasePage {

    public DashboardPage(WebDriver driver, int waitDuration){
        super(driver, waitDuration);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//img[@class='main-logo']")
    protected WebElement mainLogo;



    public boolean isPageLoaded(){
        return wait.until(ExpectedConditions.visibilityOf(mainLogo)).isDisplayed();
    }

    public boolean validateElementsDisplayed(){
        return mainLogo.isDisplayed();
    }

    public void clickMainLogo(){
        wait.until(ExpectedConditions.elementToBeClickable(mainLogo));
        mainLogo.click();
    }

}
