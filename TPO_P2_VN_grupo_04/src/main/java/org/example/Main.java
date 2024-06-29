package org.example;

import org.example.JavaUtil.PriorityQueueUtil;
import org.example.JavaUtil.QueueOfStackUtil;
import org.example.JavaUtil.StaticSetUtil;
import org.example.JavaUtil.StaticStackUtil;
import org.example.definition.IQueueOfStack;
import org.example.definition.Set;
import org.example.implementation.dynamic.DoubleLinkedCyclicDynamicQueue;
import org.example.implementation.dynamic.DynamicQueue;
import org.example.implementation.dynamic.LimitedDynamicStack;
import org.example.implementation.dynamic.nodes.Node;
import org.example.implementation.dynamic.nodes.NodeDoubleLinked;
import org.example.implementation.normal.*;

import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        /*
        StaticStack pila1= new StaticStack();
        StaticStack pila2= new StaticStack();
        StaticStack pila3= new StaticStack();
        StaticStack pila4= new StaticStack();

        pila1.add(3);
        pila1.add(2);
        pila1.add(5);
        pila1.add(5);

        pila2.add(1);
        pila2.add(3);
        pila2.add(3);
        pila2.add(4);

        pila3.add(3);
        pila3.add(2);
        pila3.add(1);
        pila3.add(3);

        pila4.add(1);
        pila4.add(2);
        pila4.add(3);
        pila4.add(4);

        QueueOfStack cola = new QueueOfStack();
        cola.add(pila1);
        cola.add(pila2);
        cola.add(pila3);
        cola.add(pila4);

        QueueOfStack cola2 = new QueueOfStack();
        cola2.add(pila4);
        cola2.add(pila3);
        cola2.add(pila2);
        cola2.add(pila1);

        //Punto 2.1.1
        int traza;
        traza = QueueOfStackUtil.ObtenerTraza(cola);
        System.out.println(traza);
        //ObtenerTraza: O(n2)

        //Punto 2.1.2
        QueueOfStack traspuesta = QueueOfStackUtil.Traspuesta(cola);
        //Traspuesta: O(n⋅m)

        //Punto 2.1.3
        QueueOfStack sumatoria = QueueOfStackUtil.SumaMatricial(cola, cola2);
        //SumaMatricial: O(n⋅m)

        //****************** Complejidad Computacional ******************
        //ObtenerTraza: O(n^2)
        //Traspuesta: O(n⋅m)
        //SumaMatricial: O(n⋅m)

        //(Revisar Complejidad)

        //Punto 2.2.1
        GenericStack pila = new GenericStack();
        pila.add("Hola");
        pila.add("como");
        pila.add(1);
        pila.add("Usted");
        GenericStack pilaInvertida = StaticStackUtil.invertir(pila);
        pilaInvertida.remove();
        System.out.println(pilaInvertida.isEmpty());
        System.out.println(pilaInvertida.getTop());

        GenericQueue queue = new GenericQueue();
        queue.add("Hola");
        queue.add(true);
        queue.add(1);
        System.out.println(queue.isEmpty());
        queue.remove();
        System.out.println(queue.getFirst());

        GenericSet setGeneric = new GenericSet();
        setGeneric.add(1);
        setGeneric.add(1);
        setGeneric.add("Hola");
        setGeneric.add("Hola");
        setGeneric.add("Progra");
        System.out.println(setGeneric.isEmpty());
        System.out.println(setGeneric.choose());
        setGeneric.remove("Hola");

        GenericQueueWithPriority priorityQueue = new GenericQueueWithPriority();
        priorityQueue.add("Hola",2);
        priorityQueue.add(true,2);
        priorityQueue.add(3,1);
        priorityQueue.add(1.7d,1);
        System.out.println(priorityQueue.isEmpty());
        System.out.println(priorityQueue.getPriority());
        System.out.println(priorityQueue.getFirst());
        priorityQueue.remove();

        //Punto 2.2.2
        GenericSet set = new GenericSet();
        set.add(1);
        set.add("Hola");
        set.add(2);
        set.add(true);
        set.add("Viernes");

        GenericSet set2 = StaticSetUtil.copyGeneric(set);
        System.out.println(set2.isEmpty());
        System.out.println(set2.choose());


        //Punto 2.3.1
        //Creacion de QueueOfQueue y Queues
        QueueOfQueue coladecolas1 = new QueueOfQueue();
        QueueOfQueue coladecolas2 = new QueueOfQueue();

        StaticQueue cola3 = new StaticQueue();
        StaticQueue cola4 = new StaticQueue();
        StaticQueue cola5 = new StaticQueue();
        StaticQueue cola6 = new StaticQueue();


        //Asignacion de valores de colas que se agregaran a QueueOfQueue
        cola3.add(1);
        cola3.add(2);
        cola4.add(3);
        cola4.add(4);
        cola5.add(5);
        cola5.add(6);
        cola6.add(7);
        cola6.add(8);

        //Agregar colas a QueueOfQueue
        coladecolas1.add(cola3);
        coladecolas1.add(cola4);

        //Agregar colas a QueueOfQueue2
        coladecolas2.add(cola5);
        coladecolas2.add(cola6);

        //Concatenar coladecolas1 y coladecolas2 a colaVacia
        QueueOfQueue colaVacia = new QueueOfQueue();
        colaVacia.concatenate(coladecolas1);
        colaVacia.concatenate(coladecolas2);

        //Punto 2.3.2
        //Creacion de queueFlat
        StaticQueue colaFlat;
        colaFlat = colaVacia.flat(colaVacia);
        System.out.println(colaFlat);

        //Punto 2.3.3
        //Creacion de queueOfQueue invertida
        QueueOfQueue colainvertida = new QueueOfQueue();
        colainvertida = colaVacia.reverseWithDepth(colaVacia);
        System.out.println(colaVacia);


        //Punto2.4
        //El patron builder es un patron de diseño, estos patrones son soluciones ya establecidas a
        //problemas conocidos, ya programadores diseñaron estos patrones para poder solucionar el/los
        //problemas en el codigo, identificados por varios programadores.

        //La necesidad de este patron surge a la hora de crear un objeto con muchos atributos y cuando
        //hay que pasar todos los atributos en un mismo constructor, no se puede distiguir lo
        //que estamos diciendo, por ejemplo si se recibe 5 Strings.
        //Entonces el Builder es un objeto al que le voy a decir todos los valores para los atributos del
        //objeto que quiero crear y el Builder me da el objeto, facilitando le legibilidad del codigo y
        //se que significa cada uno de los valores que le estoy pasando

        //- Ventajas:
        //        .Reduce el acoplamiento
        //        .Mayor control en el proceso de creacion del objeto

        //- Desventajas:
        //        .Si se agrega un atributo indispensable para la creacion del objeto y no se lo asigno
        //        al builder, no me voy a enterar hasta el tiempo de ejecucion
        //        .Incremento de complejidad en el codigo

        //Prueba Metodo Builder Set
        StaticSetBuilder setBuilder = new StaticSetBuilder();
        int [] set3 = setBuilder.add(1).add(2).add(3).build();

        StaticSet setAgregar = new StaticSet();
        setAgregar.add(5);setAgregar.add(2);setAgregar.add(4);setAgregar.add(4);
        StaticSetBuilder setBuilder2 = new StaticSetBuilder();
        int [] set4 = setBuilder2.add(2).add(1).addAll(setAgregar).build();

        //Prueba Metodo Builder Stack
        StaticStackBuilder stackBuilder = new StaticStackBuilder();
        int [] stack = stackBuilder.add(1).add(2).add(2).add(3).build();

        StaticStack stackAgregar = new StaticStack();
        stackAgregar.add(1);stackAgregar.add(1);stackAgregar.add(2);stackAgregar.add(2);
        StaticStackBuilder stackBuilder2 = new StaticStackBuilder();
        int [] stack2 = stackBuilder2.add(2).add(3).addAll(stackAgregar).build();

        //Prueba Metodo Builder Queue + Constructor n elementos
        int [] array = {1,2,3,4};
        StaticQueue colaAgregar = new StaticQueue();
        StaticQueue colaAgregar2 = new StaticQueue();

        colaAgregar.add(3);colaAgregar.add(4);colaAgregar.add(5);colaAgregar.add(6);
        colaAgregar2.add(7);colaAgregar2.add(8);colaAgregar2.add(9);colaAgregar2.add(10);

        StaticQueueBuilder queueBuilder1 = new StaticQueueBuilder();
        StaticQueueBuilder queueBuilder2 = new StaticQueueBuilder();
        StaticQueueBuilder queueBuilder3 = new StaticQueueBuilder(array);

        int [] queue1 = queueBuilder1.add(1).add(2).add(3).build();
        int [] queue2 = queueBuilder2.add(1).add(2).addAll(colaAgregar).build();
        int [] queue3 = queueBuilder3.add(5).add(6).addAll(colaAgregar2).build();

        //Punto 2.5.1 - Algoritmos
        StaticStack pilaDesordenada = new StaticStack();
        pilaDesordenada.add(3);
        pilaDesordenada.add(3);
        pilaDesordenada.add(3);
        pilaDesordenada.add(2);
        pilaDesordenada.add(2);
        pilaDesordenada.add(2);
        pilaDesordenada.add(1);
        pilaDesordenada.add(1);

        StaticStack pilaOrdenadaNoRepetidos = StaticStackUtil.pilaOrdenadaNoRepetidos(pilaDesordenada);
        //Nosotros lo hicimos con StaticPriorityQueue, pero se podria hacer con
        //TreeSet o PriorityNode

        //Complejidadad Computacional de cada metodo por separado:
        //- copy = o(n)
        //- Primer While: O(n)
        //- Segundo While: O(n+klogk)
        //- Tercer While: O(k)
        //- Complejidad total del metodo: O(n+klogk)
        // n: Cantidad elementos del stack original
        // k: Cantidad elementos del stack resultados luego de eliminar duplicados

        //Punto 2.5.2.1 - Metodo Montecarlo - TDA coordenadas del plano
        Coordenadas corde1 = new Coordenadas(0.7d,1d);
        Coordenadas corde2 = new Coordenadas(0.7d,1d);
        Coordenadas corde3 = new Coordenadas(0.7d,0.9d);
        Coordenadas corde4 = new Coordenadas(0.75d,0.9d);
        Coordenadas corde5 = new Coordenadas(2.5d,1.5d);
        Coordenadas corde6 = new Coordenadas(2.5d,3.1d);

        //Punto 2.5.2.2 - Metodo Montecarlo - Definir region cuadrada
        //Definir regionCuadrada x e y, si no se ingresa se tomara el cuadrado unidad (x:1, y:1)
        MonteCarlo plano = new MonteCarlo();
        plano.setRegionCuadradaX(3);
        plano.setRegionCuadradaY(4);

        //Punto 2.5.2.3 - Metodo reciba coordenadas y agregue al plano
        plano.agregarCoordenadas(corde1);
        plano.agregarCoordenadas(corde2);
        plano.agregarCoordenadas(corde3);
        plano.agregarCoordenadas(corde4);
        plano.agregarCoordenadas(corde5);
        plano.agregarCoordenadas(corde6);

        //Punto 2.5.2.4 - Crear conjunto de coordenadas y agregar elementos hasta caardinalidad 1000
        MonteCarlo cardinalidad1000 = new MonteCarlo();
        Random random = new Random();

        for (int i = 0; i < 1000; i++){
            double x = random.nextDouble();
            double y = random.nextDouble();
            Coordenadas coordenadas = new Coordenadas(x,y);
            cardinalidad1000.agregarCoordenadas(coordenadas);

        }

        //Punto 2.5.2.5 - Utilizar montecarlo para aproximar π
        double pi = cardinalidad1000.aproximarPi();
        System.out.println("Aproximacion de π: "+ pi);

        //Punto 2.6.1 - Pila dinamica con capacidad limitada
        LimitedDynamicStack limiDynamicStack = new LimitedDynamicStack(2);
        limiDynamicStack.add(1);
        limiDynamicStack.add(2);
        //Aca se lanza la excepcion ya que la cantidad maxima de elemtos es 2
        //limiDynamicStack.add(3);

        //Punto 2.6.2 - SuperConjunto
        UniversalSet universalSet = new UniversalSet();
        StaticSet subSet = new StaticSet();

        universalSet.add(2);
        universalSet.add(2);
        universalSet.add(4);
        universalSet.add(1);
        subSet.add(1);

        System.out.println(universalSet.isSubset(subSet));

        StaticSet setComplemento = universalSet.complement(subSet);


        //Punto 2.6.3
        //DoubleLinkedCyclicDynamicQueue pepe = new DoubleLinkedCyclicDynamicQueue();
        //pepe.addFirst(1);


        //Punto 2.6.5 - Devolver aleatoriamente algun valor a partir de una clave de un diccionario multiplo
        StaticMultipleDictionaryRandom multipleDictionaryRandom = new StaticMultipleDictionaryRandom();
        multipleDictionaryRandom.add(2,1);
        multipleDictionaryRandom.add(2,2);
        multipleDictionaryRandom.add(2,3);
        multipleDictionaryRandom.add(2,4);
        multipleDictionaryRandom.add(2,5);
        multipleDictionaryRandom.add(2,6);
        multipleDictionaryRandom.add(2,7);
        multipleDictionaryRandom.add(2,8);

        System.out.println(multipleDictionaryRandom.randomValueWhithKey(2));


        //Punto 2.7.1
        StaticPriorityQueue colaPrioridad = new StaticPriorityQueue();
        colaPrioridad.add(1,2);
        colaPrioridad.add(2,4);
        colaPrioridad.add(3,6);
        colaPrioridad.add(4,8);
        colaPrioridad.add(3,10);


        StaticPriorityQueue colaPrioridadEditarPar = PriorityQueueUtil.editarPar(colaPrioridad,3,2);

        */



        System.out.println();






    }
}