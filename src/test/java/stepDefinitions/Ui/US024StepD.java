package stepDefinitions.Ui;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.US009page;
import pages.US018page;
import pages.US024page;
import utilities.Driver;

public class US024StepD {
    US024page us024page=new US024page();
    US018page us018page = new US018page();
    US009page us009page=new US009page();
    Actions actions = new Actions(Driver.getDriver());
    Select select;
    Faker faker=new Faker();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    @Then("Kullanici username ve password girer")
    public void kullanici_username_ve_password_girer() {
        us024page.userName.sendKeys("SanerTaklaci");
        us024page.password.sendKeys("SanerTaklaci65.");
    }
    @Then("Kullanicisign in butonuna tiklar ve sign olur")
    public void kullanicisign_in_butonuna_tiklar_ve_sign_olur() {
        us024page.secondSignIn.click();
    }
    @Then("Kullanici My Pages butonunu tiklar")
    public void kullanici_my_pages_butonunu_tiklar() {
        Driver.waitAndClick(us024page.myPages);
    }
    @Then("Kullanici My Appointment butonunu tiklar")
    public void kullanici_my_appointment_butonunu_tiklar() {
        Driver.waitAndClick(us024page.myAppointments);
    }
    @Then("Testleri goruntule butonunu tiklar")
    public void testleri_goruntule_butonunu_tiklar() {
        Driver.waitAndClick(us024page.showTestButton);
    }
    @Then("Kullanici sonuclari gor butonunu tiklar")
    public void kullanici_sonuclari_gor_butonunu_tiklar() {
        Driver.waitAndClick(us024page.viewResultButton);
    }
    @Then("Id, name for test, max ve min value, test data ve description bolumleri gorulur")
    public void id_name_for_test_max_ve_min_value_test_data_ve_description_bolumleri_gorulur() {
        Assert.assertTrue(us024page.testResults.isDisplayed());

        /*
        Assert.assertTrue(us024page.idColumn.isDisplayed());
        Assert.assertTrue(us024page.nameColumn.isDisplayed());
        Assert.assertTrue(us024page.minValueColumn.isDisplayed());
        Assert.assertTrue(us024page.maxValueColumn.isDisplayed());
        Assert.assertTrue(us024page.descriptionColumn.isDisplayed());
         */

        Driver.closeDriver();
    }

    @Then("Kullanici shov Invoice butonuna tiklar")
    public void kullanici_shov_invoice_butonuna_tiklar() {
        Driver.waitAndClick(us024page.showInvoiceButton);
    }
    @Then("Kullanici faturayi gorur")
    public void kullanici_faturayi_gorur() {
        Assert.assertTrue(us024page.faturaTarihi.isDisplayed());

        Driver.closeDriver();
    }



}
