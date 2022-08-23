package stepDefinitions.Api;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import utilities.ConfigReader;

import static org.hamcrest.Matchers.matchesPattern;
import static utilities.ApiUtils.getRequest;
import static utilities.Authentication2.generateToken;

public class US002Api {
    Response response;
    @When("kullanici pathparams ve bearer token ayarlamasini yapar")
    public void kullanici_pathparams_ve_bearer_token_ayarlamasini_yapar() {
        response=getRequest(generateToken(), ConfigReader.getProperty("medunnaAccount"));
    }
    @Then("kullanici adini dogrular")
    public void kullanici_adini_dogrular() {
        response.then().assertThat().body("login",matchesPattern("team65"));
    }

}
