package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9935_문자열_폭발 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 주어지는 문자열
		String sentence = br.readLine();

		// 폭발 트리거 문자열을 char 배열로 만들기
		String boomSt = br.readLine();

		int len = boomSt.length();
		char[] boom = new char[len];
		for (int i = 0; i < len; i++) {
			boom[i] = boomSt.charAt(i);
		}

		Stack<Integer> stack = new Stack<>();

		int k = 0;
		for (int i = 0; i < sentence.length(); i++) {
			// 비교하려는 문자가 boom과 같다면
			if (boom[k] == sentence.charAt(i))
				// boom의 다음 글자를 확인한다.
				k++;
			// 같지 않다면
			else {
				// 해당 글자와 boom의 첫번째 글자가 같은지 보고
				if (boom[0] == sentence.charAt(i)) {
					// 같다면 전까지 센 k의 값을 stack에 저장
					stack.push(k);
					k = 1;
				} else {					
					// 같지 않다면 스택에 쌓였던 것들을 전부 클리어해주고
					stack.clear();
					// boom의 처음부터 세준다.
					k = 0;
				}
			}

			// 글자 하나를 스트링빌더에 쌓아준다.
			sb.append(sentence.charAt(i));
//			System.out.println(sb);

			// k가 len에 도달했다면
			if (k == len) {
				sb.setLength(sb.length() - len);

				// 스택에 쌓인게 없다면 boom의 처음부터 세준다.
				if (stack.isEmpty())
					k = 0;
				// 쌓인게 있다면 k를 스택에 쌓인 수로 만들어준다.
				else
					k = stack.pop();
			}
		}

		if (sb.length() == 0)
			System.out.println("FRULA");
		else
			System.out.println(sb);
	}
}
