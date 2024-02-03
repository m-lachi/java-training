package de.milac.java.training.java8.streams;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
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

		assertThat(createStream().collect(
			Collectors.partitioningBy(s -> s.length() > 1)).toString()).isEqualTo("{false=[a, b, c, b, a], true=[aa, bb, cc]}");

		assertThat(createStream().collect(
			Collectors.summarizingInt(String::length)).toString()).isEqualTo("IntSummaryStatistics{count=8, sum=11, min=1, average=1,375000, max=2}");
	}

	@Test
	void filter() {
		assertThat(createStream().filter(s -> s.contains("c")).collect(Collectors.toList())).containsOnly("c", "cc");
	}

	@Test
	void pipeline() {
		// source
        List<Integer> lengths = createStream()
        // intermediate operation(s)
            .skip(1)
            .map(String::length)
            .sorted(Comparator.reverseOrder())
        // terminal operation
            .collect(Collectors.toList());
        assertThat(lengths.toString()).isEqualTo("[2, 2, 2, 1, 1, 1, 1]");
    }

	@Test
	void reduce() {
		Optional<String> reduced1 = createStream().reduce(String::concat);
		assertThat(reduced1).isPresent().contains("aaabbbcccba");

		String reduced2 = createStream().parallel().reduce("=", String::concat);
		assertThat(reduced2).isEqualTo("=a=aa=b=bb=c=cc=b=a");

		final AtomicBoolean wasCalled = new AtomicBoolean(false);
		String reduced3 = createStream().reduce("=", String::concat, (s1, s2) -> {
			wasCalled.set(true); // combiner won't be called in a non-parallel execution
			return s1.concat(s2);
		});
		assertThat(reduced3).isEqualTo("=aaabbbcccba");
		assertThat(wasCalled.get()).isFalse();

		wasCalled.set(false);
		String reduced4 = createStream().parallel().reduce("=", String::concat, (s1, s2) -> {
			wasCalled.set(true); // combiner will be called in a parallel execution
			return s1.concat(s2);
		});
		assertThat(reduced4).isEqualTo("=a=aa=b=bb=c=cc=b=a");
		assertThat(wasCalled.get()).isTrue();
	}
}

