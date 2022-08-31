package stepDefinitions.Api;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.codehaus.jackson.map.ObjectMapper;
import pojos.US017pojo;
import pojos.US017pojoPost;
import pojos.User;
import utilities.ConfigReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static utilities.Authentication2.generateToken;

public class US017Api {
    User user = new User();
    Faker faker = new Faker();
    Response response;
    RequestSpecification spec;
    String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZWFtNjUiLCJhdXRoIjoiUk9MRV9BRE1JTiIsImV4cCI6MTY2MTk2MjQzNn0.D5epCJIBBcJHDWKdNcdmHDK_xqx79MNBXyeZhONaj-H7CPQR70x6rIyvTD0kaBQ2CA7wqcZYTBUvoktw6yWW0Q";

    US017pojo[] testItems;
    US017pojoPost us017pojoPost = new US017pojoPost();
    US017pojo us017pojoPut = new US017pojo();

    /*
    [
  {
    "createdBy": "string",
    "createdDate": "2022-08-30T15:10:05.765Z",
    "defaultValMax": "string",
    "defaultValMin": "string",
    "description": "string",
    "id": 0,
    "name": "string",
    "price": 0
  }
]
     */


    @Given("kullanici test itemlar icin get request yapar")
    public void kullaniciTestItemlarIcinGetRequestYapar() {
        response = given().headers("Authorization", "Bearer " + generateToken(), "Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                when().
                get(ConfigReader.getProperty("baseUrl_17_endpoint"));
        response.then().assertThat().statusCode(200);
        // response.prettyPrint();

    }

    @And("kullanici gelen test item datayi deserialize yapar")
    public void kullaniciGelenTestItemDatayiDeserializeYapar() throws IOException {
        ObjectMapper obj = new ObjectMapper();
        testItems = obj.readValue(response.asString(), US017pojo[].class);

        System.out.println("kac tane item" + testItems.length);
        for (int i = 0; i < 20; i++) {
            System.out.println(testItems[i].getPrice());

        }

    }


    @Given("kullanici test itemlar icin post request yapar")
    public void kullaniciTestItemlarIcinPostRequestYapar() {

        //Set the expected data/ istenilen datayi ekle
        us017pojoPost.setCreatedBy("team65");
        us017pojoPost.setDescription("def");
        us017pojoPost.setDefaultValMin("115");
        us017pojoPost.setName("dogrulandi14");
        us017pojoPost.setPrice(19);
        us017pojoPost.setDefaultValMax("16");


        response = given().headers("Authorization", "Bearer " + generateToken(), "Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                body(us017pojoPost).contentType(ContentType.JSON).when().post(ConfigReader.getProperty("baseUrl_17_endpoint_post"));
        response.then().assertThat().statusCode(201);


    }

    @Then("kullanici post request validation yapar")
    public void kullaniciPostRequestValidationYapar() throws Exception {

        ObjectMapper obj = new ObjectMapper();
        US017pojoPost actualDatapost = obj.readValue(response.asString(), US017pojoPost.class);
        assertEquals(us017pojoPost.getPrice(), actualDatapost.getPrice());
        assertEquals(us017pojoPost.getDescription(), actualDatapost.getDescription());
        response.then().assertThat().statusCode(201);
        response.prettyPrint();


        //1. validation
        //response.then().assertThat().statusCode(201);
       /*response.then().assertThat().
                body("CreatedBy",equalTo("createdBy")).
                body("Description",equalTo("description")).
                body("DefaultValMin",equalTo("defaultValMin")).
                body("DefaultValMax",equalTo("defaultValMax")).
                body("Name",equalTo("name"));

        */


//diger validation

        Map<String, Object> actualMap = response.as(HashMap.class);
        System.out.println(actualMap);
        assertEquals(us017pojoPost.getCreatedBy(), actualMap.get("createdBy"));
        assertEquals(us017pojoPost.getDescription(), actualMap.get("description"));
        assertEquals(us017pojoPost.getDefaultValMin(), actualMap.get("defaultValMin"));
        assertEquals(us017pojoPost.getDefaultValMax(), actualMap.get("defaultValMax"));
        assertEquals(us017pojoPost.getPrice(), actualMap.get("price"));
        assertEquals(us017pojoPost.getName(), actualMap.get("name"));

        response.then().assertThat().statusCode(201);


    }

    @Given("kullanici test itemlar icin put request yapar")
    public void kullaniciTestItemlarIcinPutRequestYapar() {


        us017pojoPut.setCreatedBy("team65");
        us017pojoPut.setId(254754);
        us017pojoPut.setPrice(33);
        us017pojoPut.setDescription("krallll");
        us017pojoPut.setDefaultValMax("10001");
        us017pojoPut.setDefaultValMin("100");
        us017pojoPut.setName("yeni");


        response = given().headers("Authorization", "Bearer " + generateToken(), "Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                body(us017pojoPut).contentType(ContentType.JSON).when().put(ConfigReader.getProperty("baseUrl_17_endpoint_post"));


        response.prettyPrint();


    }

    @Then("kullanici put request validation yapar")
    public void kullaniciPutRequestValidationYapar() {
        Map<String, Object> actualMap = response.as(HashMap.class);
        System.out.println(actualMap);
        assertEquals(us017pojoPut.getCreatedBy(), actualMap.get("createdBy"));
        assertEquals(us017pojoPut.getDescription(), actualMap.get("description"));
        assertEquals(us017pojoPut.getDefaultValMin(), actualMap.get("defaultValMin"));
        assertEquals(us017pojoPut.getDefaultValMax(), actualMap.get("defaultValMax"));
        assertEquals(us017pojoPut.getPrice(), actualMap.get("price"));
        assertEquals(us017pojoPut.getName(), actualMap.get("name"));
        System.out.println(actualMap);

        response.then().assertThat().statusCode(200);


    }

    @Given("kullanici Delete request eder {string}")
    public void kullaniciDeleteRequestEder(String id) {

        response = given().headers("Authorization", "Bearer " + generateToken(), "Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                body(us017pojoPut).contentType(ContentType.JSON).when().delete(ConfigReader.getProperty("baseUrl_17_endpoint_post") + "/" + id);
    }

    @Then("delete validation")
    public void deleteValidation() {
        response.then().statusCode(204);
    }
}
