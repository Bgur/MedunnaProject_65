package stepDefinitions.Ui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.US002page;
import utilities.Driver;
import utilities.ReusableMethods;

import static utilities.ReusableMethods.*;

public class US002StepD {
    US002page us002=new US002page();
    @When("Kullanici UserName kutucuguna tiklar ardından boş bırakır")
    public void kullanici_user_name_kutucuguna_tiklar_ardından_boş_bırakır() {
       us002.userNameTextBox();
       waitFor(3);
       us002.emailTextBox();
    }
    @When("Kullanici Your UserName is required. uyarı mesajını görüntüler")
    public void kullanici_your_user_name_is_required_uyarı_mesajını_görüntüler() {
        us002.userNameRequiredMessage();

    }





    @Then("Kullanici harfler ve rakamlardan olusan herhangi bir karakter sinirlamasina tabi tutulmayan {string} girilir ve uyari mesaji alinmaz")
    public void kullaniciHarflerVeRakamlardanOlusanHerhangiBirKarakterSinirlamasinaTabiTutulmayanGirilirVeUyariMesajiAlinmaz(String username) {
        us002.GecerliUserName(username);
    }

    @And("Kullanici UserName kutucuguna tiklar")
    public void kullaniciUserNameKutucugunaTiklar() {
        us002.userNameTextBox();
    }







    @And("Kullanici harfler ve rakamlardan olusan herhangi bir karakter sinirlamasina tabi tutulmayan {string} girilir ve Your username is invalid. uyari mesaji gorulur")
    public void kullaniciHarflerVeRakamlardanOlusanHerhangiBirKarakterSinirlamasinaTabiTutulmayanGirilirVeYourUsernameIsInvalidUyariMesajiGorulur(String arg0) {
        us002.GecersizOUserName(arg0);
    }


    @And("Kullanici harfler ve rakamlardan olusan {string} girilirer. ve Your username is invalid. uyari mesaji gorulmez")
    public void kullaniciHarflerVeRakamlardanOlusanGirilirerVeYourUsernameIsInvalidUyariMesajiGorulur(String arg0) {
        us002.GecersizUserName(arg0);
    }

    @Then("Kullanici Email kutusuna tiklar")
    public void kullaniciEmailKutusunaTiklar() {
        us002.emailTextBox();
        waitFor(2);

    }

    @And("Kullanici Email kutusunu bos birakinca Your email is required. uyarı mesajını görüntüler")
    public void kullaniciEmailKutusunuBosBirakincaYourEmailIsRequiredUyarıMesajınıGörüntüler() {
        us002.userNameTextBox();
        us002.emailRequiredMessage();
    }


    @Then("Kullanici Email kutucuğuna bes karakterden az {string} yollandığında Your email is required to be at least five characters. uyarı mesajı görüntülenmeli")
    public void kullaniciemailKutucuğunaBesKarakterdenAzYollandığındaYourEmailIsRequiredToBeAtLeastFiveCharactersUyarıMesajıGörüntülenmeli(String arg0) {
        us002.GecersizEmail(arg0);
        us002.emailCharacterMessage();
        us002.userNameTextBox();
        ReusableMethods.waitFor(2);
        Driver.getDriver().navigate().refresh();
    }

    @And("Kullanici Email kutusuna ve . olmadan {string} girer.Ve This field is invalid mesajini alir")
    public void kullaniciEmailKutusunaVeOlmadanGirerVeThisFieldIsInvalidMesajiniAlir(String arg0) {
        us002.GecersizEmail(arg0);
        us002.emailInvalidMessage();
        us002.userNameTextBox();
        ReusableMethods.waitFor(2);
        Driver.getDriver().navigate().refresh();

    }


    @And("Kullanici Mail kutusuna ve @ olmadan {string} girer. This field is invalid mesajini alir")
    public void kullaniciMailKutusunaVeOlmadanGirerThisFieldIsInvalidMesajiniAlir(String arg0) {
        us002.GecersizEmail(arg0);
        us002.emailInvalidMessage();
        us002.userNameTextBox();
    }

    @And("Kullanici Email kutucuğuna mail adresi @ ve . karakterleri kullanarak {string} girer.")
    public void kullaniciEmailKutucuğunaMailAdresiVeKarakterleriKullanarakGirer(String arg0) {
        us002.GecerliEmail(arg0);
    }


    @And("Kullanici herhangi bir uyarı mesajı almaz")
    public void kullaniciHerhangiBirUyarıMesajıAlmaz() {
        us002.emailValidConfirm();
    }
}
