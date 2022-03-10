package xml.stax;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileReader;

public class ReadingXmlWithStAX {
    public static void main(String[] args) throws Exception {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        FileReader fileReader = new FileReader("input/customer.xml");
        XMLStreamReader reader = factory.createXMLStreamReader(fileReader);

        int nodeType;
        int depth = 0;
        while (XMLStreamConstants.END_DOCUMENT != (nodeType = reader.next())) {
            switch (nodeType) {
                case XMLStreamConstants.START_ELEMENT:
                    depth++;
                    printDepth(depth);
                    System.out.print("Found the start of element " + reader.getLocalName());
                    for (int i = 0; i < reader.getAttributeCount(); i++) {
                        System.out.print(" (");
                        System.out.print(reader.getAttributeLocalName(i));
                        System.out.print(",");
                        System.out.print(reader.getAttributeValue(i));
                        System.out.print(")");
                    }
                    System.out.println();
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    printDepth(depth);
                    System.out.println("Found the end of element " + reader.getLocalName());
                    depth--;
                    break;
                case XMLStreamConstants.CHARACTERS:
                    printDepth(depth);
                    if (reader.getText().trim().length() == 0) {
                        System.out.println("Found whitespace only text");
                    } else {
                        System.out.println("Found a text block with content: " + reader.getText());
                    }
                    break;
                case XMLStreamConstants.COMMENT:
                    printDepth(depth);
                    System.out.println("Found a comment with text: " + reader.getText());
                    break;

            }
        }
        reader.close();
        fileReader.close();
    }

    private static void printDepth(int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("--->");
        }
    }

}
