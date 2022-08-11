package org.sparta.jn.sortmanager.exceptions;

public class SortLoaderException extends RuntimeException{
    private String msg = "";
    public SortLoaderException(String msg) {
        this.msg =msg;
    }

    @Override
    public String getMessage() {
        return this.msg;
    }
}
