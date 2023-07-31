package co.com.sebas.certification.flash.integrations;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import java.util.Set;

public class SwicthPage implements Task {
    private String page;

    public SwicthPage(String page) {
        this.page = page;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<String> webTabs = BrowseTheWeb.as(actor).getDriver().getWindowHandles();
        for (String tab : webTabs){
            BrowseTheWeb.as(actor).getDriver().switchTo().window(tab);
            if(tab.equals(page)){
                break;
            }
        }
    }
    public static SwicthPage switchPage(String page){
        return Tasks.instrumented(SwicthPage.class, page);
    }
}
