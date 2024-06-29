package org.example.implementation.dynamic.nodes;

public class NodeDoubleLinked {

    private int value;
    private NodeDoubleLinked next;
    private NodeDoubleLinked last;

    public NodeDoubleLinked(int value, NodeDoubleLinked last, NodeDoubleLinked next) {
        this.value = value;
        this.next = next;
        this.last = last;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public NodeDoubleLinked getNext() {
        return next;
    }

    public void setNext(NodeDoubleLinked next) {
        this.next = next;
    }

    public NodeDoubleLinked getLast() {
        return last;
    }

    public void setLast(NodeDoubleLinked last) {
        this.last = last;
    }
}
