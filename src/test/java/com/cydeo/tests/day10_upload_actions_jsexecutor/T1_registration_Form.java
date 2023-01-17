package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_registration_Form {


    @Test
    public void registration_form_test(){

    //TC#1: Registration form confirmation
    //Note: Use JavaFaker OR read from configuration.properties file when possible.
    //1. Openbrowser
    //2. Gotowebsite:https://practice.cydeo.com/registration_form
        //Driver.getDriver() --> driver
        Driver.getDriver().get(ConfigurationReader.getProperty("registration.form.url"));

        //create JavaFaker object
        Faker faker= new Faker();

    //3. Enter first name
        WebElement inputFirstName = Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
        String fakerFirstName =faker.name().firstName();
        inputFirstName.sendKeys(fakerFirstName);

    //4. Enter last name
        WebElement inputLastName = Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
        inputLastName.sendKeys(faker.name().lastName());

    //5. Enter username
        WebElement inputUserName = Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
        //inputUserName.sendKeys(faker.name().username().replaceAll(".",""));
//OR
        String user = faker.bothify("helpdesk###");
        inputUserName.sendKeys(user);

    //6. Enter email address
        WebElement inputEMail = Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        inputEMail.sendKeys(user+ "@email.com");

    //7. Enter password
        WebElement inputPassword = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        inputPassword.sendKeys(faker.bothify("????####"));
       // faker.internet().password()
       // System.out.println("faker.internet().password() = " + faker.internet().password());

        //8. Enter phone number
        WebElement inputPhoneNumber = Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        inputPhoneNumber.sendKeys(faker.numerify("###-###-####"));
        // faker.phoneNumber().cellPhone()

    //9. Select a gender from radio buttons
        WebElement radioButton = Driver.getDriver().findElement(By.xpath("//input[@value='female']"));
        radioButton.click();

    //10.Enter date of birth
        WebElement dateOfBirth = Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        dateOfBirth.sendKeys("03/08/2000");
        //faker.number().numberBetween(2004,1920)

    //11.Select Department/Office
        Select departmentDropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
        departmentDropdown.selectByIndex(faker.number().numberBetween(1,9));

    //12.Select Job Title
        Select jobTitle = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='job_title']")));
        jobTitle.selectByIndex(faker.number().numberBetween(1,8));

    //13.Select programming language from checkboxes

        WebElement programmingLanguage = Driver.getDriver().findElement(By.xpath("//input[@id='inlineCheckbox2']"));
        programmingLanguage.click();

    //14.Click to sign up button
        WebElement signInButton = Driver.getDriver().findElement(By.xpath("//button[@id='wooden_spoon']"));
        signInButton.click();

    //15.Verify success message “You’ve successfully completed registration.” is
    //displayed.
        WebElement message = Driver.getDriver().findElement(By.xpath("//p"));
        String actual= message.getText();
        String expected= "You've successfully completed registration!";
        Assert.assertEquals(expected,actual);

    }
}
