import java.io.*;

public class SubstitutionCipher {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = "abcdefghijklmnopqrstuvwxyz";
        String b = "zyxwvutsrqponmlkjihgfedcba";

        System.out.print("Enter any string: ");
        String str = br.readLine().toLowerCase();

        String encrypt = "";
        char c;

       
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            int j = a.indexOf(c);

            if (j != -1) {
                encrypt = encrypt + b.charAt(j);
            } else {
                encrypt = encrypt + c; // keep spaces/symbols
            }
        }

        System.out.println("Encrypted data: " + encrypt);

        
        String decrypt = "";

        for (int i = 0; i < encrypt.length(); i++) {
            c = encrypt.charAt(i);
            int j = b.indexOf(c);

            if (j != -1) {
                decrypt = decrypt + a.charAt(j);
            } else {
                decrypt = decrypt + c;
            }
        }

        System.out.println("Decrypted data: " + decrypt);
    }
}
