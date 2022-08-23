package stepDefinitions.Db;

import io.cucumber.java.en.*;
import org.junit.Assert;
import utilities.DatabaseUtility;
import utilities.ReadTxt;
import utilities.WriteToTxt;

import java.util.ArrayList;
import java.util.List;

import static utilities.DatabaseUtility.getColumnData;

public class US010Db {



    String fileName1;

    @Given("kullanici bilgileri kullanarak medunna_db baglanti kurar")
    public void kullanici_bilgileri_kullanarak_medunna_db_baglanti_kurar() {

        DatabaseUtility.createConnection();


    }

    @Given("kullanici query ve column gonderir")
    public void kullanici_query_ve_column_gonderir() {
        String query = "select * from appointment";//Tüm randevuları çeker
        System.out.println(DatabaseUtility.getColumnNames(query) + "\n");

        //Dataların id lerini alıp listelenmesi
        System.out.println("================= ID LIST ====================");
        List<Object> idList = getColumnData(query, "id");
        System.out.println(idList + "\n");

        //Aldığımız ID leri bilgisayarımızda kaydetmek için Test Data içinde AppointmentID adında text dosyası açıyoruz.
        fileName1 = "src/test/resources/Test Data/AppointmentIDs.txt";
        WriteToTxt.saveAppointmentIds(fileName1, idList);

    }

    @Given("kullanici randevulari dogrular")
    public void kullanici_randevulari_dogrular() {

        //Validation
        List<Object> actualAppointmentsIDs = ReadTxt.returnAppointmentsIDsList(fileName1);
        List<Object> expectedAppointmentsIDs = new ArrayList<>();
        expectedAppointmentsIDs.add(191393);


        Assert.assertTrue("IDler Uyusmuyor", actualAppointmentsIDs.containsAll(expectedAppointmentsIDs));

    }

}



