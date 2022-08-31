package stepDefinitions.Ui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;

public class US019StepD {

    US019page us019page = new US019page();

    @Given("Admin medunna_Url sayfasina gider")
    public void admin_medunna_url_sayfasina_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("medunna_url"));
    }
    @When("Admin medunna anasayfasinda sag_ust kosedeki kullanici ikonuna tiklar")
    public void admin_medunna_anasayfasinda_sag_ust_kosedeki_kullanici_ikonuna_tiklar() {
        us019page.signInLocation.click();
    }
    @When("Admin kullanici ikonu altinda yer alan Sign_In butonuna tiklar")
    public void admin_kullanici_ikonu_altinda_yer_alan_sign_in_butonuna_tiklar() {
        us019page.signInButton.click();
    }

    @When("Admin user name {string} alanini doldurur")
    public void admin_user_name_alanini_doldurur(String AdminUsername) {
        us019page.usernameBox.sendKeys(ConfigReader.getProperty("AdminUsername"));
    }
    @When("Admin user password {string} alanini doldurur")
    public void admin_user_password_alanini_doldurur(String AdminPassword) {
        us019page.passwordBox.sendKeys(ConfigReader.getProperty("AdminPassword"));
    }
    @When("Admin Sign_In butonuna tiklar")
    public void admin_sign_in_butonuna_tiklar() {

        Driver.waitAndClick(us019page.signInButtonForUsers);
    }
    @When("Admin acilan anasayfada Items&Titles alanina tiklar")
    public void admin_acilan_anasayfada_items_titles_alanina_tiklar() {
        Driver.waitAndClick(us019page.itemsAndTitles);
    }

    @When("Admin Items&Titles dropdown menusunde yer alan Staff secenegine tiklar")
    public void admin_items_titles_dropdown_menusunde_yer_alan_staff_secenegine_tiklar() {
        us019page.staffInDropDownMenu.click();
    }

    @When("Admin Create_A_Staff butonuna tiklar")
    public void admin_create_a_staff_butonuna_tiklar() {
        Driver.waitAndClick(us019page.createANewStaffButton);
    }

    @Then("Admin Use Search box'a tik atar")
    public void admin_use_search_box_a_tik_atar() {
        Driver.waitAndClick(us019page.getUseSSNSearchCheckBox);
    }

    @Then("Admin SSN box'una var olan bir staff'a ait {string} girer")
    public void admin_ssn_box_una_var_olan_bir_staff_a_ait_girer(String SSN) {
        Driver.waitAndSendText(us019page.getSearchSSNTextBox, SSN);
    }
    @Then("Admin Search_User butonuna tiklar")
    public void admin_search_user_butonuna_tiklar() {
        us019page.getSearchUserButton.click();
    }
    @Then("Admin User found with search SSN mesajini gorur")
    public void admin_user_found_with_search_ssn_mesajini_gorur() {
        Driver.wait(1);
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("User found with search SSN"));
    }

    @Then("Admin SSN box'a staff'a ait {string} girer")
    public void admin_ssn_box_a_staff_a_ait_girer(String SSN) {
        Driver.waitAndSendText(us019page.getSearchSSNTextBox, SSN);
    }
    @Then("{string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} alanlarini doldurulur")
    public void alanlarini_doldurulur(String FirstName, String LastName, String BirthDate, String Phone, String Gender, String BloodGroup, String Address, String Description, String User, String Country) {
        Driver.waitAndSendText(us019page.firstNameTextBox, FirstName);
        Driver.waitAndSendText(us019page.lastNameTextBox, LastName);
        Driver.waitAndSendText(us019page.birthDate, BirthDate);
        Driver.waitAndSendText(us019page.phone, Phone);
        Driver.waitAndSendText(us019page.genderTextBox, Gender);
        Driver.waitAndSendText(us019page.bloodGroupTextBox, BloodGroup);
        Driver.waitAndSendText(us019page.adressTextBox, Address);
        Driver.waitAndSendText(us019page.descriptionTextBox, Description);
        Driver.waitAndSendText(us019page.userFieldTextBox, User);
        Driver.waitAndSendText(us019page.countryTextBox, Country);
    }
    @Then("Save butonuna tiklar")
    public void save_butonuna_tiklar() {
        Driver.waitAndClick(us019page.saveButton);
    }
    @Then("Admin yeni Satff olusturuldu mesajini dogrular")
    public void admin_yeni_satff_olusturuldu_mesajini_dogrular() {
        Driver.wait(1);
        Assert.assertFalse(Driver.getDriver().getPageSource().contains("Field User cannot be empty!"));
    }
    @When("Admin bilgilerini guncellemek istedigi Staff'i secer")
    public void admin_bilgilerini_guncellemek_istedigi_staff_i_secer() {
        Driver.waitAndClick(us019page.userWhoWillBeUpdated);
    }

    @Then("{string}, {string} alanlarina yeni bilgiler doldurulur")
    public void alanlarina_yeni_bilgiler_doldurulur(String FirstName, String LastName) {
        Driver.waitAndSendText(us019page.firstNameTextBox, FirstName);
        Driver.waitAndSendText(us019page.lastNameTextBox, LastName);
    }
    @Then("Admin Satff bilgilerinin guncellendigini dogrular")
    public void admin_satff_bilgilerinin_guncellendigini_dogrular() {
        Driver.wait(1);
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("A Staff is updated with identifier")); // ID: 257755
    }
    @Given("Admin acilan anasayfada Administration ikonuna tiklar")
    public void admin_acilan_anasayfada_administration_ikonuna_tiklar() {
        Driver.waitAndClick(us019page.administrationIcon);
    }
    @Given("Admin Administration ikonu altinda yer alan User managementi tiklar")
    public void admin_administration_ikonu_altinda_yer_alan_user_managementi_tiklar() {
        Driver.waitAndClick(us019page.goToUserManagement);
    }
    @Given("Profiles bilgisi ROLE_STAFF olan herhangi bir Staff'i secer ve Delete butonuna tiklanir")
    public void profiles_bilgisi_role_staff_olan_herhangi_bir_staff_i_secer_ve_delete_butonuna_tiklanir() {
        Driver.waitAndClick(us019page.userWhoWillBeDeleted);
    }
    @Given("Admin acilan Pop Up mesajinda Delete butonuna tekrar tiklar")
    public void admin_acilan_pop_up_mesajinda_delete_butonuna_tekrar_tiklar() {
        Driver.wait(2);
        Driver.clickWithJS(us019page.getDeleteConfirmationButtonByJS);
    }
    @Then("Basarili bir sekilde silindigi gelen Pop-Up bildirimi ile teyit edilir")
    public void basarili_bir_sekilde_silindigi_gelen_pop_up_bildirimi_ile_teyit_edilir() {
        Driver.wait(1);
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("A user is deleted with identifier emirha"));
    }

    @And("user see Internal server error message")
    public void userSeeInternalServerErrorMessage() {
        Driver.wait(1);
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Internal server error."));
    }
    @Then("Admin browser'i kapatir")
    public void admin_browser_i_kapatir() {
        Driver.wait(2);
        Driver.closeDriver();
    }

}