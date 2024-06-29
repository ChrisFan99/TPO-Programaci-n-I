package org.example.implementation.normal;

import org.example.definition.IGenericQueue;

public class GenericQueue<T> implements IGenericQueue<T> {

    private static final int MAX = 10000;

    private final T[] array;
    private int count;

    public GenericQueue() {
        array = (T[]) new Object[MAX];
        count = 0;
    }

    @Override
    public void add(T a) {
        if(count == MAX) {
            throw new RuntimeException("No se puede agregar el elemento");
        }
        array[count] = a;
        count++;
    }

    @Override
    public void remove() {
        if(isEmpty()) {
            throw new RuntimeException("No se puede desacolar una cola vacia");
        }
        for(int i = 0; i < count - 1; i++) {
            array[i] = array[i + 1];
        }
        count--;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public T getFirst() {
        if(isEmpty()) {
            throw new RuntimeException("No se puede obtener el primero de una cola vacia");
        }
        return array[0];
    }
}
