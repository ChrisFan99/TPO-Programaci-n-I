package org.example.definition;

import org.example.implementation.normal.StaticQueue;

/**
 * Precondicion: para usar cualquier de estos metodos la estructura debe estar inicializada.
 */
public interface IStackOfQueue {

    /**
     * Postcondicion: Apila (coloca en el tope) una cola.
     *
     * @param a cola a apilar.
     */
    void add(StaticQueue a);

    /**
     * Precondicion: La pila no esta vacia.
     * Postcondicion: Desapila (quita el tope).
     */
    void remove();

    /**
     * @return <code>true</code> si la pila esta vacia, <code>false</code> en caso contrario.
     */
    boolean isEmpty();

    /**
     * @return tope de la pila
     */
    StaticQueue getTop();

}


