package Base;

import Utils.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Properties;

public class BaseTest {
    private WebDriver driver;

    @BeforeMethod
    public void init(){
        String browser = System.getProperty("browser");
        if (browser != null ){
            switch (browser){
                case "Chrome":
                    driver = new ChromeDriver();
                    break;
                case "Firefox":
                    driver = new FirefoxDriver();
                    break;
                case "Edge":
                    driver = new EdgeDriver();
                    break;
            }
        } else {
            driver = new ChromeDriver();
        }

        driver.get(ReadProperties.readProperty("baseUrl"));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        if (driver != null){
            driver.close();
            driver.quit();
        }
    }

    public WebDriver getDriver() { return driver; }

}
