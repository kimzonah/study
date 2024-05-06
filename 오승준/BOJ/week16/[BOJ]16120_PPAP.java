import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
	static String ans;
	static Stack<Character> stack = new Stack<>();
	static boolean flag = true;

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// ans로 저장
		// a는 세번째 자리수부터 가능
		// 모든 P는 ppap 문자열이므로 가능
		// stack을 만들어서 a가 들어왔을 때 a의 앞 두 문자가 p인지 확인
		// 그리고 a의 뒷 문자가 p인지 확인
		// 이상없을 경우 p를 stack에 추가하고, 이상이 있다면 NP 출력
		ans = br.readLine();

		cp: for (int i = 0; i < ans.length(); i++) {
			char alp = ans.charAt(i);
			if (alp == 'P')
				stack.push('P');
			else {
				// 이 밑의 if절은 한개로 줄일 수 있는데 ㅠ
				// a인 경우 앞의 두자리의 문자와 뒤의 한자리 문자가 p임을 확인해야 한다
				
				// a가 맨 마지막 문자면 ppap가 불가능
				if (i == ans.length() - 1) {
					flag = false;
					break cp;
				}
				// a 앞에는 최소 p가 두개 있어야 한다
				if (stack.size() < 2) {
					flag = false;
					break cp;
				}
				// 뒤의 문자가 P가 아니면 ppap를 만들지 못하니까
				if (ans.charAt(i + 1) != 'P') {
					flag = false;
					break cp;
				}

				// flag가 true면 조건을 만족하므로 ppap를 p로 변경하여 stack에 쌓는다
				// a가 있을 경우 ppap를 p로 치환하여 stack에 쌓음
				// stack에 있던 앞의 pp를 지우고, 뒤의 p를 하나 지우고
				// a가 있던 위치에 p를 삽입
				stack.pop();
				stack.pop();
				i++;
				stack.push('P');

			}
		}
		// 그리고 추가로 PPAP문자열은 결국 P, 하나의 문자에서 시작한다
		// ppap를 모두 압축하고 난 후에는 P 하나만 남아서 stack의 size가 1이 되야돼
		// 그게 아니라면 애초에 P하나로 시작한게 아니라 PPAP 문자열이 아니다
		if (!flag||stack.size()!=1)
			bw.write("NP");
		else {
			bw.write("PPAP");			
		}
		bw.flush();
		bw.close();
	}
}
