import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
	static String bomb;
	static String ans;
	static Stack<Character> stack = new Stack<>();

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

		// subString을 사용하면 메모리 초과; stack이 강제되는 듯
		// stack에 기존 문자열을 하나씩 넣는다
		// bomb의 마지막 문자가 stack에 들어가면
		// stack에서 마지막 글자부터 bomb의 문자열의 길이까지 확인해서 bomb 문자열인지 확인
		// bomb 문자열과 같으면 문자열 길이만큼 pop을 해주면 된다
		ans = br.readLine();
		bomb = br.readLine();
		char alp = bomb.charAt(bomb.length() - 1);

		cp: for (int i = 0; i < ans.length(); i++) {
			stack.push(ans.charAt(i));
			// bomb의 길이보다 현재 stack에서의 길이가 길어야 bomb 문자열이 포함되겠죠??
			if (stack.size() >= bomb.length()) {
				if (ans.charAt(i) == alp) {
					// bomb문자열의 길이를 저장해서 stack의 뒷부분과 bomb의 뒷부분을 비교
					int size = bomb.length() - 1;
					for (int j = stack.size() - 1; j > stack.size() - bomb.length() - 1; j--) {
						//bomb문자열과 일치하지 않으면 지나가주면 된다
						if (stack.get(j) != bomb.charAt(size--))
							continue cp;
					}
					
					// bomb 길이만큼 비교가 됐는데 현재의 if문에서 벗어나지 않았다면 pop으로 bomb문자열을 빼준다
					for (int j = 0; j < bomb.length(); j++) {
						stack.pop();
					}
				}
			}
		}
		
		// stack에 모든 값이 빼주면 FRULA 출력
		if (stack.size() == 0)
			bw.write("FRULA");
		else {
			// 그게 아니라면 stack의 문자를 하나씩 빼준다
			// 몰랐는데 stack도 굳이 pop할 필요 없이 get으로 내부를 확인할 수 있다
			for (int i = 0; i < stack.size(); i++) {
				bw.write(stack.get(i));
			}
		}
		bw.flush();
		bw.close();
	}
}
