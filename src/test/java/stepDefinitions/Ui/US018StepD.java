package stepDefinitions.Ui;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.US009page;
import pages.US018page;
import utilities.Driver;
import utilities.ReusableMethods;

public class US018StepD {

    US018page us018page = new US018page();
    US009page us009page=new US009page();
    Actions actions = new Actions(Driver.getDriver());
    Select select;
    Faker faker=new Faker();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    static String alinacakIdStr;

    @When("Admin Items&Titles ikonu altinda yer alan Physician bolumune tiklar")
    public void admin_items_titles_ikonu_altinda_yer_alan_physician_bolumune_tiklar() throws InterruptedException {
        Driver.waitAndClick(us018page.physician);
        Thread.sleep(5000);
    }

    @When("Admin doktorlarin bilgilerini gorur")
    public void admin_doktorlarin_bilgilerini_gorur() {
        Assert.assertTrue(us018page.physiciansHeading.isDisplayed());
    }

    @When("Admin Edit butonunu tiklar")
    public void admin_edit_butonunu_tiklar() throws InterruptedException {

        Thread.sleep(1000);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("javascript:window.scrollBy(0,800)");

        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        jsExecutor.executeScript("arguments[0].click();", us018page.ID);

        jsExecutor = (JavascriptExecutor) Driver.getDriver();
        jsExecutor.executeScript("arguments[0].click();", us018page.editDr);
        // patientView.EditButton.click();
        Thread.sleep(2000);
    }

    @Then("Use Search boxsa tik atar")
    public void use_search_boxsa_tik_atar() {
        us018page.useSSNSearchCheckBox.click();
    }

    @Then("SSN boxa gecerli bir SSN girer")
    public void ssn_boxa_gecerli_bir_ssn_girer() {
        us018page.searchSSN.click();
        us018page.searchSSN.sendKeys("812-12-4321");
    }

    @Then("Search User butonuna tiklar")
    public void search_user_butonuna_tiklar() {
        us018page.searchUser.click();
    }

    @Then("Firstname, lastname, birth date doldurur")
    public void firstname_lastname_birth_date_doldurur() {
        us018page.firstName.clear();
        us018page.firstName.sendKeys("Lokman");
        us018page.lastName.clear();
        us018page.lastName.sendKeys("Tabib");
        us018page.birthDate.clear();
        us018page.birthDate.sendKeys("01.01.2000");
    }

    @Then("Admin, dr icin bir uzmanlik alani secer")
    public void admin_dr_icin_bir_uzmanlik_alani_secer() {
        String uzmanlik="Urology";
        select=new Select(us018page.specialityDdm);
        select.selectByVisibleText(uzmanlik);
    }


    @Then("Admin dr nin profil resmini duzenler")
    public void admin_dr_nin_profil_resmini_duzenler() {
        String path = "C:\\Users\\jakyu\\Pictures\\Screenshot (2).png";
        us018page.dosyaSecButton.sendKeys(path);
    }

    @Then("Admin dr nin muayene ucretini girer")
    public void admin_dr_nin_muayene_ucretini_girer() {
        js.executeScript("arguments[0].scrollIntoView(true);", us018page.examFee);
        us018page.examFee.clear();
        us018page.examFee.sendKeys("500");
        ReusableMethods.waitFor(1);
    }


    @Then("Save butonunu tiklar")
    public void save_butonunu_tiklar() {
        Driver.waitAndClick(us018page.saveButton);
        Driver.closeDriver();
    }

    @Given("Admin Administration dropdownu tiklar")
    public void admin_administration_dropdownu_tiklar() {
        Driver.waitAndClick(us018page.administration);
    }
    @Then("Admin User managementi tiklar")
    public void admin_user_managementi_tiklar() {
        Driver.waitAndClick(us018page.userManagement);
    }
    @Then("Admin {int}. sayfaya gider")
    public void admin_sayfaya_gider(Integer sayfaNo) {
        js.executeScript("arguments[0].scrollIntoView(true);", us018page.medunnaText);
        Driver.waitAndClick(us018page.sonSayfa);
        //js.executeScript("arguments[0].click();", us018page.sonSayfa);

    }
    @Then("Admin first name Lokman olan dr secer")
    public void admin_first_name_lokman_olan_dr_secer() {
        //Assert.assertTrue(us018page.edidlenecekDr.isDisplayed());

    }

    @Then("Secilen doktoru siler")
    public void secilen_doktoru_siler() {
        Driver.waitAndClick(us018page.silinecekDr);
        //Driver.waitAndClick(us018page.deleteDr);
        Driver.closeDriver();
    }
}














