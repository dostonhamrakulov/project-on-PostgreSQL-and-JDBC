/**
 * Copyright @ 2000 Peter Roßbach (pr@webapp.de) und Lars Röwekamp (Lars@openKnowlege.de)
 *
 * Source is only for non commercial and coaching usage.
 *
 * Not Warranty to use it.
 */
package de.ix.jspTutorial.model;

import java.util.*;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

/**
 * Class declaration
 *
 *
 * @author Peter Rossbach (<a href="mailto://pr@webapp.de">pr@webapp.de</a>),
 * Lars Röwekamp (
 * <a href="mailto://lars.roewekamp@openKnowledge.de">lars.roewekamp@openKnowledge.de</a>)
 * @version $Id:$
 */
public final class PersonalPizza extends Pizza
{

    private TreeMap<Long, Ingredient> ingredients;

    /**
     * Erzeuge Pizza für die Bestellung
     *
     *
     * @param aRequest Bestellanfrage
     * @param pizzaId Die Nummer der Pizze
     * @param ingredientIds Liste der zusätzlichen Zutaten
     *
     * @see
     */
    public PersonalPizza(HttpServletRequest aRequest, String pizzaId,
            String ingredientIds)
    {
        this.ingredients = new TreeMap<>();
        HttpSession theSession = aRequest.getSession(false);

        if (theSession == null)
            throw new RuntimeException("Session not Ready to order");
        PizzaList pizzaList = (PizzaList) theSession.getAttribute("pizzaList");
        if (pizzaList == null)
            throw new RuntimeException("Pizzaliste fehlt");
        IngredientList ingredientList = (IngredientList) theSession.getAttribute("ingredientList");

        System.out.println(pizzaId);

        Pizza pizza = pizzaList.getPizza(new Long(pizzaId.trim()));

        this.setPizza(pizza);
        System.out.println(pizza);
        StringTokenizer st = new StringTokenizer(ingredientIds, ",");

        for (; st.hasMoreElements();)
        {
            String s_ingredientId = (String) st.nextElement();
            Long ingredientId = new Long(s_ingredientId.trim());
            Ingredient ingredient = ingredientList.getIngredient(ingredientId);

            ingredients.put(ingredientId, ingredient);
        }
    }

    /**
     * Hole die Liste der aktuelle Zutaten der Bestellung.
     *
     *
     * @return aktuelle Zutaten
     *
     * @see
     */
    public java.util.TreeMap getIngredients()
    {
        return ingredients;
    }

    /**
     * Setze die Liste der Zutaten.
     *
     *
     * @param newIngredients
     *
     * @see
     */
    public void setIngredients(java.util.TreeMap<Long, Ingredient> newIngredients)
    {
        this.ingredients = newIngredients;
    }

    /**
     * Setze die bestellte Pizza
     *
     *
     * @param newPizza neue Bestellung
     *
     * @see
     */
    public void setPizza(Pizza newPizza)
    {
        this.setId(newPizza.getId());
        this.setBasePrice(newPizza.getBasePrice());
        this.setName(newPizza.getName());
        this.setSize(newPizza.getSize());
    }

    /**
     * Hole die bestelle Pizza. (Schade das es jetzt nicht klingelt!)
     *
     *
     * @return akutellle Pizza
     *
     * @see
     */
    public Pizza getPizza()
    {
        return (Pizza) this;
    }

    /**
     *
     * Berechne den Preis der Pizza. Der Preis berechnet sich aus dem Preis der
     * gewählten Grundpizza und den weiteren Zustaten.
     *
     * @return Der Preis der Pizza
     *
     * @see
     */
    public double calcTotalPrice()
    {
        double additionalPrice = 0.0;
        java.util.Set entrySet = ingredients.entrySet();

        for (Iterator iter = entrySet.iterator(); iter.hasNext();)
        {
            System.out.println("Entry found - try to get it ");
            Map.Entry entry = (Map.Entry) iter.next();

            System.out.println("Entry found - got it ");
            System.out.println("Try to get entry : " + entry.getValue());
            Ingredient ingredient = (Ingredient) entry.getValue();

            System.out.println("Try to get price : " + entry.getValue());
            double price = ingredient.getPrice();

            additionalPrice += price;
        }
        System.out.println("OK");
        return getBasePrice() + additionalPrice;
    }
}

//
// History
//
// $Log:$
//
//
