package Q1_RemoveAt;

class DListNode {
    DListNode(int data) {
    this(data, null, null);
    }
    DListNode(int theElement, DListNode n, DListNode p) {
    data = theElement;
    nextNode = n;
    previousNode = p;
    }
    // Friendly data; accessible by other package routines
    int data;
    DListNode nextNode, previousNode;
    }