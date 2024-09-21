
import java.util.Stack;

public class QueuePractice extends DeQLinkedList {
    
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public void insertLastWithStack(int value) throws Exception {
        stack1.push(value);
    }

    public int removeFirstWithStack() throws Exception {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        if (stack2.isEmpty()) {
            throw new Exception();
        }

        return stack2.pop();
    }

    public void removeOddIndex() throws Exception {

        Stack<Integer> tempStack = new Stack<>();
        int index = 0;

        while (!isEmpty()) {
            if (index % 2 == 0) {
                tempStack.push(removeFirst());
            } else {
                removeFirst();
            }
            index++;
        }

        while (!tempStack.isEmpty()) {
            insertFirst(tempStack.pop());
        }

    }

    public void moveBackToFront() throws Exception {
        
        insertFirst(removeLast());

    }

    public void reverseQueue() throws Exception {

        Stack<Integer> tempStack = new Stack<>();

        while (!isEmpty()) {
            tempStack.push(removeFirst());
        }

        while (!tempStack.isEmpty()) {
            insertLast(tempStack.pop());
        }
    }

    public MyQueue merge(MyQueue q1, MyQueue q2) throws Exception {

        QueueLinkedList mergedQueue = new QueueLinkedList();
    
        // Step 1: Merge elements from both queues while both are non-empty
        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.front() <= q2.front()) {
                mergedQueue.insertLast(q1.removeFirst());  // Add the smaller element from q1
            } else {
                mergedQueue.insertLast(q2.removeFirst());  // Add the smaller element from q2
            }
        }
    
        // Step 2: If q1 has remaining elements, append them
        while (!q1.isEmpty()) {
            mergedQueue.insertLast(q1.removeFirst());
        }
    
        // Step 3: If q2 has remaining elements, append them
        while (!q2.isEmpty()) {
            mergedQueue.insertLast(q2.removeFirst());
        }
    
        return mergedQueue;
    }

    public void sortQueue() throws Exception {
        Stack<Integer> tempStack = new Stack<>();

        while (!isEmpty()) {
            tempStack.push(removeFirst());
        }

        Stack<Integer> tempStack2 = new Stack<>();
        while (!tempStack.isEmpty()) {
            int current = tempStack.pop();

            while (!tempStack2.isEmpty() && tempStack.peek() > current) {
                tempStack.push(tempStack2.pop());
            }

            tempStack2.push(current);
        }

        while (!tempStack2.isEmpty()) {
            insertLast(tempStack2.pop());
        }
    }

    public void jumpQueue(int x, int i) throws Exception {
        // Step 1: Rotate the first `i` elements to the back
        for (int j = 0; j < i; j++) {
            insertLast(removeFirst());
        }
    
        // Step 2: Insert the new element at the front
        insertFirst(x);
    
        // Step 3: Rotate the rest of the queue to maintain the correct order
        int toIterate = size() - i - 1;  // Adjust the number of rotations after insertion
    
        for (int k = 0; k < toIterate; k++) {
            insertLast(removeFirst());
        }
    }

    public void swap(int p1, int p2) throws Exception {

        // Ensure p1 is less than p2 for easier handling
        if (p1 > p2) {
            int temp = p1;
            p1 = p2;
            p2 = temp;
        }
    
        // Step 1: Rotate to the element at p1
        int size = size();
        int firstValue = 0;
        int secondValue = 0;
    
        for (int i = 0; i < size; i++) {
            int current = removeFirst();
    
            if (i == p1) {
                firstValue = current;  // Save the value at p1
            } else if (i == p2) {
                secondValue = current;  // Save the value at p2
            }
    
            // Push the current element back into the queue, except for the positions p1 and p2
            if (i != p1 && i != p2) {
                insertLast(current);
            }
        }
    
        // Step 2: Reinsert the values in the swapped positions
        for (int i = 0; i < size; i++) {
            int current = removeFirst();
    
            if (i == p1) {
                insertLast(secondValue);  // Insert the value that was at p2
            } else if (i == p2) {
                insertLast(firstValue);   // Insert the value that was at p1
            } else {
                insertLast(current);      // Insert the other values unchanged
            }
        }
    }
    

}

    