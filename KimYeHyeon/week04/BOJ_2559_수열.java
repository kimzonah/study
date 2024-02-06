package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 맞는 것 같은데 틀렸다고 뜹니다...
public class BOJ_2559_수열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 첫째줄 입력받기
		st = new StringTokenizer(br.readLine());

		// 온도를 측정한 전체 날짜 수
		int N = Integer.parseInt(st.nextToken());

		// 합을 구하기 위한 연속적인 날짜의 수
		int K = Integer.parseInt(st.nextToken());

		// 둘째줄 입력받기
		st = new StringTokenizer(br.readLine());

		// 수열 입력받기
		int[] numArr = new int[N];
		for (int i = 0; i < N; i++)
			numArr[i] = Integer.parseInt(st.nextToken());

		// 계산된 값 중 가장 큰 합의 값
		int maxSum = Integer.MIN_VALUE;
		// 0 ~ K 까지의 합,
		// 1 ~ (K + 1) 까지의 합,
		// ... x ~ (K + x) < N 까지의 합까지 비교
		for (int x = 0; x < N - K; x++) {
			int sum = 0;
			for (int i = x; i < K + x; i++) {
				sum += numArr[i];
			}
			maxSum = Math.max(maxSum, sum);
		}
		System.out.println(maxSum);
	}
}
