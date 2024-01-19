package week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 색종이 개수 입력받기
		int[] paperCount = new int[N + 1]; // 색종이 개수만큼 배열 만들어서 색종이별 면적 담기
		int[][] map = new int[1001][1001]; // 전체 평면의 크기만큼 배열 생성

		for (int k = 0; k < N; k++) { // 색종이 크기만큼 반복하며 좌표, 너비, 높이 순으로 값 입력받기
			StringTokenizer st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			for (int r = y; r < y + h; r++) { // 입력받은 y좌표부터 높이만큼 돌기
				for (int c = x; c < x + w; c++) { // 입력받은 x좌표부터 너비만큼 돌기
					map[r][c] = k + 1;
				}
			}
		}

		// 출력 해보기
		for (int r = 0; r < 1001; r++) {
			for (int c = 0; c < 1001; c++) {
				for (int i = 1; i <= N; i++) {
					if (map[r][c] == i) {
						paperCount[i]++;
					}
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			System.out.println(paperCount[i]);
		}

	}
}
