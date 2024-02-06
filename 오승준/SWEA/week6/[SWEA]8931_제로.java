import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// stack으로 받을 거니까 collection 생성
		Stack<Integer> stack;
		
		// 변수 생성
		int K;
		int sum;
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=T;i++) {
			sum = 0;
			stack = new Stack<Integer>();
			K = Integer.parseInt(br.readLine());
			for(int j=0;j<K;j++) {
				int a = Integer.parseInt(br.readLine());
				// 새로 받은 값이 0이 아니면 add, 0이면 추가하지 않고 pop 실행
				if(a != 0) {
					stack.add(a);
				} else {
					stack.pop();
				}
			}
			// 반복문 수행 후 stack에서 남아있는 값들의 합 구하고
			for(int j=0;j<stack.size();j++) {
				sum += stack.get(j);
			}
			// 출력
			bw.write("#"+i+" "+sum+"\n");
			bw.flush();
		}
		bw.close();
	}
}
