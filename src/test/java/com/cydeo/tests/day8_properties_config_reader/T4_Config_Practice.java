package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T4_Config_Practice {

    public WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        //We are getting the browserType dynamically from our configuration.properties file
   String browserType = ConfigurationReader.getProperty("browser");



        //TC #4: Google search
        //1- Open a chrome browser
        //1. Goto: https://www.google.com

        driver = WebDriverFactory.getDriver(browserType);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.google.com");
    }

    @Test
    public void google_search_test() throws InterruptedException {

        //3- Write “apple” in search box
        WebElement googleSearchBox = driver.findElement(By.xpath("//input[@name='q']"));
        googleSearchBox.sendKeys("apple"+ Keys.ENTER);

        // 4- Verify title:
        //Expected: apple - Google Search
        Thread.sleep(2000);

        String expectedTitle= "apple - Google'da Ara";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

    }




}
