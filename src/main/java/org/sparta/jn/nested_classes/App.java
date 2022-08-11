package org.sparta.jn.nested_classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class App {
    public static void main(String[] args) {
        ArrayList<Spartan> spartans = new ArrayList<>(Arrays.asList(
                new Spartan("Manish,", LocalDate.now()),
                new Spartan("David,", LocalDate.now()),
                new Spartan("Stephen,", LocalDate.now())
                ));
        ArrayList<String> turtles = new ArrayList<>(Arrays.asList(
                "Leonardo",
                "Donatello",
                "Michelangelo",
                "Raphael"
        ));

        Collections.sort(turtles);
        System.out.println(turtles);
        SpartanComparator comparator = new SpartanComparator();

        Collections.sort(spartans, comparator);
        System.out.println(spartans);
    }
}
