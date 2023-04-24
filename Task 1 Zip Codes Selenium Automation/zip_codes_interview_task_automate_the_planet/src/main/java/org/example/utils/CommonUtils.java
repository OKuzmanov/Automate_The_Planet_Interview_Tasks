package org.example.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class CommonUtils {

    public static void deleteScreenshotsFolderIfExists() {
        if (Files.exists(Path.of(System.getProperty("user.dir") + "//screenshots//"))) {
            try {
                FileUtils.deleteDirectory(new File(System.getProperty("user.dir") + "//screenshots//"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void takeScreenshot(WebDriver driver, String fileName) {
        TakesScreenshot ts = (TakesScreenshot) driver;

        File source = ts.getScreenshotAs(OutputType.FILE);

        File file = new File(System.getProperty("user.dir") + "//screenshots//" + fileName);

        try {
            FileUtils.copyFile(source, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String extractStateName(String stateTxt) {
        return stateTxt.substring(stateTxt.indexOf("[") + 1, stateTxt.indexOf("]"));
    }
}
