package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class CutPaper {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		// 전체 가로길이, 세로길이
		int garo = Integer.parseInt(input[0]);
		int sero = Integer.parseInt(input[1]);

		// 테스트 케이스 입력 받기
		int N = Integer.parseInt(br.readLine());
		
		// 잘린 길이 중 가장 긴 길이
		int xMaxLength = 0;
		int yMaxLength = 0;

		// 자를 위치 배열
		ArrayList<Integer> xCut = new ArrayList<>();
		ArrayList<Integer> yCut = new ArrayList<>();

		xCut.add(0);
		xCut.add(garo);
		yCut.add(0);
		yCut.add(sero);

		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);

			if (a == 0) { // 가로면, 세로 cut에 넣기 (가로로 자르면 잘리는 기준은 세로니까 ??)
				yCut.add(b);
			} else {
				xCut.add(b);
			}
		}

		Collections.sort(xCut); // 정렬
		Collections.sort(yCut);
		
		for (int i = 0; i < xCut.size() - 1; i++) { // 인덱스 이용해 차를 구해서 더 큰 숫자 대입
			int k = xCut.get(i + 1) - xCut.get(i);
			xMaxLength = k > xMaxLength ? k : xMaxLength;
		}
		for (int i = 0; i < yCut.size() - 1; i++) {
			int k = yCut.get(i + 1) - yCut.get(i);
			yMaxLength = k > yMaxLength ? k : yMaxLength;
		}
		System.out.println(xMaxLength * yMaxLength);
	}
}
