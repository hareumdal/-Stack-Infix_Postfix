package Test;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Stack_Test {

	// "2*3/4-2";
	// "1*(2-3*4)/5-(6+7*8)-2";
	// "1*(2-3*4)/5-6";
	// "(4+2)/3*(12+15)-6/2";
	// "3*(12+15)-6/2";

	private String calEX = "3*(12+15)-6/2";

	private ArrayList<String> postArr = new ArrayList<>();
	private Stack s = new Stack();
	private String stackData;
	Stack_Test() {
		StringTokenizer st = new StringTokenizer(calEX, "+-*/()", true); // true 나누는 기준도 담기
		String token = "";

		while (st.hasMoreTokens()) {
			for (int i = 0; i < s.getmyStack().length; i++) { // 토큰을 모두 뽑아내고서, 처리 되지 않은 연산자를 리스트에 넣어주기
				if (s.getmyStack()[i] != null) {
					System.out.println(i + "번째 : " + s.getmyStack()[i]);
				}
			}
			System.out.println();
			token = st.nextToken();
			switch (token) {
			case "*":
			case "/":
				chkFirst(token);
				// chkFront(token);
				break;
			case "+":
			case "-":
				chkSecond(token);
				// chkFront(token);
				break;
			case "(":
				chkYeolgi(token);
				// chkFront(token);
				break;
			case ")":
				chkDadgi(token);
				// chkFront(token);
				break;
			default:
				postArr.add(token);
			}
		}

		while ((stackData = s.pop()) != null) {
			postArr.add(stackData);
		}
//----------위의 while문과 상동
//		for (int i = s.getpointer(); i > -1; i--) { // 토큰을 모두 뽑아내고서, 처리 되지 않은 연산자를 리스트에 넣어주기
//			if (s.getmyStack()[i] != null) {
//				postArr.add(s.pop());
//			}
//		}

		System.out.println(postArr);
	}

	public void chkFirst(String token) { // token이 *이거나 /일 때 // 우선순위가 가장 큰 경우 // 무조건 스택에 넣는다

		stackData = s.getfrontValue(); // 스택의 값을 비교해 보자
		switch (stackData) {// 스택 값이 우선 순위가 크다면 // 나 (token)을 리스트에 먼저 넣고 해당 스택값을 넣어 주쟈아!!
		case "*":
		case "/":
			postArr.add(s.pop());
			s.push(token); // 나를 스택에 넣어주자
			// postArr.add(token);
			break;
		default: // 그외 경우라면
			s.push(token);
			break;
		}
	}

	public void chkSecond(String token) { // token이 +이거나 -일 때 // 우선순위가 두 번째인 경우
		stackData = s.getfrontValue(); // 스택의 값을 비교해 보자
		switch (stackData) {// 스택 값이 우선 순위가 크다면 // 나 (token)을 리스트에 먼저 넣고 해당 스택값을 넣어 주쟈아!!
		case "*":
		case "/":
			postArr.add(s.pop());
			// postArr.add(token);
			s.push(token); // 나를 스택에 넣어주자
			break;
		default: // 그외 경우라면
			s.push(token);
			break;
		}
	}

	public void chkYeolgi(String token) { // 내가 가장 작은 우선 순위라면 // (
		s.push(token);
	}

	public void chkDadgi(String token) { // ) 경우

		while ((stackData = s.pop()) != null) {
			if (!stackData.equals("(")) {
				postArr.add(stackData);
			}
		}
	}
}
// 방법3
//////	public void chkFront(String token) {
//////		stackData = s.getfrontValue();
//////		if (stackData == null) { // 비어 있다면 일단 넣고 보쟈아!!
//////			s.push(token);
//////		} else { // 값이 이미 들어가 있다면 우선순위를 비교해 보쟈!!
//////			switch (token) { // 현재 내가 아래 케이스 일때
//////			case "*":
//////			case "/":
//////				s.push(token); // 스택에 넣자
//////				break;
//////			case "+":
//////			case "-":
//////				if (stackData.equals("*") && stackData.equals("/")) { // 이전 값이
//////					// 스택의 값이 높은 우선 순위라면
//////					postArr.add(token); // 내 값도 리스에 넣고
//////					postArr.add(s.pop()); // 스택의 값도 꺼내 리스트에 넣자
//////				} else {
//////					s.push(token); // 스택에 넣자
//////				}
//////				break;
//////			case "(":
//////				s.push(token);
//////				break;
//////			case ")":
//////				while (s.getpointer() != -1) {
//////					String popword = s.pop();
//////					if (!popword.equals("(")) {
//////						postArr.add(popword); // 스택에서 꺼내서 리스트에 넣자
//////					}
//////				}
//////			}
//////		}
//////		
//////	}
