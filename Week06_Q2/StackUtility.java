
public class StackUtility {

	public static MyStack removeRange(MyStack s, int i, int j) throws Exception {
		//5,10,15,20,25,30,35 (2,4)
		StackArray temp = new StackArray();
		
		int k = 0;
		for (k = 0; k < i; k++) {
			temp.push(s.top());
			s.pop();
			
		}
		
		for (int n = 0; n <= j-k; n++) {
			s.pop();
		}
		
		while (!temp.isEmpty()) {
			s.push(temp.top()); 
			temp.pop();
		}
		
		return (s);
	}
	
}
