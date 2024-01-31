package de.milac.java.training.java8.streams;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static de.milac.java.training.java8.streams.StreamClass.createStream;
import static org.assertj.core.api.Assertions.assertThat;

class StreamClassTest {

    @Test
    void matches() {
        assertThat(createStream().anyMatch(s -> s.equals("a"))).isTrue();
        assertThat(createStream().allMatch(s -> s.equals("a"))).isFalse();
        assertThat(createStream().noneMatch(s -> s.equals("a"))).isFalse();
    }


    @Test
    void count() {
        assertThat(createStream().count()).isEqualTo(8);
        assertThat(createStream().distinct().count()).isEqualTo(6);
    }

    @Test
    void collect() {
        assertThat(createStream().collect(Collectors.joining())).isEqualTo("aaabbbcccba");
        assertThat(createStream().collect(Collectors.joining("."))).isEqualTo("a.aa.b.bb.c.cc.b.a");
        assertThat(createStream().collect(Collectors.joining(".", "<", ">"))).isEqualTo("<a.aa.b.bb.c.cc.b.a>");
        assertThat(createStream().collect(Collectors.toList())).contains("a", "b", "c");

        assertThat((String) createStream().collect(
                Collectors.collectingAndThen(Collectors.joining("-"), String::toUpperCase))).isEqualTo("A-AA-B-BB-C-CC-B-A");

        assertThat(createStream().collect(
                Collectors.groupingBy(String::length)).toString()).isEqualTo("{1=[a, b, c, b, a], 2=[aa, bb, cc]}");
    }

    @Test
    void filter() {
        assertThat(createStream().filter(s -> s.contains("c")).collect(Collectors.toList())).containsOnly("c", "cc");
    }

    @Test
    void sourceIntermediateTerminal() {
        // source

        // intermediate operation

        // terminal operation

    }
}

