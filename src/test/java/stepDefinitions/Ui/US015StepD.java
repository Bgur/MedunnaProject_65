package stepDefinitions.Ui;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.US015page;
import pages.US010page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class US015StepD {

    US015page Us015page=new US015page();
    pages.US010page US010page=new US010page();
    Actions actions=new Actions(Driver.getDriver());
    Faker faker=new Faker();
    Select select;

    @Given("Admin medunnaUrl sayfasina gider")
    public void admin_medunna_url_sayfasina_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("medunna_url"));

    }
    @When("Admin medunna anasayfasinin sag ust kosesindeki kullanici ikonuna tiklar")
    public void admin_medunna_anasayfasinin_sag_ust_kosesindeki_kullanici_ikonuna_tiklar() {
        US010page.KullaniciIkonu.click();

    }
    @When("Admin kullanici ikonu altinda yer alan sign in butonuna tiklar")
    public void admin_kullanici_ikonu_altinda_yer_alan_sign_in_butonuna_tiklar() {
        US010page.singIn.click();

    }
    @When("Admin username alanina gecerli {string} girer")
    public void admin_username_alanina_gecerli_girer(String string) {
        US010page.singInUsernameTextBox.sendKeys(ConfigReader.getProperty("AdminUsername"));

    }
    @When("Admin password alanina gecerli {string} girer")
    public void admin_password_alanina_gecerli_girer(String string) {
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("AdminPassword")).perform();

    }
    @When("Admin Sign in butonuna tiklar")
    public void admin_sign_in_butonuna_tiklar() {
        US010page.singInButonu.click();

    }
    @When("Admin acilan anasayfada Items&Titles ikonuna tiklar")
    public void admin_acilan_anasayfada_items_titles_ikonuna_tiklar() {

        ReusableMethods.waitFor(2);
        Us015page.items_titles.click();


    }
    @When("Admin Items&Titles ikonu altinda yer alan Patient bolumune tiklar")
    public void admin_items_titles_ikonu_altinda_yer_alan_patient_bolumune_tiklar() {
        Us015page.Patient.click();

    }
    @When("Admin acilan sayfada create a new Patient butonuna tiklar")
    public void admin_acilan_sayfada_create_a_new_patient_butonuna_tiklar() {
        Us015page.createAnewPatientButton.click();

    }

    @When("Admin first name alanina {string} girer")
    public void admin_first_name_alanina_girer(String string) {
        Us015page.patientFirstName.sendKeys(faker.name().firstName());

    }

    @When("Admin last name alanina {string} girer")
    public void admin_last_name_alanina_girer(String string) {
        Us015page.patientLastName.sendKeys(faker.name().lastName());

    }

    @When("Admin Birth date alanina  {string} girer")
    public void admin_birth_date_alanina_girer(String string) {
        LocalDate localDate=LocalDate.now();
        LocalDate duzenlenmisLocalDate = localDate.minusDays(10).minusMonths(3).minusYears(30);
        DateTimeFormatter duzenliDateStart = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String checkInDate = duzenlenmisLocalDate.format(duzenliDateStart);
        Us015page.patientBirthDay.sendKeys(checkInDate);
    }

    @When("Admin Email alanina  {string} girer")
    public void admin_email_alanina_girer(String string) {
        Us015page.patientEmail.sendKeys(faker.internet().emailAddress());
    }

    @When("Admin Phone alanina hastanin telefon numarasini girer")
    public void admin_phone_alanina_hastanin_telefon_numarasini_girer() {
        Us015page.patientPhoneNumber.sendKeys("1234567890");

    }

    @When("Admin Gender alanina {string} secer")
    public void admin_gender_alanina_secer(String string) {

        select=new Select(Us015page.patientGender);
        select.selectByValue("MALE");

    }

    @When("Admin Blood Group alanina {string} secer")
    public void admin_blood_group_alanina_secer(String string) {
        ReusableMethods.waitFor(2);
        select=new Select(Us015page.patientBloodGroup);
        select.selectByVisibleText("AB+");

    }

    @When("Admin Address alanina {string} girer")
    public void admin_address_alanina_girer(String string) {
        Us015page.patientAdress.sendKeys(faker.address().fullAddress());

    }
    @When("Admin Description alanini doldurur")
    public void admin_description_alanini_doldurur() {
        Us015page.descriptionTextBox.sendKeys("Bas agrisi, mide bulantisi");

    }

    @When("Admin user alanina  kullanici secer")
    public void admin_user_alanina_kullanici_secer() {
        select=new Select(Us015page.patientUser);
        select.selectByVisibleText("staff");

    }

    @When("Admin Country alanina hastanin ulkesini secer")
    public void admin_country_alanina_hastanin_ulkesini_secer() {
        select=new Select(Us015page.patientCountry);
        select.selectByVisibleText("Germany");
    }

    @And("Admin State-City alanina hastanin yasadigi sehri secer")
    public void adminStateCityAlaninaHastaninYasadigiSehriSecer() {
        Us015page.patientState.click();
    }


    @When("Admin Save butonuna tiklar")
    public void admin_save_butonuna_tiklar() {
        Us015page.saveButonu.click();
    }

    @When("Admin A new Patient is created mesajini gorur")
    public void admin_a_new_patient_is_created_mesajini_gorur() {
        ReusableMethods.waitFor(2);
        String expectedText="A new Patient is created";
        String actualText=Us015page.patientKayitOlusturuldu.getText();
        Assert.assertTrue(actualText.contains(expectedText));
        System.out.println("alert yazisi :"+ Us015page.patientKayitOlusturuldu.getText());
    }

    @When("Admin sayfayi kapatir")
    public void admin_sayfayi_kapatir() {
        ReusableMethods.waitFor(1);
        Driver.closeDriver();


    }


}
