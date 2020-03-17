package Test;

public class Stack { // define Stack
	private String[] myStack = new String[10]; // 10개의 데이터가 들어올 스택을 만들쟈아
	// stack 연산 2가지=> push(input) & pop(output)

	
	
	
	
	public String[] getmyStack() {
		return myStack;
	}
	
	private int pointer = -1; // pointer는 빈값으로서 초기에 -1이라는 인덱스로 설정
	

	public void push(String p) {
		// pointer 하나 증가 후 String p를 입력한다.
		pointer++; // 0부터 시작한다
		if (pointer == 10) {// myStack.length
			System.out.println("Stack full"); // 배열의 경우 크기의 하나 -한 만큼 유효하니까
		} else {
			myStack[pointer] = p; // 최상위 인덱스의 자리가 받은 값을 가지게 된다
		}

	}

	
	public String getfrontValue() {
		String getData = null;
		if(pointer == -1) { // 아무 것도 들어 있지 않을 때 // pointer의 기본 값=빈 값은 -1이니까
			return "Stack empty";
		} else { // 값이 들어 있을 때
			getData = myStack[pointer]; 
			
		}
		return getData;
	}
	
	public String pop() { // 매개변수 필요 ㄴㄴ
		String getData = null;
		if(pointer == -1) { // 아무 것도 들어 있지 않을 때 // pointer의 기본 값=빈 값은 -1이니까
			//return "Stack empty";
			return null;
		} else { // 값이 들어 있을 때
			getData = myStack[pointer]; // 최상위의 데이터를 getData에 넣고
			myStack[pointer] = null; // 그 최상위 데이터를 비워준다
			pointer--; // 이후 빈 데이터 아래를 최상위의 인덱스를 가리키도록 --해준다
		}
		return getData; // 이후 뽑아 놓은 getData를 반환해 준다
	}
}
