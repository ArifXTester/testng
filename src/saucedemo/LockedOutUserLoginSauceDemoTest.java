package saucedemo;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LockedOutUserLoginSauceDemoTest {
    public static void main(String[] args) {

        // Initialize the WebDriver for Chrome
        WebDriver driver = new ChromeDriver();

        // Navigate to SauceDemo
        driver.get("https://www.saucedemo.com");
        String currentTitle = driver.getTitle();
        Assert.assertEquals("Swag Labs",currentTitle);
        System.out.println("Swag Labs Page Loaded Successfully");

        //maximize window
        driver.manage().window().maximize();

        // Find the username and password input fields and the login button
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        // Enter the locked-out username and a valid password
        usernameField.sendKeys("locked_out_user");
        passwordField.sendKeys("secret_sauce");

        // Click the login button
        loginButton.click();

        // Verify that an error message is displayed
        WebElement errorElement = driver.findElement(By.cssSelector("h3[data-test='error']"));
        String errorMessage = errorElement.getText();

        if (errorMessage.equals("Epic sadface: Sorry, this user has been locked out.")) {
            System.out.println("Test Case Passed: Locked-out user handled correctly.");
        } else {
            System.out.println("Test Case Failed: Locked-out user not handled correctly.");
        }
    }
}