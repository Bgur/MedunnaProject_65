package stepDefinitions.Ui;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;

import org.junit.Assert;

import pages.US007page;
import utilities.*;

import java.io.IOException;
import java.time.LocalDate;


public class US007StepD {

    US007page us07_pages = new US007page();
    public static Faker faker = new Faker();
    String firstname;
    String lastname;
    String ssn;
    String email;



    @Given("OS kullanici url'e gider")
    public void OSKullaniciUrlEGider() {
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
    }

    @Given("OS kullanici signIn olur")
    public void os_kullanici_sign_in_olur() {

        us07_pages.login("OSPatientUsername", "OSPatientPassword");
    }

    @Then("OS kullanici signIn isleminin barasili olarak gerceklestigini dogrular")
    public void OSKullaniciSignInIslemininBarasiliOlarakGerceklestiginiDogrular() {
        JSUtils.clickElementByJS(us07_pages.profileIcon);
        us07_pages.profileIcon.click();
        Assert.assertTrue(us07_pages.loginPageSignOutButton.isDisplayed());
    }

    @Then("OS kullanici My Pages Butonuna Tiklar ve Menu'den 'Make An Appointment' Secenegini Secer")
    public void OS_kullanici_my_pages_butonuna_tiklar_ve_menu_den_make_an_appointment_secenegini_secer() {
        JSUtils.clickElementByJS(us07_pages.myPagesButtonu);
        JSUtils.clickElementByJS(us07_pages.loginPageMakeAnAppointmentButtonu);
        String expectedAppointmentHeader = ConfigReader.getProperty("OSexpectedAppointmentHeader");
        Assert.assertEquals(expectedAppointmentHeader, us07_pages.loginPageMakeAnAppointmentHeader.getText());
    }

    @Then("OS kullanici phone textbox'ini valid bir deger ile doldurur")
    public void OS_kullanici_phone_textbox_ini_valid_bir_deger_ile_doldurur() {

       us07_pages.loginPagePhoneTextBox.sendKeys(ConfigReader.getProperty("OSValidPhoneNumber"));

    }

    @Then("OS kullanici date textbox'inda yer alan tarihin sistem tarihi ile ayni oldugunu dogrular")
    public void OS_kullanici_date_textbox_inda_yer_alan_tarihin_sistem_tarihi_ile_ayni_oldugunu_dogrular() {

        String dateTextboxValue = us07_pages.loginPageDateTextBox.getAttribute("value");
        LocalDate tarih = LocalDate.now();
        String sistemDateValue = "" + tarih;
//        System.out.println("sistem tarihi: "+sistemDateValue);
//        System.out.println("kutudaki tarih: "+dateTextboxValue);
        Assert.assertTrue(dateTextboxValue.equals(sistemDateValue));
    }


    @Then("OS kullanici Send an Appointment Request butonunu tiklar")
    public void OS_kullanici_send_an_appointment_request_butonunu_tiklar() {
        JSUtils.clickElementByJS(us07_pages.loginPageSendAnAppointmentRequestButton);
    }

    @Then("OS kullanici randevunun basarili bir sekilde kaydedildigini cikan popup ile dogrular")
    public void OS_kullanici_randevunun_basarili_bir_sekilde_kaydedildigini_cikan_popup_ile_dogrular() throws IOException {

        ReusableMethods.getScreenshotForUS007("gecerliTarih");
        String expectedAlertYazısı = ConfigReader.getProperty("OSBasariliAlertYazisi");
        Assert.assertEquals(expectedAlertYazısı, us07_pages.alertText.getAttribute("innerText"));
        us07_pages.logout();
    }

    @And("OS kullanici date textbox'ini gecmis bir tarih ile doldurur")
    public void OSKullaniciDateTextboxIniGecmisBirTarihIleDoldurur() {

        String date = ReusableMethods.setTheDateByRandom("dd-MM-yyy", 1, "past");
        us07_pages.loginPageDateTextBox.clear();
        us07_pages.loginPageDateTextBox.sendKeys(date);
    }


    @And("OS kullanici date textboxinin altinda Appointment date can not be past date! uyarisinin gorundugunu dogrular")
    public void OSKullaniciDateTextboxininAltindaAppointmentDateCanNotBePastDateUyarisininGorundugunuDogrular() {

        String expectedErrorText = ConfigReader.getProperty("OSDateExpectedError");
        Assert.assertEquals(expectedErrorText, us07_pages.loginPageDateErrorLine.getText());
    }

    @Then("OS kullanici Make an Appointment butonuna tiklar")
    public void OSKullaniciMakeAnAppointmentButonunaTiklar() {
        JSUtils.clickElementByJS(us07_pages.mainpageMakeAnAppointmentButtonu);
    }

    @And("OS kullanici Send an Appointment Request butonunu gorene kadar sayfayi kaydirir")
    public void OSKullaniciSendAnAppointmentRequestButonunuGoreneKadarSayfayiKaydirir() {
        JSUtils.scrollIntoVIewJS(us07_pages.mainpageSendAnAppointmentRequestButton);
    }

    @Given("OS kullanici First Name kutusunu doldurur")
    public void osKullaniciFirstNameKutusunuDoldurur() {

        firstname = faker.name().name();
        us07_pages.mainpageFirstnameTextBox.sendKeys(firstname);
    }

    @And("OS kullanici Last Name kutusunu doldurur")
    public void OSKullaniciLastNameKutusunuDoldurur() {
        lastname = faker.name().lastName();
        us07_pages.mainpageLastnameTextBox.sendKeys(lastname);
    }

    @And("OS kullanici SSN kutusunu doldurur")
    public void OSKullaniciSSNKutusunuDoldurur() {
        ssn = faker.idNumber().ssnValid();

        us07_pages.mainpageSSNTextBox.sendKeys(ssn);
    }

    @And("OS kullanici Email kutusunu valid bir deger ile doldurur")
    public void OSKullaniciEmailKutusunuValidBirDegerIleDoldurur() {
        email = faker.internet().emailAddress();
        us07_pages.mainpageEmailTextBox.sendKeys(email);
    }

    @Then("OS kullanici OS kullanici randevusunun olustugunu cikan popup ile dogrular")
    public void OSKullaniciOSKullaniciRandevusununOlustugunuCikanPopupIleDogrular() {
        String expectedAlertYazısı = ConfigReader.getProperty("OSBasariliAlertYazisi");
        Assert.assertEquals(expectedAlertYazısı, us07_pages.alertText.getAttribute("innerText"));
    }


    @Then("OS kullanici randevunun basarili bir sekilde kaydedilemedigini cikan popup ile dogrular")
    public void OS_kullanici_randevunun_basarili_bir_sekilde_kaydedilemedigini_cikan_popup_ile_dogrular() throws IOException {
        RusableForUS008.wait(2);
        String expectedAlertYazısı = ConfigReader.getProperty("OSBasariliAlertYazisi");
        RusableForUS008.wait(1);
        String kayitMesaji = us07_pages.alertText.getAttribute("innerText");
        ReusableMethods.getScreenshotForUS007("BugTarih");
        RusableForUS008.wait(1);
        Assert.assertFalse(kayitMesaji.contains(expectedAlertYazısı));

    }

    @Then("OS kullanici date textbox'ini valid bir deger ile doldurur ve Send An Appointment butonuna basar")
    public void OSKullaniciDateTextboxIniValidBirDegerIleDoldururVeSendAnAppointmentButonunaBasar() {
        String date = ReusableMethods.setTheDateByRandom("dd-MM-yyy", 1, "feature");
        us07_pages.loginPageDateTextBox.clear();
        us07_pages.loginPageDateTextBox.sendKeys(date);
        RusableForUS008.wait(3);
        JSUtils.clickElementByJS(us07_pages.loginPageSendAnAppointmentRequestButton);
    }

    @Then("OS kullanici date textbox'ini {string} ile doldurur ve date alaninda yazan tarihin ayni oldugunu dogrular")
    public void OSKullaniciDateTextboxIniIleDoldururVeDateAlanindaYazanTarihinAyniOldugunuDogrular(String date) {
        us07_pages.loginPageDateTextBox.sendKeys(date);// 01.01.2030
        System.out.println(date);
        date = ReusableMethods.stringDateFormat(date); // 2030-01-01  yıl ay gun
        System.out.println("date = " + date);
        System.out.println("us05_pages.loginPageDateTextBox.getAttribute(\"value\") = " + us07_pages.loginPageDateTextBox.getAttribute("value"));
        RusableForUS008.wait(5);
        Assert.assertEquals(date, us07_pages.loginPageDateTextBox.getAttribute("value"));

    }

    @Then("OS kullanici date textbox'ini {string} ile doldurur ve date alaninda yazan tarihin ayni olmadigini dogrular")
    public void OSKullaniciDateTextboxIniIleDoldururVeDateAlanindaYazanTarihinAyniOlmadiginiDogrular(String date) {
        us07_pages.loginPageDateTextBox.sendKeys(date);
        System.out.println(date);
        date = ReusableMethods.stringDateFormat(date);
        RusableForUS008.wait(5);
        Assert.assertFalse(date.contains(us07_pages.loginPageDateTextBox.getAttribute("value")));
    }

    @Given("OS kullanici signOut olur")
    public void OSKullaniciSignOutOlur() {
        us07_pages.logout();
    }
}


