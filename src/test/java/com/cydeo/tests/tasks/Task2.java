package com.cydeo.tests.tasks;


import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task2 {
    @Test
    public void test() {
        Driver.getDriver().get("http://automationexercise.com");
        Assert.assertEquals(Driver.getDriver().getTitle(), "Automation Exercise");

        Driver.getDriver().findElement(By.xpath("//a[text()=' Contact us']")).click();

        WebElement nameInput = Driver.getDriver().findElement(By.xpath("//input[@data-qa='name']"));
        Faker faker = new Faker();

        nameInput.sendKeys(faker.name().fullName()+ Keys.TAB + faker.internet().emailAddress()+Keys.TAB
                +faker.animal().name()+Keys.TAB+faker.lorem().paragraph());

        String path = "C:\\Users\\Harry\\Desktop\\20230116_081159.jpg";

        WebElement uploadFile = Driver.getDriver().findElement(By.xpath("//input[@name='upload_file']"));
        BrowserUtils.sleep(3);
        uploadFile.sendKeys(path);
        BrowserUtils.sleep(2);
        Driver.getDriver().findElement(By.xpath("//input[@data-qa='submit-button']")).click();

        Driver.getDriver().switchTo().alert().accept();

        Assert.assertEquals(Driver.getDriver().findElement(By.xpath("//div[@class='status alert alert-success']")).getText(), "Success! Your details have been submitted successfully.");
    }
}
/*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Contact Us' button
5. Verify 'GET IN TOUCH' is visible
6. Enter name, email, subject and message
7. Upload file
8. Click 'Submit' button
9. Click OK button
10. Verify success message 'Success! Your details have been submitted successfully.' is visible
11. Click 'Home' button and verify that landed to home page successfully
 */