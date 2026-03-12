import javax.crypto.Cipher; 
import javax.crypto.KeyGenerator; 
import javax.crypto.SecretKey; 
import java.nio.charset.StandardCharsets; 
import java.security.SecureRandom; 
import java.util.Base64; 

public class BlowfishExample { 
    public static SecretKey generateKey(int keySize) throws Exception { 
        if (keySize < 32 || keySize > 448) { 
        throw new IllegalArgumentException("Key size must be between 32 and 448 bits"); 
        } 
        KeyGenerator keyGen = KeyGenerator.getInstance("Blowfish"); 
        keyGen.init(keySize, new SecureRandom()); 
        return keyGen.generateKey(); 
    } 

    public static String encrypt(String plainText, SecretKey key) throws Exception { 
        Cipher cipher = Cipher.getInstance("Blowfish"); 
        cipher.init(Cipher.ENCRYPT_MODE, key); 
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8)); 
        return Base64.getEncoder().encodeToString(encryptedBytes); 
    } 
    public static String decrypt(String encryptedText, SecretKey key) throws Exception { 
        Cipher cipher = Cipher.getInstance("Blowfish"); 
        cipher.init(Cipher.DECRYPT_MODE, key); 
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText)); 
        return new String(decryptedBytes, StandardCharsets.UTF_8); 
    }
    public static void main(String[] args) { 
        try { 
            SecretKey secretKey = generateKey(128); 
            String originalText = "Hello Blowfish!"; 
            System.out.println("Original Text: " + originalText); 
            String encryptedText = encrypt(originalText, secretKey); 
            System.out.println("Encrypted Text (Base64): " + encryptedText); 
            String decryptedText = decrypt(encryptedText, secretKey); 
            System.out.println("Decrypted Text: " + decryptedText); 
            String keyBase64 = Base64.getEncoder().encodeToString(secretKey.getEncoded()); 
            System.out.println("Secret Key (Base64): " + keyBase64); 
            } catch (Exception e) { 
            e.printStackTrace(); 
        } 
    } 
} 
