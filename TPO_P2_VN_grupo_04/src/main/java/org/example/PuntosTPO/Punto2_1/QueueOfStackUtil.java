package org.example.PuntosTPO.Punto2_1;

import org.example.implementation.normal.StaticStack;

public class QueueOfStackUtil {

    public static StaticStack copyStack (StaticStack pilaO){
        StaticStack pila1 = new StaticStack();
        StaticStack pila2 = new StaticStack();

        while (!pilaO.isEmpty()){
            pila2.add(pilaO.getTop());
            pilaO.remove();
        }

        while (!pila2.isEmpty()){
            pilaO.add(pila2.getTop());
            pila1.add(pilaO.getTop());
            pila2.remove();
        }

        return pila1;
    }

    public static QueueOfStack copy (QueueOfStack Queue){
        QueueOfStack copy1 = new QueueOfStack();
        QueueOfStack copy2 = new QueueOfStack();

        while (!Queue.isEmpty()){
            copy1.add(Queue.getFirst());
            copy2.add(Queue.getFirst());
            Queue.remove();
        }

        while (!copy2.isEmpty()){
            Queue.add(copy2.getFirst());
            copy2.remove();
        }

        return copy1;
    }

    //ObtenerTraza: O(n2)
    public static int ObtenerTraza (QueueOfStack Queue){
        QueueOfStack copy1 = copy(Queue);
        int aux1 = 0;
        int aux2;
        int traza = 0;


        while(!copy1.isEmpty()){
            StaticStack pilaAux1 = copyStack(copy1.getFirst());
            copy1.remove();
            aux2 = aux1;

            while(!pilaAux1.isEmpty() && aux2>0){pilaAux1.remove();aux2--;}

            traza += pilaAux1.getTop();
            aux1 ++;
        }

        return traza;
    }

    //Traspuesta: O(n⋅m)
    public static QueueOfStack Traspuesta (QueueOfStack Queue) {
        QueueOfStack copy1 = copy(Queue);
        QueueOfStack traspuesta = new QueueOfStack();
        QueueOfStack traspuestaAux = new QueueOfStack();
        StackOfStack pilaAux = new StackOfStack();
        boolean bandera = true;

        while (!copy1.isEmpty()){
            pilaAux.add(copy1.getFirst());
            copy1.remove();
        }

        while (!pilaAux.isEmpty()){
            while (!pilaAux.getTop().isEmpty()){
                if (bandera){
                    StaticStack pilaAux2 = new StaticStack();
                    pilaAux2.add(pilaAux.getTop().getTop());
                    traspuesta.add(pilaAux2);
                    traspuestaAux.add(traspuesta.getFirst());
                    traspuesta.remove();
                    pilaAux.getTop().remove();
                }
                else {
                    traspuesta.getFirst().add(pilaAux.getTop().getTop());
                    pilaAux.getTop().remove();
                    traspuestaAux.add(traspuesta.getFirst());
                    traspuesta.remove();
                }
            }
            bandera = false;
            pilaAux.remove();
            while (!traspuestaAux.isEmpty()){
                traspuesta.add(traspuestaAux.getFirst());
                traspuestaAux.remove();
            }
        }

        return traspuesta;

        /*

        ******************** Otra alternativa con Matriz ********************
        QueueOfStack copy1 = copy(Queue);

        int matriz[][] = new int[Queue.getCount()][Queue.getCount()];

        for (int i = 0; i < Queue.getCount(); i++) {
            StaticStack pilaAux = copyStack(copy1.getFirst());
            for (int j = 0; j < Queue.getCount(); j++) {
                matriz[i][j] = pilaAux.getTop();
                pilaAux.remove();
            }
            copy1.remove();
        }

        for (int i = 0; i <= matriz.length-1; i++) {
            StaticStack pilaAux = new StaticStack();
            for (int j = matriz.length-1; j >= 0; j--) {
                pilaAux.add(matriz[j][i]);
            }
            copy1.add(pilaAux);
        }
        return copy1;

        */
    }

    //SumaMatricial: O(n⋅m)
    public static QueueOfStack SumaMatricial (QueueOfStack Queue, QueueOfStack Queue2){
        QueueOfStack copy11 = copy(Queue);
        QueueOfStack copy21 = copy(Queue2);
        QueueOfStack QueueOfStackSumatoria = new QueueOfStack();

        while (!copy11.isEmpty()){
            StaticStack pilaAux11 = copyStack(copy11.getFirst());
            StaticStack pilaAux21 = copyStack(copy21.getFirst());
            StaticStack pilaAux = new StaticStack();
            while (!pilaAux11.isEmpty()) {
                pilaAux.add(pilaAux11.getTop() + pilaAux21.getTop());
                pilaAux11.remove();
                pilaAux21.remove();
            }
            while (!pilaAux.isEmpty()){
                pilaAux11.add(pilaAux.getTop());
                pilaAux.remove();
            }
            copy11.remove();
            copy21.remove();
            QueueOfStackSumatoria.add(pilaAux11);
        }
        return QueueOfStackSumatoria;
    }
}