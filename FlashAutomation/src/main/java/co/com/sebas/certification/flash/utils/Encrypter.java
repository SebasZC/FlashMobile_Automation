package co.com.sebas.certification.flash.utils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class Encrypter {

    private static SecretKeySpec createPassword(String password) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        byte[] passwordEncrypted = password.getBytes("UTF-8");

        MessageDigest sha = MessageDigest.getInstance("SHA-1");

        passwordEncrypted = sha.digest(passwordEncrypted);
        passwordEncrypted = Arrays.copyOf(passwordEncrypted, 16);

        SecretKeySpec secretKey = new SecretKeySpec(passwordEncrypted, "AES");

        return secretKey;
    }


    public static String decrypt(String dataEncrypted, String secretPassword) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        SecretKeySpec secretKey = createPassword(secretPassword);

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] bytesEncrypt = Base64.getDecoder().decode(dataEncrypted);
        byte[] dataEncrypt = cipher.doFinal(bytesEncrypt);
        String data = new String(dataEncrypt);

        return data;
    }
}
