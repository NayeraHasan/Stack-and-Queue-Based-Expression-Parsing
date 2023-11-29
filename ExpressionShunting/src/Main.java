import java.util.*;

public class Main {

    /**
     This is the main method that takes in a command line argument containing an infix mathematical expression,
     converts it to postfix notation using the shuntingYard method, evaluates the postfix expression using the postFix method,
     and outputs the result to the console.
     @param args an array of strings containing command line arguments
     */
    public static void main(String[] args) { // Check if there is at least one argument, otherwise output error message.
        if (args.length == 0) {
            System.out.println("Please provide an infix expression as a command line argument.");
            return;
        } // Get the infix expression from the first argument, split into an array of strings, and convert to postfix
        StringBuilder infix = new StringBuilder("");
        for(int i = 0; i < args.length; i++) {
            infix.append(args[i] + " ");
        }
        System.out.println(infix);
        LinkedQueue<String> postfix = shuntingYard(infix.toString().split(" "));
        LinkedQueue<String> postfix2= new LinkedQueue<>() ;
        while (!postfix.isEmpty()) {
            String newpostfixes = postfix.dequeue();
            postfix2.enqueue(newpostfixes);

       }
        // Evaluate the postfix expression and store the result in a double variable
        double result = postFix(postfix2);
        System.out.println(result);
    }

    /**
     This method takes in an array of strings representing an infix mathematical expression and converts it to postfix notation using the shunting yard algorithm.
     @param stringArray an array of strings representing the infix expression

     @return a LinkedQueue of strings representing the postfix expression

     @throws IllegalArgumentException if an invalid token is encountered or if there are mismatched parentheses
     */
    public static LinkedQueue<String> shuntingYard(String[] stringArray) {
        // Initialize an operator stack and an output queue
        Stack<String> operatorStack = new LinkedStack<>();
        LinkedQueue<String> outputQueue = new LinkedQueue<>(); // Iterate through each token in the string array
        // Iterate through each token in the string array
        for (String token : stringArray) {
            // If the token is a number, enqueue it in the output queue
            if (isNumeric(token)) {
                outputQueue.enqueue(token);
            }
            // If the token is an operator, pop operators from the stack to the output queue until the stack is empty or the top operator has lower precedence
            else if (isOperator(token)) {
                while (!operatorStack.isEmpty()&& isOperator(operatorStack.peek())
                        && (precedence(token) <= precedence(operatorStack.peek()))) {
                    outputQueue.enqueue(operatorStack.pop());
                }
                // Push the new operator onto the stack
                operatorStack.push(token);
            } else if (isParenthesis(token)) { // If the token is a parenthesis, handle it accordingly
                if (token.equals("(")) { // If the token is an opening parenthesis, push it onto the stack
                    operatorStack.push(token);
                } else { // If the token is a closing parenthesis, pop operators from the stack to the output queue until an opening parenthesis is encountered
                    while (!operatorStack.isEmpty()&& !operatorStack.peek().equals("(")) {
                        outputQueue.enqueue(operatorStack.pop());
                    }
                    if (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                        throw new IllegalArgumentException("Mismatched parentheses"); // If there are no opening parentheses, throw an exception
                    }
                    operatorStack.pop(); // Pop the opening parenthesis from the stack

                }
            } else {
                throw new IllegalArgumentException("Invalid token: " + token); // If the token is not a number, operator, or parenthesis, throw an exception

            }
        }
        while (!operatorStack.isEmpty()) {
            if (isParenthesis(operatorStack.peek())) { // If there are any remaining parentheses on the stack, throw an exception
                throw new IllegalArgumentException("Mismatched parentheses");
            }
            outputQueue.enqueue(operatorStack.pop());
        }

        return outputQueue;
    }
    /**
     Determines if the given token is a parenthesis.
     @param token the token to be checked
     @return true if the token is a parenthesis, false otherwise
     */
    private static boolean isParenthesis(String token) { // Check if the token is an opening or closing parenthesis
        return token.equals("(") || token.equals(")");
    }

    private static int precedence(String operator) {
        switch (operator) {
            case "+":
                return 0;
            case "-":
                return 0;
            case "*":
                return 5;
            case "/":
                return 5;
            case "^":
                return 10;
            default:
                throw new IllegalArgumentException("Invalid operator: ");
        }
    }

    /**

     Evaluates a postfix expression represented as a queue of tokens.

     @param stringQueue the queue of tokens representing the postfix expression

     @return the result of evaluating the postfix expression

     @throws IllegalArgumentException if the postfix expression is invalid
     */
    public static double postFix(LinkedQueue<String> stringQueue) {
        Stack<Double> stack = new LinkedStack<>();

        while (!stringQueue.isEmpty()) {
            String token = stringQueue.dequeue();

            if (isNumeric(token)) {
                stack.push(Double.parseDouble(token));
            } else if (isOperator(token)) {
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(operand1 + operand2);
                        break;
                    case "-":
                        stack.push(operand1 - operand2);
                        break;
                    case "*":
                        stack.push(operand1 * operand2);
                        break;
                    case "/":
                        stack.push(operand1 / operand2);
                        break;
                    case "^":
                        stack.push(Math.pow(operand1, operand2));
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: ");
                }
            }
        }

          if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid postfix expression");
       }

        return stack.pop();
    }

    /**
     * Checks if a string represents a numeric value.
     *
     * @param strNum a string to be checked
     * @return true if the string represents a numeric value, false otherwise
     */
    public static boolean isNumeric(String strNum) {
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }
    /**
     * Checks if the given string is a valid operator (+, -, *, /, or ^).
     * @param strOp the string to check
     * @return true if the string is a valid operator, false otherwise
     */
    public static boolean isOperator(String strOp) {
        // Use a regular expression to check if the string matches one of the valid operators
        return strOp.matches("[+\\-*/^]");
    }
}