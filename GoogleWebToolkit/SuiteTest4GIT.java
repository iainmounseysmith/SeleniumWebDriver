package com.selenium.GoogleWebToolkit;

import com.selenium.PageObjects.refactorExampleOne.OriginalCodeRefactoredTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import com.selenium.GoogleWebToolkit.*;
/**
 * Created by Iain Mounsey-Smith on 29/09/2016.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({//we separate classes with a comma
        exampleGitBasedTests.class
})
public class SuiteTest4GIT {
}
