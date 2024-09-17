public class MyStack {
    Queue q;

    public MyStack() {
        q = new Queue(); // Initialize the queue
    }

    // Push an element onto the stack
    public void push(int x) throws Exception {
        q.insertFirst(x); // Insert at the front of the queue (like adding to the top of the stack)
    }

    // Remove and return the top element (pop operation)
    public int pop() throws Exception {
        if (q.isEmpty()) {
            throw new Exception("Stack is empty");
        }
        return q.removeFirst(); // Remove from the front of the queue (top of the stack)
    }

    // Return the top element without removing it (top operation)
    public int top() throws Exception {
        if (q.isEmpty()) {
            throw new Exception("Stack is empty");
        }
        return q.front(); // Return the front of the queue (top of the stack)
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return q.isEmpty();
    }

    // Return the size of the stack
    public int size() {
        return q.size();
    }
}
