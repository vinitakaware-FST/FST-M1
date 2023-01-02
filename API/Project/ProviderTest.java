package LiveProjects;

import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit5.HttpTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;

@Provider("UserProvider")
@PactFolder("target/pacts")
//@PactBroker or PactUrl we can use
public class ProviderTest {
    @BeforeEach
    public void setUp(PactVerificationContext context)
            //it does current interaction, it sets the target for user provider
    {
        HttpTestTarget target = new HttpTestTarget("localhost", 8585);
        context.setTarget(target);
    }
    //repeat steps - verify interactions, so we created template so all test use same

    @TestTemplate
    @ExtendWith(PactVerificationInvocationContextProvider.class)
    public void providerTest(PactVerificationContext context)
    {
        context.verifyInteraction();

    }
    @State("A request to create user")
    public void state1()
    {}
}
