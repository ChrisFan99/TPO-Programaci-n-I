package org.example.PuntosTPO.Punto2_2;

/**
 * Precondicion: para usar cualquier de estos metodos la estructura debe estar inicializada.
 */
public interface IGenericStack<T> {

    /**
     * Postcondicion: Apila (coloca en el tope) un valor.
     *
     * @param a valor a apilar.
     */
    void add(T a);

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
    T getTop();

}

