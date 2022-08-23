package stepDefinitions.Api;

import io.cucumber.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojos.Appointment;
import utilities.ConfigReader;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static utilities.Authentication2.generateToken;

public class US010Api {
    Response response;
    Appointment actualAppointment;
    public static RequestSpecification spec;

    @Given("Doktor Medunna randevu API endpointini {string} ile olusturur")
    public void doktorMedunnaRandevulerAPIEndpointiniIleOlurturur(String id) {
        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
        spec.pathParams("1", "api", "2", "appointments", "3", id);
    }
    @Then("Doktor randevu icin Get request olusturur ve gonderir")
    public void doktor_randevu_icin_get_request_i_olusturu_ve_gonderir() {
        response = given().spec(spec).header("Authorization", "Bearer "+ generateToken())
                .contentType(ContentType.JSON)
                .when()
                .get("/{1}/{2}/{3}/");
    }
    @Then("Doktor randevu icin Get response alir")
    public void doktor_randevu_icin_get_response_i_alir() {
       response.prettyPrint();
    }
    @Given("Doktor Status Kodun {int} oldugunu dogrular")
    public void doktor_status_kodun_oldugunu_dogrular(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }
    @Given("Doktor gelen json randevu datalarini javaya donusturur")
    public void doktor_gelen_json_randevu_datalarini_javaya_donusturur(){
       // ObjectMapper obj = new ObjectMapper();
       // Appointment actualAppointment =obj.readValue(response.asString(),Appointment.class);
        actualAppointment = response.as(Appointment.class);

    }
    @Given("Doktor gelen randevu datalarini kayit eder")
    public void doktor_gelen_randevu_datalarini_kayit_eder() {
        //saveAppointData(actualAppointment);
    }

    @Given("Doctor API ile gelen datalar {string} {string} {string} {string} dogrular")
    public void doctor_api_ile_gelen_datalar_dogrular(String patientId, String startDate, String endDate, String status) {
        assertEquals(Integer.parseInt(patientId), actualAppointment.getPatient().getId());
        assertEquals(startDate, actualAppointment.getStartDate());
        assertEquals(endDate, actualAppointment.getEndDate());
        assertEquals(status,actualAppointment.getStatus());
    }


}
