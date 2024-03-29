package co.com.sebas.certification.flash.stepdefinitions;


import co.com.sebas.certification.flash.integrations.SendWhatsappMessage;
import co.com.sebas.certification.flash.questions.ValidatePlan;
import co.com.sebas.certification.flash.questions.ValidateTelephoneNumber;
import co.com.sebas.certification.flash.tasks.LogInFlash;
import co.com.sebas.certification.flash.utils.Checkeo;
import co.com.sebas.certification.flash.tasks.LoginBemovil;
import co.com.sebas.certification.flash.tasks.RechargeToPhone;
import co.com.sebas.certification.flash.utils.CSVReader;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

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
        OnStage.theActorInTheSpotlight().wasAbleTo(Open.url(FLASH_MOBILE_URL));
    }

    @When("^the user log in in your account with its credentials$")
    public void theUserLogInInYourAccountWithItsCredentials() {
        OnStage.theActorInTheSpotlight().attemptsTo(LogInFlash.logIn(1));
    }
    @Then("^the user will see your current plan (.*)$")
    public void theUserWillSeeYourCurrentPlanPowerFlash(String plane) {
        System.out.println("Entró al THEN");
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidatePlan.validatePlan(), Matchers.equalTo(plane)));
    }

    @And("^the user will see your correct telephone number (.*)$")
    public void theUserWillSeeYourCorrectTelephoneNumber(String telephoneNumber) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateTelephoneNumber.validateTelephoneNumber(telephoneNumber), Matchers.equalTo(telephoneNumber)));
    }

    @And("the user is notified")
    public void theUserIsNotified() {
        OnStage.theActorInTheSpotlight().attemptsTo(SendWhatsappMessage.sendWhatsappMessage("Sebas"));
    }

    @And("the user is in the main page to whatsapp")
    public void theUserIsInTheMainPageToWhatsapp() {
        OnStage.theActorInTheSpotlight().wasAbleTo(Open.url("https://web.whatsapp.com/send/?phone=573505082088&text=Hola *Sebas* bien?"));
        OnStage.theActorInTheSpotlight().attemptsTo(SendWhatsappMessage.sendWhatsappMessage(""));
    }

    @Given("the user in on bemovil page")
    public void theUserInOnBemovilPage() {
        OnStage.theActorInTheSpotlight().wasAbleTo(Open.url("https://sirse.bemovil.net/login/"));
    }

    @When("^the user make login to the platform with (.*) and (.*)$")
    public void theUserMakeLoginToThePlatformWithUserAndPassword(String user, String password) {
        OnStage.theActorInTheSpotlight().attemptsTo(LoginBemovil.login(user, password));
    }
    @When("^the user make a recharge to (.*) with (.*)$")
    public void theUserMakeARechargeTo(String telephone, String amount) {
        OnStage.theActorInTheSpotlight().attemptsTo(RechargeToPhone.recharge(telephone,amount));
    }
    @Then("the user will see success message")
    public void theUserWillSeeSuccessMessage() {

    }


    @And("validation amount available")
    public void validationAmountAvailable() {

    }

    @Given("the user reads data")
    public void theUserReadsData() {
        CSVReader.readData(2);
    }
}
