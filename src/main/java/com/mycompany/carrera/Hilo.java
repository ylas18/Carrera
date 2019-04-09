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

    /**
     * variables que declaramos para poder ser usadas en el run de la clase hilo
     */
    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador jugador3;

    /**
     * variable que almacena los pasos que da cada jugador
     */
    int pas = 0;
    /**
     * lista de los jugadores
     */
    private ArrayList<Jugador> listaJugadores = new ArrayList<Jugador>();

    /**
     * Parametros que recibimos de la clase inicio para poder ser usadas en la
     * clase hilo
     *
     * @param jugador1 equipo 1
     * @param jugador2 equipo2
     * @param jugador3 equipo3
     */
    public Hilo(Jugador jugador1, Jugador jugador2, Jugador jugador3) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.jugador3 = jugador3;
    }

    /**
     * metodo run el cual es el que ejecuta todos los hilos
     */
    @Override
    public void run() {

        Random ran = new Random(); //ran es una variable que almacena el numero aleatorio que se le da a cada equipo para que avance
        System.out.println("Equipo " + jugador2.getEquipo() + " Jugador " + jugador2.getNombre() + " " + jugador2.getPasos() + " En espera");
        /**
         * este while se encarga de mantener un ciclo infinito hasta que pas que
         * es la variable de pasos totales sea mayos a 100
         */
        while (pas < 100) {
            int random = ran.random();
            /**
             * esta condicion nos dice que mientras sea los pasos del jugador 1
             * menor a 33 inicie
             */
            if (jugador1.getPasos() < 33) {
                pas = pas + random;
                /**
                 * este if condiciona que si por algun caso el aleatorio me dio
                 * la suma de mas de 33 lo iguale a 33 el cual es el limite
                 * maximo
                 */
                if (pas > 33) {
                    pas = 33;
                }
                /**
                 * almacenamos los pasos en la variable pasos de la lista del
                 * jugador 1 e imprimimos el equipo, nombre y numeor de pasos
                 */
                jugador1.setPasos(pas);

                System.out.println("Equipo " + jugador2.getEquipo() + " Jugador " + jugador1.getNombre() + " " + jugador1.getPasos());

                try {
                    /**
                     * sincronizamos la variable en comun para que se inicie y
                     * bloquee el resto de hilos
                     */
                    synchronized (jugador1) {

                        Thread.sleep(500);
                        /**
                         * preguntamos si el primer corredor acabo la carrera
                         * para poder notificar a los otros hlos si ya pueden
                         * iniciar
                         */
                        if (Terminada1()) {
                            jugador1.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                /**
                 * esta condicion nos dice que mientras sea los pasos del
                 * jugador 2 mayor a 33 y menor a 66 inicie
                 */
            } else if (jugador2.getPasos() >= 33 && jugador2.getPasos() < 66) {
                pas = pas + random;
                /**
                 * este if condiciona que si por algun caso el aleatorio me dio
                 * la suma de mas de 66 lo iguale a 66 el cual es el limite
                 * maximo
                 */
                if (pas > 66) {
                    pas = 66;
                }
                /**
                 * almacenamos los pasos en la variable pasos de la lista del
                 * jugador 2 e imprimimos el equipo, nombre y numeor de pasos
                 */
                jugador2.setPasos(pas);
                System.out.println("Equipo " + jugador2.getEquipo() + " Jugador " + jugador2.getNombre() + " " + jugador2.getPasos());
                try {
                    /**
                     * sincronizamos la variable en comun para que se inicie y
                     * bloquee el resto de hilos
                     */
                    synchronized (jugador2) {
                        Thread.sleep(500);
                        /**
                         * preguntamos si el primer corredor acabo la carrera
                         * para poder notificar a los otros hlos si ya pueden
                         * iniciar
                         */
                        if (Terminada2()) {
                            jugador2.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                /**
                 * esta condicion nos dice que mientras sea los pasos del
                 * jugador 3 mayor a 66 y menor a 100 inicie
                 */
            } else if (jugador3.getPasos() >= 66 && jugador3.getPasos() < 100) {
                pas = pas + random;
                /**
                 * este if condiciona que si por algun caso el aleatorio me dio
                 * la suma de mas de 33 lo iguale a 33 el cual es el limite
                 * maximo
                 */
                if (pas > 100) {
                    pas = 100;
                }
                /**
                 * almacenamos los pasos en la variable pasos de la lista del
                 * jugador 1 e imprimimos el equipo, nombre y numeor de pasos
                 */
                jugador3.setPasos(pas);
                System.out.println("Equipo " + jugador3.getEquipo() + " Jugador " + jugador3.getNombre() + " " + jugador3.getPasos());
                try {
                    /**
                     * sincronizamos la variable en comun para que se inicie y
                     * bloquee el resto de hilos
                     */
                    synchronized (jugador3) {
                        Thread.sleep(500);
                        /**
                         * preguntamos si el primer corredor acabo la carrera
                         * para poder notificar a los otros hlos si ya pueden
                         * iniciar
                         */
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

    /**
     * estos metodos lo que hacen es verificar si cada jugador termino la
     * carrera comparando la cantidad de pasos con la deseada
     *
     * @return un boolean el cual comparamos si es verdadero o falso
     */
    public boolean Terminada1() {
        boolean ter;
        ter = jugador1.getPasos() >= 33;
        return ter;
    }

    /**
     * estos metodos lo que hacen es verificar si cada jugador termino la
     * carrera comparando la cantidad de pasos con la deseada
     *
     * @return un boolean el cual comparamos si es verdadero o falso
     */
    public boolean Terminada2() {
        boolean ter;
        ter = jugador2.getPasos() >= 66;
        return ter;
    }

    /**
     * estos metodos lo que hacen es verificar si cada jugador termino la
     * carrera comparando la cantidad de pasos con la deseada
     *
     * @return un boolean el cual comparamos si es verdadero o falso
     */
    public boolean Terminada3() {
        boolean ter;
        ter = jugador3.getPasos() == 100;
        return ter;
    }

}
