package co.com.sebas.certification.flash.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.sebas.certification.flash.userinterfaces.Bemovil.HomePage.*;

public class LoginBemovil implements Task {
    private String user;
    private String password;

    public LoginBemovil(String user, String password) {
        this.user = user;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Tiempo agotado");
        actor.attemptsTo(
                Enter.theValue(user).into(USER_NAME),
                Click.on(NEXT),
                Enter.theValue(password).into(USER_PASSWORD),
                Click.on(NEXT)
        );
    }

    public static LoginBemovil login(String user, String password){
        return new LoginBemovil(user, password);
    }
}
