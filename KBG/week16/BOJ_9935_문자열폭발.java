import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9935_문자열폭발 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine(); // 문자열
		String bombStr = br.readLine(); // 폭발 문자열

		int bombSize = bombStr.length(); // 길이를 저장하고

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) { //문자열 길이만큼 반복하고//...
			stack.push(str.charAt(i));
			
			//문자열과 길이가 같아지는 순간이 시작점
			if(stack.size() >= bombSize) {
				boolean check = true;
				
				for(int j = 0 ; j < bombSize; j++) {
					//스택의 현 위치와 폭발 문자열의 현 위치를 비교해서 같지 않으면? 폭발안시켜도 됨
					if(stack.get(stack.size()-bombSize + j) != bombStr.charAt(j)) {
						check = false;
						break;
					}
				}
				//다하고 체크가 트루(문자열과 일치)이면
				if(check) {
					//폭발 문자열 길이만큼 뺴준다.
					for(int j = 0; j < bombSize; j++) {
						stack.pop();
					}
				}
			}
		}
		
		//다 반복한 후...
		
		StringBuilder sb = new StringBuilder();
		//남은 단어들을 모조리 sb에 넣어준다.
		for(Character ch : stack) {
			sb.append(ch);
		}
		
		if(sb.length() == 0) {//길이가 0이라면!
			System.out.println("FRULA");
		}
		else {//남아있다면!
			System.out.println(sb.toString());
		}

	}

}
