package stepDefinitions.Db;

import io.cucumber.java.en.*;
import org.junit.Assert;
import utilities.DBUtils;
import utilities.DatabaseUtility;
import utilities.ReadTxt;
import utilities.WriteToTxt;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static utilities.DBUtils.getColumnData;

public class US018Db {
    static String query;
    static String fileList;

    @When("Kullanici databese query gonderir ve gerekli columnu alir")
    public void kullanici_databese_query_gonderir_ve_gerekli_columnu_alir() {
        query = "select * from physician";
        DBUtils.executeQuery(query);

    }
    @Then("Kullanici doktorun bilgilerini dogrular")
    public void kullanici_doktorun_bilgilerini_dogrular() throws SQLException {

        String query = "select * from physician";
        System.out.println(DBUtils.getColumnNames(query)  + "\n");

        System.out.println("==ID LIST==");
        List<Object> idList = getColumnData(query, "id");
        System.out.println(idList + "\n");
        String fileName = "src/test/resources/Test Data/Physician.txt";
        WriteToTxt.savePhysician(fileName, idList);

        List<Object> actualPhysicianIDs = ReadTxt.returnPhysicianIDsList(fileName);
        List<Object> expectedPhysicianIDs = new ArrayList<>();
        expectedPhysicianIDs.add(229012);

        Assert.assertTrue("IDLER UYUSMUYOR", actualPhysicianIDs.containsAll(expectedPhysicianIDs));

    }
}
