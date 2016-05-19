package com.selenium.GoogleWebToolkit.CheckBox;

import com.selenium.environment.HelperClasses;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.selenium.environment.MyDriverManager.aDriver;
import static com.selenium.environment.MyDriverManager.waitForJStoLoad;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;
/**
 * Created by Iain Mounsey-Smith on 1/05/2016.
 * clickCheckBox(String idOfCheckBox)
 * clickCheckBox(String idOfCheckBox,String action)
 *  action = clickon or clickoff
 *
 *  defaultTest(String idOfCheckBox,boolean defaultstate)
 *  false = NOT selected
 *  true = selected
 */
public class IndividualCheckBoxTest {
    private WebElement checkbox;
private WebDriver driver;
    public IndividualCheckBoxTest(WebDriver aDriver) {
        driver=aDriver;
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
    public void clickCheckBox(String idOfCheckBox,String action) {
        try {
            checkbox  = driver.findElement(By.cssSelector("input[id=\"" + idOfCheckBox + "\"]"));
            if (action=="clickon"){
                //testThatCheckBoxIsTickedIfNotForceUsingJavaScript(elementUnderTest);
                if (checkbox.isSelected()==false) //if TRUE then tester is asking for the wrong thing
                { System.out.println("clickon-isSelected is fALSE");
                    checkbox.click();
                    if (checkbox.isSelected()==false){
                        System.out.println("clickon-Checkbox is NOT selected");
                        CheckBoxNotTickedSoUseJavaScriptToTickIt(checkbox);
                        assertThat("dfdf",checkbox.isSelected(),is(true));}//we'll force it using javascript
                }else{
                    System.out.println("The checkbox is already selected - so I've made NO change ");
                    //add assert here to echk selected
                }
                assertThat("dfdf",checkbox.isSelected(),is(true));
            }
            if (action=="clickoff"){
                //isCheckBoxNotTicked(elementUnderTest);
                if (checkbox.isSelected()==true){
                    System.out.println("clickoff-Checkbox IS selected");
                    checkbox.click();
                    if (checkbox.isSelected()==true){
                        System.out.println("clickoff-isSelected IS TRUE");
                        CheckBoxNotTickedSoUseJavaScriptToTickIt(checkbox);//we'll force it using javascript
                        assertThat("dfdf", checkbox.isSelected(), is(false));
                    }
                }else{
                    System.out.println("The checkbox is already de-selected - so I've made NO change ");
                    //CheckBoxNotTickedSoUseJavaScriptToTickIt(checkbox);
                    //System.out.println("Checkbox IS selected");
                }
                //AssertAction(checkbox,selected);
                assertThat("dfdf",checkbox.isSelected(),is(false));
            }
                    } catch (NoSuchElementException e) {
            fail("Element not found - using id: \" "+ idOfCheckBox+ "\"");
            //e.printStackTrace();
        }
        //checkbox.click();

    }
    //from clickon, if not selected then use javascript
   // public static void testThatCheckBoxIsTickedIfNotForceUsingJavaScript(WebElement checkbox) {

   // }
       /* public static void AssertAction(WebElement elementundertest String state){
            if (state="selected"){Boolean state=True;)
            assertThat("dfdf",state,elementundertest.isSelected());
        }*/
    public void CheckBoxNotTickedSoUseJavaScriptToTickIt(WebElement checkbox) {
        System.out.println("Using Java to make selection");
        HelperClasses.js = (JavascriptExecutor) driver;
        System.out.println("CheckBoxNotTickedSoUseJavaScriptToTickIt");
        HelperClasses.js.executeScript("function toggle(checked) {" +
                "var element = document.getElementById('" + checkbox.getAttribute("id") + "');" +
                "if (checked != element.checked) {" +
                "element.click();" +
                "}}" +
                "toggle();");
    }


    @Test
    public void clickCheckBox(String idOfCheckBox) {
        checkbox  = driver.findElement(By.cssSelector("input[id=\"" + idOfCheckBox + "\"]"));
        checkbox.click();
           }


    public void defaultTest(String idOfCheckBox,boolean defaultstate) {
        //true = selected, false = not selected
        try {
            checkbox  = driver.findElement(By.cssSelector("input[id=\"" + idOfCheckBox + "\"]"));
            assertThat("Checking default state of check box",checkbox.isSelected(),is(equalTo(defaultstate)));
        } catch (Exception e) {
            //e.printStackTrace();
            fail("Element not found - using id: \" " + idOfCheckBox + "\"");
        }
    }


}
