package org.example.PuntosTPO.Punto2_1;

import org.example.implementation.normal.StaticStack;

public class QueueOfStack implements IQueueOfStack {

    private static final int Max = 15;
    private StaticStack array[];
    private int count;

    public QueueOfStack() {
        array = new StaticStack[Max];
        count = 0;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void add(StaticStack a) {
        if (count == Max){
            throw new RuntimeException("Muchos elementos en la cola");
        }
        array[count] = a;
        count++;
    }

    @Override
    public void remove() {
        if (isEmpty()){
            throw new RuntimeException("No se puede desacolar de una cola vacia");
        }
        for (int i=0;i < count; i++) {
            array[i] = array[i+1];
        }
        count--;
    }

    @Override
    public boolean isEmpty() {return count == 0;}

    @Override
    public StaticStack getFirst() {
        if (isEmpty()){
            throw new RuntimeException("No se puede obtener elemento de una cola vacia");
        }
        return array[0];
    }

}
