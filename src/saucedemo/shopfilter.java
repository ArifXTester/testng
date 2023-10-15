package saucedemo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class shopfilter {
    public static void main(String[] args) throws InterruptedException {
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

        // Enter the username and password
        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");

        // Click the login button
        loginButton.click();

        // Verify that the login is successful by checking the inventory page URL
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)) {
            System.out.println("Login Successful!");
        } else {
            System.out.println("Login Failed!");
            driver.quit();
            return; // Exit the test if login fails
        }

        // Test Case 1: Add an item to the shopping cart
        WebElement addToCartButton = driver.findElement(By.xpath("//button[text()='Add to cart']"));
        addToCartButton.click();

        // Verify that the shopping cart badge updates to '1'
        WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
        String cartBadgeText = cartBadge.getText();
        Thread.sleep(1000);

        if (cartBadgeText.equals("1")) {
            System.out.println("Test Case 1 Passed: Item added to the shopping cart.");
        } else {
            System.out.println("Test Case 1 Failed: Item not added to the shopping cart.");
        }

        // Test Case 2: Apply a filter (Sort A to Z)
        WebElement filterDropdown = driver.findElement(By.className("product_sort_container"));
        filterDropdown.click();
        Thread.sleep(1000);
        WebElement filterOption = driver.findElement(By.xpath("//option[text()='Name (A to Z)']"));
        filterOption.click();

        // Verify that the products are sorted in alphabetical order
        WebElement option1 = driver.findElement(By.cssSelector("option[value='za']"));
        Select select = new Select(option1);
        select.selectByVisibleText("Name (Z to A)");
    }
}
//