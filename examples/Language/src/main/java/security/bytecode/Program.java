package security.bytecode;

import java.io.DataInputStream;
import java.io.File;

public class Program {

    public static void main(String[] args) throws Exception {
        Program reader = new Program();
        String sep = File.separator;
        reader.read("security" + sep + "bytecode" + sep + "Test.class");
    }

    private static void read(String fname) throws Exception {
        ClassLoader cl = Program.class.getClassLoader();
        DataInputStream dis = new DataInputStream(cl.getResourceAsStream(fname));

        //magic
        int magic = dis.readInt();
        System.out.println("Magic number is: " + Integer.toHexString(magic));

        //minor version
        int minor = dis.readShort();
        System.out.println("\nMinor version number is: " + minor);

        //major version
        int major = dis.readShort();
        System.out.println("\nMajor version number is: " + major);

        //poolCount
        int poolCount = dis.readShort();
        System.out.println("\nConstant pool count is: " + poolCount);

        System.out.println("\nConstant pool content is:");

        //read entries in constant pool
        for (int entryIndex = 1; entryIndex < poolCount; entryIndex++) {
            int tag = dis.readUnsignedByte();
            //System.out.println("Found tag " + tag);

            int index;
            int length;
            int intVal;
            float floatVal;
            long longVal;
            double doubleVal;

            switch (tag) {
                case 7:
                    index = dis.readShort();
                    System.out.println("\n\t " + entryIndex + " CONSTANT_Class_info struct with index: " + index);
                    break;
                case 9:
                    System.out.print("\n\t " + entryIndex + " CONSTANT_Fieldref_info struct ");
                    index = dis.readShort();
                    System.out.print("with class index " + index);
                    index = dis.readShort();
                    System.out.println("and name/type index " + index);
                    break;
                case 10:
                    System.out.print("\n\t " + entryIndex + " CONSTANT_Methodref_info struct ");
                    index = dis.readShort();
                    System.out.print("with class index " + index);
                    index = dis.readShort();
                    System.out.println("and name/type index " + index);
                    break;
                case 11:
                    System.out.print("\n\t " + entryIndex + " CONSTANT_InterfaceMethodref_info struct ");
                    index = dis.readShort();
                    System.out.print("with class index " + index);
                    index = dis.readShort();
                    System.out.println("and name/type index " + index);
                    break;
                case 8:
                    index = dis.readShort();
                    System.out.println("\n\t " + entryIndex + " CONSTANT_String_info struct with index: " + index);
                    break;
                case 3:
                    intVal = dis.readInt();
                    System.out.println("\n\t " + entryIndex + " CONSTANT_Integer_info struct with value: " + intVal);
                case 4:
                    floatVal = dis.readFloat();
                    System.out.println("\n\t " + entryIndex + " CONSTANT_Float_info struct with value: " + floatVal);
                    break;
                case 5:
                    longVal = dis.readLong();
                    System.out.println("\n\t " + entryIndex + " CONSTANT_Long_info struct: " + longVal);
                    break;
                case 6:
                    doubleVal = dis.readDouble();
                    System.out.println("\n\t " + entryIndex + " CONSTANT_Double_info struct: " + doubleVal);
                    break;
                case 12:
                    System.out.print("\n\t " + entryIndex + " CONSTANT_NameAndType_info struct ");
                    index = dis.readShort();
                    System.out.print("with name index " + index);
                    index = dis.readShort();
                    System.out.println(" and descriptor index " + index);
                    break;
                case 1:
                    length = dis.readShort();
                    System.out.print("\n\t " + entryIndex + " CONSTANT_Utf8_info struct with length " + length);
                    byte[] bytes = new byte[length];
                    dis.read(bytes);
                    System.out.println(" and value " + new String(bytes));
                    break;
            }
        }
        System.out.println("\nEnd of pool content");

        //access flags
        int accessFlags = dis.readShort();
        System.out.println("Access flags are: " + Integer.toBinaryString(accessFlags));

        //'this' class index
        int thisClass = dis.readShort();
        System.out.println("This class is the entry in the constant pool with index: " + thisClass);

        //'super' class index
        int superClass = dis.readShort();
        System.out.println("Super class is the entry in the constant pool with index: " + superClass);

        //interfaces count
        int interfaceCount = dis.readShort();
        System.out.println("Number of implemented interfaces is: " + interfaceCount);

        //interaces
        for (int i = 0; i < interfaceCount; i++) {
            int index = dis.readShort();
            System.out.println("An implemented interface is in the constant pool with index: " + index);
        }

        //DEAL WITH MEMBERS OF THE CLASS

        //fields count
        int fieldsCount = dis.readShort();
        System.out.println("Number of implemented fields is: " + fieldsCount);

        System.out.println("\nFields are:");

        //fields
        for (int i = 0; i < fieldsCount; i++) {
            System.out.println("\n\tNew field");
            //accessibility
            int fieldAccessFlags = dis.readShort();
            System.out.println("\tAccess flags are: " + Integer.toBinaryString(fieldAccessFlags));
            //name index
            int index = dis.readShort();
            System.out.println("\tField name can be found in the constant pool with index: " + index);
            //descriptor index
            index = dis.readShort();
            System.out.println("\tDescriptor name can be found in the constant pool with index: " + index);
            //attributes
            int attributes = dis.readShort();
            System.out.println("\tNumber of attributes is: " + attributes);
            System.out.println("\t\tAttributes are ");
            for (int x = 0; x < attributes; x++) {
                int attributeIndex = dis.readShort();
                System.out.println("\t\tAttribute name is in the constant pool with index: " + attributeIndex);
                int attributeLength = dis.readInt();
                byte[] bytes = new byte[attributeLength];
                dis.read(bytes);
                //skip processing of attributes
            }
        }

        System.out.println("\nEnd of Fields");

        //DEAL WITH METHODS OF THE CLASS

        //methods count
        int methodsCount = dis.readShort();
        System.out.println("Number of methods is: " + methodsCount);

        System.out.println("\nMethods are:");

        //fields
        for (int i = 0; i < methodsCount; i++) {
            System.out.println("\n\tNew method");
            //accessibility
            int methodAccessFlags = dis.readShort();
            System.out.println("\tAccess flags are: " + Integer.toBinaryString(methodAccessFlags));
            //name index
            int index = dis.readShort();
            System.out.println("\tMethod name can be found in the constant pool with index: " + index);
            //descriptor index
            index = dis.readShort();
            System.out.println("\tDescriptor name can be found in the constant pool with index: " + index);
            //attributes
            int attributes = dis.readShort();
            System.out.println("\tNumber of attributes is: " + attributes);
            System.out.println("\t\tAttributes are ");
            for (int x = 0; x < attributes; x++) {
                int attributeIndex = dis.readShort();
                System.out.println("\t\tAttribute name is in the constant pool with index: " + attributeIndex);
                int attributeLength = dis.readInt();
                byte[] bytes = new byte[attributeLength];
                dis.read(bytes);
                //skip processing of attributes
            }
        }

        System.out.println("\nEnd of Methods");

        //DEAL WITH CLASS ATTRIBUTES

        int attributes = dis.readShort();
        System.out.println("\nThere are " + attributes + " class attributes");
        for (int x = 0; x < attributes; x++) {
            int attributeIndex = dis.readShort();
            System.out.println("\tAttribute name is in the constant pool with index: " + attributeIndex);
            int attributeLength = dis.readInt();
            byte[] bytes = new byte[attributeLength];
            dis.read(bytes);
            //skip processing of attributes
        }

    }
}
