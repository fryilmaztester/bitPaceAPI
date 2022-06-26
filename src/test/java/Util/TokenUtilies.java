package Util;

import TestData.GetTokenTestData;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class TokenUtilies {

    public String token;

    public  void getTokenForAuto() {

        String baseURL = "https://api-sandbox.bitpace.com/api/v1/auth/token";

        GetTokenTestData reqBodyObj = new GetTokenTestData();
        Map<String, String> reqBodyMap = reqBodyObj.reqTestDataBody();

        Response response =
                given().
                        contentType(ContentType.JSON).
                        body(reqBodyMap).
                        when().
                        post(baseURL);


        JsonPath jsonPath = response.jsonPath();
        token = jsonPath.getString("data.token");
    }
}
