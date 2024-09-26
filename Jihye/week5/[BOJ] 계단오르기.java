package backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class 계단오르기2 {
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int N = Integer.parseInt(br.readLine());
 
		// DP 풀이
		int[] DP = new int[N + 1];
		int[] arr = new int[N + 1];
 
		// 인덱스 N까지 입력 받기
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
 
		// 첫번째 수 처리
		DP[1] = arr[1];
		
		// N이 1일 경우 대비해 조건문 달아주기
		if (N >= 2) {
			DP[2] = arr[1] + arr[2];
		}
 
		for (int i = 3; i <= N; i++) {
			DP[i] = Math.max(DP[i - 2] , DP[i - 3] + arr[i - 1]) + arr[i];
		}
 
		System.out.println(DP[N]);
 
	}
 
}