package stepDefinitions.Ui;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.US018page;
import utilities.Driver;

public class US018StepD {

    US018page us018page = new US018page();
    Actions actions = new Actions(Driver.getDriver());
    Select select;
    Faker faker=new Faker();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    static String alinacakIdStr;













}