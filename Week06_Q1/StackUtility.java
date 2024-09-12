
public class StackUtility {
	static String alphabets = "abcdefghijklmnopqrstuvwxyz";
	
	public static String operate(MyStack s1, MyStack s2) throws Exception {

			StackArray s3 = new StackArray();
			
			while (!s1.isEmpty() && s1.size() != 1) {
				int temp1 = s1.top();
				s1.pop();
				int temp2 = s1.top();
				s1.pop();
				
				int operation = s2.top();
				s2.pop();
				
				if (operation < 0) {	
					 s3.push(temp1-temp2);
				} 
				if (operation >= 0) {
					s3.push(temp1+temp2);
				}
		
			}
			

			String word = "";
			
			while (!s3.isEmpty()) {
				int index = s3.top();
				s3.pop();
				char letter = alphabets.charAt(index);
				word += Character.toString(letter);
			}
			
			return word;
	}
}
