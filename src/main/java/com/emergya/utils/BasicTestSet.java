package com.emergya.utils;

import com.emergya.pageObjects.Login;
import com.emergya.pageObjects.NetworkPage;
import com.emergya.pageObjects.NewContact;
import com.emergya.pageObjects.NewGroup;
import com.emergya.pageObjects.NewOrganization;
import com.emergya.pageObjects.SriHome;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.emergya.pageObjects.AddEntityForNetwork;
import com.emergya.pageObjects.AddOrganization;
import com.emergya.pageObjects.CommunityPage;
import com.emergya.selenium.testSet.DefaultTestSet;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.http.HttpResponse;


/**
 * PageObjects variable references
 * @author Iker Casado
 */
public abstract class BasicTestSet extends DefaultTestSet {
    protected Login login;
    protected SriHome sriHome;
    protected CommunityPage communityPage;
    protected AddOrganization addOrganization;
    protected NewOrganization newOrganization;
    protected NewContact newContact;
    protected NewGroup newGroup;
    protected NetworkPage networkPage;
    protected AddEntityForNetwork addEntityForNetwork;
    
    // ************************ After Methods *************************
    /**
     * Now this method will set our tests to pass or fail in CrossBrowserTesting's API after our tests methods
     * have been executed. It is really important not to overwrite the annotation @AfterMethod with another method 
     * because in that case we could cause an error. We only could override this annotation if we also 
     * execute this method in the method that overrides it
     * @param result
     */
    @AfterMethod(alwaysRun = true)
    public void setRemoteTestStatus(ITestResult result) {
        log.info("---------- setRemoteTestStatus - Start ----------");
        if ("Remote".equalsIgnoreCase(config.getBrowser())) {
        	try {
        		
        		switch (result.getStatus()) {
                case ITestResult.SUCCESS:
                    log.info("======PASS=====");
                    setScore(driver.getSessionId().toString(), "pass");
                    break;

                case ITestResult.FAILURE:
                    log.info("======FAIL=====");
                    setScore(driver.getSessionId().toString(), "fail");
                    break;

                case ITestResult.SKIP:
                    log.info("======SKIP BLOCKED=====");
                    setScore(driver.getSessionId().toString(), "unset");
                    break;

                default:
                    throw new RuntimeException("Invalid status");
                }
        	} catch (Exception e) {
        		System.out.println(e);
        		System.out.println(e.getStackTrace());
			}
        	finally {
        		log.info("---------- setRemoteTestStatus - End ----------");
       
        	}
        }
    }

    // ************************ Private Methods *************************
    /**
     * This is the method that does the real task of sending a request to CrossBrowserTesting's API
     * to set our tests pass or fail
     * @param seleniumTestId
     * @param score
     * @return
     */
    private JsonNode setScore(String seleniumTestId, String score) {
        // Mark a Selenium test as Pass/Fail
        HttpResponse<JsonNode> response = null;

        try {
            response = Unirest.put(
                    "http://crossbrowsertesting.com/api/v3/selenium/{seleniumTestId}")
                    .basicAuth(
                            CrossBrowserInitialization.getInstance().getRemoteUserName(),
                            CrossBrowserInitialization.getInstance().getRemoteUserKey())
                    .routeParam("seleniumTestId", seleniumTestId)
                    .field("action", "set_score").field("score", score)
                    .asJson();
        } catch (UnirestException e) {
            log.error(e.getMessage());
        }
        return response.getBody();
    }
}
