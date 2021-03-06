package ru.auto.ebay.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

/**
 * Created 05.10.2017.
 */
public class DriverManager {
    private static WebDriver webDriver;

    public static WebDriver driver() {
        if (webDriver == null) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
            seleniumSetup();
        }
        return webDriver;
    }

    public static void quit() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }

    private static void seleniumSetup() {
        webDriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }
}
