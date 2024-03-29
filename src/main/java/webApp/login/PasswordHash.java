package webApp.login;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

public class PasswordHash {

    //Creating variables

    private static final String PBKDF2_ALGORITHM = "PBKDF2WithHmacSHA1";

    private static final int SALT_BYTES = 24;
    private static final int HASH_BYTES = 24;
    private static final int PBKDF2_ITERATIONS = 1000;

    private static final int ITERATION_INDEX = 0;
    private static final int SALT_INDEX = 1;
    private static final int PBKDF2_INDEX= 2;

    //Creating a password hash

    public static String createHash(String password) throws NoSuchAlgorithmException, InvalidKeySpecException{
        return createHash(password.toCharArray());
    }

     private static String createHash(char [] password) throws NoSuchAlgorithmException, InvalidKeySpecException{

        //Generate a random salt
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_BYTES];
        random.nextBytes(salt);

        //Hash the password
        byte[] hash= pbkdf2(password, salt, PBKDF2_ITERATIONS, HASH_BYTES);

        //format iterations: salt: hash
        return PBKDF2_ITERATIONS + ":" + toHex(salt) + ":" + toHex(hash);

    }

    //Password Validation

    public static boolean validatePassword(String password, String goodHash) throws NoSuchAlgorithmException,InvalidKeySpecException{
        return validatePassword(password.toCharArray(), goodHash);
    }

    private static boolean validatePassword(char[] password, String goodHash) throws NoSuchAlgorithmException, InvalidKeySpecException{

        //Decode the Hash into its parameters

        String [] params = goodHash.split(":");
        int iterations = Integer.parseInt(params[ITERATION_INDEX]);
        byte[] salt = fromHex(params[SALT_INDEX]);
        byte[] hash = fromHex(params[PBKDF2_INDEX]);

        //Compute the hash of the provided password, using the same salt, iteration count, and hash length

        byte[] testHash= pbkdf2(password, salt, iterations, hash.length);

        //Compare the hashes in constant time

        return slowEquals(hash, testHash);
    }

    //Compute the Hash

   private static byte[] pbkdf2(char[] password, byte[] salt, int iterations, int bytes) throws NoSuchAlgorithmException, InvalidKeySpecException{

        PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, bytes * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance(PBKDF2_ALGORITHM);
        return skf.generateSecret(spec).getEncoded();
    }

    //Compare Hashes

    private static  boolean slowEquals(byte[] a, byte[] b) {
        int diff = a.length ^ b.length;
        for( int i= 0; i < a.length && i < b.length; i++)
            diff |= a[i] ^ b[i];
        return diff == 0;
    }

    //Hex to byte array

    private static byte[] fromHex(String hex){
        byte [] binary = new byte[hex.length() / 2];
        for (int i = 0; i < binary.length; i++){
            binary[i] = (byte) Integer.parseInt( hex.substring(2 * i, 2 * i + 2), 16);
        }
        return binary;
    }

    //And back to byte

    private static String toHex(byte[] array){
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        if(paddingLength > 0){
            return String.format("%0" + paddingLength + "d", 0) + hex;
        }else{
            return hex;
        }
    }

}
