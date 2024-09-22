public class PriorityQueue {
    MyQueue q;

    public PriorityQueue(MyQueue q) {
		super();
        this.q = q;
    }

    // Insert element x into the priority queue
    public void push(int x) throws Exception {
        // If the queue is empty, just insert x
        if (q.isEmpty()) {
            q.insertLast(x);
            return;
        }

        int size = q.size();
        boolean inserted = false; // Track if x has been inserted

        // Iterate through existing elements in the queue
        for (int i = 0; i < size; i++) {
            int front = q.removeFirst(); // Get the front element

            // If x has a higher priority (smaller value), insert it now
            if (!inserted && x <= front) {
                q.insertLast(x);
                inserted = true; // Mark that we've inserted x
            }

            // Reinsert the front element back to the queue
            q.insertLast(front);
        }

        // If x was never inserted, add it to the end of the queue
        if (!inserted) {
            q.insertLast(x);
        }
    }

    // Remove the highest priority element
    public void pop() throws Exception {
        q.removeFirst();
    }

    // Get the highest priority element
    public int top() throws Exception {
        return q.front();
    }
}
