package ru.praktikum;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;

import java.io.File;
import java.time.Duration;

public class DriverRule extends ExternalResource {

    WebDriver driver;

    @Override
    protected void before() throws Throwable {
        if("firefox".equals(System.getProperty("browser")))
            setUpFirefox();
        else
            setUpChrome();

        driver.manage().window().maximize();
    }

    public void setUpFirefox() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        GeckoDriverService service = new GeckoDriverService.Builder()
                .usingDriverExecutable(new File("/Users/o.litvinov/BrowserDrivers/geckodriver/geckodriver"))
                .build();

        FirefoxOptions options = new FirefoxOptions()
                .setBinary("/Applications/Firefox.app/Contents/MacOS/firefox");

        driver = new FirefoxDriver(service, options);
    }

    public void setUpChrome() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("/Users/o.litvinov/BrowserDrivers/chromedriver-mac-arm64/chromedriver"))
                .build();

        ChromeOptions options = new ChromeOptions()
                .setBinary("/Users/o.litvinov/BrowserDrivers/chrome-mac-arm64/Google Chrome for Testing.app/Contents/MacOS/Google Chrome for Testing");

        driver = new ChromeDriver(service, options);
    }

    @Override
    protected void after() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
