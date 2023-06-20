import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class XmlTest {

    public static void main(String[] args) {
        //xFrame5 설치파일 받는곳
        //http://technet.softbase.co.kr/wiki/start

        Path path = Paths.get("data\\SCREEN0001.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document doc = null;
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
            doc = builder.parse(path.toFile());
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }


        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();
        XPathExpression expr = null;
        try {
            expr = xPath.compile("/map_list/map/screen");
        } catch (XPathExpressionException e) {
            throw new RuntimeException(e);
        }

        NodeList nodeList = null;
        try {
            nodeList = (NodeList) ((XPathExpression) expr).evaluate(doc, XPathConstants.NODESET);
        } catch (XPathExpressionException e) {
            throw new RuntimeException(e);
        }

        if(nodeList.getLength() != 1) {
            System.out.println("Many Screen Node. Error.");
            return;
        }

        Node item = nodeList.item(0);
        String title = item.getAttributes().getNamedItem("title").getNodeValue();

        System.out.println(title);
    }

}
