package saucedemo;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {
    public static void main(String[] args) {

        //launch the Chrome browser
        ChromeDriver driver = new ChromeDriver();
        System.out.println("Chrome browser launched success");
        driver.manage().window().maximize();

        //navigate to www.amazon.com
        driver.get("https://www.amazon.com");
      String currentTitle = driver.getTitle();
   Assert.assertEquals("Amazon.com. Spend less. Smile more.",currentTitle);
    System.out.println("amazon main page loaded success");

     //  driver.findElement(By.c("nav-a  ")).click();

//        //type "java book" in search field
//       driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java book");
//       // driver.findElement(By.cssSelector("a[data-csa-c-type='link']"));
//        System.out.println("type java book on the search field success");
        driver.findElement(By.cssSelector("[data-csa-c-content-id='nav_cs_bestsellers']")).click();
//
//        //click on search button
//        driver.findElement(By.tagName("span")).click();
//        String currentText = driver.findElement(By.xpath("/html/body/div[1]/div[1]/span[2]/div/h1/div/div[1]/div/div/span[1]")).getText();
//        System.out.println("text is: "+currentText);
//        Assert.assertTrue(currentText.contains("results for"));
//        System.out.println("search page loaded success");
//
//     driver.close();

    }
}
