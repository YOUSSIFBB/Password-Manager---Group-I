/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package passwordmanager;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 *
 * @author youssif Cryptographic use of algorithms Reference:
 * https://stackoverflow.com/questions/22580853/reliable-implementation-of-pbkdf2-hmac-sha256-for-java
 * Reference of Password-Based Key Derivation Function 2:
 * https://github.com/SebastianDeiss/Java-PBKDF2 Reference for Hash based
 * message authentication thats is compatable with PBKDF2:
 * https://www.youtube.com/watch?v=WJP0l_RFyLE Reference:
 * https://blog.devgenius.io/java-password-management-top-methods-for-handling-and-storage-c1dc57947c8a
 * Reference : stack overflow code reference:
 * https://stackoverflow.com/questions/11412882/hash-password-in-c-bcrypt-pbkdf2/12719984#12719984
 *
 *
 */
public class PasswordEncryption {

    private static final int ITERATIONS = 10000;    //number of iterations, (make the value higher to make brute force attacks harder for hackers)
    private static final int KEY_LENGTH = 256;      //derived key length in bits
    private static final String ALGORITHM = "PBKDF2WithHmacSHA256";     //standard java Crptography Architecture(JCA)

    //method that computes and takes two varaibles, the password and salt are passed as parapamters, in which the method will gerenate the hashed passowrd back as a string
    public static String passwordHash(String password, String salt) {
        //convert user input into an array of characters (char)
        char[] passwordChars = password.toCharArray();
        //decode the salt string into a byte array
        byte[] slatBytes = Base64.getDecoder().decode(salt);
        //pass the array of characters, the salt tring & explain more
        KeySpec spec = new PBEKeySpec(passwordChars, slatBytes, ITERATIONS, KEY_LENGTH);

        try {
            //specefied algorithm "PBKDF2 with HMAC-SHA-256"
            SecretKeyFactory factory = SecretKeyFactory.getInstance(ALGORITHM);
            //generate the secret key
            byte[] hashBytes = factory.generateSecret(spec).getEncoded();
            //return the encoded key into a string using encodeTpString()
            return Base64.getEncoder().encodeToString(hashBytes);
            //exceptions for the algorithm and invalid key specifications
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
            return null;
        }
    }// end of password hash 

    //methof to generate the salt
    public static String generateSlat() {
        SecureRandom random = new SecureRandom();   //generation of crptographic numbers
        byte[] salt = new byte[16];    //create a byte array of 16 to store the salt
        random.nextBytes(salt);     //generate the by array for each letter randomly
        return Base64.getEncoder().encodeToString(salt);    //return the salt generate to string

    }

}
