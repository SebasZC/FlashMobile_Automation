package co.com.sebas.certification.flash.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class UserPage {
    public static final Target FIELD_NUMBER = Target.the("field of the telephone number")
            .located(By.xpath("//*[@class='number']"));

    public static final Target FIELD_PLANE = Target.the("field of the plane name")
            .located(By.xpath("//*[@class='plan-name']"));

    public static final Target PRICE_PLANE = Target.the("field of the plane price")
            .located(By.xpath("(//*[@class='value'])[1]"));
}
