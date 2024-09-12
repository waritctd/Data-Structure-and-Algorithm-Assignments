import java.util.NoSuchElementException;

public class Deck extends DeQLinkedList {
	
	
	public void putBottom(int n) {
		try {
			insertLast(n);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int draw() {
		try {
			return (removeFirst());
		} catch (Exception NoSuchElementException) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	public int removeNth(int n) {
	    if (n < 0 || isEmpty()) {
	        return -1;
	    }
	    
	    DeQLinkedList temp = new DeQLinkedList();
	    int num = -1; 

	    try {
		    if (n == 0 || isEmpty()) {
		        return removeFirst(); 
		    }
		    
	        int count = 0;

	        while (count < n && !isEmpty()) {
	            temp.insertFirst(removeFirst());
	            count++;
	        }

	        if (!isEmpty()) {
	            num = removeFirst(); 
	        }

	        while (!temp.isEmpty()) {
	            insertFirst(temp.removeFirst());
	        }
	    } catch (Exception e) {
	        return -1; 
	    }
	    
	    return num;
	}
	
	public void reverseTopN(int n) {
	    if (n <= 0) {
	        return; 
	    }

	    DeQLinkedList temp = new DeQLinkedList();

	    try {
		    if (n > size()) {
		        n = size();
		    }

		    for (int i = 0; i < n; i++) {
		        temp.insertFirst(removeFirst());
		    }
	
		    while (!temp.isEmpty()) {
		        insertFirst(temp.removeLast());
		    }
	    } catch (Exception e) {
	    	return;
	    }
	}

}
