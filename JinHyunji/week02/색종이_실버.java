package week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이_실버 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 색종이 수 입력
		int[][] map = new int[101][101]; // 전체 평면의 크기만큼 배열 생성
		int sum = 0; // 색종이 면적 합 담을 변수
		
		for (int i = 0; i < N; i++) { // 색종이 개수 만큼 반복
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()); // x축 시작점 입력
			int y = Integer.parseInt(st.nextToken()); // y축 시작점 입력

			for (int r = y; r < y + 10; r++) { // y축 높이만큼 반복 (길이 : 10)
				for (int c = x; c < x + 10; c++) { // x축 너비만큼 반복 (길이 : 10)
					map[r][c] = 1; // 해당하는 곳에 1 넣어주기
				}
			}
		}
		
		for (int[] i : map) { // map 배열 전체 돌면서
			for (int j : i) {
				sum += j; // 1이 들어있는 곳 더해주기
			}
		}

		System.out.println(sum); // 전체 면적 합 출력
	}

}
