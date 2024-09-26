package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bingo {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[][] board = new int[5][5];
		int[][] called = new int[5][5];
		int bingo = 0; // 빙고 개수 체크
		int idxR = 0, idxC = 0;

		// 빙고판 초기화
		for (int r = 0; r < 5; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < 5; c++) {
				board[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		// 사회자가 부른 수 저장
		for (int r = 0; r < 5; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < 5; c++) {
				called[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		int count = 0;
		while (bingo < 3) {
			// 빙고 맞추기(0으로 값 바꿔주기)
			for (int r = 0; r < 5; r++) {
				for (int c = 0; c < 5; c++) {
					for (int x = 0; x < 5; x++) {
						int check = 0;
						for (int y = 0; y < 5; y++) {
							// 부른 수를 빙고판에서 0으로 바꿔주기
							if (board[x][y] == called[r][c]) {
								board[x][y] = 0;
								count++;
							}
							if (board[x][y] == 0) {
								check++;
							}
						}
						if (count == 5) {
							bingo++;
							check = 0;
						}
						if (bingo == 3) {
							System.out.println(count);
							break;
						}
					}
				}
			}
		}
	}
}
