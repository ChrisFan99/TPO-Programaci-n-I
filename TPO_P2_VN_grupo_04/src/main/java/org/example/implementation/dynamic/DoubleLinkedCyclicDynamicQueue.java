package org.example.implementation.dynamic;

import org.example.definition.IQueueDoubleLinkCyclicDynamic;
import org.example.implementation.dynamic.nodes.NodeDoubleLinked;

import java.util.Objects;

public class DoubleLinkedCyclicDynamicQueue implements IQueueDoubleLinkCyclicDynamic {

    private NodeDoubleLinked first;
    private NodeDoubleLinked last;
    private int count;

    @Override
    public void addFirst(int a) {
        if (this.isEmpty()) {
            this.first = new NodeDoubleLinked(a, null, null);
            this.last = this.first;
            count++;
        } else {
            NodeDoubleLinked newNode = new NodeDoubleLinked(a, last, first);
            last.setLast(newNode);
            first.setNext(newNode);
            first = newNode;
            count++;
        }

    }

    @Override
    public void addLast(int a) {
        if (this.isEmpty()) {
            this.first = new NodeDoubleLinked(a, null, null);
            this.last = this.first;
            count++;
        } else {
            NodeDoubleLinked newNode = new NodeDoubleLinked(a, last, first);
            last.setNext(newNode);
            first.setLast(newNode);
            last = newNode;
            count++;
        }
    }

    @Override
    public void removeFirst() {
        if (this.isEmpty()) {
            throw new RuntimeException("La cola está vacía");
        } else if (count == 1) {
            first = null;
            last = null;
            count--;
        } else {
            NodeDoubleLinked newNode = first.getNext();
            last.setNext(newNode);
            newNode.setLast(last);
            first.getNext().setLast(last);
            last.setNext(first.getNext());
            first = newNode;
            count--;
        }
    }

    @Override
    public void removeLast() {
        if (this.isEmpty()) {
            throw new RuntimeException("La cola está vacía");
        } else if (count == 1) {
            first = null;
            last = null;
            count--;
        } else {
            NodeDoubleLinked newNode = last.getLast();
            newNode.setNext(first);
            first.setLast(newNode);
            last = newNode;
            count--;
        }
    }

    @Override
    public boolean isEmpty() {return Objects.isNull(this.first);}

    @Override
    public NodeDoubleLinked getFirst() {
        return first;
    }

    @Override
    public NodeDoubleLinked getLast() {
        return last;
    }
}


