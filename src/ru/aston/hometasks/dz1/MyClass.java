package ru.aston.hometasks.dz1;

import java.util.List;

public class MyClass {
    private List<String> words;
    private int integer;

    public MyClass(List<String> words, int integer) {
        this.words = words;
        this.integer = integer;
    }

    public List<String> getWords() {
        return words;
    }

    public int getInteger() {
        return integer;
    }

    void setWords(List<String> words) {
        this.words = words;
    }

    void setInteger(int integer) {
        this.integer = integer;
    }
}