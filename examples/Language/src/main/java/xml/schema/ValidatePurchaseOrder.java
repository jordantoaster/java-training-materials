package xml.schema;

import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;

public class ValidatePurchaseOrder {
    public static void main(String[] args) throws Exception {
        String xmlFile = "input/purchase_order.xml";
        String xsdFile = "input/purchase_order.xsd";

        DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = parser.parse(new File(xmlFile));

        SchemaFactory factory = SchemaFactory.newInstance(javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI);

        Source schemaFile = new StreamSource(new File(xsdFile));
        Schema schema = factory.newSchema(schemaFile);

        Validator validator = schema.newValidator();
        CustomHandler customHandler = new CustomHandler();
        validator.setErrorHandler(customHandler);

        validator.validate(new DOMSource(document));
        if (customHandler.getErrorCount() == 0) {
            System.out.println("Document Validated Successfully!");
        }
    }

    private static class CustomHandler implements ErrorHandler {
        public void warning(SAXParseException ex) throws SAXException {
            System.out.println("Warning " + ex);
        }

        public void error(SAXParseException ex) throws SAXException {
            System.out.println("Error " + ex);
            errorCount++;
        }

        public void fatalError(SAXParseException ex) throws SAXException {
            System.out.println("FatalError " + ex);
            errorCount++;
        }

        public int getErrorCount() {
            return errorCount;
        }

        private int errorCount;
    }
}
