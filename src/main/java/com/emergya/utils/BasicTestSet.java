package com.emergya.utils;

import com.emergya.pageObjects.Login;
import com.emergya.pageObjects.NewOrganization;
import com.emergya.pageObjects.SriHome;
import com.emergya.pageObjects.AddOrganization;
import com.emergya.pageObjects.CommunityPage;
import com.emergya.selenium.testSet.DefaultTestSet;

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
}
