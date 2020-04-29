package com.emergya.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;
import com.emergya.utils.WebDriverUtils;

public class NetworkPage extends BasePageObject{
	
	static Logger log = Logger.getLogger(CommunityPage.class);
	
	private static final String NOOCLookLogo = "logo";
	private static final String ADDBUTTON = "addupperrightbutton";
	private static final String MENUITEMCUSTOMERS = "menuitemcustomers";
	private static final String MENUITEMENDUSERS = "menuitemendusers";
	private static final String MENUITEMPROVIDERS = "menuitemproviders";
	private static final String MENUITEMOWNERS = "menuitemsiteowners";
	private static String USERIDXPATH = "//span[contains(text(),\"{USER}\")]";

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
	
    public AddEntityOrganization clickAddButton() {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start setName method");
    	if(isAddButtonVisible()) {
    		WebDriverUtils.click(driver, this.getElementByXPath(ADDBUTTON));
    	}
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End setName method");
    	return new AddEntityOrganization(driver);
    }
    
    public void clickMenuItemCustomers() {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start setName method");
    	if(isMenuItemCustomersVisible()) {
    		WebDriverUtils.click(driver, this.getElementByXPath(MENUITEMCUSTOMERS));
    	}
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End setName method");
    }
    
    public void clickMenuItemEndUsers() {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start setName method");
    	if(isMenuItemEndUsersVisible()) {
    		WebDriverUtils.click(driver, this.getElementByXPath(MENUITEMENDUSERS));
    	}
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End setName method");
    }
    
    public void clickMenuItemProviders() {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start clickMenuItemProviders method");
    	if(isMenuItemProvidersVisible()) {
    		WebDriverUtils.click(driver, this.getElementByXPath(MENUITEMPROVIDERS));
    	}
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End clickMenuItemProviders method");
    }
    
    public void clickMenuItemOwners() {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start clickMenuItemOwners method");
    	if(isMenuItemProvidersVisible()) {
    		WebDriverUtils.click(driver, this.getElementByXPath(MENUITEMOWNERS));
    	}
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End clickMenuItemOwners method");
    }
    
    public AddEntityOrganization clickInUser(String user) {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start setName method");
    	if(isUserVisible(user)) {
    		String xpath = USERIDXPATH.replace("{USER}", user);
            WebElement userrow = driver.findElementByXPath(xpath);
    		WebDriverUtils.click(driver, userrow);
    	}
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End setName method");
    	return new AddEntityOrganization(driver);
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
    
    public boolean isMenuItemProvidersVisible() {
    	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                 + "]- Start isMenuItemProvidersVisible method");
         log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                 + "]- End isMenuItemProvidersVisible method");
         return this.isElementVisibleByXPath(MENUITEMPROVIDERS);
    }
    
    public boolean isMenuItemOwnersVisible() {
   	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start isMenuItemOwnersVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End isMenuItemOwnersVisible method");
        return this.isElementVisibleByXPath(MENUITEMOWNERS);
   }
    
    public boolean isUserVisible(String user) {
    	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                 + "]- Start isUserVisible method");
         log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                 + "]- End isUserVisible method");
         String xpath = USERIDXPATH.replace("{USER}", user);
         WebElement userrow = null;
         try {
        	 userrow = driver.findElementByXPath(xpath);
         }catch(NoSuchElementException e) {
        	 userrow = null;
         }
         
         return userrow != null;
    }

}
