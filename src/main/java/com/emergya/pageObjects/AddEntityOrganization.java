package com.emergya.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;
import com.emergya.utils.WebDriverUtils;

public class AddEntityOrganization extends BasePageObject{
	
static Logger log = Logger.getLogger(CommunityPage.class);
	
	private static final String BUTTONBACK = "backbutton";
	private static final String FIELDNAME = "fieldname";
	private static final String FIELDDESCRIPTION = "fielddescription";
	private static final String FIELDURL = "fieldurl";
	private static final String FIELDWORKLOG = "fieldworklog";
	private static final String BUTTONSAVE = "buttonsave";
	private static final String BUTTONEDIT = "buttonedit";
	private static final String BUTTONSAVEEDIT = "buttonsaveedit";
	private static final String BUTTONSEND = "buttonsend";
	private static final String BUTTONDELETE = "buttondelete";
	private static final String TEXTAREACOMMENT = "textareacomment";
	private static final String DATEFIELDS = "datesfields";
	
	
	public AddEntityOrganization(EmergyaWebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isReady() {
        log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start isReady method");

        boolean status = isBackButtonVisible();

        log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - End isReady method");

        return status;
	}
	
    public void setName(String name) {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start setName method");
    	if(isFieldNameVisible()) {
    		this.getElementByXPath(FIELDNAME).sendKeys(name);
    	}
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End setName method");
    }
	
    public void setDescription(String description) {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start setDescription method");
    	if(isFieldDescriptionVisible()) {
    		this.getElementByXPath(FIELDDESCRIPTION).sendKeys(description);
    	}
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End setDescription method");
    }
    
    public void setURL(String url) {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start setURL method");
    	if(isFieldURLVisible()) {
    		this.getElementByXPath(FIELDURL).sendKeys(url);
    	}
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End setURL method");
    }
    
    public void setWorklog(String worklog) {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start setWorklog method");
    	if(isFieldWorklogVisible()) {
    		this.getElementByXPath(FIELDWORKLOG).sendKeys(worklog);
    	}
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End setWorklog method");
    }
    
    public void setTextAreaComment(String comment) {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start setTextAreaComment method");
    	if(isTextAreaCommentVisible()) {
    		this.getElementById(TEXTAREACOMMENT).sendKeys(comment);
    	}
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End setTextAreaComment method");
    }
    
    public void clickButtonSave() {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start clickButtonSave method");
    	if(isButtonSaveVisible()) {
    		WebElement buttonSave = this.getElementsByXPath(BUTTONSAVE).get(0);
    		WebDriverUtils.click(driver, buttonSave);
    	}
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End clickButtonSave method");
    }
    
    public void clickButtonEdit() {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start clickButtonEdit method");
    	if(isButtonEditVisible()) {
    		WebDriverUtils.click(driver, this.getElementByXPath(BUTTONEDIT));
    	}
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End clickButtonEdit method");
    }
    
    
    public void clickButtonSend() {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start clickButtonSend method");
    	if(isButtonSendVisible()) {
    		WebDriverUtils.click(driver, this.getElementByXPath(BUTTONSEND));
    	}
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End clickButtonSend method");
    }
    
    public void clickButtonDelete() {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start clickButtonDelete method");
    	if(isButtonDeleteVisible()) {
    		WebDriverUtils.click(driver, this.getElementByXPath(BUTTONDELETE));
    	}
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End clickButtonDelete method");
    }
    
    public String getCreationDate() {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start getCreationDate method");
    	String date = "";
    	if(isCreationDateVisible()) {
    		WebElement creationDate = this.getElementsByXPath(DATEFIELDS).get(0);
    		date = creationDate.getText();
    		date = date.replace("Created: ", "");
    	}
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End getCreationDate method");
    	return date;
    }
    
    public String getUpdateDate() {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start getUpdateDate method");
    	String date = "";
    	if(isUpdateDateVisible()) {
    		WebElement creationDate = this.getElementsByXPath(DATEFIELDS).get(1);
    		date = creationDate.getText();
    		date = date.replace("Last update: ", "");
    	}
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End getUpdateDate method");
    	return date;
    }
	
    public boolean isBackButtonVisible() {
      	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                   + "]- Start isBackButtonVisible method");
           log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                   + "]- End isBackButtonVisible method");
           return this.isElementVisibleByXPath(BUTTONBACK);
      }
    
    public boolean isFieldNameVisible() {
     	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                  + "]- Start isFieldNameVisible method");
          log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                  + "]- End isFieldNameVisible method");
          return this.isElementVisibleByXPath(FIELDNAME);
     }
    
    public boolean isFieldDescriptionVisible() {
    	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                 + "]- Start isFieldDescriptionVisible method");
         log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                 + "]- End isFieldDescriptionVisible method");
         return this.isElementVisibleByXPath(FIELDDESCRIPTION);
    }
    
    public boolean isFieldURLVisible() {
   	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start isFieldURLVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End isFieldURLVisible method");
        return this.isElementVisibleByXPath(FIELDURL);
   }
    
    public boolean isFieldWorklogVisible() {
      	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                   + "]- Start isFieldWorklogVisible method");
           log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                   + "]- End isFieldWorklogVisible method");
           return this.isElementVisibleByXPath(FIELDWORKLOG);
      }
    public boolean isTextAreaCommentVisible() {
     	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                  + "]- Start isTextAreaCommentVisible method");
          log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                  + "]- End isTextAreaCommentVisible method");
          return this.isElementVisibleById(TEXTAREACOMMENT);
     }
    
    public boolean isButtonSaveVisible() {
     	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                  + "]- Start isButtonSaveVisible method");
          log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                  + "]- End isButtonSaveVisible method");
          return this.isElementVisibleByXPath(BUTTONSAVE);
     }
    
    public boolean isButtonEditVisible() {
    	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                 + "]- Start isButtonEditVisible method");
         log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                 + "]- End isButtonEditVisible method");
         return this.isElementVisibleByXPath(BUTTONEDIT);
    }
    
    
    public boolean isButtonSendVisible() {
      	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                   + "]- Start isButtonSendVisible method");
           log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                   + "]- End isButtonSendVisible method");
           return this.isElementVisibleByXPath(BUTTONSEND);
      }
    
    public boolean isButtonDeleteVisible() {
     	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                  + "]- Start isButtonDeleteVisible method");
          log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                  + "]- End isButtonDeleteVisible method");
          return this.isElementVisibleByXPath(BUTTONDELETE);
     }
    
    public boolean isCreationDateVisible() {
    	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                 + "]- Start isCreationDateVisible method");
         log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                 + "]- End isCreationDateVisible method");
         WebElement creationDate = this.getElementsByXPath(DATEFIELDS).get(0);
         return this.isVisible(creationDate);
    }
    
    public boolean isUpdateDateVisible() {
   	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start isUpdateDateVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End isUpdateDateVisible method");
        WebElement creationDate = this.getElementsByXPath(DATEFIELDS).get(1);
        return this.isVisible(creationDate);
   }
}
