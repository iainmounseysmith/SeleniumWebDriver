package com.selenium.pageFactory;

import com.selenium.PageObjects.refactorExampleOne.pages.BasicAjaxPageObject;
import com.selenium.PageObjects.refactorExampleOne.pages.ProcessedFormPageObject;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.selenium.helpers.HelperClassesOLD.takeSnapShotFILE;

/**
 * Created by Iain Mounsey-Smith on 22/11/2015.
 */
public class MyPageFactory {
    public static WebDriver driver;

    final private String PROTOCOL="http:";
    final private String DOMAIN = "www.compendiumdev.co.uk/";

    final private String A = "AssertThat ";

    public static WebDriverWait wait;
    private BasicAjaxPageObject basicAjaxPage;
    private ProcessedFormPageObject ProcessedFormPage;
    private Integer language;

    @BeforeClass
    public static void setupDriver() {
        //startBrowserAndSelectServer();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10, 50);
    }
    @Before
    public void miscSetupBeforeTest() {
        //wait = new WebDriverWait(Adriver, 10, 50); //moved into startBrowserAndSelectServer
        basicAjaxPage = new BasicAjaxPageObject(driver);
        ProcessedFormPage = new ProcessedFormPageObject(driver);
        basicAjaxPage.get();}

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
    public void waitingForAjaxToCompleteRefactored(){
         basicAjaxPage.selectCategory(Category2.Server.CategoryCode);     //findCombo1AndSelectOptionServer();
         basicAjaxPage.selectCombo2Language(LanguageCodes2.JAVA.LanguageCode);//selectCombo2Language();
        basicAjaxPage.clickCodeInItButton();//submitFormandCheckResult
          ProcessedFormPage.waitUntilPageIsLoaded();
         //MatcherAssert.assertThat("The correct getText is '23'", ProcessedFormPage.waitUntilPageIsLoaded(), CoreMatchers.is("23"));
         takeSnapShotFILE(driver);
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
        driver.quit();
    } }