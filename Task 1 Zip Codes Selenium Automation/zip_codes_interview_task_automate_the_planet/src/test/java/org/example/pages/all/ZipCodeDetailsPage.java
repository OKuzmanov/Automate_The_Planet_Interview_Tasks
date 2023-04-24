package org.example.pages.all;

import org.example.pages.BasePage;
import org.example.pojos.ZipCodePojo;
import org.example.utils.CommonUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ZipCodeDetailsPage extends BasePage {
    private By zipCode = By.xpath("//h2[contains(text(), 'Details')]/parent::div //td[span[text() = 'Zip Code:']]/parent::tr //td[@class='info']");
    private By cityName = By.xpath("//h2[contains(text(), 'Details')]/parent::div //td[span[text() = 'City:']]/parent::tr //td[@class='info']");
    private By state = By.xpath("//h2[contains(text(), 'Details')]/parent::div //td[span[text() = 'State:']]/parent::tr //td[@class='info']");
    private By longitude = By.xpath("//h2[contains(text(), 'Details')]/parent::div //td[span[text() = 'Longitude:']]/parent::tr //td[@class='info']");
    private By latitude = By.xpath("//h2[contains(text(), 'Details')]/parent::div //td[span[text() = 'Latitude:']]/parent::tr //td[@class='info']");

    public ZipCodeDetailsPage(WebDriver driver) {
        super(driver);
    }

    public ZipCodePojo generateZipCodePojo() {

        String zipCodeTxt = wait.until(ExpectedConditions.visibilityOfElementLocated(zipCode)).getText();
        String cityNameTxt = wait.until(ExpectedConditions.visibilityOfElementLocated(cityName)).getText();
        String stateTxt = wait.until(ExpectedConditions.visibilityOfElementLocated(state)).getText();
        String longitudeTxt = wait.until(ExpectedConditions.visibilityOfElementLocated(longitude)).getText();
        String latitudeTxt = wait.until(ExpectedConditions.visibilityOfElementLocated(latitude)).getText();

        return new ZipCodePojo(cityNameTxt, CommonUtils.extractStateName(stateTxt), zipCodeTxt, longitudeTxt, latitudeTxt);
    }
}
