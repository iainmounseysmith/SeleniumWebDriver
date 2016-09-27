package com.jUnit;

import com.selenium.PageObjects.refactorExampleOne.OriginalCodeRefactoredTest;

//import static com.selenium.environment.DriverManagerTest.*;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Iain Mounsey-Smith on 24/11/2015.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({//we separate classes with a comma
       exampleGitBasedTests.class
        })

public class SuiteTest {
        public static void TestSuitesuite() {
                        }
}
