package stepDefinitions.Api;




import io.cucumber.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import utilities.ConfigReader;


import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static utilities.Authentication.generateToken;

public class US028Api {

    RequestSpecification spec=new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("baseUrl")).build();

    static Response response;
    Map<String,Object> expectedData;


    @Given("Kullanici set the Base Url")
    public void kullanici_set_the_base_url() {
        spec.pathParams("1","api","2","countries", "3", 216008);

    }

    @Given("Send the GET request and get the response")
    public void send_the_get_request_and_get_the_response() {

        response = given().headers("Authorization", "Bearer " +generateToken(),
                        "Content-Type", ContentType.JSON, "Accept", ContentType.JSON).when().
                get(ConfigReader.getProperty("country_endpoint"));

    }

    @Given("Set the expected data")
    public void set_the_expected_data() {

        expectedData = new HashMap<>();
        expectedData.put("id",259332);
        expectedData.put("name","yeniulke2");

    }

    @Then("Make validation")
    public void make_validation() {

        Map<String, String> actualData=response.as(HashMap.class);

        assertEquals(expectedData.get("id"),actualData.get("id"));
        assertEquals(expectedData.get("name"),actualData.get("name"));


    }


    //


    @Given("Kullanici, ulke guncellemesi icin beklenen verileri girer")
    public void kullanici_ulke_guncellemesi_icin_beklenen_verileri_girer() {

        spec.pathParams("1","api","2","countries");

    }

    @Given("Kullanici, ulke guncellemesi icin istek gonderir ve yanit alir")
    public void kullanici_ulke_guncellemesi_icin_istek_gonderir_ve_yanit_alir() {
        expectedData = new HashMap<>();
        expectedData.put("id",259332);
        expectedData.put("name","yeniulke2");

    }

    @Given("Kullanici, ulke guncellemesi icin tum API bilgilerini kaydeder")
    public void kullanici_ulke_guncellemesi_icin_tum_apı_bilgilerini_kaydeder() {

        response = given().spec(spec)
                .headers("Authorization", "Bearer " +generateToken(),
                        "Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
                .body(expectedData)
                .when()
                .put("/{1}/{2}");

        try {
            response.then().statusCode(200);
        } catch (Exception e){
            kullanici_ulke_guncellemesi_icin_beklenen_verileri_girer();
            kullanici_ulke_guncellemesi_icin_istek_gonderir_ve_yanit_alir();
        }
        response.prettyPrint();
        System.out.println("response.getStatusCode() = " + response.getStatusCode());

    }

    @Then("Kullanici, ulke guncellemesi icin API kayitlarini dogrular")
    public void kullanici_ulke_guncellemesi_icin_apı_kayitlarini_dogrular() {


        Map<String, String> actualData = response.as(HashMap.class);
        assertEquals(expectedData.get("name"), actualData.get("name"));

    }


    //


    @Given("Kullanici Base Url i olusturur")
    public void kullanici_base_url_i_olusturur() {

        spec.pathParams("1","api","2","c-states");



    }

    @Given("Kullanici post istegini gonderir ve yanitini alir")
    public void kullanici_post_istegini_gonderir_ve_yanitini_alir() {

        Map<String, String> countryMap = new HashMap<>();
        countryMap.put("id","259332");
        countryMap.put("name","yeniulke2");
        expectedData = new HashMap<>();
        expectedData.put("name","yenisehir2");
        expectedData.put("country",countryMap);



        response = given().spec(spec)
                .headers("Authorization", "Bearer " +generateToken(),
                        "Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
                .body(expectedData)
                .when()
                .post("/{1}/{2}");

        try {
            response.then().statusCode(201);
        } catch (Exception e){
            kullanici_base_url_i_olusturur();

        }
        response.prettyPrint();
        System.out.println("response.getStatusCode() = " + response.getStatusCode());

        System.out.println();

    }

    @Then("Kullanici APi kayitlarini dogrular")
    public void kullanici_a_pi_kayitlarini_dogrular() {

        Map<String, String> actualData = response.as(HashMap.class);

        Assert.assertEquals(expectedData.get("name"), actualData.get("name"));
        System.out.println(expectedData.get("name"));
        System.out.println(actualData.get("name"));

    }







}
