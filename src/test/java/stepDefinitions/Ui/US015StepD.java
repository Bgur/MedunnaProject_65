package stepDefinitions.Ui;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.US015page;
import pages.US010page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class US015StepD {

    US015page Us015page=new US015page();
    pages.US010page US010page=new US010page();
    Actions actions=new Actions(Driver.getDriver());
    Faker faker=new Faker();
    Select select;
    LocalDate localDate=LocalDate.now();
    LocalDate duzenlenmisLocalDate = localDate.minusDays(10).minusMonths(3).minusYears(30);
    DateTimeFormatter duzenliDateStart = DateTimeFormatter.ofPattern("dd/MM/yyyy ");
    String checkInDate = duzenlenmisLocalDate.format(duzenliDateStart);
    List<String> statesInUs;
    List<String> theListOfNameOfStatesFromWebTable;

    @Given("Admin medunnaUrl sayfasina gider")
    public void admin_medunna_url_sayfasina_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("medunna_url"));

    }
    @When("Admin medunna anasayfasinin sag ust kosesindeki kullanici ikonuna tiklar")
    public void admin_medunna_anasayfasinin_sag_ust_kosesindeki_kullanici_ikonuna_tiklar() {
        US010page.KullaniciIkonu.click();

    }
    @When("Admin kullanici ikonu altinda yer alan sign in butonuna tiklar")
    public void admin_kullanici_ikonu_altinda_yer_alan_sign_in_butonuna_tiklar() {
        US010page.singIn.click();

    }
    @When("Admin username alanina gecerli {string} girer")
    public void admin_username_alanina_gecerli_girer(String string) {
        US010page.singInUsernameTextBox.sendKeys(ConfigReader.getProperty("AdminUsername"));

    }
    @When("Admin password alanina gecerli {string} girer")
    public void admin_password_alanina_gecerli_girer(String string) {
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("AdminPassword")).perform();

    }
    @When("Admin Sign in butonuna tiklar")
    public void admin_sign_in_butonuna_tiklar() {
        US010page.singInButonu.click();

    }
    @When("Admin acilan anasayfada Items&Titles ikonuna tiklar")
    public void admin_acilan_anasayfada_items_titles_ikonuna_tiklar() {

        ReusableMethods.waitFor(2);
        Us015page.items_titles.click();


    }
    @When("Admin Items&Titles ikonu altinda yer alan Patient bolumune tiklar")
    public void admin_items_titles_ikonu_altinda_yer_alan_patient_bolumune_tiklar() {
        Us015page.Patient.click();

    }
    @When("Admin acilan sayfada create a new Patient butonuna tiklar")
    public void admin_acilan_sayfada_create_a_new_patient_butonuna_tiklar() {
        Us015page.createAnewPatientButton.click();

    }

    @When("Admin first name alanina {string} girer")
    public void admin_first_name_alanina_girer(String string) {
        Us015page.patientFirstName.sendKeys(faker.name().firstName());

    }

    @When("Admin last name alanina {string} girer")
    public void admin_last_name_alanina_girer(String string) {
        Us015page.patientLastName.sendKeys(faker.name().lastName());

    }

    @When("Admin Birth date alanina  {string} girer")
    public void admin_birth_date_alanina_girer(String string) {

        Us015page.patientBirthDay.sendKeys(checkInDate);
    }

    @When("Admin Email alanina  {string} girer")
    public void admin_email_alanina_girer(String string) {
        Us015page.patientEmail.sendKeys(faker.internet().emailAddress());
    }

    @When("Admin Phone alanina hastanin telefon numarasini girer")
    public void admin_phone_alanina_hastanin_telefon_numarasini_girer() {
        Us015page.patientPhoneNumber.sendKeys("1234567890");

    }

    @When("Admin Gender alanina {string} secer")
    public void admin_gender_alanina_secer(String string) {

        select=new Select(Us015page.patientGender);
        select.selectByValue("MALE");

    }

    @When("Admin Blood Group alanina {string} secer")
    public void admin_blood_group_alanina_secer(String string) {
        ReusableMethods.waitFor(2);
        select=new Select(Us015page.patientBloodGroup);
        select.selectByVisibleText("AB+");

    }

    @When("Admin Address alanina {string} girer")
    public void admin_address_alanina_girer(String string) {
        Us015page.patientAdress.sendKeys(faker.address().fullAddress());

    }
    @When("Admin Description alanini doldurur")
    public void admin_description_alanini_doldurur() {
        Us015page.descriptionTextBox.sendKeys("Bas agrisi, mide bulantisi");

    }

    @When("Admin user alanina  kullanici secer")
    public void admin_user_alanina_kullanici_secer() {
        select=new Select(Us015page.patientUser);
        select.selectByVisibleText("hy");

    }

    @When("Admin Country alanina hastanin ulkesini secer")
    public void admin_country_alanina_hastanin_ulkesini_secer() {
        select=new Select(Us015page.patientCountry);
        select.selectByVisibleText("Germany");
    }

    @And("Admin State-City alanini bos birakir")
    public void adminStateCityAlaniniBosBirakir() {
        Us015page.patientState.click();
    }


    @When("Admin Save butonuna tiklar")
    public void admin_save_butonuna_tiklar() {
        Us015page.saveButonu.click();
        ReusableMethods.waitFor(4);
    }

    @When("Admin A new Patient is created mesajini gorur")
    public void admin_a_new_patient_is_created_mesajini_gorur() {
        ReusableMethods.waitFor(2);
        String expectedText="A new Patient is created";
        String actualText=Us015page.patientKayitOlusturuldu.getText();
        Assert.assertTrue(actualText.contains(expectedText));
        System.out.println("alert yazisi :"+ Us015page.patientKayitOlusturuldu.getText());
    }

    @When("Admin 3357 id nolu hastanin SSN numarasi bilgisini gorur")
    public void admin_3357_id_nolu_hastanin_ssn_numarasi_bilgisini_gorur() {
        ReusableMethods.waitFor(2);
        String expectedData= "856-45-6777";
        Assert.assertEquals(expectedData,Us015page.HastaSnnNumarasiKontrol.getText());

    }
    @When("Admin 3357 id nolu hastanin First Name bilgisini gorur")
    public void admin_3357_id_nolu_hastanin_first_name_bilgisini_gorur() {
        ReusableMethods.waitFor(2);
        String expectedData= "Myrtice";
        Assert.assertEquals(expectedData,Us015page.HastaFirstNameKontrol.getText());

    }
    @When("Admin 3357 id nolu hastanin Last Name bilgisini gorur")
    public void admin_3357_id_nolu_hastanin_last_name_bilgisini_gorur() {
        String expectedData= "Gaylord";
        Assert.assertEquals(expectedData,Us015page.HastaLastNameKontrol.getText());

    }
    @When("Admin 3357 id nolu hastanin Birt Date bilgisini gorur")
    public void admin_3357_id_nolu_hastanin_birt_date_bilgisini_gorur() {
        String expectedData= "30/07/67 03:17";
        Assert.assertEquals(expectedData,Us015page.HastaBirthDateKontrol.getText());

    }
    @When("Admin 3357 id nolu hastanin Phone number bilgisini gorur")
    public void admin_3357_id_nolu_hastanin_phone_number_bilgisini_gorur() {
        String expectedData= "4165667780";
        Assert.assertEquals(expectedData,Us015page.HastaPhoneNumberKontrol.getText());

    }
    @When("Admin 3357 id nolu hastanin Gender bilgisini gorur")
    public void admin_3357_id_nolu_hastanin_gender_bilgisini_gorur() {
        String expectedData= "FEMALE";
        Assert.assertEquals(expectedData,Us015page.HastaGenderKontrol.getText());

    }

    @When("Admin 3357 id nolu hastanin Blood Group bilgisini gorur")
    public void admin_3357_id_nolu_hastanin_blood_group_bilgisini_gorur() {
        ReusableMethods.waitFor(2);
        String expectedData= "B-";
        Assert.assertEquals(expectedData,Us015page.HastaBloodGroupKontrol.getText());

    }
    @When("Admin 3357 id nolu hastanin Adress bilgilesini gorur")
    public void admin_3357_id_nolu_hastanin_adress_bilgilesini_gorur() {
        ReusableMethods.waitFor(2);
        String expectedData= "Antalya";
        Assert.assertEquals(expectedData,Us015page.HastaAdressKontrol.getText());

    }
    @When("Admin 3357 id nolu hastanin Description bilgisini gorur")
    public void admin_3357_id_nolu_hastanin_description_bilgisini_gorur() {

        String expectedData= "asthma";
        Assert.assertEquals(expectedData,Us015page.HastaDescriptionKontrol.getText());

    }
    @When("Admin 3357 id nolu hastanin Created Date bilgisini gorur")
    public void admin_3357_id_nolu_hastanin_created_date_bilgisini_gorur() {
        String expectedData= "28/12/21 10:24";
        Assert.assertEquals(expectedData,Us015page.HastaCreatedDateKontrol.getText());

    }
    @When("Admin 3357 id nolu hastanin User bilgisini gorur")
    public void admin_3357_id_nolu_hastanin_user_bilgisini_gorur() {
        String expectedData= "admin";
        Assert.assertEquals(expectedData,Us015page.HastaUserKontrol.getText());

    }
    @When("Admin 3357 id nolu hastanin Country bilgisini gorur")
    public void admin_3357_id_nolu_hastanin_country_bilgisini_gorur() {
        String expectedData= "Turkey";
        Assert.assertEquals(expectedData,Us015page.HastaCountryKontrol.getText());
    }
    @When("Admin 3357 id nolu hastanin State-City bilgisini gorur")
    public void admin_3357_id_nolu_hastanin_state_city_bilgisini_gorur() {
       String expectedData= "Van";
       Assert.assertEquals(expectedData,Us015page.HastaStateCityKontrol.getText());
    }

    @When("Admin ilk siradaki hastanin bilgilerini guncellemek icin edit butonuna tiklar")
    public void admin_ilk_siradaki_hastanin_bilgilerini_guncellemek_icin_edit_butonuna_tiklar() {
        ReusableMethods.waitFor(2);
        Us015page.ilkHastaEditButonu.click();

    }
    @When("Admin hastanin bilgilerini guncellemek icin SNN numarasina data girisi yapar")
    public void admin_hastanin_bilgilerini_guncellemek_icin_snn_numarasina_data_girisi_yapar() {
        Assert.assertTrue(Us015page.hastaSNN.isDisplayed());

    }
    @When("Admin hastanin bilgilerini guncellemek icin Created Date bilgisine data girisi yapar")
    public void admin_hastanin_hastanin_bilgilerini_guncellemek_icin_created_date_bilgisine_data_girisi_yapar() {
        Assert.assertTrue(Us015page.hastaCreatedDate.isDisplayed());

    }
    @When("Admin yeni hasta kaydi olustururken hastanin SNN numarasina data girisi yapar")
    public void admin_yeni_hasta_kaydi_olustururken_hastanin_snn_numarasina_data_girisi_yapar() {
        Assert.assertTrue(Us015page.patientSNN.isDisplayed());

    }
    @When("Admin yeni hasta kaydi olustururken hastanin Created Date bilgisine data girisi yapar")
    public void admin_yeni_hasta_kaydi_olustururken_hastanin_created_date_bilgisine_data_girisi_yapar() {
        Assert.assertTrue(Us015page.patientCreatedDate.isDisplayed());

    }

    @When("Admin hastanin First Name bilgisine data girisi yapar")
    public void admin_hastanin_first_name_bilgisine_data_girisi_yapar() {
        ReusableMethods.waitFor(2);
        Us015page.hastaFirstName.clear();
        Us015page.hastaFirstName.sendKeys("Guncel");

    }
    @When("Admin hastanin Last Name bilgisine data girisi yapar")
    public void admin_hastanin_last_name_bilgisine_data_girisi_yapar() {
        Us015page.hastaLastName.clear();
        Us015page.hastaLastName.sendKeys("Hasta");
    }
    @When("Admin hastanin Birth Date bilgisine data girisi yapar")
    public void admin_hastanin_birth_date_bilgisine_data_girisi_yapar() {

        Us015page.hastaBirthDate.sendKeys(checkInDate);
    }
    @When("Admin hastanin Phone Number bilgisine data girisi yapar")
    public void admin_hastanin_phone_number_bilgisine_data_girisi_yapar() {
        Us015page.hastaPhoneNumber.clear();
        Us015page.hastaPhoneNumber.sendKeys("5321234567");


    }
    @When("Admin hastanin Gender bilgisine data girisi yapar")
    public void admin_hastanin_gender_bilgisine_data_girisi_yapar() {
        select=new Select(Us015page.hastaGender);
        select.selectByVisibleText("FEMALE");

    }
    @When("Admin hastanin Blood Groub bilgisine data girisi yapar")
    public void admin_hastanin_blood_groub_bilgisine_data_girisi_yapar() {
        select=new Select(Us015page.hastaBloodGroup);
        select.selectByVisibleText("B+");

    }
    @When("Admin hastanin Adress bilgisine data girisi yapar")
    public void admin_hastanin_adress_bilgisine_data_girisi_yapar() {
        Us015page.hastaAdress.clear();
        Us015page.hastaAdress.sendKeys("Antalya");

    }
    @When("Admin hastanin Description bilgisine data girisi yapar")
    public void admin_hastanin_description_bilgisine_data_girisi_yapar() {
        Us015page.hastaDescription.clear();
        Us015page.hastaDescription.sendKeys("Kanser");
    }

    @When("Admin hastanin User bilgisine data girisi yapar")
    public void admin_hastanin_user_bilgisine_data_girisi_yapar() {
        select=new Select(Us015page.hastaUser);
        select.selectByVisibleText("hy");

    }
    @When("Admin hastanin Country bilgisine data girisi yapar")
    public void admin_hastanin_country_bilgisine_data_girisi_yapar() {
        select=new Select(Us015page.hastaCountry);
        select.selectByVisibleText("Turkey");

    }
    @When("Admin hastanin State-City bilgisine data girisi yapar")
    public void admin_hastanin_state_city_bilgisine_data_girisi_yapar() {

    }


    @And("Admin A Patient is updated mesajini gorur")
    public void adminANewPatientIsUpdatedMesajiniGorur() {
        ReusableMethods.waitFor(2);
        String expectedText="A Patient is updated";
        String actualText=Us015page.hastaBilgisiGuncellendi.getText();
        Assert.assertTrue(actualText.contains(expectedText));
        System.out.println("alert yazisi :"+ Us015page.hastaBilgisiGuncellendi.getText());



    }





    @When("Admin sayfayi kapatir")
    public void admin_sayfayi_kapatir() {
        ReusableMethods.waitFor(1);
        Driver.closeDriver();


    }

    @When("Admin hastanin ulkesini secmek icin Country butonuna tiklar")
    public void admin_hastanin_ulkesini_secmek_icin_country_butonuna_tiklar() {
        Us015page.hastaCountry.click();

    }
    @When("Admin Country alaninda Turkey olup olmadigini test eder")
    public void admin_country_alaninda_turkey_olup_olmadigini_test_eder() {
        ReusableMethods.waitFor(2);
        Select country = new Select(Us015page.patientCountry);
        String expectedText = "USA";
        String actualText;



    }
    @When("Admin Country alaninda Turkey secer")
    public void admin_country_alaninda_turkey_secer() {

    }
    @When("Admin Country alaninin doldurulmasinin zorunlu oldugunu test eder")
    public void admin_country_alaninin_doldurulmasinin_zorunlu_oldugunu_test_eder() {

    }

    @When("Admin Items&Titles ikonu altinda yer alan Appointment bolumune tiklar")
    public void admin_items_titles_ikonu_altinda_yer_alan_appointment_bolumune_tiklar() {
        Us015page.appointmentButonu.click();

    }
    @When("Admin acilan sayfada ilk siradaki hastaya doktor atayabilmek icin edit butonuna tiklar")
    public void admin_acilan_sayfada_ilk_siradaki_hastaya_doktor_atayabilmek_icin_edit_butonuna_tiklar() {
        ReusableMethods.waitFor(5);
        Us015page.doktorAtamaEditButonu.click();



    }
    @When("Admin Physician alanina hastaya atayacagi doktoru secer")
    public void admin_physician_alanina_hastaya_atayacagi_doktoru_secer() {
        ReusableMethods.waitFor(10);
        select=new Select(Us015page.doktorSecme);
        select.selectByVisibleText("94207:Ali Can");


    }


    @And("Admin A Appointment is updated mesajini gorur")
    public void adminAAppointmentIsUpdatedMesajiniGorur() {
        ReusableMethods.waitFor(5);
        System.out.println("alert yazisi"+ Us015page.hastayaDoktorAtandiYazisi.getText());
   /*
        String expectedText="The Appointment is updated with identifier 2301";
      System.out.println("alert yazisi :"+ Us015page.hastayaDoktorAtandiYazisi.getText());
          String actualText=Us015page.hastayaDoktorAtandiYazisi.getText();
       Assert.assertTrue(actualText.contains(expectedText));

    */

    }

    @And("Admin ilk siradaki hastayi silmek icin delete butonuna tiklar")
    public void adminIlkSiradakiHastayiSilmekIcinDeleteButonunaTiklar() {


    }

    @And("Admin acilan Confirm Delete Operation uyari mesajinda delete butonuna tiklar")
    public void adminAcilanConfirmDeleteOperationUyariMesajindaDeleteButonunaTiklar() {
    }

    @And("Admin hastanin silinip silmedigini kontrol etmek icin A Patient is deleted mesajini gormeli")
    public void adminHastaninSilinipSilmediginiKontrolEtmekIcinAPatientIsDeletedMesajiniGormeli() {
    }


}
