package food.togo.customer.util;

import java.security.AlgorithmParameters;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public class CustomerUtil {

    private static int iterations = 10000  ;
    private static int keySize = 128;
    private static byte[] ivBytes = null;
    private static SecretKeyFactory skf;

    private static String encryptionKey = "68PU8r12#$@";

    private static String ALGORITHM = "PBKDF2WithHmacSHA256";

    private static String ENCRYPTION_ALGORITHM = "AES";

    private static String SECURE_RANDOM_ALGORITHM = "SHA1PRNG";

    private static String PADDING = "CBC/PKCS5Padding";

    static {
        try {
            skf = SecretKeyFactory.getInstance(ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }


    public static void main(String []args) throws Exception {

        String salt = getSalt();
        System.out.println("salt: " + salt);

        char[] message = "PasswordToEncrypt".toCharArray();
        System.out.println("Message: " + String.valueOf(message));
        String encryptedMsg =  encrypt(message, salt);
        System.out.println("Encrypted: " + encryptedMsg);
        System.out.println("Decrypted: " + decrypt(encryptedMsg.toCharArray(), salt));
    }



    public static String encrypt(char[] plaintext, String salt) throws Exception {
        byte[] saltBytes = salt.getBytes();


        PBEKeySpec spec = new PBEKeySpec(encryptionKey.toCharArray(), saltBytes, iterations, keySize);
        SecretKey secretKey = skf.generateSecret(spec);
        SecretKeySpec secretSpec = new SecretKeySpec(secretKey.getEncoded(), ENCRYPTION_ALGORITHM);

        Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM+"/"+PADDING);
        cipher.init(Cipher.ENCRYPT_MODE, secretSpec);
        AlgorithmParameters params = cipher.getParameters();
        ivBytes = params.getParameterSpec(IvParameterSpec.class).getIV();
        byte[] encryptedTextBytes = cipher.doFinal(String.valueOf(plaintext).getBytes("UTF-8"));

        return DatatypeConverter.printBase64Binary(encryptedTextBytes);
    }

    public static String decrypt(char[] encryptedText, String salt) throws Exception {

        System.out.println(encryptedText);
        byte[] saltBytes = salt.getBytes();

        byte[] encryptedTextBytes = DatatypeConverter.parseBase64Binary(new String(encryptedText));

        SecretKeyFactory skf = SecretKeyFactory.getInstance(ALGORITHM);
        PBEKeySpec spec = new PBEKeySpec(encryptionKey.toCharArray(), saltBytes, iterations, keySize);
        SecretKey secretKey = skf.generateSecret(spec);

        SecretKeySpec secretSpec = new SecretKeySpec(secretKey.getEncoded(), ENCRYPTION_ALGORITHM);

        Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM+"/"+PADDING);
        cipher.init(Cipher.DECRYPT_MODE, secretSpec, new IvParameterSpec(ivBytes));

        byte[] decryptedTextBytes = null;

        try {
            decryptedTextBytes = cipher.doFinal(encryptedTextBytes);
        }   catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }   catch (BadPaddingException e) {
            e.printStackTrace();
        }

        return new String(decryptedTextBytes);

    }

    public static String getSalt() throws Exception {

        SecureRandom sr = SecureRandom.getInstance(SECURE_RANDOM_ALGORITHM);
        byte[] salt = new byte[20];
        sr.nextBytes(salt);
        return new String(salt);
    }

    //PBKDF2 password hashing
    public static String hashPassword(String password, byte[] salt)  throws Exception {
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, keySize);
        SecretKeyFactory f = SecretKeyFactory.getInstance(ALGORITHM);
        byte[] hash = f.generateSecret(spec).getEncoded();
        Base64.Encoder enc = Base64.getEncoder();
        System.out.printf("salt: %s%n", enc.encodeToString(salt));
        System.out.printf("hash: %s%n", enc.encodeToString(hash));

        return enc.encodeToString(hash);

    }
}