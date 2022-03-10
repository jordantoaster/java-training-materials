package xml.sax;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileReader;

public class SaxProcessingDemo {
    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.parse(new InputSource(new FileReader("input/customer.xml")), new SaxEventHandler());
    }

    private static class SaxEventHandler extends DefaultHandler {
        public void startDocument() throws SAXException {
            System.out.println("Start of document");
        }

        public void endDocument() throws SAXException {
            System.out.println("End of document");
        }

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            depth++;
            printDepth();
            System.out.print("Start of element: " + qName);
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.print(" [");
                System.out.print(attributes.getQName(i));
                System.out.print(",");
                System.out.print(attributes.getValue(i));
                System.out.print("]");
            }
            System.out.println();
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            printDepth();
            System.out.println("End of element: " + qName);
            depth--;
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            String text = new String(ch, start, length);
            depth++;
            printDepth();
            if (text.trim().length() > 0) {
                System.out.println("Found the text: " + text);
            } else {
                System.out.println("Found ignorable whitespace");
            }
            depth--;
        }

        public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
            depth++;
            printDepth();
            System.out.println("Found ignorable whitespace");
            depth--;
        }

        private void printDepth() {
            for (int i = 0; i < depth; i++) {
                System.out.print("--->");
            }
        }

        private int depth;
    }
}
