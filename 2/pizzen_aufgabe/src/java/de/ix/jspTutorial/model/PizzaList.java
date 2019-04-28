/**
 * Copyright @ 2000 Peter Rossbach (pr@webapp.de) und Lars Roewekamp (Lars@openKnowlege.de)
 *
 * Source is only for non commercial and coaching usage.
 *
 * Not Warranty to use it.
 */
package de.ix.jspTutorial.model;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

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
     * This function needs to be edited readListFromDB().
     */
    public void readListFromDB()
    {
        try
        {
            // Load postgres driver..
            Class.forName("org.postgresql.Driver");

            /**
             * Import pizza.sql into your postgreSQL Database. You can use \i
             * pizza.sql inside postgres prompt
             *
             * Use following code snippet to create a pizza Pizza pizza = new
             * Pizza(pizzaId, pizzaName, pizzaSize, basePrice);
             *
             * use: pizzas.put(pizzaId, pizza); to add a pizza to result set
             */
            pizzas.put(new Long(0), new Pizza(0, "Please implement me. I am static and want to be in the database....", "0.0 mmm", 10000));
            //throw new SQLException("Please implement me");
        }
        catch (java.lang.ClassNotFoundException e)
        {
            // Exception abfangen, falls Treiber nicht gefunden werden kann
            System.out.println("Did not find JDBC driver. Please Add it to your lib");
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
}
