package java0226_Stack;

public class Stack {
	private String[] myStack = new String[10];
	private int pointer = -1;
	// stack 연사 2가지 , push pop

	
	public String[] getStack() {
		return myStack;
	}
	
	
	
	public void push(String p) {
		// pointer 하나 증가 한 후 String p를 입력한다.
		pointer++;
		if (pointer == 10) {
			System.out.println("Stack full");
		} else {
			myStack[pointer] = p;
		}
	}

	public String pop() {
		String getData = null;
		if (pointer == -1) {
			getData = "Stack empty";
		} else {
			getData = myStack[pointer];
			myStack[pointer] = null;
			pointer--;
		}
		return getData;
	}
}
