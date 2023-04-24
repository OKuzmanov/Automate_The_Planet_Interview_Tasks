package org.example.tests;


import org.example.pages.all.AdvancedSearchPage;
import org.example.pages.all.HomePage;
import org.example.pages.all.SearchResultsPage;
import org.example.pojos.ZipCodePojo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

public class ZipCodesTests extends BaseTest {

    @Test
    public void test_gatherFirstTenZipCodeDetailsAndTakeScreenshots() {
        HomePage homePage = initializeHomePage();

        homePage.goToUrl();

        AdvancedSearchPage advancedSearchPage = homePage.clickSearchBtn();

        advancedSearchPage.acceptCookies();

        advancedSearchPage.clickOnAdvancedSearch();

        SearchResultsPage searchResultsPage = advancedSearchPage.searchByCityName("Ale");

        List<ZipCodePojo> zipCodePojosList = searchResultsPage.getSearchResultsList();

        searchResultsPage.takeScreenShotOfMapsLinks(zipCodePojosList);

        int countFiles = 0;

        try {
            File[] files = new File(System.getProperty("user.dir") + "//screenshots").listFiles();
            assert files != null;
            countFiles = files.length;

        } catch (NullPointerException e) {
            Assertions.fail("Directory '" + System.getProperty("user.dir") + "//screenshots" + "' contains 0 files");
        }

        Assertions.assertEquals(10, countFiles);
    }
}
