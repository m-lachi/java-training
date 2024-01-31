package de.milac.java.training.java8.streams;

import java.util.stream.Stream;

public class StreamClass {
    public static Stream<String> createStream() {
        return Stream.of("a", "aa", "b", "bb", "c", "cc", "b", "a");
    }
}
