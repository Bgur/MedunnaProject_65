package stepDefinitions.Ui;


import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.US20_pages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class US20StepD {
    US20_pages us20_pages=new US20_pages();
    Actions actions=new Actions(Driver.getDriver());
    Faker faker=new Faker();
    String fakerPassword;
    JavascriptExecutor jse = ((JavascriptExecutor) Driver.getDriver());


    @Given("Admin Ustteki menulerden {string} secenegine tiklanmalidir.")
    public void admin_Ustteki_menulerden_secenegine_tiklanmalidir(String string) {
        //us20_pages.administrationButonu.click();
        Driver.waitAndClick(us20_pages.administrationButonu);
    }

    @Given("Admin Acilan sekmeden {string} secenegi secilmelidir.")
    public void admin_acilan_sekmeden_secenegi_secilmelidir(String string) {
        Driver.waitAndClick(us20_pages.userManagementButonu);
        System.out.println("Admin Acilan sekmeden {string} secenegi secilmelidir.");

    }

    @Given("Admin Acilan sekmenin Users sayfasi oldugunu dogrulamalidir.")
    public void admin_acilan_sekmenin_users_sayfasi_oldugunu_dogrulamalidir() {
        String actualText=Driver.waitAndGetText(us20_pages.usersPageText,2);
        String expectedText="Users";
        Assert.assertEquals("Users Sayfasina ulasilamadi",expectedText,actualText);

    }


    @Given("Admin Gormek istedigi kayitli kisinin uzerine gelip en sagda bulunan {string} butonuna tiklanmalidir.")
    public void admin_gormek_istedigi_kayitli_kisinin_uzerine_gelip_en_sagda_bulunan_butonuna_tiklanmalidir(String string) {
        ReusableMethods.waitFor(2);
        // us20_pages.usersPageText.click();
        // actions.keyDown(Keys.CONTROL).sendKeys(Keys.getKeyFromUnicode('f')).keyUp(Keys.CONTROL).build().perform();

        us20_pages.viewButonu.click();
        //  Driver.waitAndClick(us20_pages.viewButonu);
    }

    @Given("Admin First name bilgisi gorunur olmalidir.")
    public void admin_first_name_bilgisi_gorunur_olmalidir() {
        ReusableMethods.waitFor(2);
        Assert.assertTrue(us20_pages.firstnameText.isDisplayed());

    }

    @Given("Admin Last name bilgisi gorunur olmalidir.")
    public void admin_last_name_bilgisi_gorunur_olmalidir() {
        ReusableMethods.waitFor(1);
        Assert.assertTrue(us20_pages.lastnameText.isDisplayed());

    }

    @Given("Admin Email bilgisi gorunur olmalidir.")
    public void admin_email_bilgisi_gorunur_olmalidir() {
        ReusableMethods.waitFor(1);
        Assert.assertTrue(us20_pages.emailText.isDisplayed());

    }
    @Given("Admin Profiles durumu gorunur olmalidir.")
    public void admin_profiles_durumu_gorunur_olmalidir() {
        ReusableMethods.waitFor(1);
        ReusableMethods.hooverByJS(us20_pages.profilesText);
        ReusableMethods.waitFor(1);
        Assert.assertTrue(us20_pages.profilesText.isDisplayed());
    }
    @Given("Admin Sign out butonuna basarak cikis yapmalidir.")
    public void admin_sign_out_butonuna_basarak_cikis_yapmalidir() {
        us20_pages.Team65Butonu.click();
        ReusableMethods.waitFor(2);
        us20_pages.signOutButonu.click();

    }
    @Given("Admin {string} olmayan ilk kullaniciyi bulup edit butonuna tiklar")
    public void Admin_string_olmayan_ilk_kullaniciyi_bulur(String role) {



        for (int i = 19; i <=20 ; i++) {//bir sayfada goruntulenen toplam profil sayisi kadar bir dongu olusturuyoruz
            Driver.wait(1);
            WebElement profileDurumuElementi=(Driver.getDriver().findElement(By.xpath("(//td[7])["+i+"]")));


            if
            (profileDurumuElementi.getText().contains(role)){//rolu admin olmayan ilk kisiyi bulur

                System.out.println(i+". kullanicinin adi= "+Driver.getDriver().findElement(By.xpath("(//td[2])["+i+"]")).getText() );
                if (i>10){//10. kisiden sonra islem yapmak icin scroll yapmak gerektiginden bu sekilde bir kosul olusturduk
                    JSUtils.clickElementByJS(Driver.getDriver().findElement(By.xpath("(//*[text()='Edit'])["+i+"]")));
                }
                else{Driver.getDriver()//10. kisiden once istenen kosul elde edilirse bu kosul devreye giriyor
                        .findElement(By.xpath("(//*[text()='Edit'])["+i+"]")).click();}





                break;
            }
            else if (i==20){//eger bir sayfa icinde herkes aranan rolde ise bir sonraki sayfaya gecis yapmak icin next butonuna tikliyoruz
                jse.executeScript("arguments[0].click();",Driver.getDriver().findElement(By.xpath("//span[contains(.,'›')]")));

                i=1;//sonraki sayfaya gidildiginde bastan baslanacagi icin forloopu baslangic degerine getiriyoruz
                Driver.wait(1);

            }
            else {  System.out.println("i degeri==================================== "+i);


            }


            Driver.wait(1);

            System.out.println(profileDurumuElementi.getText());
        }
    }



    @Given("Admin rol atamasi yapmak istedigi kisinin uzerine gelip en sagda bulunan {string} butonuna tiklamalidir.")
    public void admin_rol_atamasi_yapmak_istedigi_kisinin_uzerine_gelip_en_sagda_bulunan_butonuna_tiklamalidir(String string) {

        Driver.waitAndClick(us20_pages.editButonu,2);
    }
    @Given("Admin acilan sayfadan {string} secenegine tiklar")
    public void Admin_acilan_sayfadan_ROLE_ADMIN_secenegine_tiklar(String role2) {
        switch (role2) {
            case "ROLE_ADMIN":
                Driver.wait(1);
                ReusableMethods.hooverByJS(us20_pages.roleAdmin);
                Driver.waitAndClick(us20_pages.roleAdmin);

            case "ROLE_USER":
                Driver.wait(1);
                ReusableMethods.hooverByJS(us20_pages.roleUser);
                Driver.waitAndClick(us20_pages.roleUser);

            case "ROLE_PATIENT":
                Driver.wait(1);
                ReusableMethods.hooverByJS(us20_pages.rolePatient);
                Driver.waitAndClick(us20_pages.rolePatient);

            case "ROLE_STAFF":
                Driver.wait(1);
                ReusableMethods.hooverByJS(us20_pages.roleStaff);
                Driver.waitAndClick(us20_pages.roleStaff);
            case "ROLE_PHYSICIAN":
                Driver.wait(1);
                ReusableMethods.hooverByJS(us20_pages.rolePhysician);
                Driver.waitAndClick(us20_pages.rolePhysician);
            default:
                break;


        }


    }



    @Given("Admin {string} sayfasinin acildigini dogrulamaldiir.")
    public void admin_sayfasinin_acildigini_dogrulamaldiir(String string) {
        String actualText=us20_pages.createEditUserPagesText.getText();
        String expectedText="Create or edit a user";
        System.out.println("expected text yazisi : "+expectedText);
        Assert.assertTrue(expectedText.equals(actualText));
    }

    @Given("Admin Acilan sayfada {string} kismina gelip dropdowndan rol atamasi yapabilmelidir.")
    public void admin_acilan_sayfada_kismina_gelip_dropdowndan_rol_atamasi_yapabilmelidir(String string) {
        ReusableMethods.jsScroll();
       // ReusableMethods.hooverByJS(us20_pages.rolePatient);
        Driver.waitAndClick(us20_pages.rolePatient);

        // ReusableMethods.hooverByJS(us20_pages.roleAdmin);
        // ReusableMethods.hooverByJS(us20_pages.roleStaff);
        // ReusableMethods.hooverByJS(us20_pages.rolePhysician);
        // ReusableMethods.hooverByJS(us20_pages.roleUser);

    }

    @Given("Admin Save butonuna basmalidir.")
    public void admin_save_butonuna_basmalidir() {
        Driver.waitAndClick(us20_pages.savebutonu);


    }

    @Given("Admin {string} yazisinin ciktigini dogrulamalidir.")
    public void admin_yazisinin_ciktigini_dogrulamalidir(String string) {
        String actualText= Driver.waitAndGetText(us20_pages.editToastContainerText, 4);
        System.out.println("toast Container yazisi : "+actualText);
        String expectedText ="A user is updated with identifier";


        Assert.assertTrue("Edit işleminde sorun oluştu ",actualText.contains(expectedText));

    }



    @Given("Admin silmek istedigi kullanicinin ustune en sagda bulunan {string} butonuna tiklamalidir.")
    public void admin_silmek_istedigi_kullanicinin_ustune_en_sagda_bulunan_butonuna_tiklamalidir(String string) {

        Driver.waitAndClick(us20_pages.deleteButonu,2);





    }
    @Given("Admin Yukarida cikan popup uzerindeki {string} butonuna tiklanmalidir.")
    public void admin_yukarida_cikan_popup_uzerindeki_butonuna_tiklanmalidir(String string) {
        //  String actualPopupText=us20_pages.deletePopupText.getText();
        //  System.out.println("popup yazisi : "+actualPopupText);
        //  String expectedPopupText="Are you sure you want to delete user";
        //  Assert.assertTrue("Delete işlemi siraisinda sorun oluştu ",actualPopupText.contains(expectedPopupText));

        Driver.waitAndClick(us20_pages.deletePopupDeleteButonu);
    }

    @Given("Admin A user is deleted with identifier yazisinin ciktigini dogrulamalidir.")
    public void admin_a_user_is_deleted_with_identifier_yazisinin_ciktigini_dogrulamalidir() {
        String actualText=Driver.waitAndGetText(us20_pages.deleteToastContainerText,2);
        System.out.println("Delete toast Container yazisi : "+actualText);
        String expectedText ="A user is deleted with identifier";
        String expectedText2 ="Internal server error.";
        ReusableMethods.waitFor(2);

       // try {
            Assert.assertTrue("Delete işleminde sorun oluştu ",actualText.contains(expectedText));

//        }catch (AssertionError e){
//            Assert.assertTrue("Delete işleminde sorun oluştu ",actualText.contains(expectedText2));
//            System.out.println("User icin DELETE işlemi gercekleşmedi ==>"+expectedText2);
//        }

    }

    @Given("Admin {string} adresine gider")
    public void admin_adresine_gider(String url) {
        if (Driver.getDriver()!=null)
        {Driver.getDriver().get(ConfigReader.getProperty(url));
        Driver.waitForPageToLoad(3);
        String actualTitle=Driver.getDriver().getTitle();
        System.out.println(actualTitle);
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String name= "fert";}
        else {Driver.closeDriver();}

//        String expectedTitle="MEDUNNA";
//        Assert.assertEquals("MEDUNNA sayfasina gidilemedi",expectedTitle,actualTitle);
    }
    @Given("Admin Sayfanin en Ust sag kismindaki Profile Ikonu'na Tiklanir.")
    public void admin_sayfanin_en_Ust_sag_kismindaki_profile_ikonu_na_tiklanir() {

        Driver.waitAndClick(us20_pages.profilIkonuButonu);


    }
    @Then("Admin Acilan sekmeden Sign in sececegi secilmelidir.")
    public void admin_acilan_sekmeden_sign_in_sececegi_secilmelidir() {
        //  Assert.assertTrue(us10Pages.signInButonu.isDisplayed());

        Driver.waitAndClick(us20_pages.signInButonu);

    }

    @Then("Admin Kullanici kayitli oldugu {string} i girmelidir.")
    public void adminKullaniciKayitliOlduguIGirmelidir(String AdminUsername) {

        Driver.waitAndSendText(us20_pages.signInUsernameTextBox,ConfigReader.getProperty(AdminUsername));


    }
    @Then("Admin Kullanici kayitli oldugu {string} u girmelidir.")
    public void adminKullaniciKayitliOlduguUGirmelidir(String AdminPassword) {
        us20_pages.signInPasswordTextBox.sendKeys(ConfigReader.getProperty(AdminPassword));

    }
    @Given("Admin kullanici Sign in butonuna basar.")
    public void admin_kullanici_sign_in_butonuna_basar() {

        //  Assert.assertTrue(us10Pages.signInsignInButonu.isDisplayed());
        // ReusableMethods.waitFor(1);
        us20_pages.signInsignInButonu.click();
    }
    @Given("Admin Sayfa kapatilir.")
    public void adminSayfaKapatilir() {
        ReusableMethods.waitFor(2);
        Driver.closeDriver();
    }



}
