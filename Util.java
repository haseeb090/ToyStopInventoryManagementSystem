package toystopinventorymanagementsystem;

import java.util.Random;

/**
 *
 * @author Fahad Satti
 */
public class Util implements java.io.Serializable{
    final static String ALPHA_SALT = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final static String ALPHANUM_SALT = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    
    public static String getSaltAlphaString() {
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 16) {
            int index = (int) (rnd.nextFloat() * ALPHA_SALT.length());
            salt.append(ALPHA_SALT.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
    public static String getSaltAlphaNumString() {
        
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 32) {
            int index = (int) (rnd.nextFloat() * ALPHANUM_SALT.length());
            salt.append(ALPHANUM_SALT.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

    static int getSaltNum(int bounds) {
        if(bounds<0)bounds = 2^32;
        Random salt  = new Random();
        return salt.nextInt(bounds);
    }
}
