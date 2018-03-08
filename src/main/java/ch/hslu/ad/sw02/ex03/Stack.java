package ch.hslu.ad.sw02.ex03;

import java.util.NoSuchElementException;

public class Stack implements Stackable {
    private String[] items;
    private int size;
    private int top;

    public Stack(int size) {
        this.items = new String[size];
        this.size = size;
        this.top = 0;

    }

    @Override
    public boolean empty() {
        return top == 0;
    }

    @Override
    public String peek() {
        if (top != 0) {
            return items[top - 1];
        } else {
            throw new ArrayStoreException("Stack is empty!");
        }
    }

    @Override
    public String pop() {
        if (top == 0) {
            throw new ArrayStoreException("Stack is empty!");
        }
        String item = items[top - 1];
        top--;
        return item;
    }

    @Override
    public String push(String str) {
        if (this.top < this.size) {
            if (str instanceof String) {
                this.items[top] = str;
                this.top++;
                return str;
            } else {
                throw new IllegalArgumentException("Provided Object is not a String");
            }
        } else {
            throw new ArrayIndexOutOfBoundsException("There is no more place on the stack!");
        }
    }

    @Override
    public int search(String str) {
        int i = 0;
        for (String string : items) {
            if (string.equals(str)) {
                return i;
            }
            i++;
        }
        throw new NoSuchElementException();
    }
}
