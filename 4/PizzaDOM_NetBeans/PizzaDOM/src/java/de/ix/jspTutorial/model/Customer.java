/**
 * Copyright @ 2000 Peter Rossbach (pr@webapp.de) und Lars Roewekamp (Lars@openKnowlege.de)
 *
 * Source is only for non commercial and coaching usage.
 *
 * Not Warranty to use it.
 */
package de.ix.jspTutorial.model;

/**
 * Definition eines Pizza Shop Kunden
 *
 *
 * @author Peter Rossbach (<a href="mailto://pr@webapp.de">pr@webapp.de</a>),
 * Lars Roewekamp (
 * <a href="mailto://lars.roewekamp@openKnowledge.de">lars.roewekamp@openKnowledge.de</a>)
 * @version $Id:$
 */
public class Customer
{

    /**
     * Version des Source
     */
    public static String vcid = "$Id:$";

    /**
     * Kunden ID
     */
    private long id;
    /**
     * Vorname
     */
    private String firstname;
    /**
     * Nachname
     */
    private String lastname;
    /**
     * Adressfeld 1
     */
    private String address1;
    /**
     * Adressfeld 2
     */
    private String address2;
    /**
     * Ort
     */
    private String town;
    /**
     * Postleitzahl
     */
    private String zip;
    /**
     * E-Mail Adresse
     */
    private String eMail;

    /**
     * Alle String werden auf den Leeren String "" gesetzt und die id ist -1
     *
     *
     * @see
     */
    public Customer()
    {
        this.firstname = "";
        this.lastname = "";
        this.address1 = "";
        this.address2 = "";
        this.town = "";
        this.zip = "";
        this.eMail = "";
        this.id = -1;
    }

    /**
     * Setze alle Attribute des Kunden
     *
     *
     * @param firstname	Vorname
     * @param lastname Nachname
     * @param address1 erste Adresszeile
     * @param address2 zweite Adresszeile
     * @param zip Postleitzahl
     * @param town Ort
     * @param eMail aktuelle e-mail Adresse
     * @param id Eindeutige Identitaet
     *
     * @see
     */
    public Customer(String firstname, String lastname, String address1,
            String address2, String zip, String town, String eMail,
            long id)
    {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address1 = address1;
        this.address2 = address2;
        this.zip = zip;
        this.town = town;
        this.eMail = eMail;
        this.id = id;
    }

    /**
     * Setze einen neuen Vornamen des Kunden.
     *
     *
     * @param newFirstname neuer Vorname
     *
     * @see Customer#getFirstname()
     */
    public void setFirstname(String newFirstname)
    {
        firstname = newFirstname;
    }

    /**
     * Hole den aktuellen Vornamen des Kunden.
     *
     *
     * @return aktueller Vorname
     *
     * @see Customer#setFirstname(String)
     */
    public String getFirstname()
    {
        return firstname;
    }

    /**
     * Setze neuen Nachnamen.
     *
     *
     * @param newLastname
     *
     * @see Customer#getLastname()
     */
    public void setLastname(String newLastname)
    {
        lastname = newLastname;
    }

    /**
     * Hole den aktuellen Nachname des Kunden.
     *
     *
     * @return aktueller Nachname
     *
     * @see Customer#setLastname(String)
     */
    public String getLastname()
    {
        return lastname;
    }

    /**
     * Setze neuen Nachnamen.
     *
     *
     * @param newAddress1
     *
     * @see Customer#getAddress1()
     */
    public void setAddress1(String newAddress1)
    {
        address1 = newAddress1;
    }

    /**
     * Method declaration
     *
     *
     * @return
     *
     * @see
     */
    public String getAddress1()
    {
        return address1;
    }

    /**
     * Method declaration
     *
     *
     * @param newAddress2
     *
     * @see
     */
    public void setAddress2(String newAddress2)
    {
        address2 = newAddress2;
    }

    /**
     * Method declaration
     *
     *
     * @return
     *
     * @see
     */
    public String getAddress2()
    {
        return address2;
    }

    /**
     * Method declaration
     *
     *
     * @param newZip
     *
     * @see
     */
    public void setZip(String newZip)
    {
        zip = newZip;
    }

    /**
     * Method declaration
     *
     *
     * @return
     *
     * @see
     */
    public String getZip()
    {
        return zip;
    }

    /**
     * Method declaration
     *
     *
     * @param newTown
     *
     * @see
     */
    public void setTown(String newTown)
    {
        town = newTown;
    }

    /**
     * Method declaration
     *
     *
     * @return
     *
     * @see
     */
    public String getTown()
    {
        return town;
    }

    /**
     * Method declaration
     *
     *
     * @param newEMail
     *
     * @see
     */
    public void setEMail(String newEMail)
    {
        eMail = newEMail;
    }

    /**
     * Method declaration
     *
     *
     * @return
     *
     * @see
     */
    public String getEMail()
    {
        return eMail;
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
     * Ausgabe des Kunden als String.
     *
     *
     * @return der Kunde
     *
     */
    @Override
    public String toString()
    {
        return "Firstname: " + firstname + "  Lastname: " + lastname + "  Address: " + address1 + " " + address2 + "  ZIP/Town: " + zip + " " + town + "  eMail: " + eMail;
    }
}

//
// History
//
// $Log:$
//
//
