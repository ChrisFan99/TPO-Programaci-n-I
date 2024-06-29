package org.example.PuntosTPO.Punto2_3;

import org.example.implementation.normal.StaticQueue;
import org.example.implementation.normal.StaticStack;

public class QueueOfQueue implements IQueueOfQueue {

    public static final int Max = 10000;

    private StaticQueue[] array;
    private int countArray;

    private StaticQueue queue;

    public QueueOfQueue() {
        this.array = new StaticQueue[Max];
        this.countArray = 0;
        this.queue = new StaticQueue();
    }

    @Override
    public void add(StaticQueue a) {
        if (countArray >= Max){
            throw new RuntimeException("Muhcos elementos");
        }
        array[countArray] = a;
        countArray++;
    }

    @Override
    public void remove() {
        if (isEmpty()){
            throw new RuntimeException("No se puede remover elementos de cola vacia");
        }
        for (int i = 0;i< countArray;i++){
            array[i] = array[i+1];
        }
        countArray--;
    }

    @Override
    public boolean isEmpty() {return countArray == 0;}

    @Override
    public StaticQueue getFirst() {
        if (isEmpty()){
            throw new RuntimeException("No se puede obtener primer elemento de cola vacia");
        }
        return array[0];
    }

    @Override
    public void concatenate(QueueOfQueue queue) {
        while(!queue.isEmpty()){
            if (countArray >= Max){
                throw new RuntimeException("Muchos elementos");
            }
            array[countArray] = queue.getFirst();
            queue.remove();
            countArray++;
        }
    }

    @Override
    public StaticQueue flat(QueueOfQueue queue1) {
        while (!queue1.isEmpty()){
            while (!queue1.getFirst().isEmpty()){
                queue.add(queue1.getFirst().getFirst());
                queue1.getFirst().remove();
            }
            queue1.remove();
        }
        return queue;
    }

    @Override
    public QueueOfQueue reverseWithDepth(QueueOfQueue queue1) {
        StackOfQueue pilaQueueAux = new StackOfQueue();
        QueueOfQueue queueOfQueueAux = new QueueOfQueue();
        while (!queue1.isEmpty()){
            StaticQueue colaAux1 = new StaticQueue();
            StaticStack pilaAux1 = new StaticStack();
            while (!queue1.getFirst().isEmpty()){
                pilaAux1.add(queue1.getFirst().getFirst());
                queue1.getFirst().remove();
            }
            while (!pilaAux1.isEmpty()){
                colaAux1.add(pilaAux1.getTop());
                pilaAux1.remove();
            }
            pilaQueueAux.add(colaAux1);
            queue1.remove();
        }
        while (!pilaQueueAux.isEmpty()){
            queueOfQueueAux.add(pilaQueueAux.getTop());
            pilaQueueAux.remove();
        }
        return queueOfQueueAux;
    }
}
