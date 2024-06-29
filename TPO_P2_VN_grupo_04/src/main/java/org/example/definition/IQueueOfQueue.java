package org.example.definition;

import org.example.implementation.normal.QueueOfQueue;
import org.example.implementation.normal.QueueOfStack;
import org.example.implementation.normal.StaticQueue;

/**
 * Precondicion: para usar cualquier de estos metodos la estructura debe estar inicializada.
 */
public interface IQueueOfQueue {

    /**
     * Postcondicion: Acola (coloca en el final de la cola) un valor.
     *
     * @param a valor a acolar.
     */
    void add(StaticQueue a);

    /**
     * Precondicion: La cola no esta vacia.
     * Postcondicion: Desacola (quita el primer elemento).
     */
    void remove();

    /**
     * @return <code>true</code> si la cola esta vacia, <code>false</code> en caso contrario.
     */
    boolean isEmpty();

    /**
     * @return Devuelve el primero.
     */
    StaticQueue getFirst();

    /**
     * Postcondicion: Concatena instancias de QueueOfQueue en una sola
     * @param queue valor a concatenar
     */

    void concatenate(QueueOfQueue queue);

    /**
     * @return Crea una instancia de <code>queue</code> a partir de la instancia <code>QueueOfQueue</code>
     */
    StaticQueue flat (QueueOfQueue queue);

    /**
     *
     * @Postcondicion: Invierte la instancia de QueueOfQueue pero tambien cada Queue dentro de esta
     */
    QueueOfQueue reverseWithDepth (QueueOfQueue queue);

}