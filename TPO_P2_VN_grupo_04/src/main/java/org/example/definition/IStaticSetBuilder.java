package org.example.definition;

import org.example.implementation.normal.StaticSet;
import org.example.implementation.normal.StaticSetBuilder;

/**
 * Precondicion: para usar cualquier de estos metodos la estructura debe estar inicializada.
 */
public interface IStaticSetBuilder {

    /**
     * Postcondicion: Agrega un valor al conjunto.
     *
     * @param a valor a agregar.
     */
    StaticSetBuilder add(int a);

    /**
     * Postcondicion: Agrega varios valor al conjunto.
     *
     * @param set valores a agregar.
     */
    StaticSetBuilder addAll(StaticSet set);

    int[] build();
}



