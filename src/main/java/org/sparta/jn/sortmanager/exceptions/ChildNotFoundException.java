package org.sparta.jn.sortmanager.exceptions;

public class ChildNotFoundException extends IndexOutOfBoundsException {

    @Override
    public String getMessage() {
        return "This node has no child!";
    }
}
