package Baekjoon;

import java.util.Scanner;

public class BOJ_2563_색종이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] wide_paper = new int[101][101]; // 100 X 100 도화지
		int cnt = 0; // 넓이를 구할 count (1로 변한 구역을 세줌)

		int numOfBlackPaper = sc.nextInt(); // 검은 색종이 개수

		for (int t = 0; t < numOfBlackPaper; t++) {
			int[][] blackPaper = new int[10][10]; // 검은 색종이의 길이 반영

			int axis_x = sc.nextInt();
			int axis_y = sc.nextInt();

			// 색종이가 도화지 밖으로 나가는 경우는 없으므로 해당 조건은 고려하지 않았다.
			// 색종이의 x, y 좌표에서 각각 +10까지 1로 바꿔주기
			for (int x = 0; x < blackPaper.length; x++) {
				for (int y = 0; y < blackPaper[x].length; y++) {
					wide_paper[axis_x + x][axis_y + y] = 1;
				}
			}
		}

		// 넓이 구하기
		for (int x = 0; x < 101; x++) {
			for (int y = 0; y < 101; y++) {
				if (wide_paper[x][y] == 1) { // 도화지의 좌표에 1이 있다면
					cnt++; // 개수를 늘려준다
				}
			}
		}

		System.out.println(cnt);
	}
}
