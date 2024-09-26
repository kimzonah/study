import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1699_제곱수의합 {
	static int count;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[N + 1];
		dp[0] = 0;
		for(int i = 1; i <= N; i++) {
			dp[i] = i; //최대 제곱수의 합은 모조리 1로 더한 경우의 수
		}
		
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= (int)Math.sqrt(i); j++) {
				dp[i] = Math.min(dp[i], dp[i-(j*j)] + 1);
				//dp[i] 에 값을 재할당
				//기존의 1제곱의 합을 더한 개수 vs 이전 수의 제곱을 뺀 갯수 + 1((j*j)는 카운팅이 안되어있으므로)
			}
		}
		
		System.out.println(dp[N]);
	
	}

}
