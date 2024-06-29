package org.example.PuntosTPO.Punto2_4;

import org.example.implementation.normal.StaticSet;

import java.util.Random;

public class StaticSetBuilder implements IStaticSetBuilder {

    private static final int MAX = 10;
    public int[] set;
    public int count;

    public StaticSetBuilder() {
        this.set = new int[MAX];
        this.count = 0;
    }

    @Override
    public StaticSetBuilder add(int a) {
        if(count == MAX) {
            throw new RuntimeException("Limite de elementos alcanzado");
        }
        for(int i = 0; i < count; i++) {
            if(this.set[i] == a) {
                return null;
            }
        }
        set[count] = a;
        count++;

        return this;
    }


    @Override
    public StaticSetBuilder addAll(StaticSet set) {
        while (!set.isEmpty()){
            if (count == MAX){
                throw new RuntimeException("Muchos elementos");
            }
            boolean bandera = true;
            int elementoAgregar = set.choose();

            for (int i =0; i< count;i++){
                if(this.set[i] == elementoAgregar) {
                    bandera = false;
                }
            }
            if (bandera) {
                this.set[count] = elementoAgregar;
                count++;
            }
            set.remove(elementoAgregar);
        }

        return this;
    }

    public void remove(int a){
        for(int i = 0; i < count; i++) {
            if(this.set[i] == a) {
                this.set[i] = this.set[count - 1];
                count--;
                return;
            }
        }
    }


    public boolean isEmpty(){return count == 0;}

    public int choose() {
        if(this.count == 0) {
            throw new RuntimeException("No se puede elegir un valor de un conjunto vacio");
        }
        return this.set[new Random().nextInt(this.count)];
    }

    @Override
    public int[] build() {
        return set;
    }


}
