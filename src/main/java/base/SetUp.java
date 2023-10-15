package base;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class SetUp {
    public WebDriver driver;
    @Before
    public void setUp(){
        String browserName = "chrome";

        if (browserName.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
            System.out.println("Chrome Browser launched");
            }
        else if (browserName.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
            System.out.println("FireFox Browser launched");
            } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
            System.out.println("Edge Browser launched");
        }
        // Initialize the WebDriver for Chrome

        driver.manage().window().maximize();
        System.out.println("Window maximized");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Navigate to the website
        driver.get("https://www.saucedemo.com/");
        String expectedTitle = "Swag Labs";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        System.out.println("Navigate to saucedemo website success");
    }
    @After
    public void tearDown(){
        driver.close();
        System.out.println("Browser closed successfully");
    }
}
