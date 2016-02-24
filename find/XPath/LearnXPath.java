package com.selenium.find.XPath;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.selenium.environment.EnvironmentUnderTest.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by Iain Mounsey-Smith on 13/10/2015.
 */
public class LearnXPath {
    private static WebDriver driver;//create variable Adriver of type Webdriver...must be static as accessed in beforeclass
    private static String myurl = "url here";
    final private String PROTOCOL="http:";
    final private String DOMAIN = "www.compendiumdev.co.uk/";
    final private String ROOT_URL = PROTOCOL + "//" + DOMAIN;
    final private String A = "AssertThat ";
    WebElement element;

    @BeforeClass
    public static void setupDriver() {
        driver = new FirefoxDriver();
       driver.navigate().to(getUrl("basicInteraction"));//gets url from methgod in environmentUnderTest class - see imports
        //Adriver.navigate().to("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");/
    }
@Test
//note that webelement object is initialised at top of class
//xpath = //div/p[(@name="pName31")]
public void compareById(){
    //by id
    element=driver.findElement(By.id("p31"));
    assertThat(element.getAttribute("name"), is("pName31"));
    System.out.println("element.getAttribute(\"name\") gives " + element.getAttribute("name"));
    //by xpath equivalent
    element=driver.findElement(By.xpath("//div/p[(@id=\"p31\")]"));//could have also used //div/*[(@id="p31")]
    assertThat(A+"element.getAttribute(\"name\"),is(\"pName31\")",element.getAttribute("name"),is("pName31"));
    System.out.println("By.xpath(\"//div/p[(@id=\\\"p31\\\")]\") gives " + element.getAttribute("name"));
}
    @Test
    //xpath=//div/ul[(@name="ulName1")]
    public void findByName(){
        //by name
        element=driver.findElement(By.name("ulName1"));
        assertThat(element.getAttribute("id"), is("ul1"));
        System.out.println("element.getAttribute(\"id\") gives " + element.getAttribute("id"));
        //by xpath equivalent
        element=driver.findElement(By.xpath("//div/ul[(@name=\"ulName1\")]"));//could have also used //*[(@name="ulName1")] OR ///ul[(@name="ulName1")]
        assertThat(A + "element.getAttribute(\"id\"),is(\"ul1\")", element.getAttribute("id"), is("ul1"));
        System.out.println("By.xpath(\"//div/ul[(@name=\\\"ulName1\\\")]\") gives " + element.getAttribute("id"));

        //using function
        element=driver.findElement(By.xpath("//*[starts-with (@name,'ulName1' )and string-length(@name=7)]"));
        assertThat(A+"element.getAttribute(\"id\"),is(\"ul1\")",element.getAttribute("id"),is("ul1"));
        System.out.println("By.xpathwith function - id should be ul1 " + element.getAttribute("id"));
    }

    @Test
    //by classname
    //xpath=//div[(@class="specialDiv")]
    public void findbyClassname(){
        element=driver.findElement(By.className("specialDiv"));
        assertThat(A+"",element.getAttribute("id"),is("div1"));
        System.out.println("element.getAttribute(\"id\") gives " + element.getAttribute("id"));
        element = driver.findElement(By.xpath("//div[(@class=\"specialDiv\")]"));//could also have used //*[(@class="specialDiv")]
        assertThat(A+"",element.getAttribute("id"),is("div1"));
        System.out.println("By.xpath(\"//div[(@class=\\\"specialDiv\\\")]\") gives " + element.getAttribute("id"));
    }
    @Test
    //xpath //*[(@name="liName1")]
    public void byTagname(){
        //by tagname
        element=driver.findElement(By.tagName("li"));
        assertThat(A + "", element.getAttribute("name"), is("liName1"));
        System.out.println("By.tagName(\"li\") " + element.getAttribute("name"));
        //by xpath
        element=driver.findElement(By.xpath("//*[(@name=\"liName1\")]"));
        assertThat(A+"",element.getAttribute("name"),is("liName1"));
        System.out.println("By.xpath(\"//*[(@name=\\\"liName1\\\")]\" " +element.getAttribute("name") );
    }
    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }
}
