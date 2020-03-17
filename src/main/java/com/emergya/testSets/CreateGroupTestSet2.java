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
import com.emergya.pageObjects.SriHome;
import com.emergya.utils.BasicTestSet;

/**
 * A test class contain the tests of a specific page in the application
 * @author Jose Antonio Sanchez <jasanchez@emergya.com>
 * @author Ivan Bermudez <ibermudez@emergya.com>
 * @author Ivan Gomez <igomez@emergya.com>
 */
public class CreateGroupTestSet2 extends BasicTestSet {

    static Logger log = Logger.getLogger(CreateGroupTestSet2.class);

    public CreateGroupTestSet2() {
        super();
    }
  

    }

    // **************** TESTS ****************
    // ------ EMERGYA QA SAMPLE TEST ------ //
    // ------ US00001 - Check google main page and do a search ------ //
    /**
     * Description: Create a new group and assert that is created propertly
     *
     * Pre steps:
     * - Open the browser
     * - Login
     *
     * Steps:
     * - Go to www.google.es
     * - Check that the google logo is displayed
     * - Check that the 'Buscar con Google' button is displayed
     * - Check that the 'Voy a tener suerte' button is displayed
     * - Check that the search field is displayed
     * - Do this search 'Hello world!'
     * - Check that several results are displayed
     *
     * Post steps:
     * - Close the browser
     *
   
    @Test(description = "googleMainPageSearch")
    public void googleMainPageSearch(Method method) {
        log.info("[log-TestSet] " + this.getClass().getName()
                + " - Start test method: " + method.getName());

       CreateGroupTestSet testInstance = new CreateGroupTestSet();
       testInstance.googleMainPageSearch(null);
       
       
       
       
    }    
        
          */
        
        
        
        
      
        
  
