package org.example.implementation.normal;

import org.example.definition.MultipleDictionaryRandom;
import org.example.definition.Set;

import java.util.*;

public class StaticMultipleDictionaryRandom implements MultipleDictionaryRandom {

    private static final int MAX = 100;

    private int[][] array;
    private int count;
    private int countList;

    public StaticMultipleDictionaryRandom() {
        this.array = new int[MAX][MAX];
        this.count = 0;
    }

    @Override
    public void add(int key, int value) {
        if(count == MAX) {
            throw new RuntimeException("Limite de elementos alcanzado");
        }
        for(int i = 0; i < count; i++) {
            if(this.array[i][0] == key) {
                this.array[i][array[i][1] + 2] = value;
                this.array[i][1]++;
                return;
            }
        }
        this.array[count] = new int[MAX];
        this.array[count][0] = key;
        this.array[count][2] = value;
        this.array[count][1] = 1;
        this.count++;
    }

    @Override
    public void remove(int key, int value) {
        for(int i = 0; i < count; i++) {
            if(this.array[i][0] == key) {
                if(this.array[i][1] == 1) {
                    if(this.array[i][2] == value) {
                        this.array[i] = this.array[count - 1];
                        count--;
                        return;
                    }
                    throw new RuntimeException("No existe el valor para la clave dada");
                }

                for(int j = 0; j < this.array[i][1]; j++) {
                    if(this.array[i][j + 2] == value) {
                        this.array[i][j + 2] = this.array[i][this.array[i][1] + 1];
                        // - 1 (correccion de la ultima posicion)
                        // + 2 (la clave y el total de valores en las posiciones 0 y 1)
                        this.array[i][1]--;
                        return;
                    }
                }
            }
        }
        throw new RuntimeException("No existe la clave");
    }

    @Override
    public Set getKeys() {
        Set set = new StaticSet();
        for(int i = 0; i < count; i++) {
            set.add(this.array[i][0]);
        }
        return set;
    }

    @Override
    public int[] get(int key) {
        for(int i = 0; i < count; i++) {
            if(this.array[i][0] == key) {
                int[] list = new int[MAX];
                for(int j = 0; j < array[i][1]; j++){
                    list[j] = (array[i][j + 2]);
                    countList++;
                }
                return list;
            }
        }
        throw new RuntimeException("No existe un valor asociado a la clave");
    }

    public int randomValueWhithKey(int key) {
        int[] elementos = this.get(key);
        return elementos[new Random().nextInt(this.countList)];
    }

}
