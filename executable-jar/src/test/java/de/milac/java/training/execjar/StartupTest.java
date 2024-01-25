package de.milac.java.training.execjar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StartupTest {
    private static final String OUT_WITHOUT_ARGS = "without arguments";
    private static final String OUT_WITH_ARGS = "with arguments: ";

    Startup startup;

    @BeforeEach
    void setUp() {
        startup = new Startup();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void formatArgumentsWithOneArg() {
        String arg = "Hello";
        String result = startup.formatArguments(new String[]{arg});
        assertEquals(OUT_WITH_ARGS + "[" + arg + "]", result);
    }

    @Test
    void formatArgumentsWithTwoArgs() {
        String arg1 = "Hello";
        String arg2 = "World!";
        String result = startup.formatArguments(new String[]{arg1, arg2});
        assertEquals(OUT_WITH_ARGS + "[" + arg1 + ", " + arg2 + "]", result);
    }

    @Test
    void formatArgumentsWithoutArgsEmptyArray() {
        String result = startup.formatArguments(new String[]{});
        assertEquals(OUT_WITHOUT_ARGS, result);
    }

    @Test
    void formatArgumentsWithoutArgsNull() {
        String result = startup.formatArguments(null);
        assertEquals(OUT_WITHOUT_ARGS, result);
    }
}