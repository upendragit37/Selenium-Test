package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="src/test/java/features/CreateLead.feature", glue="step", monochrome=true/*, dryRun=true, snippets= SnippetType.CAMELCASE*/)
public class Runstep extends AbstractTestNGCucumberTests{

}
