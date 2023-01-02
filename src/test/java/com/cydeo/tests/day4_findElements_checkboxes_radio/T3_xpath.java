package com.cydeo.tests.day4_findElements_checkboxes_radio;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_xpath {
    public static void main(String[] args) {
        //XPATH Practice
        //DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
        //TC #6: XPATH LOCATOR practice
        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2. Go to http://practice.cydeo.com/multiple_buttons
        driver.get("http://practice.cydeo.com/multiple_buttons");

        // 3. Click on Button 1

        WebElement button1 = driver.findElement(By.xpath("//button[@onclick='button1()']"));
button1.click();

        //4. Verify text displayed is as expected: Expected: “Clicked on button one!”
        WebElement text = driver.findElement(By.xpath("//div/p[@id='result']"));

        String expected= "Clicked on button one!";
        String actual = text.getText();
        System.out.println(expected.equals(actual));


        //USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
    }
}
