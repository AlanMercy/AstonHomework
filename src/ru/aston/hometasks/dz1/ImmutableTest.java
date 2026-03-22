package ru.aston.hometasks.dz1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ImmutableTest {

    @Test
    void whenExternalNumbersListIsModified_thenInternalNumbersRemainUnchanged() {
        List<Integer> originalNumbers = new ArrayList<>();
        originalNumbers.add(1);
        originalNumbers.add(2);
        originalNumbers.add(3);
        MyImmutableClass immutable = new MyImmutableClass("test", originalNumbers, null);
        List<Integer> numbersFromGetter = immutable.getNumbers();
        assertThrows(UnsupportedOperationException.class, () -> numbersFromGetter.add(4));
        originalNumbers.add(4);
        assertEquals(3, immutable.getNumbers().size());
    }

    @Test
    void whenExampleFieldsAreModifiedViaReturnedCopy_thenInternalExampleFieldsRemainUnchanged() {
        List<String> originalWords = new ArrayList<>();
        originalWords.add("hello");
        originalWords.add("world");
        MyClass originalExample = new MyClass(originalWords, 42);
        MyImmutableClass immutable = new MyImmutableClass("test", List.of(1, 2), originalExample);
        MyClass exampleFromGetter = immutable.getExample();
        List<String> newWords = new ArrayList<>();
        newWords.add("hacked");
        exampleFromGetter.setWords(newWords);
        exampleFromGetter.setInteger(100);
        MyClass internalExample = immutable.getExample();
        assertEquals(42, internalExample.getInteger());
        assertEquals(List.of("hello", "world"), internalExample.getWords());
    }

    @Test
    void whenWordsListFromReturnedExampleIsModified_thenUnsupportedOperationExceptionThrown() {
        List<String> originalWords = new ArrayList<>();
        originalWords.add("hello");
        originalWords.add("world");
        MyClass originalExample = new MyClass(originalWords, 42);
        MyImmutableClass immutable = new MyImmutableClass("test", List.of(1, 2), originalExample);
        MyClass exampleFromGetter = immutable.getExample();
        List<String> wordsFromGetter = exampleFromGetter.getWords();
        assertThrows(UnsupportedOperationException.class, () -> wordsFromGetter.add("hack"));
        originalWords.add("changed");
        assertEquals(2, immutable.getExample().getWords().size());
    }
}