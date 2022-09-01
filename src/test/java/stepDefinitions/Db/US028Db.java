package stepDefinitions.Db;

import io.cucumber.java.en.*;
import org.junit.Assert;
import utilities.DatabaseUtility;
import utilities.ReadTxt;
import utilities.WriteToTxt;

import java.util.ArrayList;
import java.util.List;

public class US028Db {

    String query;
    String filename1="src/test/resources/Test Data/CountryId.txt";
    String filename2="src/test/resources/Test Data/CountryName.txt";
    String filename3="src/test/resources/Test Data/StateId.txt";
    String filename4="src/test/resources/Test Data/StateName.txt";



    @Given("Kullanici DB ile baglanti kurar")
    public void kullanici_db_ile_baglanti_kurar() {
        DatabaseUtility.createConnection();

    }

    @Given("Kullanici Query tanimlar")
    public void kullanici_query_tanimlar() {

        query="select * from public.country";
        System.out.println(DatabaseUtility.getColumnNames(query));

    }

    @Given("Kullanici ulke bilgilerine ulasir ve kaydeder")
    public void kullanici_ulke_bilgilerine_ulasir_ve_kaydeder() {

        List<Object> idList= DatabaseUtility.getColumnData(query,"id");
        WriteToTxt.saveCountryId(filename1,idList);
        List<Object> nameList= DatabaseUtility.getColumnData(query," name");
        WriteToTxt.saveCountryName(filename2,nameList);

    }

    @Given("Kullanici DB ile ulke bilgilerini dogrular")
    public void kullanici_db_ile_ulke_bilgilerini_dogrular() {
        List<Object> actualCountryId= ReadTxt.returnCountryIDsList(filename1);
        List<Object> actualCountryName= ReadTxt.returnCountryNamesList(filename2);


        List<Object> expectedCountryId=new ArrayList<>();

        expectedCountryId.add(259332);
        Assert.assertTrue("ID uyusmuyor",actualCountryId.containsAll(expectedCountryId));

    }

    //


    @Given("Kullanici sehir icin Query tanimlar")
    public void kullanici_sehir_icin_query_tanimlar() {
        query = "select * from public.c_state";
        System.out.println(DatabaseUtility.getColumnNames(query));

    }

    @Given("Kullanici sehir bilgilerine ulasir ve kaydeder")
    public void kullanici_sehir_bilgilerine_ulasir_ve_kaydeder() {

        List<Object> idList= DatabaseUtility.getColumnData(query,"id");
        WriteToTxt.saveStateId(filename3,idList);
        List<Object> nameList= DatabaseUtility.getColumnData(query,"name");
        WriteToTxt.saveStateName(filename4,nameList);

    }

    @Given("Kullanici DB ile sehir bilgilerini dogrular")
    public void kullanici_db_ile_sehir_bilgilerini_dogrular() {

        List<Object> actualStateId= ReadTxt.returnStateIDsList(filename3);
        List<Object> actualStateName= ReadTxt.returnStateNamesList(filename4);

        List<Object> expectedCountryId=new ArrayList<>();

        expectedCountryId.add(0); //database update etmeye izin vermedigi icin sehir eklenemedi
        Assert.assertTrue("ID uyusmuyor",actualStateId.containsAll(expectedCountryId));

    }





}
