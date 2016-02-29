package com.selenium.pageFactory;

import com.selenium.PageObjects.refactorExampleOne.pages.BasicAjaxPageObject;
import com.selenium.PageObjects.refactorExampleOne.pages.ProcessedFormPageObject;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import static com.selenium.environment.MyDriverManager.*;
import static com.selenium.helpers.HelperClassesOLD.takeSnapShotFILE;
import static com.selenium.environment.EnvironmentUnderTest.*;
/**
 * Created by Iain Mounsey-Smith on 22/11/2015.
 * This script demonstrates some basic Selenium Webdriver testing of a test site using page objects.
 * One drop-down is selected and another drop-down is populated via Ajax calls based on the first selected option.
 * A combination of enums, page objects and WebDriver wait commands accomplishes the testing of 3 combinations of drop-down options,
 * which could easily be expanded to more combinations as required
 */
public class MyPageFactory {
    //public static WebDriver driver;
    final private String A = "AssertThat ";
    public static WebDriverWait wait;
    private BasicAjaxPageObject basicAjaxPage;
    private ProcessedFormPageObject ProcessedFormPage;
    private Integer language;

    @BeforeClass
    public static void setupDriver() {
        set(driverOrBrowserName.GOOGLECHROME);

    }
    @Before
    public void miscSetupBeforeTest() {
        get(getUrl("basic_ajax"));
        basicAjaxPage = new BasicAjaxPageObject(aDriver);
        ProcessedFormPage = new ProcessedFormPageObject(aDriver);
        }

    private enum Category2 {
        Web  (1),  //calls constructor with value 3
        Desktop(2),  //calls constructor with value 2
        Server   (3)   //calls constructor with value 1
        ; // semicolon needed when fields / methods follow

        private final int CategoryCode;

        private Category2(int levelCode) {//this is the constructor
            this.CategoryCode = levelCode;//setting field variable levelCode to equal what is passed in the constructor
        }
    }
    private enum LanguageCodes2 {
        JAVASCRIPT(0), VBSCRIPT(1), FLASH(2),
        COBOL(20), FORTRAN(21), SERVER_Cpp(22), JAVA(23),
        DESKTOP_Cpp(10), ASSEMBLER(11), C(12), VISUAL_BASIC(13);
        // semicolon needed when fields / methods follow

        private final int LanguageCode;

        private LanguageCodes2(int levelCode) {//this is the constructor
            this.LanguageCode = levelCode;//setting field variable levelCode to equal what is passed in the constructor
        }
    }
    @Test
    public void testServerJava(){
        basicAjaxPage.selectCategory(Category2.Server.CategoryCode);     //findCombo1AndSelectOptionServer();
        basicAjaxPage.selectCombo2Language(LanguageCodes2.JAVA.LanguageCode);//selectCombo2Language();
        basicAjaxPage.clickCodeInItButton();//submitFormandCheckResult
        ProcessedFormPage.waitUntilPageIsLoaded();
        //MatcherAssert.assertThat("The correct getText is '23'", ProcessedFormPage.waitUntilPageIsLoaded(), CoreMatchers.is("23"));
        takeSnapShotFILE(aDriver);
     }
 @Test
    public void testWebJavaScript(){
        basicAjaxPage.selectCategory(Category2.Web.CategoryCode);
        basicAjaxPage.selectCombo2Language(LanguageCodes2.JAVASCRIPT.LanguageCode);
        basicAjaxPage.clickCodeInItButton();
        ProcessedFormPage.waitUntilPageIsLoaded();
    }
    @Test
    public void testDesktopVisual_Basic(){
        basicAjaxPage.selectCategory(Category2.Desktop.CategoryCode);
        basicAjaxPage.selectCombo2Language(LanguageCodes2.VISUAL_BASIC.LanguageCode);
        basicAjaxPage.clickCodeInItButton();
        ProcessedFormPage.waitUntilPageIsLoaded();
    }
    @AfterClass
    public static void quitDriver() {
        aDriver.quit();
    } }