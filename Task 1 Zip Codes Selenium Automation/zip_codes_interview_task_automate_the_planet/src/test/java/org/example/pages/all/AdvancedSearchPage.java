package org.example.pages.all;

import org.example.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AdvancedSearchPage extends BasePage {
    private By consentDialog = By.className("fc-dialog-container");
    private By consentBtn = By.cssSelector("button[aria-label='Consent']");
    private By advancedSearchHead = By.id("ui-id-7");
    private By advancedSearchDiv = By.cssSelector("div#ui-id-8");
    private By cityNameInput = By.cssSelector("input[placeholder='City'][size='25']");
    private By submitBtn = By.cssSelector("div#ui-id-8 > form input[name='Submit']");

    public AdvancedSearchPage(WebDriver driver) {
        super(driver);
    }

    public void acceptCookies() {
        WebElement consentDialogElem = wait.until(ExpectedConditions.visibilityOfElementLocated(consentDialog));

        consentDialogElem.findElement(consentBtn).click();
    }

    public void clickOnAdvancedSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(advancedSearchHead)).click();
    }

    public SearchResultsPage searchByCityName(String cityName) {
        wait.until(ExpectedConditions.attributeContains(advancedSearchDiv, "aria-hidden", "false"));

        wait.until(ExpectedConditions.elementToBeClickable(cityNameInput)).sendKeys(cityName);

        wait.until(ExpectedConditions.attributeContains(advancedSearchDiv, "aria-hidden", "false"));

        wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();

        return new SearchResultsPage(driver);
    }
}
