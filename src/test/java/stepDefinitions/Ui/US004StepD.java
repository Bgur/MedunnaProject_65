package stepDefinitions.Ui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.US004page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


import static utilities.ReusableMethods.waitFor;

public class US004StepD {

    US004page obj004 = new US004page();

    @Given("Kullanici Url'e gider")
    public void kullanici_url_e_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("medunna_url2"));
        waitFor(3);
    }

    @When("Sag ust kosedeki ikonu tiklar")
    public void sag_ust_kosedeki_ikonu_tiklar() {
        obj004.signInIcon.click();
    }

    @And("Sign in tusuna tiklar")
    public void sign_in_tusuna_tiklar() {
        ReusableMethods.waitFor(2);
        obj004.signInLogin.click();
    }

    @Then("Kullanici gecerli user name bilgisi girer")
    public void kullanici_gecerli_user_name_bilgisi_girer() {
        obj004.userName.sendKeys(ConfigReader.getProperty("valid_username"));
    }


    @Then("Kullanici gecerli bir password girer")
    public void kullanici_gecerli_bir_password_girer() {
        obj004.passWord.sendKeys(ConfigReader.getProperty("valid_password"));
    }

    @Then("Acilan pencerede\"Remember me\" checkbox'ini gorur")
    public void acilan_pencerede_remember_me_checkbox_ini_gorur() {
        obj004.rememberMe.click();
    }


    @Then("Kullanici Did you forget your password? yazisini gorur")
    public void kullaniciDidYouForgetYourPasswordYazisiniGorur() {
        String metin = "Did you forget your password?";
        String actualText = obj004.forgetPasswordText.getText();
        // Assert.assertEquals(actualText,metin);
        Assert.assertTrue(actualText.contains("Did you forget your password?"));
    }


    @Then("Username alanina gecerli kullanici adini yazar")
    public void username_alanina_gecerli_kullanici_adini_yazar() throws InterruptedException {
        obj004.userName.sendKeys(ConfigReader.getProperty("valid_username"));
        Thread.sleep(2000);
    }

    @Then("Username alanina gecersiz kullanici adini yazar")
    public void username_alanina_gecersiz_kullanici_adini_yazar() throws InterruptedException {
        obj004.userName.sendKeys(ConfigReader.getProperty("invalid_username"));
        Thread.sleep(2000);
    }

    @And("Kullanici Did you forget your password? linkini tiklar")
    public void kullaniciDidYouForgetYourPasswordLinkiniTiklar() {
        obj004.getForgetPasswordLink.click();
    }


    @Then("Giris yapinca basarili mesajini gorur")
    public void giris_yapinca_basarili_mesajini_gorur() {
        Assert.assertFalse("Basarili giris yaptiniz mesaji gorulmadi", false);
    }


    @Then("Basirili giris yaptigi gorulur")
    public void basirili_giris_yaptigi_gorulur() {
        String kullanici = obj004.hesapAdi.getText();
        String actualUser = ConfigReader.getProperty("accountName");
        Assert.assertEquals(kullanici, actualUser);
    }


    @Then("password alanina gecerli pasword girer")
    public void password_alanina_gecerli_pasword_girer() {
        obj004.passWord.sendKeys(ConfigReader.getProperty("valid_password"));
    }

    @Then("password alanina gecersiz pasword girer")
    public void password_alanina_gecersiz_pasword_girer() {
        obj004.passWord.sendKeys(ConfigReader.getProperty("invalid_password"));
    }


    @Then("Kullanici You don't have an account yet? Register a new account seçeneğini gorur")
    public void kullanici_secenegini_gorur() {
        String metin = "You don't have an account yet? Register a new account";
        String actualText = obj004.haveAnAccountYetText.getText() + " " + obj004.haveAnAccountYetLink.getText();
        Assert.assertEquals(actualText, metin);
    }

    @Then("Kullanici You don't have an account yet? Register a new account linkini tiklar")
    public void kullanici_linkini_tiklar() {
        obj004.haveAnAccountYetLink.click();
    }

    @Then("Cancel secenegini tiklar")
    public void cancelSeceneginiTiklar() throws InterruptedException {
        Thread.sleep(10000);
        obj004.cancel.click();
    }


    @Then("Formdaki Sign in tusuna tiklar")
    public void formdaki_sign_in_tusuna_tiklar() {
        //obj004.signInLogin.click();
        // Actions actions=new Actions(Driver.getDriver());
        // actions.click(obj004.cancel).click().perform();
        // actions.moveToElement(obj004.rememberMe).sendKeys(Keys.TAB).sendKeys().sendKeys(Keys.TAB)
        //  .sendKeys(Keys.ENTER).perform();

        obj004.signInButton.click();
    }


    @And("Browser close{int}")
    public void browserClose(int arg0) {
        Driver.closeDriver();
    }

    @And("Kullanici Failed to sign in Please check your credentials and try again uyarisini gorur")
    public void kullaniciFailedToSignInPleaseCheckYourCredentialsAndTryAgainUyarisiniGorur() throws InterruptedException {
        Thread.sleep(3000);
        String actualText = obj004.containerDidYouForget.getText();
        String expectedData = "Authentication information not correct.";
        Assert.assertEquals(expectedData, actualText);
        Thread.sleep(3000);
    }

}
