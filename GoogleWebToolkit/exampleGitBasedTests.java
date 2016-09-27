package com.selenium.GoogleWebToolkit;

import com.selenium.GoogleWebToolkit.CheckBox.IndividualCheckBoxTest;
import com.selenium.environment.MyDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import static com.selenium.environment.EnvironmentUnderTest.getUrl;
import static com.selenium.environment.MyDriverManager.*;

/**
 * Created by Iain Mounsey-Smith on 27/09/2016.
 */
public class exampleGitBasedTests {
    public IndividualCheckBoxTest testIndividualCheckBox;

    @Before
    public void setupTest() {
        //set(driverOrBrowserName.EDGE,remoteHostName.GRID,driverOrBrowserName.EDGE);
        set(driverOrBrowserName.GOOGLECHROME);
        get(getUrl("alerts"));
        testIndividualCheckBox = new IndividualCheckBoxTest(aDriver);

    }
    @Test
    public void runtestIndividualCheckBox(){
        get(getUrl("GWTCheckBox"));
        //testIndividualCheckBox.clickCheckBox("gwt-debug-cwCheckBox-Monday-input");
        //testIndividualCheckBox.clickCheckBox("gwt-debug-cwCheckBox-Monday-input","clickon");
        testIndividualCheckBox.clickCheckBox("gwt-debug-cwCheckBox-Tuesday-input","clickon");
        testIndividualCheckBox.clickCheckBox("gwt-debug-cwCheckBox-Tuesday-input","clickoff");
        testIndividualCheckBox.clickCheckBox("gwt-debug-cwCheckBox-Wednesday-input");
        //testIndividualCheckBox.clickCheckBox("gwt-debug-cwCheckBox-Thursday-input", "clickon");
        // testIndividualCheckBox.clickCheckBox("gwt-debug-cwCheckBox-Friday-input", "clickon");
        testIndividualCheckBox.defaultTest("gwt-debug-cwCheckBox-Saturday-input", false);
        testIndividualCheckBox.defaultTest("gwt-debug-cwCheckBox-Sunday-input", false);
        //testIndividualCheckBox.changeStateThenChangeBack("gwt-debug-cwCheckBox-Monday-input", false);
    }
    @AfterClass
    public static void quitDriver () {
        aDriver.quit();
    }
}
