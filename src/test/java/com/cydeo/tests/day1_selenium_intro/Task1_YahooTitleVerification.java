package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1_YahooTitleVerification {

    public static void main(String[] args) {


            //do setup for browser driver
        WebDriverManager.chromedriver().setup();
        //1-open chrome browser
        WebDriver driver = new ChromeDriver();

        //make our page maximize
        driver.manage().window().maximize();

        //2- go to https://yahoo.com
        driver.get("https://yahoo.com");


        //3-verify title:   Expected: Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos
        String expectedTitle ="Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos";
        String actualTitle= driver.getTitle();  //actual title comes from the browser

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title is as expected. Verification PASSED!");
        }else{
            System.out.println("Title is NOT as expected. Verification FAILED!");
        }

        driver.close();


    }
}
