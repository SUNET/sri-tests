package com.emergya.pageObjects;

import org.apache.log4j.Logger;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;
import com.emergya.utils.WebDriverUtils;

public class NetworkPage extends BasePageObject{
	
	static Logger log = Logger.getLogger(CommunityPage.class);
	
	private static final String NOOCLookLogo = "logo";
	private static final String ADDBUTTON = "addupperrightbutton";
	private static final String MENUITEMCUSTOMERS = "menuitemcustomers";
	private static final String MENUITEMENDUSERS = "menuitemendusers";

	public NetworkPage(EmergyaWebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
    public boolean isReady() {
        log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start isReady method");

        boolean status = this.isElementVisibleByXPath(NOOCLookLogo);

        log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - End isReady method");

        return status;
    }
	
    public void clickAddButton() {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start setName method");
    	if(isAddButtonVisible()) {
    		WebDriverUtils.click(driver, this.getElementByXPath(ADDBUTTON));
    	}
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End setName method");
    }
    
    public void clicMenuItemCustomers() {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start setName method");
    	if(isMenuItemCustomersVisible()) {
    		WebDriverUtils.click(driver, this.getElementByXPath(MENUITEMCUSTOMERS));
    	}
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End setName method");
    }
    
    public void clicMenuItemEndUsers() {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start setName method");
    	if(isMenuItemEndUsersVisible()) {
    		WebDriverUtils.click(driver, this.getElementByXPath(MENUITEMENDUSERS));
    	}
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End setName method");
    }
	
    public boolean isAddButtonVisible() {
   	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start isAddButtonVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End isAddButtonVisible method");
        return this.isElementVisibleByXPath(ADDBUTTON);
   }
    
    public boolean isMenuItemCustomersVisible() {
      	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                   + "]- Start isMenuItemCustomersVisible method");
           log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                   + "]- End isMenuItemCustomersVisible method");
           return this.isElementVisibleByXPath(MENUITEMCUSTOMERS);
      }
    
    public boolean isMenuItemEndUsersVisible() {
     	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                  + "]- Start isMenuItemEndUsersVisible method");
          log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                  + "]- End isMenuItemEndUsersVisible method");
          return this.isElementVisibleByXPath(MENUITEMENDUSERS);
     }

}
