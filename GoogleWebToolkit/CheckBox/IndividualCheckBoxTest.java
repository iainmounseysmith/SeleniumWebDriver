package com.selenium.GoogleWebToolkit.CheckBox;

import org.apache.xpath.operations.Bool;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.selenium.GoogleWebToolkit.CheckBox.ListofCheckBoxsTest;
import static com.selenium.environment.MyDriverManager.aDriver;
import static com.selenium.environment.MyDriverManager.waitForJStoLoad;
import static com.selenium.GoogleWebToolkit.CheckBox.ListofCheckBoxsTest.*;
import static com.selenium.environment.HelperClasses.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Iain Mounsey-Smith on 1/05/2016.
 */
public class IndividualCheckBoxTest {
    public WebElement elementUnderTest;

    public IndividualCheckBoxTest(WebDriver aDriver) {

    }
    @BeforeClass
    public static void setupDriver() {
        //System.setProperty(MY_DRIVER, driverOrBrowserName.GOOGLECHROME.name());
        //System.setProperty(MY_DRIVER, "firefox");//old

           /*this is now where you set browser name if NOT running from mvn commandline or IDE run configuration
           first parameter (driverOrBrowserName) is the local driver you want to run, if running local only then second and third parameter should be omitted
           driverOrBrowserName can be passed on its own e.g.  set(driverOrBrowserName.FIREFOX);
           second parameter is the remote host name (grid or saucelabs) that you want to run on grid2
           the third parameter is the browser you want to run on the remote host*/


        //set(driverOrBrowserName.REMOTEWEB,remoteHostName.GRID,driverOrBrowserName.FIREFOX);
        //set(driverOrBrowserName.FIREFOX);
        //enter url as below - the get method will return aDriver

        //set(driverOrBrowserName.GOOGLECHROME);
        //aDriver = get("http://useragentstring.com/pages/Mobile%20Browserlist/");
        //wait = new WebDriverWait(MyDriverManager.aDriver, 10, 50);
        //get(getUrl("GWTCheckBox"));
        //System.out.println("local aDriver " + aDriver.getCurrentUrl());

        WebDriverWait wait = new WebDriverWait(aDriver,10,10);//This waits for 10 seconds for title to appear, polling every 50 ms.
        waitForJStoLoad(wait);
    }

    @Test
    public void clickCheckBox(String idOfCheckBox) {
        elementUnderTest  = aDriver.findElement(By.cssSelector("input[id=\"" + idOfCheckBox + "\"]"));
        elementUnderTest.click();
        isCheckBoxNotTicked(elementUnderTest);
    }
    @Test
    public void clickCheckBox(String idOfCheckBox,String toggle) {
        elementUnderTest  = aDriver.findElement(By.cssSelector("input[id=\"" + idOfCheckBox + "\"]"));
        elementUnderTest.click();
        if (toggle=="clickon"){
            testThatCheckBoxIsTickedIfNotForceUsingJavaScript(elementUnderTest);
        }
        if (toggle=="clickoff"){
            isCheckBoxNotTicked(elementUnderTest);
        }
    }

    public void defaultTest(String idOfCheckBox,boolean defaultstate) {
        //true = selected, false = not selected
        elementUnderTest  = aDriver.findElement(By.cssSelector("input[id=\"" + idOfCheckBox + "\"]"));
        assertThat("Checking default state of check box",elementUnderTest.isSelected(),is(equalTo(defaultstate)));
    }

    public void changeStateThenChangeBack(String idOfCheckBox,Boolean initialState) {
        elementUnderTest  = aDriver.findElement(By.cssSelector("input[id=\"" + idOfCheckBox + "\"]"));
if(initialState =false)
    {
        elementUnderTest.click();
        testThatCheckBoxIsTickedIfNotForceUsingJavaScript(elementUnderTest);
        assertThat(elementUnderTest.isSelected(), is(equalTo(true)));
        elementUnderTest.click();
        assertThat(elementUnderTest.isSelected(), is(equalTo(false)));
    }else{
    elementUnderTest.click();
    testThatCheckBoxIsTickedIfNotForceUsingJavaScript(elementUnderTest);
    assertThat(elementUnderTest.isSelected(), is(equalTo(false)));
    elementUnderTest.click();
    assertThat(elementUnderTest.isSelected(), is(equalTo(true)));
    }
}}
