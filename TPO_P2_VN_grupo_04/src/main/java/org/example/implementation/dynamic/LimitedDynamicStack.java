package org.example.implementation.dynamic;

import org.example.definition.Stack;
import org.example.implementation.dynamic.nodes.Node;

import java.util.Objects;

public class LimitedDynamicStack implements Stack {

    private Node first;
    private int maximosElmentos;
    private int count;

    public LimitedDynamicStack(int maximosElmentos) {
        this.maximosElmentos = maximosElmentos;
        this.count = 0;
    }

    @Override
    public void add(int a) {
        if (count == maximosElmentos){
            throw new RuntimeException("Muchos elemetos");
        }
        this.first = new Node(a, this.first);
        count++;
    }

    @Override
    public void remove() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede desapilar una pila vacia");
        }
        this.first = this.first.getNext();
        count--;
    }

    @Override
    public int getTop() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede desapilar una pila vacia");
        }
        return this.first.getValue();
    }

    @Override
    public boolean isEmpty() {
        return Objects.isNull(this.first);
    }

}
