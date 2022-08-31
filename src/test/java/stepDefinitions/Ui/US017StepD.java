package stepDefinitions.Ui;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.US017page;
import utilities.Driver;

public class US017StepD {
    public US017page us017page = new US017page();
    public Faker faker = new Faker();

    @Then("Admin username ve passwordu girer ve sign in butonuna tiklar")
    public void adminUsernameVePassworduGirerVeSignInButonunaTiklar() {
        us017page.userNameTextBox.sendKeys("Team65");
        us017page.passwordTextBox.sendKeys("Team65.");
        us017page.signInSubmit.submit();


    }

    @Then("Items items sekmesine ve test item sekmesine tiklar")
    public void itemsItemsSekmesineVeTestItemSekmesineTiklar() throws InterruptedException {


        Driver.waitAndClick(us017page.testItemButton);
        Thread.sleep(2000);

    }

    @Then("User isaretine ve signin butonunu tiklar")
    public void userIsaretineVeSigninButonunuTiklar() {
        us017page.userIsareti.click();
        us017page.signInIsareti.click();


    }

    @Then("Create a new Test Item butonuna tiklar")
    public void createANewTestItemButonunaTiklar() {
        Driver.waitAndClick(us017page.createTestItemButton);

    }


    @Then("Name Description Price Default  Min Value Default Max Value lari girer ve Save butonuna tiklayarak Test Item olusturur ve dogrular")
    public void nameDescriptionPriceDefaultMinValueDefaultMaxValueLariGirerVeSaveButonunaTiklayarakTestItemOlustururVeDogrular() {
        Faker faker = new Faker();
        us017page.nameKutusu.sendKeys(faker.name().username());
        us017page.descriptionKutusu.sendKeys("description");
        us017page.priceKutusu.sendKeys("15");
        us017page.minValKutusu.sendKeys("65");
        us017page.maxValKutusu.sendKeys("65");
        us017page.saveKutusu.submit();
        Driver.waitAndClick(us017page.idELementi);
        Assert.assertTrue(us017page.olusturulduID.isDisplayed());


    }

    @Then("Name Description Price Default Min Value Default ve Created Date verilerini girer")
    public void nameDescriptionPriceDefaultMinValueDefaultVeCreatedDateVerileriniGirer() {

        us017page.nameKutusu.sendKeys(faker.name().username());
        us017page.descriptionKutusu.sendKeys("description");
        us017page.priceKutusu.sendKeys("15");
        us017page.minValKutusu.sendKeys("65");
        us017page.maxValKutusu.sendKeys("65");
        us017page.createdDateELementi.sendKeys("12.08.2022");
        Assert.assertFalse(us017page.createdDateELementi.getText().contains("12.08.2022"));

    }

    @Then("Save butonuna tiklar, ID sekmesine tiklar, olusturulan Itemin Edit butonuna tiklayarak eski verileri gunceller ve save butonuna tiklar")
    public void saveButonunaTiklarIDSekmesineTiklarOlusturulanIteminEditButonunaTiklayarakEskiVerileriGuncellerVeSaveButonunaTiklar() {
        Driver.waitAndClick(us017page.saveKutusu);

        Driver.waitAndClick(us017page.idELementi);
        Driver.waitAndClick(us017page.editElementi);

        Driver.waitAndSendText(us017page.nameKutusu, faker.name().username());
        Driver.waitAndClick(us017page.saveKutusu);


    }

    @Then("Güncel Itemin gorunurlugu dogrulanir")
    public void güncelIteminGorunurluguDogrulanir() {

        Assert.assertTrue(Driver.waitForVisibility(us017page.olusturulduID,1000).isDisplayed());

    }

    @Then("Herhangi bir Test Iteminin View butonuna tiklayarak goruldugunu dogrular")
    public void herhangiBirTestItemininViewButonunaTiklayarakGoruldugunuDogrular() {
        Driver.waitAndClick(us017page.viewElementi);
        Assert.assertTrue(Driver.waitForVisibility(us017page.testItemElementi,1000).isDisplayed());

    }

    @Then("Herhangi bir Test Iteminin Delete butonuna tiklayarak silindigini dogrular")
    public void herhangiBirTestItemininDeleteButonunaTiklayarakSilindiginiDogrular() {
        Driver.waitAndClick(us017page.saveKutusu);
        Driver.waitAndClick(us017page.deleteItemElementi);
        Driver.waitAndClick(us017page.deleteDogrulaElementi);



    }


}
