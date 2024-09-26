import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 전체 변수를 받을 stack 생성
		Stack<Character> stack;
		// 케이스 별 필요한 변수 생성(문자, 케이스 길이, 유효성)
		int N;
		char a;
		int e;
		String H;
		// 케이스는 10번 돌림
		for(int T=1;T<=10;T++){
			// 케이스 별 생성한 변수 초기화
			stack = new Stack<Character>();
			e = 1;
			N = sc.nextInt();
			H = sc.next();
			// N 값만큼 반복하고, a에 따라서 함수를 나눔
			 ht : for(int i=0;i<N;i++) {
				a = H.charAt(i);
				if(a == '(' || a ==')') {
					func1(stack,a);
					if(func1(stack,a)==false) {
						e = 0;
						break ht;
					}
				} else if(a == '{' || a =='}') {
					func2(stack,a);
					if(func2(stack,a)==false) {
						e = 0;
						break ht;
					}
				} else if(a == '[' || a ==']') {
					func3(stack,a);
					if(func3(stack,a)==false) {
						e = 0;
						break ht;
					}
				} else {
					func4(stack,a);
					if(func4(stack,a)==false) {
						e = 0;
						break ht;
					}
				}
			}
			// 코드 길이 내 유효성 여부가 이상 없으면 1

			// 케이스 별로 정답 출력
			System.out.println("#"+T+" "+e);
		}
	}
	// 열린 괄호별로 닫힌 괄호가 나오지 않으면 add, 닫는 괄호가 나오면 peek
			// peek 시 top의 값이 이전 괄호와 같으면 pop
			// 같지 않을 경우 pop 실행이 되지 않으므로 나중에 유효성 여부에서 오류가 난다
	public static boolean func1(Stack<Character> stack, char a) {
		if(a == '(') {
			stack.add(a);
		} else {
			if(stack.peek()=='(') {
				stack.pop();
			} else {
				return false;
			}
		}
		return true;
	}
	
	public static boolean func2(Stack<Character> stack, char a) {
		if(a == '{') {
			stack.add(a);
		} else {
			if(stack.peek()=='{') {
				stack.pop();
			} else {
				return false;
			}
		}
		return true;
	}
	
	public static boolean func3(Stack<Character> stack, char a) {
		if(a == '[') {
			stack.add(a);
		} else {
			if(stack.peek()=='[') {
				stack.pop();
			} else {
				return false;
			}
		}
		return true;
	}
	
	public static boolean func4(Stack<Character> stack, char a) {
		if(a == '<') {
			stack.add(a);
		} else {
			if(stack.peek()=='<') {
				stack.pop();
			} else {
				return false;
			}
		}
		return true;
	}
}
