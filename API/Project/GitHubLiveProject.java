package LiveProjects;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class GitHubLiveProject {

    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;
    String SSHKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIBDnTDeiHFSOTdeNMdZl8V47pq5X50BrA0bIaBOwmySa gmx\\0020q7744@WIN-LG9IRS5NRNH";

    @BeforeClass
    public void setUp() {
        requestSpec = new RequestSpecBuilder() //Build method using specification
                .setBaseUri("https://api.github.com")
                .setContentType("application/json")
                .addHeader("Authorization", "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")
                .build();

        responseSpec =  new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectResponseTime(lessThan(3000L))
                .build();
    }

    @Test(priority = 1)
    public void postRequestTest()
    {
        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("title","FSTKey");
        reqBody.put("key", "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIBDnTDeiHFSOTdeNMdZl8V47pq5X50BrA0bIaBOwmySa gmx\\0020q7744@WIN-LG9IRS5NRNH");


        //Generate response - never write print statement in restassured
        given().log().all().spec(requestSpec)
                .body(reqBody).
                when().
                post().
                        then().spec( responseSpec)
                .body("title",equalTo("FSTKey"));

    }

    @Test(priority = 2)
    public void getRequestTest()
    {
        //generate response
        given().log().all().spec(requestSpec)
                .pathParam("title","FSTKey")
                .when()
                .get("/{title}") //match with pathParam
                .then().spec( responseSpec);

    }
    @Test(priority = 3)
    public void deleteRequestTest()
    {
        given().log().params().spec(requestSpec)
                .pathParam("title","FSTKey")
                .when()
                .delete("/{title}") //match with pathParam
                .then().body("message",equalTo("FSTKey"))
                .time(lessThan(3000l));

    }
}

