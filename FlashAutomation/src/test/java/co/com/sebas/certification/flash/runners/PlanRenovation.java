package co.com.sebas.certification.flash.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src\\test\\resources\\features\\plan_renovation.feature",
        glue = "co.com.sebas.certification.flash.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "", publish = true)
public class PlanRenovation {
}
