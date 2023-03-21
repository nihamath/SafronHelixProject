package com.qburst.testing.automationcore.selenium.browser;

import com.qburst.testing.automationcore.Constants;
import com.qburst.testing.automationcore.utils.TestLog;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ChromeBrowserDriver extends BrowserDriver {


    @Override
    public synchronized void open() {
        TestLog.log().info("Opening chrome browser");
        ChromeOptions chromeOptions = new ChromeOptions();
        if (Constants.TEST_TRIGGER.equalsIgnoreCase("jenkins")||
                Constants.TEST_HEADLESS.equalsIgnoreCase("true")){
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--headless"); //!!!should be enabled for Jenkins
            chromeOptions.addArguments("--disable-dev-shm-usage"); //!!!should be enabled for Jenkins
            chromeOptions.addArguments("--window-size=1920x1080"); //!!!should be enabled for Jenkins
//            chromeOptions.setLogLevel(ChromeDriverLogLevel.ALL);
        }
        chromeOptions.setAcceptInsecureCerts(true);
        chromeOptions.addArguments("--start-maximized");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofMillis(Constants.DEFAULT_WAIT_TIMEOUT));
        driver.manage().deleteAllCookies();
    }




}
