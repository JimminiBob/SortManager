package org.sparta.jn.nested_classes;

import java.time.LocalDate;
import java.util.Comparator;


public class Spartan {
    private String name;
    private LocalDate startDate;

    public class SpartanComparator implements Comparator<Spartan> {

        @Override
        public int compare(Spartan spartan1, Spartan spartan2) {
            return spartan1.getName().compareTo(spartan2.getName());
        }

    public Spartan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    @Override
    public String toString() {
        return "Spartan{" +
                "name='" + name + '\'' +
                ", startDate=" + startDate +
                '}';
    }
    @Override
    public int compareTo(Spartan otherSpartan) {
        return this.getName().compareTo(otherSpartan.getName()); //broken single responsibility prince
    }

}
