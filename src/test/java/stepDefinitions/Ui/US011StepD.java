package stepDefinitions.Ui;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.US011page;
import utilities.Driver;
import utilities.ReusableMethods;

import static org.junit.Assert.*;

public class US011StepD {

    US011page us11Pages=new US011page();
    Actions actions=new Actions(Driver.getDriver());
    Faker faker=new Faker();


    @Then("Doktor  Useful Links altindaki Make an appointment'a tiklar")
    public void doktor_useful_links_altindaki_make_an_appointment_a_tiklar() {

        us11Pages.makeAnAppointment.click();

    }

    @Then("Doktor first name alanina {string} girer")
    public void doktor_first_name_alanina_girer(String string) {
        ReusableMethods.waitFor(1);
        String fakerFirstName=faker.name().firstName();
        us11Pages.firstnameTextBox.sendKeys(fakerFirstName);

    }
    @Then("Doktor last name alanina {string} girer")
    public void doktor_last_name_alanina_girer(String string) {
        String fakerLastname=faker.name().lastName();
        us11Pages.lastNameTextBox.sendKeys(fakerLastname);

    }
    @Then("Doktor SSN alanina hastanin {int}. ve {int}. rakamlarindan sonra {string} koymak uzere {int} haneli sayi girer")
    public void doktor_ssn_alanina_hastanin_ve_rakamlarindan_sonra_koymak_uzere_haneli_sayi_girer(Integer int1, Integer int2, String string, Integer int3) {
        String sayi= faker.idNumber().ssnValid();
        us11Pages.ssnTextBox.sendKeys(sayi);

    }
    @Then("Doktor hastanin {string} girer")
    public void doktor_hastanin_girer(String string) {
        String fakerEmail=faker.internet().emailAddress();
        us11Pages.emailTextBox.sendKeys(fakerEmail);
    }

    @And("Doktor hastanin telefon numarasini girer")
    public void doktorHastaninTelefonNumarasiniGirer() {

        String phoneNumber="532-123-4567";
        us11Pages.phoneTextBox.sendKeys(phoneNumber);
    }

    @And("Doktor randevu tarihini girer")
    public void doktorRandevuTarihiniGirer() {
        actions.sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

    }

    @Then("Doktor Send an Appointment Request butonuna tiklar")
    public void doktor_send_an_appointment_request_butonuna_tiklar() {
        us11Pages.sendAppointmentButonu.click();

    }
    @Then("Doktor Appointment registration saved! We will call you as soon as possible mesajini gorur")
    public void doktor_appointment_registration_saved_we_will_call_you_as_soon_as_possible_mesajini_gorur() {
        ReusableMethods.waitFor(2);
        String expectedText="Appointment registration saved!";
        assertEquals(expectedText, us11Pages.KayitOlusturulduYazisi.getAttribute("innerText"));

    }

    @Then("Doktor edit butonuna tiklar")
    public void doktor_edit_butonuna_tiklar() {
        ReusableMethods.waitFor(2);
        us11Pages.editButonu.click();

    }
    @Then("Doktor Status menusunu Pending olarak secer")
    public void doktor_status_menusunu_pending_olarak_secer() {
        ReusableMethods.waitFor(2);
        Select select=new Select(us11Pages.statusDropDown);
        select.selectByValue("PENDING");

    }
    @Then("Doktor Anamnesis alanini doldurur")
    public void doktor_anamnesis_alanini_doldurur() {
        us11Pages.anamnesisTextBox.clear();
        us11Pages.anamnesisTextBox.sendKeys("dolduruldu");

    }
    @Then("Doktor Treatment alanini doldurur")
    public void doktor_treatment_alanini_doldurur() {
        us11Pages.treatmentTextBox.clear();
        us11Pages.treatmentTextBox.sendKeys("dolduruldu");

    }
    @Then("Doktor Diagnosis alanini doldurur")
    public void doktor_diagnosis_alanini_doldurur() {
        us11Pages.diagnosisTextBox.clear();
        us11Pages.diagnosisTextBox.sendKeys("dolduruldu");

    }
    @And("Doktor Prescription alanini doldurur")
    public void doktorPrescriptionAlaniniDoldurur() {
        us11Pages.prescriptionTextBox.clear();
        us11Pages.prescriptionTextBox.sendKeys("dolduruldu");
    }

    @And("Doktor Description alanini doldurur")
    public void doktorDescriptionAlaniniDoldurur() {
        us11Pages.descriptionTextBox.clear();
        us11Pages.descriptionTextBox.sendKeys("dolduruldu");
    }

    @Then("Doktor Prescription alanini bos birakir")
    public void doktor_prescription_alanini_bos_birakir() {
        //bos birakilir
    }
    @Then("Doktor Description alanini bos birakir")
    public void doktor_description_alanini_bos_birakir() {
        //bos birakilir
    }
    @Then("Doktor save butonuna tiklar")
    public void doktor_save_butonuna_tiklar() {
        us11Pages.saveButonu.click();
    }

    @Then("Doktor The Appointment is updated mesajini gorur")
    public void doktor_The_Appointment_is_updated_mesajini_mesajini_gorur() {
        ReusableMethods.waitFor(1);
        String expectedResultYazisi="The Appointment is updated with identifier 191393";
        System.out.println("randevu guncellendi yazisi :"+us11Pages.randevuGuncellendi.getText());
        assertEquals(expectedResultYazisi, us11Pages.randevuGuncellendi.getAttribute("innerText"));



    }

    @And("Doktor Status menusunu Cancelled olarak secer")
    public void doktorStatusMenusunuCancelledOlarakSecer() {
        Select select=new Select(us11Pages.statusDropDown);
        select.selectByValue("CANCELLED");

    }

    @And("Doktor randevu guncellendikten sonra hastanin id, start and end date, Status, physician and patient bilgilerini gorur")
    public void doktorRandevuGuncellendiktenSonraHastaninIdStartAndEndDateStatusPhysicianAndPatientBilgileriniGorur() {

        Assert.assertTrue(us11Pages.id.isDisplayed());
        Assert.assertTrue(us11Pages.startDateTime.isDisplayed());
        Assert.assertTrue(us11Pages.endDateTime.isDisplayed());
        Assert.assertTrue(us11Pages.status.isDisplayed());
        Assert.assertTrue(us11Pages.physician.isDisplayed());
        Assert.assertTrue(us11Pages.physician.isDisplayed());


    }

    @Then("Doktor Status menusunu Completed olarak secer")
    public void doktor_status_menusunu_completed_olarak_secebilmeli() {
        Select select=new Select(us11Pages.statusDropDown);
        select.selectByValue("COMPLETED");

    }



}
