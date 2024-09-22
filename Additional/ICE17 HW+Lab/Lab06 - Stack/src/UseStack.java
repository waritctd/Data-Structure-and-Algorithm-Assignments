
public class UseStack {
	
	//implement this method.
	public static Stack sort(Stack s) throws Exception {
		ArrayListStack tempStack = new ArrayListStack();
		
		while (!s.isEmpty()) {
			int current = s.top();
			s.pop();
			
			while (!tempStack.isEmpty() && tempStack.top() > current) {
				s.push(tempStack.top());
				tempStack.pop();
			}
			
			tempStack.push(current);
		}
		
		while (!tempStack.isEmpty()) {
			s.push(tempStack.top());
			tempStack.pop();
		}
		
		return s;
}

}

