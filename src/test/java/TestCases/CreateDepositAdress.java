package TestCases;

import Pojos.CryptoCurrencyPojo;
import Pojos.CustomerInfoPojo;
import TestBaseURL.BitPaceBaseURL;
import Util.TokenUtilies;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class CreateDepositAdress extends BitPaceBaseURL {


    TokenUtilies tokenUtilies = new TokenUtilies();


    @Test
    public void createDepositAddress() {

        tokenUtilies.getTokenForAuto();

        spec.pathParams("customerPath", "customer", "depositPath", "deposit", "addressPath", "address");

        CustomerInfoPojo customer = new CustomerInfoPojo("20625123425","","","fryteceducation@gmail.com");
        CryptoCurrencyPojo cryptocurrency = new CryptoCurrencyPojo("BTC",customer);

        Response response =
                given().
                        headers("Authorization", "Bearer " + tokenUtilies.token).
                        contentType(ContentType.JSON).
                        spec(spec).
                        body(cryptocurrency).
                        when().
                        post("{customerPath}/{depositPath}/{addressPath}");

      //  response.prettyPrint();

        Map<String,Object> actualData = response.as(HashMap.class);
        assertEquals("Response Approved",actualData.get("message").toString());

    }

}
