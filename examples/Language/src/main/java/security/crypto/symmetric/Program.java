package security.crypto.symmetric;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Program {
    public static void main(String[] args) {
        try {
            KeyGenerator generator = KeyGenerator.getInstance("DES");
            SecretKey key = generator.generateKey();

            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            IvParameterSpec iv = new IvParameterSpec(cipher.getIV());

            RandomAccessFile input = new RandomAccessFile("input" + File.separatorChar + "plaintext.txt", "r");
            byte[] clearText = new byte[(int) input.length()];
            input.readFully(clearText);
            input.close();

            printData("Original Text", clearText);

            byte[] cypherText = cipher.doFinal(clearText);

            printData("Encrypted Text", cypherText);

            cipher.init(Cipher.DECRYPT_MODE, key, iv);
            byte[] decryptedText = cipher.doFinal(cypherText);

            printData("Decrypted Text", decryptedText);

        } catch (NoSuchAlgorithmException ex) {
            System.out.println("Cannot find algorithm: " + ex);
        } catch (NoSuchPaddingException ex) {
            System.out.println("Unknown padding: " + ex);
        } catch (InvalidAlgorithmParameterException ex) {
            System.out.println("Bad parameter: " + ex);
        } catch (BadPaddingException ex) {
            System.out.println("Padding error: " + ex);
        } catch (IllegalBlockSizeException ex) {
            System.out.println("Block size error: " + ex);
        } catch (InvalidKeyException ex) {
            System.out.println("Invalid key: " + ex);
        } catch (FileNotFoundException ex) {
            System.out.println("Cannot find file: " + ex);
        } catch (IOException ex) {
            System.out.println("File I/O error: " + ex);
        }
    }

    private static void printData(String title, byte[] buffer) {
        final String titlePadding = " ---------- ";
        System.out.println(titlePadding + title + titlePadding);
        System.out.println(new String(buffer));
    }
}
