package Tesst.AbstractComponent;

import Test.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    public WebDriver driver;
    public WebDriver initializerDriver() throws IOException {
        //properties class

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\Rajat Dhakad\\IdeaProjects\\SeleniumFrameworkDesign\\src\\Rajat.Tests\\java\\Rajat\\resources\\GlobalData.properties");
        prop.load(fis);
        String browserName = prop.getProperty("browser");

        if(browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
             driver = new ChromeDriver();

        }
        else if(browserName.equalsIgnoreCase("firefox"))
        {
            //firefox
        }
        else if(browserName.equalsIgnoreCase("edge"))
        {
            //edge
            System.setProperty("Webdriver.edge.driver", "edge.exe");
             driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;

    }
    public LandingPage launchApplication() throws IOException {
        driver = initializerDriver();
        LandingPage landingPage = new LandingPage(driver);
        landingPage.goTO();
        return landingPage;
    }
}
