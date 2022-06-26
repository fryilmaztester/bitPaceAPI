package TestCases;

import TestBaseURL.BitPaceBaseURL;
import Util.TokenUtilies;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.junit.Assert.*;

import org.junit.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class ReceivedBuyBtcPrice extends BitPaceBaseURL {


    TokenUtilies tokenUtilies = new TokenUtilies();


    @Test
    public void getBTCPrice() {

        tokenUtilies.getTokenForAuto();

        spec.pathParams("buyPath", "buy", "pricePath", "prices", "cryptocurrencyCodePath", "BTC");


        Response response =
                given().
                        headers("Authorization", "Bearer " + tokenUtilies.token).
                        contentType(ContentType.JSON).
                        spec(spec).
                        when().
                        get("{buyPath}/{pricePath}/{cryptocurrencyCodePath}");

      //  response.prettyPrint();


        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);

        JsonPath json = response.jsonPath();
        assertEquals("BTC",json.getString("data.cryptocurrency"));
        assertTrue(json.getString("message").contains("Approved"));
    }

}
