package com.selenium.PageObjects.refactorExampleOne.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.selenium.helpers.HelperClassesOLD.println;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static com.selenium.environment.MyDriverManager.*;
/**
 * Created by Iain Mounsey-Smith on 17/11/2015.
 */
public class ProcessedFormPageObject {

    public static WebDriverWait wait;
    //public static WebDriver aDriver;
    WebElement valueLanaguage;
    //public WebElement valueLanaguage;
    public ProcessedFormPageObject(WebDriver adriver) {
        aDriver=adriver;
        wait=new WebDriverWait(aDriver,10,10);
            }

    public Integer waitUntilPageIsLoaded() {

        WebElement valueLanaguage = wait.until(presenceOfElementLocated(By.cssSelector("[id='_valuelanguage_id']")));
        println("The waitUntilPageIsLoaded getText valuelanguage_id is " + valueLanaguage.getText());
        //assertThat("The correct getText is '23'", valueLanaguage.getText(), is("23"));
        return Integer.valueOf(valueLanaguage.getText()); //1 assert on ProcessedFormPage.valueLanaguage.getText() directly
    }


    public void getWaitAndGetValueForAssert() {

    }
}
