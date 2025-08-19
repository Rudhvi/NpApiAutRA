package PomApiTests.FIles;

public class UserVariables {

    private static UserVariables instance = null;

    public static UserVariables getInstance() {
        if(instance==null){
            synchronized (UserVariables.class) {
                if (instance == null) {
                    instance = new UserVariables();
                }
            }
        }
        return instance;
    }

    private UserVariables() {
    }


    private String mobileNumber;
    private String token;


    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


}
