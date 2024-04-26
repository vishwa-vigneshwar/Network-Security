import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class SymmetricEncryptionExample {
    public static void main(String[] args) throws Exception {
        String plaintext = "Hello, symmetric encryption!";
        System.out.println("Original Text: " + plaintext);

        // Generate a secret key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // You can choose 128, 192, or 256 bits
        SecretKey secretKey = keyGen.generateKey();

        // Encryption
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes("UTF-8"));
        System.out.println("Encrypted Text: " +
            Base64.getEncoder().encodeToString(encryptedBytes));

        // Decryption
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        String decryptedText = new String(decryptedBytes, "UTF-8");
        System.out.println("Decrypted Text: " + decryptedText);
    }
}
