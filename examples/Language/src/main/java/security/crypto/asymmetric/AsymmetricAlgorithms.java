package security.crypto.asymmetric;

import javax.crypto.Cipher;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.Key;
import java.security.KeyFactory;
import java.security.Provider;
import java.security.Security;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;


public class AsymmetricAlgorithms {
    public static void main(String[] args) throws Exception {
        loadRSACapableProvider();

        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

        Key key = null;
        try {
            key = loadPublicKey("public.key");
        } catch (Exception ex) {
            System.out.println("Cannot load key - did you forget to generate one?");
            System.out.println("\t[" + ex + "]");
            return;
        }
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] clearText = "Lorem ipsum dolor sit amet".getBytes();

        printData("Original Text", clearText);

        byte[] cypherText = cipher.doFinal(clearText);

        printData("Encrypted Text", cypherText);

        cipher.init(Cipher.DECRYPT_MODE, loadPrivateKey("private.key"));
        byte[] decryptedText = cipher.doFinal(cypherText);

        printData("Decrypted Text", decryptedText);
    }

    private static void loadRSACapableProvider() throws Exception {
        //relies on Bouncy Castle being available
        Class<?> klass  = Class.forName("org.bouncycastle.jce.provider.BouncyCastleProvider");
        Provider p = (Provider)klass.newInstance();
        Security.insertProviderAt(p, 5);
    }

    private static Key loadPublicKey(String name) throws Exception {
        KeyFactory factory = KeyFactory.getInstance("RSA");
        KeySpec keySpec = new X509EncodedKeySpec(loadFile(name));
        return factory.generatePublic(keySpec);
    }

    private static Key loadPrivateKey(String name) throws Exception {
        KeyFactory factory = KeyFactory.getInstance("RSA");
        KeySpec keySpec = new PKCS8EncodedKeySpec(loadFile(name));
        return factory.generatePrivate(keySpec);
    }

    private static byte[] loadFile(String name) throws IOException {
        RandomAccessFile input = new RandomAccessFile("output" + File.separatorChar + name, "r");
        byte[] data = new byte[(int) input.length()];
        input.readFully(data);
        input.close();
        return data;
    }

    private static void printData(String title, byte[] buffer) {
        final String titlePadding = " ---------- ";
        System.out.println(titlePadding + title + titlePadding);
        System.out.println(new String(buffer));
    }
}
