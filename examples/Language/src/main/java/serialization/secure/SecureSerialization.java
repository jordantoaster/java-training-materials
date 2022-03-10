package serialization.secure;

import java.io.*;
import javax.crypto.*;

public class SecureSerialization {
    public static void main(String[] args) throws Exception {
        Test original = new Test(101,202.303,"abcdefg");
        System.out.println("Original object holds: " + original);
        
        KeyGenerator generator = KeyGenerator.getInstance("DES");
        SecretKey key = generator.generateKey();
        
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE,key);
        
        SealedObject obj = new SealedObject(original, cipher);
        
        final String path = "output" + File.separator + "savedObject.out";
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path));
        output.writeObject(obj);
        output.flush();
        output.close();
        
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(path));
        SealedObject obj2 = (SealedObject)input.readObject();
        input.close();
        
        Test restored = (Test)obj2.getObject(key);
        System.out.println("Restored object holds: " + restored);   
    }
}

@SuppressWarnings("serial")
class Test implements Serializable {
    private int fieldOne;
    private double fieldTwo;
    private String fieldThree;

    public Test(int p1, double p2, String p3) {
        super();
        this.fieldOne = p1;
        this.fieldTwo = p2;
        this.fieldThree = p3;
    }
    public String toString() {
        return "[fieldOne:" + fieldOne + "][fieldTwo:" 
        		+ fieldTwo + "][fieldThree:" + fieldThree + "]";
    }
}
