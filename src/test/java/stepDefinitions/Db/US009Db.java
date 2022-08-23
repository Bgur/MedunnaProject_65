package stepDefinitions.Db;

import io.cucumber.java.en.*;
import org.junit.Assert;
import utilities.DBUtils;

import java.sql.SQLException;


public class US009Db {

    @Given("Kullanici database baglanir")
    public void kullanici_database_baglanir() {

        DBUtils.createConnection();

    }

    @When("Kullanici {string} {string} ile {string} tablosundan {string} alir")
    public void kullanici_ile_tablosundan_alir(String column, String table, String idColumn, String actualId) {

        String query = "select " + column + " from " + table + " where " + idColumn + "=" + actualId;
        DBUtils.executeQuery(query);

    }

    @Then("Hastanin {string} {string} olmalidir")
    public void hastanin_olmalidir(String firstNameColumn, String actualFirstName) throws SQLException {

        DBUtils.getResultset().next();

        Assert.assertEquals(DBUtils.getResultset().getObject(firstNameColumn), actualFirstName);

    }

    @Then("Kullanici database baglantisini kapatir")
    public void kullanici_database_baglantisini_kapatir() {

        DBUtils.closeConnection();

    }

}
