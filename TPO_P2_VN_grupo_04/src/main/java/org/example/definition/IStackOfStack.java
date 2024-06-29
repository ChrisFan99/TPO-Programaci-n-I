package org.example.definition;

import org.example.implementation.normal.StaticStack;

/**
 * Precondicion: para usar cualquier de estos metodos la estructura debe estar inicializada.
 */
public interface IStackOfStack {

    /**
     * Postcondicion: Apila (coloca en el tope) una pila.
     *
     * @param a pila a apilar.
     */
    void add(StaticStack a);

    /**
     * Precondicion: La pila no esta vacia.
     * Postcondicion: Desapila (quita el tope).
     */
    void remove();

    /**
     * @return <code>true</code> si la pila esta vacia, <code>false</code> en otro caso.
     */
    boolean isEmpty();

    /**
     * @return tope de la pila
     */
    StaticStack getTop();

}





