import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;
import java.util.Base64;

public class DigitalSignatureExample2 {
    public static void main(String[] args) throws Exception {
        String message = "Hello, this is a message for digital signature!";
        System.out.println("Original Message: " + message);

        // Generate key pair
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048); // Key length
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        // Create a digital signature
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(keyPair.getPrivate());
        signature.update(message.getBytes());
        byte[] digitalSignature = signature.sign();
        System.out.println("Digital Signature: " +
            Base64.getEncoder().encodeToString(digitalSignature));

        // Verify the digital signature
        Signature verifier = Signature.getInstance("SHA256withRSA");
        verifier.initVerify(keyPair.getPublic());
        verifier.update(message.getBytes());
        boolean isVerified = verifier.verify(digitalSignature);
        if (isVerified) {
            System.out.println("Digital Signature Verified: The message is authentic.");
        } else {
            System.out.println("Digital Signature Verification Failed: The message may be tampered with.");
        }
    }
}
