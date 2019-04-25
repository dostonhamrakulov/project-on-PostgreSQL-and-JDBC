/**
 * Copyright @ 2000 Peter Rossbach (pr@webapp.de) und Lars Roewekamp (Lars@openKnowlege.de)
 *
 * Source is only for non commercial and coaching usage.
 *
 * Not Warranty to use it.
 */
package de.ix.jspTutorial.model;

/**
 * Defintion einer Pizza
 *
 *
 * @author Peter Rossbach (<a href="mailto://pr@webapp.de">pr@webapp.de</a>),
 * Lars Roewekamp (
 * <a href="mailto://lars.roewekamp@openKnowledge.de">lars.roewekamp@openKnowledge.de</a>)
 * @version $Id:$
 */
public class Pizza
{

    /**
     * Version des Source
     */
    public static String vcid = "$Id:$";

    /**
     * Name der Pizza
     */
    private String name;
    /**
     * Basis Preis der Pizza
     */
    private double basePrice;
    /**
     * Bestellnummer der Pizza
     */
    private long id;
    /**
     * Groesse der Pizza
     */
    private String size;

    /**
     * Constructor declaration
     *
     *
     * @see
     */
    public Pizza()
    {
        this.id = -1;
        this.name = null;
        this.size = "";
        this.basePrice = 0.00;
    }

    /**
     * Constructor declaration
     *
     *
     * @param id
     * @param name
     * @param size
     * @param basePrice
     *
     * @see
     */
    public Pizza(long id, String name, String size, double basePrice)
    {
        this.id = id;
        this.name = name;
        this.size = size;
        this.basePrice = basePrice;
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
     * @param newBasePrice
     *
     * @see
     */
    public void setBasePrice(double newBasePrice)
    {
        basePrice = newBasePrice;
    }

    /**
     * Method declaration
     *
     *
     * @return
     *
     * @see
     */
    public double getBasePrice()
    {
        return basePrice;
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
     * @param newSize
     *
     * @see
     */
    public void setSize(String newSize)
    {
        size = newSize;
    }

    /**
     * Method declaration
     *
     *
     * @return
     *
     * @see
     */
    public String getSize()
    {
        return size;
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
        return "Id: " + id + "  Name: " + name + "  Size: " + size + "  Base Price: " + basePrice;
    }
}

//
// History
//
// $Log:$
//
//
