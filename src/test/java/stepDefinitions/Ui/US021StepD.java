package stepDefinitions.Ui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.US009page;
import pages.US021page;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class US021StepD {

    US021page us021 = new US021page();
    US009page u = new US009page();



    @Given("Staff schowAppoinmen e tiklar")
    public void Staff_schow_appoinmen_e_tiklar() {
        this.us021.stafShowAppoinmentElementi.click();
        ReusableMethods.waitFor(3);
    }

    @And("Staff edit butonuna tiklar.")
    public void StaffeditButonunaTiklar() {
        this.us021.stafeditAppoinmentElementi.click();
        ReusableMethods.waitFor(3);
    }

    @Then("Staff hastanin  Status durumunu UNAPPROVED, PENDING or CANCELLED secebildigini test eder")
    public void StaffhastaninStatusDurumunuUNAPPROVEDPENDINGOrCANCELLEDSecebildiginiTestEder() {
        ReusableMethods.waitFor(2);
        Select select = new Select(this.us021.stafHastastatusDropdown);
        new ArrayList();
        List<WebElement> statusliste = select.getOptions();
        Iterator var3 = statusliste.iterator();

        while(var3.hasNext()) {
            WebElement x = (WebElement)var3.next();
            if (x.getText().equals("UNAPPROVED")) {
                Assert.assertTrue(x.isEnabled());
            }

            if (x.getText().equals("PENDING")) {
                Assert.assertTrue(x.isEnabled());
            }

            if (x.getText().equals("CANCELLED")) {
                Assert.assertTrue(x.isEnabled());
            }

            if (x.getText().equals("COMLETED")) {
                Assert.assertFalse(x.isEnabled());
            }
        }

    }

    @Then("Staff Anamnesis,diagnos sayfalari bos olsada sisteme kaydedebilir")
    public void staffanamnesisDiagnosSayfalariBosOlsadaSistemeKaydedebilir() {
        this.us021.stafHastaDiagnosbox.clear();
        this.us021.stafHastaanamnesisBox.clear();
        this.us021.stafHastatreatmentBox.clear();
        WebElement saveButton = Driver.getDriver().findElement(By.xpath("//button[@id='save-entity']"));
        Driver.clickWithJS(saveButton);
        Assert.assertFalse(this.us021.saveToastify.isDisplayed());
    }

    @Then("Staff hasta icin doktoru secer")
    public void StaffhastaIcinDoktoruSecer() {
        Select select = new Select(this.us021.stafHastastatusDropdown);
        select.selectByVisibleText("PENDING");
        this.us021.stafHastaDiagnosbox.sendKeys(new CharSequence[]{"kesintisizoksuruk"});
    }

    @And("Staff kaydeder")
    public void Staffkaydeder() {
        WebElement saveButton = Driver.getDriver().findElement(By.xpath("//button[@id='save-entity']"));
        Driver.clickWithJS(saveButton);
        Assert.assertFalse(this.us021.saveToastify.isDisplayed());
    }

    @And("Staff schowTest e tiklar")
    public void StaffschowtestETiklar() {
        this.us021.stafHastaShowTestElementi.click();
    }

    @Then("Staff hastanin testlerinin gorunurlugunu dogrular")
    public void StaffhastaninTestlerininGorunurlugunuDogrular() {
        this.us021.stafHastaTestTitel.isDisplayed();
    }

    @Then("Staff sayfayi kapatir")
    public void staff_sayfayi_kapatir() {
        Driver.closeDriver();
    }

    @And("Staff gecerli bir ssn girer.")
    public void staffGecerliBirSsnGirer() {
        this.u.patientSsnSearchBox.click();
        ReusableMethods.waitFor(3);
        this.u.patientSsnSearchBox.sendKeys(new CharSequence[]{"555-66-777"});
        ReusableMethods.waitFor(3);
    }
}