import java.io.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

/**
 * @author johannes fliege, richard vogel
 * <richard.vogel@informatik.tu-chemnitz.de>
 *
 */
public class DOMTest
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // Create new object from the class, which implements the handling and
        // usage of our created DOM parsed from the XML (that is THIS class)
        DOMTest domTest = new DOMTest();
        // Parse Pizza-XML
        domTest.parseXMLList(domTest.getClass().getClassLoader().getResourceAsStream("pizzenExample.xml"));
    }

    /**
     * Reads the xml data stream
     *
     * @param in the XML-Input-Stream
     *
     * @author Richard Vogel, Johannes Fliege
     */
    public void parseXMLList(InputStream in)
    {
        try
        {
            // Parse the XML file and create document tree
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(in);

            // @TODO: Use the document to access all pizza elements (you might
            // iterate over a NodeList) and print out their data (attributes).
            // Be aware, that we return not only Pizzas but also other Nodes
            // (which may not be too obvisious at the beginning).
            System.out.println("Implement Code to output XML file using DOM parser");
        }
        catch (ParserConfigurationException | SAXException | IOException e)
        {
            e.printStackTrace();
        }
    }

}
