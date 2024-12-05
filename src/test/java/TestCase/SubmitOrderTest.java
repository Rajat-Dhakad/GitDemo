package TestCase;

import Tesst.AbstractComponent.BaseTest;
import Test.pageobjects.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class SubmitOrderTest extends BaseTest {
    @Test
    public void SubmitOrder() throws IOException, InterruptedException {

        String productname = "ZARA COAT 3";
        LandingPage landingPage = launchApplication();
        ProductCatalogue.addProductToCart(productname);
        ProductCatalogue productCatalogue = landingPage.LoginApplication("Rajatdhakad365@gmail.com","Test2024@#");
        List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductTocart(productname);
        CartPage cartpage = productCatalogue.goToCartpage();

        Boolean match = cartpage.VerifyProductDisplay(productname);
        Assert.assertTrue(match);
        Checkoutpage checkoutpage =  cartpage.gotoCheckout();
        checkoutpage.setSelectCountry("india");
        ConfirmationPage confirmationPage = checkoutpage.submitOrder();

        String confirmMessage = confirmationPage.getConfirmationMessage();
        Assert.assertTrue(confirmMessage.trim().equalsIgnoreCase("Thankyou for the order."));


        driver.close();

    }
}
