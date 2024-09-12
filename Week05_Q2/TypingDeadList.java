
public class TypingDeadList extends CDLinkedList {
	int score = 0;  //not used in this exam
	DListIterator start = null; // the first position of a word to remove
	DListIterator end = null; // last position of a word to remove

	public TypingDeadList() throws Exception {
		this("");
	}

	public TypingDeadList(String s) throws Exception {
		// initialize the list
		// each data comes from each character in s
		int n = s.length();
		DListIterator d = new DListIterator(header);
		for (int i = n - 1; i >= 0; i--) {
			insert(s.charAt(i), d);
		}

	}

	public void removeWord(String w) throws Exception {
		// remove the first occurrence of w
		// if w is not in the list, do nothing
		// reset start and end to null no matter what
		findWord(w);
		if (start == null)
			return;

		int dec = w.length();
		remove(dec);

	}

	public void findWord(String w) throws Exception {
		// update start and end to mark position of the first occurrence of w
		// The word cannot cross header node
		// If w is not in the list, do nothing.
		// w is assumed never to be an empty string.


		//if word = start
		//afdstartafd
		char firstLetter = w.charAt(0);
		int length = w.length();
		int lengthCovered = 1;
		
		DListIterator p1 = new DListIterator(header);
		
;		while (p1.currentNode.data != (firstLetter)) {
			if (p1.currentNode.nextNode == header) {
				break;
			}
			p1.next();
		}
		DListIterator p2 = new DListIterator(p1.currentNode);
		
		for (int i = 1; i < length-1 ; i++) {
			if (p2.next() == w.charAt(i)) {
				p2.next();
				lengthCovered++;
			} else {
				break;
			}
		}
		

		if (p1.currentNode.data == w.charAt(0) && p2.currentNode.data == w.charAt(length -1)) {
			start = p1;
			end = p2;
		} 
		
		
	}

	public void remove(int dec) throws Exception { // this must be the last method in your code!
		// remove data from start to end, inclusive,
		// if start or end is at header, do nothing.
		// size to remove is one of the known parameter -> reduce the size parameter of
		// the list

		if (start == null || start.currentNode == header|| end.currentNode == header || end == null) {
			return;
		}
		
		start.currentNode.previousNode.nextNode = end.currentNode.nextNode;
		end.currentNode.nextNode.previousNode = start.currentNode.previousNode;
		size -= dec;
	}

}
