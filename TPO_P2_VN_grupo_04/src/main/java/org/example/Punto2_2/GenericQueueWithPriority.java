package org.example.Punto2_2;

import org.example.definition.IGenericQueueWithPriority;

public class GenericQueueWithPriority<T> implements IGenericQueueWithPriority<T> {

    private static final int LENGTH = 10000;
    private final T[] values;
    private final int[] priorities;
    private int count;

    public GenericQueueWithPriority() {
        this.values = (T[]) new Object[LENGTH];
        this.priorities = new int[LENGTH];
        this.count = 0;
    }

    @Override
    public void add(T a, int priority) {
        if(this.isEmpty() || priorities[count - 1] <= priority) {
            values[count] = a;
            priorities[count] = priority;
            count++;
            return;
        }

        if(priority <= priorities[0]) {
            for(int i = count - 1; i >= 0; i--) {
                values[i + 1] = values[i];
                priorities[i + 1] = priorities[i];
            }
            values[0] = a;
            priorities[0] = priority;
            count++;
            return;
        }

        int index = -1;
        for(int i = 1; i < count; i++) {
            if(priorities[i] > priority) {
                index = i;
                break;
            }
        }

        for(int i = count - 1; i >= index; i--) {
            values[i + 1] = values[i];
            priorities[i + 1] = priorities[i];
        }
        values[index] = a;
        priorities[index] = priority;
        count++;
    }


    @Override
    public void remove() {
        if(isEmpty()) {
            throw new RuntimeException("No se puede desacolar una cola vacia");
        }
        for(int i = 0; i < count - 1; i++) {
            values[i] = values[i + 1];
            priorities[i] = priorities[i + 1];
        }
        count--;
    }

    @Override
    public boolean isEmpty() {return count == 0;}

    @Override
    public T getFirst() {return values[0];}

    @Override
    public int getPriority() {return priorities[0];}
}
