package stepDefinitions.Db;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.DBUtils;

import java.sql.SQLException;

import static utilities.DBUtils.createConnection;

public class US002Db {



    @When("Kullanici tablodan gerekli sutunu alir")
    public void kullanici_tablodan_gerekli_sutunu_alir() {
        createConnection();
        DBUtils.executeQuery("Select * from jhi_user where first_name = 'Team'");
    }
    @Then("Kullanici email dogrulamasini yapar")
    public void kullanici_email_dogrulamasini_yapar() throws SQLException {
        DBUtils.getResultset().next();
        Object columnData = DBUtils.getResultset().getObject("email");
        String actualData= (String) columnData;
        String expectedData="healthteam65@gmail.com";
        Assert.assertEquals(expectedData,actualData);
        DBUtils.closeConnection();
    }

}
