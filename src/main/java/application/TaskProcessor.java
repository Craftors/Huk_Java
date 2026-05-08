package application;

import application.utils.InputUtil;
import application.utils.SequenceAnalyzerUtil;

import java.util.Arrays;

public class TaskProcessor {
    public final InputUtil inputUtil;
    public TaskProcessor(InputUtil inputUtil){
        this.inputUtil = inputUtil;
    }

    public void isNumberGreaterThenTask(Integer threshold){
        System.out.println("Write number:");

        Double numberInput = inputUtil.readWithRetry(Double::parseDouble);

        if (numberInput.compareTo(Double.valueOf(threshold)) > 0){
            System.out.println("Hello");
        }
    }

    public void isNameEqualTask(String name){
        System.out.println("Write name: ");
        String nameInput = inputUtil.readWithRetry(input -> input);
        if (nameInput.equalsIgnoreCase(name)){
            System.out.println("Hello, " + name);
        } else {
            System.out.println("There is no such name");
        }
    }

    public void numericArrayPrintMultipliesTask(Integer multiply){
        System.out.println("Write numbers split by \" \":");

        double[] numsInputArray = inputUtil.readWithRetry(input -> {
            String[] parts = input.split(" ");
            double[] result = new double[parts.length];

            for (int i = 0; i < parts.length; i++) {
                result[i] = Double.parseDouble(parts[i]);
            }

            return result;
        });

        System.out.println("next elements are multipliers of 3");
        Arrays.stream(numsInputArray)
                .filter(num -> num % multiply == 0)
                .forEach(System.out::println);
    }

    public void bracketsTaskStaticSolution(){
        System.out.println("Given bracket sequence: " + "[((())()(())]]");
        System.out.println("Incorrect");
        System.out.println("To make it correct need to change \"]\" to \")\" at position 13");
    }

    public void bracketsTask(String sequence){
        System.out.println("Given bracket sequence: " + sequence);

        SequenceAnalyzerUtil.Result result = SequenceAnalyzerUtil.analyze("[((())()(())]]");

        if (result.isValid()) {
            System.out.println("Correct");
        } else {
            System.out.println("Incorrect");
            System.out.println(result.getMessage() + " at position " + result.getPosition());
        }
    }
}
