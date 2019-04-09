/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.carrera;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yesid Avila
 */
public class Inicio {

    ArrayList<Jugador> listaJugador = new ArrayList<Jugador>();

    /**
     * metodo le cual llena la lista de jugadores e inicia los 3 hilos a la vez
     */
    public void llenarEquipo() {

        Equipo equipo1 = new Equipo("Equipo1");
        Equipo equipo2 = new Equipo("Equipo2");
        Equipo equipo3 = new Equipo("Equipo3");

        Jugador jugador1 = new Jugador(1, 0, "Yesid");
        Jugador jugador2 = new Jugador(1, 33, "Shirley");
        Jugador jugador3 = new Jugador(1, 66, "Max");
        Jugador jugador4 = new Jugador(2, 0, "Choco");
        Jugador jugador5 = new Jugador(2, 33, "Alejandra");
        Jugador jugador6 = new Jugador(2, 66, "Mono");
        Jugador jugador7 = new Jugador(3, 0, "Laura");
        Jugador jugador8 = new Jugador(3, 33, "Dana");
        Jugador jugador9 = new Jugador(3, 66, "Wilson");

        equipo1.getListaJugadores().add(jugador1);
        equipo1.getListaJugadores().add(jugador2);
        equipo1.getListaJugadores().add(jugador3);
        equipo2.getListaJugadores().add(jugador4);
        equipo2.getListaJugadores().add(jugador5);
        equipo2.getListaJugadores().add(jugador6);
        equipo3.getListaJugadores().add(jugador7);
        equipo3.getListaJugadores().add(jugador8);
        equipo3.getListaJugadores().add(jugador9);

        listaJugador.add(jugador1);
        listaJugador.add(jugador2);
        listaJugador.add(jugador3);

        Hilo hilo1 = new Hilo(jugador1, jugador2, jugador3);
        Hilo hilo2 = new Hilo(jugador4, jugador5, jugador6);
        Hilo hilo3 = new Hilo(jugador7, jugador8, jugador9);

        hilo1.start();
        hilo2.start();
        hilo3.start();
    }

    public void imprimirEquipos() {

        for (Jugador lj : listaJugador) {
            System.out.println(lj.getNombre() + lj.getPasos());

        }
    }

}
