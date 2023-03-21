package com.qburst.testing.automationcore.testng;

import com.qburst.testing.automationcore.pagemodels.web.page.objects.TeslaPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TeslaTest extends BaseTest {

    @Test(testName = "Safety Text Verification", description = "Safety Text Verification on product description page")
    public void vefifySafteyText() {
        String expectedSafteyYexy = "Model 3 achieved NHTSA 5-star safety ratings in every category and subcategory.";

        TeslaPage teslaPage = new TeslaPage(driver);
        driver.navigate(teslaPage.getURL());
        teslaPage.model3MenuItem().click("Select Model 3 from the list");
        teslaPage.safteyParagraph().moveToElement("Scroll to view the saftey text");
        String actualSafteyText = teslaPage.safteyParagraph().getText();
        Assert.assertTrue(actualSafteyText.contains(expectedSafteyYexy));

        driver.staticWait(1500);

    }

    @Test(testName = "Safety Text Verification - Failing", description = "Safety Text Verification on product description page")
    public void vefifySafteyTextFailing() {
        String expectedSafteyYexy = "Incorrect expected text";

//        driver.navigate("https://tesla.com");
        TeslaPage teslaPage = new TeslaPage(driver);
        driver.navigate(teslaPage.getURL());
        teslaPage.model3MenuItem().click("Select Model 3 from the list");
        teslaPage.safteyParagraph().moveToElement("Scroll to view the saftey text");
        String actualSafteyText = teslaPage.safteyParagraph().getText();
        Assert.assertTrue(actualSafteyText.contains(expectedSafteyYexy));

        driver.staticWait(1500);

    }



}
