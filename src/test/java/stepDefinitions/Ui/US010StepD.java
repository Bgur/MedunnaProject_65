package stepDefinitions.Ui;


import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.ConfigReader;
import io.cucumber.java.en.*;
import pages.US010page;
import utilities.Driver;
import utilities.ReusableMethods;


public class US010StepD {

    US010page us10Pages=new US010page();
    Actions actions;


    @Given("Doktor medunnaUrl sayfasina gider")
    public void doktor_medunna_url_sayfasina_gider() {
     Driver.getDriver().get(ConfigReader.getProperty("medunna_url"));

    }


    @When("Doktor sayfada sag ust kosedeki kullanici ikonuna tiklar")
    public void doktorSayfadaSagUstKosedekiKullaniciIkonunaTiklar() {
        us10Pages.KullaniciIkonu.click();

    }


    @Then("Doktor sayfada kullanici ikonu altinda yer alan sign in butonuna tiklar")
    public void doktor_sayfada_kullanici_ikonu_altinda_yer_alan_sign_in_butonuna_tiklar() {
        us10Pages.singIn.click();


    }
    @Then("Doktor username alanina gecerli {string} girer")
    public void doktor_username_alanina_gecerli_girer(String DoktorUsername) throws InterruptedException {
        us10Pages.singInUsernameTextBox.sendKeys(ConfigReader.getProperty(DoktorUsername));
        ReusableMethods.waitFor(1);

    }
    @Then("Doktor Password alanina gecerli {string} girer")
    public void doktor_password_alanina_gecerli_girer(String DoktorPassword) throws InterruptedException {
        ReusableMethods.waitFor(1);
        actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("DoktorPassword")).perform();

    }
    @Then("Doktor Sign in butonuna tiklar")
    public void doktor_sign_in_butonuna_tiklar() {
        us10Pages.singInButonu.click();

    }
    @And("Doktor MY PAGES ikonuna tiklar")
    public void doktorMYPAGESIkonunaTiklar() throws InterruptedException {
        ReusableMethods.waitFor(2);
        us10Pages.myPagesButonu.click();


    }

    @Then("Doktor sayfada MY PAGES ikonu altinda yer alan My Appointmeints bolumune tiklar")
    public void doktor_sayfada_my_pages_ikonu_altinda_yer_alan_my_appointmeints_bolumune_tiklar() {
        us10Pages.myAppointmentsButonu.click();

    }

    @Then("Doktor randevu listesi ve zaman dilimlerini gorur")
    public void doktor_randevu_listesi_ve_zaman_dilimlerini_gorur() {
        String actualText=us10Pages.apppointmentsPagesText.getText();
        String expectedText="Appointments";
        ReusableMethods.waitFor(1);
        Assert.assertEquals(expectedText,actualText);
        Assert.assertTrue(us10Pages.randevuID.isDisplayed());

    }

    @Then("Doktor patient id, start date, end date, status bilgilerini gorur")
    public void doktor_patient_id_start_date_end_date_status_bilgilerini_gorur() {
        ReusableMethods.waitFor(1);
        Assert.assertTrue(us10Pages.randevuID.isDisplayed());
        Assert.assertTrue(us10Pages.startDateTime.isDisplayed());
        Assert.assertTrue(us10Pages.endDateTime.isDisplayed());
        Assert.assertTrue(us10Pages.status.isDisplayed());


    }


    @And("Doktor sayfayi kapatir")
    public void doktorSayfayiKapatir() {

        ReusableMethods.waitFor(1);
        Driver.closeDriver();
    }
}
