package stepDefinitions.Ui;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import pages.US028page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class US028StepD {
    US028page uS028=new US028page();
    SoftAssert softAssert=new SoftAssert();
    List<String> silinmekIstenenUlkeIsmi = new ArrayList<>();

    @Given("Kullanici ilgili test sayfasina gider")
    public void kullanici_ilgili_test_sayfasina_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("medunna_url"));

    }

    @Then("Kullanici humain giris butonuna basar ve Sing In butonunu tiklar")
    public void kullanici_humain_giris_butonuna_basar_ve_sing_in_butonunu_tiklar() {
        uS028.humanButton.click();
        uS028.SingInMenuButton.click();

    }

    @Then("Kullanici gecerli username ve password girer")
    public void kullanici_gecerli_username_ve_password_girer() {
        uS028.SingInUserNameKutusu.sendKeys("Team65");
        uS028.SingInPasswordKutusu.sendKeys("Team65.");

    }

    @Then("Kullanici basarili giris yapar")
    public void kullanici_basarili_giris_yapar() {
        uS028.SingInSingInButton.click();

    }


    @Given("Kullanici Items&Titles butonunu tiklar ve Country secer")
    public void kullanici_items_titles_butonunu_tiklar_ve_country_secer() {
        Driver.waitAndClick(uS028.itemsTitlesButonu);
        ReusableMethods.waitFor(3);
        uS028.countryButonu.click();

    }

    @Given("Kullanici Create a new Country butonunu tiklar")
    public void kullanici_create_a_new_country_butonunu_tiklar() {
        uS028.createCountryButonu.click();

    }

    @Then("Kullanici gecerli ulke ismini yazar")
    public void kullanici_gecerli_ulke_ismini_yazar() {
        uS028.createCountryNameButonu.sendKeys("yeniulke");

    }

    @Then("Kullanici tarih ve saat girer.")
    public void kullanici_tarih_ve_saat_girer() {
        LocalDateTime tarihSaat = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.YYYY");
        DateTimeFormatter formatterSaat = DateTimeFormatter.ofPattern("hh:mm a");
        uS028.tarihSaatButonu.sendKeys(formatter.format(tarihSaat), formatterSaat.format(tarihSaat));


    }

    @Then("Kullanici Save butonunu tiklar")
    public void kullanici_save_butonunu_tiklar() {
        uS028.saveButonu.sendKeys(Keys.ENTER);

    }

    @Then("Create a new Country butonunu gorur")
    public void create_a_new_country_butonunu_gorur() {
        ReusableMethods.waitFor(3);
        Assert.assertTrue(uS028.createCountryButonu.isDisplayed());

    }



   //





    @Given("Kullanici Items&Titles butonunu tiklar")
    public void kullanici_items_titles_butonunu_tiklar() {
        Driver.waitAndClick(uS028.itemsTitlesButonu);
        ReusableMethods.waitFor(1);
    }

    @Given("Kullanici State City butonunu secer")
    public void kullanici_state_city_butonunu_secer() {
        uS028.stateCityButonu.click();
        ReusableMethods.waitFor(1);
    }

    @Given("Kullanici Create a new State City butonunu tiklar")
    public void kullanici_create_a_new_state_city_butonunu_tiklar() {
        uS028.createStateCityButonu.click();
        ReusableMethods.waitFor(1);

    }

    @Given("Kullanici gecerli eyalet sehir ismini yazar")
    public void kullanici_gecerli_eyalet_sehir_ismini_yazar() {
        uS028.createStateCityNameButonu.sendKeys("yenisehir");
        ReusableMethods.waitFor(1);

    }


    @Then("Kullanici gecerli ulke ismini secer")
    public void kullanici_gecerli_ulke_ismini_secer() {
        Driver.selectAnItemFromDropdown(uS028.stateCitySecmeButonu, "yeniulke");


    }



    @Then("Kirmizi uyari yazisini goruyorsa kayit yapilmadi uyari yazisini alir")
    public void kirmizi_uyari_yazisini_goruyorsa_kayit_yapilmadi_uyari_yazisini_alir() {

        ReusableMethods.waitFor(3);
        String expectedText = "Field translation-not-found[hospitalmsappfrontendApp.CState.country] cannot be empty!";
        String actualText = uS028.kirmiziUyariYazisi.getText();
        softAssert.assertTrue(actualText.contains(expectedText));
        softAssert.assertAll();
        System.out.println("Sehir kaydedilemedi");


    }




   //



    @Given("Kullanici sectigi ulkenin delete butonuna tiklar")
    public void kullanici_sectigi_ulkenin_delete_butonuna_tiklar() {

        ReusableMethods.waitFor(1);
        silinmekIstenenUlkeIsmi.add("yeniulke");

        List<String> sutundakiTumUlkeler = new ArrayList<>();
        for (WebElement each : uS028.tumUlkeIsimleri
        ) {
            sutundakiTumUlkeler.add(each.getText());

        }
        System.out.println(sutundakiTumUlkeler);
        ReusableMethods.waitFor(5);
        for (int i = 0; i < silinmekIstenenUlkeIsmi.size(); i++) {
            Assert.assertTrue(sutundakiTumUlkeler.contains(silinmekIstenenUlkeIsmi.get(i)));
            ReusableMethods.hooverByJS(uS028.deleteButonu);

        }



    }


    @Given("Kullanici Confirm delete operation ekranini gorur ve delete i tiklar")
    public void kullanici_confirm_delete_operation_ekranini_gorur_ve_delete_i_tiklar() {

        ReusableMethods.waitFor(1);
        Assert.assertTrue(uS028.deleteOperationYazisi.isDisplayed());
        ReusableMethods.waitFor(1);
        uS028.ikiciDeleteButonu.click();


    }






}
