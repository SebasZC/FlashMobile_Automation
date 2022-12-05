package co.com.sebas.certification.flash.tasks;

import co.com.sebas.certification.flash.integrations.SetDataToLogIn;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class LogInFlash implements Task {

    private String user;
    private String password;

    public LogInFlash(String user, String password) {
        this.user = user;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("Clase: LogInFlash\nuser: "+ user+"\nPassword: "+password);
        actor.attemptsTo(SetDataToLogIn.setData(user,password));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static LogInFlash logIn(String user, String password){
        return Tasks.instrumented(LogInFlash.class, user, password);
    }

}
