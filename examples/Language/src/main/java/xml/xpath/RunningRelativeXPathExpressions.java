package xml.xpath;

import org.w3c.dom.*;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.FileReader;

public class RunningRelativeXPathExpressions {
    public static void main(String[] args) throws Exception {
        InputSource input = new InputSource(new FileReader("input/purchase_order.xml"));
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = domFactory.newDocumentBuilder();
        Document document = builder.parse(input);

        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();

        Node contextNode = (Node) xpath.evaluate("/purchaseOrder/itemsList/item[@index = 5]", document, XPathConstants.NODE);

        XPathExpression[] relativeExpressions = new XPathExpression[6];
        relativeExpressions[0] = xpath.compile("count(preceding-sibling::item)");
        relativeExpressions[1] = xpath.compile("count(following-sibling::item)");
        relativeExpressions[2] = xpath.compile("preceding-sibling::item[1]/description");
        relativeExpressions[3] = xpath.compile("following-sibling::item[1]/description");
        relativeExpressions[4] = xpath.compile("description/text()");
        relativeExpressions[5] = xpath.compile("../item/description");

        Double result1 = (Double) relativeExpressions[0].evaluate(contextNode, XPathConstants.NUMBER);
        Double result2 = (Double) relativeExpressions[1].evaluate(contextNode, XPathConstants.NUMBER);
        Element result3 = (Element) relativeExpressions[2].evaluate(contextNode, XPathConstants.NODE);
        Element result4 = (Element) relativeExpressions[3].evaluate(contextNode, XPathConstants.NODE);
        Text result5 = (Text) relativeExpressions[4].evaluate(contextNode, XPathConstants.NODE);
        NodeList result6 = (NodeList) relativeExpressions[5].evaluate(contextNode, XPathConstants.NODESET);

        System.out.println("Results of relative expressions are:");
        System.out.println("1)\t" + result1);
        System.out.println("2)\t" + result2);
        System.out.println("3)\t" + result3.getTextContent());
        System.out.println("4)\t" + result4.getTextContent());
        System.out.println("5)\t" + result5.getTextContent());
        System.out.print("6)\t");
        for (int i = 0; i < result6.getLength(); i++) {
            Node node = result6.item(i);
            System.out.print("(");
            System.out.print(node.getTextContent());
            System.out.print(") ");
        }
        System.out.println();
    }

}
