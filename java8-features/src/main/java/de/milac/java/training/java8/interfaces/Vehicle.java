package de.milac.java.training.java8.interfaces;

public interface Vehicle {
    static String sayHelloStatic() {
        return "hello from " + Vehicle.class.getName();
    }

    default String sayHelloDefault() {
        return "hello from " + this.getClass().getName();
    }

}
