package com.cydeo.tests.day2_locators_getText_getAttribute.tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook2 {
    public static void main(String[] args) throws InterruptedException {

              //TC #2: Facebook incorrect login title verification
              //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2. Go to https://www.facebook.com
        driver.get("https://www.facebook.com");

             //3. Enter incorrect username
        WebElement userName = driver.findElement(By.id("email"));
        userName.sendKeys("shdss");
              //4. Enter incorrect password
        WebElement password = driver.findElement(By.id("pass"));
        password.sendKeys("paswrd" +Keys.ENTER);
              //5. Verify title changed to:
            //Expected: “Log into Facebook”
        Thread.sleep(1000);
        String expectedTitle = "Facebook'a Giriş Yap";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASS!");
        }else {
            System.out.println("Title verification FAILED!");
        }
    }
}
/*
TIPS FOR TASK #2:
1. Set up driver
2. Open browser
3. Get webpage: https://www.facebook.com
4. Locate the username input box using one of 6 locators we learn, and send random string
using .sendKeys() method
5. Locate the password input box using one of 6 locators we learn, and send random string
using .sendKeys() method and Keys.ENTER
6. Get title and store it in new String (actual)
7. Create new String for expected
8. Verify results with if condition
*/