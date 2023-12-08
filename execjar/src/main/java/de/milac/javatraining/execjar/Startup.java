package de.milac.javatraining.execjar;

import java.util.Arrays;

public class Startup {

    public static void main(String[] args) {
        Startup startup = new Startup();
        System.out.println("Started executable jar " + startup.formatArguments(args));
    }

    public String formatArguments(String[] args) {
        return (args == null || args.length == 0 ? "without arguments" : "with arguments: " + Arrays.toString(args));
    }
}
