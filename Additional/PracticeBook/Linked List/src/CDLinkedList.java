//----------exercise starts at line 118-----------------//

import java.util.ArrayList;
import java.util.List;

public class CDLinkedList {
    DListNode header;
    int size;
    static final int HEADERVALUE = -9999999;

    public CDLinkedList() {
        size = 0;
        header = new DListNode(HEADERVALUE);
        makeEmpty();//necessary, otherwise next/previous node will be null
    }

    public boolean isEmpty() {
        return header.nextNode == header;
    }

    public boolean isFull() {
        return false;
    }

    public void makeEmpty() {
        header.nextNode = header;
        header.previousNode = header;
        
        size =0;
    }

    // put in new data after the position of p.
    public void insert(int value, Iterator p) throws Exception {
        if (p == null || !(p instanceof DListIterator))
            throw new Exception();

        DListIterator p2 = (DListIterator) p;

        if (p2.currentNode == null)
            throw new Exception();

        DListIterator p3 = new DListIterator(p2.currentNode.nextNode);
        DListNode n = new DListNode(value, p3.currentNode, p2.currentNode);
        p2.currentNode.nextNode = n;
        p3.currentNode.previousNode = n;
        size++;
    }
    // return position number of value found in the list.
    // otherwise, return -1.
    public int find(int value) throws Exception {
        Iterator itr = new DListIterator(header);
        int index = -1;

        while (itr.hasNext()) {
            int v = itr.next();
            index++;

            DListIterator itr2 = (DListIterator) itr;
            
            if (itr2.currentNode == header)
                return -1;
            if (v == value)
                return index; // return the position of value.
        }
        return -1;
    }
    // return data stored at kth position.
    public int findKth(int kthPosition) throws Exception {
        if (kthPosition < 0)
            throw new Exception();// exit the method if the position is
    // less than the first possible
    // position, throwing exception in the process.
        Iterator itr = new DListIterator(header);
        int index = -1;
    while (itr.hasNext()) {
        int v = itr.next();
        index++;
        DListIterator itr2 = (DListIterator) itr;
        if (itr2.currentNode == header)
            throw new Exception();
        if (index == kthPosition)
        return v;
        }
        throw new Exception();
    }
    // Return iterator at position before the first position that stores value.
    // If the value is not found, return null.
    public Iterator findPrevious(int value) throws Exception {
    if (isEmpty())
        return null;
    Iterator itr1 = new DListIterator(header);
    Iterator itr2 = new DListIterator(header);

    int currentData = itr2.next();
    while (currentData != value) {
        currentData = itr2.next();
        itr1.next();
        if (((DListIterator) itr2).currentNode == header)
            return null;
    }

    if (currentData == value)
        return itr1;
    return null;
    }

    public void removeAt (Iterator p) throws Exception {
        DListIterator p1 = (DListIterator) p ; 

        if (p1.currentNode.equals(header) || isEmpty()) {
            return;
        }

        p1.currentNode.nextNode.previousNode = p1.currentNode.previousNode;
        p1.currentNode.previousNode.nextNode = p1.currentNode.nextNode;
    }

    //------------------exercise starts here------------------//

    public void insertAtFront(int x) {

        DListNode newNode = new DListNode(x);
    
        // If the list is empty (header.nextNode is null)
        if (header.nextNode == null) {
            header.nextNode = newNode;
            newNode.previousNode = header;
        } else {
            // Insert newNode at the front
            newNode.nextNode = header.nextNode;
            header.nextNode.previousNode = newNode;
            newNode.previousNode = header;
            header.nextNode = newNode;
        }
    }

    public void removeAtLast() throws Exception {

        if (header.nextNode == header) {
            throw new Exception();
        }
        
        DListNode lastNode = header.previousNode;

        lastNode.previousNode.nextNode = header;
        header.previousNode = lastNode.previousNode;

    }

    public void reverseList() throws Exception {
        if (header.nextNode == header) {
            throw new Exception();
        }

        DListNode curr = header;
        DListNode temp = null;

        do {
            temp = curr.nextNode;
            curr.nextNode = curr.previousNode;
            curr.previousNode = temp;
            curr = temp;
        } while (curr != header);
        header = header.previousNode;
    }
    
    public boolean isInFront(int x, int y) throws Exception {
        // Check if the list is empty
        if (header.nextNode == header) {
            throw new Exception("List is empty.");
        }
    
        // Initialize iterator and flags
        DListIterator itr = new DListIterator(header);
        boolean foundX = false;
    
        // Iterate through the list
        do {
            if (itr.currentNode.data == x) {
                foundX = true; // Found x
            } else if (itr.currentNode.data == y) {
                if (foundX) {
                    // Found y after x
                    return true;
                }
            }
            itr.next();
        } while (itr.currentNode != header);
    
        // Return false if y was not found after x
        return false;
    }

    public boolean checkContain(CDLinkedList list, int val) throws Exception {
        DListIterator itr = new DListIterator(list.header);
    
        do {
            if (itr.currentNode.data == val) {
                return true;
            }
            itr.next(); // Ensure iteration continues
        } while (itr.currentNode != list.header);
    
        return false;
    }
    

    public CDLinkedList setify(CDLinkedList c) throws Exception {
        CDLinkedList newList = new CDLinkedList();
        DListIterator curItr = new DListIterator(c.header);
    
        // Iterate through the original list
        do {
            int currentData = curItr.currentNode.data;
    
            // Check if the value is already in the new list
            if (!checkContain(newList, currentData)) {
                newList.insert(currentData, new DListIterator(newList.header));
            }
    
            curItr.next(); // Move to the next node
        } while (curItr.currentNode != header);
    
        newList.reverseList(); // Reverse the list to maintain original order
        return newList;
    }

    public void removeBefore(DListIterator p) throws Exception {
        // Check if the iterator is pointing to the header node or if the list is empty
        if (header.nextNode == header || p.currentNode == header || p.currentNode.previousNode == header) {
            throw new Exception("Cannot remove before the header or in an empty list.");
        }
    
        // Node to be removed
        DListNode toBeRemoved = p.currentNode.previousNode;
    
        // Update pointers of surrounding nodes
        toBeRemoved.previousNode.nextNode = toBeRemoved.nextNode;
        toBeRemoved.nextNode.previousNode = toBeRemoved.previousNode;
    }

    public int checkMin() throws Exception {
        if (header.nextNode == header) {
            throw new Exception("List is empty.");
        }
    
        DListIterator itr = new DListIterator(header);
        int min = itr.currentNode.data; // Initialize with the first node's data
    
        do {
            if (itr.currentNode.data < min) {
                min = itr.currentNode.data;
            }
            itr.next(); // Move to the next node
        } while (itr.currentNode != header);
    
        return min;
    }

    public void removeMin() throws Exception {
        if (header.nextNode == header) {
            throw new Exception("List is empty.");
        }

        // Find the minimum value in the list
        int minValue = checkMin();

        // Create an iterator to traverse the list
        DListIterator itr = new DListIterator(header);

        do {
            if (itr.currentNode.data == minValue) {
                // Remove the node with the minimum value
                removeAt(itr);
                return; // Only remove the first occurrence of the minimum value
            }
            itr.next(); // Move to the next node
        } while (itr.currentNode != header);
    }

    public void moveToFront(DListNode n) throws Exception {
        if (n == null || header == null || n == header) {
            throw new Exception();
        }
        
        // Node is already at the front or list is empty
        if (header.nextNode == n) {
            return;
        }
    
        // Disconnect node n from its current position
        n.previousNode.nextNode = n.nextNode;
        n.nextNode.previousNode = n.previousNode;
    
        // Insert node n at the front
        n.nextNode = header.nextNode;
        header.nextNode.previousNode = n;
        n.previousNode = header;
        header.nextNode = n;
    }

    
    
    public void clone(CDLinkedList in) throws Exception {
        // Clear the current list
        makeEmpty();
    
        if (in.header == null || in.header.nextNode == in.header) {
            // If the input list is empty, there's nothing to copy
            return;
        }
    
        DListIterator inItr = new DListIterator(in.header);
    
        // Copy elements from the input list to the current list
        do { 
            insert(inItr.currentNode.data, new DListIterator(header));
            inItr.next(); // Move to the next node in the input list
        } while (inItr.currentNode != in.header);
    
        // Reverse the list after copying
        reverseList();
    }

    public CDLinkedList partition(int value) throws Exception {
        CDLinkedList partitionedList = new CDLinkedList();
        DListIterator itr = new DListIterator(header);
    
        do {
            if (itr.currentNode.data <= value) {
                // Insert nodes with values <= value into the new partitioned list
                partitionedList.insert(itr.currentNode.data, new DListIterator(partitionedList.header));
            }
            itr.next(); // Move to the next node
        } while (itr.currentNode != header);
    
        return partitionedList;
    }

    public void swap(int x, int y) throws Exception {
        if (x == y) {
            // No need to swap if x and y are the same
            return;
        }
    
        DListIterator itr1 = new DListIterator(header);
        DListIterator itr2 = new DListIterator(header);
    
        // Find the nodes with data x and y
        DListNode nodeX = null;
        DListNode nodeY = null;
    
        do {
            if (itr1.currentNode.data == x) {
                nodeX = itr1.currentNode;
            }
            if (itr2.currentNode.data == y) {
                nodeY = itr2.currentNode;
            }
            itr1.next();
            itr2.next();
        } while (itr1.currentNode != header || itr2.currentNode != header);
    
        if (nodeX == null || nodeY == null) {
            throw new Exception("One or both values not found in the list.");
        }
    
        // Swap the data of the nodes
        nodeX.data = y;
        nodeY.data = x;
    }

    public void moveToBack(DListNode n) throws Exception {
        if (n == null || header == null || n == header) {
            throw new Exception("Invalid node or empty list.");
        }
    
        // Node is already at the back or list is empty
        if (header.previousNode == n) {
            return;
        }
    
        // Disconnect node n from its current position
        n.previousNode.nextNode = n.nextNode;
        n.nextNode.previousNode = n.previousNode;
    
        // Insert node n at the back
        n.nextNode = header;
        n.previousNode = header.previousNode;
        header.previousNode.nextNode = n;
        header.previousNode = n;
    }

    public void evenOdds() throws Exception {
        if (header.nextNode == header) {
            // The list is empty
            return;
        }
    
        DListIterator itr = new DListIterator(header);
        DListNode lastEvenNode = null;
        DListNode firstOddNode = null;
    
        // Identify and split the list into even and odd parts
        do {
            if (itr.currentNode.data % 2 == 0) {
                // It's an even node
                if (lastEvenNode != null) {
                    // Move this even node to the end of the even segment
                    moveToBack(itr.currentNode);
                }
                lastEvenNode = itr.currentNode;
            } else {
                // It's an odd node
                if (firstOddNode == null) {
                    firstOddNode = itr.currentNode;
                }
            }
            itr.next();
        } while (itr.currentNode != header);
    
        // Move the odd segment to the back of the list if it's not already in place
        if (firstOddNode != null) {
            DListNode lastEven = header.previousNode;
    
            // Move first odd node to the back of the list
            while (firstOddNode != header) {
                moveToBack(firstOddNode);
                if (firstOddNode == lastEven) {
                    break;
                }
                firstOddNode = firstOddNode.nextNode;
            }
    
            // Reconnect the last even node to the header correctly
            header.previousNode.nextNode = header;
            header.nextNode.previousNode = header.previousNode;
        }
    }

    public CDLinkedList specificElements(CDLinkedList C, int[] p) throws Exception {
        if (p == null) {
            throw new Exception("Index array cannot be null.");
        }
    
        CDLinkedList newList = new CDLinkedList();
        if (C.header.nextNode == C.header) {
            // If the input list is empty, return the empty new list
            return newList;
        }

        DListIterator itr = new DListIterator(header);

        for (Integer integer : p) {
            for (int i = 0; i <= integer; i++) {
                itr.next();
            }
            newList.insertAtFront(itr.currentNode.data);
        }

        return newList;

    }

    public CDLinkedList Union(CDLinkedList a, CDLinkedList b) throws Exception {
        // Convert lists to sets to remove duplicates and sort if needed
        CDLinkedList a1 = setify(a);
        CDLinkedList b1 = setify(b);
    
        CDLinkedList newList = new CDLinkedList();
    
        // Traverse and insert all elements from a1 into newList
        DListIterator itr1 = new DListIterator(a1.header);
        do {
            newList.insertAtFront(itr1.currentNode.data);
            itr1.next();
        } while (itr1.currentNode != a1.header);
    
        // Traverse and insert all elements from b1 into newList
        DListIterator itr2 = new DListIterator(b1.header);
        do {
            newList.insertAtFront(itr2.currentNode.data);
            itr2.next();
        } while (itr2.currentNode != b1.header);
    
        return newList;
    }

    public CDLinkedList intersect(CDLinkedList a, CDLinkedList b) throws Exception {
        // Convert lists to sets to remove duplicates and allow for efficient membership checking
        CDLinkedList a1 = setify(a);
        CDLinkedList b1 = setify(b);

        CDLinkedList newList = new CDLinkedList();

        // Use a DListIterator to traverse list a1 and check membership in b1
        DListIterator itr1 = new DListIterator(a1.header);

        // Create a list or set for quick lookup
        List<Integer> b1Elements = new ArrayList<>();
        DListIterator itr2 = new DListIterator(b1.header);

        do {
            b1Elements.add(itr2.currentNode.data);
        } while (itr2.currentNode != b1.header);

        // Traverse list a1 and insert common elements into newList
        do {
            if (b1Elements.contains(itr1.currentNode.data)) {
                newList.insertAtFront(itr1.currentNode.data);
            }
            itr1.next();
        } while (itr1.currentNode != a1.header);

        return newList;
    }

    public CDLinkedList diff(CDLinkedList a, CDLinkedList b) throws Exception {

        // Convert lists to sets to remove duplicates and allow for efficient membership checking
        CDLinkedList a1 = setify(a);
        CDLinkedList b1 = setify(b);

        CDLinkedList newList = new CDLinkedList();

        // Use a DListIterator to traverse list a1 and check membership in b1
        DListIterator itr1 = new DListIterator(a1.header);

        // Create a list or set for quick lookup
        List<Integer> b1Elements = new ArrayList<>();
        DListIterator itr2 = new DListIterator(b1.header);

        do {
            b1Elements.add(itr2.currentNode.data);
        } while (itr2.currentNode != b1.header);

        // Traverse list a1 and insert uncommon elements into newList
        do {
            if (!b1Elements.contains(itr1.currentNode.data)) {
                newList.insertAtFront(itr1.currentNode.data);
            }
            itr1.next();
        } while (itr1.currentNode != a1.header);

        return newList;
    }

    public void swapAdjacent(DListIterator leftItr, DListIterator rightItr) throws Exception {
        // Validate iterators
        if (leftItr == null || rightItr == null) {
            throw new Exception();
        }
        if (leftItr.currentNode == null || rightItr.currentNode == null) {
            throw new Exception();
        }
        if (leftItr.currentNode.nextNode != rightItr.currentNode) {
            throw new Exception();
        }
    
        DListNode left = leftItr.currentNode;
        DListNode right = rightItr.currentNode;
    
        // Swap the nodes
        // 1. Adjust pointers of nodes around left and right
        left.previousNode.nextNode = right;
        right.nextNode.previousNode = left;
        
        // 2. Adjust pointers of left and right
        left.nextNode = right.nextNode;
        right.previousNode = left.previousNode;
        right.nextNode = left;
        left.previousNode = right;
    }    

    public void swapChunk(DListIterator start, DListIterator end, DListIterator p) throws Exception {
        // Validate iterators
        if (start == null || end == null || p == null) {
            throw new Exception();
        }
        if (start.currentNode == end.currentNode || p.currentNode == start.currentNode || p.currentNode == end.currentNode) {
            throw new Exception();
        }
    
        // Ensure start comes before end
        if (start.currentNode == end.currentNode || start.currentNode == end.currentNode.nextNode) {
            throw new Exception();
        }
    
        // Handle the case where the chunk is moved to a new position
        if (p.currentNode == end.currentNode.nextNode) {
            // Chunk is moved right after itself
            // Re-adjust end and p 
            end.currentNode.nextNode = p.currentNode;
            p.currentNode.previousNode.nextNode = start.currentNode;
            start.currentNode.previousNode = p.currentNode.previousNode;
            p.currentNode.previousNode = end.currentNode;
        } else {
            // General case
            // Connect nodes around the chunk
            start.currentNode.previousNode.nextNode = end.currentNode.nextNode;
            end.currentNode.nextNode.previousNode = start.currentNode.previousNode;
            
            // Connect chunk to new position
            end.currentNode.nextNode = p.currentNode;
            p.currentNode.previousNode.nextNode = start.currentNode;
            start.currentNode.previousNode = p.currentNode.previousNode;
            p.currentNode.previousNode = end.currentNode;
        }
    }
    
} // end of Linked list code.
