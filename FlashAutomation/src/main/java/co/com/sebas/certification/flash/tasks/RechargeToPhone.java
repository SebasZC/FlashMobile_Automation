package co.com.sebas.certification.flash.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.HoverOverBy;

import static co.com.sebas.certification.flash.userinterfaces.Bemovil.HomePage.*;
import static co.com.sebas.certification.flash.userinterfaces.Bemovil.HomePage.AMOUNT;

public class RechargeToPhone implements Task {

    private String telephone;
    private String amount;

    public RechargeToPhone(String telephone, String amount) {
        this.telephone = telephone;
        this.amount = amount;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                HoverOverBy.over(MULTI_PRODUCT),
                Click.on(MULTI_PRODUCT_RECHARGE),
                Click.on(FLASH_RECHARGE),
                Enter.theValue(telephone).into(TELEPHONE_NUMBER_FLASH),
                Enter.theValue(amount).into(AMOUNT),
                Click.on(RECHARGE_BUTTON),
                Click.on(ACCEPT_RECHARGE)
        );
    }

    public static RechargeToPhone recharge(String telephone, String amount){
        return new RechargeToPhone(telephone,amount);
    }
}
