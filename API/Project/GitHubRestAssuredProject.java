package LiveProjects;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GitHubRestAssuredProject {

    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;
    String SSHKey;
    int SSHKeyId;

    @BeforeClass
    public void setUp() {
        requestSpec = new RequestSpecBuilder() //Build method using specification
                .setContentType(ContentType.JSON)
                .setBaseUri("https://api.github.com")
                //                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "token")
                .build();
    }

    @Test(priority = 1)
    public void postRequestTest() {
        //request body - java.util
        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("title", "FSTKey");
        reqBody.put("key", "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIBDnTDeiHFSOTdeNMdZl8V47pq5X50BrA0bIaBOwmySa");

        //Generate response - never write print statement in restassured
        /*Response response = given().log().all().spec(requestSpec)
                .body(reqBody).
                when().
                post().
                //petId = response.then().extract().path("id");
                //not to pass anything it will get from spec
                        then().spec( responseSpec)
                .body("name",equalTo("petA"));*/
    Response response = given().contentType(ContentType.JSON) // Set headers
            .body(reqBody)
            .when()
            .post("http://user/keys");
    }
}