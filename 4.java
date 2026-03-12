import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Scanner;

public class DESEX {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter message:");
        String message = sc.nextLine();

        KeyGenerator KeyGen = KeyGenerator.getInstance("DES");
        SecretKey key = KeyGen.generateKey();

        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] encryptBytes = cipher.doFinal(message.getBytes());
        String encryptedText = Base64.getEncoder().encodeToString(encryptBytes);
        System.out.println("\nEncrypted Message : " + encryptedText);

        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        String decryptedText = new String(decryptBytes);
        System.out.println("\nDecrypted Message: " + decryptedText);
    }
}
