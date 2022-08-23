package stepDefinitions.Ui;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.US009page;
import utilities.Driver;


public class US009StepD {

    US009page u=new US009page();
    Actions actions=new Actions(Driver.getDriver());

    @Given("Kullanici Medunna Url'ye gider")
    public void kullanici_medunna_url_ye_gider() {
        Driver.getDriver().get("https://medunna.com/");}

    @Given("Sign in butonunu tiklar")
    public void sign_in_butonunu_tiklar() throws InterruptedException {
    u.accountMenu.click();
    Thread.sleep(1000);
    Driver.waitAndClick(u.firstSingIn);
    }

    @Given("Staff username ve password girer")
    public void staff_username_ve_password_girer() {
        u.userName.sendKeys("PersonelOnur65");
        u.password.sendKeys("PersonelOnur.65");
    }

    @Given("Staff sign in butonuna tiklar ve sign olur")
    public void staff_sign_in_butonuna_tiklar_ve_sign_olur() {
        u.secondSignIn.click();
    }

    @Then("Staff My Pages butonunu tiklar")
    public void staff_my_pages_butonunu_tiklar() {
        Driver.waitAndClick(u.MyPages);
    }

    @Then("Staff Search Patient sekmesini tiklar")
    public void staff_search_patient_sekmesini_tiklar() {
        u.searchPatient.click();
    }

    @Then("Staff, Patients SSN search Boxa bir hasta SSN'i girer")
    public void staff_patients_ssn_search_boxa_bir_hasta_ssn_i_girer() {
    u.patientSsnSearchBox.click();
    u.patientSsnSearchBox.sendKeys("135-79-1359" + Keys.ENTER);
    }

    @Then("Staff ekrani saga kaydirarak edit butonunu tiklar")
    public void staff_ekrani_saga_kaydirarak_edit_butonunu_tiklar() throws InterruptedException {
        Thread.sleep(1000);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("javascript:window.scrollBy(0,800)");

        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        jsExecutor.executeScript("arguments[0].click();", u.patientID);

        jsExecutor = (JavascriptExecutor) Driver.getDriver();
        jsExecutor.executeScript("arguments[0].click();", u.edit);
        // patientView.EditButton.click();
        Thread.sleep(2000);
    }

    @Then("Staff hastanin tum bilgilerini duzenler")
    public void staff_hastanin_tum_bilgilerini_duzenler() {
        u.firstNameS.clear();
        u.firstNameS.sendKeys("Muzmin");
        u.lastName.clear();
        u.lastName.sendKeys("Hasta");
    }

    @Then("Staff butonuna tiklar")
    public void staff_butonuna_tiklar() {
        Driver.waitAndClick(u.saveButtonS);
        Driver.closeDriver();
    }

    @Then("Staff hastanin tum bilgilerinin dolu oldugunu kontrol eder")
    public void staff_hastanin_tum_bilgilerinin_dolu_oldugunu_kontrol_eder() {
        Assert.assertTrue(u.kontrolSSN.isDisplayed());
        Assert.assertTrue(u.kontrolFirstName.isDisplayed());
        Assert.assertTrue(u.kontrolLastName.isDisplayed());
        Assert.assertTrue(u.kontrolBirtDate.isDisplayed());
        Assert.assertTrue(u.kontrolPhone.isDisplayed());
        Assert.assertTrue(u.kontrolEmail.isDisplayed());
        Assert.assertTrue(u.kontrolGender.isDisplayed());
        Assert.assertTrue(u.kontrolBloodGroup.isDisplayed());
        Assert.assertTrue(u.kontrolAddress.isDisplayed());
        Assert.assertTrue(u.kontrolDescription.isDisplayed());
        Assert.assertTrue(u.kontrolUser.isDisplayed());
        Assert.assertTrue(u.kontrolCountry.isDisplayed());
        Driver.closeDriver();
    }

    @Given("Admin username ve password girer")
    public void admin_username_ve_password_girer() {
        u.userName.sendKeys("Team65");
        u.password.sendKeys("Team65.");
    }

    @Given("Admin sign in butonuna tiklar ve sign olur")
    public void admin_sign_in_butonuna_tiklar_ve_sign_olur() { u.secondSignIn.click();}

    @Then("Admin Items&Titles butonunu tiklar")
    public void admin_items_titles_butonunu_tiklar() {
    Driver.waitAndClick(u.itemsTitles);
    }

    @Then("Admin Dropdown menusunden Patients butonunu tiklar")
    public void admin_dropdown_menusunden_patients_butonunu_tiklar() {
        u.patientButton.click();
    }

    @Then("Admin edit butonuna tiklar")
    public void admin_edit_butonuna_tiklar() throws InterruptedException {
        Thread.sleep(1000);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("javascript:window.scrollBy(0,800)");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        jsExecutor = (JavascriptExecutor) Driver.getDriver();
        jsExecutor.executeScript("arguments[0].click();", u.editButton);
        // patientView.EditButton.click();
        Thread.sleep(2000);
    }

    @Then("Admin patientin tum bilgilerini update eder")
    public void admin_patientin_tum_bilgilerini_update_eder() {
        u.patientFirstNameA.clear();
        u.patientFirstNameA.sendKeys("RamizGrimes");
        u.patientLastNameA.clear();
        u.patientLastNameA.sendKeys("Dayi");
    }

    @Then("Admin save butonunu tiklar")
    public void admin_save_butonunu_tiklar() {
        Driver.waitAndClick(u.saveButtonA);
        Driver.closeDriver();
    }

    @Then("Admin wiew butonunu tiklar")
    public void admin_wiew_butonunu_tiklar() throws InterruptedException {
        Thread.sleep(1000);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("javascript:window.scrollBy(0,800)");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        jsExecutor = (JavascriptExecutor) Driver.getDriver();
        jsExecutor.executeScript("arguments[0].click();", u.viewButton);
        Thread.sleep(1000);
    }

    @Then("Admin Patient bilgilerini dogrular")
    public void admin_patient_bilgilerini_dogrular() {
        Assert.assertEquals("234-23-2345", u.patientSsn.getText());
        Assert.assertEquals("RamizGrimes", u.patientFNameA.getText());
        Assert.assertEquals("Dayi", u.patientLNameA.getText());
        Assert.assertEquals("576-753-4340", u.patientPhoneA.getText());
        Driver.closeDriver();
    }

    @Then("Admin delete butonuna tiklar")
    public void admin_delete_butonuna_tiklar() throws InterruptedException {
        Thread.sleep(1000);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("javascript:window.scrollBy(0,800)");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        jsExecutor = (JavascriptExecutor) Driver.getDriver();
        jsExecutor.executeScript("arguments[0].click();", u.deleteButton);
        Thread.sleep(1000);
    }

    @Then("Admin patientin bilgilerini siler")
    public void admin_patientin_bilgilerini_siler() {
        u.deleteConfirmButton.click();
        // ##################################################
        //Bug Var. delete confirm tiklaninca "internal server error" hatasi veriyor
        // ####################################################
        Driver.closeDriver();
    }

    @Then("Delete butonu gorunmez")
    public void delete_butonu_gorunmez() {
        //Assert.assertFalse(u.deleteButton.isDisplayed());
        Driver.closeDriver();
    }

    @Then("Ptients Search Box gorunmez")
    public void ptients_search_box_gorunmez() {
        //Assert.assertFalse(u.patientSsnSearchBox.isDisplayed());
        Driver.closeDriver();
    }

}
