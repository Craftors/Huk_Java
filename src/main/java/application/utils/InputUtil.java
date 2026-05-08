package application.utils;

import java.util.Scanner;

public class InputUtil {
    private final Scanner scanner;

    public InputUtil(Scanner scanner){
        this.scanner = scanner;
    }

    public <T> T readWithRetry(Parser<T> parser) {
        while (true) {
            try {
                String input = scanner.nextLine().trim();

                if (input.isBlank()) {
                    continue;
                }

                return parser.parse(input);
            } catch (Exception ex) {
                System.out.println("======================");
                System.out.println("Invalid input");
                System.out.println(ex);
                System.out.println("Please try again");
                System.out.println("======================");
            }
        }
    }

    public interface Parser<T> {
        T parse(String input) throws Exception;
    }
}
