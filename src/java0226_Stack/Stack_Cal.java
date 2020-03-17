package java0226_Stack;

import java.util.ArrayList;

public class Stack_Cal {
	// 계산

	private Stack calStack = new Stack();
	private ArrayList<String> calString = null; // stack_test에서 이미 나온 결과값을 계산 할 거니까

	Stack_Cal(ArrayList<String> a) {
		this.calString = a;

	}

	public double stack_ex() {
		double stackCalResult = 0;
		// 실제 계산

		// Tr
//		double  sInt = 0;
//		double  fInt = 0;
//		for (String nowT : calString) {
//			switch (nowT) {
//			case "*":
//				sInt = Double.valueOf(calStack.pop());
//				fInt = Double.valueOf(calStack.pop());
//				stackCalResult = fInt * sInt;
//				calStack.push(String.valueOf(stackCalResult));
//				break;
//			case "/":
//				sInt = Double.valueOf(calStack.pop());
//				fInt = Double.valueOf(calStack.pop());
//				stackCalResult = fInt / sInt;
//				calStack.push(String.valueOf(stackCalResult));
//				break;
//			case "+":
//				sInt = Double.valueOf(calStack.pop());
//				fInt = Double.valueOf(calStack.pop());
//				stackCalResult = fInt + sInt;
//				calStack.push(String.valueOf(stackCalResult));
//				break;
//			case "-":
//				sInt = Double.valueOf(calStack.pop());
//				fInt = Double.valueOf(calStack.pop());
//				stackCalResult = fInt - sInt;
//				calStack.push(String.valueOf(stackCalResult));
//				break;
//			default:
//				calStack.push(nowT);
//			}
//		}
// 여기까지 Tr
		for (int i = 0; i < calString.size(); i++) {
			String calS = calString.get(i);
			String caltor = "";
			switch (calS) {
			case "*":
			case "/":
			case "+":
			case "-":
				caltor = calS;
				stackCalResult = cal(caltor);

				calStack.push(String.valueOf(stackCalResult));
//				for (int j = 0; j < calStack.getStack().length; j++) {
//					if (calStack.getStack()[j]!= null) {
//					System.out.println(calStack.getStack()[j]);
//				}
//					System.out.println();
//				}
				break;
			default: // 피연산자인 경우
				// 새로운 스택에 넣자
				calStack.push(calS);
				break;
			}
		}
		return stackCalResult;
	}

	private double cal(String caltor) {
		// 두 개를 뽑아서
		double popNow = Double.valueOf(calStack.pop());
		double popFront = Double.valueOf(calStack.pop());

		double sum = 0;

		switch (caltor) {
		case "*":
			sum = popFront * popNow;
			return sum;
		case "/":
			sum = popFront / popNow;
			return sum;
		case "+":
			sum = popFront + popNow;
			return sum;
		case "-":
			sum = popFront - popNow;
			return sum;
		}
		return sum;
	}

}
