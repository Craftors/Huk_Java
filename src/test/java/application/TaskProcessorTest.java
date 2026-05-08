package application;

import application.utils.InputUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TaskProcessorTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @AfterEach
    void cleanup() {
        System.setOut(originalOut);
    }

    @Test
    void shouldPrintHelloWhenNumberGreaterThanSeven() {
        System.setOut(new PrintStream(output));

        Scanner scanner = new Scanner("10\n");
        TaskProcessor processor = new TaskProcessor(new InputUtil(scanner));
        processor.isNumberGreaterThenTask(7);

        assertTrue(output.toString().contains("Hello"));
    }

    @Test
    void shouldPrintHelloJohn() {
        System.setOut(new PrintStream(output));
        Scanner scanner = new Scanner("John\n");

        TaskProcessor processor = new TaskProcessor(new InputUtil(scanner));
        processor.isNameEqualTask("John");
        assertTrue(output.toString().contains("Hello, John"));
    }

    @Test
    void shouldPrintNoSuchName() {
        System.setOut(new PrintStream(output));

        Scanner scanner = new Scanner("Mike\n");
        TaskProcessor processor = new TaskProcessor(new InputUtil(scanner));
        processor.isNameEqualTask("John");

        assertTrue(output.toString().contains("There is no such name"));
    }

    @Test
    void shouldPrintOnlyMultiplesOfThree() {
        System.setOut(new PrintStream(output));

        Scanner scanner = new Scanner("1 3 4 6 9\n");
        TaskProcessor processor = new TaskProcessor(new InputUtil(scanner));

        processor.numericArrayPrintMultipliesTask(3);

        String result = output.toString();

        assertTrue(result.contains("3"));
        assertTrue(result.contains("6"));
        assertTrue(result.contains("9"));
    }
}