import java.math.BigInteger; 
import java.util.Scanner; 
import java.security.SecureRandom; 
public class SimpleRSA { 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
  
        System.out.print("Enter first prime number (p): "); 
        BigInteger p = sc.nextBigInteger(); 
 
        System.out.print("Enter second prime number (q): "); 
        BigInteger q = sc.nextBigInteger(); 
  
        BigInteger n = p.multiply(q); 
  
        BigInteger phi = (p.subtract(BigInteger.ONE)) 
                .multiply(q.subtract(BigInteger.ONE)); 
  
        SecureRandom random = new SecureRandom(); 
        BigInteger e; 
  
        do { 
            e = new BigInteger(phi.bitLength(), random); 
        } while (e.compareTo(BigInteger.ONE) <= 0 
                || e.compareTo(phi) >= 0 
                || !e.gcd(phi).equals(BigInteger.ONE)); 
  
        BigInteger d = e.modInverse(phi); 
 
        System.out.println("\nPublic key (e, n): (" + e + ", " + n + ")"); 
        System.out.println("Private key (d, n): (" + d + ", " + n + ")");
 
        System.out.print("\nEnter message (number less than n): "); 
        BigInteger message = sc.nextBigInteger(); 
 
        BigInteger ciphertext = message.modPow(e, n); 
        System.out.println("Encrypted message: " + ciphertext); 
  
        BigInteger decrypted = ciphertext.modPow(d, n); 
        System.out.println("Decrypted message: " + decrypted); 
 
        sc.close(); 
    } 
}
