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
        pizzas.put(0L, new Pizza(0, "Please implement me. I am static and want to be in the XML file...", "1.2 cm", 34567.89));
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

}
