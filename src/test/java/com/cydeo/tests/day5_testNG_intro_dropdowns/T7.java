package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class T7 {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //TC #7: Selecting value from non-select dropdown
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");
    }


@Test
        public void test1(){
    //3. Click to non-select dropdown
    WebElement Dropnon = driver.findElement(By.xpath("//a[@id='dropdownMenuLink']"));
Dropnon.click();

    //4. Select Facebook from dropdown
    WebElement facebook = driver.findElement(By.xpath("//a[.='Facebook']"));
    facebook.click();

    Set<String> windows = driver.getWindowHandles();
    for (String each :windows) {
        driver.switchTo().window(each);
    }
    //5. Verify title is “Facebook - Log In or Sign Up”

    String expected= "Facebook - Giriş Yap veya Kaydol";
    String actual = driver.getTitle();
    Assert.assertEquals(actual,expected);

}


}
