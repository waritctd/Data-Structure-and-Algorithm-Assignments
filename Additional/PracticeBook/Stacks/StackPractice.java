

public class StackPractice extends StackLinkedList{
    
    public void sortStack() throws Exception {

        StackLinkedList tempStack = new StackLinkedList();

        while (!isEmpty()) {
            int current = top();
            pop();

            while (!tempStack.isEmpty() && (tempStack.top() > current)) {
                push(tempStack.top());
                tempStack.pop();
            }

            tempStack.push(current);
        }
        while (!tempStack.isEmpty()) {
            push(tempStack.top());
            pop();
        }
    }

    public boolean checkContain(int val, StackLinkedList s1) throws Exception {
        StackLinkedList tempStack = new StackLinkedList();
    
        boolean found = false;
    
        // Traverse s1, looking for val, without modifying s1
        while (!s1.isEmpty()) {
            int topVal = s1.top();
            if (topVal == val) {
                found = true;
            }
            tempStack.push(topVal);
            s1.pop();
        }
    
        // Restore s1 to its original state
        while (!tempStack.isEmpty()) {
            s1.push(tempStack.top());
            tempStack.pop();
        }
    
        return found;
    }

    public void addNoDuplicate(StackLinkedList s2) throws Exception {

        StackLinkedList tempStack = new StackLinkedList();

        //duplicate checks
        while (!s2.isEmpty()) {
            int val = s2.top();
            if (!checkContain(val, this)) {
                tempStack.push(val);
            }
            s2.pop();
        }        

        //push back to this stack (maintaining order)
        while (!tempStack.isEmpty()) {
            push(tempStack.top());
            tempStack.pop();
        }
    }

    public void removeDup() throws MyStackException, Exception {

        StackLinkedList tempStack = new StackLinkedList();

        while (!isEmpty()) {
            if (!checkContain(top(), tempStack)) {
                tempStack.push(top());
            }
            pop();
        }

        while (!tempStack.isEmpty()) {
            push(tempStack.top());
            tempStack.pop();
        }
    }

    public void removeMin() throws Exception {

        int MIN = top();

        StackLinkedList tempStack = new StackLinkedList();

        while (!isEmpty()) {
            if (top() < MIN) {
                MIN = top();
            }
            tempStack.push(top());
            pop();
        }

        while (!tempStack.isEmpty()) {
            if (tempStack.top() != MIN) {
                push(tempStack.top());
            }
            tempStack.pop();
        }
    }


    public boolean checkPalindrome(int numbers) throws Exception {
        StackLinkedList tempStack = new StackLinkedList();
        String convertToString = Integer.toString(numbers);
        int length = convertToString.length();
    
        // Push all characters onto the stack
        for (int i = 0; i < length; i++) {
            tempStack.push(convertToString.charAt(i));
        }
    
        // Check for palindrome
        for (int i = 0; i < length; i++) {
            char topChar = (char) tempStack.top();
            char bottomChar = convertToString.charAt(i);
            
            // Compare the top of the stack with the corresponding character
            if (topChar != bottomChar) {
                return false;
            }
            tempStack.pop(); // Remove the top after comparison
        }
    
        return true;
    }
    
    public void putIn(int x) throws MyStackException, Exception {
       
        StackLinkedList tempStack = new StackLinkedList();

        while (!isEmpty() && top() > x) {
            tempStack.push(top());
            pop();
        }

        push(x);

        while (!tempStack.isEmpty()) {
            push(tempStack.top());
            tempStack.pop();
        }
    }

    //infix evaluation in a seperate class

    public int factorial(int n) throws Exception {
        if (n < 0) {
            throw new Exception();
        }
        if (n == 0 || n == 1) {
            return 1;  // Base case: 0! = 1! = 1
        }
        return n * factorial(n - 1);  // Recursive step: n * (n-1)!
    }

    public int power(int x, int y) throws Exception {
        if (y < 0) {
            throw new Exception();
        }
    
        StackLinkedList stack = new StackLinkedList();
    
        // Push the value 'x' onto the stack 'y' times
        for (int i = 0; i < y; i++) {
            stack.push(x);
        }
    
        int result = 1;
    
        // Pop from the stack and multiply
        while (!stack.isEmpty()) {
            result *= stack.top();  // Multiply the top value with the result
            stack.pop();            // Remove the top element
        }
    
        return result;
    }
    
}
