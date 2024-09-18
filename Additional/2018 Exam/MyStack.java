import java.util.Stack;

public class MyStack {
    public boolean isEmpty() {
        return false;
    }
    //Return data on top of stack.
    //Throw exception if the stack is empty.
    public int top() throws Exception {
        return 0;
    }
    //Remove data on top of stack.
    //Throw exception if the stack is empty.
    public void pop() throws Exception {
    }
    //Add new data on top of stack.
    //Throw exception if the operation is somehow
    //unsuccessful.
    public void push(int data) throws Exception {
    }

    public void swap (MyStack s1, MyStack s2, int p1, int p2) {

        MyStack temp1 = new MyStack();
        MyStack temp2 = new MyStack();

        for (int i = 0; i < p1; i++) {
            temp1.push(s1.top());
            s1.pop();
        }

        for (int j = 0; j < p2; j++) {
            temp2.push(s2.top());
            s2.pop();
        }

        s1.push(s2.top());
        s2.push(s1.top());
        s1.pop();
        s2.pop();
        
        while (!temp1.isEmpty()) {
            s1.push(temp1.top());
            temp1.pop();
        }
        while (!temp2.isEmpty()) {
            s2.push(temp2.top());
            temp2.pop();
        }
    }
}