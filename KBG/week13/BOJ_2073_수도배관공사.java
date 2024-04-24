import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2073_수도배관공사 {
	static int D, P, L, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		D = Integer.parseInt(st.nextToken()); // 길이
		P = Integer.parseInt(st.nextToken()); // 파이프 수
		int[] dp = new int[D + 1];

		dp[0] = Integer.MAX_VALUE;

		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			// 각각에 들어갈 L과 C를 입력한다.

			for (int j = D; j >= L; j--) {
				//이렇게 하면, 해당 칸이 들어갈 수 있는 용량에 대해서 dp가 채워지게 됨
				//예제 기준, 처음엔 dp[4]가 찰거고
				//그 다음엔 dp[3]과 [7]이 찬다.
				//다음엔, dp[2], dp[5], dp[6]이 찬다...
				dp[j] = Math.max(dp[j], Math.min(C, dp[j-L]));
			}
		}
		
		System.out.println(dp[D]); //마지막 항 뽑으면 최댓값이 나와있을 것

	}

}