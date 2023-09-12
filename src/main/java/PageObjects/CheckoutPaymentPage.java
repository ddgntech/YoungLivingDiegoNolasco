package PageObjects;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class CheckoutPaymentPage extends BasePage {

    public CheckoutPaymentPage(WebDriver driver, int waitDuration){
        super(driver, waitDuration);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[contains(text(),'Compra: Pago')]")
    protected WebElement paymentTitle;

    @FindBy(xpath = " //button[@class='button-cta right']")
    protected WebElement nextButton;

    @FindBy(xpath = "//a[@ng-click='$ctrl.addPayment(payment.paymentMethodInfo, payment.currency)']")
    protected WebElement addPaymentMethodButton;


    public boolean isPageLoaded(){
        return wait.until(ExpectedConditions.visibilityOf(paymentTitle)).isDisplayed();
    }

    public boolean validateElementsDisplayed(){
        return paymentTitle.isDisplayed();
    }

    public void continueWithPayment(){
        wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        nextButton.click();
    }

    public void addCreditCardPaymentMethod(){
        wait.until(ExpectedConditions.elementToBeClickable(addPaymentMethodButton));
        addPaymentMethodButton.click();
        //I was not able to add credit card because this is production and I do not have a testing credit card information
    }
}
