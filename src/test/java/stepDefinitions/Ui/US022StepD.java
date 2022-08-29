package stepDefinitions.Ui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import pages.US001page;
import pages.US009page;
import pages.US021page;
import utilities.Driver;
import utilities.ReusableMethods;

public class US022StepD {
    US021page staff = new US021page();
   US001page login=new US001page();
    US009page u = new US009page();
    Actions accion=new Actions(Driver.getDriver());



    @Then("Sign In butonuna tiklar.")
    public void sign_in_butonuna_tiklar() {
       login.signIn.click();
    }
    @And("MY PAGES butonuna tiklar")
    public void myPAGESButonunaTiklar() {
        staff.MYPAGES.click();
        Driver.wait(3);
    }

    @And("search patient butonuna tiklar")
    public void searchPatientButonunaTiklar() {

        staff.SearchPatient.click();
        Driver.wait(3);
    }



    @And("Staff SSN numarasini girerr")
    public void StaffssnNumarasiniGirerr() {
       // staff.SearchSSN.sendKeys("128-65-1234");
        Driver.wait(3);

        this.u.patientSsnSearchBox.click();
        ReusableMethods.waitFor(3);
        this.u.patientSsnSearchBox.sendKeys(new CharSequence[]{"128-65-1234"});
        ReusableMethods.waitFor(3);
    }

    @And("sayfayi kapatir")
    public void sayfayiKapatir() {
        Driver.closeDriver();
    }

    @And("Staff Show appoinmant butonuna tiklar")
    public void StaffshowAppoinmantButonunaTiklar() {
        staff.ShowAppointments.click();
        Driver.wait(4);
    }

    @And("Staff show test butonuna tiklar")
    public void StaffshowTestButonunaTiklar() {

        Driver.clickWithJS(staff.ShowTest);
        //staff.ShowTest.click();
        Driver.wait(4);
    }

    @And("Staff view results butonuna tiklar")
    public void StaffviewResultsButonunaTiklar() {
        staff.ViewTest.click();
        Driver.wait(3);
    }

    @And("Staff view results butonuna")
    public void StaffviewResultsButonuna() {
        staff.ViewTest.click();
        Driver.wait(3);

    }

    @And("Staff edit butonuna tiklar")
    public void StaffeditButonunaTiklar() {
        staff.EditTest.click();
        Driver.wait(5);
    }

    @And("Staff result texboxa tiklar")
    public void StaffresultTexboxaTiklar() {
        staff.EditTestResult.sendKeys("GAyet iyi");
        // Assert.assertTrue("Date aktif degil",staff.EditTestResultDate.isEnabled());
        accion.sendKeys(Keys.PAGE_DOWN).perform();

    }

    @And("Staff descripcion texboxuna tiklar")
    public void descripcionTexboxunaTiklar() {
        staff.EditTestResultDescription.sendKeys("Gecmis olsunn!!!");
        accion.sendKeys(Keys.PAGE_DOWN).perform();
    }

    @And("Staff save butomuna tiklar")
    public void StaffsaveButomunaTiklar() {
        staff.EditTestResultTestSave.click();
    }

    @And("Staff Date,Result,description,create date,test item,test texbox'larinin gorunurlugu test edilir")
    public void StaffdateResultDescriptionCreateDateTestItemTestTexboxLarininGorunurluguTestEdilir() {
        staff.EditTestResultDate.isDisplayed();
        accion.sendKeys(Keys.PAGE_DOWN);
        Driver.wait(1);
        staff.EditTestResult.isDisplayed();
        staff.EditTestResult.sendKeys("");
        Driver.wait(1);

        staff.EditTestResultDescription.isDisplayed();

Driver.wait(1);
        staff.EditTestResultCreatedDate.isDisplayed();
Driver.wait(1);
        staff.EditTestResultTestItem.isDisplayed();

        Driver.wait(1);

        staff.EditTestResultTestSave.isDisplayed();

        //Driver.closeDriver();
    }

    @And("Staff SSN numarasini girerr.")
    public void staffSSNNumarasiniGirerr() {
       u.patientSsnSearchBox.click();
        ReusableMethods.waitFor(3);
      u.patientSsnSearchBox.sendKeys("128-65-1234");
        ReusableMethods.waitFor(3);
    }
}



