package application.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InputUtilTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @AfterEach
    void cleanup() {
        System.setOut(originalOut);
    }

    @Test
    void shouldReturnValidValueAfterInvalidInput() {
        System.setOut(new PrintStream(output));

        String inputData = "abc\n10\n";
        Scanner scanner = new Scanner(inputData);

        InputUtil inputUtil = new InputUtil(scanner);
        Integer result = inputUtil.readWithRetry(Integer::parseInt);

        assertEquals(10, result);
    }

    @Test
    void shouldPrintErrorMessageOnInvalidInput() {
        System.setOut(new PrintStream(output));

        String inputData = "abc\n10\n";
        Scanner scanner = new Scanner(inputData);

        InputUtil inputUtil = new InputUtil(scanner);
        inputUtil.readWithRetry(Integer::parseInt);

        assertTrue(output.toString().contains("Invalid input"));
    }
}