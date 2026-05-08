package application.utils;

import java.util.Stack;

public class SequenceAnalyzerUtil {

    public static Result analyze(String sequence) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < sequence.length(); i++) {

            char ch = sequence.charAt(i);

            if (isOpen(ch)) {
                stack.push(ch);
            }

            else if (isClosed(ch)) {

                if (stack.isEmpty()) {
                    return new Result(false, "Extra closing bracket '" + ch + "'", i + 1);
                }

                char open = stack.pop();

                if (!isPair(open, ch)) {
                    return new Result(false, "Mismatched bracket '" + ch + "'", i + 1);
                }
            }
        }

        if (!stack.isEmpty()) {
            return new Result(false, "Missing closing bracket(s)", sequence.length());
        }

        return new Result(true, "Correct", -1);
    }

    private static boolean isOpen(char c) {
        return c == '(' || c == '[';
    }

    private static boolean isClosed(char c) {
        return c == ')' || c == ']';
    }

    private static boolean isPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '[' && close == ']');
    }

    public static class Result {
        private final boolean isValid;
        private final String message;
        private final int position;

        public Result(boolean isValid, String message, int position) {
            this.isValid = isValid;
            this.message = message;
            this.position = position;
        }


        public boolean isValid() {
            return isValid;
        }

        public String getMessage() {
            return message;
        }

        public int getPosition() {
            return position;
        }
    }
}