package Baekjoon;

import java.util.Scanner;

public class BOJ_10163_색종이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] plane = new int[1001][1001]; // 각 1001칸 평면

		int numOfPaper = sc.nextInt(); // 색종이의 개수

		// 색종이 종류를 paper_num으로 표시
		for (int paper_num = 1; paper_num <= numOfPaper; paper_num++) {
			// 각자의 값을 입력받고
			int x = sc.nextInt();
			int y = sc.nextInt();
			int width = sc.nextInt();
			int height = sc.nextInt();

			// 색종이 종류를 평면에 칠해준다.
			for (int dx = 0; dx < width; dx++) {
				for (int dy = 0; dy < height; dy++) {
					plane[x + dx][y + dy] = paper_num;
				}
			}
		}

		// 보이는 색종이 면적 구하고 출력하기
		int cnt = 0; // 넓이를 구할 count
		for (int paper_num = 1; paper_num <= numOfPaper; paper_num++) {
			for (int x = 0; x < plane.length; x++) {
				for (int y = 0; y < plane[x].length; y++) {
					if (plane[x][y] == paper_num) {
						cnt++;
					}
				}
			}
			System.out.println(cnt);
			cnt = 0;
		}
	}
}
