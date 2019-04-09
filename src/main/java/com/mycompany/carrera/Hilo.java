/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.carrera;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 *
 * @author Yesid Avila
 */
public class Hilo extends Thread {

    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador jugador3;


    int pas = 0;
    private ArrayList<Jugador> listaJugadores = new ArrayList<Jugador>();

    public Hilo(Jugador jugador1, Jugador jugador2, Jugador jugador3) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.jugador3 = jugador3;
    }



    @Override
    public void run() {

        Random ran = new Random();
        System.out.println("Equipo " + jugador2.getEquipo() + " Jugador " + jugador2.getNombre() + " " + jugador2.getPasos() + " En espera");
        //System.out.println("Jugador " + jugador3.getNombre() + " " + jugador3.getPasos() + " En espera");

        while (pas < 100) {
            int random = ran.random();
            if (jugador1.getPasos() < 33) {
                pas = pas + random;

                if (pas > 33) {
                    pas = 33;
                }
                jugador1.setPasos(pas);
                
                System.out.println("Equipo " + jugador2.getEquipo() + " Jugador " + jugador1.getNombre() + " " + jugador1.getPasos());

                try {
                    synchronized (jugador1) {

                        Thread.sleep(500);
                        if (Terminada1()) {
                            jugador1.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (jugador2.getPasos() >= 33 && jugador2.getPasos() < 66) {
                pas = pas + random;
                if (pas > 66) {
                    pas = 66;
                }
                jugador2.setPasos(pas);
                System.out.println("Equipo " + jugador2.getEquipo() + " Jugador " + jugador2.getNombre() + " " + jugador2.getPasos());
                try {
                    synchronized (jugador2) {
                        Thread.sleep(500);
                        if (Terminada2()) {
                            jugador2.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (jugador3.getPasos() >= 66 && jugador3.getPasos() < 100) {
                pas = pas + random;
                if (pas > 100) {
                    pas = 100;
                }
                jugador3.setPasos(pas);
                System.out.println("Equipo " + jugador3.getEquipo() + " Jugador " + jugador3.getNombre() + " " + jugador3.getPasos());
                try {
                    synchronized (jugador3) {
                        Thread.sleep(500);
                        if (Terminada3()) {
                            jugador3.notifyAll();

                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
        if (pas == 100) {
            System.out.println("El ganador es el equipo " + jugador3.getEquipo());
            currentThread().stop();
        }
    }

    public boolean Terminada1() {
        boolean ter;
        ter = jugador1.getPasos() >= 33;
        return ter;
    }

    public boolean Terminada2() {
        boolean ter;
        ter = jugador2.getPasos() >= 66;
        return ter;
    }

    public boolean Terminada3() {
        boolean ter;
        ter = jugador3.getPasos() == 100;
        return ter;
    }

}
