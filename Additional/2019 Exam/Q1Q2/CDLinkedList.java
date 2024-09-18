package Q1_RemoveAt;

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

    public DListNode sortDigits(DListNode node) throws Exception {
        DListNode middle = getMiddle(node);
        DListNode nextOfMiddle = middle.nextNode;

        middle.nextNode = null;

        DListNode left = sortDigits(node);
        DListNode right = sortDigits(nextOfMiddle);

        return merge(left, right);
    }

    public DListNode merge(DListNode left, DListNode right) {
        if (left.data <= right.data) {
            left.nextNode = merge(left.nextNode, right);
            left.nextNode.previousNode = left;
            left.previousNode = null;
            return left;
        } else {
            right.nextNode = merge(left, right.nextNode);
            right.nextNode.previousNode = right;
            right.previousNode = null;
            return right;
        }
    }

    public DListNode getMiddle(DListNode node) {
        if (node == null) {
            return node;
        }

        DListNode slow = node;
        DListNode fast = fast;

        while (fast != null && fast != node && fast.nextNode != null && fast.nextNode != node) {
            slow = slow.nextNode;
            fast = fast.nextNode.nextNode;
        }

        return slow;
    }
} // end of Linked list code.
