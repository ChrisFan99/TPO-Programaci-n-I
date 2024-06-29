package org.example.implementation.normal;

import org.example.PuntosTPO.Punto2_2.StaticSetUtil;

public class UniversalSet extends StaticSet {

    public UniversalSet() {
        super();
    }

    public boolean isSubset(StaticSet set) {
        StaticSet setCopy = StaticSetUtil.copy(set);
        while (!setCopy.isEmpty()) {
            int element = setCopy.choose();
            setCopy.remove(element);
            boolean found = false;
            StaticSet thisCopy = StaticSetUtil.copy(this);
            while (!thisCopy.isEmpty()) {
                    int thisElement = thisCopy.choose();
                    thisCopy.remove(thisElement);
                    if (thisElement == element) {
                        found = true;
                        break;
                    }
                }
            if (!found) {return false;}
        }
        return true;
    }

    public StaticSet complement(StaticSet set) {
        if (!this.isSubset(set)) {
            throw new RuntimeException("No se puede calcular el complemento de un conjunto que no es subconjunto del superconjunto");
        }
        StaticSet complement = new StaticSet();
        StaticSet thisCopy = StaticSetUtil.copy(this);
        StaticSet otherCopy = StaticSetUtil.copy(set);
        while (!thisCopy.isEmpty()) {
            StaticSet otherCopy2 = StaticSetUtil.copy(set);
            int element = thisCopy.choose();
            thisCopy.remove(element);
            boolean found = false;
            while (!otherCopy2.isEmpty()) {
                int otherElement = otherCopy2.choose();
                otherCopy2.remove(otherElement);
                if (otherElement == element) {
                    found = true;
                    otherCopy.remove(otherElement);
                    break;
                }
                otherCopy.remove(otherElement);

            }
            if (!found) {
                complement.add(element);

            }
        }
        return complement;
    }
}

