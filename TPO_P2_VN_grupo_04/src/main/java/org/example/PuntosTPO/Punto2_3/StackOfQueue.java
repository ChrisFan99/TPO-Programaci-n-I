package org.example.PuntosTPO.Punto2_3;

import org.example.implementation.normal.StaticQueue;

public class StackOfQueue implements IStackOfQueue {

    private static final int Max = 10000;
    private StaticQueue[] array;
    private int count;

    public StackOfQueue() {
        this.array = new StaticQueue[Max];
        this.count = 0;
    }

    @Override
    public void add(StaticQueue a) {
        if (count == Max){
            throw new RuntimeException("Muchos elemetos");
        }
        this.array[count] = a;
        count++;
    }

    @Override
    public void remove() {
        if (isEmpty()){
            throw new RuntimeException("No se puede dasapilar de pila vacia");
        }
        this.count--;
    }

    @Override
    public boolean isEmpty() {return count == 0;}

    @Override
    public StaticQueue getTop() {
        if (isEmpty()){
            throw new RuntimeException("No se puede devolver tope de una pila vacia");
        }
        return array[count-1];
    }
}
