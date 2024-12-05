package Test.pageobjects;

import Tesst.AbstractComponent.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkoutpage extends AbstractComponent {

    WebDriver driver;

    public Checkoutpage(WebDriver driver)
    {
        super(driver);
        this.driver = this.driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(css = "[placeholder='Select Country']")
    WebElement country;

    @FindBy(xpath = "//button[contains(@class,'ta-item')])[2]")
    WebElement selectCountry;

    @FindBy(css = ".action__submit")
    WebElement submit;

    By results = By.cssSelector(".ta-results");

    public void setSelectCountry(String countryName)
    {
        Actions a = new Actions(driver);
        a.sendKeys(country,"india").build().perform();
        waitForElementToAppear(results);
        selectCountry.click();
    }

    public ConfirmationPage submitOrder()
    {
        submit.click();
        return new ConfirmationPage(driver);
    }

}