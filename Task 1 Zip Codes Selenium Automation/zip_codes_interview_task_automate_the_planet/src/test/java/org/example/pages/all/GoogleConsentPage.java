package org.example.pages.all;

import org.example.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleConsentPage extends BasePage {
    private By declineBtn = By.cssSelector("button[jsname='tWT92d']");

    public GoogleConsentPage(WebDriver driver) {
        super(driver);
    }

    public void declineCookies() {
        List<WebElement> elements = driver.findElements(declineBtn);
        elements.get(0).click();
    }
}
