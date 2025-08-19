package PomApiTests.FIles;
import PomApiTests.OTPverify;
import PomApiTests.PortalLogin;
import PomApiTests.RegistrationAttempt;
import io.restassured.response.*;


public class ApiSpecifications {
    public static void main (String[]args){

        try {
            Response res = PortalLogin.loginUser();

            res.then().statusCode(200);
            System.out.println("Login API response\n" + res.asPrettyString());
        }catch (AssertionError e){
            System.err.println("❌ Portal Login API failed" + e.getMessage());
        }

        try {
            Response res1 = RegistrationAttempt.UserAttempt();

            res1.then().statusCode(200);
            System.out.println("Registration attempt API response\n" + res1.asPrettyString());
        } catch (AssertionError e) {
            System.err.println("❌ Registration Attempt API failed: " + e.getMessage());
        }

        try {
            Response res2 = OTPverify.otpVerify();

            res2.then().statusCode(200);
            System.out.println("Registration OTP verify API response\n" + res2.asPrettyString());
        } catch (AssertionError e) {
            System.err.println("❌ OTP Verify API failed: " + e.getMessage());
        }

    }
}
