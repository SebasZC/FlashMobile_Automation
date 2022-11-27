package co.com.sebas.certification.flash.stepdefinitions;


import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import static co.com.sebas.certification.flash.utils.Constants.FLASH_MOBILE_URL;

public class PlanRenovationStepDefinitions {

    public final Actor customer = Actor.named("User");

    @Managed
    private WebDriver driver;

    @Before
    public void setUp(){
        OnStage.setTheStage(Cast.whereEveryoneCan(BrowseTheWeb.with(driver)));
        OnStage.theActorCalled("User");
    }

    @Given("the user is in the main page")
    public void theUserIsInTheMainPage() {
        customer.wasAbleTo(Open.url(FLASH_MOBILE_URL));
    }

    @When("^the user log in in your account with (.*) and (.*)$")
    public void theUserLogInInYourAccountWithSebas001AndCc1007689094() {

    }
    @Then("^the user will see your current plan (.*)$")
    public void theUserWillSeeYourCurrentPlanPowerFlash() {

    }

}
