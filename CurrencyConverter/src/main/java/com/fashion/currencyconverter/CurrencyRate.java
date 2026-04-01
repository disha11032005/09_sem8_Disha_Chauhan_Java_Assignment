/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fashion.currencyconverter;

import jakarta.persistence.*;

@Entity
@Table(name="currency_rate")

/**
 *
 * @author root
 */
public class CurrencyRate {
    
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String from_currency;
    private String to_currency;
    private double rate;

    // Getter and Setter
    public double getRate() {
        return rate;
    }
    
}
