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
        driver.sleep(3);

        
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
        if(!WebDriverUtils.isRemoteBrowser()) {
        	isDate1OlderThanDate2(fromDate,"dd/MM/yy",creationDate,"dd/MM/yyyy");
            isDate1OlderThanDate2(creationDate,"dd/MM/yyyy",toDate,"dd/MM/yy");
        }else {
        	isDate1OlderThanDate2(fromDate,"dd/MM/yy",creationDate,"MM/dd/yyyy");
            isDate1OlderThanDate2(creationDate,"MM/dd/yyyy",toDate,"dd/MM/yy");
        }
        
        
        communityPage.clickGroupItem();
        driver.sleep(3);
        communityPage.clickContactItem();
        driver.sleep(3);
        isButtonUpdatedVisible();
        communityPage.clickOnButtonUpdated();
        isFilterFromDateVisible();
        String fromDate2 = "31/03/20";
        String toDate2 = "30/04/20";
        communityPage.setFromDate(fromDate2);
        isFilterToDateVisible();
        communityPage.setToDate(toDate2);
        communityPage.clickElementNinTable(0);
        driver.sleep(3);
        String updateDate = communityPage.getUpdateDate();
        if(!WebDriverUtils.isRemoteBrowser()) {
        	isDate1OlderThanDate2(fromDate2,"dd/MM/yy",updateDate,"dd/MM/yyyy");
            isDate1OlderThanDate2(updateDate,"dd/MM/yyyy",toDate2,"dd/MM/yy");
        }else {
        	isDate1OlderThanDate2(fromDate2,"dd/MM/yy",updateDate,"MM/dd/yyyy");
            isDate1OlderThanDate2(updateDate,"MM/dd/yyyy",toDate2,"dd/MM/yy");
        }
        
        communityPage.clickGroupItem();
        driver.sleep(3);
        communityPage.clickContactItem();
        driver.sleep(3);
        isHeaderNameVisible();
        communityPage.clickOnHeaderName();
        driver.sleep(5);
        communityPage.clickLoadAll();
        driver.sleep(10);
        String name1 = communityPage.getNnameInTable(0);
        String name2 = communityPage.getNnameInTable(1);
        assertAlphabeticalOrder(name1,name2);
        String namen1 = communityPage.getNnameInTable(communityPage.getNumberElementsInTable()-2);
        String namen = communityPage.getNnameInTable(communityPage.getNumberElementsInTable()-1);
        assertAlphabeticalOrder(namen1, namen);
        
        communityPage.clickGroupItem();
        driver.sleep(3);
        communityPage.clickContactItem();
        driver.sleep(3);
        isHeaderNameVisible();
        communityPage.clickOnHeaderName();
        driver.sleep(5);
        isHeaderNameVisible();
        communityPage.clickOnHeaderName();
        communityPage.clickLoadAll();
        driver.sleep(10);
        String namez = communityPage.getNnameInTable(0);
        String namez1 = communityPage.getNnameInTable(1);
        assertAlphabeticalOrder(namez1,namez);
        String namea1 = communityPage.getNnameInTable(communityPage.getNumberElementsInTable()-2);
        String namea = communityPage.getNnameInTable(communityPage.getNumberElementsInTable()-1);
        assertAlphabeticalOrder(namea, namea1);
        
        communityPage.clickGroupItem();
        driver.sleep(3);
        communityPage.clickContactItem();
        driver.sleep(3);
        //communityPage.setWordFilter("Hanan Prestner");
        communityPage.clickOnHeaderOrganization();
        driver.sleep(5);
        communityPage.clickLoadAll();
        driver.sleep(10);
        String organization1 = communityPage.getNelementInSecondColumnInTable(0);
        String organization2 = communityPage.getNelementInSecondColumnInTable(1);
        assertAlphabeticalOrder(organization1,organization2);
        String organizationn1 = communityPage.getNelementInSecondColumnInTable(communityPage.getNumberElementsInTable()-2);
        String organizationn = communityPage.getNelementInSecondColumnInTable(communityPage.getNumberElementsInTable()-1);
        assertAlphabeticalOrder(organizationn1, organizationn);
        
        communityPage.clickGroupItem();
        driver.sleep(3);
        communityPage.clickContactItem();
        communityPage.clickOnHeaderOrganization();
        driver.sleep(5);
        communityPage.clickOnHeaderOrganization();
        communityPage.clickLoadAll();
        driver.sleep(10);
        String organizationz = communityPage.getNelementInSecondColumnInTable(0);
        String organizationz1 = communityPage.getNelementInSecondColumnInTable(1);
        assertAlphabeticalOrder(organizationz1,organizationz);
        String organizationa1 = communityPage.getNelementInSecondColumnInTable(communityPage.getNumberElementsInTable()-2);
        String organizationa = communityPage.getNelementInSecondColumnInTable(communityPage.getNumberElementsInTable()-1);
        assertAlphabeticalOrder(organizationa, organizationa1);
        
        communityPage.clickGroupItem();
        driver.sleep(3);
        communityPage.clickContactItem();
        driver.sleep(3);
        communityPage.clickOnHeaderIconSubMenu();
        communityPage.selectTypeOrderAZ();
        communityPage.clickAcceptFilterRole();
        String type1 = communityPage.getNelementInThirdColumnInTable(0);
        String type2 = communityPage.getNelementInThirdColumnInTable(1);
        assertAlphabeticalOrder(type2, type1);
        
        
        communityPage.clickGroupItem();
        driver.sleep(3);
        communityPage.clickContactItem();
        driver.sleep(3);
        communityPage.clickOnHeaderIconSubMenu();
        communityPage.selectTypeOrderZA();
        communityPage.clickAcceptFilterRole();
        String typez = communityPage.getNelementInThirdColumnInTable(0);
        String typea = communityPage.getNelementInThirdColumnInTable(1);
        assertAlphabeticalOrder(typez, typea);
        
        communityPage.clickGroupItem();
        driver.sleep(3);
        communityPage.clickContactItem();
        driver.sleep(3);
        communityPage.clickOnHeaderIconSubMenu();
        communityPage.selectRoleAbuse();
        communityPage.clickAcceptFilterRole();
        String roleabuse = communityPage.getNelementInThirdColumnInTable(0);
        String roleabuse2 = communityPage.getNelementInThirdColumnInTable(1);
        assertTrue("First element is not Abuse",roleabuse.equals("Abuse"));
        assertTrue("Second element is not Abuse",roleabuse2.equals("Abuse"));
        
        communityPage.clickGroupItem();
        driver.sleep(3);
        communityPage.clickContactItem();
        driver.sleep(3);
        communityPage.clickOnHeaderIconSubMenu();
        communityPage.selectRolePrimaryContact();
        communityPage.clickAcceptFilterRole();
        String roleprimarycontact = communityPage.getNelementInThirdColumnInTable(0);
        String roleprimarycontact2 = communityPage.getNelementInThirdColumnInTable(1);
        assertTrue("First element is not Primary contact at incidents",roleprimarycontact.equals("Primary contact at incidents"));
        assertTrue("Second element is not Primary contact at incidents",roleprimarycontact2.equals("Primary contact at incidents"));
        
        
        communityPage.clickGroupItem();
        driver.sleep(3);
        communityPage.clickContactItem();
        driver.sleep(3);
        communityPage.clickOnHeaderIconSubMenu();
        communityPage.selectRoleSecondaryContact();
        communityPage.clickAcceptFilterRole();
        String rolesecondarycontact = communityPage.getNelementInThirdColumnInTable(0);
        String rolesecondarycontact2 = communityPage.getNelementInThirdColumnInTable(1);
        assertTrue("First element is not Secondary contact at incidents",rolesecondarycontact.equals("Secondary contact at incidents"));
        assertTrue("Second element is not Secondary contact at incidents",rolesecondarycontact2.equals("Secondary contact at incidents"));
        
        communityPage.clickGroupItem();
        driver.sleep(3);
        communityPage.clickContactItem();
        driver.sleep(3);
        communityPage.clickOnHeaderIconSubMenu();
        communityPage.selectRoleNOCTechnical();
        communityPage.clickAcceptFilterRole();
        String roleNOCTechnical = communityPage.getNelementInThirdColumnInTable(0);
        String roleNOCTechnical2 = communityPage.getNelementInThirdColumnInTable(1);
        assertTrue("First element is not NOC Technical",roleNOCTechnical.equals("NOC Technical"));
        assertTrue("Second element is not NOC Technical",roleNOCTechnical2.equals("NOC Technical"));
        
        communityPage.clickGroupItem();
        driver.sleep(3);
        communityPage.clickContactItem();
        driver.sleep(3);
        communityPage.clickOnHeaderIconSubMenu();
        communityPage.selectRoleNOCSecurity();
        communityPage.clickAcceptFilterRole();
        String roleNOCSecurity = communityPage.getNelementInThirdColumnInTable(0);
        String roleNOCSecurity2 = communityPage.getNelementInThirdColumnInTable(1);
        assertTrue("First element is not NOC Security",roleNOCSecurity.equals("NOC Security"));
        assertTrue("Second element is not NOC Security",roleNOCSecurity2.equals("NOC Security"));
        
        communityPage.clickGroupItem();
        driver.sleep(3);
        communityPage.clickContactItem();
        driver.sleep(3);
        communityPage.clickOnHeaderIconSubMenu();
        communityPage.selectRoleNOCManager();
        communityPage.clickAcceptFilterRole();
        String roleNOCManager = communityPage.getNelementInThirdColumnInTable(0);
        String roleNOCManager2 = communityPage.getNelementInThirdColumnInTable(1);
        assertTrue("First element is not NOC Manager",roleNOCManager.equals("NOC Manager"));
        assertTrue("Second element is not NOC Manager",roleNOCManager2.equals("NOC Manager"));
        
        communityPage.clickGroupItem();
        driver.sleep(3);
        communityPage.clickContactItem();
        driver.sleep(3);
        communityPage.clickOnHeaderIconSubMenu();
        communityPage.selectRoleEmployee();
        communityPage.clickAcceptFilterRole();
        String roleEmployee = communityPage.getNelementInThirdColumnInTable(0);
        String roleEmployee2 = communityPage.getNelementInThirdColumnInTable(1);
        assertTrue("First element is not Employee",roleEmployee.equals("Employee"));
        assertTrue("Second element is not Employee",roleEmployee2.equals("Employee"));
        
        communityPage.clickGroupItem();
        driver.sleep(3);
        communityPage.clickContactItem();
        driver.sleep(3);
        communityPage.clickOnHeaderContentType();
        driver.sleep(5);
        communityPage.clickLoadAll();
        driver.sleep(10);
        String contenttype1 = communityPage.getNelementInFourthColumnInTable(0);
        String contenttype2 = communityPage.getNelementInFourthColumnInTable(1);
        assertAlphabeticalOrder(contenttype1,contenttype2);
        String contenttypen1 = communityPage.getNelementInFourthColumnInTable(communityPage.getNumberElementsInTable()-2);
        String contenttypen = communityPage.getNelementInFourthColumnInTable(communityPage.getNumberElementsInTable()-1);
        assertAlphabeticalOrder(contenttypen1, contenttypen);
        
        communityPage.clickGroupItem();
        communityPage.clickContactItem();
        communityPage.clickOnHeaderContentType();
        driver.sleep(5);
        communityPage.clickOnHeaderContentType();
        communityPage.clickLoadAll();
        driver.sleep(10);
        String contenttypez = communityPage.getNelementInFourthColumnInTable(0);
        String contenttypez1 = communityPage.getNelementInFourthColumnInTable(1);
        assertAlphabeticalOrder(contenttypez1,contenttypez);
        String contenttypea1 = communityPage.getNelementInFourthColumnInTable(communityPage.getNumberElementsInTable()-2);
        String contenttypea = communityPage.getNelementInFourthColumnInTable(communityPage.getNumberElementsInTable()-1);
        assertAlphabeticalOrder(contenttypea, contenttypea1);
        
        
        communityPage.clickGroupItem();
        driver.sleep(3);
        communityPage.clickContactItem();
        driver.sleep(3);
        String search_word = "Nonnah";
        communityPage.setWordFilter(search_word);
        driver.sleep(3);
        String result_name = communityPage.getNnameInTable(0);
        assertTrue("The filter for words is not working",result_name.startsWith(search_word));
        
        driver.sleep(3);
        communityPage.clickGroupItem();
        communityPage.clickContactItem();
        driver.sleep(3);
        communityPage.clickElementNinTable(0);
        driver.sleep(3);
        String dateElementPrior = communityPage.getCreationDate();
        communityPage.clickGroupItem();
        communityPage.clickContactItem();
        driver.sleep(3);
        communityPage.changeResultsOrder();
        communityPage.clickElementNinTable(0);
        String dateElementAfter = communityPage.getCreationDate();
        if(!WebDriverUtils.isRemoteBrowser()) {
        	isDate1OlderThanDate2(dateElementAfter,"dd/MM/yyyy",dateElementPrior,"dd/MM/yyyy");
        }else {
        	isDate1OlderThanDate2(dateElementAfter,"MM/dd/yyyy",dateElementPrior,"MM/dd/yyyy");
        }
     }
    
    @Test(description = "filterOrganizations",dataProvider = "remoteParams")
    public void filterOrganizations(String remoteParams) {
        //Go to community page
        communityPage = sriHome.clickOnCommunity();    
        driver.sleep(3);

        
        // Click on item contact in the menu
        //isOrganizationItemVisible();
        //communityPage.clickOrganizationsItems();
        driver.sleep(3);
        isFilterFromDateVisible();
        String fromDate = "01/04/20";
        String toDate = "30/04/20";
        communityPage.setFromDate(fromDate);
        isFilterToDateVisible();
        communityPage.setToDate(toDate);
        communityPage.clickElementNinTable(0);
        driver.sleep(3);
        String creationDate = communityPage.getCreationDate();
        if(!WebDriverUtils.isRemoteBrowser()) {
        	isDate1OlderThanDate2(fromDate,"dd/MM/yy",creationDate,"dd/MM/yyyy");
            isDate1OlderThanDate2(creationDate,"dd/MM/yyyy",toDate,"dd/MM/yy");
        }else {
        	isDate1OlderThanDate2(fromDate,"dd/MM/yy",creationDate,"MM/dd/yyyy");
            isDate1OlderThanDate2(creationDate,"MM/dd/yyyy",toDate,"dd/MM/yy");
        }
        
        
        communityPage.clickGroupItem();
        driver.sleep(3);
        communityPage.clickOrganizationsItems();
        driver.sleep(3);
        isButtonUpdatedVisible();
        communityPage.clickOnButtonUpdated();
        isFilterFromDateVisible();
        String fromDate2 = "01/04/20";
        String toDate2 = "30/04/20";
        communityPage.setFromDate(fromDate2);
        isFilterToDateVisible();
        communityPage.setToDate(toDate2);
        communityPage.clickElementNinTable(0);
        driver.sleep(3);
        String updateDate = communityPage.getUpdateDate();
        if(!WebDriverUtils.isRemoteBrowser()) {
        	isDate1OlderThanDate2(fromDate2,"dd/MM/yy",updateDate,"dd/MM/yyyy");
            isDate1OlderThanDate2(updateDate,"dd/MM/yyyy",toDate2,"dd/MM/yy");
        }else {
        	isDate1OlderThanDate2(fromDate2,"dd/MM/yy",updateDate,"MM/dd/yyyy");
            isDate1OlderThanDate2(updateDate,"MM/dd/yyyy",toDate2,"dd/MM/yy");
        }
        
        communityPage.clickGroupItem();
        driver.sleep(3);
        communityPage.clickOrganizationsItems();
        driver.sleep(3);
        isHeaderNameVisible();
        communityPage.clickOnHeaderName();
        driver.sleep(5);
        communityPage.clickLoadAll();
        driver.sleep(10);
        String name1 = communityPage.getNnameInTable(0);
        String name2 = communityPage.getNnameInTable(1);
        assertAlphabeticalOrder(name1,name2);
        String namen1 = communityPage.getNnameInTable(communityPage.getNumberElementsInTable()-2);
        String namen = communityPage.getNnameInTable(communityPage.getNumberElementsInTable()-1);
        assertAlphabeticalOrder(namen1, namen);
        
        driver.sleep(5);
        isHeaderNameVisible();
        communityPage.clickOnHeaderName();
        communityPage.clickLoadAll();
        driver.sleep(10);
        String namez = communityPage.getNnameInTable(0);
        String namez1 = communityPage.getNnameInTable(1);
        assertAlphabeticalOrder(namez1,namez);
        String namea1 = communityPage.getNnameInTable(communityPage.getNumberElementsInTable()-2);
        String namea = communityPage.getNnameInTable(communityPage.getNumberElementsInTable()-1);
        assertAlphabeticalOrder(namea, namea1);
        
        
        communityPage.clickGroupItem();
        driver.sleep(3);
        communityPage.clickOrganizationsItems();
        driver.sleep(3);
        //communityPage.setWordFilter("Hanan Prestner");
        communityPage.clickOnHeaderOrganizationID();
        driver.sleep(5);
        communityPage.clickLoadAll();
        driver.sleep(10);
        String org1 = communityPage.getNelementInSecondColumnInTable(0);
        String org2 = communityPage.getNelementInSecondColumnInTable(1);
        assertAlphabeticalOrder(org1,org2);
        String orgn1 = communityPage.getNelementInSecondColumnInTable(communityPage.getNumberElementsInTable()-2);
        String orgn = communityPage.getNelementInSecondColumnInTable(communityPage.getNumberElementsInTable()-1);
        assertAlphabeticalOrder(orgn1, orgn);
        
        communityPage.clickGroupItem();
        driver.sleep(3);
        communityPage.clickOrganizationsItems();
        driver.sleep(3);
        //communityPage.setWordFilter("Hanan Prestner");
        communityPage.clickOnHeaderOrganizationID();
        driver.sleep(5);
        communityPage.clickOnHeaderOrganizationID();
        driver.sleep(5);
        communityPage.clickLoadAll();
        driver.sleep(10);
        String orgz = communityPage.getNelementInSecondColumnInTable(0);
        String orgz1 = communityPage.getNelementInSecondColumnInTable(1);
        assertAlphabeticalOrder(orgz1,orgz);
        String orga1 = communityPage.getNelementInSecondColumnInTable(communityPage.getNumberElementsInTable()-2);
        String orga = communityPage.getNelementInSecondColumnInTable(communityPage.getNumberElementsInTable()-1);
        assertAlphabeticalOrder(orga, orga1);
        
        
        communityPage.clickGroupItem();
        driver.sleep(3);
        communityPage.clickOrganizationsItems();
        driver.sleep(3);
        communityPage.clickOnHeaderIconSubMenu();
        communityPage.selectTypeOrderAZ();
        communityPage.clickAcceptFilterRole();
        String type1 = communityPage.getNelementInThirdColumnInTable(0);
        String type2 = communityPage.getNelementInThirdColumnInTable(1);
        assertAlphabeticalOrder(type2, type1);
        
        
        communityPage.clickGroupItem();
        driver.sleep(3);
        communityPage.clickOrganizationsItems();
        driver.sleep(3);
        communityPage.clickOnHeaderIconSubMenu();
        communityPage.selectTypeOrderZA();
        communityPage.clickAcceptFilterRole();
        String typez = communityPage.getNelementInThirdColumnInTable(0);
        String typea = communityPage.getNelementInThirdColumnInTable(1);
        assertAlphabeticalOrder(typez, typea);
        
        communityPage.clickGroupItem();
        driver.sleep(3);
        communityPage.clickOrganizationsItems();
        driver.sleep(3);
        communityPage.clickOnHeaderIconSubMenu();
        communityPage.selectTypeCommercial();
        communityPage.clickAcceptFilterRole();
        String typecommercial = communityPage.getNelementInThirdColumnInTable(0);
        String typecommercial2 = communityPage.getNelementInThirdColumnInTable(1);
        assertTrue("First element is not Commercial",typecommercial.equals("partner"));
        assertTrue("Second element is not Commercial",typecommercial2.equals("partner"));
        
        
        communityPage.clickGroupItem();
        driver.sleep(3);
        communityPage.clickOrganizationsItems();
        driver.sleep(3);
        communityPage.clickOnHeaderIconSubMenu();
        communityPage.selectTypeMuseum();
        communityPage.clickAcceptFilterRole();
        String typemuseum = communityPage.getNelementInThirdColumnInTable(0);
        String typemuseum2 = communityPage.getNelementInThirdColumnInTable(1);
        assertTrue("First element is not Museum",typemuseum.equals("museum"));
        assertTrue("Second element is not Museum",typemuseum2.equals("museum"));
        
        communityPage.clickGroupItem();
        driver.sleep(3);
        communityPage.clickOrganizationsItems();
        driver.sleep(3);
        communityPage.clickOnHeaderIconSubMenu();
        communityPage.selectTypeResearch();
        communityPage.clickAcceptFilterRole();
        String typeresearch = communityPage.getNelementInThirdColumnInTable(0);
        String typeesearch2 = communityPage.getNelementInThirdColumnInTable(1);
        assertTrue("First element is not research",typeresearch.equals("research"));
        assertTrue("Second element is not researc",typeesearch2.equals("research"));
        
        communityPage.clickGroupItem();
        driver.sleep(3);
        communityPage.clickOrganizationsItems();
        driver.sleep(3);
        communityPage.clickOnHeaderIconSubMenu();
        communityPage.selectTypeStudent();
        communityPage.clickAcceptFilterRole();
        String typerstudent = communityPage.getNelementInThirdColumnInTable(0);
        String typeestudent2 = communityPage.getNelementInThirdColumnInTable(1);
        assertTrue("First element is not student_net",typerstudent.equals("student_net"));
        assertTrue("Second element is not student_net",typeestudent2.equals("student_net"));
        
        communityPage.clickGroupItem();
        driver.sleep(3);
        communityPage.clickOrganizationsItems();
        driver.sleep(3);
        communityPage.clickOnHeaderIconSubMenu();
        communityPage.selectTypeUniversityCollege();
        communityPage.clickAcceptFilterRole();
        String typeunicol = communityPage.getNelementInThirdColumnInTable(0);
        String typeunicol2 = communityPage.getNelementInThirdColumnInTable(1);
        assertTrue("First element is not university_college",typeunicol.equals("university_college"));
        assertTrue("Second element is not university_college",typeunicol2.equals("university_college"));
        
        communityPage.clickGroupItem();
        driver.sleep(3);
        communityPage.clickOrganizationsItems();
        driver.sleep(3);
        communityPage.clickOnHeaderIconSubMenu();
        communityPage.selectTypeUniversityDepartment();
        communityPage.clickAcceptFilterRole();
        String typeunidep = communityPage.getNelementInThirdColumnInTable(0);
        String typeunidep2 = communityPage.getNelementInThirdColumnInTable(1);
        assertTrue("First element is not university_coldep",typeunidep.equals("university_coldep"));
        assertTrue("Second element is not university_coldep",typeunidep2.equals("university_coldep"));
        
        communityPage.clickGroupItem();
        driver.sleep(3);
        communityPage.clickOrganizationsItems();
        driver.sleep(3);
        String search_word = "Myworks";
        communityPage.setWordFilter(search_word);
        driver.sleep(3);
        String result_name = communityPage.getNnameInTable(0);
        assertTrue("The filter for words is not working",result_name.startsWith(search_word));
        
        driver.sleep(3);
        communityPage.clickGroupItem();
        communityPage.clickOrganizationsItems();
        driver.sleep(3);
        communityPage.clickElementNinTable(0);
        driver.sleep(3);
        String dateElementPrior = communityPage.getCreationDate();
        communityPage.clickGroupItem();
        communityPage.clickOrganizationsItems();
        driver.sleep(3);
        communityPage.changeResultsOrder();
        communityPage.clickElementNinTable(0);
        String dateElementAfter = communityPage.getCreationDate();
        if(!WebDriverUtils.isRemoteBrowser()) {
        	isDate1OlderThanDate2(dateElementAfter,"dd/MM/yyyy",dateElementPrior,"dd/MM/yyyy");
        }else {
        	isDate1OlderThanDate2(dateElementAfter,"MM/dd/yyyy",dateElementPrior,"MM/dd/yyyy");
        }
     }

    @Test(description = "filterGroups",dataProvider = "remoteParams")
    public void filterGroups(String remoteParams) {
        //Go to community page
        communityPage = sriHome.clickOnCommunity();    
        driver.sleep(3);

        
        // Click on item contact in the menu
        isGroupItemVisible();
        communityPage.clickGroupItem();
        driver.sleep(3);
        isFilterFromDateVisible();
        String fromDate = "01/04/20";
        String toDate = "30/04/20";
        communityPage.setFromDate(fromDate);
        isFilterToDateVisible();
        communityPage.setToDate(toDate);
        communityPage.clickElementNinTable(0);
        driver.sleep(3);
        String creationDate = communityPage.getCreationDate();
        if(!WebDriverUtils.isRemoteBrowser()) {
        	isDate1OlderThanDate2(fromDate,"dd/MM/yy",creationDate,"dd/MM/yyyy");
            isDate1OlderThanDate2(creationDate,"dd/MM/yyyy",toDate,"dd/MM/yy");
        }else {
        	isDate1OlderThanDate2(fromDate,"dd/MM/yy",creationDate,"MM/dd/yyyy");
            isDate1OlderThanDate2(creationDate,"MM/dd/yyyy",toDate,"dd/MM/yy");
        }
        
        communityPage.clickOrganizationsItems();
        driver.sleep(3);
        communityPage.clickGroupItem();
        driver.sleep(3);
        isButtonUpdatedVisible();
        communityPage.clickOnButtonUpdated();
        isFilterFromDateVisible();
        String fromDate2 = "01/04/20";
        String toDate2 = "30/04/20";
        communityPage.setFromDate(fromDate2);
        isFilterToDateVisible();
        communityPage.setToDate(toDate2);
        communityPage.clickElementNinTable(0);
        driver.sleep(3);
        String updateDate = communityPage.getUpdateDate();
        if(!WebDriverUtils.isRemoteBrowser()) {
        	isDate1OlderThanDate2(fromDate2,"dd/MM/yy",updateDate,"dd/MM/yyyy");
            isDate1OlderThanDate2(updateDate,"dd/MM/yyyy",toDate2,"dd/MM/yy");
        }else {
        	isDate1OlderThanDate2(fromDate2,"dd/MM/yy",updateDate,"MM/dd/yyyy");
            isDate1OlderThanDate2(updateDate,"MM/dd/yyyy",toDate2,"dd/MM/yy");
        }
        
        
        communityPage.clickOrganizationsItems();
        driver.sleep(3);
        communityPage.clickGroupItem();
        
        driver.sleep(3);
        isHeaderNameVisible();
        communityPage.clickOnHeaderName();
        driver.sleep(5);
        //communityPage.clickLoadAll();
        driver.sleep(10);
        String name1 = communityPage.getNnameInTable(0);
        String name2 = communityPage.getNnameInTable(1);
        assertAlphabeticalOrder(name1,name2);
        //String namen1 = communityPage.getNnameInTable(communityPage.getNumberElementsInTable()-2);
        //String namen = communityPage.getNnameInTable(communityPage.getNumberElementsInTable()-1);
        //assertAlphabeticalOrder(namen1, namen);
        
        communityPage.clickOrganizationsItems();
        driver.sleep(3);
        communityPage.clickGroupItem();
        driver.sleep(3);
        isHeaderNameVisible();
        communityPage.clickOnHeaderName();
        driver.sleep(5);
        isHeaderNameVisible();
        communityPage.clickOnHeaderName();
        //communityPage.clickLoadAll();
        driver.sleep(10);
        String namez = communityPage.getNnameInTable(0);
        String namez1 = communityPage.getNnameInTable(1);
        assertAlphabeticalOrder(namez1,namez);
        //String namea1 = communityPage.getNnameInTable(communityPage.getNumberElementsInTable()-2);
        //String namea = communityPage.getNnameInTable(communityPage.getNumberElementsInTable()-1);
        //assertAlphabeticalOrder(namea1, namea);
        
        communityPage.clickOrganizationsItems();
        driver.sleep(3);
        communityPage.clickGroupItem();
        
        driver.sleep(3);
        //communityPage.setWordFilter("Hanan Prestner");
        communityPage.clickOnHeaderDescription();
        driver.sleep(5);
        //communityPage.clickLoadAll();
        driver.sleep(10);
        String description1 = communityPage.getNelementInSecondColumnInTable(0);
        String description2 = communityPage.getNelementInSecondColumnInTable(1);
        assertAlphabeticalOrder(description1,description2);
        //String descriptionn1 = communityPage.getNelementInSecondColumnInTable(communityPage.getNumberElementsInTable()-2);
        //String descriptionn = communityPage.getNelementInSecondColumnInTable(communityPage.getNumberElementsInTable()-1);
        //assertAlphabeticalOrder(descriptionn1, descriptionn);
        
        driver.sleep(5);
        communityPage.clickOnHeaderDescription();
        //communityPage.clickLoadAll();
        driver.sleep(10);
        String descriptionz = communityPage.getNelementInSecondColumnInTable(0);
        String descriptionz1 = communityPage.getNelementInSecondColumnInTable(1);
        assertAlphabeticalOrder(descriptionz1,descriptionz);
        //String descriptiona1 = communityPage.getNelementInSecondColumnInTable(communityPage.getNumberElementsInTable()-2);
        //String descriptiona = communityPage.getNelementInSecondColumnInTable(communityPage.getNumberElementsInTable()-1);
        //assertAlphabeticalOrder(descriptiona, descriptiona1);
        
        
        String search_word = "Group Test";
        communityPage.setWordFilter(search_word);
        driver.sleep(3);
        String result_name = communityPage.getNnameInTable(0);
        assertTrue("The filter for words is not working",result_name.startsWith(search_word));
        
        driver.sleep(3);
        communityPage.clickOrganizationsItems();
        communityPage.clickGroupItem();
        driver.sleep(3);
        communityPage.clickElementNinTable(0);
        driver.sleep(3);
        String dateElementPrior = communityPage.getCreationDate();
        communityPage.clickOrganizationsItems();
        communityPage.clickGroupItem();
        driver.sleep(3);
        communityPage.changeResultsOrder();
        communityPage.clickElementNinTable(0);
        String dateElementAfter = communityPage.getCreationDate();
        if(!WebDriverUtils.isRemoteBrowser()) {
        	isDate1OlderThanDate2(dateElementAfter,"dd/MM/yyyy",dateElementPrior,"dd/MM/yyyy");
        }else {
        	isDate1OlderThanDate2(dateElementAfter,"MM/dd/yyyy",dateElementPrior,"MM/dd/yyyy");
        }
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
    
       public void isButtonUpdatedVisible() {
           if (communityPage == null) {
              	communityPage = new CommunityPage(driver);
              }
              assertTrue("Radio button Updated is not visible",
                      communityPage.isButtonUpdatedVisible());
              }
       
    public void isDate1OlderThanDate2(String date1, String format1, String date2, String format2){
    	assertTrue("Date1 "+date1+" is older than date2 "+date2+" so it is not true",WebDriverUtils.dateCompareTo(date1, format1, date2, format2)<=0);
    }
    
    public void assertAlphabeticalOrder(String s1, String s2) {
    	assertTrue("These string are not in the correct alphabetical order",s1.compareTo(s2)<=0);
    }
    
    public void isOrganizationItemVisible() {
    	if (communityPage == null) {
          	communityPage = new CommunityPage(driver);
          }
          assertTrue("Organization item in menu is not visible",
                  communityPage.isOrganizationItemVisible());
          }
    

    public void isGroupItemVisible() {
    	if (communityPage == null) {
          	communityPage = new CommunityPage(driver);
          }
          assertTrue("Groups item in menu is not visible",
                  communityPage.isGroupItemVisible());
          }
    public void isHeaderNameVisible() {
    	if (communityPage == null) {
          	communityPage = new CommunityPage(driver);
          }
          assertTrue("Header name in the table is not visible",
                  communityPage.isHeaderNameVisible());
          }
}