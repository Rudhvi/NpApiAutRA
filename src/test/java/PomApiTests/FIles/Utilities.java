package PomApiTests.FIles;

import java.util.Random;

public class Utilities {

    public static String generateRandomMobileNumber() {
        Random random = new Random();
        StringBuilder mobile = new StringBuilder();

        // 1st and 2nd digits: "01"
        mobile.append("01");

        // 3rd digit: randomly pick from allowed digits
        int[] allowedThirdDigits = {7, 8, 6, 3, 5};
        int thirdDigit = allowedThirdDigits[random.nextInt(allowedThirdDigits.length)];
        mobile.append(thirdDigit);

        // 4th–7th digits: fixed zeros
        mobile.append("0000");

        // 8th–11th digits: random 4 digits
        for (int i = 0; i < 4; i++) {
            mobile.append(random.nextInt(10)); // 0–9
        }

        return mobile.toString();
    }
}