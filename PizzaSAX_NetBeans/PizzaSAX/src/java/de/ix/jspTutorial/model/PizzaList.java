/**
 * Copyright @ 2000 Peter Rossbach (pr@webapp.de) und Lars Roewekamp (Lars@openKnowlege.de)
 *
 * Source is only for non commercial and coaching usage.
 *
 * Not Warranty to use it.
 */
package de.ix.jspTutorial.model;

import java.util.*;
import java.io.*;
import javax.servlet.ServletContext;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import org.xml.sax.Attributes;

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
     * This method has to be implemented to work like in in the SaxTest but
     * should parse the
     *
     */
    private void parseXMLList(InputStream in)
    {
        /* @ TODO: Parse XML file here. This works exactly like in the example before
         */
        this.pizzas.put(new Long(0), new Pizza(0, "Implement me", "0nm", 10000000.99));
    }

    /**
     * Show list of pizzas
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

}
