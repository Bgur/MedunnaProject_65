package stepDefinitions.Ui;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pages.US007page;
import pages.US025page;

import pojos.US25_appointment;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.WriteToTxt;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class US025StepD {

    US025page us25_pages=new US025page();
    Actions actions=new Actions(Driver.getDriver());
    Faker faker=new Faker();
    US25_appointment us25Appointment=new US25_appointment();
    US007page us07_pages=new US007page();

    LocalDate localDate;
    String guncelTarih;

    @Given("Patient URL sayfasina gider")
    public void patient_url_sayfasina_gider() {

        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));

    }
    @Given("Patient insan ikonuna tiklar")
    public void patient_insan_ikonuna_tiklar() {

        us25_pages.insanIkonuElementi.click();

    }
    @Given("Patient   sign in sekmesine tiklar")
    public void patient_sign_in_sekmesine_tiklar() throws InterruptedException {
        Thread.sleep(1000);
        us25_pages.signinSekmesiElementi.click();

    }
    @Then("Patient login olur")
    public void patient_username_girer() {


            Driver.wait(2);
            us07_pages.login("potilasoglu", "Abc123.");

    }
    @Then("Patient Password girer.")
    public void patient_password_girer() throws InterruptedException {
        Thread.sleep(1000);

        us25_pages.PasswordTextBox.click();
        actions.sendKeys(ConfigReader.getProperty("us24password")).perform();

    }
    @Then("Patient  signin butonuna tiklar")
    public void patient_signin_butonuna_tiklar() {
        us25_pages.signinBotunuElementi.click();

    }
    @Then("Patient giris yapilabiligini dogrular")
    public void patient_giris_yapilabiligini_dogrular()  {

        Driver.waitForVisibility(us25_pages.girisYapilabildiYazisi,2);
        Assert.assertTrue(us25_pages.girisYapilabildiYazisi.isDisplayed());

    }
    @Then("Patient My pages'e tiklar")
    public void patient_my_pages_e_tiklar() throws InterruptedException {
        Thread.sleep(1000);

        us25_pages.MypagesSekmesiElementi.click();

    }
    @And("Patient Make an Appointment tiklar")
    public void patientMakeAnAppointmentTiklar() throws InterruptedException {


        us25_pages.makeanAppointmentElementi.click();
    }
    @Then("Patient acilan sayfada bilgileri doldurur")
    public void patient_acilan_sayfada_bilgileri_doldurur() throws InterruptedException {


        us25_pages.firstnameTextbox.click();
        us25_pages.firstnameTextbox.clear();
        us25_pages.firstnameTextbox.click();
        actions.sendKeys(faker.name().firstName()+ Keys.TAB)
                .sendKeys(faker.internet().password()+Keys.TAB)
                .sendKeys(faker.idNumber().ssnValid()+Keys.TAB)
                .sendKeys(faker.internet().emailAddress()+Keys.TAB)
                .sendKeys("455-455-4555"+Keys.TAB)
                .sendKeys("30.08.2024"+Keys.TAB).perform();
    }
    @Then("Patient  Send an Appointment Request tiklar")
    public void patient_send_an_appointment_request_tiklar() {
        //  WriteToTxt.saveAppointmentDatalar(us25Appointment);
        us25_pages.SendanAppointmentRequestElementi.click();

    }
    @Then("Patient randevu aldigini dogrular")
    public void patient_randevu_aldigini_dogrular() throws InterruptedException, IOException {
        Driver.wait(2);
        ReusableMethods.getScreenshot("randevuAlindiYazisi");
        us25_pages.randevualindiYazisi.isDisplayed();

    }

    @Given("Patient acilan sayfada Make an Appointment tiklar")
    public void patient_acilan_sayfada_make_an_appointment_tiklar() {

        Driver.waitAndClick(us25_pages.makeanappointmentElementi);

    }


    @Then("Patient  firstname girer {string}")
    public void patientFirstnameGirer(String firstname) throws InterruptedException {
        //  firstname=faker.name().firstName();
        us25Appointment.setFirstname(firstname);
        Thread.sleep(1000);
        us25_pages.firstnameTextbox.click();
        actions.sendKeys(firstname+Keys.TAB).perform();

    }


    @Then("Patient  lastname girer  {string}")
    public void patientLastnameGirer(String lastname) {

        // lastname=faker.name().lastName();
        us25Appointment.setLastname(lastname);

        actions.sendKeys(lastname+Keys.TAB).perform();


    }

    @Then("Patient ssn girer  {string}")
    public void patientSsnGirer(String Ssn) {
        //  Ssn=faker.idNumber().ssnValid();
        us25Appointment.setSsn(Ssn);
        actions.sendKeys(Ssn+Keys.TAB).perform();


    }

    @Then("Patient  email girer  {string}")
    public void patientEmailGirer(String email) {
        email=faker.internet().emailAddress();
        us25Appointment.setEmail(email);
        actions.sendKeys(email+Keys.TAB).perform();


    }

    @Then("Patient phone girer {string}")
    public void patientPhoneGirer(String phone) {
        // phone=faker.phoneNumber().phoneNumber();burda yanlis giriyor
        us25Appointment.setPhone(phone);
        actions.sendKeys(phone+Keys.TAB).perform();

    }

    @Then("Patient Appointment DateTime girer {string}")
    public void patientAppointmentDateTimeGirer(String DateTime)  {

        us25Appointment.setDateTime(DateTime);
        actions.sendKeys(DateTime+Keys.TAB).perform();


    }

    @Then("Patient girilen tarihle sistem tarihi ayni olmali")
    public void patientGirilenTarihleSistemTarihiAyniOlmali() {

        String dateTimeText= us25_pages.DateTimeBox.getAttribute("value");
        localDate = LocalDate.now();
        guncelTarih = "" + localDate ;
        System.out.println(dateTimeText);
        System.out.println( localDate);
        // Assert.assertTrue(dateTimeText.equals(guncelTarih));
    }






    @Then("Patient Tarih sirasi gun.ay.yil \\(ay.gun.yil) seklinde olmalidir")
    public void patientTarihSirasiGunAyYilAyGunYilSeklindeOlmalidir() throws InterruptedException {

        DateTimeFormatter duzenle = DateTimeFormatter.ofPattern("dd.MM.YYYY");
        localDate= LocalDate.now();
        guncelTarih=duzenle.format(localDate);
        //  System.out.println("guncelTarih = " + guncelTarih);
        //  us25Appointment.setDateTime(guncelTarih);

        actions.sendKeys(guncelTarih).perform();


    }

/*
       String actualFormatliTarih=us25_pages.DateTimeBox.getText();

        System.out.println("actualFormatliTarih = " + actualFormatliTarih);

       String expectedFormatliTarih="2022-04-26";

    // Assert.assertEquals(expectedFormatliTarih,actualFormatliTarih);

 */


    @And("Patient  Send an Appointment Request elementine tiklar")
    public void patientSendAnAppointmentRequestElementineTiklar() throws InterruptedException {


        WriteToTxt.saveAppointmentDatalar(us25Appointment);

        Driver.waitAndClick(us25_pages.SendanAppointmentRequestElementi);


    }


    @Then("Patient randevu alabildigini dogrular")
    public void patientRandevuAlabildiginiDogrular() throws InterruptedException, IOException, IOException {

        Thread.sleep(1000);
        ReusableMethods.getScreenshot("Kayit Yazisi elementi");
        Assert.assertTrue(us25_pages.kayitYapildiYazisi.isDisplayed());

    }

    @Then("Sayfayi kapatir")
    public void sayfayiKapatir() {
        Driver.closeDriver();
    }
}
