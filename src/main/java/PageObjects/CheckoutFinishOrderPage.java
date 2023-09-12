package PageObjects;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutFinishOrderPage extends BasePage {

    public CheckoutFinishOrderPage(WebDriver driver, int waitDuration) {
        super(driver, waitDuration);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h3[contains(text(),'Entrega')]")
    protected WebElement paymentTitle;

    public boolean isPageLoaded() {
        return wait.until(ExpectedConditions.visibilityOf(paymentTitle)).isDisplayed();
    }

    public boolean validateElementsDisplayed() {
        return paymentTitle.isDisplayed();
    }

}


