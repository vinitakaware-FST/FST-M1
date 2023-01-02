package LiveProjects;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

@ExtendWith(PactConsumerTestExt.class)
//it's test class
public class ConsumerTest {
    //headers
    Map<String, String> headers = new HashMap<>();
    //resource path
    String resourcePath = "/api/users";

    //create the pact method
    @Pact(consumer = "UserConsumer", provider = "UserProvider")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        //Add the headers
        headers.put("Content-Type", "application/json");

        //add the request body and provide example value
        DslPart requestResponseBody = new PactDslJsonBody()
                .numberType("id", 123)
                .stringType("firstName", "Vinita")
                .stringType("lastName","Kaware")
                .stringType("email","vinitakaware@yahoo.in");

        //Generate the pact - can write with return stmt
        return builder.given("A request to create user")
        //request pull from server and trace server
            .uponReceiving("A request to create user")
                .method("POST")
                .path(resourcePath)
                .headers(headers)
                .body(requestResponseBody)
            .willRespondWith()
                .status(201)
                .body(requestResponseBody)
            .toPact();
    }
    //pact only work with junit not with testng
    @Test
    @PactTestFor(providerName = "UserProvider", port = "8282")
    //avoid 8585, port 8088 or 9000 any other will work
    public void consumerTest()
    {
        //Mock server address
        String serverURL = "http://localhost:8282";

        //create request body
        Map<String,Object> reqBody = new HashMap<>();
        reqBody.put("id",123);
        reqBody.put("firstName","Vinita");
        reqBody.put("lastName","Kaware");
        reqBody.put("email","vinitakaware@yahoo.in");

        //Generate response
        given().headers(headers).body(reqBody)
                .when().post(serverURL + resourcePath)
                .then().log().body().statusCode(201);

    }
}

