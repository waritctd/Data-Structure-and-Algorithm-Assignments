//Stack (the code inside methods are not given, but you are allowed to call the methods):
public class Stack {
    public Stack(){} // a constructor that initializes the stack.

    public boolean isEmpty() {
        return false;
    } //true if the stack has no data, false otherwise.
    public void makeEmpty(){} // remove all data from the stack.
    //Return data on top of stack.
    //Throw exception if the stack is empty.
    public int top() throws Exception{
        return 0;
    }
    //Remove data on top of stack.
    //Throw exception if the stack is empty.
    public void pop() throws Exception{}
    //Add new data on top of stack.
    //Throw exception if the operation is somehow
//unsuccessful.
    public void push(int data) throws Exception{}
    }

    public void insertFromBottom(int p, int value) throws Exception {
        Stack tempStack1 = new Stack();
    
        // Pop the first p elements and push them onto the tempStack1
        for (int i = 0; i < p; i++) {
            if (isEmpty()) {
                throw new Exception("Position is out of bounds");
            }
            tempStack1.push(top());
            pop();
        }
    
        // Push the new value onto the original stack
        push(value);
    
        // Restore the elements from tempStack1 to the original stack
        while (!tempStack1.isEmpty()) {
            push(tempStack1.top());
            tempStack1.pop();
        }
    }
    
    