package co.com.sebas.certification.flash.utils;

import co.com.sebas.certification.flash.tasks.LogInFlash;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class Checkeo {

    public static void startProccess(){
        LogInFlash.logIn(1);
    }
}
