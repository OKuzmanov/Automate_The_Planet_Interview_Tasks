package org.example.pages.all;

import org.example.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private final String HOME_URL = "https://www.zip-codes.com/";

    private By searchBtn = By.cssSelector("[value='Search']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToUrl() {
        driver.get(HOME_URL);
    }

    public AdvancedSearchPage clickSearchBtn() {
        driver.findElement(searchBtn).click();

        return new AdvancedSearchPage(driver);
    }
}
