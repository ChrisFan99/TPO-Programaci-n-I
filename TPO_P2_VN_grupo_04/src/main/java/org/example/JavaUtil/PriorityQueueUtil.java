package org.example.JavaUtil;

import org.example.implementation.normal.StaticPriorityQueue;
import org.example.implementation.normal.StaticQueue;

public class PriorityQueueUtil {

    public static StaticQueue copyQueue (StaticQueue queue){
        StaticQueue copy1 = new StaticQueue();
        StaticQueue copy2 = new StaticQueue();

        while (!queue.isEmpty()){
            copy1.add(queue.getFirst());
            copy2.add(queue.getFirst());
            queue.remove();
        }

        while (!copy2.isEmpty()){
            queue.add(copy2.getFirst());
            copy2.remove();
        }

        return copy1;
    }

    public static StaticPriorityQueue copyPriorityQueue (StaticPriorityQueue queue){
        StaticPriorityQueue copy1 = new StaticPriorityQueue();
        StaticPriorityQueue copy2 = new StaticPriorityQueue();

        while (!queue.isEmpty()){
            copy1.add(queue.getFirst(), queue.getPriority());
            copy2.add(queue.getFirst(), queue.getPriority());
            queue.remove();
        }

        while (!copy2.isEmpty()){
            queue.add(copy2.getFirst(), copy2.getPriority());
            copy2.remove();
        }

        return copy1;
    }

    public static StaticPriorityQueue editarPar (StaticPriorityQueue priorityQueue, int v, int priority){
        StaticPriorityQueue copy1 = copyPriorityQueue(priorityQueue);
        StaticQueue queueValue = new StaticQueue();
        StaticQueue queuepriority = new StaticQueue();
        StaticQueue queuepriorityOriginal = new StaticQueue();
        StaticPriorityQueue priorityQueueAux = new StaticPriorityQueue();

        boolean bandera = false;
        int priorityremplace = 0;

        while (!copy1.isEmpty()){
            if (copy1.getFirst() == v) {
                queueValue.add(copy1.getFirst());
                queuepriority.add(priority);
                priorityremplace = copy1.getPriority();
                bandera = true;
            }
            else {
                queueValue.add(copy1.getFirst());
                queuepriority.add(copy1.getPriority());
            }
            queuepriorityOriginal.add(copy1.getPriority());
            copy1.remove();
        }

        StaticQueue copyQueuepriorityOrig = copyQueue(queuepriorityOriginal);
        StaticQueue copyQueuepriority = copyQueue(queuepriority);

        int[] posicionesCriticas = new int[10000];
        int count = 0;
        int dif = 0;
        int difGeneric = 0;

        while (!copyQueuepriorityOrig.isEmpty()){
            if (copyQueuepriorityOrig.getFirst() != copyQueuepriority.getFirst()){
                posicionesCriticas[count] = copyQueuepriority.getFirst();
                if (copyQueuepriorityOrig.getFirst() > copyQueuepriority.getFirst()) {
                    dif = copyQueuepriorityOrig.getFirst() - copyQueuepriority.getFirst();
                }
                else {
                    dif = copyQueuepriority.getFirst() - copyQueuepriorityOrig.getFirst();
                }
                posicionesCriticas[count] = dif;
            }
            count++;
            copyQueuepriorityOrig.remove();
            copyQueuepriority.remove();
        }

        while (!queuepriorityOriginal.isEmpty()){
            if  (count == 0){
                priorityQueueAux.add(queueValue.getFirst(),queuepriority.getFirst());
                queuepriorityOriginal.remove();
                queueValue.remove();
                continue;
            }
            priorityQueueAux.add(queueValue.getFirst(),queuepriority.getFirst()-dif);
            count--;
            queuepriorityOriginal.remove();
            queueValue.remove();
        }
        return priorityQueueAux;
    }

}
