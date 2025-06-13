package application.model;

import java.util.Stack;

/**
 * The ArithmeticCalculator class provides a method to evaluate
 * arithmetic expressions given as strings.
 **/
public class ArithmeticCalculator {

    public static double evaluate(String expression) {
        if (expression == null || expression.trim().isEmpty()) {
            throw new IllegalArgumentException("Expression cannot be empty");
        }

        expression = expression.replaceAll("\\s+", "");
        validate(expression);

        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c) || c == '.' || (c == '-' && (i == 0 || isOperator(expression.charAt(i-1)) || expression.charAt(i-1) == '('))) {
                i = processNumber(expression, i, numbers) - 1;
            }
            else if (c == '(') {
                operators.push(c);
            }
            else if (c == ')') {
                evaluateUntilLeftParenthesis(numbers, operators);
            }
            else if (isOperator(c)) {
                handleOperator(c, numbers, operators);
            }
            else {
                throw new IllegalArgumentException("Invalid character: " + c);
            }
        }

        evaluateRemainingOperators(numbers, operators);

        if (numbers.size() != 1) {
            throw new IllegalArgumentException("Invalid expression structure");
        }

        return numbers.pop();
    }

    private static void validate(String expression) {
        int parenthesesBalance = 0;
        for (char c : expression.toCharArray()) {
            if (c == '(') parenthesesBalance++;
            else if (c == ')') parenthesesBalance--;

            if (parenthesesBalance < 0) {
                throw new IllegalArgumentException("Mismatched parentheses");
            }
        }

        if (parenthesesBalance != 0) {
            throw new IllegalArgumentException("Mismatched parentheses");
        }
    }

    private static int processNumber(String expr, int index, Stack<Double> numbers) {
        StringBuilder numStr = new StringBuilder();
        boolean isNegative = false;

        if (expr.charAt(index) == '-') {
            isNegative = true;
            index++;
        }

        while (index < expr.length() &&
                (Character.isDigit(expr.charAt(index)) || expr.charAt(index) == '.')) {
            numStr.append(expr.charAt(index++));
        }

        try {
            double number = Double.parseDouble(numStr.toString());
            numbers.push(isNegative ? -number : number);
            return index;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number format: " + numStr);
        }
    }

    private static void evaluateUntilLeftParenthesis(Stack<Double> numbers,
                                                     Stack<Character> operators) {
        while (!operators.isEmpty() && operators.peek() != '(') {
            evaluateTopOperation(numbers, operators);
        }

        if (operators.isEmpty()) {
            throw new IllegalArgumentException("Mismatched parentheses");
        }

        operators.pop();
    }

    private static void handleOperator(char currentOp,
                                       Stack<Double> numbers, Stack<Character> operators) {
        while (!operators.isEmpty() &&
                operators.peek() != '(' &&
                hasPrecedence(operators.peek(), currentOp)) {
            evaluateTopOperation(numbers, operators);
        }

        operators.push(currentOp);
    }

    private static void evaluateRemainingOperators(Stack<Double> numbers,
                                                   Stack<Character> operators) {
        while (!operators.isEmpty()) {
            if (operators.peek() == '(') {
                throw new IllegalArgumentException("Mismatched parentheses");
            }
            evaluateTopOperation(numbers, operators);
        }
    }

    private static void evaluateTopOperation(Stack<Double> numbers,
                                             Stack<Character> operators) {
        if (numbers.size() < 2) {
            throw new IllegalArgumentException("Invalid expression");
        }

        double b = numbers.pop();
        double a = numbers.pop();
        char op = operators.pop();
        numbers.push(applyOperation(op, a, b));
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private static boolean hasPrecedence(char op1, char op2) {
        if (op1 == '*' || op1 == '/') {
            return op2 == '+' || op2 == '-';
        }
        return false;
    }

    private static double applyOperation(char op, double a, double b) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return a / b;
            default:
                throw new IllegalArgumentException("Unknown operator: " + op);
        }
    }
}