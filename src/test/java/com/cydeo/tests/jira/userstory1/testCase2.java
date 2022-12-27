package com.cydeo.tests.jira.userstory1;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class testCase2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://library1.cydeo.com/login.html");

        WebElement username= driver.findElement(By.xpath("//label[@for='inputEmail']"));
        username.sendKeys("student@cydeo");

        WebElement password= driver.findElement(By.xpath("//label[@for='inputPassword']"));
        password.sendKeys("dfg");

        WebElement signInButton = driver.findElement(By.xpath("//button[@type='submit']"));
        signInButton.click();



        WebElement popup = driver.findElement(By.xpath("//div[.='Sorry, Wrong Email or Password']"));
        System.out.println("popup.isDisplayed() = " + popup.isDisplayed());


//"invalid email:
//student@cydeo, ab@@library, %^&
//password: dfg, 23, asdd"
        /*
user should access the sign in page
user should be able to type credentials
user should see an error message " Sorry, Wrong Email or Password"
         */
    }
}
