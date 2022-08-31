
package stepDefinitions.Api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import pojos.Patient;
import utilities.*;

import static org.junit.Assert.assertEquals;


public class US015Api {


    Response response;
    private Patient actualPojo;


    @Given("kullanici Url'e get request gonderir ve response alir")
    public void kullanici_url_e_get_request_gonderir_ve_response_alir() {

        response = ApiUtils.getRequest(Authentication.generateToken(), ConfigReader.getProperty("patientsEndPoint") +
                "/" + ReadTxt.readLastLinePatientList(ConfigReader.getProperty("apiPatientIds"), 1));

        response.prettyPrint();

    }

    @Then("Status Code {int} oldugunu dogrular")
    public void statusCodeOldugunuDogrular(int statusCode) {
        response.then().assertThat().statusCode(200);
    }

    @And("response deserialize eder ve hasta bilgilerini dogrular")
    public void responseDeserializeEdilirVeHastaBilgileriDogrulanir() {
        Patient actualPojo;
        Patient expectedPojo = new Patient();
        expectedPojo.setPhone(ReadTxt.readLastLinePatientList(ConfigReader.getProperty("apiPatientIds"), 2));
        expectedPojo.setEmail(ReadTxt.readLastLinePatientList(ConfigReader.getProperty("apiPatientIds"), 3));
        expectedPojo.setLastName(ReadTxt.readLastLinePatientList(ConfigReader.getProperty("apiPatientIds"), 4));
        expectedPojo.setFirstName(ReadTxt.readLastLinePatientList(ConfigReader.getProperty("apiPatientIds"), 5));

        actualPojo = response.as(Patient.class);
        assertEquals(expectedPojo.getFirstName(), actualPojo.getFirstName());
        assertEquals(expectedPojo.getLastName(), actualPojo.getLastName());
        assertEquals(expectedPojo.getEmail(), actualPojo.getEmail());
        assertEquals(expectedPojo.getPhone(), actualPojo.getPhone());


    }

}

