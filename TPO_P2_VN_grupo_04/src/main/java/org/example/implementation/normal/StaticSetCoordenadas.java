package org.example.implementation.normal;

import org.example.definition.SetCoordenadas;

import java.util.Random;

public class StaticSetCoordenadas implements SetCoordenadas {

    private StaticSet[] setCoordenadas;
    private int count;

    @Override
    public void add(StaticSet a) {
        for(int i = 0; i < count; i++) {

        }
    }

    @Override
    public void remove(StaticSet a) {

    }

    @Override
    public boolean isEmpty() {return count == 0;}

    @Override
    public StaticSet choose() {
        if(this.count == 0) {
            throw new RuntimeException("No se puede elegir un valor de un conjunto vacio");

        }
        return this.setCoordenadas[new Random().nextInt(this.count)];
    }

}
