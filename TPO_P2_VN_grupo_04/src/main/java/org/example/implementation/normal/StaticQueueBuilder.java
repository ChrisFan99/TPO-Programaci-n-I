package org.example.implementation.normal;

import org.example.definition.IStaticQueueBuilder;

public class StaticQueueBuilder implements IStaticQueueBuilder {

    private static final int Max = 10000;
    private int [] queue;
    private int count;

    public StaticQueueBuilder(int[] array) {
        this.queue = new int[Max];
        this.count = 0;

        for (int i = 0;i<array.length;i++){
            queue[count] = array[i];
            count++;
        }
    }

    public StaticQueueBuilder() {
        this.queue = new int[Max];
        this.count = 0;
    }

    @Override
    public StaticQueueBuilder add(int a) {
        if(count == 10000) {
            throw new RuntimeException("No se puede agregar el elemento");
        }
        this.queue[count] = a;
        count++;

        return this;
    }

    @Override
    public StaticQueueBuilder addAll(StaticQueue cola) {
        while (!cola.isEmpty()){
            if (count == Max){
                throw new RuntimeException("Muchos elementos");
            }
            this.queue[count] = cola.getFirst();
            count++;
            cola.remove();
        }
        return this;
    }

    public void remove() {
        if(isEmpty()) {
            throw new RuntimeException("No se puede desacolar una cola vacia");
        }
        for(int i = 0; i < count - 1; i++) {
            queue[i] = queue[i + 1];
        }
        count--;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int getFirst() {
        if(isEmpty()) {
            throw new RuntimeException("No se puede obtener el primero de una cola vacia");
        }
        return queue[0];
    }

    @Override
    public int[] build() {
        return queue;
    }
}
