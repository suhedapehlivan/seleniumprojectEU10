package com.cydeo.tests.tasks;


import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task1 {
    @Test
    public void test1() throws InterruptedException {

        Driver.getDriver().get("http://automationexercise.com");
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Automation Exercise";
        Assert.assertEquals(actualTitle, expectedTitle);

        Driver.getDriver().findElement(By.linkText( "Signup / Login")).click();

        WebElement signUpText = Driver.getDriver().findElement(By.tagName("h2"));
        Assert.assertTrue(signUpText.isDisplayed());

        WebElement nameText = Driver.getDriver().findElement(By.xpath("//input[@data-qa='signup-name']"));

        Faker faker = new Faker();

        nameText.sendKeys(faker.name().fullName()+ Keys.TAB+faker.internet().emailAddress());

        Driver.getDriver().findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        WebElement displayHead2 = Driver.getDriver().findElement(By.xpath("//h2/b[text()='Enter Account Information']"));

        Assert.assertTrue(displayHead2.isDisplayed());

        WebElement radioButton = Driver.getDriver().findElement(By.id("id_gender1"));
        radioButton.click();

        WebElement password = Driver.getDriver().findElement(By.id("password"));
        password.sendKeys(faker.internet().password());

        Select selectDay = new Select( Driver.getDriver().findElement(By.id("days")));

        selectDay.selectByValue("15");

        Select selectMonth = new Select( Driver.getDriver().findElement(By.id("months")));

        selectMonth.selectByValue("4");

        Driver.getDriver().findElement(By.xpath("//select[@id='years']/option[@value='1997']")).click();

        WebElement newsLetter = Driver.getDriver().findElement(By.id("newsletter"));
        newsLetter.click();
        Driver.getDriver().findElement(By.id("optin")).click();

        WebElement firstName = Driver.getDriver().findElement(By.id("first_name"));

        firstName.sendKeys(faker.name().firstName()+ Keys.TAB+faker.name().lastName()+Keys.TAB
                + faker.company().name()+Keys.TAB+faker.address().streetName()+Keys.TAB+faker.address().cityName());

        Select country = new Select( Driver.getDriver().findElement(By.id("country")));

        country.selectByValue("Israel");

        Driver.getDriver().findElement(By.id("country")).sendKeys(Keys.TAB+faker.address().state()
                + Keys.TAB+ faker.address().cityName()+Keys.TAB+faker.address().zipCode()+Keys.TAB+faker.numerify("###-###-####"));

        Driver.getDriver().findElement(By.xpath("//button[@data-qa='create-account']")).click();

        Thread.sleep(2000);
        Assert.assertTrue(Driver.getDriver().findElement(By.tagName("h2")).isDisplayed());

        Driver.getDriver().findElement(By.xpath("//a[@data-qa='continue-button']")).click();


        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.xpath("//iframe[@id='aswift_2']")));

        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.xpath("//iframe[@id='ad_iframe']")));

        Driver.getDriver().findElement(By.xpath("//div[@id='dismiss-button']")).click();

        Driver.getDriver().switchTo().defaultContent();
        BrowserUtils.sleep(3);

        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//a[text()=' Logged in as ']")).isDisplayed());

        Driver.getDriver().findElement(By.xpath("//a[text()=' Delete Account']")).click();

        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//b[text()='Account Deleted!']")).isDisplayed());

        Driver.getDriver().findElement(By.xpath("//a[@data-qa='continue-button']")).click();



    }

  /*  @AfterMethod
    public void tearDown() {
        Driver.getDriver().close();
    }*/
}
/*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and email address
7. Click 'Signup' button
8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
9. Fill details: Title, Name, Email, Password, Date of birth
10. Select checkbox 'Sign up for our newsletter!'
11. Select checkbox 'Receive special offers from our partners!'
12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
13. Click 'Create Account button'
14. Verify that 'ACCOUNT CREATED!' is visible
15. Click 'Continue' button
16. Verify that 'Logged in as username' is visible
17. Click 'Delete Account' button
18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
 */