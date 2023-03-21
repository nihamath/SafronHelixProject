package com.qburst.testing.automationcore.selenium.browser;

import com.qburst.testing.automationcore.Constants;
import com.qburst.testing.automationcore.utils.TestLog;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FirefoxBrowserDriver extends BrowserDriver {


    @Override
    public synchronized void open() {
        TestLog.log().info("Opening firefox browser");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        if (Constants.TEST_TRIGGER.equalsIgnoreCase("jenkins")||
                Constants.TEST_HEADLESS.equalsIgnoreCase("true")){
            firefoxOptions.setHeadless(true);
            firefoxOptions.addArguments("--window-size=1920x1080"); //!!!should be enabled for Jenkins
        }
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver(firefoxOptions);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofMillis(Constants.DEFAULT_WAIT_TIMEOUT));
        driver.manage().deleteAllCookies();
    }




}
