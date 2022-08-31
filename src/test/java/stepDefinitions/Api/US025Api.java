package stepDefinitions.Api;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.Assert;
import pojos.Appointment;
import pojos.Patient;
import pojos.US25_appointment;
import utilities.Authentication;
import utilities.ConfigReader;
import static io.restassured.RestAssured.given;
import static utilities.WriteToTxt.saveAppointmentApiDatalar;


public class US025Api {
    /*{
    "createdBy": "potilasoglu",
    "createdDate": "2022-08-30T21:15:01.054531Z",
    "id": 254203,
    "startDate": "2024-08-30T00:00:00Z",
    "endDate": "2024-08-30T01:00:00Z",
    "status": "UNAPPROVED",
    "anamnesis": null,
    "treatment": null,
    "diagnosis": null,
    "prescription": null,
    "description": null,
    "physician": null,
    "patient": {
        "createdBy": "potilasoglu",
        "createdDate": "2022-08-30T21:15:01.054207Z",
        "id": 253908,
        "firstName": "Alecia",
        "lastName": "rzwtmwuyos9",
        "birthDate": null,
        "phone": "455-455-4555",
        "gender": null,
        "bloodGroup": null,
        "adress": null,
        "email": "hubert.nicolas@yahoo.com",
        "description": null,
        "user": {
            "createdBy": "potilasoglu",
            "createdDate": "2022-08-30T21:15:01.053709Z",
            "id": 252148,
            "login": "user_112233445_56677889991661894100936",
            "firstName": "Alecia",
            "lastName": "rzwtmwuyos9",
            "email": "hubert.nicolas@yahoo.com",
            "activated": false,
            "langKey": null,
            "imageUrl": null,
            "resetDate": null,
            "ssn": "410-65-5405"
        },
        "inPatients": null,
        "country": null,
        "cstate": null
    },
    "ctests": null
}*/

    US25_appointment us25appointment=new US25_appointment();
    Appointment us25Appo=new Appointment();
    Faker faker=new Faker();
    Response response;
    Response response2;
    public static RequestSpecification spec1;

    @Given("kullanici gerekli path params ayarlari yapar")
    public void kullanici_gerekli_path_params_ayarlari_yapar() {

        spec1 = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("baseUrl")).build();
        spec1.pathParams("bir","api","iki","appointments");


        //https://www.medunna.com/api/appointments/
    }

    @Given("kullanici expected datalari girer {string} {string} {string} {string} {string} {string}")
    public void kullanici_expected_datalari_girer(String firstname, String lastname, String Ssn, String email, String phone, String DateTime) {

//        firstname=faker.name().firstName();
//        lastname=faker.name().lastName();
//        Ssn=faker.idNumber().ssnValid();
//        email=faker.internet().emailAddress();
        // phone=faker.phoneNumber().phoneNumber();
        //  Datete=



        us25appointment.setFirstname(firstname);
        us25appointment.setLastname(lastname);
        us25appointment.setSsn(Ssn);
        us25appointment.setEmail(email);
        us25appointment.setPhone(phone);
        us25appointment.setDateTime(DateTime);



    }

    @Given("kullanici request gonderir ve response alir")
    public void kullanici_request_gonderir_ve_response_alir() {
//        RequestSpecification spec = new RequestSpecBuilder().setBaseUri("https://medunna.com").build();
//        spec.pathParams("first","api", "second", "users");
//        given().headers().spec(spec).when().get("/{first}/{second}");

        //.headers("Authorization","Bearer "+ AuthenticationYeni.generateToken())
        String token=Authentication.generateToken();

        response=given().spec(spec1)
                .headers("Authorization","Bearer "+ token)
                .contentType(ContentType.JSON)
                .body(us25appointment)
                .when()
                .get("/{bir}/{iki}");
                //.post("/{bir}/{iki}");
        System.out.println(token);
        System.out.println("======================================");
        System.out.println(response.getStatusCode());
        response.prettyPrint();
        System.out.println("======================================");
        us25Appo.setAnamnesis("gerizekali");
        us25Appo.setCreatedBy("SAHANEN");
        us25Appo.setDateTime("30.08.2023");
        us25Appo.setDescription("spastik");
        us25Appo.setPhysician("LAAKARINEN");


//        response2=given().headers("Authorization", "Bearer"+Authentication.generateToken(),ContentType.JSON,"Accept", ContentType.JSON).body()
//                .contentType(ContentType.JSON).when().post(ConfigReader.getProperty("postAppointment"));


    }
    @Given("kullanici Api kayitlarini dosyaya kaydeder")
    public void kullanici_api_kayitlarini_dosyaya_kaydeder() {

        saveAppointmentApiDatalar(us25appointment);

    }
    @Given("kullanici Api kayitlari dogrular")
    public void kullanici_api_kayitlari_dogrular() {

        response.then().statusCode(200);
//        Assert.assertEquals(response.statusCode(),200);
//        Assert.assertEquals(response.body(),200);
//        Assert.assertEquals(us25appointment.getFirstname(),200);
//        Assert.assertEquals(response.statusCode(),200);
//        Assert.assertEquals(response.statusCode(),200);
        response.prettyPrint();
        // HashMap<String,Object>actual=response.as(HashMap.class);
        // System.out.println("actual = " + actual);

    }


}
