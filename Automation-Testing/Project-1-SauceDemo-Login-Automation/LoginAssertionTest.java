package com.lakshitha.qa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginAssertionTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {

            driver.manage().window().maximize();

            driver.get("https://www.saucedemo.com/");

            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();

            // Assertion 1 - Verify Page Title
            String actualTitle = driver.getTitle();
            String expectedTitle = "Google";

            if (actualTitle.equals(expectedTitle)) {
                System.out.println("PASS - Page title is correct.");
            } else {
                System.out.println("FAIL - Page title is incorrect.");
            }

            // Assertion 2 - Verify URL
            String actualURL = driver.getCurrentUrl();

            if (actualURL.contains("inventory")) {
                System.out.println("PASS - User logged in successfully.");
            } else {
                System.out.println("FAIL - Login failed.");
            }

            // Assertion 3 - Verify Products Title
            WebElement productsTitle =
                    driver.findElement(By.className("title"));

            if (productsTitle.getText().equals("Products")) {
                System.out.println("PASS - Products page displayed.");
            } else {
                System.out.println("FAIL - Products page not displayed.");
            }

            Thread.sleep(3000);

        } catch (Exception e) {

            System.out.println("Test Failed: " + e.getMessage());

        } finally {

            driver.quit();

        }
    }
}