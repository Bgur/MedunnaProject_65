package stepDefinitions.Api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.Messages;

import static io.restassured.RestAssured.given;
import static utilities.Authentication2.generateToken;

public class US027Api {
    Response response;

    Messages  messages;



    @When("Kullanici{int} API kullanarak id {int} olan mesaji okur")
    public void kullaniciAPIKullanarakIdOlanMesajiOkur(int arg0, int arg1) {
        response=given()
                .header("Authorization", "Bearer "+ generateToken())
                .contentType(ContentType.JSON)
                .when()
                .get("https://medunna.com/api/c-messages/"+arg1);
        System.out.println(response.prettyPrint());
    }



    @Then("Kullanici{int} okudugu mesaji dogrular")
    public void kullaniciOkuduguMesajiDogrular(int arg0) throws JsonProcessingException {
        String expectedName="nameUS27TestApi1";
        String expectedEmail="emailUS27TestApi1@gmail.com";
        String expectedSubject="subjectUS27TestApi1";
        String expectedMessage="messageUS27TestApi1";

        ObjectMapper obj=new ObjectMapper();
        messages=obj.readValue(response.asString(),Messages.class);

        Assert.assertEquals(200,response.getStatusCode());
        Assert.assertEquals(expectedName,messages.getName());
        Assert.assertEquals(expectedEmail,messages.getEmail());
        Assert.assertEquals(expectedSubject,messages.getSubject());
        Assert.assertEquals(expectedMessage,messages.getMessage());

    }


    @When("Kullanici{int} API kullanarak mesaj olusturur")
    public void kullaniciAPIKullanarakMesajOlusturur(int arg0) {
        response=given()
                .header("Authorization", "Bearer "+ generateToken())
                .contentType(ContentType.JSON)
                .when()
                .body("{\"name\": \"nameUS27TestApiPostAutomation\",\n" +
                        "    \"email\": \"emailUS27TestApiPostAutomation@gmail.com\",\n" +
                        "    \"subject\": \"subjectUS27TestApiPostAutomation\",\n" +
                        "    \"message\": \"messageUS27TestApiPostAutomation\"\n" +
                        "}")
                .post("https://medunna.com/api/c-messages");
        System.out.println(response.prettyPrint());

    }

    @Then("Kullanici{int} mesaj olustugunu dogrular")
    public void kullaniciMesajOlustugunuDogrular(int arg0) throws JsonProcessingException {
    ObjectMapper obj=new ObjectMapper();
    messages=obj.readValue(response.asString(),Messages.class);
        String expectedName="nameUS27TestApiPostAutomation";
        String expectedEmail="emailUS27TestApiPostAutomation@gmail.com";
        String expectedSubject="subjectUS27TestApiPostAutomation";
        String expectedMessage="messageUS27TestApiPostAutomation";

        Assert.assertEquals(201,response.getStatusCode());
        Assert.assertEquals(expectedName,messages.getName());
        Assert.assertEquals(expectedEmail,messages.getEmail());
        Assert.assertEquals(expectedSubject,messages.getSubject());
        Assert.assertEquals(expectedMessage,messages.getMessage());


    }


}
