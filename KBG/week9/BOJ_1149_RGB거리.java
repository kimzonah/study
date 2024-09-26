import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149_RGB거리 {
	static int[][] rgb;
	static int N, min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		rgb = new int[1001][3]; // 3개의 색, N개의 숫자들
		int[][] dp = new int[1001][3]; //최소합 저장용
		int sum = Integer.MAX_VALUE;
		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			rgb[i][0] = Integer.parseInt(st.nextToken());
			rgb[i][1] = Integer.parseInt(st.nextToken());
			rgb[i][2] = Integer.parseInt(st.nextToken()); //배열에 값 저장..
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j < 3; j++) {
				min = Integer.MAX_VALUE; //최소값 미리 설정..
				for(int k = 0; k < 3; k++) {
					if(j == k) {
						continue;
					}
					else {
						min = Math.min(min, dp[i - 1][k]);
					}
				}
				dp[i][j] = min + rgb[i][j];
			}
		}
		
		for(int i = 0; i < 3; i++) {
			sum = Math.min(sum, dp[N][i]);
		}
		System.out.println(sum);
		
		
	}

}
