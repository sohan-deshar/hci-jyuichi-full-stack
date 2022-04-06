package api.mongo.juichibackend.Utils;

import java.util.Random;

public abstract class Utils {
    public static String generateRandomString(int targetLength){
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int TARGETSTRINGLENGTH = targetLength;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(TARGETSTRINGLENGTH)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
