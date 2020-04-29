package com.emergya.testSets;

import static org.testng.AssertJUnit.assertTrue;

import java.lang.reflect.Method;
import java.net.NetPermission;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.emergya.pageObjects.AddEntityOrganization;
import com.emergya.pageObjects.AddOrganization;
import com.emergya.pageObjects.CommunityPage;
import com.emergya.pageObjects.Login;
import com.emergya.pageObjects.NetworkPage;
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
public class FilterNetworkCommunityEntitiesTestSet extends BasicTestSet {

    static Logger log = Logger.getLogger(FilterNetworkCommunityEntitiesTestSet.class);

    public FilterNetworkCommunityEntitiesTestSet() {
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
     * TO - DO
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

    @Test(description = "filterCustomers",dataProvider = "remoteParams")
    public void filtersCustomers(String remoteParams) {
        //Go to community page
        networkPage = sriHome.clickOnNetwork();    
        driver.sleep(3);
        // Click on item contact in the menu
        isReady();
        String fromDate = "01/04/20";
        String toDate = "28/04/20";
        isInputFromDateVisible();
        networkPage.setFromDate(fromDate);
        isInputToDateVisible();
        networkPage.setToDate(toDate);
        driver.sleep(5);
        addEntityOrganization = networkPage.clickRowN(0);
        driver.sleep(3);
        isCreationDateVisible();
        String creationDate = addEntityOrganization.getCreationDate();
        if(!WebDriverUtils.isRemoteBrowser()) {
        	isDate1OlderThanDate2(fromDate,"dd/MM/yy",creationDate,"dd/MM/yyyy");
            isDate1OlderThanDate2(creationDate,"dd/MM/yyyy",toDate,"dd/MM/yy");
        }else {
        	isDate1OlderThanDate2(fromDate,"dd/MM/yy",creationDate,"MM/dd/yyyy");
            isDate1OlderThanDate2(creationDate,"MM/dd/yyyy",toDate,"dd/MM/yy");
        }
        isMenuItemCustomersVisible();
        networkPage.clickMenuItemCustomers();
        isRadioUpdatedVisible();
        networkPage.clickRadioUpdated();
        String fromDate2 = "01/04/20";
        String toDate2 = "28/04/20";
        isInputFromDateVisible();
        networkPage.setFromDate(fromDate);
        isInputToDateVisible();
        networkPage.setToDate(toDate);
        driver.sleep(5);
        addEntityOrganization = networkPage.clickRowN(0);
        driver.sleep(3);
        isUpdateDateVisible();
        String updateDate = addEntityOrganization.getUpdateDate();
        if(!WebDriverUtils.isRemoteBrowser()) {
        	isDate1OlderThanDate2(fromDate2,"dd/MM/yy",updateDate,"dd/MM/yyyy");
            isDate1OlderThanDate2(updateDate,"dd/MM/yyyy",toDate2,"dd/MM/yy");
        }else {
        	isDate1OlderThanDate2(fromDate2,"dd/MM/yy",updateDate,"MM/dd/yyyy");
            isDate1OlderThanDate2(updateDate,"MM/dd/yyyy",toDate2,"dd/MM/yy");
        }
        isMenuItemEndUsersVisible();
        networkPage.clickMenuItemEndUsers();
        isMenuItemCustomersVisible();
        networkPage.clickMenuItemCustomers();
        driver.sleep(3);
        isHeaderNameVisible();
        networkPage.clickHeaderName();
        driver.sleep(3);
        isButtonLoadAllVisible();
        networkPage.clickButtonLoadAll();
        driver.sleep(3);
        String name0 = networkPage.getNcolumnMrow(1, 0);
        String name1 = networkPage.getNcolumnMrow(1, 1);
        assertAlphabeticalOrder(name0,name1);
        String namen1 = networkPage.getNcolumnMrow(1, networkPage.getNumberRowsInTable()-2);
        String namen = networkPage.getNcolumnMrow(1, networkPage.getNumberRowsInTable()-1);
        assertAlphabeticalOrder(namen1,namen);
        isHeaderNameVisible();
        networkPage.clickHeaderName();
        isButtonLoadAllVisible();
        networkPage.clickButtonLoadAll();
        driver.sleep(3);
        String namez = networkPage.getNcolumnMrow(1, 0);
        String namez1 = networkPage.getNcolumnMrow(1, 1);
        assertAlphabeticalOrder(namez1,namez);
        String namea1 = networkPage.getNcolumnMrow(1, networkPage.getNumberRowsInTable()-2);
        String namea = networkPage.getNcolumnMrow(1, networkPage.getNumberRowsInTable()-1);
        assertAlphabeticalOrder(namea,namea1);
        isMenuItemEndUsersVisible();
        networkPage.clickMenuItemEndUsers();
        isMenuItemCustomersVisible();
        networkPage.clickMenuItemCustomers();
        driver.sleep(3);
        isHeaderDescriptionVisible();
        networkPage.clickHeaderDescription();
        driver.sleep(3);
        isButtonLoadAllVisible();
        networkPage.clickButtonLoadAll();
        driver.sleep(3);
        String description0 = networkPage.getNcolumnMrow(3, 0);
        String description1 = networkPage.getNcolumnMrow(3, 1);
        assertAlphabeticalOrder(description0,description1);
        String deescriptionn1 = networkPage.getNcolumnMrow(3, networkPage.getNumberRowsInTable()-2);
        String descriptionn = networkPage.getNcolumnMrow(3, networkPage.getNumberRowsInTable()-1);
        assertAlphabeticalOrder(deescriptionn1,descriptionn);
        isHeaderDescriptionVisible();
        networkPage.clickHeaderDescription();
        driver.sleep(3);
        isButtonLoadAllVisible();
        networkPage.clickButtonLoadAll();
        driver.sleep(3);
        String descriptionz = networkPage.getNcolumnMrow(3, 0);
        String descriptionz1 = networkPage.getNcolumnMrow(3, 1);
        assertAlphabeticalOrder(descriptionz1,descriptionz);
        String descriptiona1 = networkPage.getNcolumnMrow(3, networkPage.getNumberRowsInTable()-2);
        String descriptiona = networkPage.getNcolumnMrow(3, networkPage.getNumberRowsInTable()-1);
        assertAlphabeticalOrder(descriptiona,descriptiona1);
        isMenuItemEndUsersVisible();
        networkPage.clickMenuItemEndUsers();
        isMenuItemCustomersVisible();
        networkPage.clickMenuItemCustomers();
        driver.sleep(3);
        String searchWord = "Wilson";
        isWordFilterVisible();
        networkPage.setWordFilter(searchWord);
        driver.sleep(3);
        String name = networkPage.getNcolumnMrow(1, 0);
        assertTrue("The filter for words did not work properly",name.contains(searchWord));
        isMenuItemEndUsersVisible();
        networkPage.clickMenuItemEndUsers();
        isMenuItemCustomersVisible();
        networkPage.clickMenuItemCustomers();
        networkPage.clickOrderBy();
        driver.sleep(3);
        addEntityOrganization = networkPage.clickRowN(0);
        String date1 = addEntityOrganization.getCreationDate();
        networkPage.clickMenuItemEndUsers();
        isMenuItemCustomersVisible();
        networkPage.clickMenuItemCustomers();
        networkPage.clickOrderBy();
        driver.sleep(3);
        addEntityOrganization = networkPage.clickRowN(1);
        String date2 = addEntityOrganization.getCreationDate();
        if(!WebDriverUtils.isRemoteBrowser()) {
        	isDate1OlderThanDate2(date1,"dd/MM/yy",date2,"dd/MM/yyyy");
        }else {
        	isDate1OlderThanDate2(date1,"dd/MM/yy",date2,"MM/dd/yyyy");
        }
        isMenuItemEndUsersVisible();
        networkPage.clickMenuItemEndUsers();
        isMenuItemCustomersVisible();
        networkPage.clickMenuItemCustomers();
        networkPage.clickOrderBy();
        driver.sleep(3);
        networkPage.clickOrderBy();
        driver.sleep(3);
        addEntityOrganization = networkPage.clickRowN(0);
        String daten = addEntityOrganization.getCreationDate();
        networkPage.clickMenuItemEndUsers();
        isMenuItemCustomersVisible();
        networkPage.clickMenuItemCustomers();
        networkPage.clickOrderBy();
        driver.sleep(3);
        networkPage.clickOrderBy();
        driver.sleep(3);
        addEntityOrganization = networkPage.clickRowN(1);
        String daten1 = addEntityOrganization.getCreationDate();
        if(!WebDriverUtils.isRemoteBrowser()) {
        	isDate1OlderThanDate2(daten1,"dd/MM/yy",daten,"dd/MM/yyyy");
        }else {
        	isDate1OlderThanDate2(daten1,"dd/MM/yy",daten,"MM/dd/yyyy");
        }
     }
    

    @Test(description = "filterEndUsers",dataProvider = "remoteParams")
    public void filtersEndUsers(String remoteParams) {
        //Go to community page
        networkPage = sriHome.clickOnNetwork();
        isMenuItemEndUsersVisible();
        networkPage.clickMenuItemEndUsers();
        driver.sleep(3);
        // Click on item contact in the menu
        isReady();
        String fromDate = "01/04/20";
        String toDate = "28/04/20";
        isInputFromDateVisible();
        networkPage.setFromDate(fromDate);
        isInputToDateVisible();
        networkPage.setToDate(toDate);
        driver.sleep(5);
        addEntityOrganization = networkPage.clickRowN(0);
        driver.sleep(3);
        isCreationDateVisible();
        String creationDate = addEntityOrganization.getCreationDate();
        if(!WebDriverUtils.isRemoteBrowser()) {
        	isDate1OlderThanDate2(fromDate,"dd/MM/yy",creationDate,"dd/MM/yyyy");
            isDate1OlderThanDate2(creationDate,"dd/MM/yyyy",toDate,"dd/MM/yy");
        }else {
        	isDate1OlderThanDate2(fromDate,"dd/MM/yy",creationDate,"MM/dd/yyyy");
            isDate1OlderThanDate2(creationDate,"MM/dd/yyyy",toDate,"dd/MM/yy");
        }
        isMenuItemEndUsersVisible();
        networkPage.clickMenuItemEndUsers();
        isRadioUpdatedVisible();
        networkPage.clickRadioUpdated();
        String fromDate2 = "01/04/20";
        String toDate2 = "28/04/20";
        isInputFromDateVisible();
        networkPage.setFromDate(fromDate);
        isInputToDateVisible();
        networkPage.setToDate(toDate);
        driver.sleep(5);
        addEntityOrganization = networkPage.clickRowN(0);
        driver.sleep(3);
        isUpdateDateVisible();
        String updateDate = addEntityOrganization.getUpdateDate();
        if(!WebDriverUtils.isRemoteBrowser()) {
        	isDate1OlderThanDate2(fromDate2,"dd/MM/yy",updateDate,"dd/MM/yyyy");
            isDate1OlderThanDate2(updateDate,"dd/MM/yyyy",toDate2,"dd/MM/yy");
        }else {
        	isDate1OlderThanDate2(fromDate2,"dd/MM/yy",updateDate,"MM/dd/yyyy");
            isDate1OlderThanDate2(updateDate,"MM/dd/yyyy",toDate2,"dd/MM/yy");
        }
        isMenuItemCustomersVisible();
        networkPage.clickMenuItemCustomers();
        isMenuItemEndUsersVisible();
        networkPage.clickMenuItemEndUsers();
        driver.sleep(3);
        isHeaderNameVisible();
        networkPage.clickHeaderName();
        driver.sleep(3);
        isButtonLoadAllVisible();
        networkPage.clickButtonLoadAll();
        driver.sleep(3);
        String name0 = networkPage.getNcolumnMrow(1, 0);
        String name1 = networkPage.getNcolumnMrow(1, 1);
        assertAlphabeticalOrder(name0,name1);
        String namen1 = networkPage.getNcolumnMrow(1, networkPage.getNumberRowsInTable()-2);
        String namen = networkPage.getNcolumnMrow(1, networkPage.getNumberRowsInTable()-1);
        assertAlphabeticalOrder(namen1,namen);
        isHeaderNameVisible();
        networkPage.clickHeaderName();
        isButtonLoadAllVisible();
        networkPage.clickButtonLoadAll();
        driver.sleep(3);
        String namez = networkPage.getNcolumnMrow(1, 0);
        String namez1 = networkPage.getNcolumnMrow(1, 1);
        assertAlphabeticalOrder(namez1,namez);
        String namea1 = networkPage.getNcolumnMrow(1, networkPage.getNumberRowsInTable()-2);
        String namea = networkPage.getNcolumnMrow(1, networkPage.getNumberRowsInTable()-1);
        assertAlphabeticalOrder(namea,namea1);
        isMenuItemCustomersVisible();
        networkPage.clickMenuItemCustomers();
        isMenuItemEndUsersVisible();
        networkPage.clickMenuItemEndUsers();
        driver.sleep(3);
        isHeaderDescriptionVisible();
        networkPage.clickHeaderDescription();
        driver.sleep(3);
        isButtonLoadAllVisible();
        networkPage.clickButtonLoadAll();
        driver.sleep(3);
        String description0 = networkPage.getNcolumnMrow(3, 0);
        String description1 = networkPage.getNcolumnMrow(3, 1);
        assertAlphabeticalOrder(description0,description1);
        String deescriptionn1 = networkPage.getNcolumnMrow(3, networkPage.getNumberRowsInTable()-2);
        String descriptionn = networkPage.getNcolumnMrow(3, networkPage.getNumberRowsInTable()-1);
        assertAlphabeticalOrder(deescriptionn1,descriptionn);
        isHeaderDescriptionVisible();
        networkPage.clickHeaderDescription();
        driver.sleep(3);
        isButtonLoadAllVisible();
        networkPage.clickButtonLoadAll();
        driver.sleep(3);
        String descriptionz = networkPage.getNcolumnMrow(3, 0);
        String descriptionz1 = networkPage.getNcolumnMrow(3, 1);
        assertAlphabeticalOrder(descriptionz1,descriptionz);
        String descriptiona1 = networkPage.getNcolumnMrow(3, networkPage.getNumberRowsInTable()-2);
        String descriptiona = networkPage.getNcolumnMrow(3, networkPage.getNumberRowsInTable()-1);
        assertAlphabeticalOrder(descriptiona,descriptiona1);
        isMenuItemCustomersVisible();
        networkPage.clickMenuItemCustomers();
        isMenuItemEndUsersVisible();
        networkPage.clickMenuItemEndUsers();
        driver.sleep(3);
        String searchWord = "Ashley";
        isWordFilterVisible();
        networkPage.setWordFilter(searchWord);
        driver.sleep(3);
        String name = networkPage.getNcolumnMrow(1, 0);
        assertTrue("The filter for words did not work properly",name.contains(searchWord));
        isMenuItemCustomersVisible();
        networkPage.clickMenuItemCustomers();
        isMenuItemEndUsersVisible();
        networkPage.clickMenuItemEndUsers();
        networkPage.clickOrderBy();
        driver.sleep(3);
        addEntityOrganization = networkPage.clickRowN(0);
        String date1 = addEntityOrganization.getCreationDate();
        isMenuItemCustomersVisible();
        networkPage.clickMenuItemCustomers();
        isMenuItemEndUsersVisible();
        networkPage.clickMenuItemEndUsers();
        networkPage.clickOrderBy();
        driver.sleep(3);
        addEntityOrganization = networkPage.clickRowN(1);
        String date2 = addEntityOrganization.getCreationDate();
        if(!WebDriverUtils.isRemoteBrowser()) {
        	isDate1OlderThanDate2(date1,"dd/MM/yy",date2,"dd/MM/yyyy");
        }else {
        	isDate1OlderThanDate2(date1,"dd/MM/yy",date2,"MM/dd/yyyy");
        }
        isMenuItemCustomersVisible();
        networkPage.clickMenuItemCustomers();
        isMenuItemEndUsersVisible();
        networkPage.clickMenuItemEndUsers();
        networkPage.clickOrderBy();
        driver.sleep(3);
        networkPage.clickOrderBy();
        driver.sleep(3);
        addEntityOrganization = networkPage.clickRowN(0);
        String daten = addEntityOrganization.getCreationDate();
        isMenuItemCustomersVisible();
        networkPage.clickMenuItemCustomers();
        isMenuItemEndUsersVisible();
        networkPage.clickMenuItemEndUsers();
        networkPage.clickOrderBy();
        driver.sleep(3);
        networkPage.clickOrderBy();
        driver.sleep(3);
        addEntityOrganization = networkPage.clickRowN(1);
        String daten1 = addEntityOrganization.getCreationDate();
        if(!WebDriverUtils.isRemoteBrowser()) {
        	isDate1OlderThanDate2(daten1,"dd/MM/yy",daten,"dd/MM/yyyy");
        }else {
        	isDate1OlderThanDate2(daten1,"dd/MM/yy",daten,"MM/dd/yyyy");
        }
     }
    
    @Test(description = "filterProviders",dataProvider = "remoteParams")
    public void filtersProviders(String remoteParams) {
        //Go to community page
        networkPage = sriHome.clickOnNetwork();
        isMenuItemProvidersVisible();
        networkPage.clickMenuItemProviders();
        driver.sleep(3);
        // Click on item contact in the menu
        isReady();
        String fromDate = "01/04/20";
        String toDate = "28/04/20";
        isInputFromDateVisible();
        networkPage.setFromDate(fromDate);
        isInputToDateVisible();
        networkPage.setToDate(toDate);
        driver.sleep(5);
        addEntityOrganization = networkPage.clickRowN(0);
        driver.sleep(3);
        isCreationDateVisible();
        String creationDate = addEntityOrganization.getCreationDate();
        if(!WebDriverUtils.isRemoteBrowser()) {
        	isDate1OlderThanDate2(fromDate,"dd/MM/yy",creationDate,"dd/MM/yyyy");
            isDate1OlderThanDate2(creationDate,"dd/MM/yyyy",toDate,"dd/MM/yy");
        }else {
        	isDate1OlderThanDate2(fromDate,"dd/MM/yy",creationDate,"MM/dd/yyyy");
            isDate1OlderThanDate2(creationDate,"MM/dd/yyyy",toDate,"dd/MM/yy");
        }
        isMenuItemProvidersVisible();
        networkPage.clickMenuItemProviders();
        isRadioUpdatedVisible();
        networkPage.clickRadioUpdated();
        String fromDate2 = "01/04/20";
        String toDate2 = "28/04/20";
        isInputFromDateVisible();
        networkPage.setFromDate(fromDate);
        isInputToDateVisible();
        networkPage.setToDate(toDate);
        driver.sleep(5);
        addEntityOrganization = networkPage.clickRowN(0);
        driver.sleep(3);
        isUpdateDateVisible();
        String updateDate = addEntityOrganization.getUpdateDate();
        if(!WebDriverUtils.isRemoteBrowser()) {
        	isDate1OlderThanDate2(fromDate2,"dd/MM/yy",updateDate,"dd/MM/yyyy");
            isDate1OlderThanDate2(updateDate,"dd/MM/yyyy",toDate2,"dd/MM/yy");
        }else {
        	isDate1OlderThanDate2(fromDate2,"dd/MM/yy",updateDate,"MM/dd/yyyy");
            isDate1OlderThanDate2(updateDate,"MM/dd/yyyy",toDate2,"dd/MM/yy");
        }
        isMenuItemCustomersVisible();
        networkPage.clickMenuItemCustomers();
        isMenuItemProvidersVisible();
        networkPage.clickMenuItemProviders();
        driver.sleep(3);
        isHeaderNameVisible();
        networkPage.clickHeaderName();
        driver.sleep(3);
        //isButtonLoadAllVisible();
        //networkPage.clickButtonLoadAll();
        driver.sleep(3);
        String name0 = networkPage.getNcolumnMrow(1, 0);
        String name1 = networkPage.getNcolumnMrow(1, 1);
        assertAlphabeticalOrder(name0,name1);
        String namen1 = networkPage.getNcolumnMrow(1, networkPage.getNumberRowsInTable()-2);
        String namen = networkPage.getNcolumnMrow(1, networkPage.getNumberRowsInTable()-1);
        assertAlphabeticalOrder(namen1,namen);
        isHeaderNameVisible();
        networkPage.clickHeaderName();
        //isButtonLoadAllVisible();
        //networkPage.clickButtonLoadAll();
        driver.sleep(3);
        String namez = networkPage.getNcolumnMrow(1, 0);
        String namez1 = networkPage.getNcolumnMrow(1, 1);
        assertAlphabeticalOrder(namez1,namez);
        String namea1 = networkPage.getNcolumnMrow(1, networkPage.getNumberRowsInTable()-2);
        String namea = networkPage.getNcolumnMrow(1, networkPage.getNumberRowsInTable()-1);
        assertAlphabeticalOrder(namea,namea1);
        isMenuItemCustomersVisible();
        networkPage.clickMenuItemCustomers();
        isMenuItemProvidersVisible();
        networkPage.clickMenuItemProviders();
        driver.sleep(3);
        isHeaderDescriptionVisible();
        networkPage.clickHeaderDescription();
        driver.sleep(3);
        //isButtonLoadAllVisible();
        //networkPage.clickButtonLoadAll();
        driver.sleep(3);
        String description0 = networkPage.getNcolumnMrow(3, 0);
        String description1 = networkPage.getNcolumnMrow(3, 1);
        assertAlphabeticalOrder(description0,description1);
        String deescriptionn1 = networkPage.getNcolumnMrow(3, networkPage.getNumberRowsInTable()-2);
        String descriptionn = networkPage.getNcolumnMrow(3, networkPage.getNumberRowsInTable()-1);
        assertAlphabeticalOrder(deescriptionn1,descriptionn);
        isHeaderDescriptionVisible();
        networkPage.clickHeaderDescription();
        driver.sleep(3);
        //isButtonLoadAllVisible();
        //networkPage.clickButtonLoadAll();
        driver.sleep(3);
        String descriptionz = networkPage.getNcolumnMrow(3, 0);
        String descriptionz1 = networkPage.getNcolumnMrow(3, 1);
        assertAlphabeticalOrder(descriptionz1,descriptionz);
        String descriptiona1 = networkPage.getNcolumnMrow(3, networkPage.getNumberRowsInTable()-2);
        String descriptiona = networkPage.getNcolumnMrow(3, networkPage.getNumberRowsInTable()-1);
        assertAlphabeticalOrder(descriptiona,descriptiona1);
        isMenuItemCustomersVisible();
        networkPage.clickMenuItemCustomers();
        isMenuItemProvidersVisible();
        networkPage.clickMenuItemProviders();
        driver.sleep(3);
        String searchWord = "Allen";
        isWordFilterVisible();
        networkPage.setWordFilter(searchWord);
        driver.sleep(3);
        String name = networkPage.getNcolumnMrow(1, 0);
        assertTrue("The filter for words did not work properly",name.contains(searchWord));
        isMenuItemCustomersVisible();
        networkPage.clickMenuItemCustomers();
        isMenuItemProvidersVisible();
        networkPage.clickMenuItemProviders();
        networkPage.clickOrderBy();
        driver.sleep(3);
        addEntityOrganization = networkPage.clickRowN(0);
        String date1 = addEntityOrganization.getCreationDate();
        isMenuItemCustomersVisible();
        networkPage.clickMenuItemCustomers();
        isMenuItemProvidersVisible();
        networkPage.clickMenuItemProviders();
        networkPage.clickOrderBy();
        driver.sleep(3);
        addEntityOrganization = networkPage.clickRowN(1);
        String date2 = addEntityOrganization.getCreationDate();
        if(!WebDriverUtils.isRemoteBrowser()) {
        	isDate1OlderThanDate2(date1,"dd/MM/yy",date2,"dd/MM/yyyy");
        }else {
        	isDate1OlderThanDate2(date1,"dd/MM/yy",date2,"MM/dd/yyyy");
        }
        isMenuItemEndUsersVisible();
        networkPage.clickMenuItemEndUsers();
        isMenuItemProvidersVisible();
        networkPage.clickMenuItemProviders();
        networkPage.clickOrderBy();
        driver.sleep(3);
        networkPage.clickOrderBy();
        driver.sleep(3);
        addEntityOrganization = networkPage.clickRowN(0);
        String daten = addEntityOrganization.getCreationDate();
        isMenuItemCustomersVisible();
        networkPage.clickMenuItemCustomers();
        isMenuItemEndUsersVisible();
        networkPage.clickMenuItemEndUsers();
        networkPage.clickOrderBy();
        driver.sleep(3);
        networkPage.clickOrderBy();
        driver.sleep(3);
        addEntityOrganization = networkPage.clickRowN(1);
        String daten1 = addEntityOrganization.getCreationDate();
        if(!WebDriverUtils.isRemoteBrowser()) {
        	isDate1OlderThanDate2(daten1,"dd/MM/yy",daten,"dd/MM/yyyy");
        }else {
        	isDate1OlderThanDate2(daten1,"dd/MM/yy",daten,"MM/dd/yyyy");
        }
     }
    
    @Test(description = "filterOwners",dataProvider = "remoteParams")
    public void filtersOwners(String remoteParams) {
        //Go to community page
        networkPage = sriHome.clickOnNetwork();
        isMenuItemOwnersVisible();
        networkPage.clickMenuItemOwners();
        driver.sleep(3);
        // Click on item contact in the menu
        isReady();
        String fromDate = "01/04/20";
        String toDate = "28/04/20";
        isInputFromDateVisible();
        networkPage.setFromDate(fromDate);
        isInputToDateVisible();
        networkPage.setToDate(toDate);
        driver.sleep(5);
        addEntityOrganization = networkPage.clickRowN(0);
        driver.sleep(3);
        isCreationDateVisible();
        String creationDate = addEntityOrganization.getCreationDate();
        if(!WebDriverUtils.isRemoteBrowser()) {
        	isDate1OlderThanDate2(fromDate,"dd/MM/yy",creationDate,"dd/MM/yyyy");
            isDate1OlderThanDate2(creationDate,"dd/MM/yyyy",toDate,"dd/MM/yy");
        }else {
        	isDate1OlderThanDate2(fromDate,"dd/MM/yy",creationDate,"MM/dd/yyyy");
            isDate1OlderThanDate2(creationDate,"MM/dd/yyyy",toDate,"dd/MM/yy");
        }
        isMenuItemOwnersVisible();
        networkPage.clickMenuItemOwners();
        isRadioUpdatedVisible();
        networkPage.clickRadioUpdated();
        String fromDate2 = "01/04/20";
        String toDate2 = "28/04/20";
        isInputFromDateVisible();
        networkPage.setFromDate(fromDate);
        isInputToDateVisible();
        networkPage.setToDate(toDate);
        driver.sleep(5);
        addEntityOrganization = networkPage.clickRowN(0);
        driver.sleep(3);
        isUpdateDateVisible();
        String updateDate = addEntityOrganization.getUpdateDate();
        if(!WebDriverUtils.isRemoteBrowser()) {
        	isDate1OlderThanDate2(fromDate2,"dd/MM/yy",updateDate,"dd/MM/yyyy");
            isDate1OlderThanDate2(updateDate,"dd/MM/yyyy",toDate2,"dd/MM/yy");
        }else {
        	isDate1OlderThanDate2(fromDate2,"dd/MM/yy",updateDate,"MM/dd/yyyy");
            isDate1OlderThanDate2(updateDate,"MM/dd/yyyy",toDate2,"dd/MM/yy");
        }
        isMenuItemCustomersVisible();
        networkPage.clickMenuItemCustomers();
        isMenuItemOwnersVisible();
        networkPage.clickMenuItemOwners();
        driver.sleep(3);
        isHeaderNameVisible();
        networkPage.clickHeaderName();
        driver.sleep(3);
        //isButtonLoadAllVisible();
        //networkPage.clickButtonLoadAll();
        driver.sleep(3);
        String name0 = networkPage.getNcolumnMrow(1, 0);
        String name1 = networkPage.getNcolumnMrow(1, 1);
        assertAlphabeticalOrder(name0,name1);
        String namen1 = networkPage.getNcolumnMrow(1, networkPage.getNumberRowsInTable()-2);
        String namen = networkPage.getNcolumnMrow(1, networkPage.getNumberRowsInTable()-1);
        assertAlphabeticalOrder(namen1,namen);
        isHeaderNameVisible();
        networkPage.clickHeaderName();
        //isButtonLoadAllVisible();
        //networkPage.clickButtonLoadAll();
        driver.sleep(3);
        String namez = networkPage.getNcolumnMrow(1, 0);
        String namez1 = networkPage.getNcolumnMrow(1, 1);
        assertAlphabeticalOrder(namez1,namez);
        String namea1 = networkPage.getNcolumnMrow(1, networkPage.getNumberRowsInTable()-2);
        String namea = networkPage.getNcolumnMrow(1, networkPage.getNumberRowsInTable()-1);
        assertAlphabeticalOrder(namea,namea1);
        isMenuItemCustomersVisible();
        networkPage.clickMenuItemCustomers();
        isMenuItemOwnersVisible();
        networkPage.clickMenuItemOwners();
        driver.sleep(3);
        isHeaderDescriptionVisible();
        networkPage.clickHeaderDescription();
        driver.sleep(3);
        //isButtonLoadAllVisible();
        //networkPage.clickButtonLoadAll();
        driver.sleep(3);
        String description0 = networkPage.getNcolumnMrow(3, 0);
        String description1 = networkPage.getNcolumnMrow(3, 1);
        assertAlphabeticalOrder(description0,description1);
        String deescriptionn1 = networkPage.getNcolumnMrow(3, networkPage.getNumberRowsInTable()-2);
        String descriptionn = networkPage.getNcolumnMrow(3, networkPage.getNumberRowsInTable()-1);
        assertAlphabeticalOrder(deescriptionn1,descriptionn);
        isHeaderDescriptionVisible();
        networkPage.clickHeaderDescription();
        driver.sleep(3);
        //isButtonLoadAllVisible();
        //networkPage.clickButtonLoadAll();
        driver.sleep(3);
        String descriptionz = networkPage.getNcolumnMrow(3, 0);
        String descriptionz1 = networkPage.getNcolumnMrow(3, 1);
        assertAlphabeticalOrder(descriptionz1,descriptionz);
        String descriptiona1 = networkPage.getNcolumnMrow(3, networkPage.getNumberRowsInTable()-2);
        String descriptiona = networkPage.getNcolumnMrow(3, networkPage.getNumberRowsInTable()-1);
        assertAlphabeticalOrder(descriptiona,descriptiona1);
        isMenuItemCustomersVisible();
        networkPage.clickMenuItemCustomers();
        isMenuItemOwnersVisible();
        networkPage.clickMenuItemOwners();
        driver.sleep(3);
        String searchWord = "Gunnar";
        isWordFilterVisible();
        networkPage.setWordFilter(searchWord);
        driver.sleep(3);
        String name = networkPage.getNcolumnMrow(1, 0);
        assertTrue("The filter for words did not work properly",name.contains(searchWord));
        isMenuItemCustomersVisible();
        networkPage.clickMenuItemCustomers();
        isMenuItemOwnersVisible();
        networkPage.clickMenuItemOwners();
        networkPage.clickOrderBy();
        driver.sleep(3);
        addEntityOrganization = networkPage.clickRowN(0);
        String date1 = addEntityOrganization.getCreationDate();
        isMenuItemCustomersVisible();
        networkPage.clickMenuItemCustomers();
        isMenuItemOwnersVisible();
        networkPage.clickMenuItemOwners();
        networkPage.clickOrderBy();
        driver.sleep(3);
        addEntityOrganization = networkPage.clickRowN(1);
        String date2 = addEntityOrganization.getCreationDate();
        if(!WebDriverUtils.isRemoteBrowser()) {
        	isDate1OlderThanDate2(date1,"dd/MM/yy",date2,"dd/MM/yyyy");
        }else {
        	isDate1OlderThanDate2(date1,"dd/MM/yy",date2,"MM/dd/yyyy");
        }
        isMenuItemEndUsersVisible();
        networkPage.clickMenuItemEndUsers();
        isMenuItemOwnersVisible();
        networkPage.clickMenuItemOwners();
        networkPage.clickOrderBy();
        driver.sleep(3);
        networkPage.clickOrderBy();
        driver.sleep(3);
        addEntityOrganization = networkPage.clickRowN(0);
        String daten = addEntityOrganization.getCreationDate();
        isMenuItemCustomersVisible();
        networkPage.clickMenuItemCustomers();
        isMenuItemEndUsersVisible();
        networkPage.clickMenuItemEndUsers();
        networkPage.clickOrderBy();
        driver.sleep(3);
        networkPage.clickOrderBy();
        driver.sleep(3);
        addEntityOrganization = networkPage.clickRowN(1);
        String daten1 = addEntityOrganization.getCreationDate();
        if(!WebDriverUtils.isRemoteBrowser()) {
        	isDate1OlderThanDate2(daten1,"dd/MM/yy",daten,"dd/MM/yyyy");
        }else {
        	isDate1OlderThanDate2(daten1,"dd/MM/yy",daten,"MM/dd/yyyy");
        }
     }
    
    public void isReady() {
    	if (networkPage == null) {
          	networkPage = new NetworkPage(driver);
          }
          assertTrue("Menu item Network is not visible",
                  networkPage.isReady());
          }
    
    public void isMenuItemCustomersVisible() {
    	if (networkPage == null) {
          	networkPage = new NetworkPage(driver);
          }
          assertTrue("Menu item Customers is not visible",
                  networkPage.isMenuItemCustomersVisible());
          }
    
    public void isMenuItemEndUsersVisible() {
    	if (networkPage == null) {
          	networkPage = new NetworkPage(driver);
          }
          assertTrue("Menu item End Users is not visible",
                  networkPage.isMenuItemEndUsersVisible());
          }
    
    public void isMenuItemProvidersVisible() {
    	if (networkPage == null) {
          	networkPage = new NetworkPage(driver);
          }
          assertTrue("Menu item Providers is not visible",
                  networkPage.isMenuItemProvidersVisible());
          }
    
    public void isMenuItemOwnersVisible() {
    	if (networkPage == null) {
          	networkPage = new NetworkPage(driver);
          }
          assertTrue("Menu item Owners is not visible",
                  networkPage.isMenuItemOwnersVisible());
          }
    
    public void isInputFromDateVisible() {
    	if (networkPage == null) {
          	networkPage = new NetworkPage(driver);
          }
          assertTrue("Input for From Date is not visible",
                  networkPage.isInputFromDateVisible());
          }
    
    public void isInputToDateVisible() {
    	if (networkPage == null) {
          	networkPage = new NetworkPage(driver);
          }
          assertTrue("Input for To Date is not visible",
                  networkPage.isInputToDateVisible());
          }
    
    public void isCreationDateVisible() {
    	if (addEntityOrganization == null) {
          	addEntityOrganization = new AddEntityOrganization(driver);
          }
          assertTrue("Creation Date is not visible",
                 addEntityOrganization.isCreationDateVisible());
          }
    
    public void isUpdateDateVisible() {
    	if (addEntityOrganization == null) {
          	addEntityOrganization = new AddEntityOrganization(driver);
          }
          assertTrue("Update Date is not visible",
                 addEntityOrganization.isUpdateDateVisible());
          }
    
    public void isRadioUpdatedVisible() {
    	if (networkPage == null) {
          	networkPage = new NetworkPage(driver);
          }
          assertTrue("Radio Updated is not visible",
                  networkPage.isRadioUpdatedVisible());
          }
    
    public void isButtonLoadAllVisible() {
    	if (networkPage == null) {
          	networkPage = new NetworkPage(driver);
          }
          assertTrue("Button Load All is not visible",
                  networkPage.isButtonLoadAllVisible());
          }
    
    public void isHeaderNameVisible() {
    	if (networkPage == null) {
          	networkPage = new NetworkPage(driver);
          }
          assertTrue("Header Name is not visible",
                  networkPage.isHeaderNameVisible());
          }
    
    public void isHeaderDescriptionVisible() {
    	if (networkPage == null) {
          	networkPage = new NetworkPage(driver);
          }
          assertTrue("Header Description is not visible",
                  networkPage.isHeaderDescriptionVisible());
          }
    
    public void isWordFilterVisible() {
    	if (networkPage == null) {
          	networkPage = new NetworkPage(driver);
          }
          assertTrue("Filter for words is not visible",
                  networkPage.isWordFilterVisible());
          }
    
    public void isDate1OlderThanDate2(String date1, String format1, String date2, String format2){
    	assertTrue("Date1 "+date1+" is older than date2 "+date2+" so it is not true",WebDriverUtils.dateCompareTo(date1, format1, date2, format2)<=0);
    }
    
    public void assertAlphabeticalOrder(String s1, String s2) {
    	if(!s1.equals("") && s2.equals("")) {
    		assertTrue("These strings are in the correct alphabetical order", true);
    	}else {
        	assertTrue("These strings are not in the correct alphabetical order",s1.compareTo(s2)<=0);
    	}
    }
}