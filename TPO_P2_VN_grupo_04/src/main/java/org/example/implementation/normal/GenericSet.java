package org.example.implementation.normal;

import org.example.definition.IGenericSet;

import java.util.Random;

public class GenericSet<T> implements IGenericSet<T> {

    private static final int MAX = 10000;
    private T[] array;
    private int count;

    public GenericSet() {
        this.array = (T[]) new Object[MAX];
        this.count = 0;
    }

    @Override
    public void add(T a) {
        if(count == MAX) {
            throw new RuntimeException("Limite de elementos alcanzado");
        }
        for(int i = 0; i < count; i++) {
            if(this.array[i] == a) {
                return;
            }
        }
        this.array[count] = a;
        this.count++;
    }

    @Override
    public void remove(T a) {
        for(int i = 0; i < count; i++) {
            if(this.array[i] == a) {
                this.array[i] = this.array[count - 1];
                count--;
                return;
            }
        }
    }

    @Override
    public boolean isEmpty() {return this.count == 0;}

    @Override
    public T choose() {
        if(this.count == 0) {
            throw new RuntimeException("No se puede elegir un valor de un conjunto vacio");
        }
        return this.array[new Random().nextInt(this.count)];
    }
}
