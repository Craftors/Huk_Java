package application;

import application.utils.InputUtil;

import java.util.Scanner;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            System.out.println("Task 1");
            System.out.println("*******************");
            TaskProcessor taskProcessor = new TaskProcessor(new InputUtil(scanner));
            taskProcessor.isNumberGreaterThenTask(7);
            System.out.println("------");
            taskProcessor.isNameEqualTask("John");
            System.out.println("------");
            taskProcessor.numericArrayPrintMultipliesTask(3);
            System.out.println();
            System.out.println("*******************");
            System.out.println("Task 2");

            System.out.println("*******************");
            System.out.println("Static solution (just answering the question as asked as it was not asked to build any algorithm)");
            taskProcessor.bracketsTaskStaticSolution();
            System.out.println("------");

            System.out.println("Dynamic solution");
            taskProcessor.bracketsTask("[((())()(())]]");
        } finally {
            scanner.close();
        }
    }
}