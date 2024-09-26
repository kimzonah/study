package baekjoon;

import java.util.Scanner;

public class BOJ_2491_수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 수열의 길이
		int N = sc.nextInt();
		
		// 숫자들 입력받기
		int[] num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();			
		}
		
		// 해당 인덱스와 다음 인덱스를 비교하여
		// 같거나 큰 경우와 같거나 작은 경우가 있을 것이다.
		int bigger = 1;
		int smaller = 1;
		int max = 1;
		
		for (int i = 1; i < N; i++) {
			if (num[i - 1] < num[i]) {
				// 전보다 크면 bigger 올려주고
				bigger++;
				// smaller와 max를 비교하고 smaller 초기화
				max = Math.max(max, smaller);
				smaller = 1;
			} else if (num[i - 1] > num[i]) {
				// 전보다 작으면 smaller 올려준다
				smaller++;
				// bigger와 max를 비교하고 bigger 초기화
				max = Math.max(max, bigger);
				bigger = 1;
			} else {
				// 둘이 같을 경우는 둘 다 올려준다.
				bigger++;
				smaller++;
			}
//			System.out.printf("큰가?: %d, 작은가?: %d, max: %d\n", bigger, smaller, max);
		}
		// 마지막까지 bigger와 smaller가 올랐을때는 비교하지 못했으므로 한번 더 비교해준다.
		max = Math.max(max, smaller);
		max = Math.max(max, bigger);
		
		System.out.println(max);
	}
}
