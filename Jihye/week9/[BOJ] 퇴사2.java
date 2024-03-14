package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 퇴사2 {
	static int[] t, p, dp;
	static int N;
	
	// 이건 살짝 참고했어요
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());

		t = new int[N+1];
		p = new int[N+1];
		dp = new int[N+1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}

		int max = -1;
		for(int i=0; i<= N; i++) {
			if(max < dp[i]) {
				max = dp[i];
			}
			
			int nxt = i + t[i];
			if(nxt < N + 1) {
				dp[nxt] = Math.max(dp[nxt], max+p[i]);
			}
		}
		System.out.println(dp[N]);
		
		
	}
}
