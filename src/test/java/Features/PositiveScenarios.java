package Features;

import Base.BaseTest;
import PageObjects.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveScenarios extends BaseTest {

    @Test
    public void makeOrderWithoutSubmittingTest(){
        CommonPage commonPage = new CommonPage(getDriver(), 20);

        HomePage homePage = new HomePage(getDriver(), 20);
        Assert.assertTrue(homePage.isPageLoaded());
        Assert.assertTrue(homePage.validateElementsDisplayed());
        homePage.clickSignIn();

        LoginPage loginPage = new LoginPage(getDriver(), 20);
        Assert.assertTrue(loginPage.isPageLoaded());
        Assert.assertTrue(loginPage.validateElementsDisplayed());
        loginPage.loginWithDefaultUser();
        commonPage.isLoaderHidden();

        DashboardPage dashboardPage = new DashboardPage(getDriver(), 20);
        Assert.assertTrue(dashboardPage.isPageLoaded());
        Assert.assertTrue(dashboardPage.validateElementsDisplayed());
        commonPage.isLoaderHidden();
        dashboardPage.clickMainLogo();

        MainPage mainPage = new MainPage(getDriver(), 20);
        Assert.assertTrue(mainPage.isPageLoaded());
        Assert.assertTrue(mainPage.validateElementsDisplayed());
        mainPage.searchForProductByIndex(2);

        ProductDescriptionPage productDescriptionPage = new ProductDescriptionPage(getDriver(), 20);
        Assert.assertTrue(productDescriptionPage.isPageLoaded());
        Assert.assertTrue(productDescriptionPage.validateElementsDisplayed());
        productDescriptionPage.addtoCart();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(getDriver(), 20);
        Assert.assertTrue(shoppingCartPage.isPageLoaded());
        Assert.assertTrue(shoppingCartPage.validateElementsDisplayed());
        commonPage.isLoaderHidden();
        shoppingCartPage.proceedCheckout();

        CheckoutDeliveriesPage checkoutDeliveriesPage = new CheckoutDeliveriesPage(getDriver(), 20);
        Assert.assertTrue(checkoutDeliveriesPage.isPageLoaded());
        Assert.assertTrue(checkoutDeliveriesPage.validateElementsDisplayed());
        checkoutDeliveriesPage.selectShippingMethodByIndex(1);

        CheckoutPaymentPage checkoutPaymentPage = new CheckoutPaymentPage(getDriver(), 20);
        commonPage.isLoaderHidden();
        Assert.assertTrue(checkoutPaymentPage.isPageLoaded());
        Assert.assertTrue(checkoutPaymentPage.validateElementsDisplayed());
        checkoutPaymentPage.continueWithPayment();

        CheckoutFinishOrderPage checkoutFinishOrderPage = new CheckoutFinishOrderPage(getDriver(), 20);
        Assert.assertTrue(checkoutFinishOrderPage.isPageLoaded());
        Assert.assertTrue(checkoutFinishOrderPage.validateElementsDisplayed());
    }

}
