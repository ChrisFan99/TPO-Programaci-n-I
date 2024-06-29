package org.example.definition;

/**
 * Precondicion: para usar cualquier de estos metodos la estructura debe estar inicializada.
 */
public interface IGenericSet<T> {

    /**
     * Postcondicion: Agrega un valor al conjunto.
     *
     * @param a valor a agregar.
     */
    void add(T a);

    /**
     * Postcondicion: Quita el elemento indicado si existe, de lo contrario no hace nada.
     *
     * @param a valor a quitar.
     */
    void remove(T a);

    /**
     * @return <code>true</code> si es el conjunto vacio, <code>false</code> en otro caso.
     */
    boolean isEmpty();

    /**
     * @return elemento arbitrario del conjunto.
     */
    T choose();

}



