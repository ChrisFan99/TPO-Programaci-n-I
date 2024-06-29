package org.example.JavaUtil;

import org.example.implementation.normal.GenericSet;
import org.example.implementation.normal.StaticSet;

public class StaticSetUtil {

    public static StaticSet copy (StaticSet set){
        StaticSet setAux1 = new StaticSet();
        StaticSet setAux2 = new StaticSet();

        while (!set.isEmpty()){
            int elementoAgragar = set.choose();
            setAux1.add(elementoAgragar);
            setAux2.add(elementoAgragar);
            set.remove(elementoAgragar);
        }

        while (!setAux2.isEmpty()){
            int elementoAgragar = setAux2.choose();
            set.add(elementoAgragar);
            setAux2.remove(elementoAgragar);
        }

        return setAux1;
    }

    public static <T> GenericSet copyGeneric (GenericSet set){
        GenericSet setGenericAux1 = new GenericSet();
        GenericSet setGenericAux2 = new GenericSet();

        while (!set.isEmpty()){
            T elementoAgregar = (T) set.choose();
            setGenericAux1.add(elementoAgregar);
            setGenericAux2.add(elementoAgregar);
            set.remove(elementoAgregar);
        }

        while (!setGenericAux2.isEmpty()){
            T elementoAgregar = (T) setGenericAux2.choose();
            set.add(elementoAgregar);
            setGenericAux2.remove(elementoAgregar);
        }

        return setGenericAux1;
    }

}
