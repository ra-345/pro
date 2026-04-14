import java.security.MessageDigest;  
import java.security.NoSuchAlgorithmException;  
import java.util.Scanner;  
 
public class SHA512Example {  
    public static void main(String[] args) {  
        Scanner sc = new Scanner(System.in);  
        System.out.print("Enter text: ");  
        String input = sc.nextLine();  
        try {  
            MessageDigest md = MessageDigest.getInstance("SHA-512");   

            byte[] messageDigest = md.digest(input.getBytes()); 

           StringBuilder hexString = new StringBuilder(); 
            for (int i = 0; i < messageDigest.length; i++) {  
                String hex = Integer.toHexString(0xff & messageDigest[i]);  
                if (hex.length() == 1)  
                    hexString.append('0');  
                hexString.append(hex);  
            }    
            System.out.println("SHA-512 Hash Value:"); 
             System.out.println(hexString.toString());  
        } catch (NoSuchAlgorithmException e) {  
            System.out.println("SHA-512 Algorithm not found."); 
        }  
        sc.close();  
    }  
} 
