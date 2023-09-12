package PageObjects;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CommonPage extends BasePage {

    public CommonPage(WebDriver driver, int waitDuration){
        super(driver, waitDuration);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='spinner-container']")
    protected WebElement spinnerLoader;

    public void isLoaderHidden(){
        wait.until(ExpectedConditions.invisibilityOf(spinnerLoader));
    }

}
