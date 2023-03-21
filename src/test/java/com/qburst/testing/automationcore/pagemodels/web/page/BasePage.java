package com.qburst.testing.automationcore.pagemodels.web.page;

import com.qburst.testing.automationcore.Constants;
import com.qburst.testing.automationcore.selenium.ParentDriver;
import com.qburst.testing.automationcore.selenium.browser.BrowserDriver;
import com.qburst.testing.automationcore.selenium.browser.page.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * All Global Objects and Actions in the Web Application is maintained here.
 */
public class BasePage extends Page {
    private static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);

    public BasePage(ParentDriver driver) {
        super(driver);
    }

    public String getURL() {
        if (Constants.TEST_ENVIRONMENT.equalsIgnoreCase("PROD"))
            return System.getProperty("test.prod.url");
        else if (Constants.TEST_ENVIRONMENT.equalsIgnoreCase("QA"))
            return System.getProperty("test.qa.url");
        else return System.getProperty("test.base.url");
    }
}
