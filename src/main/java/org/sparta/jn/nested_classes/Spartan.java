package org.sparta.jn.nested_classes;

import java.time.LocalDate;
import java.util.Comparator;

public class Spartan {
    private String name;
    private LocalDate startDate;

    public static class SpartanComparator implements Comparator<Spartan> {

        @Override
        public int compare(Spartan spartan1, Spartan spartan2) {
            return spartan1.getName().compareTo(spartan2.getName());
        }
    }

    public Spartan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
        {
            //ststic bloack
        }

    }

    public String getName() {
        class SpartanName {
            //can only see directly outside
        }
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
}

