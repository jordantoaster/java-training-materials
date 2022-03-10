package xml.xslt;

import java.io.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.*;

public class Program {

	public static void main(String[] args) throws Exception {
		//These are the locations of the XML documents
		String sep = File.separator;
        File inputFile = new File("input" + sep + "much_ado_about_nothing.xml");
		File xsltFile = new File("input" + sep + "shakespeare.xslt");
		File outputFile = new File("output" + sep + "play.html");
	
		//JAXP locates an XSLT Processor for us, usually based on the
		// value of the 'javax.xml.transform.TransformerFactory' property
		TransformerFactory tf = TransformerFactory.newInstance();	
		
		//Create JAXP style input objects
		StreamSource inputSource = new StreamSource(inputFile );
		StreamSource stylesheetSource = new StreamSource(xsltFile);
		
		//Create JAXP style output objects
		StreamResult consoleResult = new StreamResult(System.out);
		StreamResult fileResult = new StreamResult(outputFile);

		//Create a Transformer that can apply the stylesheet
		Transformer t = tf.newTransformer(stylesheetSource);
		
		//Perform the transformation
		t.transform(inputSource,consoleResult);
		t.transform(inputSource,fileResult);	
	}
}
