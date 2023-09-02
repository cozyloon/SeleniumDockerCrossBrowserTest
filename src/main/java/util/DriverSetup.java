package util;


import config.PropertyConfig;
import org.aeonbits.owner.ConfigCache;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverSetup {
    public static WebDriver driver;
    public static String SELENIUM_GRID_URL = "http://localhost:4444";
    public static PropertyConfig propertyConfig = ConfigCache.getOrCreate(PropertyConfig.class);

    public static void launchRemoteDriver(String browser) throws MalformedURLException {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            //options.addArguments("--headless=new");
            //options.addArguments("--remote-allow-origins=*");
            driver = new RemoteWebDriver(new URL(SELENIUM_GRID_URL), options);

        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--start-maximized");
           // options.addArguments("-headless");
            driver = new RemoteWebDriver(new URL(SELENIUM_GRID_URL), options);

        } else if (browser.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--start-maximized");
            //options.addArguments("--headless=new");
            driver = new RemoteWebDriver(new URL(SELENIUM_GRID_URL), options);
        }
        driver.get(propertyConfig.webUrl());
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public static void closeRemoteDriver() {
        driver.quit();
    }
}
