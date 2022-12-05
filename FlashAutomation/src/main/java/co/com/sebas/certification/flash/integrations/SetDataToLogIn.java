package co.com.sebas.certification.flash.integrations;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;


import static co.com.sebas.certification.flash.userinterfaces.HomePage.*;

public class SetDataToLogIn implements Task {

    private String user;
    private String password;

    public SetDataToLogIn(String user, String password) {
        this.user = user;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("Clase: SetDataToLogIn\nuser: "+ user+"\nPassword: "+password);
        actor.attemptsTo(
                Click.on(LOG_IN_BUTTON),
                Click.on(MY_ACCOUNT_BUTTON),
                Enter.theValue(user).into(USER_FIELD),
                Enter.theValue(password).into(PASSWORD_FIELD),
                Click.on(SUBMIT_BUTTON)

        );
    }

    public static SetDataToLogIn setData(String user, String password){
        return Tasks.instrumented(SetDataToLogIn.class, user,password);
    }
}
