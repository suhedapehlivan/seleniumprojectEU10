package com.cydeo.tests.day2_locators_getText_getAttribute.tasks;

public class Facebook2 {
    public static void main(String[] args) {
        //  //
        //        //TC #2: Facebook incorrect login title verification
        //        //1. Open Chrome browser
        //        //2. Go to https://www.facebook.com
        //        //3. Enter incorrect username
        //        //4. Enter incorrect password
        //        //5. Verify title changed to:
        //        //Expected: “Log into Facebook”
    }
}
/*
TIPS FOR TASK #2:
1. Set up driver
2. Open browser
3. Get webpage: https://www.facebook.com
4. Locate the username input box using one of 6 locators we learn, and send random string
using .sendKeys() method
5. Locate the password input box using one of 6 locators we learn, and send random string
using .sendKeys() method and Keys.ENTER
6. Get title and store it in new String (actual)
7. Create new String for expected
8. Verify results with if condition
*/