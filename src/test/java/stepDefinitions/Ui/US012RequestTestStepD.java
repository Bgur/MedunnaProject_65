package stepDefinitions.Ui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class US012RequestTestStepD {

    US012LoginPage loginPage = new US012LoginPage();
    US012RequestTestPage requestTestPage = new US012RequestTestPage();
    US012AppointmentPage myPagesAppointmentPage = new US012AppointmentPage();

    @Given("doktor medunna sayfasina gider")
    public void doktor_medunna_sayfasina_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("medunna_url"));
    }
    @Given("doktor sag üst kösedeki kullanici ikonuna tiklar")
    public void doktor_sag_üst_kösedeki_kullanici_ikonuna_tiklar() {
        loginPage.signInLocation.click();
    }
    @Given("doktor dropdown menüden Sign in ikonuna tiklar")
    public void doktor_dropdown_menüden_sign_in_ikonuna_tiklar() {
        loginPage.signIn.click();
    }
    @Given("doktor gecerli bir kullanici adi {string} Sign in sayfasina girer")
    public void doktor_gecerli_bir_kullanici_adi_sign_in_sayfasina_girer(String username) {
        Driver.waitAndSendText(loginPage.usernameBox, username);
    }
    @Given("doktor gecerli bir kullanici parolasi {string} Sign in sayfasina girer")
    public void doktor_gecerli_bir_kullanici_parolasi_sign_in_sayfasina_girer(String password) {
        Driver.waitAndSendText(loginPage.passwordBox, password);
    }
    @When("doktor sign in butonuna tiklar")
    public void doktor_sign_in_butonuna_tiklar() {
        Driver.waitAndClick(loginPage.signInButton);
    }
    @Then("doktor basarli giris yaptigini {string} teyit eder")
    public void doktor_basarli_giris_yaptigini_teyit_eder(String signedInUserName) {
        Assert.assertTrue(loginPage.signedInUserName.isDisplayed());
    }
    @Then("doktor my pages sekmesine tiklar")
    public void doktor_my_pages_sekmesine_tiklar() {
        Driver.waitForVisibility(myPagesAppointmentPage.myPages, 10);
        myPagesAppointmentPage.myPages.click();
    }
    @Then("doktor my appoinments sekmesine tiklar")
    public void doktor_my_appoinments_sekmesine_tiklar() {
        myPagesAppointmentPage.myAppointments.click();
    }
    @Then("doktor edit buttonuna tiklar")
    public void doktor_edit_buttonuna_tiklar() {
        Driver.waitForVisibility(myPagesAppointmentPage.editButton, 10);
        myPagesAppointmentPage.editButton.click();
    }
    @Then("doktor bir test iste button'a cift tiklar")
    public void doktor_bir_test_iste_button_a_cift_tiklar() throws InterruptedException {
        Driver.doubleClick(requestTestPage.requestTestButton);
        Thread.sleep(2000);
    }
    @Then("doktor test isteme sayfasinda oldugunu teyit eder")
    public void doktor_test_isteme_sayfasinda_oldugunu_teyit_eder() {
        Assert.assertTrue(requestTestPage.testItemsPage.isDisplayed());
    }
    @Then("doktor Save butonuna tiklar")
    public void doktor_save_butonuna_tiklar() {
        ReusableMethods.waitForClickablility(requestTestPage.requestTestSaveButton, 10);
    }
    @Then("doktor No Test Items Found bildirimini görür")
    public void doktor_no_test_items_found_bildirimini_görür() {
        Assert.assertTrue(requestTestPage.noTestItemsFound.isDisplayed());
    }
    @Then("doktor Urea checkmark'ina tiklar")
    public void doktor_urea_checkmark_ina_tiklar() {
        requestTestPage.ureaCheckBox.click();
    }
    @Then("doktor Creatinine checkmark'ina tiklar")
    public void doktor_creatinine_checkmark_ina_tiklar() {
        requestTestPage.creatinineCheckBox.click();
    }
    @Then("doktor Sodium checkmark'ina tiklar")
    public void doktor_sodium_checkmark_ina_tiklar() {
        requestTestPage.sodiumCheckBox.click();
    }
    @Then("doktor Potassium checkmark'ina tiklar")
    public void doktor_potassium_checkmark_ina_tiklar() {
        requestTestPage.potassiumCheckBox.click();
    }
    @Then("doktor Total_protein checkmark'ina tiklar")
    public void doktor_total_protein_checkmark_ina_tiklar() {
        requestTestPage.totalProteinCheckBox.click();
    }
    @Then("doktor Albumin checkmark'ina tiklar")
    public void doktor_albumin_checkmark_ina_tiklar() {
        requestTestPage.albuminCheckBox.click();
    }
    @Then("doktor Hemoglobin checkmark'ina tiklar")
    public void doktor_hemoglobin_checkmark_ina_tiklar() {
        requestTestPage.hemoglobinCheckBox.click();
    }
    @Then("doktor A New Test Created bildirimini görür")
    public void doktor_a_new_test_created_bildirimini_görür() {
        Assert.assertTrue(requestTestPage.aNewTestCreatedMessage.isDisplayed());
    }

    @And("doctor should verify Glucose is not displayed")
    public void doctorShouldVerifyGlucoseIsNotDisplayed() {


        Select select = new Select(requestTestPage.table);
        List<WebElement> allOptions = select.getOptions();
        boolean flag = false;
        for (WebElement eachOption : allOptions) {
            if (!eachOption.getText().contains("Glucose")) {
                flag = true;

            }

        }
        Assert.assertFalse(flag = false);


    }

}
