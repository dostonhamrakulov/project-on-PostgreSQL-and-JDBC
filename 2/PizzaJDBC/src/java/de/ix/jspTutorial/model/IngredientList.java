/**
 * Copyright @ 2000 Peter Roßbach (pr@webapp.de) und Lars Röwekamp (Lars@openKnowlege.de)
 *
 * Source is only for non commercialand coaching usage.
 *
 * Not Warranty to use it.
 */
package de.ix.jspTutorial.model;

import java.util.*;
import java.io.*;

import javax.servlet.ServletContext;

/**
 * Liste aller Zutaten zur Ergänzung von Basis Pizzen.
 *
 *
 * @author Peter Rossbach (<a href="mailto://pr@webapp.de">pr@webapp.de</a>),
 * Lars Röwekamp (
 * <a href="mailto://lars.roewekamp@openKnowledge.de">lars.roewekamp@openKnowledge.de</a>)
 * @version $Id:$
 */
public class IngredientList
{

    /**
     * Version des Source
     */
    public static String vcid = "$Id:$";

    /**
     * Liste der Zutaten
     */
    private TreeMap<Long, Ingredient> ingredients;

    /**
     * Erstelle leere Zutatenlist.
     *
     *
     * @see IngredientList#readList(InputStream)
     */
    public IngredientList()
    {
        this.ingredients = new TreeMap<>();
    }

    /**
     * Erstelle eine liste von Zutaten auf Basis einer vorhandenen Liste.
     *
     *
     * @param ingredients neue Zutatenliste
     *
     * @see IngredientList#readList(InputStream)
     */
    public IngredientList(TreeMap<Long, Ingredient> ingredients)
    {
        this.ingredients = ingredients;
    }

    /**
     * Hole eine bestimmte Zutat.
     *
     * @param key Identität einer Zutat
     *
     * @return
     *
     */
    public Ingredient getIngredient(Long key)
    {
        return (Ingredient) ingredients.get(key);
    }

    /**
     * Hole Liste aller Zutaten.
     *
     *
     * @return Liste der möglichen Zutaten
     *
     */
    public TreeMap getIngredients()
    {
        return ingredients;
    }

    /**
     * Lese die Listen der Zutaten aus der Datei
     * <I>/WEB-INF/config/ingredient.properties</I>. Die Datei befindet sich
     * innerhalb des Path des ServletContexts
     *
     * @param aApplication ServletContext
     *
     * @see javax.servlet.ServletContext#getRessourceAsStream(String)
     */
    public void readList(ServletContext aApplication)
    {
        readList(aApplication.getResourceAsStream("/WEB-INF/config/ingredient.properties"));
    }

    /**
     * Lese die Liste der Zutaten aus einem Stream. Die Schlüssel der Liste
     * sind:
     * <UL>
     * <LI><I>ingredient.count</I> Anzahl der Zustaten
     * <LI><I>ingredient.id_<number>.id</I> Identität einer Zutat
     * <LI><I>ingredient.id_<number>.name</I> Bezeichnung der Zutat
     * <LI><I>ingredient.id_<number>.price</I> Preis der Zutat
     * </UL>
     *
     * Beispiel einer Listen von Zutaten:
     * <xmp>
     * ingredient.count=2
     *
     * ingredient.id_0.id=0 ingredient.id_0.name=Zwiebeln
     * ingredient.id_0.price=1.15
     *
     * ingredient.id_1.id=1 ingredient.id_1.name=Salami
     * ingredient.id_1.price=1.25
     *
     * </xmp>
     *
     * @param aResourceStream
     *
     * @see
     */
    public void readList(InputStream aResourceStream)
    {
        ingredients = new TreeMap<>();
        try
        {
            Properties props = new Properties();

            props.load(aResourceStream);
            Integer ingredientCount = new Integer(props.getProperty("ingredient.count"));

            for (int i = 0; i < ingredientCount; i++)
            {
                Long ingredientId = new Long(props.getProperty("ingredient.id_" + i + ".id"));
                String ingredientName = props.getProperty("ingredient.id_" + i + ".name");
                Double ingredientPrice = new Double(props.getProperty("ingredient.id_" + i + ".price"));

                ingredients.put(ingredientId, new Ingredient(ingredientId, ingredientName, ingredientPrice));
            }
        }
        catch (IOException | NumberFormatException e)
        {
            throw new RuntimeException("Unable to read resource to get data source" + e);
        }
    }

    /**
     * Ausgabe der Zutaten als String
     *
     *
     * @return Die Liste der möglichen Zutaten
     *
     * @see
     */
    @Override
    public String toString()
    {
        StringBuilder outStr = new StringBuilder();
        Set entrySet = ingredients.entrySet();

        outStr.append("[");
        for (Iterator iter = entrySet.iterator(); iter.hasNext();)
        {
            Map.Entry entry = (Map.Entry) iter.next();

            outStr.append(((Ingredient) entry.getValue()).toString());
            if (iter.hasNext())
                outStr.append(",");
        }
        outStr.append("]");
        return outStr.toString();
    }
}

//
// History
//
// $Log:$
//
//
