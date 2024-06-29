package org.example.PuntosTPO.Punto2_4;

import org.example.implementation.normal.StaticQueue;

public interface IStaticQueueBuilder {

    /**
     * Postcondicion: Agrega un valor al Queue.
     *
     * @param a valor a encolar.
     */
    StaticQueueBuilder add(int a);

    /**
     * Postcondicion: Agrega varios valor al Queue.
     *
     * @param cola de valores a agregar.
     */
    StaticQueueBuilder addAll(StaticQueue cola);

    int[] build();
}

