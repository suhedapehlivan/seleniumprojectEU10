package com.cydeo.tests.day7_webtables_utilities_javafaker;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_WindowHandling_WithUtilityMethod {
    public WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //TC #1: Window Handle practice
        //1. Create new test and make setups
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void window_handling_test(){


        //2. Goto:https://www.amazon.com
        driver.get("https://www.amazon.com");

        //3. Copy paste the lines from below into your class   OPENING NEW TABS
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

        //4. Create a logic to switch to the tab where Etsy.com is open

        // 5. Assert:Title contains “Etsy”


        BrowserUtils.switchWindowAndVerify(driver, "etsy","Etsy");


        //Lines to be pasted:
        //These lines will simply open new tabs using something called JavascriptExecutor and get those pages. We will learn JavascriptExecutor later as well.
    }
}
