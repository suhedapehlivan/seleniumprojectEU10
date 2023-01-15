package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SmartBearUtils {

    public static void loginToSmartBear(WebDriver driver, String username, String password){

        //3. Enter valid username

        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));
        inputUsername.sendKeys(username);

        //4. Enter valid password

        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']"));
        inputPassword.sendKeys(password);

        //5. Click to`LogIn`button

        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();

    }



}
