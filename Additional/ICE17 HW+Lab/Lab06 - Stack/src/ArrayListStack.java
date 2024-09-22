import java.util.ArrayList;

public class ArrayListStack implements Stack {
	private ArrayList<Integer> a;
	private int currentSize;
	
	private static final int DEFAULT_SIZE = 10;
	// implement a default constructor and all methods from interface Stack.
	// Additional methods maybe required in order to run tests.
	public ArrayListStack() {
		this(DEFAULT_SIZE);
	}
	
	public ArrayListStack(int intendedCapacity) {
		a = new ArrayList<Integer>(intendedCapacity);
		currentSize = 0;
	}

	public ArrayList<Integer> getA() {
		return a;
	}
	
	//check if stack is empty
	public boolean isEmpty() {
		return (currentSize == 0);
	}

	// Check if the stack is full
	public boolean isFull() {
		if (currentSize == 0 || a.size() == 0) {
			return false;
		}
	    return (currentSize >= a.size());
	    
	}


	// Set the stack to be an empty stack
	public void makeEmpty() {
	    a.clear(); // Clear all elements from the underlying list
	    currentSize = 0; // Reset currentSize to 0
	}


	//return value on top of stack. If the stack is empty, throw exception.
	public int top() throws Exception {
		if (a.isEmpty()) {
			throw new Exception();
		}
		
		return a.get(a.size() - 1);
	}

	//remove value on top of stack. If the stack is empty, throw exception.
	public void pop() throws Exception {
		if (a.isEmpty()) {
			throw new Exception();
		}
		
		a.remove(a.size() -1);
		currentSize--;
	};

	public void doubleCapacity() { 
	    ArrayList<Integer> temp = new ArrayList<>(a.size() * 2); // Create a new ArrayList with double the capacity
	    temp.addAll(a); // Copy all elements from the original list to the new list
	    a = temp; // Assign the new list back to 'a'
	}

	
	//push data on top of stack.
	public void push(int data) throws Exception {
		if(isFull())
			doubleCapacity();
		a.add(currentSize, data);
		currentSize++;
	}
	

}
