import java.util.Scanner; 
public class Hill { 
    static int[][] K = { 
        {9, 7, 11, 13}, 
        {4, 7, 5, 6}, 
        {2, 21, 14, 9}, 
        {3, 23, 21, 8} 
    }; 
    static int[][] K_INV = { 
        {2, 15, 22, 3}, 
        {15, 0, 19, 3}, 
        {9, 9, 3, 11}, 
        {17, 0, 4, 7} 
    }; 
    static int[] multiply(int[][] m, int[] v) { 
        int[] r = new int[4]; 
        for (int i = 0; i < 4; i++) { 
            r[i] = 0; 
            for (int j = 0; j < 4; j++) { 
                r[i] += m[i][j] * v[j]; 
            } 
            r[i] %= 26; 
        } 
        return r; 
    } 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter Plain Text: "); 
        String msg = sc.nextLine().toUpperCase().replaceAll("[^A-Z]", ""); 
        while (msg.length() % 4 != 0) { 
            msg += "X"; 
        }
          // Encryption 
        String cipher = ""; 
        for (int i = 0; i < msg.length(); i += 4) { 
            int[] v = { 
                msg.charAt(i) - 'A', 
                msg.charAt(i + 1) - 'A', 
                msg.charAt(i + 2) - 'A', 
                msg.charAt(i + 3) - 'A' 
            }; 
            int[] c = multiply(K, v); 
            for (int x : c) { 
                cipher += (char) (x + 'A'); 
            } 
        } 
        System.out.println("Encrypted Text: " + cipher); 
        // Decryption 
        String plain = ""; 
        for (int i = 0; i < cipher.length(); i += 4) { 
            int[] v = { 
                cipher.charAt(i) - 'A', 
                cipher.charAt(i + 1) - 'A', 
                cipher.charAt(i + 2) - 'A', 
                cipher.charAt(i + 3) - 'A' 
            }; 
            int[] p = multiply(K_INV, v); 
            for (int x : p) { 
                plain += (char) ((x + 26) % 26 + 'A'); 
            } 
        } 
        System.out.println("Decrypted Text: " + plain); 
    } 
}
