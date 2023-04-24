package org.example.tests;

import org.example.pages.all.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeEach
    public void setup() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
//        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--window-size=1920,937");
        chromeOptions.addArguments("--headless");


        driver = new ChromeDriver(chromeOptions);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    protected HomePage initializeHomePage() {
        return new HomePage(driver);
    }
}
