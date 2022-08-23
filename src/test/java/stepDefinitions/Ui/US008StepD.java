package stepDefinitions.Ui;


import com.github.javafaker.Faker;
import io.cucumber.java.en.*;

import org.junit.Assert;

import org.openqa.selenium.interactions.Actions;


import org.testng.asserts.SoftAssert;

import pages.US008page;

import utilities.ConfigReader;
import utilities.Driver;
import utilities.RusableForUS008;


public class US008StepD {
    US008page MedunnaPage = new US008page();

    Faker faker = new Faker();
    Actions actions;
    SoftAssert softAssert = new SoftAssert();



    @Given("Kullanici siteye gider {string}")
    public void kullaniciSiteyeGider(String baseUrl) {
        Driver.getDriver().get(ConfigReader.getProperty(baseUrl));
        RusableForUS008.wait(3);

    }

    @When("Sayfaya gidildigi ana sayfadaki WELCOME TO MEDUNNA texti ile dogrulanir")
    public void sayfaya_gidildigi_ana_sayfadaki_welcome_to_medunna_texti_ile_dogrulanir() {
        Assert.assertTrue(MedunnaPage.anaSayfaWelcomeToMedunnaYazisi.isDisplayed());
    }

    @When("Kullanici sayfaya giris icin CONTACT linkinin saginda bulunan kullanici girisi linkine tiklar")
    public void kullanici_sayfaya_giris_icin_contact_linkinin_saginda_bulunan_kullanici_girisi_linkine_tiklar() {
        MedunnaPage.anaSayfaKullaniciIkonu.click();
    }

    @Then("Sign in sekmesine tiklar.")
    public void sign_in_sekmesine_tiklar() {

        RusableForUS008.waitAndClick(MedunnaPage.signInLinkiElementi);

    }

    @Then("Kullanici Username Box'a gecerli {string} girerr")
    public void kullanici_username_box_a_gecerli_girerr(String username) {

        MedunnaPage.homePageUsernameBox.click();
        MedunnaPage.homePageUsernameBox.sendKeys(ConfigReader.getProperty("username"));
    }

    @Then("Kullanici Sign in sekmesine tiklar.")
    public void kullanici_sign_in_sekmesine_tiklar() {
        MedunnaPage.homePageSignInLinki.click();
        RusableForUS008.wait(2);
    }


    @Then("Kullanici Password Box'a gecerli {string} girer.")
    public void kullanici_password_box_a_gecerli_girer(String SignInValidPassword) {
        MedunnaPage.homePagePasswordBox.sendKeys(ConfigReader.getProperty("SignInValidPassword"));
    }

    @Then("Kullanici Sign in butonuna tiklar.")
    public void kullanici_sign_in_butonuna_tiklar() {
        MedunnaPage.signInButonu.click();
    }


    @Then("Kullanici acilan menude password yazisina tiklar")
    public void kullanici_acilan_menude_password_yazisina_tiklar() {
        MedunnaPage.kullaniciIkonuMenusuAltindakiPasswordYazisi.click();
        RusableForUS008.wait(2);
    }

    @Then("Kullanici acilan sayfadaki Current password kutucuguna mevcut parolayi girer")
    public void kullanici_acilan_sayfadaki_current_password_kutucuguna_mevcut_parolayi_girer() {
        RusableForUS008.waitAndClick(MedunnaPage.passwordDegisikligiIcinGecerliPasswordBox, 1);
        MedunnaPage.passwordDegisikligiIcinGecerliPasswordBox.sendKeys(ConfigReader.getProperty("SignInValidPassword"));
        RusableForUS008.wait(2);
    }

    @Then("Kullanici new password kutucuguna yeni parolayi girer")
    public void kullanici_new_password_kutucuguna_yeni_parolayi_girer() {
        MedunnaPage.passwordDegisikligiIcinYeniPasswordbox.sendKeys(ConfigReader.getProperty("SigInNewPassword"));
        RusableForUS008.wait(2);
    }

    @Then("Kullanici Password strength seviyesinin degistigini gorur")
    public void kullaniciPasswordStrengthSeviyesininDegistiginiGorur() {
    }

    @Then("Kullanici new password confirmation kutucuguna yeni parolayi tekrar girer")
    public void kullanici_new_password_confirmation_kutucuguna_yeni_parolayi_tekrar_girer() {
        MedunnaPage.passwordDegisikligiIcinYeniPasswordConfirmBox.sendKeys(ConfigReader.getProperty("SigInNewPassword"));
    }

    @Then("Kullanici save butonuna tiklar")
    public void kullaniciSaveButonunaTiklar() {
        RusableForUS008.wait(2);
        RusableForUS008.clickWithJS(MedunnaPage.passwordDegisikligiIcinSaveButonu);
        RusableForUS008.wait(2);
    }


    @Then("Kullanici username box'a gecerli {string} girer.")
    public void kullaniciUsernameBoxAGecerliGirer(String username) {

        MedunnaPage.homePageUsernameBox.click();

        MedunnaPage.homePageUsernameBox.sendKeys(username);


    }

    @Then("Kullanici password box'a gecerli {string} girer.")
    public void kullaniciPasswordBoxAGecerliGirer(String password) {
        MedunnaPage.homePageUsernameBox.click();
        MedunnaPage.homePagePasswordBox.sendKeys(password);
    }


    @Then("Kullanici sayfa sag ustte isim ve soyisminin yer aldigi yaziya tiklar")
    public void kullanici_sayfa_sag_ustte_isim_ve_soyisminin_yer_aldigi_yaziya_tiklar() {
        MedunnaPage.kullaniciIkoniGirisYaptiktanSonra.click();
        RusableForUS008.wait(2);
    }


    @Then("Kullanici acilan sayfadaki Current password kutucuguna {string} girer")
    public void kullaniciAcilanSayfadakiCurrentPasswordKutucugunaGirer(String mevcutPassword) {
        MedunnaPage.passwordDegisikligiIcinGecerliPasswordBox.click();
        // Driver.clickWithJS( mp.passwordDegisikligiIcinGecerliPasswordBox);
        MedunnaPage.passwordDegisikligiIcinGecerliPasswordBox.sendKeys(mevcutPassword);
    }

    @Then("Kullanici new password kutucuguna {string} girer")
    public void kullaniciNewPasswordKutucugunaGirer(String yeniParola) {
        RusableForUS008.clickWithJS(MedunnaPage.passwordDegisikligiIcinYeniPasswordbox);
        MedunnaPage.passwordDegisikligiIcinYeniPasswordbox.sendKeys(yeniParola);
    }

    @Then("Kullanici new password confirmation kutucuguna {string} tekrar girer")
    public void kullaniciNewPasswordConfirmationKutucugunaTekrarGirer(String yeniParola) {
        RusableForUS008.clickWithJS(MedunnaPage.passwordDegisikligiIcinYeniPasswordConfirmBox);
        MedunnaPage.passwordDegisikligiIcinYeniPasswordConfirmBox.sendKeys(yeniParola);
    }

    @Then("Kullanici Password Box'a gecerli {string} girerr.")
    public void kullanici_password_box_a_gecerli_girerr(String password) {
        MedunnaPage.passwordBoxElementi.sendKeys(ConfigReader.getProperty("SignInValidPassword"));
    }

    @Then("Passwordun basarili bir sekilde degistigi gorulur")
    public void passwordun_basarili_bir_sekilde_degistigi_gorulur() {
        RusableForUS008.waitForVisibility(MedunnaPage.passwordDegisikligiBasariliYazisi, 1);
        Assert.assertTrue(MedunnaPage.passwordDegisikligiBasariliYazisi.isDisplayed());
    }


    @And("Kullanici acilan menuden signOut linkine tiklar")
    public void kullaniciAcilanMenudenSignOutLinkineTiklar() {
        MedunnaPage.signOutLinki.click();
    }


}
