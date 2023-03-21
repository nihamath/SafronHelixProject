package com.qburst.testing.automationcore.pagemodels.web.page.objects;

import com.qburst.testing.automationcore.pagemodels.web.page.BasePage;
import com.qburst.testing.automationcore.selenium.Element;
import com.qburst.testing.automationcore.selenium.ParentDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

/**
 * The page elements are maintained here
 */
public class TeslaPage extends BasePage {

    /*Below are the xpath locators for the elements from the Web Page*/
    String menu = "//button[@class='tds-site-nav-item tds--highlighted tds--product-name']";
    String model3MenuItem = "//a[@title='Model 3']/span";

    String orderNow = "//div[@class='tcl-hero__content-end tds-animate_small--reveal']//a[@class='tds-btn tcl-button tds-btn--secondary tcl-button--secondary']";

    String customOrder = "(//section[contains(@class,'vertical')]//a[@class='tds-btn tcl-button tds-btn--primary tcl-button--primary'][@data-gtm-drawer='model3'])[1]";
    String continueToPayment = "//button[@data-id='continue-to-payment-button']";

    String safteyParagraph = "(//strong[contains(text(),'5-Star Rating')]/..)[1]";



    public TeslaPage(ParentDriver driver) {
        super(driver);
    }

    /*Below are the objects identified from the web page*/
    public Element menuButton(){
        return driver.findElement(By.xpath(menu));
    }
    public Element model3MenuItem(){
        return driver.findVisibleElement(By.xpath(model3MenuItem));
    }

    public Element safteyParagraph(){
        try {
            return driver.findClickableElement(By.xpath(safteyParagraph));
        }catch (TimeoutException e){
            return driver.findPresentElement(By.xpath(safteyParagraph));
        }
    }

    public Element orderNow(){
        return driver.findElement(By.xpath(orderNow));
    }

    public Element customOrderButton(){
        return driver.findElement(By.xpath(customOrder));
    }

    public Element continueToPaymentButton(){
        return driver.findElement(By.xpath(continueToPayment));
    }
}
