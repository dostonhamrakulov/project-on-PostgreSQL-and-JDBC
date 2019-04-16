/**
 * Copyright @ 2000 Peter Roßbach (pr@webapp.de) und Lars Röwekamp (Lars@openKnowlege.de)
 *
 * Source is only for non commercialand coaching usage.
 *
 * Not Warranty to use it.
 */
package de.ix.jspTutorial.model;

/**
 * Eine Pizza Zutat
 *
 *
 * @author Peter Rossbach (<a href="mailto://pr@webapp.de">pr@webapp.de</a>),
 * Lars Röwekamp (
 * <a href="mailto://lars.roewekamp@openKnowledge.de">lars.roewekamp@openKnowledge.de</a>)
 * @version $Id:$
 */
public class Ingredient
{

    /**
     * Version des Source
     */
    public static String vcid = "$Id:$";

    /**
     * Identität der Zutat
     */
    private long id;
    /**
     * Bezeichnung der Zutat.
     */
    private String name;
    /**
     * Der Preis der Zutat
     */
    private double price;

    /**
     * Erzeuge leer Zutat
     *
     */
    public Ingredient()
    {
    }

    /**
     * Constructor declaration
     *
     *
     * @param id
     * @param name
     * @param price
     *
     * @see
     */
    public Ingredient(long id, String name, double price)
    {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    /**
     * Method declaration
     *
     *
     * @return
     *
     * @see
     */
    public long getId()
    {
        return id;
    }

    /**
     * Method declaration
     *
     *
     * @param newId
     *
     * @see
     */
    public void setId(long newId)
    {
        id = newId;
    }

    /**
     * Method declaration
     *
     *
     * @param newName
     *
     * @see
     */
    public void setName(String newName)
    {
        name = newName;
    }

    /**
     * Method declaration
     *
     *
     * @return
     *
     * @see
     */
    public String getName()
    {
        return name;
    }

    /**
     * Method declaration
     *
     *
     * @param newPrice
     *
     * @see
     */
    public void setPrice(double newPrice)
    {
        price = newPrice;
    }

    /**
     * Method declaration
     *
     *
     * @return
     *
     * @see
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * Method declaration
     *
     *
     * @return
     *
     * @see
     */
    @Override
    public String toString()
    {
        return "Id: " + id + "  Name: " + name + "  Price: " + price;
    }
}

//
// History
//
// $Log:$
//
//
