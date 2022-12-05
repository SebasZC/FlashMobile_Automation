package co.com.sebas.certification.flash.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sebas.certification.flash.userinterfaces.UserPage.FIELD_PLANE;

public class ValidatePlan implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        System.out.println("Entró a ValidatePlan");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Plan-name: " + FIELD_PLANE.resolveFor(actor).getText());
        return FIELD_PLANE.resolveFor(actor).getText();
    }
    public static ValidatePlan validatePlan(){
        return new ValidatePlan();
    }
}
