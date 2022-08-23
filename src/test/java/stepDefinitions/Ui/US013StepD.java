package stepDefinitions.Ui;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.US013page;
import utilities.ConfigReader;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class US013StepD {

    US013page US013page=new US013page();

    @Given("Doktor  sign in sekmesini secer")
    public void doktor_sign_in_sekmesini_secer() {
        US013page.singInButtonu.click();
    }

    @Given("Doktor acilan sayfada Username bolumune kullanici adini girer")
    public void doktor_acilan_sayfada_username_bolumune_kullanici_adini_girer() {
        US013page.userName.sendKeys(ConfigReader.getProperty("doktorUserName"));
    }
    @Given("Doktor ayni sayfada bulunan Password bolumune sifresini girer")
    public void doktor_ayni_sayfada_bulunan_password_bolumune_sifresini_girer() {
        US013page.password.sendKeys(ConfigReader.getProperty("doktorPassword"));
    }
    @Then("Doktor ayni sayfada bulunan Sign in butonuna tiklar")
    public void doktor_ayni_sayfada_bulunan_sign_in_butonuna_tiklar() {
        US013page.girisSonrasiSingIn.click();
    }
    @Then("Doktor giris yaptigi sayfada My Pages butonuna tiklar")
    public void doktor_giris_yaptigi_sayfada_my_pages_butonuna_tiklar() {
        US013page.myPagesButton.click();
    }
    @Then("Doktor My Appointments secenegini tiklar")
    public void doktor_my_appointments_secenegini_tiklar() {
        US013page.myAppointmentsButton.click();
    }
    @Then("Sonraki sayfada randevusu olan hastasinin satirindaki Edit secenegini tiklar")
    public void sonraki_sayfada_randevusu_olan_hastasinin_satirindaki_edit_secenegini_tiklar() {
        US013page.editButtonu.click();
    }
    @Given("Doktor Request A butonuna tiklar")
    public void doktor_request_a_butonuna_tiklar() {
        ReusableMethods.waitFor(3);
        US013page.requestATestButonu.click();
    }
    @Given("Doktor Glucose, urea, creatinine, Sodium, Potassium,Total protein, Albumin, Hemoglobin testlerini secer")
    public void doktor_glucose_urea_creatinine_sodium_potassium_total_protein_albumin_hemoglobin_testlerini_secer() {

        List<String> istenenTestIsimleri= new ArrayList<>();
        istenenTestIsimleri.add("Sodium");
        istenenTestIsimleri.add("glucose");
        istenenTestIsimleri.add("Urea");
        istenenTestIsimleri.add("Creatinine");
        istenenTestIsimleri.add("Potassium-");
        istenenTestIsimleri.add("Total Protein-");
        istenenTestIsimleri.add("Albumin");
        istenenTestIsimleri.add("Hemoglobin");

        List<String> sutundakiTumTestlerListesi = new ArrayList<>();

        for (WebElement each:US013page.testIsimListesi
        ) {
            sutundakiTumTestlerListesi.add(each.getText());
        }

        for (int i = 0; i <istenenTestIsimleri.size() ; i++) {
            sutundakiTumTestlerListesi.contains(istenenTestIsimleri.get(i));
            ReusableMethods.hooverByJS(US013page.testSecmeButonuListesi.get(i));
        }

    }

    @Given("Doktor Save butonuna tiklar")
    public void doktor_save_butonuna_tiklar() {
        US013page.saveButonu.sendKeys(Keys.ENTER);
    }

    @Given("Acilan sayfada Show Test Result secenegini tiklar")
    public void acilan_sayfada_show_test_result_secenegini_tiklar() {
        ReusableMethods.waitFor(3);
        US013page.showTestResultsButonu.click();
    }

    @Given("Acilan sayfada View Result secenegini tiklar")
    public void acilan_sayfada_view_result_secenegini_tiklar() {
        US013page.viewResultsButonu.click();
    }

    @Given("Doktor  id, name, default max value, default min value, test, description and the date bilgilerini gorur")
    public void doktor_id_name_default_max_value_default_min_value_test_description_and_the_date_bilgilerini_gorur() {
        Assert.assertTrue(US013page.idGorunurluk.isDisplayed());
        Assert.assertTrue(US013page.nameGorunurluk.isDisplayed());
        Assert.assertTrue(US013page.defaultMinValueGorunurluk.isDisplayed());
        Assert.assertTrue(US013page.defaultMaxValueGorunurluk.isDisplayed());
        Assert.assertTrue(US013page.testGorunurluk.isDisplayed());
        Assert.assertTrue(US013page.descriptionGorunurluk.isDisplayed());
        Assert.assertTrue(US013page.dateGorunurluk.isDisplayed());
    }


    @Given("Acilan sayfada Request Inpatient secenegini tiklar")
    public void acilanSayfadaRequestInpatientSeceneginiTiklar() {
        US013page.requestInPatientButonu.click();
    }
}
