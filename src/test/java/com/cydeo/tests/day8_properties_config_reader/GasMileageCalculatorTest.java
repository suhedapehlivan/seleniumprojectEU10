package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GasMileageCalculatorTest {
    //1. Add a new class GasMileageCalculatorTest

    public WebDriver driver;
    @BeforeMethod
    public void setupMethod(){


        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //2. Go to https://www.calculator.net
        driver.get("https://www.calculator.net");
    }

    @Test
    public void Gas_Mileage(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //3. Search for “gas mileage” using search box
        WebElement searchGasMileage=driver.findElement(By.xpath("//input[@name='calcSearchTerm']"));
        searchGasMileage.sendKeys("gas mileage");
        //4. Click on the “Gas Mileage Calculator” link
        WebElement clickButtonForGasMileage=driver.findElement(By.xpath("//tbody//a[.='Gas Mileage Calculator']"));
        clickButtonForGasMileage.isDisplayed();
        clickButtonForGasMileage.click();
        //5. On Next page verify:
        //a. Title equals: “Gas Mileage Calculator”

        BrowserUtils.verifyTitle(driver,"Gas Mileage Calculator");
        //b. “Gas Mileage Calculator” label is displayed????

        //6. Locate, clear and type “7925” into “Current odometer” field

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("(//img[@class='clearbtn'])[2]")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement current_Odometer=driver.findElement(By.xpath("//td//input[@name='mucodreading']"));
        current_Odometer.clear();
        current_Odometer.sendKeys("7925");
        //7. Locate, clear and type “7550” into “Previous odometer” field
        WebElement previous_Odometer=driver.findElement(By.xpath("//td//input[@name='mupodreading']"));
        previous_Odometer.clear();
        previous_Odometer.sendKeys("7550");
        //8. Locate, clear and type “16” into “Gas added” field
        WebElement gas_Added=driver.findElement(By.xpath("//td//input[@name='mugasputin']"));
        gas_Added.clear();
        gas_Added.sendKeys("16");
        //9. Locate, clear and type “3.55” into “Gas price” field
        WebElement gas_Price=driver.findElement(By.xpath("//td//input[@name='mugasprice']"));
        gas_Price.clear();
        gas_Price.sendKeys("3.55");
        /*
        WebElement firstInput = Driver.getDriver().findElement(By.xpath("//input[@name='mucodreading']"));

        firstInput.clear();
        firstInput.sendKeys("7925"
                + Keys.TAB+ Keys.DELETE+"7550"+Keys.TAB+Keys.DELETE+"16"+Keys.TAB+Keys.DELETE+"3.55");
         */

        //10. Click on Calculate button
        WebElement calculateButton=driver.findElement(By.xpath("(//input[@value='Calculate'])[2]"));
        calculateButton.click();

    }

}

/*
Task #: Gas Mileage Calculator Automation Test
1. Add a new class GasMileageCalculatorTest
2. Go to https://www.calculator.net
3. Search for “gas mileage” using search box
4. Click on the “Gas Mileage Calculator” link
5. On Next page verify:
a. Title equals: “Gas Mileage Calculator”
b. “Gas Mileage Calculator” label is displayed
6. Locate, clear and type “7925” into “Current odometer” field
7. Locate, clear and type “7550” into “Previous odometer” field
8. Locate, clear and type “16” into “Gas added” field
9. Locate, clear and type “3.55” into “Gas price” field
10. Click on Calculate button
11. Verify mpg value is as expected:
Expected value: “23.44 mpg
 */