package stepDefinitions.Ui;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.US026page;
import utilities.Driver;


public class US026_StepDefinitions {
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    US026page us026page = new US026page();

    public static String name = "name";
    String email = "email@email.com";
    String subject = "subject";
    String mesaj = "mesaj";


    @Then("Herhangi bir kullanici contact butonunu tiklar")
    public void herhangiBirKullaniciContactButonunuTiklar() {


        us026page.contactButton.click();


    }

    @Then("Name, Email, Subject ve Message bilgilerini dogru girer")
    public void nameEmailSubjectVeMessageBilgileriniDogruGirer() {


        us026page.nameYeri.sendKeys(name);
        us026page.emailYeri.sendKeys(email);
        // jse.executeScript("window.scrollBy(0,450)");

        us026page.subjectYeri.sendKeys(subject);
        us026page.messageYeri.sendKeys(mesaj);
        jse.executeScript("window.scrollBy(0,150)");


    }

    @Then("Send butonuna tiklar")
    public void sendButonunaTiklar() throws InterruptedException {

        us026page.sendButton.submit();
        Thread.sleep(2000);


    }

    @Then("Mesajin gonderildigi dogrulanir")
    public void mesajinGonderildigiDogrulanir() {
        Assert.assertTrue(us026page.mesajGonderildiYazisi.isDisplayed());


    }

    @Then("Kullanici name, Email, subject, Message bilgilerini girildigini dogrular")
    public void kullaniciNameEmailSubjectMessageBilgileriniGirildiginiDogrular() {
        us026page.nameYeri.sendKeys(name);
        WebElement nameValueElement=Driver.getDriver().findElement(By.xpath("//input[@value='name']"));

        if (nameValueElement.isEnabled()) {
            Assert.assertTrue(true);
        } else Assert.assertTrue(false);

        us026page.emailYeri.sendKeys(email);
        WebElement emailElement=Driver.getDriver().findElement(By.xpath("//input[@value='email@email.com']"));

        if (emailElement.isEnabled()) {
            Assert.assertTrue(true);
            System.out.println("calisti");
        } else Assert.assertTrue(false);


        us026page.subjectYeri.sendKeys(subject);
        WebElement subjectElement=Driver.getDriver().findElement(By.xpath("//input[@value='subject']"));


        if (subjectElement.isEnabled()) {
            Assert.assertTrue(true);
        } else Assert.assertTrue(false);

        us026page.messageYeri.sendKeys(mesaj);
        WebElement mesajElement=Driver.getDriver().findElement(By.xpath("//textarea[text()='mesaj']"));

        if (mesajElement.isEnabled()) {
            Assert.assertTrue(true);
        } else Assert.assertTrue(false);

    }
}
