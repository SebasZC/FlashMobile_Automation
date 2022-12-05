package co.com.sebas.certification.flash.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sebas.certification.flash.userinterfaces.UserPage.PRICE_PLANE;

public class ValidatePrice implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        return PRICE_PLANE.resolveFor(actor).getText();
    }
}
