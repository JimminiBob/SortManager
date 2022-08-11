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

        //SpartanComparator is a nested inner class

       // Spartan spartanObject = new Spartan(new Spartan("Manish", LocalDate.MAX));

        Spartan.SpartanComparator comparator = new Spartan.SpartanComparator(); //static inner class

        Collections.sort(spartans, comparator);
//        spartans.sort(comparator);
        System.out.println(spartans);

        MathOperation mathObject = new MathOperation() { //Anonymous inner class
            @Override
            public int add(int number1, int number2) {
                return number1 + number2;
            }
        };
        System.out.println(mathObject.add(5,7));
        System.out.println(mathObject.getClass());
    }
}
