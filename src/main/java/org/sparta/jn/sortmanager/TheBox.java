package org.sparta.jn.sortmanager;

public class TheBox<T> {
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public static void main(String[] args) {
        TheBox<? super Integer> box = new TheBox<>();
        box.setT(new Integer(10));
        System.out.println(box.getT());
    }
}
