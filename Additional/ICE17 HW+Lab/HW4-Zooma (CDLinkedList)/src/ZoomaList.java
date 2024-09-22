import org.hamcrest.core.IsInstanceOf;

public class ZoomaList extends CDLinkedList {
	int score = 0;

	public ZoomaList() {
		super();
	}

	public ZoomaList(CDLinkedList l) {
		header = l.header;
		size = l.size;
	}

	
	
	public void checkRepeat(DListIterator prev, DListIterator next, DListIterator cur) throws Exception {
	    int repeatedTimes = 1;  // Initialize to 1 because the current node matches `val`
	    
        // Count repetitions on the next side
        while (next.currentNode != header && cur.currentNode.data == next.currentNode.data) {
            repeatedTimes++;
            next.next();
        }

        // Count repetitions on the previous side
        while (prev.currentNode != header && cur.currentNode.data == prev.currentNode.data) {
            repeatedTimes++;
            prev.previous();
        }

	    // If we found 3 or more repeated values, remove them and recheck
	    if (repeatedTimes >= 3) {
	        removeBetween(prev, next, repeatedTimes); // Remove all repeated elements // Get the new value at the collision point
	        score += repeatedTimes; 
	        repeatedTimes = 0;// Increment the score

	        
	        DListNode forPrint = header.nextNode;
	        System.out.println("List: ");
	        while (forPrint != header) {
	        	System.out.println(forPrint.data + " ");
	        	forPrint = forPrint.nextNode;
	        }
	        System.out.println();
	        //list 4,4,4,3,3,5,5,3 -> 4,4,4,3,3,(5),5,5,3 -> 4,4,4
	        // Recursively check from the updated position
	    }
	    if (prev.currentNode.data == next.currentNode.data && size > 2 && next.currentNode != header && prev.currentNode != header) {
	    	checkRepeat(new DListIterator(prev.currentNode.previousNode), next, prev);
	    }
	}

	public void insert(int value, Iterator p) throws Exception {
	    if (!(p instanceof DListIterator)) {
	        return;
	    }

	    DListIterator itr = (DListIterator)p;
	    DListNode newNode = new DListNode(value);

	    // Insert the new node after the current node
	    newNode.nextNode = itr.currentNode.nextNode;
	    itr.currentNode.nextNode.previousNode = newNode;
	    itr.currentNode.nextNode = newNode;
	    newNode.previousNode = itr.currentNode;
	    size++;

	    // Now check for collisions after insertion
	    DListIterator prev = new DListIterator(newNode.previousNode);
	    DListIterator next = new DListIterator(newNode.nextNode);
	    DListIterator curr = new DListIterator(newNode);
	    checkRepeat(prev, next, curr);  // Check if the insertion caused any repeated values
	}

	
	public void removeBetween(DListIterator left, DListIterator right, int inc) {
		// list 1,2,3,4,5,6,7 -> 1,2,6,7
		//        ^       ^ 
        //        d1      d2
		
		if (size == 1 || size == 2) {
			return;
		}
		
		right.currentNode.previousNode = left.currentNode;
		left.currentNode.nextNode = right.currentNode;
		size -= inc;
			
	}
}
