package com.emergya.testSets;

import static org.testng.AssertJUnit.assertTrue;

import java.lang.reflect.Method;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.emergya.pageObjects.AddOrganization;
import com.emergya.pageObjects.CommunityPage;
import com.emergya.pageObjects.Login;
import com.emergya.pageObjects.NewContact;
import com.emergya.pageObjects.NewGroup;
import com.emergya.pageObjects.NewOrganization;
import com.emergya.pageObjects.SriHome;
import com.emergya.utils.BasicTestSet;
import com.emergya.utils.WebDriverUtils;

import net.bytebuddy.matcher.IsNamedMatcher;

/**
 * A test class contain the tests of a specific page in the application
 * @author Jose Antonio Sanchez <jasanchez@emergya.com>
 * @author Ivan Bermudez <ibermudez@emergya.com>
 * @author Ivan Gomez <igomez@emergya.com>
 */
public class CommunityFiltersTestSet extends BasicTestSet {

    static Logger log = Logger.getLogger(CommunityFiltersTestSet.class);

    public CommunityFiltersTestSet() {
        super();
    }

    // **************** TESTS ****************
    // ------ EMERGYA QA SAMPLE TEST ------ //
    // ------ US00001 - Add Contact ------ //
    /**
     * Description: It should be possible to add a contact, with or without 
     * organization and role associated to it. Currently it only allows to add 
     * users with organizations associated.

     *
     * Pre steps:
     * We'll be able to order the contacts using the header of Contacts page
     * A few contacts created with more than one phone, email and multiple organizations.
     * Access to the website (https://sri.ed-integrations.com/)
     * Login as Admin
     * 
     * Steps
     * Click on Community
     * Click Contacts
     * Click on all the order arrows (on top of the table) twice (name,organization,Roles,contact type) 
     * The contacts will be ordered correctly
     * Click in the “updated from” radio button
     * Select both dates
     * The contacts will be filtered correctly according the dates
     * Click Contacts
     * Click in the “updated from” radio button
     * Select just one date 
     * The contacts will be filtered correctly according the date
     * Click on Community
     * Click Contacts
     * Click in the “updated from” radio button
     * Select both dates
     * Click on Reset Dates 
     * The dates will be cleared correctly
     * Click Contacts
     * Select “Filtered by word” and type “John” 
     * The contacts will be ordered correctly.
     * Click Contacts
     * Click on “Newest first”
     * The contacts will be ordered correctly.
     * Click Contacts
     * Click in the “created from” radio button
     * Select just one date
     * The contacts will be filtered correctly according the date
     * Click Contacts
     * Click in the “created from” radio button
     * Select both dates
     *  The contacts will be filtered correctly according the dates
     */
    /**
    @AfterMethod(description = "endTest")
    public void afterAllIsSaidAndDone() {
        super.afterAllIsSaidAndDone();
    }**/
    
    @BeforeMethod(description = "login")
    public void login() {
    	// Login
        String username = "admin";
        isReady(login = new Login(driver));
        login.fillUsername(username);
        login.fillPassword("Local.2019");
        sriHome = login.clickOnLogin();
    }

    @Test(description = "FilterContacts",dataProvider = "remoteParams")
    public void filterContact(String remoteParams) {
       
        //Go to community page
        communityPage = sriHome.clickOnCommunity();    
        driver.sleep(1);

        
        // Click on item contact in the menu
        communityPage.clickContactItem();
        driver.sleep(3);
        isFilterFromDateVisible();
        String fromDate = "31/03/20";
        String toDate = "30/04/20";
        communityPage.setFromDate(fromDate);
        isFilterToDateVisible();
        communityPage.setToDate(toDate);
        communityPage.clickElementNinTable(0);
        driver.sleep(3);
        String creationDate = communityPage.getCreationDate();
        isDate1OlderThanDate2(fromDate,"dd/mm/yy",creationDate,"dd/mm/yyyy");
        isDate1OlderThanDate2(creationDate,"dd/mm/yyyy",toDate,"dd/mm/yy");
        /*
        driver.navigate().back();
        driver.sleep(2);
        isFilterFromDateVisible();
        communityPage.setFromDate(fromDate);
        isFilterToDateVisible();
        communityPage.setToDate(toDate);
        driver.sleep(2);
        isLoadAllVisible();
        communityPage.clickLoadAll();
        driver.sleep(7);
        communityPage.clickElementNinTable(communityPage.getNumberElementsInTable()-1);
        driver.sleep(7);
        String creationDate2 = communityPage.getCreationDate();
        isDate1OlderThanDate2(creationDate2,"dd/mm/yyyy",fromDate,"mm/dd/yy");
        isDate1OlderThanDate2(toDate,"mm/dd/yy",creationDate2,"dd/mm/yyyy");
        */
        communityPage.clickGroupItem();
        communityPage.clickContactItem();
        driver.sleep(3);
        //communityPage.setWordFilter("Hanan Prestner");
        communityPage.clickOnHeaderName();
        driver.sleep(3);
        communityPage.clickLoadAll();
        driver.sleep(7);
        String name1 = communityPage.getNnameInTable(0);
        String name2 = communityPage.getNnameInTable(1);
        assertAlphabeticalOrder(name1,name2);
        String namen1 = communityPage.getNnameInTable(communityPage.getNumberElementsInTable()-2);
        String namen = communityPage.getNnameInTable(communityPage.getNumberElementsInTable()-1);
        assertAlphabeticalOrder(namen1, namen);
        
        communityPage.clickGroupItem();
        communityPage.clickContactItem();
        communityPage.clickOnHeaderName();
        driver.sleep(4);
        communityPage.clickOnHeaderName2();
        communityPage.clickLoadAll();
        driver.sleep(7);
        String namez = communityPage.getNnameInTable(0);
        String namez1 = communityPage.getNnameInTable(1);
        assertAlphabeticalOrder(namez1,namez);
        String namea1 = communityPage.getNnameInTable(communityPage.getNumberElementsInTable()-2);
        String namea = communityPage.getNnameInTable(communityPage.getNumberElementsInTable()-1);
        assertAlphabeticalOrder(namea, namea1);
        
        isInputWordFilterVisible();
        String search_word = "Nonnah";
        communityPage.setWordFilter(search_word);
        driver.sleep(3);
        String result_name = communityPage.getNnameInTable(0);
        assertTrue("The filter for words is not working",result_name.startsWith(search_word));
        
        }
    
    //Check if Delete Button is visible
    public void isFilterFromDateVisible() {
        if (communityPage == null) {
        	communityPage = new CommunityPage(driver);
        }
        assertTrue("From Date input is not visible",
                communityPage.isFilterFromDateVisible());
    }
    public void isFilterToDateVisible() {
        if (communityPage == null) {
        	communityPage = new CommunityPage(driver);
        }
        assertTrue("To Date input is not visible",
                communityPage.isFilterToDateVisible());
    }
    
    public void isLoadButtonVisible() {
        if (communityPage == null) {
        	communityPage = new CommunityPage(driver);
        }
        assertTrue("Load More button is not visible",
                communityPage.isLoadButtonVisible());
      }
       
       public void isLoadAllVisible() {
           if (communityPage == null) {
           	communityPage = new CommunityPage(driver);
           }
           assertTrue("Load All button is not visible",
                   communityPage.isLoadAllVisible());
         }
    
       public void isInputWordFilterVisible() {
           if (communityPage == null) {
              	communityPage = new CommunityPage(driver);
              }
              assertTrue("Filfer for words is not visible",
                      communityPage.isInputWordFilterVisible());
        }
       
    public void isDate1OlderThanDate2(String date1, String format1, String date2, String format2){
    	assertTrue("Date1 "+date1+" is older than date2 "+date2+" so it is not true",WebDriverUtils.dateCompareTo(date1, format1, date2, format2));
    }
    
    public void assertAlphabeticalOrder(String s1, String s2) {
    	assertTrue("These string are not in the correct alphabetical order",s1.compareTo(s2)<0);
    }
}