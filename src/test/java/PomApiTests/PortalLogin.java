package PomApiTests;

import java.util.HashMap;
import java.util.Map;
import PomApiTests.FIles.ApiPaths;
import PomApiTests.FIles.TestConstants;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class PortalLogin {

    public static Response loginUser(){
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("username", PomApiTests.FIles.TestConstants.UserName);
        requestBody.put("password", PomApiTests.FIles.TestConstants.PassWord);


        return given()
                .baseUri(TestConstants.ApiGwBaseUrl)
                .log().uri()
                .header("Content-Type", "application/json")
                .log().headers()
                .body(requestBody)
                .log().body()

                .when()
                .post(ApiPaths.loginPath);
    }

}

