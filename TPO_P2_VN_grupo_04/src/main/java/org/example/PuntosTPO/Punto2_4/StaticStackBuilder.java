package org.example.PuntosTPO.Punto2_4;

import org.example.implementation.normal.StaticStack;

public class StaticStackBuilder implements IStaticStackBuilder {

    public static final int Max = 10000;
    private int [] pila;
    private int count;

    public StaticStackBuilder() {
        this.pila = new int [Max];
        this.count = 0;
    }

    @Override
    public StaticStackBuilder add(int a) {
        if(this.count >= Max) {
            throw new RuntimeException("Limite excedido");
        }
        this.pila[this.count++] = a;

        return this;
    }

    @Override
    public StaticStackBuilder addAll(StaticStack stack) {
        while (!stack.isEmpty()){
            if (count == Max){
                throw new RuntimeException("Muchos elementos");
            }
            this.pila[count] = stack.getTop();
            count++;
            stack.remove();
        }
        return this;
    }

    public void remove() {
        if(this.isEmpty()) {
            throw new RuntimeException("Pila vacía");
        }
        this.count--;
    }

    public boolean isEmpty(){return this.count == 0;}

    public int getTop() {
        if(this.isEmpty()) {
            throw new RuntimeException("Pila vacía");
        }
        return this.pila[this.count - 1];
    }

    @Override
    public int[] build() {
        return pila;
    }


}
