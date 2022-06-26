package TestCases;

import TestBaseURL.BitPaceBaseURL;
import Util.TokenUtilies;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.hamcrest.Matchers.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import static io.restassured.RestAssured.given;


public class IncorrectCryptocurrencyCode extends BitPaceBaseURL {

    TokenUtilies tokenUtilies = new TokenUtilies();


    @Test
    public void getInccorectCurrencyCode() {

        tokenUtilies.getTokenForAuto();

        spec.pathParams("buyPath", "buy", "pricePath", "prices", "cryptocurrencyCodePath", "etc");


        Response response =
                given().
                        headers("Authorization", "Bearer " + tokenUtilies.token).
                        contentType(ContentType.JSON).
                        spec(spec).
                        when().
                        get("{buyPath}/{pricePath}/{cryptocurrencyCodePath}");


        response.then().assertThat().body("message", equalTo("Unsupported cryptocurrency"));
    }

}
