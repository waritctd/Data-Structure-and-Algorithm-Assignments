
public class StudentList extends CDLinkedList {
	// you can write additional methods.

	// implement this method
	public void swapNode(DListIterator i1, DListIterator i2) throws Exception {
		
		DListNode prev1 = i1.currentNode.previousNode;
		DListNode next1 = i1.currentNode.nextNode;
		DListNode prev2 = i2.currentNode.previousNode;
		DListNode next2 = i2.currentNode.nextNode;
		
		//detach 1
		i1.currentNode.previousNode.nextNode = i1.currentNode.nextNode;
		i1.currentNode.nextNode.previousNode = i1.currentNode.previousNode;
		
		//detaach2
		i2.currentNode.previousNode.nextNode = i2.currentNode.nextNode;
		i2.currentNode.nextNode.previousNode = i2.currentNode.previousNode;
		
		//swap
		prev2.nextNode = i1.currentNode;
		i1.currentNode.previousNode = prev2;
		next2.previousNode = i1.currentNode;
		i1.currentNode.nextNode = next2;
		
		prev1.nextNode = i2.currentNode;
		i2.currentNode.previousNode = prev1;
		next1.previousNode = i2.currentNode;
		i2.currentNode.nextNode = next1;
		
	}

	// implement this method
	public void insertList(DListIterator i1, CDLinkedList lst) throws Exception {
		if (lst.header.nextNode == lst.header) {
			return;
		}
        
        
		i1.currentNode.nextNode.previousNode = lst.header.previousNode;
		lst.header.previousNode.nextNode = i1.currentNode.nextNode;
		i1.currentNode.nextNode = lst.header.nextNode;
		lst.header.nextNode.previousNode = i1.currentNode;
		
		
	}

	// implement this method
	public void gender(String g) throws Exception {
	    DListIterator itr = new DListIterator(header.nextNode);
	    CDLinkedList tempList = new CDLinkedList();
	    DListIterator tempItr = new DListIterator(tempList.header);

	    // Iterate through the original list
	    while (itr.currentNode != header) {
	        Student student = (Student) itr.currentNode.data;

	        // Check if the gender matches
	        if (student.getSex().equals(g)) {
	            // Store the data of the current node in a temporary variable
	            Student toMove = student.createCopy();

	            // Remove the node from the original list
	            itr.currentNode.previousNode.nextNode = itr.currentNode.nextNode;
	            itr.currentNode.nextNode.previousNode = itr.currentNode.previousNode;

	            // Insert the copied student into the temp list
	            tempList.insert(toMove, tempItr);
	            tempItr.next();  // Move temp iterator forward after insertion
	        }

	        // Move the original iterator forward
	        itr.next();
	    }

	    // Now insert tempList into the original list
	    insertList(new DListIterator(header), tempList);
	    
        DListNode forPrint = header.nextNode;
        String stringList = "List: ";
        while (forPrint != header) {
        	stringList += forPrint.data + ",";
        	forPrint = forPrint.nextNode;
        }
        System.out.println(stringList);
	}



}
