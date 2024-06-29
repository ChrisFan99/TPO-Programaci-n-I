package org.example.PuntosTPO.Punto2_6;

/**
 * Precondicion: para usar cualquier de estos metodos la estructura debe estar inicializada.
 */
public interface SetRepeated {

    /**
     * Postcondicion: Agrega un valor al conjunto, si ya se encuentra suma la cantidad.
     *
     * @param elementos a agregar
     * @param cantidad de elementos.
     */
    void add(int elementos, int cantidad);

    /**
     * Postcondicion: Quita una cantidad del elemento del conjunto,
     * si la cantidad es mayor o igual a la cantidad existente,
     * sera eliminado del conjunto
     *
     * @param elementos a quitar.
     * @param cantidad de elementos.
     */
    void remove(int elementos, int cantidad);

    /**
     * @return <code>true</code> si es el conjunto vacio, <code>false</code> en otro caso.
     */
    boolean isEmpty();

    /**
     * @return elemento arbitrario del conjunto.
     */
    int choose();



}
