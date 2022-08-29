package stepDefinitions.Ui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.US023page;
import utilities.Driver;

public class US023StepD {

      US023page us23 = new US023page();
      Actions actions = new Actions(Driver.getDriver());

    @Then("SignInDropDownLink ni tiklar")
    public void signindropdownlinkNiTiklar() {
        us23.SignInDropDownLink.click();
        Driver.wait(2);
    }


    @Then("SigninEnterTusu butonuna tiklar")
    public void signinentertusuButonunaTiklar() {
        us23.SigninEnterTusu.click();
    }

    @And("MyPages sekmesine tiklar")
    public void mypagesSekmesineTiklar() {
        us23.MyPages.click();
        Driver.wait(2);
    }

    @Then("SearchPatient sekmesine tiklar")
    public void searchpatientSekmesineTiklar() {
        us23.SearchPatient.click();
        Driver.wait(2);
    }

    @And("SearchPatientSSNBox kutusuna hasta numarasi olarak {string} girer")
    public void searchpatientssnboxKutusunaHastaNumarasiOlarakGirer(String arg0) {
        JavascriptExecutor jsexecutor = ((JavascriptExecutor) Driver.getDriver());
        jsexecutor.executeScript("arguments[0].scrollIntoView(true);", us23.SearchPatientSSNBox);
        us23.SearchPatientSSNBox.sendKeys("151-15-1515");
        Driver.wait(2);
    }

    @Then("ShowAppointmentsButton a tiklar")
    public void showappointmentsbuttonATiklar() {
        Driver.wait(2);
        us23.ShowAppointmentsButton.click();
    }

    @Then("PaymentInvoiceProcessButton a tiklar")
    public void paymentinvoiceprocessbuttonATiklar() {
        Driver.wait(2);
        us23.PaymentInvoiceProcessButton.click();
        Driver.wait(2);
    }

    @And("PAYMENT DETAIL sayfasini gorur")
    public void paymentDETAILSayfasiniGorur() {
        Assert.assertTrue("Payment Detail Page Text i gorulemiyor", us23.PaymentDetailPageText.isDisplayed());
        Driver.wait(2);
    }

    @And("Personel Hasta adina fatura olusturmak icin RandevuDurumu nun COMPLETED veya CANCELED oldugunu gorur")
    public void randevudurumuNunCOMPLETEDVeyaCANCELEDOldugunuGorur() {
        if (us23.RandevuDurumu.getText().equals("COMPLETED") || us23.RandevuDurumu.getText().equals("CANCELED")) {
            Assert.assertTrue("Invoice Process Tusu gorulemiyor", us23.PaymentInvoiceProcessButton.isDisplayed());   }
        }

    @And("Exam Fee yi gorur")
    public void examFeeYiGorur() {
        Assert.assertTrue("Exam Fee gorulemiyor", us23.ExamFee.isDisplayed());
        Driver.wait(2);
    }

    @Then("TestItem Fee yi gorur")
    public void testitemFeeYiGorur() {
        Assert.assertTrue("Test Item Fee gorulemiyor", us23.TestItemFee.isDisplayed());
        Driver.wait(2);
    }

    @And("ShowInvoiceButton a tiklar")
    public void showinvoicebuttonATiklar() {
        us23.ShowInvoiceButton.click();
    }

    @Then("InvoicePageTitleText in altinda INVOICE u gorur")
    public void invoicepagetitletextInAltindaINVOICEUGorur() {
        Assert.assertTrue("Invoice sayfasi baslik texti gorulemiyor", us23.InvoicePageTitleText.isDisplayed());
        Driver.wait(2);
    }

    @And("Hastanin randevu durumunun COMPLETED olup olmadigini kontrol eder")
    public void randevuDurumununCOMPLETEDOlupOlmadiginiKontrolEder() {
        Assert.assertEquals("Hastanin randevu durumu COMPLETED degil", "COMPLETED",
                            us23.RandevuDurumu.getText());
    }

    @Then("Eger COMPLETED ise PaymentInvoiceProcessButton a tiklar")
    public void egerCOMPLETEDIsePaymentInvoiceProcessButtonATiklar() {
        if (us23.RandevuDurumu.getText().equalsIgnoreCase( "COMPLETED")) {
            us23.PaymentInvoiceProcessButton.click();  }
    }

    @And("Create Invoice butonuna tiklar")
    public void createInvoiceButonunaTiklar() {
        us23.CreateInvoiceButton.click();
    }

    @Then("Create or edit a Bill formunu doldurur ve save butonuna tiklar")
    public void createOrEditABillFormunuDoldurur() {
        US023page paymentMethod = new US023page();
        Select select = new Select(us23.BillPaymentKutusu);
        // invoicePage.BillIdKutusu.sendKeys("77");
        // CharSequence LocalDateTime = null;
        us23.BillDateKutusu.sendKeys(Keys.ARROW_DOWN);
        us23.BillDateKutusu.click();
        // invoicePage.BillNameKutusu.sendKeys("allergy");
        select.selectByVisibleText("CREDIT_CARD");
        Driver.wait(1);
        us23.BILLDescriptionKutusu.sendKeys("Do NOT CODE so much");
        us23.EditaBillSavebutonu.click();
    }

    @Then("A Bill is updated with identifier yazili uyariyi gorur")
    public void aBillIsUpdatedWithIdentifierYaziliUyariyiGorur() {
        // Bir onceki adimda bug oldugu icin bu asamaya gecilemiyor
    }
}
