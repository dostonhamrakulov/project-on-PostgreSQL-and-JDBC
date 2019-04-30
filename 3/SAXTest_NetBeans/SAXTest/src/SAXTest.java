import java.io.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author johannes fliege, richard vogel
 * <richard.vogel@informatik.tu-chemnitz.de>
 *
 */
public class SAXTest
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // Create new object from the class, which implements the handlers
        // for our XML-Parsing-Events (that is THIS class)
        SAXTest saxTest = new SAXTest();
        // Parse Pizza-XML
        saxTest.parseXMLList(saxTest.getClass().getClassLoader().getResourceAsStream("pizzenExample.xml"));
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
            // Parse the XML file by using the default (non-validating) parser
            SAXParserFactory.newInstance().newSAXParser().parse(in, new PizzaHandler());
        }
        catch (ParserConfigurationException | SAXException | IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * This is the actual handler we are only interested in "Pizza" Elements.
     * The SAX parser will just run one time through the document and calls our
     * (Pizza)Handler each time an event each time something
     *
     * @author Johannes Fliege, Richard Vogel
     *
     */
    private class PizzaHandler extends DefaultHandler
    {

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
        {
            //@TODO: Read pizza data and print it to out stream
            System.out.println(qName + " encountered");
            
            for(int i = 0; i < attributes.getLength(); i++){
                System.out.println(attributes.getLocalName(i) + " : " + attributes.getValue(i));
            }
            System.out.println("4" + attributes.getValue("pizzaId"));
        }

    }

}
