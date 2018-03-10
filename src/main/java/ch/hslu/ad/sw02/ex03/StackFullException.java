package ch.hslu.ad.sw02.ex03;

public class StackFullException extends RuntimeException {


    public StackFullException(String message) {
        super(message);
    }

    public StackFullException() {

    }
}