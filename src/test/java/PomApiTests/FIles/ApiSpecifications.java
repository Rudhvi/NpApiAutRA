package PomApiTests.FIles;
import PomApiTests.UserLogin;
import io.restassured.response.*;


public class ApiSpecifications {
    public static void main (String[]args){
        Response res = UserLogin.loginUser();

        res.then().statusCode(401);
        System.out.println("Login API response\n" + res.asPrettyString());


    }
}
