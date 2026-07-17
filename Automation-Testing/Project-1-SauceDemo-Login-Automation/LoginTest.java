package com.lakshitha.qa.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    public static void main(String[] args) {

        WebDriver driver = null;

        try {
            // Open Chrome browser
            driver = new ChromeDriver();

            // Maximize browser
            driver.manage().window().maximize();

            // Open SauceDemo
            driver.get("https://www.saucedemo.com/");

            // Enter username
            driver.findElement(By.id("user-name"))
                  .sendKeys("standard_user");

            // Enter password
            driver.findElement(By.id("password"))
                  .sendKeys("secret_sauce");

            // Click Login
            driver.findElement(By.id("login-button"))
                  .click();

            // Print page title
            System.out.println("Page title: " + driver.getTitle());

            // Keep browser open for 3 seconds
            Thread.sleep(3000);

        } catch (Exception e) {
            System.out.println("Test failed: " + e.getMessage());
            e.printStackTrace();

        } finally {
            // Close browser safely
            if (driver != null) {
                driver.quit();
            }
        }
    }
}