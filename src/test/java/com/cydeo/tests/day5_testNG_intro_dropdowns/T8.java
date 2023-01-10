package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T8 {
WebDriver driver;
    //TC #8: Selecting value from multiple select dropdown

    @BeforeMethod
    public void setupMethod(){

        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2. Go to website: https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @Test
            public void test1() throws InterruptedException {


    //2. Go to https://practice.cydeo.com/dropdown
    //3. Select all the options from multiple select dropdown.
        //4. Print out all selected values.
    Select dropdown = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));
        List<WebElement> list = dropdown.getOptions();
        for (WebElement each : list) {
            System.out.println("each = " + each.getText());

            each.click();
            Thread.sleep(1000);
        }

        //5. Deselect all values.
       dropdown.deselectAll();

    }

}
