package stepDefinitions.Ui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.US014page;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;
import java.util.List;

public class US014StepD {
    US014page medunnaPage = new US014page();

    @Given("Doktor  Medunna internet sitesine gider")
    public void doktor_medunna_internet_sitesine_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("base_url"));
    }

    @When("Doktor anasayfa sag ust kosede bulunan kullanici ikonunu tiklar")
    public void doktor_anasayfa_sag_ust_kosede_bulunan_kullanici_ikonunu_tiklar() {

        medunnaPage.kullaniciIkonuElementi.click();
    }

    @When("Doktor acilan dropdown menuden  Sign in sekmesini secer")
    public void doktor_acilan_dropdown_menuden_sign_in_sekmesini_secer() {
        medunnaPage.signInElementi.click();
    }


    @And("Doktor kullanici adi ve parola girerek kendi sayfasina giris yapar")
    public void doktorKullaniciAdiVeParolaGirerekKendiSayfasinaGirisYapar() {
        medunnaPage.kullaniciAdiGirisiElementi.sendKeys("DoktorOnur65", Keys.TAB);
        medunnaPage.sifreGirisiElementi.sendKeys("DoktorOnur.65");
        medunnaPage.ikinciSignInElementi.click();

    }

    @And("Doktor giris yaptigi sayfada {string} butonuna tiklar")
    public void doktorGirisYaptigiSayfadaButonunaTiklar(String arg0) {
        medunnaPage.myPagesElementi.click();
    }

    @And("Doktor acilan dropdown menuden {string} i secer")
    public void doktorAcilanDropdownMenudenISecer(String arg0) {
        medunnaPage.myInPatientsElementi.click();
    }

    @Then("Doktor yatan hastanin ID, start and end dates, description, created date, appointment id, status, room and patient bilgilerinin gorunur oldugunu dogrular")
    public void doktorYatanHastaninIDStartAndEndDatesDescriptionCreatedDateAppointmentIdStatusRoomAndPatientBilgilerininGorunurOldugunuDogrular() {
        Assert.assertTrue(medunnaPage.idBaslikElementi.isDisplayed());
        Assert.assertTrue(medunnaPage.startDateBaslikElementi.isDisplayed());
        Assert.assertTrue(medunnaPage.endDateBaslikElementi.isDisplayed());
        Assert.assertTrue(medunnaPage.statusBaslikElementi.isDisplayed());
        Assert.assertTrue(medunnaPage.descriptionBaslikElementi.isDisplayed());
        Assert.assertTrue(medunnaPage.createdDateBaslikElementi.isDisplayed());
        Assert.assertTrue(medunnaPage.roomBaslikElementi.isDisplayed());
        Assert.assertTrue(medunnaPage.appointmentBaslikElementi.isDisplayed());
        Assert.assertTrue(medunnaPage.patientBaslikElementi.isDisplayed());
    }
    /*
    @And("Doktor sayfayi kapatir")
    public void doktorSayfayiKapatir() {
        Driver.closeDriver();


    }

     */

    @And("Doktor {string} ekraninda hasta bilgilerinin son kisminda bulunan {string} butonuna listedeki hastalardan {string} u  {string} olan ilk hasta icin tiklar")
    public void doktorEkranindaHastaBilgilerininSonKismindaBulunanButonunaListedekiHastalardanUOlanIlkHastaIcinTiklar(String arg0, String arg1, String arg2, String arg3) {
        int editIndex = 0;
        List<WebElement> statusList = Driver.getDriver().findElements(By.xpath("//table[@class='table']//td[4]"));
        for (int i = 0; i < statusList.size(); i++) {
            if (statusList.get(i).getText().equals(arg3)) {
                editIndex = i + 1;
            }
        }
        WebElement editElementi = Driver.getDriver().findElement(By.xpath("(//*[text()='Edit'])[" + editIndex + "]"));
        editElementi.click();

    }

    @And("Doktor acilan ekranda status basligi altindaki dropdown menuyu tiklar, {string} secenegini secer ve Save butonuna tiklar")
    public void doktorAcilanEkrandaStatusBasligiAltindakiDropdownMenuyuTiklarSeceneginiSecerVeSaveButonunaTiklar(String arg0) throws InterruptedException {
        medunnaPage.statusDropDownElementi.click();
        Select select = new Select(medunnaPage.statusDropDownElementi);
        select.selectByVisibleText(arg0);

        medunnaPage.inpatientAppointmentElementi.click();
        Actions action = new Actions(Driver.getDriver());
        action.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        action.moveToElement(medunnaPage.inpatientSaveButtonElementi).perform();
        //JavascriptExecutor jse = (JavascriptExecutor)Driver.getDriver();
        //jse.executeScript("arguments[0].scrollIntoView()", medunnaPage.inpatientSaveButtonElementi);


        // WebDriverWait wait=new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(15));
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary']")));
        // action.moveToElement(medunnaPage.inpatientSaveButtonElementi);
        medunnaPage.inpatientSaveButtonElementi.click();


    }

    @And("Doktor ekranin sol ust kosesinde uzerinde {string} yazan bir alert box un ciktigini dogrular")
    public void doktorEkraninSolUstKosesindeUzerindeYazanBirAlertBoxUnCiktiginiDogrular(String arg0) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
        String inpatientAlertExpectedResult = "The In Patient is updated with identifier";
        String inpatientAlertActualResult = medunnaPage.inpatientAlertUpdatedElementi.getText();
        Assert.assertTrue(inpatientAlertActualResult.startsWith(inpatientAlertExpectedResult));
    }




    @And("Doktor status basligi altindaki dropdown menuden {string} secenegini secer")
    public void doktorStatusBasligiAltindakiDropdownMenudenSeceneginiSecer(String arg0) {
        medunnaPage.statusDropDownElementi.click();
        Select select = new Select(medunnaPage.statusDropDownElementi);
        select.selectByVisibleText(arg0);

    }






    @Then("Doktor Room menusunden varsa ilk Available odayi secer Save butonuna basar ve uzerinde {string} yazan bir alert'in ciktigini test eder, Available oda yoksa ilk Unavailable odayi secer, Save butonuna tiklar ve {string} yazan bir alertin ciktigini dogrular")
    public void doktorRoomMenusundenVarsaIlkAvailableOdayiSecerSaveButonunaBasarVeUzerindeYazanBirAlertInCiktiginiTestEderAvailableOdaYoksaIlkUnavailableOdayiSecerSaveButonunaTiklarVeYazanBirAlertinCiktiginiDogrular(String arg0, String arg1) throws InterruptedException {
        medunnaPage.inpatientAppointmentElementi.click();
        Actions action = new Actions(Driver.getDriver());
        action.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        action.sendKeys(Keys.PAGE_DOWN).perform();


        int availableRoomIndex = 1;
        Select select1 = new Select(medunnaPage.roomDropDownElementi);
        List<WebElement> roomList = select1.getOptions();

        for (int i = 0; i <roomList.size() ; i++) {
            System.out.println(roomList.get(i).getText());
        }


        boolean verify=false;
        for (int i = 1; i < roomList.size(); i++) {
            if (!roomList.get(i).getText().contains("FULL-UNAVAILABLE")) {
                verify=true;
                availableRoomIndex=i;
                break;
            }else {
                verify=false;

            }
        }

        if (verify==true){
            select1.selectByIndex(availableRoomIndex);
            action.moveToElement(medunnaPage.inpatientSaveButtonElementi).perform();
            medunnaPage.inpatientSaveButtonElementi.click();
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
            String inpatientAlertExpectedResult = "The In Patient is updated with identifier";
            String inpatientAlertActualResult = medunnaPage.inpatientAlertUpdatedElementi.getText();
            Assert.assertTrue(inpatientAlertActualResult.startsWith(inpatientAlertExpectedResult));

        }else if (verify==false){
            availableRoomIndex=1;
            select1.selectByIndex(availableRoomIndex);
            action.moveToElement(medunnaPage.inpatientSaveButtonElementi).perform();
            medunnaPage.inpatientSaveButtonElementi.click();
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
            String inpatientAlertExpectedResult = "The room already reserved";
            String inpatientAlertActualResult = medunnaPage.roomReservedAlertElementi.getText();
            Assert.assertTrue(inpatientAlertActualResult.equalsIgnoreCase(inpatientAlertExpectedResult));
        }


    }
}
