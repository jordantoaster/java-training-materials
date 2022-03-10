package xml.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ModifyingXmlWithDom {
    public static void main(String[] args) throws Exception {

        File fileToReadFrom = new File("output" + File.separator + "dom_output.xml");
        File fileToSaveTo = new File("output" + File.separator + "dom_modified_output.xml");

        // Use JAXP to locate a parser and create a document
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(fileToReadFrom);

        // Sort out whitespace
        doc.normalize();

        // Change the customers forename
        NodeList forenameNodes = doc.getElementsByTagName("Forename");
        forenameNodes.item(0).getFirstChild().setNodeValue("Jane");

        // Change the customers title
        Element parent = (Element) forenameNodes.item(0).getParentNode();
        parent.setAttribute("title", "Mrs");

        // Change the customers surname
        NodeList surnameNodes = doc.getElementsByTagName("Surname");
        surnameNodes.item(0).getFirstChild().setNodeValue("Smith");

        // Change the customers address
        Element address = null;
        NodeList nodeList = doc.getDocumentElement().getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i) instanceof Element) {
                Element current = (Element) nodeList.item(i);
                if (current.getTagName().equals("Address")) {
                    address = (Element) current;
                }
            }
        }
        address.getChildNodes().item(0).getFirstChild().setNodeValue("Connolly Street");
        address.getChildNodes().item(1).getFirstChild().setNodeValue("Dublin");

        DomPrintUtils.printDocument(builder, doc);
        DomPrintUtils.saveDocument(builder, fileToSaveTo, doc);
    }
}
