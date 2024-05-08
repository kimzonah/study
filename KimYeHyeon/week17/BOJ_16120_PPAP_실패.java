package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16120_PPAP_실패 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();

		// 만난 P의 개수를 세준다.
		int pcnt = 0;
		// 전에 A를 만났는지 확인
		boolean beforeA = false;
		
		for (int i = 0; i < str.length(); i++) {
			// 문자열에서 P를 만났다면
			if (str.charAt(i) == 'P') {
				// P 개수 증가
				pcnt++;
				beforeA = false;
			} else {
				// A를 만나면 전에 A를 만났는지 확인한다.
				if (beforeA) {
					// 전에 A를 만났다면 PPAP 문자열이 될 수 없다.
					sb.append("NP");
					break;
				} else {
					// 전에 A를 만나지 않았다면 pcnt를 2 낮춰준다.
					pcnt -= 2;
					beforeA = true;
				}
			}
			
			// 만약 pcnt가 0미만이면 PPAP 문자열이 될 수 없다.
			if (pcnt < 0) {
				sb.append("NP");
				break;
			}
		}
		
		// sb가 비어있고 A로 끝나지 않았다면 PPAP 문자열이다.
		if (sb.length() == 0)
			if (!beforeA) sb.append("PPAP");
			else sb.append("NP");
		
		System.out.println(sb);
	}
}
