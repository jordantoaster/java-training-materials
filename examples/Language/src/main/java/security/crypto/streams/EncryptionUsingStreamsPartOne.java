package security.crypto.streams;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.io.*;


public class EncryptionUsingStreamsPartOne {
    private static final String cypherTextFile = "output" + File.separator + "ciphertext.out";
    private static final String keyFile = "output" + File.separator + "key.out";

    public static void main(String[] args) throws Exception {
        KeyGenerator generator = KeyGenerator.getInstance("DES");
        SecretKey key = generator.generateKey();

        Cipher cipher = Cipher.getInstance("DES/CFB8/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        IvParameterSpec iv = new IvParameterSpec(cipher.getIV());

        CipherOutputStream cipherOutput = new CipherOutputStream(new FileOutputStream(cypherTextFile), cipher);
        ObjectOutputStream keyOutput = new ObjectOutputStream(new FileOutputStream(keyFile));
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter some text (XXXX to end)");
        while (true) {
            String text = console.readLine();
            if (text.equals("XXXX")) {
                break;
            } else {
                text += "\n";
                cipherOutput.write(text.getBytes());
            }
        }
        keyOutput.writeObject(key);
        keyOutput.write(iv.getIV());

        cipherOutput.close();
        keyOutput.close();
    }
}
