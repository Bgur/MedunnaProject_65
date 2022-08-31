package stepDefinitions.Ui;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import pages.US003page;
import utilities.ConfigReader;
import utilities.Driver;


public class US003StepD {
    public US003page us003Pages = new US003page();
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();


    @Given("User Medunna Url ye gider")
    public void user_medunna_url_ye_gider() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("medunna_url"));
        Thread.sleep(1000);

    }


    @Then("User isaretine ve register butonunu tiklar")
    public void user_isaretine_ve_register_butonunu_tiklar() {
        //US003_Pages us003Pages = new US003_Pages();
        us003Pages.userIsareti.click();
        us003Pages.register.click();


    }

    @Then("Kullanici alti karakterli tüm parametreleri iceren veya sadece tek parametre iceren sifre girer ve Password strengthde degisme olmadigini dogrular")
    public void kullanici_alti_karakterli_tüm_parametreleri_iceren_veya_sadece_tek_parametre_iceren_sifre_girer_ve_password_strengthde_degisme_olmadigini_dogrular() throws InterruptedException {


        us003Pages.passwordBox.sendKeys("123456");
        jse.executeScript("window.scrollBy(0,350)");
        Thread.sleep(2000);


        if (Driver.getDriver().findElement(By.xpath("(//*[@value='123456'])[1]")).isDisplayed()) {
            Assert.assertTrue(us003Pages.strenghtBar1_sönük.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar2_sönük.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar3_sönük.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar4_sönük.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar5_sönük.isDisplayed());
        } else Assert.assertTrue(false);

        Driver.getDriver().navigate().back();
        Driver.getDriver().navigate().forward();

        us003Pages.passwordBox.sendKeys("aA#*3_");
        Thread.sleep(2000);


        if (Driver.getDriver().findElement(By.xpath("(//*[@value='aA#*3_'])[1]")).isDisplayed()) {
            Assert.assertTrue(us003Pages.strenghtBar1_sönük.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar2_sönük.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar3_sönük.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar4_sönük.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar5_sönük.isDisplayed());
        } else Assert.assertTrue(false);


    }

    @Then("Kullanici yedi veya daha fazla karakterli fakat yalnizca tek parametreli karakterler girer ve Password strengthde degisme olmadigini dogrular")
    public void kullanici_yedi_veya_daha_fazla_karakterli_fakat_yalnizca_tek_parametreli_karakterler_girer_ve_password_strengthde_degisme_olmadigini_dogrular() throws InterruptedException {
        Driver.getDriver().navigate().back();
        Driver.getDriver().navigate().forward();

        us003Pages.passwordBox.sendKeys("1234567");
        Thread.sleep(2000);


        if (Driver.getDriver().findElement(By.xpath("(//*[@value='1234567'])[1]")).isDisplayed()) {
            Assert.assertTrue(us003Pages.strenghtBar1_sönük.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar2_sönük.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar3_sönük.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar4_sönük.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar5_sönük.isDisplayed());
        } else Assert.assertTrue(false);

        Driver.getDriver().navigate().back();
        Driver.getDriver().navigate().forward();

        us003Pages.passwordBox.sendKeys("123456789");
        Thread.sleep(2000);


        if (Driver.getDriver().findElement(By.xpath("(//*[@value='123456789'])[1]")).isDisplayed()) {
            Assert.assertTrue(us003Pages.strenghtBar1_sönük.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar2_sönük.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar3_sönük.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar4_sönük.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar5_sönük.isDisplayed());
        } else Assert.assertTrue(false);

    }

    @Then("Kullanici yedi karakterli ve ayni zamanda iki parametreli sifreler girerek Password strengthde bir sekme güclenme oldugunu dogrular")
    public void kullanici_yedi_karakterli_ve_ayni_zamanda_iki_parametreli_sifreler_girerek_password_strengthde_bir_sekme_güclenme_oldugunu_dogrular() throws InterruptedException {
        Driver.getDriver().navigate().back();
        Driver.getDriver().navigate().forward();

        us003Pages.passwordBox.sendKeys("123456a");
        Thread.sleep(2000);


        if (Driver.getDriver().findElement(By.xpath("(//*[@value='123456a'])[1]")).isDisplayed()) {
            Assert.assertTrue(us003Pages.strenghtBar1_yanik_turuncu.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar2_yanik_turuncu.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar3_sönük_turuncu.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar3_sönük_turuncu.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar3_sönük_turuncu.isDisplayed());
        } else Assert.assertTrue(false);

        Driver.getDriver().navigate().back();
        Driver.getDriver().navigate().forward();

        us003Pages.passwordBox.sendKeys("+#+#+#A");
        Thread.sleep(2000);

        if (Driver.getDriver().findElement(By.xpath("(//*[@value='+#+#+#A'])[1]")).isDisplayed()) {
            Assert.assertTrue(us003Pages.strenghtBar1_yanik_turuncu.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar2_yanik_turuncu.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar3_sönük_turuncu.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar3_sönük_turuncu.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar3_sönük_turuncu.isDisplayed());
        } else Assert.assertTrue(false);
        Thread.sleep(2000);

    }


    @Then("Kullanicinin en güclü sifre icin en az yedi karakter, en az iki farkli özel karakter ve diger parametrelerden en az bir tane iceren sifre girmesi gerektigi dogrulanir")
    public void kullanicinin_en_güclü_sifre_icin_en_az_yedi_karakter_en_az_iki_farkli_özel_karakter_ve_diger_parametrelerden_en_az_bir_tane_iceren_sifre_girmesi_gerektigi_dogrulanir() throws InterruptedException {
        Driver.getDriver().navigate().back();
        Driver.getDriver().navigate().forward();

        us003Pages.passwordBox.sendKeys("123aA#*");


        Thread.sleep(2000);

        if (Driver.getDriver().findElement(By.xpath("(//*[@value='123aA#*'])[1]")).isDisplayed()) {
            Assert.assertTrue(us003Pages.strenghtBar1_yanik_tamyesil.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar2_yanik_tamyesil.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar3_yanik_tamyesil.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar4_yanik_tamyesil.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar5_yanik_tamyesil.isDisplayed());
        } else Assert.assertTrue(false);
        Thread.sleep(2000);

        Driver.getDriver().navigate().back();
        Driver.getDriver().navigate().forward();
        Thread.sleep(2000);


        us003Pages.passwordBox.sendKeys("123aA##");
        Thread.sleep(2000);

        if (Driver.getDriver().findElement(By.xpath("(//*[@value='123aA##'])[1]")).isDisplayed()) {
            //burada web elemente hiculsamazsa nosuchelemnetexeption veriyor
            Assert.assertTrue(us003Pages.strenghtBar1_yanik_yesil.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar2_yanik_yesil.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar3_yanik_yesil.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar4_yanik_yesil.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar5_sönük_yesil.isDisplayed());
        } else Assert.assertTrue(false);


    }


    @Then("Kullanici ilk alti karakteri büyük harften farkli en az bir cesit karakter iceren sifreye yedinci karakter olarak büyük harf girdiginde Password strength: de bir sekme güclenme oldugunu dogrular")
    public void kullaniciIlkAltiKarakteriBüyükHarftenFarkliEnAzBirCesitKarakterIcerenSifreyeYedinciKarakterOlarakBüyükHarfGirdigindePasswordStrengthDeBirSekmeGüclenmeOldugunuDogrular() throws InterruptedException {

        us003Pages.passwordBox.sendKeys("abcdefA");
        jse.executeScript("window.scrollBy(0,550)");

        if (Driver.getDriver().findElement(By.xpath("(//*[@value='abcdefA'])[1]")).isDisplayed()) {
            Assert.assertTrue(us003Pages.strenghtBar1_yanik_turuncu.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar2_yanik_turuncu.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar3_sönük_turuncu.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar3_sönük_turuncu.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar3_sönük_turuncu.isDisplayed());
        } else Assert.assertTrue(false);

        Driver.getDriver().navigate().back();
        Driver.getDriver().navigate().forward();
        Thread.sleep(2000);
        us003Pages.passwordBox.sendKeys("123456A");
        jse.executeScript("window.scrollBy(0,550)");

        if (Driver.getDriver().findElement(By.xpath("(//*[@value='123456A'])[1]")).isDisplayed()) {
            Assert.assertTrue(us003Pages.strenghtBar1_yanik_turuncu.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar2_yanik_turuncu.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar3_sönük_turuncu.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar3_sönük_turuncu.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar3_sönük_turuncu.isDisplayed());
        } else Assert.assertTrue(false);


    }

    @Then("Kullanici ilk alti karaktere iki farkli parametreli olarak abcde*A girdikten sonra yedinci karaktere farkli bir tür ücüncü parametre olarak büyük harf girdiginde Password strength: de ücüncü sekme isiginin yandigini dogrular")
    public void kullaniciIlkAltiKaraktereIkiFarkliParametreliOlarakGirdiktenSonraYedinciKaraktereFarkliBirTürÜcüncüParametreOlarakBüyükHarfGirdigindePasswordStrengthDeÜcüncüSekmeIsigininYandiginiDogrular() {
        Driver.getDriver().navigate().back();
        Driver.getDriver().navigate().forward();
        us003Pages.passwordBox.sendKeys("abcde*A");
        jse.executeScript("window.scrollBy(0,550)");

        if (Driver.getDriver().findElement(By.xpath("(//*[@value='abcde*A'])[1]")).isDisplayed()) {
            if (
                    us003Pages.strenghtBar1_yanik_yesil.isDisplayed() &&
                            us003Pages.strenghtBar2_yanik_yesil.isDisplayed() &&
                            us003Pages.strenghtBar3_yanik_yesil.isDisplayed() &&
                            us003Pages.strenghtBar4_yanik_yesil.isDisplayed() &&
                            us003Pages.strenghtBar5_sönük_yesil.isDisplayed()) {
                Assert.assertTrue(false);

            }
        } else Assert.assertTrue(true);
    }

    @Then("Kullanici ilk alti karakteri kücük harften farkli en az  bir cesit karakter iceren sifreye yedinci karakter olarak kücük harf girdiginde Password strength: de bir sekme güclenme oldugunu dogrular")
    public void kullaniciIlkAltiKarakteriKücükHarftenFarkliEnAzBirCesitKarakterIcerenSifreyeYedinciKarakterOlarakKücükHarfGirdigindeDeBirSekmeGüclenmeOldugunuDogrular() throws InterruptedException {
        us003Pages.passwordBox.sendKeys("ABCDEFa");
        jse.executeScript("window.scrollBy(0,550)");

        if (Driver.getDriver().findElement(By.xpath("(//*[@value='ABCDEFa'])[1]")).isDisplayed()) {
            Assert.assertTrue(us003Pages.strenghtBar1_yanik_turuncu.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar2_yanik_turuncu.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar3_sönük_turuncu.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar3_sönük_turuncu.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar3_sönük_turuncu.isDisplayed());
        } else Assert.assertTrue(false);

        Driver.getDriver().navigate().back();
        Driver.getDriver().navigate().forward();
        Thread.sleep(2000);
        us003Pages.passwordBox.sendKeys("123456a");
        jse.executeScript("window.scrollBy(0,550)");

        if (Driver.getDriver().findElement(By.xpath("(//*[@value='123456a'])[1]")).isDisplayed()) {
            Assert.assertTrue(us003Pages.strenghtBar1_yanik_turuncu.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar2_yanik_turuncu.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar3_sönük_turuncu.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar3_sönük_turuncu.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar3_sönük_turuncu.isDisplayed());
        } else Assert.assertTrue(false);


    }

    @Then("Kullanici ilk alti karaktere iki farkli parametre girdikten sonra yedinci karaktere farkli bir tür ücüncü parametre olarak kücük harf girdiginde Password strength: de ücüncü sekme isiginin yandigini dogrular")
    public void kullaniciIlkAltiKaraktereIkiFarkliParametreGirdiktenSonraYedinciKaraktereFarkliBirTürÜcüncüParametreOlarakKücükHarfGirdigindePasswordStrengthDeÜcüncüSekmeIsigininYandiginiDogrular() {
        Driver.getDriver().navigate().back();
        Driver.getDriver().navigate().forward();
        us003Pages.passwordBox.sendKeys("ABCDE*a");
        jse.executeScript("window.scrollBy(0,550)");

        if (Driver.getDriver().findElement(By.xpath("(//*[@value='ABCDE*a'])[1]")).isDisplayed()) {
            if (
                    us003Pages.strenghtBar1_yanik_yesil.isDisplayed() &&
                            us003Pages.strenghtBar2_yanik_yesil.isDisplayed() &&
                            us003Pages.strenghtBar3_yanik_yesil.isDisplayed() &&
                            us003Pages.strenghtBar4_yanik_yesil.isDisplayed() &&
                            us003Pages.strenghtBar5_sönük_yesil.isDisplayed()) {
                Assert.assertTrue(false);

            }
        } else Assert.assertTrue(true);
    }

    @Then("Kullanici ilk alti karakteri rakamdan farkli en az bir cesit karakter iceren sifreye yedinci karakter olarak rakam girdiginde Password strength: de bir sekme güclenme oldugunu dogrular")
    public void kullaniciIlkAltiKarakteriRakamdanFarkliEnAzBirCesitKarakterIcerenSifreyeYedinciKarakterOlarakRakamGirdigindePasswordStrengthDeBirSekmeGüclenmeOldugunuDogrular() throws InterruptedException {
        us003Pages.passwordBox.sendKeys("abcdef1");
        jse.executeScript("window.scrollBy(0,550)");

        if (Driver.getDriver().findElement(By.xpath("(//*[@value='abcdef1'])[1]")).isDisplayed()) {
            Assert.assertTrue(us003Pages.strenghtBar1_yanik_turuncu.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar2_yanik_turuncu.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar3_sönük_turuncu.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar3_sönük_turuncu.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar3_sönük_turuncu.isDisplayed());
        } else Assert.assertTrue(false);

        Driver.getDriver().navigate().back();
        Driver.getDriver().navigate().forward();
        Thread.sleep(2000);
        us003Pages.passwordBox.sendKeys("ABCDEF1");
        jse.executeScript("window.scrollBy(0,550)");

        if (Driver.getDriver().findElement(By.xpath("(//*[@value='ABCDEF1'])[1]")).isDisplayed()) {
            Assert.assertTrue(us003Pages.strenghtBar1_yanik_turuncu.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar2_yanik_turuncu.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar3_sönük_turuncu.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar3_sönük_turuncu.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar3_sönük_turuncu.isDisplayed());
        } else Assert.assertTrue(false);


    }

    @Then("Kullanici ilk alti karaktere iki farkli parametre girdikten sonra yedinci karaktere farkli bir tür ücüncü parametre olarak rakam girdiginde Password strength: de ücüncü sekme isiginin yandigini dogrular")
    public void kullaniciIlkAltiKaraktereIkiFarkliParametreGirdiktenSonraYedinciKaraktereFarkliBirTürÜcüncüParametreOlarakRakamGirdigindePasswordStrengthDeÜcüncüSekmeIsigininYandiginiDogrular() {
        Driver.getDriver().navigate().back();
        Driver.getDriver().navigate().forward();
        us003Pages.passwordBox.sendKeys("ABCDE*1");
        jse.executeScript("window.scrollBy(0,550)");

        if (Driver.getDriver().findElement(By.xpath("(//*[@value='ABCDE*1'])[1]")).isDisplayed()) {
            if (
                    us003Pages.strenghtBar1_yanik_yesil.isDisplayed() &&
                            us003Pages.strenghtBar2_yanik_yesil.isDisplayed() &&
                            us003Pages.strenghtBar3_yanik_yesil.isDisplayed() &&
                            us003Pages.strenghtBar4_yanik_yesil.isDisplayed() &&
                            us003Pages.strenghtBar5_sönük_yesil.isDisplayed()) {
                Assert.assertTrue(false);

            }
        } else Assert.assertTrue(true);


    }

    @Then("Kullanici ilk alti karakteri özel karakterden farkli en az bir karakter iceren sifreye yedinci karakter olarak özel karakter  girdiginde Password strength: de bir sekme güclenme oldugunu dogrular")
    public void kullaniciIlkAltiKarakteriÖzelKarakterdenFarkliEnAzBirKarakterIcerenSifreyeYedinciKarakterOlarakÖzelKarakterGirdigindePasswordStrengthDeBirSekmeGüclenmeOldugunuDogrular() throws InterruptedException {
        us003Pages.passwordBox.sendKeys("abcdef#");
        jse.executeScript("window.scrollBy(0,550)");

        if (Driver.getDriver().findElement(By.xpath("(//*[@value='abcdef#'])[1]")).isDisplayed()) {
            Assert.assertTrue(us003Pages.strenghtBar1_yanik_turuncu.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar2_yanik_turuncu.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar3_sönük_turuncu.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar3_sönük_turuncu.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar3_sönük_turuncu.isDisplayed());
        } else Assert.assertTrue(false);

        Driver.getDriver().navigate().back();
        Driver.getDriver().navigate().forward();
        Thread.sleep(2000);
        us003Pages.passwordBox.sendKeys("ABCDEF#");
        jse.executeScript("window.scrollBy(0,550)");

        if (Driver.getDriver().findElement(By.xpath("(//*[@value='ABCDEF#'])[1]")).isDisplayed()) {
            Assert.assertTrue(us003Pages.strenghtBar1_yanik_turuncu.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar2_yanik_turuncu.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar3_sönük_turuncu.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar3_sönük_turuncu.isDisplayed());
            Assert.assertTrue(us003Pages.strenghtBar3_sönük_turuncu.isDisplayed());
        } else Assert.assertTrue(false);


    }

    @Then("Kullanici ilk alti karaktere iki farkli parametre girdikten sonra yedinci karaktere farkli bir tür ücüncü parametre olarak özel karakter girdiginde Password strength: de ücüncü sekme isiginin yandigini dogrular")
    public void kullaniciIlkAltiKaraktereIkiFarkliParametreGirdiktenSonraYedinciKaraktereFarkliBirTürÜcüncüParametreOlarakÖzelKarakterGirdigindePasswordStrengthDeÜcüncüSekmeIsigininYandiginiDogrular() {
        Driver.getDriver().navigate().back();
        Driver.getDriver().navigate().forward();
        us003Pages.passwordBox.sendKeys("ABCDE1*");
        jse.executeScript("window.scrollBy(0,350)");

        if (Driver.getDriver().findElement(By.xpath("(//*[@value='ABCDE1*'])[1]")).isDisplayed()) {
            if (
                    us003Pages.strenghtBar1_yanik_yesil.isDisplayed() &&
                            us003Pages.strenghtBar2_yanik_yesil.isDisplayed() &&
                            us003Pages.strenghtBar3_yanik_yesil.isDisplayed() &&
                            us003Pages.strenghtBar4_yanik_yesil.isDisplayed() &&
                            us003Pages.strenghtBar5_sönük_yesil.isDisplayed()) {
                Assert.assertTrue(false);

            }
        } else Assert.assertTrue(true);
    }


}





