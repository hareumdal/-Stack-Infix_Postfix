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
		StringTokenizer st = new StringTokenizer(calEX, "+-*/()", true); // true ������ ���ص� ���
		String token = "";

		while (st.hasMoreTokens()) {
			for (int i = 0; i < s.getmyStack().length; i++) { // ��ū�� ��� �̾Ƴ���, ó�� ���� ���� �����ڸ� ����Ʈ�� �־��ֱ�
				if (s.getmyStack()[i] != null) {
					System.out.println(i + "��° : " + s.getmyStack()[i]);
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
//----------���� while���� ��
//		for (int i = s.getpointer(); i > -1; i--) { // ��ū�� ��� �̾Ƴ���, ó�� ���� ���� �����ڸ� ����Ʈ�� �־��ֱ�
//			if (s.getmyStack()[i] != null) {
//				postArr.add(s.pop());
//			}
//		}

		System.out.println(postArr);
	}

	public void chkFirst(String token) { // token�� *�̰ų� /�� �� // �켱������ ���� ū ��� // ������ ���ÿ� �ִ´�

		stackData = s.getfrontValue(); // ������ ���� ���� ����
		switch (stackData) {// ���� ���� �켱 ������ ũ�ٸ� // �� (token)�� ����Ʈ�� ���� �ְ� �ش� ���ð��� �־� �����!!
		case "*":
		case "/":
			postArr.add(s.pop());
			s.push(token); // ���� ���ÿ� �־�����
			// postArr.add(token);
			break;
		default: // �׿� �����
			s.push(token);
			break;
		}
	}

	public void chkSecond(String token) { // token�� +�̰ų� -�� �� // �켱������ �� ��°�� ���
		stackData = s.getfrontValue(); // ������ ���� ���� ����
		switch (stackData) {// ���� ���� �켱 ������ ũ�ٸ� // �� (token)�� ����Ʈ�� ���� �ְ� �ش� ���ð��� �־� �����!!
		case "*":
		case "/":
			postArr.add(s.pop());
			// postArr.add(token);
			s.push(token); // ���� ���ÿ� �־�����
			break;
		default: // �׿� �����
			s.push(token);
			break;
		}
	}

	public void chkYeolgi(String token) { // ���� ���� ���� �켱 ������� // (
		s.push(token);
	}

	public void chkDadgi(String token) { // ) ���

		while ((stackData = s.pop()) != null) {
			if (!stackData.equals("(")) {
				postArr.add(stackData);
			}
		}
	}
}
// ���3
//////	public void chkFront(String token) {
//////		stackData = s.getfrontValue();
//////		if (stackData == null) { // ��� �ִٸ� �ϴ� �ְ� �����!!
//////			s.push(token);
//////		} else { // ���� �̹� �� �ִٸ� �켱������ ���� ����!!
//////			switch (token) { // ���� ���� �Ʒ� ���̽� �϶�
//////			case "*":
//////			case "/":
//////				s.push(token); // ���ÿ� ����
//////				break;
//////			case "+":
//////			case "-":
//////				if (stackData.equals("*") && stackData.equals("/")) { // ���� ����
//////					// ������ ���� ���� �켱 �������
//////					postArr.add(token); // �� ���� ������ �ְ�
//////					postArr.add(s.pop()); // ������ ���� ���� ����Ʈ�� ����
//////				} else {
//////					s.push(token); // ���ÿ� ����
//////				}
//////				break;
//////			case "(":
//////				s.push(token);
//////				break;
//////			case ")":
//////				while (s.getpointer() != -1) {
//////					String popword = s.pop();
//////					if (!popword.equals("(")) {
//////						postArr.add(popword); // ���ÿ��� ������ ����Ʈ�� ����
//////					}
//////				}
//////			}
//////		}
//////		
//////	}
