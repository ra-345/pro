import javax.crypto.Cipher; 
import javax.crypto.KeyGenerator; 
import javax.crypto.SecretKey; 
import java.util.Base64; 
import java.util.Scanner; 
 
public class AESExample { 
 
    public static void main(String[] args) throws Exception { 
 
        Scanner sc = new Scanner(System.in); 
 
        // Generate AES Key 
        KeyGenerator keyGen = KeyGenerator.getInstance("AES"); 
        keyGen.init(128);  
        SecretKey secretKey = keyGen.generateKey(); 
 
         
        System.out.print("Enter plain text: "); 
        String plaintext = sc.nextLine(); 
 
        System.out.println("Original Text: " + plaintext); 
  
        Cipher cipher = Cipher.getInstance("AES"); 
        cipher.init(Cipher.ENCRYPT_MODE, secretKey); 
 
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes()); 
        String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes); 
 
        System.out.println("Encrypted Text: " + encryptedText); 
 
        
        cipher.init(Cipher.DECRYPT_MODE, secretKey); 
 
        byte[] decryptedBytes = cipher.doFinal( 
            Base64.getDecoder().decode(encryptedText) 
        ); 
 
        String decryptedText = new String(decryptedBytes); 
        System.out.println("Decrypted Text: " + decryptedText); 
 
        sc.close(); 
    } 
} 
