package java0226_Stack;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Stack_Test {
	private String calEX = "2-3*2/1*(2+3)";
			// "2*3/4-2";
	// 3 12 15 + * 6 2 / -
	private ArrayList<String> newS = new ArrayList<>(); // ��ȯ�� ���� �ޱ�
	private Stack mys = new Stack(); // ���ο� ������ ���� �����ڸ� ����

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
		Stack_Cal s = new Stack_Cal(newS); // Stack_Cal�� �����ϰ� �Ű������� ���� ����Ʈ�� ��������
		double  sum = s.stack_ex(); // ��� ���� �����ͼ� �������
		System.out.println("���� �����: " + sum);
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
		String stackData = mys.pop(); // ���ÿ��� ������ �ϳ��� �����ͼ� 
		if (priority(stackData) >= priority(nowToken)) { // ������ �� ���� ���� ���� �켱 ���� �� 
			newS.add(stackData); // ������ �� ũ�� ���� ���� ����Ʈ�� ���
		} else { // ���簡 �� ũ��
			mys.push(stackData); // ���Դ� ���� �ٽ� ���ÿ� �ֱ�
		}
		mys.push(nowToken); // ��°�ų� ���� ���� ���ÿ� �ֱ�
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
