package PomApiTests.FIles;
import PomApiTests.PortalLogin;
import io.restassured.response.*;


public class ApiSpecifications {
    public static void main (String[]args){
        Response res = PortalLogin.loginUser();

        res.then().statusCode(200);
        System.out.println("Login API response\n" + res.asPrettyString());


    }
}
