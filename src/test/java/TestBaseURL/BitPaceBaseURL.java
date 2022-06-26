package TestBaseURL;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BitPaceBaseURL {

    protected static RequestSpecification spec;

    @Before
    public void setUp(){
        spec = new RequestSpecBuilder().setBaseUri("https://api-sandbox.bitpace.com/api/v1/").build();
    }


}
