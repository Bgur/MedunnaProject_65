package stepDefinitions.Ui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.US014page;
import pages.US027page;
import pojos.Messages;
import utilities.*;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class US027StepD {



    US027page medunnaPage27=new US027page();
    US014page medunnaPage=new US014page();

    List<WebElement> messagesSatirList;

    int counter =1;

    @Given("Admin27  Medunna internet sitesine gider")
    public void admin27_medunna_internet_sitesine_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("base_url"));
    }
    @When("Admin27 anasayfa sag ust kosede bulunan kullanici ikonunu tiklar")
    public void admin27_anasayfa_sag_ust_kosede_bulunan_kullanici_ikonunu_tiklar() {
        medunnaPage27.kullaniciIkonuElementi.click();
    }
    @When("Admin27 acilan dropdown menuden  {string} sekmesini secer")
    public void admin27_acilan_dropdown_menuden_sekmesini_secer(String string) {
        medunnaPage27.signInElementi.click();
    }
    @And("Admin{int} acilan sayfada {string} ve {string} girerek kendi sayfasina erisir")
    public void adminAcilanSayfadaVeGirerekKendiSayfasinaErisir(int arg0, String arg1, String arg2) throws InterruptedException {
        medunnaPage27.kullaniciAdiGirisiElementi.sendKeys("Team65", Keys.TAB);
        medunnaPage27.sifreGirisiElementi.sendKeys("Team65.");


        medunnaPage27.ikinciSignInElementi.click();

        Thread.sleep(2000);

    }

    @When("Admin27 giris yaptigi sayfada {string} butonuna tiklar")
    public void admin27_giris_yaptigi_sayfada_butonuna_tiklar(String string) {
        medunnaPage27.itemsAndTitlesElementi27.click();
    }

    @When("Admin27 acilan dropdown menuden {string} i secer")
    public void admin27_acilan_dropdown_menuden_i_secer(String string) {
        medunnaPage27.messagesDropDownElementi.click();
    }

    @Then("Admin27 mesajlar bolumunde ID, name, email, subject, message  basliklarinin ve iceriklerinin tamaminin gorunur oldugunu dogrular")
    public void admin27_mesajlar_bolumunde_id_name_email_subject_message_basliklarinin_ve_iceriklerinin_tamaminin_gorunur_oldugunu_dogrular() throws Exception {
        Thread.sleep(2000);
        Assert.assertTrue(medunnaPage27.messagesMessageElementi.isDisplayed());
        Assert.assertTrue(medunnaPage27.messagesIdElementi.isDisplayed());
        Assert.assertTrue(medunnaPage27.messagesEmailElementi.isDisplayed());
        Assert.assertTrue(medunnaPage27.messagesSubjectElementi.isDisplayed());
        Assert.assertTrue(medunnaPage27.messagesNameElementi.isDisplayed());
        Assert.assertTrue(medunnaPage27.copyrightElementi.isDisplayed());



        Actions actions=new Actions(Driver.getDriver());
        Response response=ApiUtils.getRequest(Authentication.generateToken(),"https://medunna.com/api/c-messages?size=1000");
        ObjectMapper obj=new ObjectMapper();
        Messages [] messages=obj.readValue(response.asString(),Messages [].class);

        int pageDownTekrarSayisi=(messages.length)/8;



        for (int i = 0; i <pageDownTekrarSayisi ; i++) {
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            Thread.sleep(2000);
        }


        messagesSatirList=Driver.getDriver().findElements(By.xpath("//table//tbody//tr"));



        List <String> tekrarsizList=new ArrayList<>();
        for (int i = 0; i <messagesSatirList.size() ; i++) {
            if (!tekrarsizList.contains(messagesSatirList.get(i))){
                tekrarsizList.add(messagesSatirList.get(i).getText());
            }
        }
        System.out.println("UI mesaj sayisi: "+tekrarsizList.size());

        response=ApiUtils.getRequest(Authentication.generateToken(),"https://medunna.com/api/c-messages?=size=1000");

        obj=new ObjectMapper();
         messages =obj.readValue(response.asString(),Messages [].class);
        System.out.println("API mesaj sayisi: "+messages.length);

        DBUtils.createConnection();
        DBUtils.executeQuery("select * from cmessage");
        System.out.println("JDBC mesaj sayisi: "+DBUtils.getRowCount());
        DBUtils.closeConnection();


        Assert.assertTrue(messages.length<messagesSatirList.size());




     // List<WebElement> messagesSatirList;
     // for (int i = 0; i <20 ; i++) {
     //     if (medunnaPage27.copyrightElementi.isDisplayed()){
     //         Thread.sleep(3000);
     //         messagesSatirList=Driver.getDriver().findElements(By.xpath("//tbody//tr"));
     //         System.out.println(messagesSatirList.size());
     //         break;

     //     }else {
     //         actions=new Actions(Driver.getDriver());
     //         actions.sendKeys(Keys.PAGE_DOWN).perform();
     //         Thread.sleep(3000);
     //     }
     // }




    }

    @Then("Admin27 sayfayi kapatir")
    public void admin27_sayfayi_kapatir() {
        Driver.closeDriver();
    }


    @And("Admin{int} {string}, {string}, {string} ve {string} alanlarina giris yapar ve {string} butonunu tiklar")
    public void adminVeAlanlarinaGirisYaparVeButonunuTiklar(int arg0, String arg1, String arg2, String arg3, String arg4, String arg5) throws InterruptedException {



        Actions actions=new Actions(Driver.getDriver());
        String name="nameUS27Test"+ counter;
        medunnaPage27.createNewMessageElementi.click();
        medunnaPage27.messageNameEntryElementi.click();
        Thread.sleep(2000);
        medunnaPage27.messageNameEntryElementi.sendKeys("nameUS27Test"+ counter,Keys.TAB);

        medunnaPage27.messageEmailEntryElementi.sendKeys("emailUS27Test"+ counter +"@gmail.com");
        actions.sendKeys(Keys.TAB).perform();
        medunnaPage27.messageSubjectEntryElementi.sendKeys("subjectUS27Test"+ counter);
        actions.sendKeys(Keys.TAB).perform();
        medunnaPage27.messageMessageEntryElementi.sendKeys("messageUS27Test"+ counter);
        medunnaPage27.messageEntrySaveElementi.click();




    }

    @Then("Admin{int} yeni mesajinin girisinin basarili oldugunu dogrular")
    public void adminYeniMesajininGirisininBasariliOldugunuDogrular(int arg0) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
        String actualAlertText=medunnaPage27.messageEntryAlertElementi.getText();
        String expectedAlertText="A new Message is created with identifier";
        Assert.assertTrue(actualAlertText.startsWith(expectedAlertText));
    }

    @And("Admin{int} kendisi tarafindan kaydi yapilan son mesajin butun alanlarini gunceller")
    public void adminKendisiTarafindanKaydiYapilanSonMesajinButunAlanlariniGunceller(int arg0) throws Exception {

        Actions actions=new Actions(Driver.getDriver());

        Response response=ApiUtils.getRequest(Authentication.generateToken(),"https://medunna.com/api/c-messages?size=1000");
        ObjectMapper obj=new ObjectMapper();
        Messages [] messages=obj.readValue(response.asString(),Messages [].class);

        int pageDownTekrarSayisi=(messages.length)/8;
        System.out.println(pageDownTekrarSayisi);


        for (int i = 0; i <pageDownTekrarSayisi ; i++) {
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            Thread.sleep(2000);
        }
        messagesSatirList=Driver.getDriver().findElements(By.xpath("//table//tbody//tr"));

        int indexEditMessage=0;
        for (int i = 0; i < messagesSatirList.size(); i++) {
            if (messagesSatirList.get(i).getText().contains("nameUS27Test"+ counter)){
                indexEditMessage=i+1;
            }
        }
        WebElement updateMessageEditElementi=Driver.getDriver().findElement(By.xpath("(//Span[text()='Edit'])["+indexEditMessage+"]"));
        updateMessageEditElementi.click();
        Thread.sleep(2000);

        //medunnaPage27.messageNameEntryElementi.click();

        medunnaPage27.messageNameEntryElementi.sendKeys("_Update"+ counter);
        actions.sendKeys(Keys.TAB).perform();
        medunnaPage27.messageEmailEntryElementi.sendKeys("emailUS27Test_Update"+ counter +"@gmail.com");
        actions.sendKeys(Keys.TAB).perform();
        medunnaPage27.messageSubjectEntryElementi.sendKeys("subjectUS27Test_Update"+ counter);
        actions.sendKeys(Keys.TAB).perform();
        medunnaPage27.messageMessageEntryElementi.sendKeys("messageUS27Test_Update"+ counter);
        medunnaPage27.messageEntrySaveElementi.click();
    }

    @Then("Admin{int} ilgili mesajin guncellendigini dogrular")
    public void adminIlgiliMesajinGuncellendiginiDogrular(int arg0) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
        String actualAlertText=medunnaPage27.messageEntryAlertElementi.getText();
        String expectedAlertText="A Message is updated with identifier";
        Assert.assertTrue(actualAlertText.startsWith(expectedAlertText));
    }

    @And("Admin{int} kendisi tarafindan guncellenen son mesaji siler")
    public void adminKendisiTarafindanGuncellenenSonMesajiSiler(int arg0) throws InterruptedException, IOException {


        Actions actions=new Actions(Driver.getDriver());
        Response response=ApiUtils.getRequest(Authentication.generateToken(),"https://medunna.com/api/c-messages?size=1000");
        ObjectMapper obj=new ObjectMapper();
        Messages [] messages=obj.readValue(response.asString(),Messages [].class);

        int pageDownTekrarSayisi=(messages.length)/8;
        System.out.println(pageDownTekrarSayisi);


        for (int i = 0; i <pageDownTekrarSayisi ; i++) {
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            Thread.sleep(2000);
        }
        messagesSatirList=Driver.getDriver().findElements(By.xpath("//table//tbody//tr"));

        int indexDeleteMessage=0;
        for (int i = 0; i < messagesSatirList.size(); i++) {
            String name="nameUS27Test"+ counter+"_Update"+counter;
            if (messagesSatirList.get(i).getText().contains(name)){
                indexDeleteMessage=i+1;
            }
        }
        System.out.println(indexDeleteMessage);
        WebElement updateMessageDeleteElementi=Driver.getDriver().findElement(By.xpath("(//Span[text()='Delete'])["+indexDeleteMessage+"]"));

        updateMessageDeleteElementi.click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='jhi-confirm-delete-cMessage']")));


        medunnaPage27.messageDeletConfirmElementi.click();
        counter++;
    }


    @Then("Admin{int} mesajin silindigini dogrular")
    public void adminMesajinSilindiginiDogrular(int arg0) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
        String actualAlertText=medunnaPage27.messageEntryAlertElementi.getText();
        String expectedAlertText="A Message is deleted with identifier";
        Assert.assertTrue(actualAlertText.startsWith(expectedAlertText));
    }

}
