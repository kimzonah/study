package baekjoon;

import java.util.Scanner;

public class BOJ_10157_자리배정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 입력부분
		int C = sc.nextInt(); // x좌표 최대값
		int R = sc.nextInt(); // y좌표 최대값
		int K = sc.nextInt(); // 관객의 대기번호

		// 대기번호가 좌석보다 클 경우 0을 출력하고 종료한다.
		if (C * R < K) {
			System.out.println(0);
			return;
		}

		int[][] seat = new int[C + 1][R + 1]; // 좌석 공간 생성
		int n = 0; // 내부 돌 때의 가중치
		int seatC = 0; // 대기번호의 x좌표
		int seatR = 0; // 대기번호의 y좌표
		int KCnt = 1;
		
		// 안되는 경우를 제외 했으므로 좌석이 안에 있을 경우
		out: while (true) {
			for (int i = 1 + n; i < R - n; i++) { // 왼쪽편 위로 갈 때
				if (K == KCnt) {
					seatC = 1 + n;
					seatR = i;
					break out;
				}
//				System.out.printf("(%d, %d), %d\n", 1 + n, i, KCnt);
				KCnt++;
			}

			for (int i = 1 + n; i < C - n; i++) { // 위쪽편 오른쪽으로 갈 때
				if (K == KCnt) {
					seatC = i;
					seatR = R - n;
					break out;
				}
//				System.out.printf("(%d, %d), %d\n", i, R - n, KCnt);
				KCnt++;
			}

			for (int i = R - n; i > 1 + n; i--) { // 오른쪽편 아래로 갈 때
				if (K == KCnt) {
					seatC = C - n;
					seatR = i;
					break out;
				}
//				System.out.printf("(%d, %d), %d\n", C - n, i, KCnt);
				KCnt++;
			}

			for (int i = C - n; i > 1 + n; i--) { // 아래쪽편 왼쪽으로 갈 때
				if (K == KCnt) {
					seatC = i;
					seatR = 1 + n;
					break out;
				}
//				System.out.printf("(%d, %d), %d\n", i, 1 + n, KCnt);
				KCnt++;
			}
			n++;
		}

		System.out.printf("%d %d\n", seatC, seatR);
	}
}
