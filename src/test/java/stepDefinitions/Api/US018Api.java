package stepDefinitions.Api;
import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.Physician;
import utilities.Authentication;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class US018Api {

    Response response;
    Physician physcianApiPojo=new Physician();

    @Given("Admin BA  {string} Medunna Api Endpointinden {string} numarali doktoru Okur Ve doktorun {string}, {string},{string},{string}, {string} Datalarina Sahip Oldugunu Dogrular.")
    public void admin_ba_medunna_api_endpointinden_numarali_doktoru_okur_ve_doktorun_datalarina_sahip_oldugunu_dogrular(String endpoint, String id, String firstName, String lastName, String ssn, String examFee, String speciality) {

        response = given().
                headers(
                        "Authorization",
                        "Bearer " + Authentication.generateToken(),
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON).
                when().
                get(endpoint + "/" + id).
                then().
                extract().
                response();

        response.prettyPrint();

        HashMap<String,Object> actualData=response.as(HashMap.class);
        System.out.println("actualData = " + actualData);

        Assert.assertEquals(physcianApiPojo.getId(),actualData.get(id));
        Assert.assertEquals(physcianApiPojo.getFirstname(),actualData.get(firstName));
        Assert.assertEquals(physcianApiPojo.getLastname(),actualData.get(lastName));
        Assert.assertEquals(physcianApiPojo.getExamfee(),actualData.get(examFee));
        Assert.assertEquals(physcianApiPojo.getSpeciality(),actualData.get(speciality));

    }

    @Given("Kullanici {string} id'li doktor verileri icin bir get request gonderir")
    public void kullanici_id_li_doktor_verileri_icin_bir_get_request_gonderir(String id) {
        String endpoint="https://medunna.com/api/physicians/";
        response = given().
                headers(
                        "Authorization",
                        "Bearer " + Authentication.generateToken(),
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON).
                when().
                get(endpoint + "/" + id).
                then().
                extract().
                response();

        response.prettyPrint();

    }

    @Given("Doktorun {string}, {string},{string},{string}, {string} Datalarina Sahip Oldugunu Dogrular.")
    public void doktorun_datalarina_sahip_oldugunu_dogrular(String firstName, String lastName, String ssn, String examFee, String speciality) {
        HashMap<String,Object> actualData=response.as(HashMap.class);
        System.out.println("actualData = " + actualData);


        Assert.assertEquals(physcianApiPojo.getFirstname(),actualData.get(firstName));
        Assert.assertEquals(physcianApiPojo.getLastname(),actualData.get(lastName));
        Assert.assertEquals(physcianApiPojo.getExamfee(),actualData.get(examFee));
        Assert.assertEquals(physcianApiPojo.getSpeciality(),actualData.get(speciality));
    }


}
