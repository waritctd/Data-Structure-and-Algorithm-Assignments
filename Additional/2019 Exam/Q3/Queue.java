public class Queue {//each method is assumed to perform in Θ(1)
    // a constructor which initializes the queue to an empty queue.
    public Queue(){}
    //Return the first data.
    //Throw Exception if the queue is empty.
    public int front() throws Exception{
        return 0;
    }
    //Return the last data.
    //Throw Exception if the queue is empty.
    public int back() throws Exception{
        return 0;
    }
    //Remove the first data (return its value too).
    //Throw Exception if the queue is empty.
    public int removeFirst() throws Exception{
        return 0;
    }
    //Remove the last data (return its value too).
    //Throw Exception if the queue is empty.
    public int removeLast() throws Exception{
        return 0;
    }
    //Insert new data before the first data.
    //Throw exception if the insert fails for some reason.
    public void insertFirst(int data) throws Exception{}
    //Insert new data after the last data.
    //Throw exception if the insert fails for some reason.
    public void insertLast(int data) throws Exception{}
    //Check if the queue is empty.
    public boolean isEmpty() {
        return false;
    }
        
    //Check if the queue has no more space to store new data.
    public boolean isFull() {
        return false;
    };
    //Return the number of data currently stored in the queue.
    public int size() {
        return 0;
    };
}