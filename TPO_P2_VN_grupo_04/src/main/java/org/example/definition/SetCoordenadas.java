package org.example.definition;

import org.example.implementation.normal.StaticSet;

/**
 * Precondicion: para usar cualquier de estos metodos la estructura debe estar inicializada.
 */
public interface SetCoordenadas {

    /**
     * Postcondicion: Agrega coordenadas (x, y) al conjunto.
     *
     * @param a coordenadas a agregar.
     */
    void add(StaticSet a);

    /**
     * Postcondicion: Quita la coordenada indicada si existe, de lo contrario no hace nada.
     *
     * @param a coordenada a quitar.
     */
    void remove(StaticSet a);

    /**
     * @return <code>true</code> si es el conjunto vacio, <code>false</code> en otro caso.
     */
    boolean isEmpty();

    /**
     * @return coordenada arbitraria del conjunto.
     */
    StaticSet choose();

}