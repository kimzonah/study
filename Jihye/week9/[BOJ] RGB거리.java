package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB거리 {
	
	// 1. dp 2차원 배열 만들고
	// 2. 2번째 행부터 윗 행 중 열이 겹치지 않는 값 비교
	// 3. 더 큰 값 넣어줌
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		// house와 dp 배열 만들기
		int[][] house = new int[N][3];
		int[][] dp = new int[N][3];
		
		// 값 넣기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < house[0].length; j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 1행 처리
		for (int i = 0; i < 3; i++) {
			dp[0][i] = house[0][i];
		}
		
		// 2행부터 윗행 다른 열 값과 비교해 더 큰 값을 더해주기
		for (int r = 1; r < dp.length; r++) {
			for (int c = 0; c < dp[0].length; c++) {
				int val1 = dp[r - 1][(c + 1) % 3];
				int val2 = dp[r - 1][(c + 2) % 3];
				dp[r][c] += (val1 < val2) ? val1 + house[r][c] : val2 + house[r][c]; 
			}
		}
		
		// 마지막 행의 값들 중 가장 큰 값 찾기
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			min = dp[N - 1][i] < min ? dp[N - 1][i] : min;
		}
		
		System.out.println(min);
	}
}
