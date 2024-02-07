package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 직사각형 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		// 직사각형 처리할 배열 sq1,2 선언
		int[] sq1 = new int[4]; // [0] : x1, [1] : y1, [2] : p1, [3] : q1 
		int[] sq2 = new int[4]; // [0] : x2, [1] : y2, [2] : p2, [3] : q2 
		
		// 4번 반복
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) { // 직사각형 1 입력 받기
				sq1[j] = Integer.parseInt(st.nextToken());
			}
			for (int j = 0; j < 4; j++) { // 직사각형 2 입력 받기
				sq2[j] = Integer.parseInt(st.nextToken());
			}
			sb.append(output(sq1, sq2) + "\n");
		}
		System.out.println(sb);
	}
	
	public static char output(int[] a1, int[] a2) {
		// 1. 공통부분이 직사각형인 경우
		if (a1[2] < a2[0] && a1[3] < a2[1] && a1[2] > a2[0] && a1[2] < a2[2]) {
			return 'a';
		} else if (a1[2] > a2[0] && a1[3] > a2[1] && a2[2] > a1[0] && a2[2] < a1[2]) {
			return 'a';
		}
		// 2. 변으로 만나는 경우
		if (a1[2] == a2[0] || a2[2] == a1[0]) {
			for (int k = a1[1]; k < a1[3]; k++) {
				if (k > a2[1] || k < a2[3]) return 'b';
			}
		} else if (a1[1] == a2[3] || a2[1] == a1[3]) {
			for (int k = a1[0]; k < a1[2]; k++) {
				if (k > a2[0] || k < a2[2]) return 'b';
			}
		}
		// 3. 한 점에서 만나는 경우
		if (a1[2] == a2[0] && a1[3] == a2[1] || a2[2] == a1[0] && a2[3] == a1[1] 
				|| (a1[0] + a1[2] == a2[0]) && (a2[1] + a2[3] == a1[1]) || (a2[0] + a2[2] == a1[0]) && (a1[1] + a1[3] == a2[1])) {
			return 'c';
		}
		// 4. 공통부분이 없는 경우
		return 'd';
	}
}
