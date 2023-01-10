package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CRM_Utilities {

    /*
    This method will log in with helpdesk1@cybertekschool.com
     user when it is called
     */
    public static void crm_login(WebDriver driver){

        //3. Enter valid username

        WebElement inputUsername= driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys("helpdesk1@cybertekschool.com");

        //4. Enter valid password

        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys("UserUser");

        //5. Click to`LogIn`button

        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

        //USERNAME helpdesk1@cybertekschool.com Helpdesk2@cybertekschool.com
        //PASSWORD UserUser UserUser

    }

    public static void crm_login(WebDriver driver, String username, String password) {

        //3. Enter valid username

        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys(username);

        //4. Enter valid password

        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys(password);

        //5. Click to`LogIn`button

        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

        //USERNAME helpdesk1@cybertekschool.com Helpdesk2@cybertekschool.com
        //PASSWORD UserUser UserUser
    }


    }
