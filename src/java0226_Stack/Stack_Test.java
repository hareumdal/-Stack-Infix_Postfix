package java0226_Stack;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Stack_Test {
	private String calEX = "2-3*2/1*(2+3)";
			// "2*3/4-2";
	// 3 12 15 + * 6 2 / -
	private ArrayList<String> newS = new ArrayList<>(); // 변환된 식을 받기
	private Stack mys = new Stack(); // 새로운 스택을 만들어서 연산자를 담자

	Stack_Test() {
		StringTokenizer st = new StringTokenizer(calEX, "+-*/()", true);
		while (st.hasMoreElements()) {
			String nowToken = st.nextToken();
			switch (nowToken) {
			case "*":
			case "/":
			case "+":
			case "-":
				chkOper(nowToken);
				break;
			case "(":
				mys.push(nowToken);
				break;
			case ")":
				popOper();
				break;
			default:
				newS.add(nowToken);
			}
		}
		popOper();
		 System.out.println(newS);
		calProcess();
	}

	private void calProcess() {
		Stack_Cal s = new Stack_Cal(newS); // Stack_Cal을 생성하고 매개변수로 현재 리스트를 전해주자
		double  sum = s.stack_ex(); // 결과 값을 가져와서 출력하자
		System.out.println("최종 결과값: " + sum);
	}

	private void popOper() {
		while (true) {
			String nowStack = mys.pop();
			if (nowStack.equals("(") || nowStack.equals("Stack empty")) {
				break;
			}
			newS.add(nowStack);
		}
	}

	private void chkOper(String nowToken) {
		String stackData = mys.pop(); // 스택에서 연산자 하나를 꺼내와서 
		if (priority(stackData) >= priority(nowToken)) { // 스택의 그 값과 현재 값의 우선 순위 비교 
			newS.add(stackData); // 스택이 더 크면 빼온 값을 리스트에 담기
		} else { // 현재가 더 크면
			mys.push(stackData); // 빼왔던 값을 다시 스택에 넣기
		}
		mys.push(nowToken); // 어째거나 현재 값을 스택에 넣기
	}

	private int priority(String nowToken) {
		switch (nowToken) {
		case "*":
		case "/":
			return 2;
		case "+":
		case "-":
			return 1;
		default:
			return -1;
		}
	}

}
