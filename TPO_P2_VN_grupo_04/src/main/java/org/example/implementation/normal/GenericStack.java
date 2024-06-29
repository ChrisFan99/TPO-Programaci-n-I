package org.example.implementation.normal;

import org.example.definition.IGenericStack;

public class GenericStack<T> implements IGenericStack<T> {

    private static final int MAX = 10000;

    private final T[] array;
    private int count;

    public GenericStack() {
        this.array = (T[]) new Object[MAX];
        this.count = 0;
    }

    @Override
    public void add(T a) {
        if(this.count >= MAX) {
            throw new RuntimeException("Muchos elementos");
        }
        this.array[this.count++] = a;
    }

    @Override
    public void remove() {
        if(this.isEmpty()) {
            throw new RuntimeException("Pila Generica Vacía");
        }
        this.count--;
    }

    @Override
    public boolean isEmpty() {return this.count == 0;}

    @Override
    public T getTop() {
        if(this.isEmpty()) {
            throw new RuntimeException("Pila vacía");
        }
        return this.array[this.count - 1];
    }
}
