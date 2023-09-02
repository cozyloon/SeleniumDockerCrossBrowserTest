package util;


import config.PropertyConfig;
import org.aeonbits.owner.ConfigCache;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;


public class TestBase {
    public SoftAssert softAssert;
    public static PropertyConfig propertyConfig = ConfigCache.getOrCreate(PropertyConfig.class);

    @BeforeMethod
    @Parameters("browser")
    public void beforeClass(String browser) throws MalformedURLException {
        DriverSetup.launchRemoteDriver(browser);
    }

    @AfterMethod
    public void afterClass() {
        DriverSetup.closeRemoteDriver();
    }


    @BeforeTest
    public void beforeTest() {
        this.softAssert = new SoftAssert();
    }
}
