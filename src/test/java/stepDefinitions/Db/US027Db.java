package stepDefinitions.Db;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class US027Db {
    @Given("Kullanici27 database'e baglanir")
    public void kullanici27_database_e_baglanir() {
        DBUtils.createConnection();
    }
    @When("Kullanici27 id'si {int} olan mesaji database'den alir")
    public void kullanici27_id_si_olan_mesaji_database_den_alir(Integer int1) {
    DBUtils.executeQuery("select * from public.cmessage where id="+int1);
    }
    @Then("Kullanici27 bu mesajin name, email, subject ve message bolumlerini dogrular")
    public void kullanici27_bu_mesajin_name_email_subject_ve_message_bolumlerini_dogrular() throws SQLException {
    ResultSet result=DBUtils.getResultset();
    String expectedName="nameUS27TestApi1";
    String expectedEmail="emailUS27TestApi1@gmail.com";
    String expectedSubject="subjectUS27TestApi1";
    String expectedMessage="messageUS27TestApi1";

    result.next();

        Assert.assertEquals(result.getObject("name"),expectedName);
        Assert.assertEquals(result.getObject("email"),expectedEmail);
        Assert.assertEquals(result.getObject("subject"),expectedSubject);
        Assert.assertEquals(result.getObject("message"),expectedMessage);

    }
    @Then("Kullanici27 baglantiyi sonlandirir")
    public void kullanici27_baglantiyi_sonlandirir() {
        DBUtils.closeConnection();
    }

}
