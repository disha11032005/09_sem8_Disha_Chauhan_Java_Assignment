/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fashion.que4;

/**
 *
 * @author root
 */
import jakarta.ejb.Stateful;
import java.util.*;

@Stateful
public class ShoppingCartBean {

    Map<String, Double> cart = new LinkedHashMap<>();

    public void addBook(String book, double price) {
        cart.put(book, price);
    }

    public Map<String, Double> getCart() {
        return cart;
    }

    public double getTotal() {

        double total = 0;

        for(double p : cart.values()) {
            total += p;
        }

        return total;
    }

    public void clearCart() {
        cart.clear();
    }
}