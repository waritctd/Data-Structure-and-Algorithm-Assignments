public class TestQueue {
    public Queue combine(Queue q1, Queue q2) throws Exception {
        Queue q3 = new Queue();

        // While both queues have elements
        while (!q1.isEmpty() && !q2.isEmpty()) {
            // Compare the front elements of both queues
            if (q1.front() <= q2.front()) {
                q3.insertLast(q1.removeFirst()); // Insert the smaller element from q1
            } else {
                q3.insertLast(q2.removeFirst()); // Insert the smaller element from q2
            }
        }

        // If q1 still has elements, add them all to q3
        while (!q1.isEmpty()) {
            q3.insertLast(q1.removeFirst());
        }

        // If q2 still has elements, add them all to q3
        while (!q2.isEmpty()) {
            q3.insertLast(q2.removeFirst());
        }

        return q3; // Return the merged and sorted queue
    }
}
