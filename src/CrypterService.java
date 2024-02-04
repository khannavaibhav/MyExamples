
import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.Formatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Encryption/Decryption service
 * @author amitkapps
 */
public class CrypterService {



    private static final String PASS_PHRASE = "C@sf79";
    private static final int ITERATION_COUNT = 23;

    private Cipher ecipher;
    private Cipher dcipher;

    private byte[] salt = {
            (byte)0x1E, (byte)0xAA, (byte)0xF9, (byte)0x02,
            (byte)0x42, (byte)0xBC, (byte)0x2E, (byte)0xCD
    };


    CrypterService() throws NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException, NoSuchPaddingException, InvalidAlgorithmParameterException {
        try {
            String passPhrase = PASS_PHRASE;
            // Create the key
            KeySpec keySpec = new PBEKeySpec(passPhrase.toCharArray(), salt, ITERATION_COUNT);
            SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);
            ecipher = Cipher.getInstance(key.getAlgorithm());
            dcipher = Cipher.getInstance(key.getAlgorithm());

            // Prepare the parameter to the ciphers
            AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, ITERATION_COUNT);

            // Create the ciphers
            ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
            dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
        } catch (InvalidAlgorithmParameterException | InvalidKeySpecException | NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException e) {
            throw e;
        }
    }

    public String encrypt(String str) {
        try {
            // Encode the string into bytes using utf-8
            byte[] utf8 = str.getBytes("UTF8");

            // Encrypt
            byte[] enc = null;
            //Since we're using it as a single instance (For whatever reason), methods would need synchronization.
            synchronized(ecipher){
                enc = ecipher.doFinal(utf8);
            }

            // Encode bytes to base64 to get a string
            return Base64.getEncoder().encodeToString(enc);
        } catch (javax.crypto.BadPaddingException | IllegalBlockSizeException | UnsupportedEncodingException e) {
        	e.printStackTrace();
        }
        return null;
    }

    public String decrypt(String str) {
        try {
            // Decode base64 to get bytes
            byte[] dec = Base64.getDecoder().decode(str);

            // Decrypt
            byte[] utf8 = null;
            //Since we're using it as a single instance (For whatever reason), methods would need synchronization.
            //Without this concurrent decryption was corrupting the results/throwing BadPadding Exception.
            synchronized(dcipher){
                utf8 = dcipher.doFinal(dec);
            }

            // Decode using utf-8
            return new String(utf8, "UTF8");
        } catch (BadPaddingException | IllegalBlockSizeException | IOException e) {
            e.printStackTrace();
        }
        System.out.println("RETURNING NULL !!!!");
        return null;
    }

    private Pattern CRYPT_PUBLIC_PATTERN = Pattern.compile("crypt\\{(.*)\\}");
    private String CRYPT_PUBLIC_FORMAT_TEXT = "crypt{%s}";

    String getPublicRepresentation(String text){
        if(isPublicRepresentation(text))
            return text;
        else{
            try (Formatter formatter = new Formatter()) {
                return formatter.format(CRYPT_PUBLIC_FORMAT_TEXT, encrypt(text)).toString();
            }
        }
    }

    public String getRawPublicRepresentation(String text){
        if(isPublicRepresentation(text))
            return text;
        else{
            try (Formatter formatter = new Formatter()) {
                return formatter.format(CRYPT_PUBLIC_FORMAT_TEXT, text).toString();
            }
        }
    }

    boolean isPublicRepresentation(String text){
        if(null == text)
            return false;
        Matcher matcher = CRYPT_PUBLIC_PATTERN.matcher(text);
        return matcher.matches();
    }

    String getPrivateRepresentation(String text){
        if(null == text)
            return null;
        Matcher matcher = CRYPT_PUBLIC_PATTERN.matcher(text);
        if(matcher.matches()){
            return matcher.group(1);
        }else{
            return encrypt(text);
        }
    }

}
