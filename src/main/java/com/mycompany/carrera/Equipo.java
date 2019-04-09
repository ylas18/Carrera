/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.carrera;

import java.util.ArrayList;

/**
 *
 * @author Yesid Avila
 */
public class Equipo {

    public String nombre;
    public int totalPasos;
    private ArrayList<Jugador> listaJugadores = new ArrayList<Jugador>();

    

    

    public Equipo() {
    }

    public Equipo(String nombre) {
        this.nombre = nombre;
    }

    public Equipo(String nombre, int totalPasos) {
        this.nombre = nombre;
        this.totalPasos = totalPasos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTotalPasos() {
        return totalPasos;
    }

    public void setTotalPasos(int totalPasos) {
        this.totalPasos = totalPasos;
    }

    public ArrayList<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(ArrayList<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

}
