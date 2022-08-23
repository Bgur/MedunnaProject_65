package stepDefinitions.Ui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.US001page;
import utilities.ConfigReader;
import utilities.Driver;

import static utilities.ReusableMethods.waitFor;

public class US001StepD {
    US001page us001=new US001page();

    @Given("Kullanici {string} sayfasina gider")
    public void kullanici_sayfasina_gider(String string) {
        Driver.getDriver().get(ConfigReader.getProperty("medunna_url"));
        waitFor(3);
    }
    @Given("Kullanici Anasayfada kullanici ikonuna tiklar")
    public void kullanici_anasayfada_kullanici_ikonuna_tiklar() {

        us001.accuntButton();

    }
    @Given("Kullanici ikonu altindaki regester'i tiklar")
    public void kullanici_ikonu_altindaki_regester_i_tiklar() {
 us001.registerButton();
    }
    @When("Kullanici SSN kutucuguna tiklar")
    public void kullanici_ssn_kutucuguna_tiklar() throws InterruptedException {
     us001.ssnTextBox();

    }
    @Then("Kullanici SSN kutucugunu bos birakir")
    public void kullanici_ssn_kutucugunu_bos_birakir() {

    }

    @Then("KUllanici SSN kutucugunu bos birakinca {string} uyarı mesajını görüntüle")
    public void k_ullanici_ssn_kutucugunu_bos_birakinca_uyarı_mesajını_görüntüle(String string) {
       us001.ssnRequiredMessage();
    }


    @Then("Kullanici Your SSN is invalid' uyarı mesajı görüntülenmeli")
    public void kullanici_your_ssn_is_invalid_uyarı_mesajı_görüntülenmeli() {

    }


    @And("Kullanici SSN kutucuğuna {string}lerden ve {string}lerden  olusan SSN girmeli ve kabul edilmemeli")
    public void kullaniciSSNKutucuğunaLerdenVeLerdenOlusanSSNGirmeliVeKabulEdilmemeli(String karekter, String harf) throws InterruptedException {
        us001.falseSsn(karekter,harf);
    }

    








    @And("Kullanici SSN kutucuğuna {string}rakamlardan olusan ve {string}içeren bir ssn girer")
    public void kullaniciSSNKutucuğunaRakamlardanOlusanVeIçerenBirSsnGirer(String sayi1, String sayi2) throws InterruptedException {
        us001.YanlisSsn(sayi1,sayi2);
    }

    @And("Kullanici SSN kutucuğuna {string}rakamlardan olusan")
    public void kullaniciSSNKutucuğunaRakamlardanOlusan(String arg0) {
        us001.ssnTextBox.sendKeys(arg0);
    }

    @And("Kullanici browseri kapatir")
    public void kullaniciBrowseriKapatir() {
        Driver.closeDriver();
    }







    @And("Kullanici dogru SSN girdigini dogrular")
    public void kullaniciDogruSSNGirdiginiDogrular() {
        us001.ValidSsn();
    }



    @And("Kullanici SSN kutusuna dokuz rakamdan oluşan ve ucuncu ve besinci rakamdan sonra - içeren  bir ssn girer")
    public void kullaniciSSNKutusunaDokuzRakamdanOluşanVeUcuncuVeBesinciRakamdanSonraIçerenBirSsnGirer() throws InterruptedException {
       us001.GecerliSsn();
        //us001.ssnTextBox.sendKeys("456-12-7852");
    }

    @And("Kullanici FirstName kutusunu bos birakir")
    public void kullaniciFirstNameKutusunuBosBirakir() {
    }

    @Then("Kullanici FirstName kutusuna tiklar")
    public void kullaniciFirstNameKutusunaTiklar() {
        us001.firstNameTextBox();
    }


    @And("Kullanici LastName kutusuna tiklar")
    public void kullaniciLastNameKutusunaTiklar() {
        us001.lastNameTextBox();

    }



    @And("KUllanici FirstName kutucugunu bos birakinca Your FirstName is required. uyarı mesajını görüntüler")
    public void kullaniciFirstNameKutucugunuBosBirakincaYourFirstNameIsRequiredUyarıMesajınıGörüntüle() {
        us001.firstNameRequiredMessage();
    }

    @And("Kullanici First Name kutucuğuna {string} olusan First Name girer")
    public void kullaniciFirstNameKutucuğunaOlusanFirstNameGirer(String arg0) {
        us001.hatalifirstName(arg0);
    }

    @And("Kullanici gecerli olmayan bir First Name girmesine ragmen kabul edildigini gorur")
    public void kullaniciGecerliOlmayanBirFirstNameGirmesineRagmenKabulEdildiginiGorur() {
        us001.firstNameValidConfirm();
    }

    @And("Kullanici First Name kutucuğuna karekterlerden ve rakamlardan olusan First Name girer")
    public void kullaniciFirstNameKutucuğunaKarekterlerdenVeRakamlardanOlusanFirstNameGirer() {
        us001.validfirstName();
    }

    @And("KUllanici LastName kutucugunu bos birakinca Your LastName is required. uyarı mesajını görüntüler")
    public void kullaniciLastNameKutucugunuBosBirakincaYourLastNameIsRequiredUyarıMesajınıGörüntüler() {
        us001.lastNameRequiredMessage();
    }

    @And("Kullanici Last Name kutucuğuna {string} olusan Last Name girer")
    public void kullaniciLastNameKutucuğunaOlusanLastNameGirer(String arg0) {
        us001.GecersizlastName(arg0);
    }

    @And("Kullanici gecerli olmayan bir Last Name girmesine ragmen kabul edildigini gorur")
    public void kullaniciGecerliOlmayanBirLastNameGirmesineRagmenKabulEdildiginiGorur() {
        us001.lastNameValidConfirm();
    }

    @And("Kullanici gecerli olan bir First Name girer ve kabul edildigini gorur")
    public void kullaniciGecerliOlanBirFirstNameGirerVeKabulEdildiginiGorur() {
        us001.validfirstName();
    }

    @And("Kullanici Last Name kutucuğuna karekterlerden ve rakamlardan olusan Last Name girer")
    public void kullaniciLastNameKutucuğunaKarekterlerdenVeRakamlardanOlusanLastNameGirer() {
        us001.GecerlilastName();
    }
}
