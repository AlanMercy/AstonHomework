package ru.aston.hometasks.dz1;

import java.util.List;

public final class MyImmutableClass {
    private final String string;
    private final List<Integer> numbers;
    private final MyClass example;

    public MyImmutableClass(String string, List<Integer> numbers, MyClass example) {
        this.string = string;
        this.numbers = numbers == null ? List.of() : List.copyOf(numbers);
        this.example = copyMyClass(example);
    }

    public String getString() {
        return string;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public MyClass getExample() {
        return copyMyClass(example);
    }

    private MyClass copyMyClass(MyClass original) {
        if (original == null) {
            return null;
        }
        List<String> words = original.getWords();
        List<String> wordsCopy = words == null ? null : List.copyOf(words);
        return new MyClass(wordsCopy, original.getInteger());
    }
}