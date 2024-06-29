package org.example.implementation.dynamic;

import org.example.definition.IQueueDoubleLinkCyclicDynamic;
import org.example.definition.Queue;
import org.example.implementation.dynamic.nodes.Node;
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
            this.last = new NodeDoubleLinked(a,null,null);
            count++;
        }

    }

    @Override
    public void addLast(int a) {

    }

    @Override
    public void removeFirst() {

    }

    @Override
    public void removeLast() {

    }

    @Override
    public boolean isEmpty() {return Objects.isNull(this.first);}

    @Override
    public NodeDoubleLinked getFirst() {
        return null;
    }

    @Override
    public NodeDoubleLinked getLast() {
        return null;
    }
}


