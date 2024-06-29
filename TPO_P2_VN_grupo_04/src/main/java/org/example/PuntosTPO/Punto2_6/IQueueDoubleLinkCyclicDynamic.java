package org.example.PuntosTPO.Punto2_6;

import org.example.implementation.dynamic.nodes.NodeDoubleLinked;

/**
 * Precondicion: para usar cualquier de estos metodos la estructura debe estar inicializada.
 */
public interface IQueueDoubleLinkCyclicDynamic {

    /**
     * Postcondicion: Acola (coloca en el principio de la cola) un valor.
     *
     * @param a valor a acolar.
     */
    void addFirst(int a);

    /**
     * Postcondicion: Acola (coloca en el final de la cola) un valor.
     *
     * @param a valor a acolar.
     */
    void addLast(int a);

    /**
     * Precondicion: La cola no esta vacia.
     * Postcondicion: Desacola (quita el primer elemento de la cola).
     */
    void removeFirst();

    /**
     * Precondicion: La cola no esta vacia.
     * Postcondicion: Desacola (quita el ultimo elemento de la cola).
     */
    void removeLast();

    /**
     * @return <code>true</code> si la cola esta vacia, <code>false</code> en otro caso.
     */
    boolean isEmpty();

    /**
     * @return Devuelve el primero Node.
     */
    NodeDoubleLinked getFirst();

    /**
     * @return Devuelve el Ultimo Node.
     */
    NodeDoubleLinked getLast();




}



