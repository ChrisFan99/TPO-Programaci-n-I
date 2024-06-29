package org.example.implementation.normal;

import org.example.definition.SetRepeated;

public class StaticSetRepeated implements SetRepeated {

    private static final int MAX = 10000;

    private int[][] array;
    private int count;

    public StaticSetRepeated() {
        this.array = new int[MAX][];
        this.count = 0;
    }

    @Override
    public void add(int elementos, int cantidad) {
        int[] duplas = {elementos,cantidad};
        if(count == MAX) {
            throw new RuntimeException("Limite de elementos alcanzado");
        }
        for(int i = 0; i < count; i++) {
            if (this.array[i][0] == duplas[0]){
                this.array[i][1] += duplas[1];
                return;
            }
        }
        this.array[count] = duplas;
        count++;

    }

    @Override
    public void remove(int elementos, int cantidad) {
        int[] duplas = {elementos,cantidad};
        for(int i = 0; i < count; i++) {
            if(this.array[i] == duplas) {
                this.array[i] = this.array[count - 1];
                count--;
                return;
            }
        }
    }

    @Override
    public boolean isEmpty() {return this.count == 0;}

    @Override
    public int choose() {
        int totalCantidad = 0;
        for (int i = 0; i < count; i++) {
            totalCantidad += array[i][1];
        }

        int randomIndex = (int) (Math.random() * totalCantidad);
        int acumulado = 0;

        for (int i = 0; i < count; i++) {
            acumulado += array[i][1];
            if (randomIndex < acumulado) {
                return array[i][0];
            }
        }

        throw new RuntimeException("No se encontró un elemento");
    }
}
