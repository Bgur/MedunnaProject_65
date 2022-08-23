package stepDefinitions.Db;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.DBUtils;

import java.sql.SQLException;

import static utilities.DBUtils.createConnection;

public class US001Db {

    //-------------------TC07----------------------------



   /* @When("Kullanici tablodan gerekli sutunu alir")
    public void kullanici_tablodan_gerekli_sutunu_alir() {
        createConnection();
        DBUtils.executeQuery("Select * from jhi_user where ssn= '456-12-7852'");
    }*/
    @Then("Kullanici ssn dogrulamasini yapar")
    public void kullanici_ssn_dogrulamasini_yapar() throws SQLException {

        DBUtils.getResultset().next();
        Object columnData = DBUtils.getResultset().getObject("ssn");
        String actualData= (String) columnData;
        String expectedData="456-12-7852";
        Assert.assertEquals(expectedData,actualData);
        DBUtils.closeConnection();

    }
}
