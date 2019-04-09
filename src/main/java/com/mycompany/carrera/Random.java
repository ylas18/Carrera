/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.carrera;

/**
 *Esta clase lo uqe hace es crear un numero aleatorio el cual es usado en la carrera
 * @author Yesid Avila
 */

public class Random {

    public int numero;

    public int random() {

        numero = (int) (Math.random() * 3) + 1;
        return numero;
    }

}
