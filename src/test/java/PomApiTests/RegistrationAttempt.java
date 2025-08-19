package PomApiTests;

import PomApiTests.FIles.ApiPaths;
import PomApiTests.FIles.ConfigReader;
import PomApiTests.FIles.UserVariables;
import PomApiTests.FIles.Utilities;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RegistrationAttempt {
    public static Response UserAttempt(){

        String mobileNumber = Utilities.generateRandomMobileNumber();
        UserVariables.getInstance().setMobileNumber(mobileNumber);

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("name", ConfigReader.get("name"));
        requestBody.put("uuid", ConfigReader.get("uuid"));
        requestBody.put("app_type", ConfigReader.get("app_type"));
        requestBody.put("device_id", ConfigReader.get("device_id"));
        requestBody.put("device_type", ConfigReader.get("device_type"));
        requestBody.put("mobile_number", mobileNumber);


        return given()
                .baseUri(ApiPaths.ApiGwBaseUrl)
                .log().uri()
                .header("Content-Type", "application/json")
                .log().headers()
                .body(requestBody)
                .log().body()

                .when()
                .post(ApiPaths.RegistrationAttemptPath);
    }

}

