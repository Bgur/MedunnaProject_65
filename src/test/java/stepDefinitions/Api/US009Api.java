package stepDefinitions.Api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.US009pojo;
import utilities.Authentication;
import utilities.ConfigReader;

import java.io.IOException;

import static io.restassured.RestAssured.given;


public class US009Api {

    Response response;
    US009pojo[] pojo;

    @Given("Kullanici {string} id'li hasta verileri icin bir get request gonderir")
    public void kullanici_id_li_hasta_verileri_icin_bir_get_request_gonderir(String string) {

        response= given().headers(
                "Authorization",
                "Bearer " + Authentication.generateToken(),
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON
        ).when().get(ConfigReader.getProperty("patient_endpoint"));

    }

    @Given("Kullanici Status code {int} oldugunu dogrular")
    public void kullanici_status_code_oldugunu_dogrular(Integer int1) {
        response.then().assertThat().statusCode(200);
        response.prettyPrint();
    }

    @Given("Kullanici gelen datayi deserialize eder")
    public void kullanici_gelen_datayi_deserialize_eder() throws IOException {

        ObjectMapper obj=new ObjectMapper();
        // pojo=obj.readValue(response.asString(), US009_Pojo[].class);
        // System.out.println(pojo.length());

    }

    @Then("Kullanici, hasta ID, adini, ssn'yi, e-postayi dogrular")
    public void kullanici_hasta_id_adini_ssn_yi_e_postayi_dogrular() {



    }

    @Given("Kullanici patients icin post request yapar")
    public void kullanici_patients_icin_post_request_yapar() {



    }


    @Then("Kullanici post request validation yapar")
    public void kullanici_post_request_validation_yapar() {



    }

}
