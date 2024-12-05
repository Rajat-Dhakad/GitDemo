package Test.pageobjects;

import Tesst.AbstractComponent.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponent {

    WebDriver driver;
    public LandingPage(WebDriver driver)
    {
        super(driver);
        //Initialization
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="userEmail")
    WebElement userEmail;

    @FindBy(id="userPassword")
    WebElement userPasswordEle;

    @FindBy(id="login")
    WebElement submit;

    public void goTO()
    {
        driver.get("https://rahulshettyacademy.com/client");
    }

    public ProductCatalogue LoginApplication(String email, String password)
    {
        userEmail.sendKeys(email);
        userPasswordEle.sendKeys(password);
        submit.click();
        ProductCatalogue productCatalogue = new ProductCatalogue(driver);
        return productCatalogue;
    }


}
