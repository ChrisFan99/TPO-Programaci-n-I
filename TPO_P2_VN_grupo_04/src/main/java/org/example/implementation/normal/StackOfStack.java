package org.example.implementation.normal;

import org.example.definition.IStackOfStack;

public class StackOfStack implements IStackOfStack {

    private static final int MAX = 10000;

    private final StaticStack[] array;
    private int count;

    public StackOfStack() {
        this.array = new StaticStack[MAX];
        this.count = 0;
    }

    @Override
    public void add(StaticStack a) {
        if(this.count >= MAX) {
            throw new RuntimeException("Muchos elementos");
        }
        this.array[this.count++] = a;
    }


    @Override
    public void remove() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede remover elementos de una pila vacía");
        }
        this.count--;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public StaticStack getTop() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede obtener tope de una pila vacia");
        }
        return this.array[this.count - 1];
    }
}
