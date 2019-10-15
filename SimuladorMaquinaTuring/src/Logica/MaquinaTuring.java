/**
 * 
 */
package Logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author harryalvarado28
 *
 */
public class MaquinaTuring {

    private String estadoActual;
    private int cursor;
    private String entrada;
    private HashMap<String, Accion> transicion;
    public  ArrayList<String> cinta;
    private static String ESPACIO_BLANCO = "B";
    private boolean pasos = false;
    private String ESTADO_FINAL = "qf";

    public MaquinaTuring(String entrada, HashMap transicion, boolean pasos) {
        this.entrada = entrada;
        this.transicion = transicion;
        this.pasos = pasos;
        cinta = new ArrayList<String>();
        init();
    }

    private void init() {
        //cinta.add(ESPACIO_BLANCO);
        for (int i = 0; i < entrada.length(); i++) {
            cinta.add(String.valueOf(entrada.charAt(i)));
        }
        cinta.add(ESPACIO_BLANCO);
        cursor = 1;
        estadoActual = "q1";
    }

    public void run() {
        while (true) {
            display();
            if (cursor == 0) {
                paso_derecha();
                cursor = 1;
            }
            Accion action;
            String key = estadoActual + cinta.get(cursor);
            if ((action = transicion.get(key)) != null) {
                exec(action);
                if (estadoActual.equals(ESTADO_FINAL)) {
                    detener();
                    break;
                }
            } else {
                detener();
                break;
            }
            if (pasos) {
                System.out.println("Presione ENTER para continuar...");
                new Scanner(System.in).nextLine();
            }
        }
    }

    private void paso_derecha() {
        cinta.add("B");
        for (int i = cinta.size() - 1; i > 0; i--) {
            Collections.swap(cinta, i, i -1);
        }
    }

    public void exec(Accion accion) {
        cinta.set(cursor, accion.nuevo_simbolo);
        estadoActual = accion.siguiente_estado;

        cursor += accion.movimiento.equals("R") ? 1 : - 1;
    }


    public void detener() {
        if (estadoActual.equals(ESTADO_FINAL)) {
            System.out.println("Ok");
        } else {
            System.out.println("OK");
        }
    }

    public void display() {
        System.out.print(cinta);
        System.out.println(" | estado: " + estadoActual);
        for (int i = 0; i < cinta.size(); i++) {
            System.out.print(" ");
            if (i == cursor) {
                System.out.print("^");
                break;
            }
            System.out.print("  ");
        }
        System.out.println();
    }
}
