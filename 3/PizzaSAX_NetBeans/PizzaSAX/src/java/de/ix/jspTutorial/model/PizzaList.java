/**
 * Copyright @ 2000 Peter Rossbach (pr@webapp.de) und Lars Roewekamp (Lars@openKnowlege.de)
 *
 * Source is only for non commercial and coaching usage.
 *
 * Not Warranty to use it.
 */
package de.ix.jspTutorial.model;

import java.io.*;
import java.util.*;

import javax.servlet.ServletContext;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Liste der Pizza fuer den Pizza Services Die Pizza werden aus einer Properties
 * Datei einmalig in den ServletContext geladen.
 *
 * @author Peter Rossbach (<a href="mailto://pr@webapp.de">pr@webapp.de</a>),
 * Lars Roewekamp (
 * <a href="mailto://lars.roewekamp@openKnowledge.de">lars.roewekamp@openKnowledge.de</a>)
 * @version $Id:$
 */
public class PizzaList
{

    private final TreeMap<Long, Pizza> pizzas;

    /**
     * Leere Liste von Pizzen
     *
     *
     * @see
     */
    public PizzaList()
    {
        this.pizzas = new TreeMap<>();
    }

    /**
     * Initialisiern mit Testpizzen
     *
     *
     * @param pizzas Testpizzen
     *
     * @see
     */
    public PizzaList(TreeMap<Long, Pizza> pizzas)
    {
        this.pizzas = pizzas;
    }

    /**
     * Hole bestimmte Pizza
     *
     *
     * @param key Bestellnummer der Pizza
     *
     * @return Schluessel der Pizza
     *
     * @see
     */
    public Pizza getPizza(Long key)
    {
        return (Pizza) pizzas.get(key);
    }

    /**
     * Hole alle Pizzen
     *
     *
     * @return
     *
     * @see
     */
    public TreeMap getPizzas()
    {
        return pizzas;
    }

    /**
     * Reads the XML File from <i>/WEB-INF/config/pizzenExample.xml</i>. and
     * calls parseXMLList.
     *
     * @param aApplication ServletContext
     */
    public void readXMLList(ServletContext aApplication)
    {
        InputStream in = aApplication.getResourceAsStream("/WEB-INF/config/pizzenExample.xml");
        this.parseXMLList(in);
    }

    /**
     * This method has to be implemented to work like in in the SAXTest
     *
     */
    private void parseXMLList(InputStream in)
    {
        /**
         * @ TODO: Parse XML file here.
         * This works exactly like in the example before
         *
         * Create a pizza:
         * Pizza pizza = new Pizza(pizzaId, pizzaName, pizzaSize, basePrice);
         * Add a pizza to result set:
         * pizzas.put(pizzaId, pizza);
         */
        try
        {
            // Parse the XML file by using the default (non-validating) parser
//            Pizza pizza = new Pizza();
            SAXParserFactory.newInstance().newSAXParser().parse(in, new PizzaHandler());
            
            
//            SAXParserFactory factory = SAXParserFactory.newInstance();
//            SAXParser saxParser = factory.newSAXParser();
//            MyHandler myhandler = new MyHandler();
//            saxParser.parse(in, myhandler);
//            pizzas = myhandler.getPizzas();
//            pizzas.put(0L, new Pizza(0, "Please implement me. I am static and want to be in the XML file...", "1.2 cm", 34567.89));
            
        }
        catch (ParserConfigurationException | SAXException | IOException e)
        {
            e.printStackTrace();
        }
        
    }

    /**
     * zeige die Liste der Pizzen
     *
     *
     * @return Liste der Pizzen
     *
     * @see
     */
    @Override
    public String toString()
    {
        StringBuilder outStr = new StringBuilder();
        Set entrySet = pizzas.entrySet();

        outStr.append("[");
        for (Iterator iter = entrySet.iterator(); iter.hasNext();)
        {
            Map.Entry entry = (Map.Entry) iter.next();

            outStr.append(((Pizza) entry.getValue()).toString());
            if (iter.hasNext())
                outStr.append(",\n");
        }
        outStr.append("]");
        return outStr.toString();
    }
    
    
    private class PizzaHandler extends DefaultHandler
    {

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
        {
            //@TODO: Read pizza data and print it to out stream
            System.out.println(qName + " encountered");
            final Pizza pizza = new Pizza();
            
            for(int i = 0; i < attributes.getLength(); i++){
//                pizza = 
                qName = attributes.getLocalName(i);
                long pizza_id = 0L;
                if (qName.equalsIgnoreCase("pizzaId")) {
                    pizza.setId(new Integer(attributes.getValue(i)));
//                    pizza_id.valueof(attributes.getValue(i));
                    pizza_id = Long.valueOf(attributes.getValue(i));
                 } else if (qName.equalsIgnoreCase("pizzaName")) {
                    pizza.setName(attributes.getValue(i));
                 } else if (qName.equalsIgnoreCase("pizzaSize")) {
                    pizza.setSize(attributes.getValue(i));
                 } else if (qName.equalsIgnoreCase("basePrice")) {
                    pizza.setBasePrice(new Double(attributes.getValue(i)));
                 }
                System.out.println(attributes.getLocalName(i) + " : " + attributes.getValue(i));
                pizzas.put(pizza_id, pizza);
                
            }
//            System.out.println("4" + attributes.getValue("pizzaId"));
        }

    }

}


