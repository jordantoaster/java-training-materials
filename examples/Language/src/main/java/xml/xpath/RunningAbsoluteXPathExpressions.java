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

public class RunningAbsoluteXPathExpressions {
    public static void main(String[] args) throws Exception {
        InputSource input = new InputSource(new FileReader("input/purchase_order.xml"));
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = domFactory.newDocumentBuilder();
        Document document = builder.parse(input);

        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();

        XPathExpression[] absoluteExpressions = new XPathExpression[6];
        absoluteExpressions[0] = xpath.compile("/purchaseOrder/customer/address/@postcode");
        absoluteExpressions[1] = xpath.compile("/purchaseOrder/customer/paymentOptions/category");
        absoluteExpressions[2] = xpath.compile("/purchaseOrder/itemsList/item[1]/description/text()");
        absoluteExpressions[3] = xpath.compile("/purchaseOrder/itemsList/item[last()]/description/text()");
        absoluteExpressions[4] = xpath.compile("/purchaseOrder/itemsList/item/description");
        absoluteExpressions[5] = xpath.compile("count(/purchaseOrder/itemsList/item)");

        Attr result1 = (Attr) absoluteExpressions[0].evaluate(document, XPathConstants.NODE);
        Element result2 = (Element) absoluteExpressions[1].evaluate(document, XPathConstants.NODE);
        Text result3 = (Text) absoluteExpressions[2].evaluate(document, XPathConstants.NODE);
        Text result4 = (Text) absoluteExpressions[3].evaluate(document, XPathConstants.NODE);
        NodeList result5 = (NodeList) absoluteExpressions[4].evaluate(document, XPathConstants.NODESET);
        Double result6 = (Double) absoluteExpressions[5].evaluate(document, XPathConstants.NUMBER);

        System.out.println("Results of absolute expressions are:");
        System.out.println("1)\t" + result1.getValue());
        System.out.println("2)\t" + result2.getTextContent());
        System.out.println("3)\t" + result3.getTextContent());
        System.out.println("4)\t" + result4.getTextContent());
        System.out.print("5)\t");
        for (int i = 0; i < result5.getLength(); i++) {
            Node node = result5.item(i);
            System.out.print("(");
            System.out.print(node.getTextContent());
            System.out.print(") ");
        }
        System.out.println();
        System.out.println("6)\t" + result6);

    }

}
