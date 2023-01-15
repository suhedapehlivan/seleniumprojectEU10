package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.utilities.SmartBearUtils;
import com.cydeo.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartbearExtraTask {


    public WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void smartbearLinkVerification(){

       //1. Open browser
        //2. Go to website:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        //3. Enter username: “Tester”
        //4. Enter password: “test”
        //5. Click to Login button
        SmartBearUtils.loginToSmartBear(driver,"Tester", "test" );

        //6. Print out count of all the links on landing page
      //(Locate all the links in the page.)
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));


        //7. Print out each link text on this page
        for (WebElement each : allLinks) {
            System.out.println("Text of each link: "+each.getText());

        }




    }

    @Test
    public void smartbearOrderPlacing(){
        //1. Open browser
        //2. Go to website:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        //3. Enter username: “Tester”
        //4. Enter password: “test”
        //5. Click on Login button
        SmartBearUtils.loginToSmartBear(driver,"Tester", "test" );

        //6. Click on Order
        WebElement order = driver.findElement(By.xpath("//a[.='Order']"));
        order.click();

        //7. Select familyAlbum from product, set quantity to 2
        WebElement familyAlbum = driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']/option[2]"));

        WebElement quantity = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
        quantity.sendKeys("2");

        //8. Click to “Calculate” button
        WebElement calculate = driver.findElement(By.xpath("//input[@value='Calculate']"));
        calculate.click();

        //9. Fill address Info with JavaFaker
        //• Generate: name, street, city, state, zip code
        Faker faker = new Faker();



       WebElement name = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']"));
       name.sendKeys(faker.name().fullName());

       WebElement street= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']"));
       street.sendKeys(faker.address().streetAddress());

       WebElement city = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']"));
       city.sendKeys(faker.address().city());

       WebElement state = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']"));
       state.sendKeys(faker.address().state());

       WebElement zipCode = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']"));
       zipCode.sendKeys(faker.numerify("########"));


        //10. Click on “visa” radio button
        WebElement visaButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_0']"));
        visaButton.click();

        //11. Generate card number using JavaFaker
        WebElement cardNumber = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']"));
        cardNumber.sendKeys(faker.numerify("##################"));

        WebElement expireDate =driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']"));
        expireDate.sendKeys(faker.numerify("##/##"));

        //12. Click on “Process”
        WebElement processButton = driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']"));
        processButton.click();

        //13.Verify success message “New order has been successfully added.”
        WebElement message= driver.findElement(By.xpath("//strong"));
        System.out.println("Message is displayed = " + message.isDisplayed());

    }

    @Test
    public void smartbearOrderVerification(){
        //TC#3: Smartbear software order verification
        //1. Open browser and login to Smartbear software
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        SmartBearUtils.loginToSmartBear(driver,"Tester", "test" );


        //2. Click on View all orders
        WebElement allOrdersClick= driver.findElement(By.xpath("//li[@class='selected']"));
        allOrdersClick.click();

        //3. Verify Susan McLaren has order on date “01/05/2010”
        WebElement susanDate= driver.findElement(By.xpath("//table[@class='SampleTable']/tbody//td[.='Susan McLaren']/following-sibling::td[3]"));

        String expected = "01/05/2010";
        String actual = susanDate.getText();

        Assert.assertEquals(expected,actual);

    }

}
