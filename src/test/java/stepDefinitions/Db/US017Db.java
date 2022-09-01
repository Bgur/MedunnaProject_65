package stepDefinitions.Db;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.DBUtils;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static utilities.DBUtils.createConnection;

public class US017Db {


    @Given("kullanici tablodan {string} ile gerekli datayi alir")
    public void kullaniciTablodanIleGerekliDatayiAlir(String name_) {
        createConnection();
        DBUtils.executeQuery("Select * from c_test_item where name ='"+name_+"'");
    }



    @Then("kullanici db ile {string} ile test item sorgulamasi yapar")
    public void kullaniciDbIleIleTestItemSorgulamasiYapar(String name_) throws SQLException {
        DBUtils.getResultset().next();
        Object columnData = DBUtils.getResultset().getObject("name");
        String actualData = (String) columnData;
        System.out.println(columnData);
        System.out.println(actualData);
        String expectedData = name_;
        Assert.assertEquals(expectedData, actualData);
        DBUtils.closeConnection();
    }





    @Given("kullanici {string} ile data kontrol eder")
    public void kullaniciIleDataKontrolEder(String id) throws SQLException {
        createConnection();
        DBUtils.executeQuery("Select * from c_test_item where id ="+id+"");
        DBUtils.getResultset().next();
        Object columnData =  DBUtils.getResultset().getObject("id");
        System.out.println(columnData);
        Long expectedData = Long.valueOf(id);
        Assert.assertEquals(expectedData, columnData);
        DBUtils.closeConnection();


    }



}
