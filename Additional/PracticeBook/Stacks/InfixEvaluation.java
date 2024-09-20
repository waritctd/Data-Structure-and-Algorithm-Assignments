import java.util.Stack;

public class InfixEvaluation {

    // Method to perform an operation and return the result
    public int applyOperator(char operator, int operand1, int operand2) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) throw new UnsupportedOperationException("Cannot divide by zero");
                return operand1 / operand2;
        }
        return 0;
    }

    // Method to return precedence of an operator
    public int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;  // Lowest precedence
            case '*':
            case '/':
                return 2;  // Higher precedence
        }
        return -1;
    }

    // Method to evaluate the infix expression
    public int evaluate(String expression) throws Exception {
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            // If the character is a digit, form the full number (in case of multi-digit numbers)
            if (Character.isDigit(ch)) {
                int num = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    num = num * 10 + (expression.charAt(i) - '0');
                    i++;
                }
                i--;  // Step back after forming the full number
                operands.push(num);
            }
            // If opening parenthesis, push it onto the operator stack
            else if (ch == '(') {
                operators.push(ch);
            }
            // If closing parenthesis, solve entire bracket
            else if (ch == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    int operand2 = operands.pop();
                    int operand1 = operands.pop();
                    char operator = operators.pop();
                    operands.push(applyOperator(operator, operand1, operand2));
                }
                operators.pop();  // Pop '('
            }
            // If the character is an operator
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                // While the operator on the top of the stack has higher precedence, apply it
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(ch)) {
                    int operand2 = operands.pop();
                    int operand1 = operands.pop();
                    char operator = operators.pop();
                    operands.push(applyOperator(operator, operand1, operand2));
                }
                operators.push(ch);
            }
        }

        // After the loop, apply remaining operators
        while (!operators.isEmpty()) {
            int operand2 = operands.pop();
            int operand1 = operands.pop();
            char operator = operators.pop();
            operands.push(applyOperator(operator, operand1, operand2));
        }

        // The final result will be the only value in the operand stack
        return operands.pop();
    }

    public static void main(String[] args) throws Exception {
        InfixEvaluation evaluator = new InfixEvaluation();
        String expression = "3+(6*5)-(8/2)";

        int result = evaluator.evaluate(expression);
        System.out.println("The result of the expression is: " + result);
    }
}
