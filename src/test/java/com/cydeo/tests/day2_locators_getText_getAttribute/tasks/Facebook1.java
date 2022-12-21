package com.cydeo.tests.day2_locators_getText_getAttribute.tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook1 {
    public static void main(String[] args) {
        //TC #1: Facebook title verification
        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2. Go to https://www.facebook.com
        driver.get("https://www.facebook.com");

        //3. Verify title:
        //Expected: “Facebook - Log In or Sign Up”
        String expectedTitle = "Facebook - Giriş Yap veya Kaydol";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASS!");
        }else {
            System.out.println("Title verification FAILED!");
        }
driver.close();
    }
}
/*
TIPS FOR TASK #1:
1. Set up driver
2. Open browser
3. Get webpage: https://www.facebook.com
4. Use .getTitle() method, and store the actual title in a String
5. Create expectedTitle String
6. Create if conditions to do your verification
 */