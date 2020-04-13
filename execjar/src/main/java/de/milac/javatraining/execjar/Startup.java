package de.milac.javatraining.execjar;

import java.util.Arrays;

public class Startup {

    public static void main(String[] args) {
        System.out.println("Started executable jar"
                + (args.length == 0 ? " without arguments" : " with arguments: " + Arrays.toString(args)));
    }

}
