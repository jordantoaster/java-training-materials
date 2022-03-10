package xml.stax;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.File;
import java.io.FileWriter;

public class WritingXmlWithStAX {
    public static void main(String[] args) throws Exception {
        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        String outputFileName = "output" + File.separator + "stax_output.xml";
        FileWriter fileWriter = new FileWriter(outputFileName);
        XMLStreamWriter writer = factory.createXMLStreamWriter(fileWriter);

        writer.writeComment("This document describes a customer");    //<!-- -->
        writer.writeStartElement("Customer");                        //<Customer>
        writer.writeStartElement("Name");                            //	<Name
        writer.writeAttribute("title", "Mr");                        //	<Name title="Mr">
        writer.writeStartElement("Forename");                        //		<Forename>
        writer.writeCharacters("Joe");                                //			Joe
        writer.writeEndElement();                                    //		</Forename>
        writer.writeStartElement("Surname");                        //		<Surname>
        writer.writeCharacters("Bloggs");                            //			Bloggs
        writer.writeEndElement();                                    //		</Surname>
        writer.writeEndElement();                                    //	</Name>
        writer.writeStartElement("Address");                        //	<Address
        writer.writeAttribute("postcode", "BT37 ABC");                //	<Address postcode="BT37 ABC"
        writer.writeStartElement("Street");                            //		<Street
        writer.writeAttribute("number", "27");                        //		<Street number="27">
        writer.writeCharacters("University Street");                //			University Street
        writer.writeEndElement();                                    //		</Street>
        writer.writeStartElement("City");                            //		<City>
        writer.writeCharacters("Belfast");                            //			Belfast
        writer.writeEndElement();                                    //		</City>
        writer.writeEndElement();                                    //	</Address>
        writer.writeEndElement();                                    //</Customer>

        writer.flush();
        writer.close();
        fileWriter.close();
        System.out.println("Document written to: " + outputFileName);
    }

}
