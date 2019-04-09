/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.carrera;

/**
 *
 * @author Yesid Avila
 */
public class Jugador {
/**
 * Indicador de cada equipo
 */
    public int equipo;
    /**
     * Numero de pasos de cada jugador
     */
    public int pasos;
    /**
     * Nombre de cada jugador
     */
    public String nombre;

    public Jugador() {
    }
/**
 * constuctor que inicializa las variables para que puedan ser usadas
 * @param equipo
 * @param pasos
 * @param nombre 
 */
    public Jugador(int equipo, int pasos, String nombre) {
        this.equipo = equipo;
        this.pasos = pasos;
        this.nombre = nombre;
    }

    public int getEquipo() {
        return equipo;
    }

    public void setEquipo(int equipo) {
        this.equipo = equipo;
    }

    public int getPasos() {
        return pasos;
    }

    public void setPasos(int pasos) {
        this.pasos = pasos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
