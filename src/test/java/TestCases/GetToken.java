package TestCases;

import TestBaseURL.BitPaceBaseURL;
import TestData.GetTokenTestData;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

import java.util.Map;

public class GetToken extends BitPaceBaseURL {

    public static String token;

    @Test
    public void getToken() {

        spec.pathParams("authPath", "auth", "tokenPath", "token");

        GetTokenTestData reqBodyObj = new GetTokenTestData();
        Map<String, String> reqBodyMap = reqBodyObj.reqTestDataBody();

        System.out.println("reqBodyMap: " + reqBodyMap);

        Response response =
                given().
                        contentType(ContentType.JSON).
                        spec(spec).
                        body(reqBodyMap).
                        when().
                        post("/{authPath}/{tokenPath}");

       // response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        token = jsonPath.getString("data.token");



    }

}
