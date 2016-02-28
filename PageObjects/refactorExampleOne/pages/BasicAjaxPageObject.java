package com.selenium.PageObjects.refactorExampleOne.pages;
import com.selenium.pageFactory.MyPageFactory.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.selenium.helpers.HelperClassesOLD.println;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
//import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
//import java.util.NoSuchElementException;
//import java.util.concurrent.TimeoutException;
import static com.selenium.environment.MyDriverManager.*;

import static com.selenium.environment.EnvironmentUnderTest.*;

/**
 * Created by Iain Mounsey-Smith on 17/11/2015.
 */
public class BasicAjaxPageObject {
    public static WebDriverWait wait;
    public  WebDriver aDriver;
   public WebElement valueLanaguage;
    public WebElement clickme2;
    public WebElement clickme3;
    //public enum Category {}
    public BasicAjaxPageObject(WebDriver anydriver) {
        aDriver= anydriver;
        wait=new WebDriverWait(aDriver,5,10);
                   }

    public void selectCategory(int categoryValue) {
        WebElement multiSelect = aDriver.findElement(By.cssSelector("[id='combo1']")).findElement(By.cssSelector("[value='" + categoryValue + "']"));
        multiSelect.click();
        //wait.until(invisibilityOfElementLocated(By.id("ajaxBusy")));
        //new WebDriverWait(driver,10,10).until(waitForAjax());
        //wait.until(waitForAjax());
        println("category value is: " +categoryValue );
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("ajaxBusy")));
    }
    //this essentially does same thing as waitForAjax2
    public ExpectedCondition<Boolean> waitForAjax() {
        return invisibilityOfElementLocated(By.id("ajaxBusy"));
    }
    //this essentially does same thing as waitForAjax
    public void waitForAjax2() {
        wait.until(invisibilityOfElementLocated(By.id("ajaxBusy")));
    }
    public void waitForAjax3(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("ajaxBusy")));
    }
    public void clickCodeInItButton() {
        //wait = new WebDriverWait(driver, 10, 50);
        WebElement clickme = aDriver.findElement(By.cssSelector("input[ value='Code In It']"));
        clickme.click();

    }

    public static void waitForValueOption() {
        wait.until((elementToBeClickable(By.cssSelector("option[value='23']"))));
    }

    public void selectCombo2Language(Integer language) {
        //WebElement clickme2;elementToBeClickable
        println("language value is: " +language );
        try{ clickme2 = BasicAjaxPageObject.wait.until((presenceOfElementLocated(By.cssSelector("option[value='" + language + "']"))));
        }
        catch(TimeoutException exc)
        {clickme2 = wait.until(presenceOfElementLocated(By.xpath("//select[@id=\"combo2\"]/option[1]")));}
finally {
            clickme2.click();
            System.out.println();
        }


    }
}