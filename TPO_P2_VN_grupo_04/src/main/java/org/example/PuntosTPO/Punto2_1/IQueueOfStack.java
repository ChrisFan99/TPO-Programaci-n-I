package org.example.PuntosTPO.Punto2_1;

import org.example.implementation.normal.StaticStack;

/**
 * Precondicion: Para usar cualquiera de estos metodos la estructura debe estar inicializada.
 */

public interface IQueueOfStack {

    /**
     * Postcondicion: Acola (coloca en el final de la cola) una Pila(Stack).
     *
     * @param a valor a acolar.
     */
    void add(StaticStack a);

             /**
     * Precondicion: La cola no esta vacia.
     * Postcondicion: Desacola (quita el primer elemento).
     */
    void remove();

    /**
     * @return <code>true</code> si la cola esta vacia, <code>false</code> en otro caso.
     */
    boolean isEmpty();

    /**
     * @return Devuelve el primer elemento.
     */
    StaticStack getFirst();



}
