/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fashion.currencyconverter;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

/**
 *
 * @author root
 */

@Stateless
public class CurrencyConverterBean {
    
     @PersistenceContext(unitName = "Ass3PU")
    private EntityManager em;

    public double convert(String from, String to, double amount) {

        String jpql = "SELECT c FROM CurrencyRate c WHERE c.from_currency = :f AND c.to_currency = :t";

        TypedQuery<CurrencyRate> query =
                em.createQuery(jpql, CurrencyRate.class);

        query.setParameter("f", from);
        query.setParameter("t", to);

        CurrencyRate rate = query.getSingleResult();

        return amount * rate.getRate();
    }
    
}
