package PomApiTests;

import PomApiTests.FIles.ApiPaths;
import PomApiTests.FIles.ConfigReader;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;
import PomApiTests.FIles.UserVariables;
import static io.restassured.RestAssured.given;

public class OTPverify {

    public static Response otpVerify(){

        String mobileNumber= UserVariables.getInstance().getMobileNumber();

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("otp", ConfigReader.get("OTP"));
        requestBody.put("mobile_number", mobileNumber);
        requestBody.put("otp_type", ConfigReader.get("OtpType"));

        return given()
                .baseUri(ApiPaths.ApiGwBaseUrl)
                .log().uri()
                .header("Content-Type", "application/json")
                .log().headers()
                .body(requestBody)
                .log().body()

                .when()
                .post(ApiPaths.OtpVerifyPath);
    }

}
