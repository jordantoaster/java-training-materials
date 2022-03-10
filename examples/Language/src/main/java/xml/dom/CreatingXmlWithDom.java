package xml.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class CreatingXmlWithDom {

    public static void main(String[] args) throws Exception {

        File fileToSaveTo = new File("output" + File.separator + "dom_output.xml");

        //Use JAXP to locate a parser and create a document
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();

        // Add a comment to the document
        doc.appendChild(doc.createComment("This document describes a customer"));

        //Create and set the Document Element
        Element docElement = doc.createElement("Customer");
        doc.appendChild(docElement);

        //Create some children with attributes
        Element name = doc.createElement("Name");
        name.setAttribute("title", "Mr");
        Element address = doc.createElement("Address");
        address.setAttribute("postcode", "BT37 ABC");

        //Add the children to the document element
        docElement.appendChild(name);
        docElement.appendChild(address);

        // Fill out the name element
        Element forename = doc.createElement("Forename");
        forename.appendChild(doc.createTextNode("Joe"));
        Element surname = doc.createElement("Surname");
        surname.appendChild(doc.createTextNode("Bloggs"));

        name.appendChild(forename);
        name.appendChild(surname);

        //Fill out the street element
        Element street = doc.createElement("Street");
        street.appendChild(doc.createTextNode("University Street"));
        street.setAttribute("number", "27");
        Element city = doc.createElement("City");
        city.appendChild(doc.createTextNode("Belfast"));

        address.appendChild(street);
        address.appendChild(city);

        DomPrintUtils.printDocument(builder, doc);
        DomPrintUtils.saveDocument(builder, fileToSaveTo, doc);
    }
}
