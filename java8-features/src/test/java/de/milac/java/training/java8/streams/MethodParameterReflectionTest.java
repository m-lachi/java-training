package de.milac.java.training.java8.streams;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class MethodParameterReflectionTest {
	@Test
	void reflectMethodParameters() {
		// ensure that compile argument "-parameter" has been set
		// otherwise the parameter names would be ["arg0", "arg1"]
		assertThat(Arrays.stream(MethodParameterReflection.class.getMethods()[0].getParameters())
			.map(Parameter::getName).collect(Collectors.toList())).containsOnly("firstName", "lastName");
	}

	@Test
	void computeName() {
		MethodParameterReflection mpr = new MethodParameterReflection();
		assertThat(mpr.computeName("Hans", "Mueller")).isEqualTo("Hans Mueller");
	}
}