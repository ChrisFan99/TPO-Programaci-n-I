package org.example.JavaUtil;

import org.example.implementation.normal.GenericStack;
import org.example.implementation.normal.StaticPriorityQueue;
import org.example.implementation.normal.StaticSet;
import org.example.implementation.normal.StaticStack;

public class StaticStackUtil {

    public static GenericStack copyGeneric (GenericStack stack){
        GenericStack stackAux = new GenericStack();
        GenericStack stackAux2 = new GenericStack();

        while (!stack.isEmpty()){
            stackAux2.add(stack.getTop());
            stack.remove();
        }

        while (!stackAux2.isEmpty()){
            stackAux.add(stackAux2.getTop());
            stack.add(stackAux2.getTop());
            stackAux2.remove();
        }

        return stackAux;
    }

    public static StaticStack copyStatic (StaticStack stack){
        StaticStack stackAux = new  StaticStack();
        StaticStack stackAux2 = new StaticStack();

        while (!stack.isEmpty()){
            stackAux2.add(stack.getTop());
            stack.remove();
        }

        while (!stackAux2.isEmpty()){
            stackAux.add(stackAux2.getTop());
            stack.add(stackAux2.getTop());
            stackAux2.remove();
        }

        return stackAux;
    }

    public static GenericStack invertir (GenericStack stack){
        GenericStack copy = copyGeneric(stack);
        GenericStack stackAux = new GenericStack();

        while (!copy.isEmpty()){
            stackAux.add(copy.getTop());
            copy.remove();
        }

        return stackAux;
    }

    public static StaticStack pilaOrdenadaNoRepetidos (StaticStack stack){
        StaticStack copy = copyStatic(stack);
        StaticStack stackOrdenadoNoRepetidos = new StaticStack();
        StaticSet setAux = new StaticSet();
        StaticPriorityQueue priorityQueueAux = new StaticPriorityQueue();

        while (!copy.isEmpty()){
            setAux.add(copy.getTop());
            copy.remove();
        }

        while (!setAux.isEmpty()) {
            int elementoAgregar = setAux.choose();
            priorityQueueAux.add(elementoAgregar, elementoAgregar);
            setAux.remove(elementoAgregar);
        }

        while (!priorityQueueAux.isEmpty()){
            stackOrdenadoNoRepetidos.add(priorityQueueAux.getFirst());
            priorityQueueAux.remove();
        }

        return stackOrdenadoNoRepetidos;
    }


}
