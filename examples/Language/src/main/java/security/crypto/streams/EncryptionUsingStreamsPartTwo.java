package security.crypto.streams;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.io.*;

public class EncryptionUsingStreamsPartTwo {

    private static final int initializationVectorSizeForDES = 8;
    private static final String cypherTextFile = "output" + File.separator + "ciphertext.out";
    private static final String keyFile = "output" + File.separator + "key.out";

    public static void main(String[] args) throws Exception {
        ObjectInputStream keyInput = new ObjectInputStream(new FileInputStream(keyFile));

        SecretKey key = (SecretKey) keyInput.readObject();

        byte[] ivBytes = new byte[initializationVectorSizeForDES];
        keyInput.read(ivBytes);
        IvParameterSpec iv = new IvParameterSpec(ivBytes);

        Cipher cipher = Cipher.getInstance("DES/CFB8/NoPadding");
        cipher.init(Cipher.DECRYPT_MODE, key, iv);

        CipherInputStream binaryInput = new CipherInputStream(new FileInputStream(cypherTextFile), cipher);
        BufferedReader textInput = new BufferedReader(new InputStreamReader(binaryInput));

        System.out.println("-------- Decrypted Text --------");
        String currentLine;
        while (null != (currentLine = textInput.readLine())) {
            System.out.println(currentLine);
        }
        keyInput.close();
        textInput.close();
    }

}
