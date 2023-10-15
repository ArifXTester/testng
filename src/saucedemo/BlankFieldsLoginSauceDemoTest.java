package saucedemo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BlankFieldsLoginSauceDemoTest {
    public static void main(String[] args) {

        // Initialize the WebDriver for Chrome
        WebDriver driver = new ChromeDriver();

        // Navigate to SauceDemo
        driver.get("https://www.saucedemo.com/");

        //maximize window
        driver.manage().window().maximize();

        // Find the username and password input fields and the login button
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        // Click the login button
        loginButton.click();

        // Verify that an error message is displayed
        WebElement errorElement = driver.findElement(By.cssSelector("h3[data-test='error']"));
        String errorMessage = errorElement.getText();

        if (errorMessage.equals("Epic sadface: Username is required")) {
            System.out.println("Test Case Passed: Blank username and password fields handled correctly.");
        } else {
            System.out.println("Test Case Failed: Blank username and password fields not handled correctly.");
        }
    }
}