package stepDefinitions.Api;


import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import pojos.User;
import utilities.ConfigReader;
import utilities.JsonUtil;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utilities.Authentication2.generateToken;
import static utilities.WriteToTxt.saveRegistrantApiData;

public class US001Api {

    User user=new User();
    Faker faker = new Faker();
    Response response;
    RequestSpecification spec;

    @When("Kullanici pathparams ayarlamasini yapar")
    public void kullanici_pathparams_ayarlamasini_yapar() {
        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
        spec.pathParams("first", "api", "second", "user","third","ssn=456-12-7852");


    }
       /*
c
        *  {
    "id": 152712,
    "login": "team65",
    "firstName": "Team",
    "lastName": "65",
    "ssn": "456-12-7852",
    "email": "healthteam65@gmail.com"}
    *
    * */
    /*
    {
    "id": 152712,
    "login": "team65",
    "firstName": "Team",
    "lastName": "65",
    "ssn": "456-12-7852",
    "email": "healthteam65@gmail.com",
    "imageUrl": null,
    "activated": false,
    "langKey": null,
    "createdBy": null,
    "createdDate": null,
    "lastModifiedBy": null,
    "lastModifiedDate": null,
    "authorities": null
}
     */

    @Then("Kullanici accountlarin bilgilerini alir")
    public void accountlarin_bilgilerini_alir() {

        response = given().spec(spec).contentType(ContentType.JSON)
                .header("Authorization","Bearer "+generateToken())
                .when()
                .get("/{first}/{second}/"+"?"+"{third}");
        System.out.println(response.asString());
    }

    @Then("Kullanici alinan bilgilerin dogrulamasini yapar")
    public void alinan_bilgilerin_dogrulamasini_yapar() {
        response.then().assertThat().statusCode(200);
     User expectedPojo= new User(152712,"team65","Team","65","456-12-7852","healthteam65@gmail.com",
             null,false,null,null,null,null,null,null);


       User actualPojo = JsonUtil.convertJsonToJavaObject(response.asString(), User.class);
       assertEquals(expectedPojo.getId(),actualPojo.getId());
       assertEquals(expectedPojo.getLogin(),actualPojo.getLogin());
       assertEquals(expectedPojo.getFirstName(),actualPojo.getFirstName());
       assertEquals(expectedPojo.getLastName(),actualPojo.getLastName());
       assertEquals(expectedPojo.getSsn(),actualPojo.getSsn());
       assertEquals(expectedPojo.getEmail(),actualPojo.getEmail());

    }

   // --------------------//tc06-----------------------------------------//

    @When("Kullanici gerekli path params ayarlar")
    public void kullanici_gerekli_path_params_ayarlar() {
        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
        spec.pathParams("first", "api", "second", "register");
    }

    @Then("Kullanici expected datalari girer")
    public void expected_datalari_girer() {
    String    firstname = faker.name().firstName();
    String    lastname = faker.name().lastName();
    String    ssn = faker.idNumber().ssnValid();
    String    email = faker.internet().emailAddress();
    String    username = faker.name().username();

      user.setFirstName(firstname);
      user.setLastName(lastname);
      user.setSsn(ssn);
      user.setEmail(email);
      user.setLogin(username);

    


    }

    @Then("Kullanici request gonderir ve response alir")
    public void kullanici_request_gonderir_ve_response_alir() {
        response = given().spec(spec).contentType(ContentType.JSON)
                .body(user)
                .when()
                .post("/{first}/{second}");
        response.prettyPrint();
    }

    @Then("Kullanici api kayitlarini dosyaya kaydeder")
    public void kullamici_api_kayitlarini_dosyaya_kaydeder() {
        saveRegistrantApiData(user);
    }

    @Then("Kullanici  api kayitlarini dogrular")
    public void kullanici_api_kayitlarini_dogrular() throws IOException {
        response.then().statusCode(200);
        response.prettyPrint();

        ObjectMapper obj = new ObjectMapper();


        User actualuser = JsonUtil.convertJsonToJavaObject(response.asString(), User.class);

        System.out.println("Actual Data: " + actualuser);

        Assert.assertEquals(user.getFirstName(), actualuser.getFirstName());
        Assert.assertEquals(user.getLastName(), actualuser.getLastName());
        Assert.assertEquals(user.getSsn(), actualuser.getSsn());
        Assert.assertEquals(user.getEmail(), actualuser.getEmail());
        Assert.assertEquals(user.getLogin(), actualuser.getLogin());
    }


}
