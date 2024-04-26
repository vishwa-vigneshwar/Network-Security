import java.security.KeyPair;
import java.security.KeyPairGenerator;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;

public class AsymmetricAndKeyExchangeExample {
    public static void main(String[] args) throws Exception {
        // Asymmetric Key Encryption using RSA
        String plaintext = "Hello, asymmetric encryption!";
        System.out.println("Original Text: " + plaintext);

        // Generate key pair
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048); // Key length
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        // Encryption
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes());
        System.out.println("Encrypted Text: " + new String(encryptedBytes));

        // Decryption
        cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        String decryptedText = new String(decryptedBytes);
        System.out.println("Decrypted Text: " + decryptedText);

        // Key Exchange using Diffie-Hellman
        KeyPairGenerator dhKeyPairGenerator = KeyPairGenerator.getInstance("DiffieHellman");
        dhKeyPairGenerator.initialize(2048); // Key length
        KeyPair dhKeyPair = dhKeyPairGenerator.generateKeyPair();
        KeyAgreement keyAgreement = KeyAgreement.getInstance("DiffieHellman");
        keyAgreement.init(dhKeyPair.getPrivate());

        // Simulate another party by generating its key pair
        KeyPair dhOtherKeyPair = dhKeyPairGenerator.generateKeyPair();
        keyAgreement.doPhase(dhOtherKeyPair.getPublic(), true);
        byte[] sharedSecret = keyAgreement.generateSecret();
        System.out.println("Shared Secret: " + new String(sharedSecret));
    }
}
