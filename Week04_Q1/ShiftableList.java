import java.util.ArrayList;

public class ShiftableList extends CDLinkedList {

	public ShiftableList() throws Exception {
		this("");
	}

	public ShiftableList(String s) throws Exception {
		// initialize the list
		// each data comes from each character in s
		int n = s.length();
		DListIterator d = new DListIterator(header);
		for (int i = n - 1; i >= 0; i--) {
			insert(s.charAt(i), d);
		}

	}

	//change the nth data (counting from header) to be a new first 
	//data of the list 
	public void shift(int n) throws Exception {
		
	    if (header == null || header.nextNode == header) {
	        // List is empty or has only one node; no need to shift
	        return;
	    }

	    DListIterator iterator = new DListIterator(header);
	    DListIterator endNode = new DListIterator(iterator.currentNode);


	    findNthNode(iterator, n);
	
	    DListNode start = iterator.currentNode;
	    DListNode end = endNode.currentNode.previousNode;
	    
	    DListNode nextNode = end.nextNode;
	    DListNode prevNode = start.previousNode;
	
	    if (prevNode != null) {
	        prevNode.nextNode = nextNode;
	    }
	    if (nextNode != null) {
	        nextNode.previousNode = prevNode;
	    }
	    
	    end.nextNode = header.nextNode;
	    start.previousNode = header;
	    
	    header.nextNode.previousNode = end;
	    header.nextNode = start;
	    }
	

	// shift the list such that the data at position newStart becomes the first data
	// for list a,b,c,d,e,f
	// if newStart is pointing at c, 
	// the new list will be c,d,e,f,a,b

	public void shift(DListNode newStart) throws Exception {
	    if (newStart == null || newStart == header) {
	        throw new IllegalArgumentException("Invalid newStart node");
	    }

	    DListIterator iterator = new DListIterator(header);
	    DListIterator endNode = new DListIterator(iterator.currentNode);


	    shiftToRecursive(iterator, newStart);

	
	    DListNode start = iterator.currentNode;
	    DListNode end = endNode.currentNode.previousNode;
	    
	    if (end == null) {
	        throw new IllegalStateException("The new start node is not part of the list");
	    }

	    DListNode nextNode = end.nextNode;
	    DListNode prevNode = start.previousNode;
	
	    if (prevNode != null) {
	        prevNode.nextNode = nextNode;
	    }
	    if (nextNode != null) {
	        nextNode.previousNode = prevNode;
	    }
	    
	    end.nextNode = header.nextNode;
	    start.previousNode = header;
	    
	    header.nextNode.previousNode = end;
	    header.nextNode = start;
	}
	
	
	private void shiftToRecursive(DListIterator currentNode, DListNode newStart) throws Exception {
	    if (currentNode.currentNode == newStart) {
	        return;
	    } else {
	        
	        currentNode.next();
	        shiftToRecursive(currentNode, newStart);
	    }
	}

	
	private void findEnd(DListIterator currentNode) throws Exception {
	     if (currentNode.currentNode.nextNode == header) {
	         return;
	     } else {
	         currentNode.next();
	         findEnd(currentNode);
	     }
	}
	
	private void findNthNode(DListIterator currentNode, int count) throws Exception {
		if (count == 0) {
			return;
		} else {
			currentNode.next();
			count--;
			findNthNode(currentNode, count);
		}
	}

}
	





	
