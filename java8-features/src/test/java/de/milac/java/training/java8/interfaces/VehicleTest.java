package de.milac.java.training.java8.interfaces;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class VehicleTest {
    @Test
    void callInterfaceStaticMethod() {
        assertThat(Vehicle.sayHelloStatic()).isEqualTo("hello from de.milac.java.training.java8.interfaces.Vehicle");
    }
    @Test
    void callInterfaceDefaultMethod() {
        assertThat(new Car().sayHelloDefault()).isEqualTo("hello from de.milac.java.training.java8.interfaces.Car");
    }
}