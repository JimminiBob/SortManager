package org.sparta.jn.nested_classes;

import java.util.Comparator;

public class SpartanComparator implements Comparator<Spartan> {

    @Override
    public int compare(Spartan spartan1, Spartan spartan2) {
        return spartan1.getName().compareTo(spartan2.getName());
    }
}
