package xml.dom;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;

import javax.xml.parsers.DocumentBuilder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

class DomPrintUtils {

    private static DOMImplementationLS getDomImplementation(DocumentBuilder builder) {
        DOMImplementation impl = builder.getDOMImplementation();
        if (!(impl instanceof DOMImplementationLS)) {
            throw new IllegalArgumentException("DOM provider does not support load and save");
        }
        DOMImplementationLS implLS = (DOMImplementationLS) impl;
        return implLS;
    }

    static void printDocument(DocumentBuilder builder, Document doc) throws IOException {
        DOMImplementationLS impl = getDomImplementation(builder);
        LSSerializer s = impl.createLSSerializer();
        LSOutput output = impl.createLSOutput();
        output.setByteStream(System.out);
        s.write(doc, output);

    }

    static void saveDocument(DocumentBuilder builder, File fileToSaveTo, Document doc) throws IOException, FileNotFoundException {
        DOMImplementationLS impl = getDomImplementation(builder);
        LSSerializer s = impl.createLSSerializer();
        LSOutput output = impl.createLSOutput();
        output.setCharacterStream(new FileWriter(fileToSaveTo));
        s.write(doc, output);
    }

}
