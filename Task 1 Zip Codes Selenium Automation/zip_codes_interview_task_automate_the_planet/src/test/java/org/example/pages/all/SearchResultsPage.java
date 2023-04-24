package org.example.pages.all;

import org.example.pages.BasePage;
import org.example.pojos.ZipCodePojo;
import org.example.utils.CommonUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage extends BasePage {
    private By results = By.cssSelector("table.statTable > tbody > tr:not(tr:first-of-type) td:nth-of-type(1) > a");

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public List<ZipCodePojo> getSearchResultsList() {

        int resultsCount = wait.until(ExpectedConditions
                .visibilityOfAllElementsLocatedBy(results)).size();

        List<ZipCodePojo> zipCodePojosList = new ArrayList<>();

        for (int i = 0; i < (Math.min(10, resultsCount)); i++) {

            List<WebElement> zipCodeDetailsLinks = wait.until(ExpectedConditions
                    .visibilityOfAllElementsLocatedBy(results));

            zipCodeDetailsLinks.get(i).click();

            ZipCodeDetailsPage detailsPage = new ZipCodeDetailsPage(driver);

            ZipCodePojo newZipPojo = detailsPage.generateZipCodePojo();

            zipCodePojosList.add(newZipPojo);

            driver.navigate().back();
        }

        return zipCodePojosList;
    }

    public void takeScreenShotOfMapsLinks(List<ZipCodePojo> zipCodesList) {
        CommonUtils.deleteScreenshotsFolderIfExists();

        for (ZipCodePojo zipCodePojo: zipCodesList) {

            driver.get(zipCodePojo.generateGoogleMapsLink());

            if(driver.getCurrentUrl().contains("consent")) {
                new GoogleConsentPage(driver).declineCookies();
            }

            CommonUtils.takeScreenshot(driver, zipCodePojo.getCityName() + "-"
                    + zipCodePojo.getState() + "-"
                    + zipCodePojo.getZipCode()
                    + ".jpg");
        }
    }
}
