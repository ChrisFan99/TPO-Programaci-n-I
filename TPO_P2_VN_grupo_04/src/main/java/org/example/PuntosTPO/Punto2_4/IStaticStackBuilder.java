package org.example.PuntosTPO.Punto2_4;

import org.example.implementation.normal.StaticStack;

public interface IStaticStackBuilder {

    /**
     * Postcondicion: Agrega un valor al Stack.
     *
     * @param a valor a agregar.
     */
    StaticStackBuilder add(int a);

    /**
     * Postcondicion: Agrega varios valor al Stack.
     *
     * @param stack de valores a agregar.
     */
    StaticStackBuilder addAll(StaticStack stack);

    int[] build();
}

